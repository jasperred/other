package com.sunmw.web.action.serviceApply;

import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.sunmw.web.bean.serviceOrder.ServiceApplyServices;
import com.sunmw.web.common.message.MessageInfo;
import com.sunmw.web.entity.UserLogin;
import com.sunmw.web.util.WebUtil;

public class ServiceApplyAction {
	
	private ServiceApplyServices serviceApplyServices;
	
	private String serviceId;
	private String applyType;
	private String homeRate;
	private String otherRate;
	private String otherRateMemo;
	private String serviceApplyId;
	
	private String message;
	
	public ServiceApplyServices getServiceApplyServices() {
		return serviceApplyServices;
	}

	public void setServiceApplyServices(ServiceApplyServices serviceApplyServices) {
		this.serviceApplyServices = serviceApplyServices;
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public String getApplyType() {
		return applyType;
	}

	public void setApplyType(String applyType) {
		this.applyType = applyType;
	}

	public String getHomeRate() {
		return homeRate;
	}

	public void setHomeRate(String homeRate) {
		this.homeRate = homeRate;
	}

	public String getOtherRate() {
		return otherRate;
	}

	public void setOtherRate(String otherRate) {
		this.otherRate = otherRate;
	}

	public String getOtherRateMemo() {
		return otherRateMemo;
	}

	public void setOtherRateMemo(String otherRateMemo) {
		this.otherRateMemo = otherRateMemo;
	}

	public String getServiceApplyId() {
		return serviceApplyId;
	}

	public void setServiceApplyId(String serviceApplyId) {
		this.serviceApplyId = serviceApplyId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String serviceApply()
	{
		try {
			Map session = ActionContext.getContext().getSession();
			UserLogin ul = (UserLogin) session.get("LOGIN_INFO");
			Map param = new HashMap();
			param.put("UserLogin", ul);
			if(WebUtil.isNotNull(serviceId))
				param.put("ServiceId", WebUtil.filterSpecialCharacters(serviceId.trim()));
			Map<String,String> r = serviceApplyServices.createServiceApplyByPartAndMachine(param);
			String flag = r.get("Flag");
			if(flag.equals("ERROR"))
			{
				message = r.get("Message");
				return "error";
			}
			else
			{
				//serviceApplyId = r.get("ServiceApplyId");
				message = null;
			}
		} catch (Exception e) {
			message = MessageInfo.OperationType;
			return "error";
		}
		return "success";
	}
	
	public String checkServiceRateApply()
	{
		Map<String,String> r = serviceApplyServices.checkServiceApplyByRate(WebUtil.filterSpecialCharacters(serviceId.trim()));
		String flag = r.get("Flag");
		message = r.get("Message");
		return "success";
	}
	
	public String serviceRateApply()
	{
		try {
			Map session = ActionContext.getContext().getSession();
			UserLogin ul = (UserLogin) session.get("LOGIN_INFO");
			Map param = new HashMap();
			param.put("UserLogin", ul);
			if(WebUtil.isNotNull(serviceId))
				param.put("ServiceId",  WebUtil.filterSpecialCharacters(serviceId.trim()));
			param.put("HomeRate",  WebUtil.filterSpecialCharacters(homeRate));
			param.put("OtherRate",  WebUtil.filterSpecialCharacters(otherRate));
			param.put("OtherRateMemo",  WebUtil.filterSpecialCharacters(otherRateMemo));
			Map<String,String> r = serviceApplyServices.createServiceApplyByRate(param);
			String flag = r.get("Flag");
			if(flag.equals("ERROR"))
			{
				message = r.get("Message");
				return "error";
			}
			else
			{
				//serviceApplyId = r.get("ServiceApplyId");
				message = null;
			}
		} catch (Exception e) {
			message = MessageInfo.OperationType;
			return "error";
		}
		return "success";
	}

}
