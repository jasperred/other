package com.sunmw.web.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpsFilter implements Filter {
	private boolean https = false;
	private String httpsPort ="443";

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest servletrequest = (HttpServletRequest) request;
		HttpServletResponse servletresponse = (HttpServletResponse) response;
		//自动跳转到https
		if(https)
		{
			String sss = servletrequest.getScheme();
			if(sss!=null&&sss.equals("http"))
			{
				if(httpsPort==null)
					httpsPort = "443";
				String basePath = "https://"+servletrequest.getServerName()+":"+httpsPort+servletrequest.getContextPath()+"/";
				servletresponse.sendRedirect(basePath);
			}
		}
		arg2.doFilter(request, response);
	}

	public void init(FilterConfig config) throws ServletException {

		if (config.getInitParameter("https").length() >= 1)
		{
			this.https = true;
			this.httpsPort = config.getInitParameter("https");
		}
	}

}
