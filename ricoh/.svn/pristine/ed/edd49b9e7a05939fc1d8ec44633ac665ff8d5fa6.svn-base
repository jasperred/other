package com.sunmw.web.action.machine;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.sunmw.web.bean.machine.MachineServices;
import com.sunmw.web.common.message.MessageInfo;
import com.sunmw.web.entity.UserLogin;
import com.sunmw.web.util.VerifyRequest;
import com.sunmw.web.util.WebUtil;

public class MachineInfoAction {

	private MachineServices machineServices;

	private String machineId;
	private String machineTypeId;
	private String machineTypeName;
	private String machineCd;
	private String machineNo;
	private String ppsNo;
	private String serviceFromDate;
	private String serviceEndDate;
	private String outDate;
	private String invoiceDate;
	private String paymentStatus;
	private String paymentCompany;
	private String paymentCompanyCd;
	private String paymentDate;
	private String paymentAmt;
	private String lastTime;
	private String lastCompany;
	private String machineStatus;
	private String machineStatusName;
	private String origin;
	private String customerNo;
	private String customerName;

	private String machineFlag;
	private String message;
	private String crumb;

	public MachineServices getMachineServices() {
		return machineServices;
	}

	public void setMachineServices(MachineServices machineServices) {
		this.machineServices = machineServices;
	}

	public String getMachineId() {
		return machineId;
	}

	public void setMachineId(String machineId) {
		this.machineId = machineId;
	}

	public String getMachineTypeId() {
		return machineTypeId;
	}

	public void setMachineTypeId(String machineTypeId) {
		this.machineTypeId = machineTypeId;
	}

	public String getMachineTypeName() {
		return machineTypeName;
	}

	public void setMachineTypeName(String machineTypeName) {
		this.machineTypeName = machineTypeName;
	}

	public String getMachineCd() {
		return machineCd;
	}

	public void setMachineCd(String machineCd) {
		this.machineCd = machineCd;
	}

	public String getMachineNo() {
		return machineNo;
	}

	public void setMachineNo(String machineNo) {
		this.machineNo = machineNo;
	}

	public String getPpsNo() {
		return ppsNo;
	}

	public void setPpsNo(String ppsNo) {
		this.ppsNo = ppsNo;
	}

	public String getServiceFromDate() {
		return serviceFromDate;
	}

	public void setServiceFromDate(String serviceFromDate) {
		this.serviceFromDate = serviceFromDate;
	}

	public String getServiceEndDate() {
		return serviceEndDate;
	}

	public void setServiceEndDate(String serviceEndDate) {
		this.serviceEndDate = serviceEndDate;
	}

	public String getOutDate() {
		return outDate;
	}

	public void setOutDate(String outDate) {
		this.outDate = outDate;
	}

	public String getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getPaymentCompany() {
		return paymentCompany;
	}

	public void setPaymentCompany(String paymentCompany) {
		this.paymentCompany = paymentCompany;
	}

	public String getPaymentCompanyCd() {
		return paymentCompanyCd;
	}

	public void setPaymentCompanyCd(String paymentCompanyCd) {
		this.paymentCompanyCd = paymentCompanyCd;
	}

	public String getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getPaymentAmt() {
		return paymentAmt;
	}

	public void setPaymentAmt(String paymentAmt) {
		this.paymentAmt = paymentAmt;
	}

	public String getLastTime() {
		return lastTime;
	}

	public void setLastTime(String lastTime) {
		this.lastTime = lastTime;
	}

	public String getLastCompany() {
		return lastCompany;
	}

	public void setLastCompany(String lastCompany) {
		this.lastCompany = lastCompany;
	}

	public String getMachineStatus() {
		return machineStatus;
	}

	public void setMachineStatus(String machineStatus) {
		this.machineStatus = machineStatus;
	}

	public String getMachineStatusName() {
		return machineStatusName;
	}

	public void setMachineStatusName(String machineStatusName) {
		this.machineStatusName = machineStatusName;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getMachineFlag() {
		return machineFlag;
	}

	public void setMachineFlag(String machineFlag) {
		this.machineFlag = machineFlag;
	}

	public String getCustomerNo() {
		return customerNo;
	}

	public void setCustomerNo(String customerNo) {
		this.customerNo = customerNo;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
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

	public String machineInfo() {
		if (WebUtil.isNull(machineId)) {
			machineId = null;
			machineTypeId = null;
			machineCd = null;
			machineNo = null;
			ppsNo = null;
			serviceFromDate = null;
			serviceEndDate = null;
			outDate = null;
			invoiceDate = null;
			paymentStatus = null;
			paymentCompany = null;
			paymentCompanyCd = null;
			paymentDate = null;
			paymentAmt = null;
			lastTime = null;
			lastCompany = null;
			machineStatus = null;
			machineStatusName = null;
			origin = null;
			customerNo = null;
			customerName = null;
			return "success";
		}
		Map<String, String> m = machineServices.getMachineInfo(machineId);

		if (m == null)
			return "error";
		machineId = WebUtil.replaceSpecialCharacters(m.get("MachineId"));
		machineTypeId = WebUtil.replaceSpecialCharacters(m.get("MachineTypeId"));
		machineCd = WebUtil.replaceSpecialCharacters(m.get("MachineCd"));
		machineNo = WebUtil.replaceSpecialCharacters(m.get("MachineNo"));
		ppsNo = WebUtil.replaceSpecialCharacters(m.get("PpsNo"));
		serviceFromDate = WebUtil.replaceSpecialCharacters(m.get("ServiceFromDate"));
		serviceEndDate = WebUtil.replaceSpecialCharacters(m.get("ServiceEndDate"));
		outDate = WebUtil.replaceSpecialCharacters(m.get("OutDate"));
		invoiceDate = WebUtil.replaceSpecialCharacters(m.get("InvoiceDate"));
		paymentStatus = WebUtil.replaceSpecialCharacters(m.get("PaymentStatus"));
		paymentCompany = WebUtil.replaceSpecialCharacters(m.get("PaymentCompany"));
		paymentCompanyCd = WebUtil.replaceSpecialCharacters(m.get("PaymentCompanyCd"));
		paymentDate = WebUtil.replaceSpecialCharacters(m.get("PaymentDate"));
		paymentAmt = WebUtil.replaceSpecialCharacters(m.get("PaymentAmt"));
		lastTime = WebUtil.replaceSpecialCharacters(m.get("LastTime"));
		lastCompany = WebUtil.replaceSpecialCharacters(m.get("LastCompany"));
		machineStatus = WebUtil.replaceSpecialCharacters(m.get("MachineStatus"));
		machineStatusName = WebUtil.replaceSpecialCharacters(m.get("MachineStatusName"));
		origin = WebUtil.replaceSpecialCharacters(m.get("Origin"));
		customerNo = WebUtil.replaceSpecialCharacters(m.get("CustomerNo"));
		customerName = WebUtil.replaceSpecialCharacters(m.get("CustomerName"));
		return "success";
	}

	public String checkMachineNo() {
		message = machineServices.checkMachineNo(machineNo);
		return "success";
	}

	public String saveMachine() {
		Map session = ActionContext.getContext().getSession();
		UserLogin ul = (UserLogin) session.get("LOGIN_INFO");
		String userNo = ul.getUserNo();		
		if(crumb==null||!VerifyRequest.verifyCrumb(userNo, crumb))
		{
			message = "";
			return "success";
		}
		Map param = new HashMap();
		param.put("UserLogin", ul);
		param.put("MachineId", WebUtil.filterSpecialCharacters(machineId));
		param.put("MachineTypeId", WebUtil.filterSpecialCharacters(machineTypeId));
		param.put("MachineCd", WebUtil.filterSpecialCharacters(machineCd));
		param.put("MachineNo", WebUtil.filterSpecialCharacters(machineNo));
		param.put("PpsNo", WebUtil.filterSpecialCharacters(ppsNo));
		param.put("ServiceFromDate", WebUtil.filterSpecialCharacters(serviceFromDate));
		param.put("ServiceEndDate", WebUtil.filterSpecialCharacters(serviceEndDate));
		param.put("OutDate", WebUtil.filterSpecialCharacters(outDate));
		param.put("InvoiceDate", WebUtil.filterSpecialCharacters(invoiceDate));
		param.put("PaymentStatus", WebUtil.filterSpecialCharacters(paymentStatus));
		param.put("PaymentCompany", WebUtil.filterSpecialCharacters(paymentCompany));
		param.put("PaymentCompanyCd", WebUtil.filterSpecialCharacters(paymentCompanyCd));
		param.put("PaymentDate", WebUtil.filterSpecialCharacters(paymentDate));
		param.put("PaymentAmt", WebUtil.filterSpecialCharacters(paymentAmt));
		param.put("UserName", ul.getUserName());
		param.put("CustomerNo", WebUtil.filterSpecialCharacters(customerNo));
		param.put("CustomerName", WebUtil.filterSpecialCharacters(customerName));
		Integer i = machineServices.saveMachine(param);
		if (i == null)
			this.message = "";
		else {
			this.message = i.toString();
		}
		return "success";
	}

	public String checkMachine() {
		try {
			Map session = ActionContext.getContext().getSession();
			UserLogin ul = (UserLogin) session.get("LOGIN_INFO");
			machineNo = WebUtil.filterSpecialCharacters(machineNo);
			Map m = machineServices.checkMachine(machineNo, ul);
			if (m.get("Flag").equals("ERROR")) {
				this.message = (String) m.get("Message");
				machineId = null;
				machineTypeId = null;
				machineTypeName = null;
				machineCd = null;
				machineNo = null;
				ppsNo = null;
				serviceFromDate = null;
				serviceEndDate = null;
				outDate = null;
				invoiceDate = null;
				paymentStatus = null;
				paymentCompany = null;
				paymentCompanyCd = null;
				paymentDate = null;
				paymentAmt = null;
				lastTime = null;
				lastCompany = null;
				machineStatus = null;
				machineStatusName = null;
				origin = null;
				
				machineFlag = "E";//不可维修
			} else {
				Map mm = (Map) m.get("Machine");
				if (WebUtil.isNotNull(mm.get("MachineId")))
					machineId = mm.get("MachineId").toString();
				else
					machineId = "";
				if (WebUtil.isNotNull(mm.get("MachineTypeId")))
					machineTypeId = mm.get("MachineTypeId").toString();
				else
					machineTypeId = "";
				if (WebUtil.isNotNull(mm.get("MachineTypeName")))
					machineTypeName = mm.get("MachineTypeName").toString();
				else
					machineTypeName = "";
				if (WebUtil.isNotNull(mm.get("MachineCd")))
					machineCd = mm.get("MachineCd").toString();
				else
					machineCd = "";
				if (WebUtil.isNotNull(mm.get("MachineNo")))
					machineNo = mm.get("MachineNo").toString();
				else
					machineNo = "";
				if (WebUtil.isNotNull(mm.get("PpsNo")))
					ppsNo = mm.get("PpsNo").toString();
				else
					ppsNo = "";
				if (WebUtil.isNotNull(mm.get("ServiceFromDate")))
					serviceFromDate = WebUtil.formatDateString((Date)mm.get("ServiceFromDate"), "yyyy-MM-dd");
				else
					serviceFromDate = "";
				if (WebUtil.isNotNull(mm.get("ServiceEndDate")))
					serviceEndDate = WebUtil.formatDateString((Date)mm.get("ServiceEndDate"), "yyyy-MM-dd");
				else
					serviceEndDate = "";
				if (WebUtil.isNotNull(mm.get("OutDate")))
					outDate = WebUtil.formatDateString((Date)mm.get("OutDate"), "yyyy-MM-dd");
				else
					outDate = "";
				if (WebUtil.isNotNull(mm.get("OutDate")))
					lastTime = WebUtil.formatDateString((Date)mm.get("LastTime"), "yyyy-MM-dd");
				else
					lastTime = "";
				if (WebUtil.isNotNull(mm.get("InvoiceDate")))
					invoiceDate = WebUtil.formatDateString((Date)mm.get("InvoiceDate"), "yyyy-MM-dd");
				else
					invoiceDate = "";
				if (WebUtil.isNotNull(mm.get("PaymentStatus")))
					paymentStatus = mm.get("PaymentStatus").toString();
				else
					paymentStatus = "";
				if (WebUtil.isNotNull(mm.get("PaymentCompany")))
					paymentCompany = mm.get("PaymentCompany").toString();
				else
					paymentCompany = "";
				if (WebUtil.isNotNull(mm.get("PaymentCompanyCd")))
					paymentCompanyCd = mm.get("PaymentCompanyCd").toString();
				else
					paymentCompanyCd = "";
				//保修期
				BigDecimal serviceDate = this.machineServices.getServiceDate((String)mm.get("MachineCat"));
				if(serviceDate==null)
					serviceDate = new BigDecimal(1);
				Date date = WebUtil.toDateForString(WebUtil.formatDateString(new Date(), "yyyy-MM-dd"), "yyyy-MM-dd");
				//判断保修期 machineFlag S(保修期内) C(保修期外) SC(维护合同期)
				//维护合同期：符合“保修期外”条件，并且当天<“机号管理”表/“保修期结束日”
				//保修期内：当天<“发票日期”+12个月 or EXCEED“出库日期”+15个月
				//保修期外：同保修期内条件相反。“服务费已支付”有标记。
				
				if(WebUtil.isNotNull(mm.get("InvoiceDate"))||WebUtil.isNotNull(mm.get("OutDate"))||WebUtil.isNotNull(mm.get("ServiceEndDate")))
				{
					long d;
					if(WebUtil.isNotNull(mm.get("ServiceEndDate")))
					{
						d = WebUtil.toDateForString(WebUtil.formatDateString((Date)mm.get("ServiceEndDate"), "yyyy-MM-dd"), "yyyy-MM-dd").getTime();
						if(d>=date.getTime()-24*60*60*1000L)
						{
							machineFlag = "SC";
							message = "此机器在维护合同期内";
						}
						else
						{
							machineFlag = "C";
							message = "此机器在保修期外";
						}
					}
					else
					{
						if(WebUtil.isNotNull(mm.get("InvoiceDate")))
						{
							//d = WebUtil.toDateForString(WebUtil.formatDateString((Date)mm.get("InvoiceDate"), "yyyy-MM-dd"), "yyyy-MM-dd").getTime()+365*24*60*60*1000L;
							d = WebUtil.toDateForString(WebUtil.ofterMonthDate(WebUtil.toDateForString(WebUtil.formatDateString((Date)mm.get("InvoiceDate"), "yyyy-MM-dd"), "yyyy-MM-dd"), 12*serviceDate.intValue()),  "yyyy-MM-dd").getTime();
						}
						else
						{
							//d = WebUtil.toDateForString(WebUtil.formatDateString((Date)mm.get("OutDate"), "yyyy-MM-dd"), "yyyy-MM-dd").getTime()+455*24*60*60*1000L;
							d = WebUtil.toDateForString(WebUtil.ofterMonthDate(WebUtil.toDateForString(WebUtil.formatDateString((Date)mm.get("OutDate"), "yyyy-MM-dd"), "yyyy-MM-dd"), 12*serviceDate.intValue()+3),  "yyyy-MM-dd").getTime();
						}
						if(d>=date.getTime()-24*60*60*1000L)
						{
							machineFlag = "S";
							message = null;
						}
						else
						{
							machineFlag = "C";
							message = "此机器在保修期外";
						}
					}
				}
				else
				{
					
				}
				//保修期结束日计算
				//①“机号管理”表/“保修期结束日”有数据，则=“保修期结束日”；
				//②“发票日期”+12个月；
				//③“机号管理”表/“保修期开始日”有数据，则=“保修期开始日”+15个月；
				//④“机号管理”表/“保修期开始日”无数据，根据EXCEED“出库日期”加15个月计算。
				//保修期结束日判断
				if(WebUtil.isNotNull(mm.get("ServiceEndDate")))
				{
					serviceEndDate = WebUtil.formatDateString((Date)mm.get("ServiceEndDate"), "yyyy-MM-dd");
//				Date d = WebUtil.toDateForString(WebUtil.formatDateString((Date)mm.get("ServiceEndDate"), "yyyy-MM-dd"), "yyyy-MM-dd");
//				if(d.getTime()>=date.getTime()-24*60*60*1000L)
//				{
//					machineFlag = "S";//保修期内
//				}
//				else
//				{
//					machineFlag = "C";//保修期外.
//					message = "此机器在保修期外";
//				}
				}
				//发票日期判断
				else if(WebUtil.isNotNull(mm.get("InvoiceDate")))
				{
					
					Date d = WebUtil.toDateForString(WebUtil.formatDateString((Date)mm.get("InvoiceDate"), "yyyy-MM-dd"), "yyyy-MM-dd");
					//serviceEndDate = WebUtil.formatDateString(new Date(d.getTime()+365*24*60*60*1000L), "yyyy-MM-dd");
					serviceEndDate = WebUtil.ofterMonthDate(new Date(d.getTime()-24*60*60*1000), 12*serviceDate.intValue());
					//“发票日期”+12个月
//				if(d.getTime()+365*24*60*60*1000L>=date.getTime()-24*60*60*1000L)
//				{
//					machineFlag = "S";//保修期内
//				}
//				else
//				{
//					machineFlag = "C";//保修期外
//					message = "此机器在保修期外";
//				}
				}
				//保修期开始日判断
				else if(WebUtil.isNotNull(mm.get("ServiceFromDate")))
				{
					Date d = WebUtil.toDateForString(WebUtil.formatDateString((Date)mm.get("ServiceFromDate"), "yyyy-MM-dd"), "yyyy-MM-dd");
					//serviceEndDate = WebUtil.formatDateString(new Date(d.getTime()+455*24*60*60*1000L), "yyyy-MM-dd");
					serviceEndDate = WebUtil.ofterMonthDate(new Date(d.getTime()-24*60*60*1000), 12*serviceDate.intValue()+3);
					//“保修期开始日”+15个月；
//				if(d.getTime()+455*24*60*60*1000L>=date.getTime()-24*60*60*1000L)
//				{
//					machineFlag = "S";//保修期内
//				}
//				else
//				{
//					machineFlag = "C";//保修期外
//					message = "此机器在保修期外";
//				}
				}
				//出库日期判断
				else if(WebUtil.isNotNull(mm.get("OutDate")))
				{
					Date d = WebUtil.toDateForString(WebUtil.formatDateString((Date)mm.get("OutDate"), "yyyy-MM-dd"), "yyyy-MM-dd");
					//serviceEndDate = WebUtil.formatDateString(new Date(d.getTime()+455*24*60*60*1000L), "yyyy-MM-dd");
					serviceEndDate = WebUtil.ofterMonthDate(new Date(d.getTime()-24*60*60*1000), 12*serviceDate.intValue()+3);
					//“出库日期”加15个月
//				if(d.getTime()+455*24*60*60*1000L>=date.getTime()-24*60*60*1000L)
//				{
//					machineFlag = "S";//保修期内
//				}
//				else
//				{
//					machineFlag = "C";//保修期外
//					message = "此机器在保修期外";
//				}
				}
//			else
//			{
//				machineFlag = "E";//不可维修
//				message = "保修期无法确认,请联系理光总部";
//			}
				
				
			}
		} catch (Exception e) {
			message = MessageInfo.OperationType;
		}
		return "success";
	}

}
