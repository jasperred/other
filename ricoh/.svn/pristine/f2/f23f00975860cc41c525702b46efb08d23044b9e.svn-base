package com.sunmw.web.action.area;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.sunmw.web.bean.area.AreaServices;
import com.sunmw.web.common.message.MessageInfo;
import com.sunmw.web.entity.UserLogin;
import com.sunmw.web.util.VerifyRequest;
import com.sunmw.web.util.WebUtil;

public class AreaInfoAction {
	private AreaServices areaServices;
	
	private String areaCd;
	private String areaName;
	private List provinceList;
	private List<Map> areaProvinceList;
	private String provinceIds;
	private String message;
	private String crumb;
			
	public AreaServices getAreaServices() {
		return areaServices;
	}

	public void setAreaServices(AreaServices areaServices) {
		this.areaServices = areaServices;
	}

	public String getAreaCd() {
		return areaCd;
	}

	public void setAreaCd(String areaCd) {
		this.areaCd = areaCd;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public List getProvinceList() {
		return provinceList;
	}

	public void setProvinceList(List provinceList) {
		this.provinceList = provinceList;
	}

	public List<Map> getAreaProvinceList() {
		return areaProvinceList;
	}

	public void setAreaProvinceList(List<Map> areaProvinceList) {
		this.areaProvinceList = areaProvinceList;
	}

	public String getProvinceIds() {
		return provinceIds;
	}

	public void setProvinceIds(String provinceIds) {
		this.provinceIds = provinceIds;
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

	public String provinceList()
	{
		try {
			areaCd = WebUtil.filterSpecialCharacters(areaCd);
			this.provinceList = this.areaServices.provinceList(areaCd);
			this.areaProvinceList = this.areaServices.areaProvinceList(areaCd);
			this.provinceIds = "";
			if(this.areaProvinceList!=null)
			{
				for(Map m:this.areaProvinceList)
				{
					if(this.provinceIds.length()>0)
						this.provinceIds += ",";
					this.provinceIds += m.get("provinceCd");
				}
			}
		} catch (Exception e) {
			message = MessageInfo.OperationType;
		}
		return "success";
	}
	
	public String saveArea()
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
			areaCd = WebUtil.filterSpecialCharacters(areaCd);
			areaName = WebUtil.filterSpecialCharacters(areaName);
			String m = this.areaServices.saveArea(areaCd, areaName);
			message = m;
		} catch (Exception e) {
			message = MessageInfo.OperationType;
		}
		return "success";
	}
	
	public String saveAreaProvince()
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
			areaCd = WebUtil.filterSpecialCharacters(areaCd);
			provinceIds = WebUtil.filterSpecialCharacters(provinceIds);
			String m = this.areaServices.saveAreaProvince(areaCd, provinceIds);
			message = m;
		} catch (Exception e) {
			message = MessageInfo.OperationType;
		}
		return "success";
	}
	
	public String deleteArea()
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
			areaCd = WebUtil.filterSpecialCharacters(areaCd);
			String m = this.areaServices.deleteArea(areaCd);
			message = m;
		} catch (Exception e) {
			message = MessageInfo.OperationType;
		}
		return "success";
	}
	
	
	public String viewAreaInfo()
	{
		if(WebUtil.isNull(areaCd))
			areaCd = null;
		if(WebUtil.isNull(areaName))
			areaName = null;
		return "success";
	}

}
