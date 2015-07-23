package com.xai.email;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

public class MyEmail {
	
	private Logger logger = Logger.getLogger(MyEmail.class);
	private static final String textEncoding = "UTF8";
	private static final String USER_AGENT = "IDS-Design-It Application";

	public void send(String url, Map<String, String> parameters){
		//this url has to handle email, prefer jboss or tomcat server
		//for php servers, you'll have to send as a string with get or post parameters
		
		String result = doPost(url, parameters);
		logger.info(result);
		System.out.println(result);
	}
	
	private String doPost(String url, Map<String, String> parameters){
		
		HttpPost httpPost = new HttpPost(url);
		
		//get the data ready
		List<NameValuePair> nameValuePairs = null;
		if(parameters != null){
			nameValuePairs = new ArrayList<NameValuePair>();
			for(Entry<String, String> parameter : parameters.entrySet()) {
				nameValuePairs.add(new BasicNameValuePair(parameter.getKey(), parameter.getValue()));
			}
		}
		
		//encode the data into the http
		try{
			httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
		}catch(UnsupportedEncodingException e){
			logger.warn("Failed to form content for POST");
		}
		
		//prepare the client
		HttpClient client = ClientPool.getHttpClient(url);
		HttpResponse response = null;
		
		try {
			httpPost.addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
			httpPost.addHeader("Accept-Language", "en-US,en;q=0.8");
			httpPost.addHeader("User-Agent", USER_AGENT);
			
			//execute the http request (send) get the response
			response = client.execute(httpPost);
			
			// Examine the response status
			//InputStream str = response.getEntity().getContent();
			//logger.info(response.getStatusLine() + str.toString());
			
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			logger.error("Failed to post to url: " + url, e);
		}
		
		//get the response
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), textEncoding));
		} catch (Exception e) {
			logger.error("Failed to read response from HTTP POST", e);
		}
		StringBuilder result = new StringBuilder();
		String line = null;
		try {
			while((line = reader.readLine()) != null) {
				result.append(line);
			}
		} catch (IOException e) {
			logger.error("Failed to deal with response from HTTP POST to url: " + url, e);
		}
		try {
			EntityUtils.consume(response.getEntity());
		} catch (IOException e) {
			logger.error("Failed to consume response: " + url, e);
		}
		
		ClientPool.releaseConnection(client);
		return result != null ? result.toString() : null;
		//get the returned data
		//HttpEntity entity = httpPost.getEntity();
		
		
	}
	
}
