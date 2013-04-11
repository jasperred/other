package com.sunmw.web.action.machine;

import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.sunmw.web.bean.machine.MachineServices;
import com.sunmw.web.common.message.MessageInfo;
import com.sunmw.web.entity.UserLogin;
import com.sunmw.web.util.VerifyRequest;
import com.sunmw.web.util.WebUtil;

public class MachineTypeInfoAction {

	private MachineServices machineServices;

	private String machineTypeId;
	private String machineType;
	private String machineCd;
	private String machineCat;
	private String serviceProviderType;
	private String rate1;
	private String rate2;
	private String cuser;
	private String ctime;

	private String message;
	private String crumb;

	public MachineServices getMachineServices() {
		return machineServices;
	}

	public void setMachineServices(MachineServices machineServices) {
		this.machineServices = machineServices;
	}

	public String getMachineTypeId() {
		return machineTypeId;
	}

	public void setMachineTypeId(String machineTypeId) {
		this.machineTypeId = machineTypeId;
	}

	public String getMachineType() {
		return machineType;
	}

	public void setMachineType(String machineType) {
		this.machineType = machineType;
	}

	public String getMachineCd() {
		return machineCd;
	}

	public void setMachineCd(String machineCd) {
		this.machineCd = machineCd;
	}

	public String getMachineCat() {
		return machineCat;
	}

	public void setMachineCat(String machineCat) {
		this.machineCat = machineCat;
	}

	public String getServiceProviderType() {
		return serviceProviderType;
	}

	public void setServiceProviderType(String serviceProviderType) {
		this.serviceProviderType = serviceProviderType;
	}

	public String getRate1() {
		return rate1;
	}

	public void setRate1(String rate1) {
		this.rate1 = rate1;
	}

	public String getRate2() {
		return rate2;
	}

	public void setRate2(String rate2) {
		this.rate2 = rate2;
	}

	public String getCuser() {
		return cuser;
	}

	public void setCuser(String cuser) {
		this.cuser = cuser;
	}

	public String getCtime() {
		return ctime;
	}

	public void setCtime(String ctime) {
		this.ctime = ctime;
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

	public String machineTypeInfo() {

		try {
			machineTypeId = WebUtil.filterSpecialCharacters(machineTypeId);
			if(WebUtil.isNull(machineTypeId))
			{
				this.machineTypeId = " ";
				this.machineType = null;
				this.machineCd = null;
				this.machineCat = null;
				this.serviceProviderType = null;
				this.rate1 = null;
				this.rate2 = null;
				this.ctime = null;
				this.cuser = null;
				return "success";
			}
			Map<String, String> m = machineServices
					.getMachineTypeInfo(machineTypeId);

			if (m == null)
				return "success";
			this.machineTypeId = WebUtil.replaceSpecialCharacters(m.get("MachineTypeId"));
			this.machineType = WebUtil.replaceSpecialCharacters(m.get("MachineType"));
			this.machineCd = WebUtil.replaceSpecialCharacters(m.get("MachineCd"));
			this.machineCat = WebUtil.replaceSpecialCharacters(m.get("MachineCat"));
			this.serviceProviderType = WebUtil.replaceSpecialCharacters(m.get("ServiceProviderType"));
			this.rate1 = WebUtil.replaceSpecialCharacters(m.get("Rate1"));
			this.rate2 = WebUtil.replaceSpecialCharacters(m.get("Rate2"));
			this.ctime = WebUtil.replaceSpecialCharacters(m.get("Ctime"));
			this.cuser = WebUtil.replaceSpecialCharacters(m.get("Cuser"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "success";
	}

	public String saveMachineType() {
		try {
			Map session = ActionContext.getContext().getSession();
			UserLogin ul = (UserLogin) session.get("LOGIN_INFO");
			String userNo = ul.getUserNo();		
			if(crumb==null||!VerifyRequest.verifyCrumb(userNo, crumb))
			{
				message = MessageInfo.Verify;
				return "success";
			}
			Map param = new HashMap();
			param.put("MachineTypeId", WebUtil.filterSpecialCharacters(machineTypeId));
			param.put("MachineType", WebUtil.filterSpecialCharacters(machineType));
			param.put("MachineCd", WebUtil.filterSpecialCharacters(machineCd));
			param.put("MachineCat", WebUtil.filterSpecialCharacters(machineCat));
			param.put("ServiceProviderType", WebUtil.filterSpecialCharacters(serviceProviderType));
			param.put("Rate1", WebUtil.filterSpecialCharacters(rate1));
			param.put("Rate2", WebUtil.filterSpecialCharacters(rate2));
			param.put("UserName", ul.getUserName());
			Integer i = machineServices.saveMachineType(param);
			if (i == null)
				this.message = "";
			else {
				this.message = i.toString();
			}
		} catch (Exception e) {
			message = "";
		}
		return "success";
	}

	public String checkMachineNo() {
		try {
			machineCd = WebUtil.filterSpecialCharacters(machineCd);
			message = machineServices.checkMachineCd(machineCd);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "success";
	}

	public String deleteMachineType() {
		try {
			Map session = ActionContext.getContext().getSession();
			UserLogin ul = (UserLogin)session.get("LOGIN_INFO");
			if(ul==null)
				return "success";
			String userNo = ul.getUserNo();		
			if(crumb==null||!VerifyRequest.verifyCrumb(userNo, crumb))
			{
				message = MessageInfo.Verify;
				return "success";
			}
			machineTypeId = WebUtil.filterSpecialCharacters(machineTypeId);
			boolean b = machineServices.deleteMachineType(machineTypeId);
			if (b)
				this.message = "success";
			else
				this.message = "error";
		} catch (Exception e) {
			this.message = "error";
		}
		return "success";
	}

}
