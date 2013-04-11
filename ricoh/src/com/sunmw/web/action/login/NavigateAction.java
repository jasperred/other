package com.sunmw.web.action.login;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.sunmw.web.bean.login.UserServices;
import com.sunmw.web.entity.UserLogin;

public class NavigateAction {

	private UserServices userServices;
	
	private List navigateList;
	
	public UserServices getUserServices() {
		return userServices;
	}

	public void setUserServices(UserServices userServices) {
		this.userServices = userServices;
	}

	public List getNavigateList() {
		return navigateList;
	}

	public void setNavigateList(List navigateList) {
		this.navigateList = navigateList;
	}

	public void navigateList()
	{
		try {
			Map session = ActionContext.getContext().getSession();
			UserLogin ul = (UserLogin) session.get("LOGIN_INFO");
			Map param = new HashMap();
			param.put("UserLogin", ul);
			this.navigateList = userServices.navigateListByUser(param);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
