package com.ivanmix.resume.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

public class ResumeFilter extends AbstractFilter {

	protected final Logger LOGGER = LoggerFactory.getLogger(getClass());

	@Value("${application.production}")
	private boolean production;
	
	@Override
	public void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain) throws IOException, ServletException {
		LOGGER.debug("doFilter");
		String requestUrl = req.getRequestURI();
		req.setAttribute("REQUEST_URL", requestUrl);
		try {
			chain.doFilter(req, resp);
		} catch (Throwable th) {
			LOGGER.error("Process request failed: " + requestUrl, th);
			handleException(th, requestUrl, resp);
		}
	}
	
	private void handleException(Throwable th, String requestUrl, HttpServletResponse resp) throws ServletException, IOException {
		if(production) {
			if ("/error".equals(requestUrl)) {
				throw new ServletException(th);
			} else {
				resp.sendRedirect("/error?url="+requestUrl);
			}
		} else {
			throw new ServletException(th);
		}
	}
}
