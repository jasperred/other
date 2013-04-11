package com.sunmw.web.action.serviceOrder;

import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.sunmw.web.bean.serviceOrder.ServiceOrderServices;
import com.sunmw.web.common.message.MessageInfo;
import com.sunmw.web.entity.UserLogin;
import com.sunmw.web.util.VerifyRequest;
import com.sunmw.web.util.WebUtil;

public class ServiceOrderCancelAction {
	
	private ServiceOrderServices serviceOrderServices;
	
	private String serviceId;
	private String message;
	private String crumb;
	
	public ServiceOrderServices getServiceOrderServices() {
		return serviceOrderServices;
	}

	public void setServiceOrderServices(ServiceOrderServices serviceOrderServices) {
		this.serviceOrderServices = serviceOrderServices;
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
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

	public String cancelServiceOrder()
	{
		try {
			Map session = ActionContext.getContext().getSession();
			UserLogin ul = (UserLogin) session.get("LOGIN_INFO");
			String userNo = ul.getUserNo();		
			if(crumb==null||!VerifyRequest.verifyCrumb(userNo, crumb))
			{
				message = MessageInfo.Verify;
				return "error";
			}
			Map param = new HashMap();
			param.put("UserLogin", ul);
			param.put("ServiceId", WebUtil.filterSpecialCharacters(serviceId));
			Map<String,String> r = serviceOrderServices.cancelServiceOrder(param);
			String flag = r.get("Flag");
			if(flag.equals("ERROR"))
			{
				message = r.get("Message");
				return "error";
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
