package com.sunmw.web.action.company;

import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.sunmw.web.bean.company.CompanyServices;
import com.sunmw.web.common.message.MessageInfo;
import com.sunmw.web.entity.UserLogin;
import com.sunmw.web.util.VerifyRequest;
import com.sunmw.web.util.WebUtil;

public class CompanyMachineTypeRefDeleteAction {

	private CompanyServices companyServices;

	private String companyId;
	private String machineTypeId;
	
	private String message;
	private String crumb;

	public CompanyServices getCompanyServices() {
		return companyServices;
	}

	public void setCompanyServices(CompanyServices companyServices) {
		this.companyServices = companyServices;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getMachineTypeId() {
		return machineTypeId;
	}

	public void setMachineTypeId(String machineTypeId) {
		this.machineTypeId = machineTypeId;
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

	public String deleteCompanyMachineTypeRef() {
		try {
			Map session = ActionContext.getContext().getSession();
			UserLogin ul = (UserLogin) session.get("LOGIN_INFO");
			String userNo = ul.getUserNo();		
			if(crumb==null||!VerifyRequest.verifyCrumb(userNo, crumb))
			{
				message = MessageInfo.Verify;
				return "success";
			}
			Map param = new HashMap();
			param.put("CompanyId", WebUtil.filterSpecialCharacters(companyId));
			param.put("MachineTypeId", WebUtil.filterSpecialCharacters(machineTypeId));
			boolean b = companyServices.deleteCompanyMachineTypeRef(param);
			if(b)
			{
				message = "success";
			}
		} catch (Exception e) {
			message = MessageInfo.OperationType;
		}
		return "success";
	}

}
