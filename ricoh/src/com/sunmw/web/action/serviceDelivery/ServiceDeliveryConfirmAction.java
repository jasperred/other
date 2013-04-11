package com.sunmw.web.action.serviceDelivery;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import com.opensymphony.xwork2.ActionContext;
import com.sunmw.web.bean.serviceOrder.ServiceDeliveryServices;
import com.sunmw.web.common.message.MessageInfo;
import com.sunmw.web.entity.UserLogin;
import com.sunmw.web.util.VerifyRequest;
import com.sunmw.web.util.WebUtil;

public class ServiceDeliveryConfirmAction {

	private ServiceDeliveryServices serviceDeliveryServices;

	private String serviceDeliveryInfo;

	private String message;
	private String crumb;
	
	public ServiceDeliveryServices getServiceDeliveryServices() {
		return serviceDeliveryServices;
	}

	public void setServiceDeliveryServices(
			ServiceDeliveryServices serviceDeliveryServices) {
		this.serviceDeliveryServices = serviceDeliveryServices;
	}

	public String getServiceDeliveryInfo() {
		return serviceDeliveryInfo;
	}

	public void setServiceDeliveryInfo(String serviceDeliveryInfo) {
		this.serviceDeliveryInfo = serviceDeliveryInfo;
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

	public String serviceDeliveryConfirmByScm()
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
			JSONObject sdi = JSONObject.fromObject(serviceDeliveryInfo);
			String serviceDeliveryId = sdi.getString("ServiceDeliveryId");
			if(WebUtil.isNull(serviceDeliveryId))
			{
				message = "发货ID没有";
				return "error";
			}
			param.put("ServiceDeliveryId", WebUtil.filterSpecialCharacters(serviceDeliveryId));
			param.put("Department", "SCM");
			param.put("ShippingNo", WebUtil.filterSpecialCharacters(sdi.getString("ShippingNo")));
			param.put("DeliveryStock", WebUtil.filterSpecialCharacters(sdi.getString("DeliveryStock")));
			param.put("DeliveryDate", WebUtil.filterSpecialCharacters(sdi.getString("DeliveryDate")));
			List<Map> itemList = (List)sdi.get("ServiceDeliveryItemList");
			List il = new ArrayList();
			if(!WebUtil.isNullForList(itemList))
			{
				for(Map<String,String> m:itemList)
				{
					m.put("ServiceDeliveryItemId", WebUtil.filterSpecialCharacters(m.get("ServiceDeliveryItemId")));
					m.put("ItemArrivalDate", WebUtil.filterSpecialCharacters(m.get("ItemArrivalDate")));
					m.put("ItemChange", WebUtil.filterSpecialCharacters(m.get("ItemChange")));
					m.put("ItemDeliveryDate", WebUtil.filterSpecialCharacters(m.get("ItemDeliveryDate")));
					m.put("HasInv", WebUtil.filterSpecialCharacters(m.get("HasInv")));
					m.put("ItemOrderDate", WebUtil.filterSpecialCharacters(m.get("ItemOrderDate")));
					m.put("ItemOrderNo", WebUtil.filterSpecialCharacters(m.get("ItemOrderNo")));
					m.put("NewItemNo", WebUtil.filterSpecialCharacters(m.get("NewItemNo")));
					il.add(m);
				}
			}
			param.put("ServiceDeliveryItemList", il);
			Map<String,String> r = serviceDeliveryServices.deliveryServiceOrder(param);
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
	
	public String serviceDeliveryWaitByScm()
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
			JSONObject sdi = JSONObject.fromObject(serviceDeliveryInfo);
			String serviceDeliveryId = sdi.getString("ServiceDeliveryId");
			if(WebUtil.isNull(serviceDeliveryId))
			{
				message = "发货ID没有";
				return "error";
			}
			param.put("ServiceDeliveryId", WebUtil.filterSpecialCharacters(serviceDeliveryId));
			param.put("Department", "SCM");
			param.put("ShippingNo", WebUtil.filterSpecialCharacters(sdi.getString("ShippingNo")));
			param.put("DeliveryStock", WebUtil.filterSpecialCharacters(sdi.getString("DeliveryStock")));
			param.put("DeliveryDate", WebUtil.filterSpecialCharacters(sdi.getString("DeliveryDate")));
			List<Map> itemList = (List)sdi.get("ServiceDeliveryItemList");
			List il = new ArrayList();
			if(!WebUtil.isNullForList(itemList))
			{
				for(Map<String,String> m:itemList)
				{
					m.put("ServiceDeliveryItemId", WebUtil.filterSpecialCharacters(m.get("ServiceDeliveryItemId")));
					m.put("ItemArrivalDate", WebUtil.filterSpecialCharacters(m.get("ItemArrivalDate")));
					m.put("ItemChange", WebUtil.filterSpecialCharacters(m.get("ItemChange")));
					m.put("ItemDeliveryDate", WebUtil.filterSpecialCharacters(m.get("ItemDeliveryDate")));
					m.put("HasInv", WebUtil.filterSpecialCharacters(m.get("HasInv")));
					m.put("ItemOrderDate", WebUtil.filterSpecialCharacters(m.get("ItemOrderDate")));
					m.put("ItemOrderNo", WebUtil.filterSpecialCharacters(m.get("ItemOrderNo")));
					m.put("NewItemNo", WebUtil.filterSpecialCharacters(m.get("NewItemNo")));
					il.add(m);
				}
			}
			param.put("ServiceDeliveryItemList", il);
			Map<String,String> r = serviceDeliveryServices.waitDeliveryServiceOrder(param);
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
	
	public String serviceDeliveryConfirmByCspc()
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
			JSONObject sdi = JSONObject.fromObject(serviceDeliveryInfo);
			String serviceDeliveryId = sdi.getString("ServiceDeliveryId");
			if(WebUtil.isNull(serviceDeliveryId))
			{
				message = "发货ID没有";
				return "error";
			}
			param.put("ServiceDeliveryId", WebUtil.filterSpecialCharacters(serviceDeliveryId));
			param.put("Department", "CSPC");
			param.put("ShippingNo", WebUtil.filterSpecialCharacters(sdi.getString("ShippingNo")));
			param.put("DeliveryStock", WebUtil.filterSpecialCharacters(sdi.getString("DeliveryStock")));
			param.put("DeliveryDate", WebUtil.filterSpecialCharacters(sdi.getString("DeliveryDate")));
			List<Map> itemList = (List)sdi.get("ServiceDeliveryItemList");
			List il = new ArrayList();
			if(!WebUtil.isNullForList(itemList))
			{
				for(Map<String,String> m:itemList)
				{
					m.put("ServiceDeliveryItemId", WebUtil.filterSpecialCharacters(m.get("ServiceDeliveryItemId")));
					m.put("ItemArrivalDate", WebUtil.filterSpecialCharacters(m.get("ItemArrivalDate")));
					m.put("ItemChange", WebUtil.filterSpecialCharacters(m.get("ItemChange")));
					m.put("ItemDeliveryDate", WebUtil.filterSpecialCharacters(m.get("ItemDeliveryDate")));
					m.put("HasInv", WebUtil.filterSpecialCharacters(m.get("HasInv")));
					m.put("ItemOrderDate", WebUtil.filterSpecialCharacters(m.get("ItemOrderDate")));
					m.put("ItemOrderNo", WebUtil.filterSpecialCharacters(m.get("ItemOrderNo")));
					m.put("NewItemNo", WebUtil.filterSpecialCharacters(m.get("NewItemNo")));
					il.add(m);
				}
			}
			param.put("ServiceDeliveryItemList", il);
			Map<String,String> r = serviceDeliveryServices.deliveryServiceOrder(param);
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
	
	public String serviceDeliveryWaitByCspc()
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
			JSONObject sdi = JSONObject.fromObject(serviceDeliveryInfo);
			String serviceDeliveryId = sdi.getString("ServiceDeliveryId");
			if(WebUtil.isNull(serviceDeliveryId))
			{
				message = "发货ID没有";
				return "error";
			}
			param.put("ServiceDeliveryId", WebUtil.filterSpecialCharacters(serviceDeliveryId));
			param.put("Department", "CSPC");
			param.put("ShippingNo", WebUtil.filterSpecialCharacters(sdi.getString("ShippingNo")));
			param.put("DeliveryStock", WebUtil.filterSpecialCharacters(sdi.getString("DeliveryStock")));
			param.put("DeliveryDate", WebUtil.filterSpecialCharacters(sdi.getString("DeliveryDate")));
			List<Map> itemList = (List)sdi.get("ServiceDeliveryItemList");
			List il = new ArrayList();
			if(!WebUtil.isNullForList(itemList))
			{
				for(Map<String,String> m:itemList)
				{
					m.put("ServiceDeliveryItemId", WebUtil.filterSpecialCharacters(m.get("ServiceDeliveryItemId")));
					m.put("ItemArrivalDate", WebUtil.filterSpecialCharacters(m.get("ItemArrivalDate")));
					m.put("ItemChange", WebUtil.filterSpecialCharacters(m.get("ItemChange")));
					m.put("ItemDeliveryDate", WebUtil.filterSpecialCharacters(m.get("ItemDeliveryDate")));
					m.put("HasInv", WebUtil.filterSpecialCharacters(m.get("HasInv")));
					m.put("ItemOrderDate", WebUtil.filterSpecialCharacters(m.get("ItemOrderDate")));
					m.put("ItemOrderNo", WebUtil.filterSpecialCharacters(m.get("ItemOrderNo")));
					m.put("NewItemNo", WebUtil.filterSpecialCharacters(m.get("NewItemNo")));
					il.add(m);
				}
			}
			param.put("ServiceDeliveryItemList", il);
			Map<String,String> r = serviceDeliveryServices.waitDeliveryServiceOrder(param);
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
