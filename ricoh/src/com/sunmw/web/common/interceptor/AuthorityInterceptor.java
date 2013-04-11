package com.sunmw.web.common.interceptor;

import java.util.Map;

import javax.servlet.http.Cookie;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import com.sunmw.web.bean.login.LoginServices;
import com.sunmw.web.entity.UserLogin;

public class AuthorityInterceptor extends MethodFilterInterceptor {

	@Override
	protected String doIntercept(ActionInvocation arg0) throws Exception {
		//cookieAutoLogin();
		Map session = ActionContext.getContext().getSession();
		//用户信息为空或者需要修改密码则返回登录页面
		if (session.get("LOGIN_INFO") == null||(session.get("MODIFY_PWD")!=null&&session.get("MODIFY_PWD").equals("Y")))
			return "login";
		else
			return arg0.invoke();
	}

	// 使用COOKIE自动登录
//	private void cookieAutoLogin() {
//		Cookie[] cookies = ServletActionContext.getRequest().getCookies();
//		if(cookies==null)
//			return;
//		String userName = null;
//		String password = null;
//		int pjId = -1;
//		for (Cookie c : cookies) {
//			if (c.getName().equals("COOKIE_LOGIN_USERNAME"))
//				userName = c.getValue();
//			if (c.getName().equals("COOKIE_LOGIN_PASSWORD"))
//				password = c.getValue();
//		}
//		// cookie不存在
//		if (userName == null || password == null)
//			return;
//		// 自动登录
//		ApplicationContext ctx = WebApplicationContextUtils
//				.getWebApplicationContext(ServletActionContext
//						.getServletContext());
//		LoginServices loginServices = (LoginServices) ctx
//				.getBean("loginServices");
//		Map m = loginServices.loginByUserName(userName, password);
//		String r = (String) m.get("LOGIN");
//		if ("ERROR".equals(r)) {
//			return;
//		}
//		UserLogin ul = (UserLogin) m.get("LOGIN_INFO");
//		Map session = ActionContext.getContext().getSession();
//
//		session.put("LOGIN_INFO", m.get("LOGIN_INFO"));
//	}

}
