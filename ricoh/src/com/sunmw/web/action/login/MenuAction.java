package com.sunmw.web.action.login;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.sunmw.web.bean.login.SecurityPermissionServices;
import com.sunmw.web.entity.UserLogin;
/**
 * 登录用户的菜单列表
 * @author sun
 *
 */
public class MenuAction {
	private SecurityPermissionServices securityPermissionServices;

	private List userMenuList;

	public SecurityPermissionServices getSecurityPermissionServices() {
		return securityPermissionServices;
	}

	public void setSecurityPermissionServices(
			SecurityPermissionServices securityPermissionServices) {
		this.securityPermissionServices = securityPermissionServices;
	}

	public List getUserMenuList() {
		return userMenuList;
	}

	public void setUserMenuList(List userMenuList) {
		this.userMenuList = userMenuList;
	}

	public void userMenu() {
		try {
			Map session = ActionContext.getContext().getSession();
			UserLogin ul = (UserLogin) session.get("LOGIN_INFO");
			userMenuList = securityPermissionServices.getLoginMenu(ul.getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
