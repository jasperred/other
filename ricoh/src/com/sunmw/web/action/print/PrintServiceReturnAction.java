package com.sunmw.web.action.print;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import com.opensymphony.xwork2.ActionContext;
import com.sunmw.web.bean.print.PrintServices;
import com.sunmw.web.common.message.MessageInfo;
import com.sunmw.web.entity.UserLogin;
import com.sunmw.web.util.WebUtil;

public class PrintServiceReturnAction {
	
	private PrintServices printServices;
	
	private String serviceId;
	private String serviceApplyId;
	private ServiceReturnPrintBean serviceReturnPrintBean;
	private String serviceReturnPrintInfo;
	
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

	public String getServiceApplyId() {
		return serviceApplyId;
	}

	public void setServiceApplyId(String serviceApplyId) {
		this.serviceApplyId = serviceApplyId;
	}

	public ServiceReturnPrintBean getServiceReturnPrintBean() {
		return serviceReturnPrintBean;
	}

	public void setServiceReturnPrintBean(
			ServiceReturnPrintBean serviceReturnPrintBean) {
		this.serviceReturnPrintBean = serviceReturnPrintBean;
	}

	public String getServiceReturnPrintInfo() {
		return serviceReturnPrintInfo;
	}

	public void setServiceReturnPrintInfo(String serviceReturnPrintInfo) {
		this.serviceReturnPrintInfo = serviceReturnPrintInfo;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String printServiceReturnByServiceId()
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
			Map r = printServices.serviceReturnPrintInfo(param);
			if (r.get("Flag").equals("ERROR")) {
				message = (String) r.get("Message");
				return "error";
			} else {
				message = null;
			}
			serviceReturnPrintBean = (ServiceReturnPrintBean)r.get("ServiceReturnPrintBean");
		} catch (Exception e) {
			message = MessageInfo.OperationType;
		}
        return "success";
	}
	
	public String viewPrintServiceReturn()
	{
		try {
			if(WebUtil.isNull(serviceApplyId))
			{
				message = "找不到维修单";
				return "error";
			}
			Map session = ActionContext.getContext().getSession();
			UserLogin ul = (UserLogin) session.get("LOGIN_INFO");
			Map param = new HashMap();
			param.put("UserLogin", ul);
			param.put("ServiceApplyId", serviceApplyId);
			Map r = printServices.serviceReturnPrintInfo(param);
			if (r.get("Flag").equals("ERROR")) {
				message = (String) r.get("Message");
				return "error";
			} else {
				message = null;
			}
			serviceReturnPrintBean = (ServiceReturnPrintBean)r.get("ServiceReturnPrintBean");
		} catch (Exception e) {
			message = MessageInfo.OperationType;
		}
        return "success";
	}
	
	public String printServiceReturn()
	{
		try {
			if(serviceReturnPrintInfo==null)
			{
				message = "打印数据错误";
				return "error";
			}
			else
				message = null;
			JSONObject soi = JSONObject.fromObject(serviceReturnPrintInfo);
			serviceReturnPrintBean = new ServiceReturnPrintBean();
			serviceReturnPrintBean.setApplyDate(WebUtil.filterSpecialCharacters(soi.getString("ApplyDate")));
			serviceReturnPrintBean.setBlackWhiteNumber(WebUtil.filterSpecialCharacters(soi.getString("BlackWhiteNumber")));
			serviceReturnPrintBean.setCompanyAddress(WebUtil.filterSpecialCharacters(soi.getString("CompanyAddress")));
			serviceReturnPrintBean.setCompanyTel(WebUtil.filterSpecialCharacters(soi.getString("CompanyTel")));
			serviceReturnPrintBean.setCustomerCompany(WebUtil.filterSpecialCharacters(soi.getString("CustomerCompany")));
			serviceReturnPrintBean.setCustomerName(WebUtil.filterSpecialCharacters(soi.getString("CustomerName")));
			serviceReturnPrintBean.setPpsNo(WebUtil.filterSpecialCharacters(soi.getString("PpsNo")));
			serviceReturnPrintBean.setInvoiceDate(WebUtil.filterSpecialCharacters(soi.getString("InvoiceDate")));
			serviceReturnPrintBean.setField1(WebUtil.filterSpecialCharacters(soi.getString("Field1")));
			serviceReturnPrintBean.setField2(WebUtil.filterSpecialCharacters(soi.getString("Field2")));
			serviceReturnPrintBean.setField3(WebUtil.filterSpecialCharacters(soi.getString("Field3")));
			serviceReturnPrintBean.setField4(WebUtil.filterSpecialCharacters(soi.getString("Field4")));
			serviceReturnPrintBean.setField5(WebUtil.filterSpecialCharacters(soi.getString("Field5")));
			serviceReturnPrintBean.setField6(WebUtil.filterSpecialCharacters(soi.getString("Field6")));
			serviceReturnPrintBean.setField7(WebUtil.filterSpecialCharacters(soi.getString("Field7")));
			serviceReturnPrintBean.setField8(WebUtil.filterSpecialCharacters(soi.getString("Field8")));
			serviceReturnPrintBean.setField9(WebUtil.filterSpecialCharacters(soi.getString("Field9")));
			serviceReturnPrintBean.setField10(WebUtil.filterSpecialCharacters(soi.getString("Field10")));
			serviceReturnPrintBean.setField11(WebUtil.filterSpecialCharacters(soi.getString("Field11")));
			serviceReturnPrintBean.setField12(WebUtil.filterSpecialCharacters(soi.getString("Field12")));
			serviceReturnPrintBean.setField13(WebUtil.filterSpecialCharacters(soi.getString("Field13")));
			serviceReturnPrintBean.setField14(WebUtil.filterSpecialCharacters(soi.getString("Field14")));
			serviceReturnPrintBean.setField15(WebUtil.filterSpecialCharacters(soi.getString("Field15")));
			serviceReturnPrintBean.setField16(WebUtil.filterSpecialCharacters(soi.getString("Field16")));
			serviceReturnPrintBean.setField17(WebUtil.filterSpecialCharacters(soi.getString("Field17")));
			serviceReturnPrintBean.setField18(WebUtil.filterSpecialCharacters(soi.getString("Field18")));
			serviceReturnPrintBean.setField19(WebUtil.filterSpecialCharacters(soi.getString("Field19")));
			serviceReturnPrintBean.setField20(WebUtil.filterSpecialCharacters(soi.getString("Field20")));
			serviceReturnPrintBean.setField21(WebUtil.filterSpecialCharacters(soi.getString("Field21")));
			serviceReturnPrintBean.setField22(WebUtil.filterSpecialCharacters(soi.getString("Field22")));
			serviceReturnPrintBean.setField23(WebUtil.filterSpecialCharacters(soi.getString("Field23")));
			serviceReturnPrintBean.setField24(WebUtil.filterSpecialCharacters(soi.getString("Field24")));
			serviceReturnPrintBean.setField25(WebUtil.filterSpecialCharacters(soi.getString("Field25")));
			serviceReturnPrintBean.setField26(WebUtil.filterSpecialCharacters(soi.getString("Field26")));
			serviceReturnPrintBean.setField27(WebUtil.filterSpecialCharacters(soi.getString("Field27")));
			serviceReturnPrintBean.setField28(WebUtil.filterSpecialCharacters(soi.getString("Field28")));
			serviceReturnPrintBean.setField29(WebUtil.filterSpecialCharacters(soi.getString("Field29")));
			serviceReturnPrintBean.setField30(WebUtil.filterSpecialCharacters(soi.getString("Field30")));
			serviceReturnPrintBean.setField31(WebUtil.filterSpecialCharacters(soi.getString("Field31")));
			serviceReturnPrintBean.setField32(WebUtil.filterSpecialCharacters(soi.getString("Field32")));
			serviceReturnPrintBean.setField33(WebUtil.filterSpecialCharacters(soi.getString("Field33")));
			serviceReturnPrintBean.setField34(WebUtil.filterSpecialCharacters(soi.getString("Field34")));
			serviceReturnPrintBean.setField35(WebUtil.filterSpecialCharacters(soi.getString("Field35")));
			serviceReturnPrintBean.setField36(WebUtil.formatDateString(new Date(), "yyyy年MM月dd日"));
			if(WebUtil.isNotNull(soi.getString("Field37")))
			serviceReturnPrintBean.setField37(WebUtil.round(new BigDecimal(WebUtil.filterSpecialCharacters(soi.getString("Field37").trim()))).toString());
			serviceReturnPrintBean.setField38(WebUtil.filterSpecialCharacters(soi.getString("Field38")));
		} catch (Exception e) {
			message = MessageInfo.OperationType;
			return "error";
		}
        return "success";
	}

}
