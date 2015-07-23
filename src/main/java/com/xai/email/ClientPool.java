package com.xai.email;

import org.apache.http.client.HttpClient;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Semaphore;

public class ClientPool {
	private static final Logger logger = Logger.getLogger("ASPECT");
	private static Map<HttpClient, Semaphore> sslClients = new HashMap<HttpClient, Semaphore>();
	private static Map<HttpClient, Semaphore> nonSslClients = new HashMap<HttpClient, Semaphore>();
	private static final ClientConnectionManager httpConnectionManager;
	private static final ClientConnectionManager httpsConnectionManager;
	private static final CustomRedirectStrategy customRedirectStrategy = new CustomRedirectStrategy();
	private static final int maxConcurrentRequests = 15;
	//Limit us to a finite number of concurrent requests
	static {
		SchemeRegistry schemeRegistry = new SchemeRegistry();
		schemeRegistry.register(new Scheme("http", 80, PlainSocketFactory.getSocketFactory()));
		httpConnectionManager = new ThreadSafeClientConnManager(schemeRegistry);
		KeyStore keyStore = null;
		try {
			keyStore = KeyStore.getInstance("jks");
		} catch (KeyStoreException e2) {
			logger.warn("Failed to get keystore instance", e2);
		}
		try {
			keyStore.load(new FileInputStream(System.getProperty("java.home").concat("/lib/security/cacerts").replace('/', File.separatorChar)), "changeit".toCharArray());
		} catch (Exception e) {
			logger.warn("Failed to load keystore", e);
		}
		
		schemeRegistry = new SchemeRegistry();
		try {
			schemeRegistry.register(new Scheme("https", 443,  new SSLSocketFactory(keyStore)));
		} catch (Exception e) {
			logger.warn("Failed to set up HTTPS scheme", e);
		}
		httpsConnectionManager = new ThreadSafeClientConnManager(schemeRegistry);
	}
	private static HttpClient setUpHttpsClient() {
		DefaultHttpClient httpClient = new DefaultHttpClient(httpsConnectionManager);
    	httpClient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, 5000);
		httpClient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 10000);
		httpClient.setRedirectStrategy(customRedirectStrategy);
		return httpClient;
	}
	private static HttpClient setUpHttpClient() {
		DefaultHttpClient httpClient = new DefaultHttpClient(httpConnectionManager);
    	httpClient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, 5000);
		httpClient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 10000);
		httpClient.setRedirectStrategy(customRedirectStrategy);
		return httpClient;
	}
	
	/**
	 * Provides an httpClient available immediately for a httpRequest. If the url starts with
	 * https:// the client will have the trust store in current JRE loaded and have a SSLSocketFactory
	 * set up, otherwise, it will just return a default HttpClient with no extra set up. 
	 * 
	 * After a request, the httpClient must be released with a call to {@link #releaseConnection}
	 * 
	 * @param url
	 * @return
	 */
	protected synchronized static HttpClient getHttpClient(String url) {
		if(url != null && url.startsWith("https://")) {
			HttpClient returnVal = getClientFromMap(sslClients);
			if(returnVal == null) {
				sslClients.put(setUpHttpsClient(), new Semaphore(1));
			} else {
				return returnVal;
			}
			return getClientFromMap(sslClients);
		} else {
			HttpClient returnVal = getClientFromMap(nonSslClients);
			if(returnVal == null) {
				nonSslClients.put(setUpHttpClient(), new Semaphore(1));
			} else { 
				return returnVal;
			}
			return getClientFromMap(nonSslClients);
		}
	}
	private static HttpClient getClientFromMap(Map<HttpClient, Semaphore> clients) {
		for(Entry<HttpClient, Semaphore> clientEntry : clients.entrySet()) {
			if(clientEntry.getValue().tryAcquire()) {
				return clientEntry.getKey();
			}
		}
		return null;
	}
	
	protected static void releaseConnection(HttpClient toRelease) {
		if(toRelease.getConnectionManager().equals(httpConnectionManager)) {
			nonSslClients.get(toRelease).release();
		} else if(toRelease.getConnectionManager().equals(httpsConnectionManager)){
			sslClients.get(toRelease).release();
		}
	}
}
