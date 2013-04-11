package com.sunmw.web.action.base;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.sunmw.web.bean.area.AreaServices;
import com.sunmw.web.bean.base.BaseServices;
import com.sunmw.web.bean.login.SecurityPermissionServices;
import com.sunmw.web.entity.Company;
import com.sunmw.web.entity.UserLogin;

public class BaseAction {
	
	private AreaServices areaServices;
	private BaseServices baseServices;
	private SecurityPermissionServices securityPermissionServices;
	
	private List provinceList;//省份
	private List companyCategoryList;//公司分类	
	private List serviceStatusList;//维修单状态
	private List serviceTypeList;//维修单类型
	private List machineCatList;//机器分类
	private String message;//登录消息,显示登录用户未完成的工作
	
	public AreaServices getAreaServices() {
		return areaServices;
	}

	public void setAreaServices(AreaServices areaServices) {
		this.areaServices = areaServices;
	}

	public BaseServices getBaseServices() {
		return baseServices;
	}

	public void setBaseServices(BaseServices baseServices) {
		this.baseServices = baseServices;
	}

	public SecurityPermissionServices getSecurityPermissionServices() {
		return securityPermissionServices;
	}

	public void setSecurityPermissionServices(
			SecurityPermissionServices securityPermissionServices) {
		this.securityPermissionServices = securityPermissionServices;
	}

	public List getProvinceList() {
		return provinceList;
	}

	public void setProvinceList(List provinceList) {
		this.provinceList = provinceList;
	}

	public List getCompanyCategoryList() {
		return companyCategoryList;
	}

	public void setCompanyCategoryList(List companyCategoryList) {
		this.companyCategoryList = companyCategoryList;
	}

	public List getServiceStatusList() {
		return serviceStatusList;
	}

	public void setServiceStatusList(List serviceStatusList) {
		this.serviceStatusList = serviceStatusList;
	}

	public List getServiceTypeList() {
		return serviceTypeList;
	}

	public void setServiceTypeList(List serviceTypeList) {
		this.serviceTypeList = serviceTypeList;
	}

	public List getMachineCatList() {
		return machineCatList;
	}

	public void setMachineCatList(List machineCatList) {
		this.machineCatList = machineCatList;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	//省份列表
	public void provinceList()
	{
		try {
			provinceList = areaServices.provinceList();
		} catch (Exception e) {
			this.provinceList = null;
		}
	}
	
	//公司分类
	public void companyCategoryList()
	{
		try {
			this.companyCategoryList = this.baseServices.getUnitList("COMPANY_CATEGORY");
		} catch (Exception e) {
			this.companyCategoryList = null;
		}
	}
	
	//维修单状态
	public void serviceStatusList()
	{
		try {
			this.serviceStatusList = this.baseServices.getUnitList("SERVICE_STATUS");
		} catch (Exception e) {
			this.serviceStatusList = null;
		}
	}
	
	//维修单类型
	public void serviceTypeList()
	{
		try {
			this.serviceTypeList = this.baseServices.getUnitList("SERVICE_TYPE");
		} catch (Exception e) {
			this.serviceTypeList = null;
		}
	}
	
	//机器分类
	public void machineCatList()
	{
		try {
			this.machineCatList = this.baseServices.getMachineCatList();
		} catch (Exception e) {
			this.machineCatList = null;
		}
	}
	
	//根据不同的登录用户判断，得到当前用户需要处理的工作
	public String userLoginMessage()
	{

		try {
			Map session = ActionContext.getContext().getSession();
			UserLogin ul = (UserLogin) session.get("LOGIN_INFO");
			Company c = (Company) session.get("COMPANY_INFO");
			if(c==null||c.getCategory()==null)
				return "success";
			Map m = baseServices.userLoginMessage(ul, c);
			message = "";
			if(c.getCategory()==null)
				return "success";
			if(c.getCategory().equals("SHOP"))
			{
				if(m.get("NO_APPLY")!=null&&Integer.parseInt(m.get("NO_APPLY").toString())>0)
					message+="未申请("+Integer.parseInt(m.get("NO_APPLY").toString())+")";
				if(m.get("RE_APPLY")!=null&&Integer.parseInt(m.get("RE_APPLY").toString())>0)
					message+="不通过("+Integer.parseInt(m.get("RE_APPLY").toString())+")";
			}else if(c.getCategory().equals("CC"))
			{
				if(m.get("NO_VISIT")!=null&&Integer.parseInt(m.get("NO_VISIT").toString())>0)
					message+="未回访("+Integer.parseInt(m.get("NO_VISIT").toString())+")";
			}else if(c.getCategory().equals("RCN"))
			{
				if(m.get("IN_APPLY")!=null&&Integer.parseInt(m.get("IN_APPLY").toString())>0)
					message+="未审核("+Integer.parseInt(m.get("IN_APPLY").toString())+")";
				if(securityPermissionServices.checkPermission(ul.getId(), "MENU_19").equals("SUCCESS")&&m.get("SCM")!=null&&Integer.parseInt(m.get("SCM").toString())>0)
					message+="SCM("+Integer.parseInt(m.get("SCM").toString())+")";
				if(securityPermissionServices.checkPermission(ul.getId(), "MENU_39").equals("SUCCESS")&&m.get("CSPC")!=null&&Integer.parseInt(m.get("CSPC").toString())>0)
					message+="CSPC("+Integer.parseInt(m.get("CSPC").toString())+")";
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "success";
	}

}
