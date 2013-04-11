package com.sunmw.web.action.serviceApply;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.sunmw.web.bean.serviceOrder.ServiceApplyServices;
import com.sunmw.web.common.message.MessageInfo;
import com.sunmw.web.entity.UserLogin;
import com.sunmw.web.util.WebConfigProperties;
import com.sunmw.web.util.WebUtil;

public class ServiceApplyInfoAction {
	
	private ServiceApplyServices serviceApplyServices;
	
	private String serviceApplyId;
	private String auditedResult;
	private String companyId;
	private String companyName;
	private String homeRate;
	private String machineCat;
	private String otherRate;
	private String otherRateMemo;
	private String partType;
	private String resultMemo;
	private String serviceApplyType;
	private String serviceApplyTypeName;
	private String serviceId;
	private String serviceNo;
	private String shopMemo;
	private String status;
	private String statusName;
	private String tecRate;
	private String ctime;
	private String cuser;
	private String ccompany;
	private String muser;
	private String returnFlag;
	private String returnMemo;
	private String returnImprove;
	private String returnConfirm;	
	private String visitId;
	private String visitResult;
	private String serviceApplyNo;
	private String serviceType;
	private String backMemo;

	private List faultList;
	private List serviceItemList;
	private List serviceApplyFileList;
	
	private String message;

	private String fileUploadUrl;
	
	public String getFileUploadUrl() {
		return fileUploadUrl;
	}

	public void setFileUploadUrl(String fileUploadUrl) {
		this.fileUploadUrl = fileUploadUrl;
	}

	public ServiceApplyServices getServiceApplyServices() {
		return serviceApplyServices;
	}

	public void setServiceApplyServices(ServiceApplyServices serviceApplyServices) {
		this.serviceApplyServices = serviceApplyServices;
	}

	public String getServiceApplyId() {
		return serviceApplyId;
	}

	public void setServiceApplyId(String serviceApplyId) {
		this.serviceApplyId = serviceApplyId;
	}

	public String getAuditedResult() {
		return auditedResult;
	}

	public void setAuditedResult(String auditedResult) {
		this.auditedResult = auditedResult;
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

	public String getHomeRate() {
		return homeRate;
	}

	public void setHomeRate(String homeRate) {
		this.homeRate = homeRate;
	}

	public String getMachineCat() {
		return machineCat;
	}

	public void setMachineCat(String machineCat) {
		this.machineCat = machineCat;
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

	public String getPartType() {
		return partType;
	}

	public void setPartType(String partType) {
		this.partType = partType;
	}

	public String getResultMemo() {
		return resultMemo;
	}

	public void setResultMemo(String resultMemo) {
		this.resultMemo = resultMemo;
	}

	public String getServiceApplyType() {
		return serviceApplyType;
	}

	public void setServiceApplyType(String serviceApplyType) {
		this.serviceApplyType = serviceApplyType;
	}

	public String getServiceApplyTypeName() {
		return serviceApplyTypeName;
	}

	public void setServiceApplyTypeName(String serviceApplyTypeName) {
		this.serviceApplyTypeName = serviceApplyTypeName;
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

	public String getShopMemo() {
		return shopMemo;
	}

	public void setShopMemo(String shopMemo) {
		this.shopMemo = shopMemo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public String getTecRate() {
		return tecRate;
	}

	public void setTecRate(String tecRate) {
		this.tecRate = tecRate;
	}

	public String getCtime() {
		return ctime;
	}

	public void setCtime(String ctime) {
		this.ctime = ctime;
	}

	public String getCuser() {
		return cuser;
	}

	public void setCuser(String cuser) {
		this.cuser = cuser;
	}

	public String getCcompany() {
		return ccompany;
	}

	public void setCcompany(String ccompany) {
		this.ccompany = ccompany;
	}

	public String getMuser() {
		return muser;
	}

	public void setMuser(String muser) {
		this.muser = muser;
	}

	public String getReturnFlag() {
		return returnFlag;
	}

	public void setReturnFlag(String returnFlag) {
		this.returnFlag = returnFlag;
	}

	public String getReturnMemo() {
		return returnMemo;
	}

	public void setReturnMemo(String returnMemo) {
		this.returnMemo = returnMemo;
	}

	public String getReturnImprove() {
		return returnImprove;
	}

	public void setReturnImprove(String returnImprove) {
		this.returnImprove = returnImprove;
	}

	public String getVisitId() {
		return visitId;
	}

	public void setVisitId(String visitId) {
		this.visitId = visitId;
	}

	public String getVisitResult() {
		return visitResult;
	}

	public void setVisitResult(String visitResult) {
		this.visitResult = visitResult;
	}

	public String getReturnConfirm() {
		return returnConfirm;
	}

	public void setReturnConfirm(String returnConfirm) {
		this.returnConfirm = returnConfirm;
	}

	public String getServiceApplyNo() {
		return serviceApplyNo;
	}

	public void setServiceApplyNo(String serviceApplyNo) {
		this.serviceApplyNo = serviceApplyNo;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public String getBackMemo() {
		return backMemo;
	}

	public void setBackMemo(String backMemo) {
		this.backMemo = backMemo;
	}

	public List getFaultList() {
		return faultList;
	}

	public void setFaultList(List faultList) {
		this.faultList = faultList;
	}

	public List getServiceItemList() {
		return serviceItemList;
	}

	public void setServiceItemList(List serviceItemList) {
		this.serviceItemList = serviceItemList;
	}

	public List getServiceApplyFileList() {
		return serviceApplyFileList;
	}

	public void setServiceApplyFileList(List serviceApplyFileList) {
		this.serviceApplyFileList = serviceApplyFileList;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String serviceApplyInfo()
	{
		try {
			Map session = ActionContext.getContext().getSession();
			UserLogin ul = (UserLogin) session.get("LOGIN_INFO");
			Map param = new HashMap();
			param.put("UserLogin", ul);
			param.put("ServiceApplyId", WebUtil.filterSpecialCharacters(serviceApplyId));
			param.put("ServiceApplyType", WebUtil.filterSpecialCharacters(serviceApplyType));
			param.put("ServiceId", WebUtil.filterSpecialCharacters(serviceId));
			Map r = this.serviceApplyServices.serviceApplyInfo(param);
			String flag = (String)r.get("Flag");
			if(flag.equals("ERROR"))
			{
				message = (String)r.get("Message");
				return "error";
			}
			else
			{
				fileUploadUrl = WebConfigProperties.getProperties("file.upload.url");
				if(WebUtil.isNotNull(r.get("ServiceApplyId")))
					serviceApplyId=WebUtil.replaceSpecialCharacters(r.get("ServiceApplyId").toString());
				else 
					serviceApplyId = "";
				auditedResult=WebUtil.replaceSpecialCharacters((String) r.get("AuditedResult"));
				if(WebUtil.isNotNull(r.get("CompanyId")))
					companyId=WebUtil.replaceSpecialCharacters(r.get("CompanyId").toString());
				else 
					companyId = "";
				companyName=WebUtil.replaceSpecialCharacters((String) r.get("CompanyName"));
				if(WebUtil.isNotNull(r.get("HomeRate")))
					homeRate=WebUtil.round((BigDecimal)r.get("HomeRate")).toString();
				else
					homeRate = "";
				machineCat=WebUtil.replaceSpecialCharacters((String) r.get("MachineCat"));
				if(WebUtil.isNotNull(r.get("OtherRate")))
					otherRate=WebUtil.round((BigDecimal)r.get("OtherRate")).toString();
				else
					otherRate = "";
				otherRateMemo=WebUtil.replaceSpecialCharacters((String) r.get("OtherRateMemo"));
				partType=WebUtil.replaceSpecialCharacters((String) r.get("PartType"));
				resultMemo=WebUtil.replaceSpecialCharacters((String) r.get("ResultMemo"));
				serviceApplyType=(String) r.get("ServiceApplyType");
				serviceApplyTypeName=WebUtil.replaceSpecialCharacters((String) r.get("ServiceApplyTypeName"));
				if(WebUtil.isNotNull(r.get("ServiceId")))
					serviceId=WebUtil.replaceSpecialCharacters(r.get("ServiceId").toString());
				else
					serviceId = "";
				serviceNo=WebUtil.replaceSpecialCharacters((String) r.get("ServiceNo"));
				shopMemo=WebUtil.replaceSpecialCharacters((String) r.get("ShopMemo"));
				status=WebUtil.replaceSpecialCharacters((String) r.get("Status"));
				statusName=WebUtil.replaceSpecialCharacters((String) r.get("StatusName"));
				if(WebUtil.isNotNull(r.get("TecRate")))
					tecRate=WebUtil.round((BigDecimal)r.get("TecRate")).toString();
				else
					tecRate = "";
				if(WebUtil.isNotNull(r.get("Ctime")))
					ctime=WebUtil.formatDateString((Date)r.get("Ctime"), "yyyy-MM-dd HH:mm:ss");
				else
					ctime = "";
				cuser=WebUtil.replaceSpecialCharacters((String) r.get("Cuser"));
				ccompany=WebUtil.replaceSpecialCharacters((String) r.get("Ccompany"));
				//muser = WebUtil.replaceSpecialCharacters((String) r.get("Muser"));
				muser = WebUtil.replaceSpecialCharacters((String) r.get("ServiceApplyAuditedUser"));
				returnFlag=WebUtil.replaceSpecialCharacters((String) r.get("ReturnFlag"));
				returnMemo=WebUtil.replaceSpecialCharacters((String) r.get("ReturnMemo"));
				returnImprove=WebUtil.replaceSpecialCharacters((String) r.get("ReturnImprove"));
				returnConfirm=WebUtil.replaceSpecialCharacters((String) r.get("ReturnConfirm"));
				if(WebUtil.isNotNull(r.get("VisitId")))
					visitId =WebUtil.replaceSpecialCharacters( r.get("VisitId").toString());
				else
					visitId = null;
				visitResult = WebUtil.replaceSpecialCharacters((String) r.get("VisitResult"));
				serviceApplyNo = WebUtil.replaceSpecialCharacters((String) r.get("ServiceApplyNo"));
				serviceType = (String) r.get("ServiceType");
				backMemo = WebUtil.replaceSpecialCharacters((String) r.get("BackMemo"));
				faultList = (List) r.get("ServiceFaultList");
				serviceItemList = (List) r.get("ServiceItemList");
				serviceApplyFileList = (List) r.get("ServiceApplyFileList");
				message = null;
			}
		} catch (Exception e) {
			message = MessageInfo.OperationType;
			return "error";
		}
		return "success";
	}
	
	//保存零件退回信息
	public String saveReturnInfo()
	{
		try {
			Map session = ActionContext.getContext().getSession();
			UserLogin ul = (UserLogin) session.get("LOGIN_INFO");
			Map param = new HashMap();
			param.put("UserLogin", ul);
			param.put("ServiceApplyId", WebUtil.filterSpecialCharacters(serviceApplyId));
			param.put("ReturnFlag", WebUtil.filterSpecialCharacters(returnFlag));
			param.put("ReturnMemo", WebUtil.filterSpecialCharacters(returnMemo));
			param.put("ReturnImprove", WebUtil.filterSpecialCharacters(returnImprove));
			param.put("ReturnConfirm", WebUtil.filterSpecialCharacters(returnConfirm));
			Map r = this.serviceApplyServices.saveServiceApplyReturn(param);
			String flag = (String)r.get("Flag");
			if(flag.equals("ERROR"))
			{
				message = (String)r.get("Message");
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
