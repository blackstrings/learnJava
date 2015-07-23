package com.xai.email;

import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolException;
import org.apache.http.impl.client.DefaultRedirectStrategy;
import org.apache.http.protocol.HttpContext;
import org.apache.log4j.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: jprochas
 * Date: 10/31/13
 * Time: 4:40 PM
 * Background redirects to a 404 page will result in the end result being us
 * attempting to load the 404 page's content, with a status 200, so we don't
 * know that we really didn't find anything valid. This will detect the redirect
 * content and handle it properly.
 */
public class CustomRedirectStrategy extends DefaultRedirectStrategy {

	private final Logger logger = Logger.getLogger("ASPECT");

	@Override
	public boolean isRedirected(
			HttpRequest request,
			HttpResponse response,
			HttpContext httpContext) {
		if(response.getFirstHeader("location") != null
				&& response.getFirstHeader("location").getValue() != null
				&& response.getFirstHeader("location").getValue().endsWith("error404.html")) {
			response.setEntity(null);
			return false;
		} else {
			try {
				return super.isRedirected(request, response, httpContext);
			} catch (ProtocolException e) {
				logger.warn("Failed to see if redirected", e);
			}
		}
		return false;
	}

}
