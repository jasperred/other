package com.sunmw.web.action.serviceOrder;

import java.util.List;

import com.sunmw.web.bean.base.BaseServices;
import com.sunmw.web.entity.Unit;
import com.sunmw.web.util.WebUtil;

public class FaultAndPartAction {
	private BaseServices baseServices;
	
	
	private List<Unit> symptomList;//故障现象
	private List<Unit> actionList;//故障措施
	private List<Unit> causeList;//故障原因
	private List<Unit> locationList;//故障部位
	private List<Unit> targetList;//故障零件
	
	private String parentNo;
	private String faultType;
	private List<Unit> childList;//子类列表

	public BaseServices getBaseServices() {
		return baseServices;
	}

	public void setBaseServices(BaseServices baseServices) {
		this.baseServices = baseServices;
	}


	public List<Unit> getSymptomList() {
		return symptomList;
	}

	public void setSymptomList(List<Unit> symptomList) {
		this.symptomList = symptomList;
	}

	public List<Unit> getActionList() {
		return actionList;
	}

	public void setActionList(List<Unit> actionList) {
		this.actionList = actionList;
	}

	public List<Unit> getCauseList() {
		return causeList;
	}

	public void setCauseList(List<Unit> causeList) {
		this.causeList = causeList;
	}

	public List<Unit> getLocationList() {
		return locationList;
	}

	public void setLocationList(List<Unit> locationList) {
		this.locationList = locationList;
	}

	public List<Unit> getTargetList() {
		return targetList;
	}

	public void setTargetList(List<Unit> targetList) {
		this.targetList = targetList;
	}

	public String getParentNo() {
		return parentNo;
	}

	public void setParentNo(String parentNo) {
		this.parentNo = parentNo;
	}

	public String getFaultType() {
		return faultType;
	}

	public void setFaultType(String faultType) {
		this.faultType = faultType;
	}

	public List<Unit> getChildList() {
		return childList;
	}

	public void setChildList(List<Unit> childList) {
		this.childList = childList;
	}

	public void symptomList()
	{
		try {
			symptomList = baseServices.getTreeUnit("SYMPTOM", "0");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void actionList()
	{
		try {
			actionList = baseServices.getTreeUnit("ACTION", "0");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void causeList()
	{
		try {
			causeList = baseServices.getTreeUnit("CAUSE", "0");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void locationList()
	{
		try {
			locationList = baseServices.getTreeUnit("LOCATION", "0");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void targetList()
	{
		try {
			targetList = baseServices.getTreeUnit("TARGET", "0");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String childList()
	{
		try {
			faultType = WebUtil.filterSpecialCharacters(faultType);
			parentNo = WebUtil.filterSpecialCharacters(parentNo);
			this.childList = baseServices.getTreeUnit(faultType, parentNo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "success";
	}
}
