package com.sunmw.web.action.login;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.sunmw.web.bean.area.AreaServices;
import com.sunmw.web.bean.login.SecurityPermissionServices;
import com.sunmw.web.common.message.MessageInfo;
import com.sunmw.web.entity.UserLogin;
import com.sunmw.web.util.VerifyRequest;
import com.sunmw.web.util.WebUtil;

public class SecurityGroupInfoAction {
	private SecurityPermissionServices securityPermissionServices;
	private AreaServices areaServices;
	
	private String groupId;
	private String groupName;
	private String level;
	private List permissionList;
	private List areaList;
	private List<Map> securityGroupPermissionList;
	private List<Map> securityGroupAreaList;
	private String permissionIds;
	private String areaIds;
	private String message;
	private String crumb;
	
	public SecurityPermissionServices getSecurityPermissionServices() {
		return securityPermissionServices;
	}

	public void setSecurityPermissionServices(
			SecurityPermissionServices securityPermissionServices) {
		this.securityPermissionServices = securityPermissionServices;
	}

	public AreaServices getAreaServices() {
		return areaServices;
	}

	public void setAreaServices(AreaServices areaServices) {
		this.areaServices = areaServices;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public List getPermissionList() {
		return permissionList;
	}

	public void setPermissionList(List permissionList) {
		this.permissionList = permissionList;
	}

	public List getAreaList() {
		return areaList;
	}

	public void setAreaList(List areaList) {
		this.areaList = areaList;
	}

	public List<Map> getSecurityGroupPermissionList() {
		return securityGroupPermissionList;
	}

	public void setSecurityGroupPermissionList(List<Map> securityGroupPermissionList) {
		this.securityGroupPermissionList = securityGroupPermissionList;
	}

	public List<Map> getSecurityGroupAreaList() {
		return securityGroupAreaList;
	}

	public void setSecurityGroupAreaList(List<Map> securityGroupAreaList) {
		this.securityGroupAreaList = securityGroupAreaList;
	}

	public String getPermissionIds() {
		return permissionIds;
	}

	public void setPermissionIds(String permissionIds) {
		this.permissionIds = permissionIds;
	}

	public String getAreaIds() {
		return areaIds;
	}

	public void setAreaIds(String areaIds) {
		this.areaIds = areaIds;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCrumb() {
		return crumb;
	}

	public void setCrumb(String crumb) {
		this.crumb = crumb;
	}

	public String securityGroupPermissionList()
	{
		try {
			groupId = WebUtil.filterSpecialCharacters(groupId);
			this.permissionList = this.securityPermissionServices.securityPermissionList();
			this.securityGroupPermissionList = this.securityPermissionServices.securityGroupPermissionList(groupId);
			this.permissionIds = "";
			if(this.securityGroupPermissionList!=null)
			{
				for(Map m:this.securityGroupPermissionList)
				{
					if(this.permissionIds.length()>0)
						this.permissionIds += ",";
					this.permissionIds += m.get("permissionId");
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "success";
	}
	
	public String securityGroupAreaList()
	{
		try {
			groupId = WebUtil.filterSpecialCharacters(groupId);
			this.areaList = this.areaServices.areaList();
			this.securityGroupAreaList = this.securityPermissionServices.securityGroupAreaList(groupId);
			this.areaIds = "";
			if(this.securityGroupAreaList!=null)
			{
				for(Map m:this.securityGroupAreaList)
				{
					if(this.areaIds.length()>0)
						this.areaIds += ",";
					this.areaIds += m.get("areaCd");
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "success";
	}
	
	public String saveSecurityGroup()
	{
		try {
			Map session = ActionContext.getContext().getSession();
			UserLogin ul = (UserLogin)session.get("LOGIN_INFO");
			if(ul==null)
				return "success";
			String userNo = ul.getUserNo();		
			if(crumb==null||!VerifyRequest.verifyCrumb(userNo, crumb))
			{
				message = MessageInfo.Verify;
				return "success";
			}
			if(WebUtil.isNull(level))
				level = "4";
			groupId = WebUtil.filterSpecialCharacters(groupId);
			groupName = WebUtil.filterSpecialCharacters(groupName);
			String m = this.securityPermissionServices.saveSecurityGroup(groupId, groupName,new Integer(level));
			message = m;
		} catch (NumberFormatException e) {
			message = MessageInfo.OperationType;
		}
		return "success";
	}
	
	public String saveSecurityGroupPermission()
	{
		try {
			Map session = ActionContext.getContext().getSession();
			UserLogin ul = (UserLogin)session.get("LOGIN_INFO");
			if(ul==null)
				return "success";
			String userNo = ul.getUserNo();		
			if(crumb==null||!VerifyRequest.verifyCrumb(userNo, crumb))
			{
				message = MessageInfo.Verify;
				return "success";
			}
			groupId = WebUtil.filterSpecialCharacters(groupId);
			permissionIds = WebUtil.filterSpecialCharacters(permissionIds);
			String m = this.securityPermissionServices.saveSecurityGroupPermission(groupId, permissionIds);
			message = m;
		} catch (Exception e) {
			message = MessageInfo.OperationType;
		}
		return "success";
	}
	
	public String saveSecurityGroupArea()
	{
		try {
			Map session = ActionContext.getContext().getSession();
			UserLogin ul = (UserLogin)session.get("LOGIN_INFO");
			if(ul==null)
				return "success";
			String userNo = ul.getUserNo();		
			if(crumb==null||!VerifyRequest.verifyCrumb(userNo, crumb))
			{
				message = MessageInfo.Verify;
				return "success";
			}
			groupId = WebUtil.filterSpecialCharacters(groupId);
			areaIds = WebUtil.filterSpecialCharacters(areaIds);
			String m = this.securityPermissionServices.saveSecurityGroupArea(groupId, areaIds);
			message = m;
		} catch (Exception e) {
			message = MessageInfo.OperationType;
		}
		return "success";
	}
	
	public String viewSecurityGroupInfo()
	{
		if(WebUtil.isNull(groupId))
			groupId = null;
		if(WebUtil.isNull(groupName))
			groupName = null;
		return "success";
	}

}
