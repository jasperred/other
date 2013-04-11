package com.sunmw.web.action.serviceDelivery;

import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.sunmw.web.bean.serviceOrder.ServiceDeliveryServices;
import com.sunmw.web.common.message.MessageInfo;
import com.sunmw.web.entity.UserLogin;
import com.sunmw.web.util.VerifyRequest;
import com.sunmw.web.util.WebUtil;

public class ServiceDeliveryBackApplyAction {
	
	private ServiceDeliveryServices serviceDeliveryServices;
	
	private String serviceDeliveryId;
	private String backMemo;
	
	private String message;
	private String crumb;
	
	public ServiceDeliveryServices getServiceDeliveryServices() {
		return serviceDeliveryServices;
	}

	public void setServiceDeliveryServices(
			ServiceDeliveryServices serviceDeliveryServices) {
		this.serviceDeliveryServices = serviceDeliveryServices;
	}

	public String getServiceDeliveryId() {
		return serviceDeliveryId;
	}

	public void setServiceDeliveryId(String serviceDeliveryId) {
		this.serviceDeliveryId = serviceDeliveryId;
	}

	public String getBackMemo() {
		return backMemo;
	}

	public void setBackMemo(String backMemo) {
		this.backMemo = backMemo;
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

	public String serviceDeliveryBackApply()
	{
		try {
			Map session = ActionContext.getContext().getSession();
			UserLogin ul = (UserLogin) session.get("LOGIN_INFO");String userNo = ul.getUserNo();		
			if(crumb==null||!VerifyRequest.verifyCrumb(userNo, crumb))
			{
				message = MessageInfo.Verify;
				return "success";
			}
			Map param = new HashMap();
			param.put("UserLogin", ul);
			param.put("ServiceDeliveryId", WebUtil.filterSpecialCharacters(serviceDeliveryId));
			param.put("BackMemo", WebUtil.filterSpecialCharacters(backMemo));
			Map<String,String> r = serviceDeliveryServices.deliveryBackApply(param);
			String flag = r.get("Flag");
			if(flag.equals("ERROR"))
			{
				message = r.get("Message");
			}
			else
			{
				message = null;
			}
		} catch (Exception e) {
			message = MessageInfo.OperationType;
			return "error";
		}
		return "success";
	}

}
