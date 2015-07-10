package com.xai.web;

/**
 * By default, Android doesn't have special code for sending and receiving HTTP
 * You'll have to implemment your own using Apache HTTP client
 *
 * May be good to put the request in a separate thread so it doesn't hold up the UI
 */
public class SendDataToURLDemo {

	public static void main(String [] args){
		
		//TODO need to install apache
		/*
		int TIMEOUT_MILLISEC = 10000;  // = 10 seconds
		HttpParams httpParams = new BasicHttpParams();
		HttpConnectionParams.setConnectionTimeout(httpParams, TIMEOUT_MILLISEC);
		HttpConnectionParams.setSoTimeout(httpParams, TIMEOUT_MILLISEC);
		HttpClient client = new DefaultHttpClient(httpParams);

		HttpPost request = new HttpPost(serverUrl);
		request.setEntity(new ByteArrayEntity(
		    postMessage.toString().getBytes("UTF8")));
		HttpResponse response = client.execute(request);
		*/
		
	}
	
}
