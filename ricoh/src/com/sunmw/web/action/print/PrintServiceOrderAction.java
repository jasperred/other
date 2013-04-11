package com.sunmw.web.action.print;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.sunmw.web.bean.print.PrintServices;
import com.sunmw.web.common.message.MessageInfo;
import com.sunmw.web.entity.UserLogin;
import com.sunmw.web.util.WebUtil;

public class PrintServiceOrderAction {
	
	private PrintServices printServices;
	
	private String serviceId;
	private ServiceOrderPrintBean serviceOrderPrintBean;

    private String message;

	public PrintServices getPrintServices() {
		return printServices;
	}

	public void setPrintServices(PrintServices printServices) {
		this.printServices = printServices;
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}
	
	public ServiceOrderPrintBean getServiceOrderPrintBean() {
		return serviceOrderPrintBean;
	}

	public void setServiceOrderPrintBean(ServiceOrderPrintBean serviceOrderPrintBean) {
		this.serviceOrderPrintBean = serviceOrderPrintBean;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String printServiceOrder()
	{
		try {
			if(WebUtil.isNull(serviceId))
			{
				message = "找不到维修单";
				return "error";
			}
			Map session = ActionContext.getContext().getSession();
			UserLogin ul = (UserLogin) session.get("LOGIN_INFO");
			Map param = new HashMap();
			param.put("UserLogin", ul);
			param.put("ServiceId", serviceId);
			Map r = printServices.serviceOrderPrintInfo(param);
			if (r.get("Flag").equals("ERROR")) {
				message = (String) r.get("Message");
				return "error";
			} else {
				message = null;
			}
			serviceOrderPrintBean = (ServiceOrderPrintBean)r.get("ServiceOrderPrintBean");
			//serviceOrderPrintList = new ArrayList();
			//serviceOrderPrintList.add(serviceOrderPrintBean);
		} catch (Exception e) {
			message = MessageInfo.OperationType;
			return "error";
		}
        return "success";
	}

}
