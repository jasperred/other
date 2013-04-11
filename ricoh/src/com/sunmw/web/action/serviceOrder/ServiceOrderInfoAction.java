package com.sunmw.web.action.serviceOrder;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.sunmw.web.bean.serviceOrder.ServiceOrderServices;
import com.sunmw.web.common.message.MessageInfo;
import com.sunmw.web.entity.ServiceFault;
import com.sunmw.web.entity.ServiceItem;
import com.sunmw.web.entity.UserLogin;
import com.sunmw.web.util.WebConfigProperties;
import com.sunmw.web.util.WebUtil;

public class ServiceOrderInfoAction {
	
	private ServiceOrderServices serviceOrderServices;
	
	//维修信息
	private String serviceId;
	private String serviceType;
	private String serviceNo;
	private String machineNo;
	private String companyId;
	private String companyName;
	private String machineTypeId;
	private String machineTypeName;
	private String machineTypeCat;
	private String machineCd;
	private String serviceDateStatus;
	private String serviceEndDate;
	private String serviceFromDate;
	private String invoiceDate;
	private String outDate;
	private String lastDate;
	private String serviceDate;
	private String fromDate;
	private String endDate;
	private String serviceMethod;
	private String serviceContract;
	private String serviceOperation;
	private String blackWhiteNumber;
	private String colorNumber;
	private String plateNumber;
	private String partOrMachine;
	private String michaneMemo;
	private String customerCompany;
	private String customerNo;
	private String customerZip;
	private String customerName;
	private String customerTel;
	private String customerAddress1;
	private String customerAddress2;
	private String customerAddress3;
	private String customerAddress4;
	private String customerAddress5;
	private String createTime;
	private String createName;
	//机器相关信息 2012-08-16
	private String machinePaymentStatus;
	private String machinePaymentCompany;
	private String machinePaymentDate;
	
	//维修状态
	private String serviceStatus;
	private String serviceStatusName;
	private String applyRateStatus;
	private String applyRateStatusName;
	private String applyPartStatus;
	private String applyPartStatusName;
	private String applyMachineStatus;
	private String applyMachineStatusName;
	private String visitStatus;
	private String visitStatusName;
	private String visitResult;
	//故障
	private List faultList;
	//零件
	private List partOrMachineList;
	//审核结果/申述
	private String partMemo1;
	private String partMemo2;
	private String rateMemo1;
	private String rateMemo2;
	//维修结果
	private String serviceAmt;
	private String homeAmt;
	private String partsAmt;
	private String consumablesAmt;
	private String otherAmt;
	private String otherAmtMemo;
	private String serviceFinishDate;
	private String serviceExpectedFinishDate;
	private String serviceResult;
	private String fixPeople;
	private String customerRetrieveDate;
	private String thruTime;
	private String responseTime;
	private String moveTime;
	private String memo;
	private String applyTecRate;
	private String applyHomeRate;
	private String applyOtherRate;
	private String applyOtherRateMemo;
	//附件
	private List fileList;
	private String fileUploadUrl;
	
	
	
	private String message;
	
	
	public String getFileUploadUrl() {
		return fileUploadUrl;
	}


	public void setFileUploadUrl(String fileUploadUrl) {
		this.fileUploadUrl = fileUploadUrl;
	}


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


	public String getServiceNo() {
		return serviceNo;
	}


	public void setServiceNo(String serviceNo) {
		this.serviceNo = serviceNo;
	}


	public String getMachineNo() {
		return machineNo;
	}


	public void setMachineNo(String machineNo) {
		this.machineNo = machineNo;
	}


	public String getCompanyId() {
		return companyId;
	}


	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}


	public String getCompanyName() {
		return companyName;
	}


	public void setCompanyName(String companyName) {
		this.companyName = companyName;
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


	public String getMachineTypeCat() {
		return machineTypeCat;
	}


	public void setMachineTypeCat(String machineTypeCat) {
		this.machineTypeCat = machineTypeCat;
	}


	public String getMachineCd() {
		return machineCd;
	}


	public void setMachineCd(String machineCd) {
		this.machineCd = machineCd;
	}


	public String getServiceDateStatus() {
		return serviceDateStatus;
	}


	public void setServiceDateStatus(String serviceDateStatus) {
		this.serviceDateStatus = serviceDateStatus;
	}


	public String getServiceEndDate() {
		return serviceEndDate;
	}


	public void setServiceEndDate(String serviceEndDate) {
		this.serviceEndDate = serviceEndDate;
	}


	public String getServiceFromDate() {
		return serviceFromDate;
	}


	public void setServiceFromDate(String serviceFromDate) {
		this.serviceFromDate = serviceFromDate;
	}


	public String getInvoiceDate() {
		return invoiceDate;
	}


	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}


	public String getOutDate() {
		return outDate;
	}


	public void setOutDate(String outDate) {
		this.outDate = outDate;
	}


	public String getLastDate() {
		return lastDate;
	}


	public void setLastDate(String lastDate) {
		this.lastDate = lastDate;
	}


	public String getCreateTime() {
		return createTime;
	}


	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}


	public String getCreateName() {
		return createName;
	}


	public void setCreateName(String createName) {
		this.createName = createName;
	}


	public String getMachinePaymentStatus() {
		return machinePaymentStatus;
	}


	public void setMachinePaymentStatus(String machinePaymentStatus) {
		this.machinePaymentStatus = machinePaymentStatus;
	}


	public String getMachinePaymentCompany() {
		return machinePaymentCompany;
	}


	public void setMachinePaymentCompany(String machinePaymentCompany) {
		this.machinePaymentCompany = machinePaymentCompany;
	}


	public String getMachinePaymentDate() {
		return machinePaymentDate;
	}


	public void setMachinePaymentDate(String machinePaymentDate) {
		this.machinePaymentDate = machinePaymentDate;
	}


	public String getServiceStatus() {
		return serviceStatus;
	}


	public void setServiceStatus(String serviceStatus) {
		this.serviceStatus = serviceStatus;
	}


	public String getServiceStatusName() {
		return serviceStatusName;
	}


	public void setServiceStatusName(String serviceStatusName) {
		this.serviceStatusName = serviceStatusName;
	}


	public String getApplyRateStatus() {
		return applyRateStatus;
	}


	public void setApplyRateStatus(String applyRateStatus) {
		this.applyRateStatus = applyRateStatus;
	}


	public String getApplyRateStatusName() {
		return applyRateStatusName;
	}


	public void setApplyRateStatusName(String applyRateStatusName) {
		this.applyRateStatusName = applyRateStatusName;
	}


	public String getApplyPartStatus() {
		return applyPartStatus;
	}


	public void setApplyPartStatus(String applyPartStatus) {
		this.applyPartStatus = applyPartStatus;
	}


	public String getApplyPartStatusName() {
		return applyPartStatusName;
	}


	public void setApplyPartStatusName(String applyPartStatusName) {
		this.applyPartStatusName = applyPartStatusName;
	}


	public String getApplyMachineStatus() {
		return applyMachineStatus;
	}


	public void setApplyMachineStatus(String applyMachineStatus) {
		this.applyMachineStatus = applyMachineStatus;
	}


	public String getApplyMachineStatusName() {
		return applyMachineStatusName;
	}


	public void setApplyMachineStatusName(String applyMachineStatusName) {
		this.applyMachineStatusName = applyMachineStatusName;
	}


	public String getApplyTecRate() {
		return applyTecRate;
	}


	public void setApplyTecRate(String applyTecRate) {
		this.applyTecRate = applyTecRate;
	}


	public String getApplyHomeRate() {
		return applyHomeRate;
	}


	public void setApplyHomeRate(String applyHomeRate) {
		this.applyHomeRate = applyHomeRate;
	}


	public String getApplyOtherRate() {
		return applyOtherRate;
	}


	public void setApplyOtherRate(String applyOtherRate) {
		this.applyOtherRate = applyOtherRate;
	}


	public String getApplyOtherRateMemo() {
		return applyOtherRateMemo;
	}


	public void setApplyOtherRateMemo(String applyOtherRateMemo) {
		this.applyOtherRateMemo = applyOtherRateMemo;
	}


	public String getVisitStatus() {
		return visitStatus;
	}


	public void setVisitStatus(String visitStatus) {
		this.visitStatus = visitStatus;
	}


	public String getVisitStatusName() {
		return visitStatusName;
	}


	public void setVisitStatusName(String visitStatusName) {
		this.visitStatusName = visitStatusName;
	}


	public String getServiceAmt() {
		return serviceAmt;
	}


	public void setServiceAmt(String serviceAmt) {
		this.serviceAmt = serviceAmt;
	}


	public String getServiceType() {
		return serviceType;
	}


	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}


	public String getServiceDate() {
		return serviceDate;
	}


	public void setServiceDate(String serviceDate) {
		this.serviceDate = serviceDate;
	}


	public String getFromDate() {
		return fromDate;
	}


	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}


	public String getEndDate() {
		return endDate;
	}


	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}


	public String getServiceMethod() {
		return serviceMethod;
	}


	public void setServiceMethod(String serviceMethod) {
		this.serviceMethod = serviceMethod;
	}


	public String getServiceContract() {
		return serviceContract;
	}


	public void setServiceContract(String serviceContract) {
		this.serviceContract = serviceContract;
	}


	public String getServiceOperation() {
		return serviceOperation;
	}


	public void setServiceOperation(String serviceOperation) {
		this.serviceOperation = serviceOperation;
	}


	public String getBlackWhiteNumber() {
		return blackWhiteNumber;
	}


	public void setBlackWhiteNumber(String blackWhiteNumber) {
		this.blackWhiteNumber = blackWhiteNumber;
	}


	public String getColorNumber() {
		return colorNumber;
	}


	public void setColorNumber(String colorNumber) {
		this.colorNumber = colorNumber;
	}


	public String getPlateNumber() {
		return plateNumber;
	}


	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}


	public String getPartOrMachine() {
		return partOrMachine;
	}


	public void setPartOrMachine(String partOrMachine) {
		this.partOrMachine = partOrMachine;
	}


	public String getMichaneMemo() {
		return michaneMemo;
	}


	public void setMichaneMemo(String michaneMemo) {
		this.michaneMemo = michaneMemo;
	}


	public String getCustomerCompany() {
		return customerCompany;
	}


	public void setCustomerCompany(String customerCompany) {
		this.customerCompany = customerCompany;
	}


	public String getCustomerNo() {
		return customerNo;
	}


	public void setCustomerNo(String customerNo) {
		this.customerNo = customerNo;
	}


	public String getCustomerZip() {
		return customerZip;
	}


	public void setCustomerZip(String customerZip) {
		this.customerZip = customerZip;
	}


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public String getCustomerTel() {
		return customerTel;
	}


	public void setCustomerTel(String customerTel) {
		this.customerTel = customerTel;
	}


	public String getCustomerAddress1() {
		return customerAddress1;
	}


	public void setCustomerAddress1(String customerAddress1) {
		this.customerAddress1 = customerAddress1;
	}


	public String getCustomerAddress2() {
		return customerAddress2;
	}


	public void setCustomerAddress2(String customerAddress2) {
		this.customerAddress2 = customerAddress2;
	}


	public String getCustomerAddress3() {
		return customerAddress3;
	}


	public void setCustomerAddress3(String customerAddress3) {
		this.customerAddress3 = customerAddress3;
	}


	public String getCustomerAddress4() {
		return customerAddress4;
	}


	public void setCustomerAddress4(String customerAddress4) {
		this.customerAddress4 = customerAddress4;
	}


	public String getCustomerAddress5() {
		return customerAddress5;
	}


	public void setCustomerAddress5(String customerAddress5) {
		this.customerAddress5 = customerAddress5;
	}


	public List getFaultList() {
		return faultList;
	}


	public void setFaultList(List faultList) {
		this.faultList = faultList;
	}


	public List getPartOrMachineList() {
		return partOrMachineList;
	}


	public void setPartOrMachineList(List partOrMachineList) {
		this.partOrMachineList = partOrMachineList;
	}


	public String getPartMemo1() {
		return partMemo1;
	}


	public void setPartMemo1(String partMemo1) {
		this.partMemo1 = partMemo1;
	}


	public String getPartMemo2() {
		return partMemo2;
	}


	public void setPartMemo2(String partMemo2) {
		this.partMemo2 = partMemo2;
	}


	public String getRateMemo1() {
		return rateMemo1;
	}


	public void setRateMemo1(String rateMemo1) {
		this.rateMemo1 = rateMemo1;
	}


	public String getRateMemo2() {
		return rateMemo2;
	}


	public void setRateMemo2(String rateMemo2) {
		this.rateMemo2 = rateMemo2;
	}


	public String getHomeAmt() {
		return homeAmt;
	}


	public void setHomeAmt(String homeAmt) {
		this.homeAmt = homeAmt;
	}


	public String getPartsAmt() {
		return partsAmt;
	}


	public void setPartsAmt(String partsAmt) {
		this.partsAmt = partsAmt;
	}


	public String getConsumablesAmt() {
		return consumablesAmt;
	}


	public void setConsumablesAmt(String consumablesAmt) {
		this.consumablesAmt = consumablesAmt;
	}


	public String getOtherAmt() {
		return otherAmt;
	}


	public void setOtherAmt(String otherAmt) {
		this.otherAmt = otherAmt;
	}


	public String getOtherAmtMemo() {
		return otherAmtMemo;
	}


	public void setOtherAmtMemo(String otherAmtMemo) {
		this.otherAmtMemo = otherAmtMemo;
	}


	public String getServiceFinishDate() {
		return serviceFinishDate;
	}


	public void setServiceFinishDate(String serviceFinishDate) {
		this.serviceFinishDate = serviceFinishDate;
	}


	public String getServiceExpectedFinishDate() {
		return serviceExpectedFinishDate;
	}


	public void setServiceExpectedFinishDate(String serviceExpectedFinishDate) {
		this.serviceExpectedFinishDate = serviceExpectedFinishDate;
	}


	public String getServiceResult() {
		return serviceResult;
	}


	public void setServiceResult(String serviceResult) {
		this.serviceResult = serviceResult;
	}


	public String getFixPeople() {
		return fixPeople;
	}


	public void setFixPeople(String fixPeople) {
		this.fixPeople = fixPeople;
	}


	public String getCustomerRetrieveDate() {
		return customerRetrieveDate;
	}


	public void setCustomerRetrieveDate(String customerRetrieveDate) {
		this.customerRetrieveDate = customerRetrieveDate;
	}


	public String getThruTime() {
		return thruTime;
	}


	public void setThruTime(String thruTime) {
		this.thruTime = thruTime;
	}


	public String getResponseTime() {
		return responseTime;
	}


	public void setResponseTime(String responseTime) {
		this.responseTime = responseTime;
	}


	public String getMoveTime() {
		return moveTime;
	}


	public void setMoveTime(String moveTime) {
		this.moveTime = moveTime;
	}


	public String getMemo() {
		return memo;
	}


	public void setMemo(String memo) {
		this.memo = memo;
	}


	public String getVisitResult() {
		return visitResult;
	}


	public void setVisitResult(String visitResult) {
		this.visitResult = visitResult;
	}


	public List getFileList() {
		return fileList;
	}


	public void setFileList(List fileList) {
		this.fileList = fileList;
	}

	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public String serviceOrderInfo()
	{
		try {
			Map session = ActionContext.getContext().getSession();
			UserLogin ul = (UserLogin) session.get("LOGIN_INFO");
			Map param = new HashMap();
			param.put("UserLogin", ul);
			param.put("ServiceId", serviceId);
			Map r = serviceOrderServices.newServiceOrderInfo(param);
			String f = (String)r.get("Flag");
			if(f.equals("ERROR"))
			{
				message = (String) r.get("Message");
				return "error";
			}
			fileUploadUrl = WebConfigProperties.getProperties("file.upload.url");
			//维修信息
			if(WebUtil.isNotNull(r.get("ServiceId")))
				serviceId = WebUtil.replaceSpecialCharacters(r.get("ServiceId").toString());
			else
				serviceId = "";
			serviceType = WebUtil.replaceSpecialCharacters((String) r.get("ServiceType"));
			serviceNo = WebUtil.replaceSpecialCharacters((String) r.get("ServiceNo"));
			machineNo = WebUtil.replaceSpecialCharacters((String) r.get("MachineNo"));		
			if(WebUtil.isNotNull(r.get("CompanyId")))
				companyId =WebUtil.replaceSpecialCharacters( r.get("CompanyId").toString());
			else
				companyId = "";
			companyName = WebUtil.replaceSpecialCharacters((String) r.get("CompanyName"));	
			if(WebUtil.isNotNull(r.get("MachineTypeId")))
				machineTypeId = WebUtil.replaceSpecialCharacters(r.get("MachineTypeId").toString());
			else
				machineTypeId = "";
			machineTypeName = WebUtil.replaceSpecialCharacters((String) r.get("MachineTypeName"));	
			machineTypeCat = WebUtil.replaceSpecialCharacters((String) r.get("MachineTypeCat"));
			machineCd = WebUtil.replaceSpecialCharacters((String) r.get("MachineCd"));	
			serviceDateStatus = WebUtil.replaceSpecialCharacters((String) r.get("ServiceDateStatus"));	
			if(WebUtil.isNotNull(r.get("ServiceEndDate")))
				serviceEndDate = WebUtil.replaceSpecialCharacters(WebUtil.formatDateString((Date)r.get("ServiceEndDate"), "yyyy-MM-dd"));
			else
				serviceEndDate = "";
			if(WebUtil.isNotNull(r.get("LastDate")))
				lastDate = WebUtil.replaceSpecialCharacters(WebUtil.formatDateString((Date)r.get("LastDate"), "yyyy-MM-dd"));
			else
				lastDate = "";
			if(WebUtil.isNotNull(r.get("CreateTime")))
				createTime = WebUtil.replaceSpecialCharacters(WebUtil.formatDateString((Date)r.get("CreateTime"), "yyyy-MM-dd"));
			else
				createTime = "";
			if(WebUtil.isNotNull(r.get("InvoiceDate")))
				invoiceDate = WebUtil.replaceSpecialCharacters(WebUtil.formatDateString((Date)r.get("InvoiceDate"), "yyyy-MM-dd"));
			else
				invoiceDate = "";
			if(WebUtil.isNotNull(r.get("ServiceFromDate")))
				serviceFromDate = WebUtil.replaceSpecialCharacters(WebUtil.formatDateString((Date)r.get("ServiceFromDate"), "yyyy-MM-dd"));
			else
				serviceFromDate = "";
			if(WebUtil.isNotNull(r.get("OutDate")))
				outDate = WebUtil.replaceSpecialCharacters(WebUtil.formatDateString((Date)r.get("OutDate"), "yyyy-MM-dd"));
			else
				outDate = "";
			createName = WebUtil.replaceSpecialCharacters((String) r.get("CreateName"));	
			if(WebUtil.isNotNull(r.get("ServiceDate")))
				WebUtil.replaceSpecialCharacters(serviceDate = WebUtil.formatDateString((Date)r.get("ServiceDate"), "yyyy-MM-dd HH:mm"));
			else
				WebUtil.replaceSpecialCharacters(serviceDate = WebUtil.formatDateString(new Date(), "yyyy-MM-dd HH:mm"));
			if(WebUtil.isNotNull(r.get("FromDate")))
				WebUtil.replaceSpecialCharacters(fromDate = WebUtil.formatDateString((Date)r.get("FromDate"), "yyyy-MM-dd HH:mm"));
			else
				fromDate = "";
			if(WebUtil.isNotNull(r.get("EndDate")))
				WebUtil.replaceSpecialCharacters(endDate = WebUtil.formatDateString((Date)r.get("EndDate"), "yyyy-MM-dd HH:mm"));
			else
				endDate = "";
			serviceMethod = WebUtil.replaceSpecialCharacters((String) r.get("ServiceMethod"));
			serviceContract = WebUtil.replaceSpecialCharacters((String) r.get("ServiceContract"));
			serviceOperation = WebUtil.replaceSpecialCharacters((String) r.get("ServiceOperation"));
			blackWhiteNumber = WebUtil.replaceSpecialCharacters((String) r.get("BlackWhiteNumber"));
			colorNumber = WebUtil.replaceSpecialCharacters((String) r.get("ColorNumber"));
			plateNumber = WebUtil.replaceSpecialCharacters((String) r.get("PlateNumber"));
			partOrMachine = WebUtil.replaceSpecialCharacters((String) r.get("PartOrMachine"));
			michaneMemo = WebUtil.replaceSpecialCharacters((String) r.get("MichaneMemo"));
			customerCompany = WebUtil.replaceSpecialCharacters((String) r.get("CustomerCompany"));
			customerNo = WebUtil.replaceSpecialCharacters((String) r.get("CustomerNo"));
			customerZip = WebUtil.replaceSpecialCharacters((String) r.get("CustomerZip"));
			customerName = WebUtil.replaceSpecialCharacters((String) r.get("CustomerName"));
			customerTel = WebUtil.replaceSpecialCharacters((String) r.get("CustomerTel"));
			customerAddress1 = WebUtil.replaceSpecialCharacters((String) r.get("CustomerAddress1"));
			customerAddress2 = WebUtil.replaceSpecialCharacters((String) r.get("CustomerAddress2"));
			customerAddress3 = WebUtil.replaceSpecialCharacters((String) r.get("CustomerAddress3"));
			customerAddress4 = WebUtil.replaceSpecialCharacters((String) r.get("CustomerAddress4"));
			customerAddress5 = WebUtil.replaceSpecialCharacters((String) r.get("CustomerAddress5"));
			//机器相关信息 2012-08-16
			machinePaymentStatus = WebUtil.replaceSpecialCharacters((String) r.get("MachinePaymentStatus"));
			machinePaymentCompany = WebUtil.replaceSpecialCharacters((String) r.get("MachinePaymentCompany"));
			if(WebUtil.isNotNull(r.get("MachinePaymentDate")))
				machinePaymentDate = WebUtil.replaceSpecialCharacters(WebUtil.formatDateString((Date)r.get("MachinePaymentDate"), "yyyy-MM-dd HH:mm"));
			else
				machinePaymentDate = "";
			//维修状态
			serviceStatus = WebUtil.replaceSpecialCharacters((String) r.get("ServiceStatus"));
			serviceStatusName = WebUtil.replaceSpecialCharacters((String) r.get("ServiceStatusName"));
			applyRateStatus = WebUtil.replaceSpecialCharacters((String) r.get("ApplyRateStatus"));
			applyRateStatusName = WebUtil.replaceSpecialCharacters((String) r.get("ApplyRateStatusName"));
			applyPartStatus = WebUtil.replaceSpecialCharacters((String) r.get("ApplyPartStatus"));
			applyPartStatusName = WebUtil.replaceSpecialCharacters((String) r.get("ApplyPartStatusName"));
			applyMachineStatus = WebUtil.replaceSpecialCharacters((String) r.get("ApplyMachineStatus"));
			applyMachineStatusName = WebUtil.replaceSpecialCharacters((String) r.get("ApplyMachineStatusName"));
			visitStatus = WebUtil.replaceSpecialCharacters((String) r.get("VisitStatus"));
			visitStatusName = WebUtil.replaceSpecialCharacters((String) r.get("VisitStatusName"));
			visitResult = WebUtil.replaceSpecialCharacters((String) r.get("VisitResult"));
			//故障
			List<ServiceFault> sfList = (List) r.get("ServiceFaultList");
			if(this.faultList==null)
				this.faultList = new ArrayList();
			this.faultList.clear();
			if(!WebUtil.isNullForList(sfList))
			{
				for(ServiceFault sf:sfList)
				{
					if(WebUtil.isNotNull(sf.getContent()))
						sf.setContent(WebUtil.replaceSpecialCharacters(sf.getContent()));
					if(WebUtil.isNotNull(sf.getFaultCateNo()))
						sf.setFaultCateNo(WebUtil.replaceSpecialCharacters(sf.getFaultCateNo()));
					if(WebUtil.isNotNull(sf.getFaultName()))
						sf.setFaultName(WebUtil.replaceSpecialCharacters(sf.getFaultName()));
					if(WebUtil.isNotNull(sf.getFaultNo()))
						sf.setFaultNo(WebUtil.replaceSpecialCharacters(sf.getFaultNo()));
					if(WebUtil.isNotNull(sf.getFaultType()))
						sf.setFaultType(WebUtil.replaceSpecialCharacters(sf.getFaultType()));
					if(WebUtil.isNotNull(sf.getMemo()))
						sf.setMemo(WebUtil.replaceSpecialCharacters(sf.getMemo()));
					if(WebUtil.isNotNull(sf.getMustMemo()))
						sf.setMustMemo(WebUtil.replaceSpecialCharacters(sf.getMustMemo()));				
					this.faultList.add(sf);
				}
			}
			//零件
			List<ServiceItem> pmList = (List) r.get("ServiceItemList");
			if(this.partOrMachineList==null)
				this.partOrMachineList = new ArrayList();
			this.partOrMachineList.clear();
			if(!WebUtil.isNullForList(pmList))
			{
				for(ServiceItem si:pmList)
				{
					if(WebUtil.isNotNull(si.getItemCate()))
						si.setItemCate(WebUtil.replaceSpecialCharacters(si.getItemCate()));		
					if(WebUtil.isNotNull(si.getItemName()))
						si.setItemName(WebUtil.replaceSpecialCharacters(si.getItemName()));		
					if(WebUtil.isNotNull(si.getItemNo()))
						si.setItemNo(WebUtil.replaceSpecialCharacters(si.getItemNo()));		
					if(WebUtil.isNotNull(si.getItemSerialNo()))
						si.setItemSerialNo(WebUtil.replaceSpecialCharacters(si.getItemSerialNo()));		
					if(WebUtil.isNotNull(si.getItemStatus()))
						si.setItemStatus(WebUtil.replaceSpecialCharacters(si.getItemStatus()));		
					if(WebUtil.isNotNull(si.getItemType()))
						si.setItemType(WebUtil.replaceSpecialCharacters(si.getItemType()));		
					this.partOrMachineList.add(si);
				}
			}
			//审核结果/申述
			partMemo1 = WebUtil.replaceSpecialCharacters((String) r.get("PartMemo1"));
			partMemo2 = WebUtil.replaceSpecialCharacters((String) r.get("PartMemo2"));
			rateMemo1 = WebUtil.replaceSpecialCharacters((String) r.get("RateMemo1"));
			rateMemo2 = WebUtil.replaceSpecialCharacters((String) r.get("RateMemo2"));
			//维修结果
			serviceAmt = WebUtil.replaceSpecialCharacters(WebUtil.round((BigDecimal)r.get("ServiceAmt")).toString());
			homeAmt = WebUtil.replaceSpecialCharacters(WebUtil.round((BigDecimal)r.get("HomeAmt")).toString());
			partsAmt = WebUtil.replaceSpecialCharacters(WebUtil.round((BigDecimal)r.get("PartsAmt")).toString());
			consumablesAmt = WebUtil.replaceSpecialCharacters(WebUtil.round((BigDecimal)r.get("ConsumablesAmt")).toString());
			otherAmt = WebUtil.replaceSpecialCharacters(WebUtil.round((BigDecimal)r.get("OtherAmt")).toString());
			otherAmtMemo = WebUtil.replaceSpecialCharacters((String) r.get("OtherAmtMemo"));
			if(WebUtil.isNotNull(r.get("ServiceFinishDate")))
				serviceFinishDate = WebUtil.replaceSpecialCharacters(WebUtil.formatDateString((Date)r.get("ServiceFinishDate"), "yyyy-MM-dd HH:mm"));
			else
				serviceFinishDate = "";
			if(WebUtil.isNotNull(r.get("ServiceExpectedFinishDate")))
				serviceExpectedFinishDate = WebUtil.replaceSpecialCharacters(WebUtil.formatDateString((Date)r.get("ServiceExpectedFinishDate"), "yyyy-MM-dd HH:mm"));
			else
				serviceExpectedFinishDate = "";
			serviceResult = WebUtil.replaceSpecialCharacters((String) r.get("ServiceResult"));
			fixPeople = WebUtil.replaceSpecialCharacters((String) r.get("FixPeople"));
			if(WebUtil.isNotNull(r.get("CustomerRetrieveDate")))
				customerRetrieveDate = WebUtil.replaceSpecialCharacters(WebUtil.formatDateString((Date)r.get("CustomerRetrieveDate"), "yyyy-MM-dd HH:mm"));
			else
				customerRetrieveDate = "";
			thruTime = WebUtil.replaceSpecialCharacters((String) r.get("ThruTime"));
			responseTime = WebUtil.replaceSpecialCharacters((String) r.get("ResponseTime"));
			moveTime = WebUtil.replaceSpecialCharacters((String) r.get("MoveTime"));
			memo = WebUtil.replaceSpecialCharacters((String) r.get("Memo"));
			applyTecRate = WebUtil.replaceSpecialCharacters(WebUtil.round((BigDecimal)r.get("ApplyTecRate")).toString());
			applyHomeRate = WebUtil.replaceSpecialCharacters(WebUtil.round((BigDecimal)r.get("ApplyHomeRate")).toString());
			applyOtherRate = WebUtil.replaceSpecialCharacters(WebUtil.round((BigDecimal)r.get("ApplyOtherRate")).toString());
			applyOtherRateMemo = WebUtil.replaceSpecialCharacters((String) r.get("ApplyOtherRateMemo"));
			//附件列表
			fileList = (List) r.get("ServiceOrderFileList");
		} catch (Exception e) {
			message = MessageInfo.OperationType;
			return "error";
		}
		return "success";
	}
	

}
