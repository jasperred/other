package com.sunmw.web.action.serviceOrder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import com.opensymphony.xwork2.ActionContext;
import com.sunmw.web.bean.serviceOrder.ServiceOrderServices;
import com.sunmw.web.common.message.MessageInfo;
import com.sunmw.web.entity.UserLogin;
import com.sunmw.web.util.VerifyRequest;
import com.sunmw.web.util.WebUtil;

public class ServiceOrderInfoSaveAction {

	private ServiceOrderServices serviceOrderServices;
	private String serviceOrderInfo;
	private String serviceOrderItemInfo;
	private String message;
	private String crumb;
	
	public ServiceOrderServices getServiceOrderServices() {
		return serviceOrderServices;
	}

	public void setServiceOrderServices(ServiceOrderServices serviceOrderServices) {
		this.serviceOrderServices = serviceOrderServices;
	}

	public String getServiceOrderInfo() {
		return serviceOrderInfo;
	}

	public void setServiceOrderInfo(String serviceOrderInfo) {
		this.serviceOrderInfo = serviceOrderInfo;
	}

	public String getServiceOrderItemInfo() {
		return serviceOrderItemInfo;
	}

	public void setServiceOrderItemInfo(String serviceOrderItemInfo) {
		this.serviceOrderItemInfo = serviceOrderItemInfo;
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

	public String saveServiceOrderInfo()
	{
		try {
			JSONObject soi = JSONObject.fromObject(serviceOrderInfo);
			String serviceId = soi.getString("ServiceId");
			if(WebUtil.isNull(serviceId))
			{
				message = "维修单ID没有";
				return "error";
			}
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
			param.put("ServiceId",WebUtil.filterSpecialCharacters(serviceId));
			param.put("ServiceType",WebUtil.filterSpecialCharacters((String)soi.get("ServiceType")));
			param.put("ServiceDate",WebUtil.filterSpecialCharacters((String)soi.get("ServiceDate")));
			param.put("FromDate",WebUtil.filterSpecialCharacters((String)soi.get("FromDate")));
			param.put("EndDate",WebUtil.filterSpecialCharacters((String)soi.get("EndDate")));
			param.put("ServiceExpectedFinishDate",WebUtil.filterSpecialCharacters((String)soi.get("ServiceExpectedFinishDate")));
			param.put("ServiceMethod",WebUtil.filterSpecialCharacters((String)soi.get("ServiceMethod")));
			param.put("ServiceContract",WebUtil.filterSpecialCharacters((String)soi.get("ServiceContract")));
			param.put("ServiceOperation",WebUtil.filterSpecialCharacters((String)soi.get("ServiceOperation")));
			param.put("BlackWhiteNumber",WebUtil.filterSpecialCharacters((String)soi.get("BlackWhiteNumber")));
			param.put("ColorNumber",WebUtil.filterSpecialCharacters((String)soi.get("ColorNumber")));
			param.put("PlateNumber",WebUtil.filterSpecialCharacters((String)soi.get("PlateNumber")));
			param.put("PartOrMachine",WebUtil.filterSpecialCharacters((String)soi.get("PartOrMachine")));
			param.put("MachineMemo",WebUtil.filterSpecialCharacters((String)soi.get("MachineMemo")));
			param.put("CustomerCompany",WebUtil.filterSpecialCharacters((String)soi.get("CustomerCompany")));
			param.put("CustomerNo",WebUtil.filterSpecialCharacters((String)soi.get("CustomerNo")));
			param.put("CustomerZip",WebUtil.filterSpecialCharacters((String)soi.get("CustomerZip")));
			param.put("CustomerAddress1",WebUtil.filterSpecialCharacters((String)soi.get("CustomerAddress1")));
			param.put("CustomerAddress2",WebUtil.filterSpecialCharacters((String)soi.get("CustomerAddress2")));
			param.put("CustomerAddress3",WebUtil.filterSpecialCharacters((String)soi.get("CustomerAddress3")));
			param.put("CustomerAddress4",WebUtil.filterSpecialCharacters((String)soi.get("CustomerAddress4")));
			param.put("CustomerAddress5",WebUtil.filterSpecialCharacters((String)soi.get("CustomerAddress5")));
			param.put("CustomerName",WebUtil.filterSpecialCharacters((String)soi.get("CustomerName")));
			param.put("CustomerTel",WebUtil.filterSpecialCharacters((String)soi.get("CustomerTel")));
			param.put("ServiceAmt",WebUtil.filterSpecialCharacters((String)soi.get("ServiceAmt")));
			param.put("HomeAmt",WebUtil.filterSpecialCharacters((String)soi.get("HomeAmt")));
			param.put("PartsAmt",WebUtil.filterSpecialCharacters((String)soi.get("PartsAmt")));
			param.put("ConsumablesAmt",WebUtil.filterSpecialCharacters((String)soi.get("ConsumablesAmt")));
			param.put("OtherAmt",WebUtil.filterSpecialCharacters((String)soi.get("OtherAmt")));
			param.put("OtherAmtMemo",WebUtil.filterSpecialCharacters((String)soi.get("OtherAmtMemo")));
			param.put("ServiceFinishDate",WebUtil.filterSpecialCharacters((String)soi.get("ServiceFinishDate")));
			param.put("ServiceResult",WebUtil.filterSpecialCharacters((String)soi.get("ServiceResult")));
			param.put("FixPeople",WebUtil.filterSpecialCharacters((String)soi.get("FixPeople")));
			param.put("CustomerRetrieveDate",WebUtil.filterSpecialCharacters((String)soi.get("CustomerRetrieveDate")));
			param.put("Memo",WebUtil.filterSpecialCharacters((String)soi.get("Memo")));
			param.put("ApplyHomeRate",WebUtil.filterSpecialCharacters((String)soi.get("ApplyHomeRate")));
			param.put("ApplyOtherRate",WebUtil.filterSpecialCharacters((String)soi.get("ApplyOtherRate")));
			param.put("ApplyOtherRateMemo",WebUtil.filterSpecialCharacters((String)soi.get("ApplyOtherRateMemo")));
			List<Map> fl = (List)soi.get("FaultList");
			List<Map> pml = (List)soi.get("PartOrMachineList");
			List<Map> faultList = new ArrayList();
			List<Map> partList = new ArrayList();
			if(!WebUtil.isNullForList(fl))
			{
				for(Map<String,String> f:fl)
				{
					f.put("ServiceFaultId", WebUtil.filterSpecialCharacters(f.get("ServiceFaultId")));
					f.put("FaultCateNo", WebUtil.filterSpecialCharacters(f.get("FaultCateNo")));
					f.put("FaultNo", WebUtil.filterSpecialCharacters(f.get("FaultNo")));
					f.put("FaultType", WebUtil.filterSpecialCharacters(f.get("FaultType")));
					f.put("FaultName", WebUtil.filterSpecialCharacters(f.get("FaultName")));
					f.put("MustMemo", WebUtil.filterSpecialCharacters(f.get("MustMemo")));
					f.put("Memo", WebUtil.filterSpecialCharacters(f.get("Memo")));
					f.put("Content", WebUtil.filterSpecialCharacters(f.get("Content")));
					faultList.add(f);
				}
			}
			if(!WebUtil.isNullForList(pml))
			{
				for(Map<String,String> p:pml)
				{
					p.put("ServiceItemId", WebUtil.filterSpecialCharacters(p.get("ServiceItemId")));
					p.put("ItemCate", WebUtil.filterSpecialCharacters(p.get("ItemCate")));
					p.put("ItemNo", WebUtil.filterSpecialCharacters(p.get("ItemNo")));
					p.put("ItemQty", WebUtil.filterSpecialCharacters(p.get("ItemQty")));
					p.put("ItemName", WebUtil.filterSpecialCharacters(p.get("ItemName")));
					p.put("ItemSerialNo", WebUtil.filterSpecialCharacters(p.get("ItemSerialNo")));
					p.put("ItemType", WebUtil.filterSpecialCharacters(p.get("ItemType")));
					p.put("ItemStatus", WebUtil.filterSpecialCharacters(p.get("ItemStatus")));
					partList.add(p);
				}
			}
			param.put("FaultList", faultList);
			param.put("PartOrMachineList", partList);
			Map<String,String> r = serviceOrderServices.saveServiceOrder(param);
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
			return "success";
		} catch (Exception e) {
			message = MessageInfo.OperationType;
			return "error";
		}
	}
	
	public String saveServiceOrderItem()
	{
		try {
			JSONObject soi = JSONObject.fromObject(serviceOrderItemInfo);
			String serviceId = (String)soi.get("ServiceId");
			if(WebUtil.isNull(serviceId))
			{
				message = "维修单ID没有";
				return "error";
			}
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
			param.put("ServiceId",serviceId);
			//List fl = (List)soi.get("FaultList");
			List<Map> pml = (List)soi.get("PartOrMachineList");
			List<Map> faultList = new ArrayList();
			List<Map> partList = new ArrayList();
			if(!WebUtil.isNullForList(pml))
			{
				for(Map<String,String> p:pml)
				{
					p.put("ServiceItemId", WebUtil.filterSpecialCharacters(p.get("ServiceItemId")));
					p.put("ItemCate", WebUtil.filterSpecialCharacters(p.get("ItemCate")));
					p.put("ItemNo", WebUtil.filterSpecialCharacters(p.get("ItemNo")));
					p.put("ItemQty", WebUtil.filterSpecialCharacters(p.get("ItemQty")));
					p.put("ItemName", WebUtil.filterSpecialCharacters(p.get("ItemName")));
					p.put("ItemSerialNo", WebUtil.filterSpecialCharacters(p.get("ItemSerialNo")));
					p.put("ItemType", WebUtil.filterSpecialCharacters(p.get("ItemType")));
					p.put("ItemStatus", WebUtil.filterSpecialCharacters(p.get("ItemStatus")));
					partList.add(p);
				}
			}
			//param.put("FaultList", fl);
			param.put("PartOrMachineList", partList);
			Map<String,String> r = serviceOrderServices.saveServiceOrderItem(param);
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
