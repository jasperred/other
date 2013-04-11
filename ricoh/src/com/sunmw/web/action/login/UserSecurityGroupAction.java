package com.sunmw.web.action.login;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.sunmw.web.bean.login.SecurityPermissionServices;
import com.sunmw.web.common.message.MessageInfo;
import com.sunmw.web.entity.UserLogin;
import com.sunmw.web.util.VerifyRequest;
import com.sunmw.web.util.WebUtil;

public class UserSecurityGroupAction {
	
	private SecurityPermissionServices securityPermissionServices;
	private int userId;
	private String groupIds;
	private List<Map> userSecurityGroupList;
	private List securityGroupList;
	private String crumb;
	
	public SecurityPermissionServices getSecurityPermissionServices() {
		return securityPermissionServices;
	}

	public void setSecurityPermissionServices(
			SecurityPermissionServices securityPermissionServices) {
		this.securityPermissionServices = securityPermissionServices;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getGroupIds() {
		return groupIds;
	}

	public void setGroupIds(String groupIds) {
		this.groupIds = groupIds;
	}

	public List getUserSecurityGroupList() {
		return userSecurityGroupList;
	}

	public void setUserSecurityGroupList(List userSecurityGroupList) {
		this.userSecurityGroupList = userSecurityGroupList;
	}

	public List getSecurityGroupList() {
		return securityGroupList;
	}

	public void setSecurityGroupList(List securityGroupList) {
		this.securityGroupList = securityGroupList;
	}

	public String getCrumb() {
		return crumb;
	}

	public void setCrumb(String crumb) {
		this.crumb = crumb;
	}

	public String userSecurityGroupList()
	{
		try {
			Map session = ActionContext.getContext().getSession();
			UserLogin ul = (UserLogin) session.get("LOGIN_INFO");
			this.userSecurityGroupList = this.securityPermissionServices.userLoginSecurityGroupList(userId);
			groupIds = "";
			if(this.userSecurityGroupList!=null)
			{
				for(Map m:this.userSecurityGroupList)
				{
					if(groupIds.length()>0)
						groupIds += ",";
					groupIds += WebUtil.replaceSpecialCharacters((String)m.get("groupId"));
				}
			}
			this.securityGroupList = this.securityPermissionServices.securityGroupList(ul);
		} catch (Exception e) {
			this.userSecurityGroupList = null;
			this.securityGroupList = null;
		}
		return "success";
	}
	
	public String saveUserSecurityGroup()
	{
		try {
			Map session = ActionContext.getContext().getSession();
			UserLogin ul = (UserLogin) session.get("LOGIN_INFO");
			String userNo = ul.getUserNo();		
			if(crumb==null||!VerifyRequest.verifyCrumb(userNo, crumb))
			{
				return "success";
			}
			//groupIds = WebUtil.filterSpecialCharacters(groupIds);
			this.securityPermissionServices.saveUserSecurityGroup(userId, groupIds);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "success";
	}

}
