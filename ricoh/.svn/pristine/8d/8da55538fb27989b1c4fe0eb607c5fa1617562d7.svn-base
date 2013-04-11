package com.sunmw.web.action.module;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.sunmw.web.bean.module.ModuleServices;
import com.sunmw.web.common.message.MessageInfo;
import com.sunmw.web.entity.ModuleConfig;
import com.sunmw.web.entity.UserLogin;
import com.sunmw.web.util.VerifyRequest;
import com.sunmw.web.util.WebUtil;

public class ModuleAction {
	
	private ModuleServices moduleServices;
	
	private int moduleId;
	private int parentModuleId;
	private int sequence;
	private String moduleName;
	private String moduleAlias;
	private String showMenu;
	private String url;
	private String message;
	private String crumb;
	
	private List menuList;
	
	public ModuleServices getModuleServices() {
		return moduleServices;
	}

	public void setModuleServices(ModuleServices moduleServices) {
		this.moduleServices = moduleServices;
	}

	public int getModuleId() {
		return moduleId;
	}

	public void setModuleId(int moduleId) {
		this.moduleId = moduleId;
	}

	public int getParentModuleId() {
		return parentModuleId;
	}

	public void setParentModuleId(int parentModuleId) {
		this.parentModuleId = parentModuleId;
	}

	public int getSequence() {
		return sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public String getModuleAlias() {
		return moduleAlias;
	}

	public void setModuleAlias(String moduleAlias) {
		this.moduleAlias = moduleAlias;
	}

	public String getShowMenu() {
		return showMenu;
	}

	public void setShowMenu(String showMenu) {
		this.showMenu = showMenu;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List getMenuList() {
		return menuList;
	}

	public void setMenuList(List menuList) {
		this.menuList = menuList;
	}

	public String getCrumb() {
		return crumb;
	}

	public void setCrumb(String crumb) {
		this.crumb = crumb;
	}

	//新增和保存菜单
	public String saveModule()
	{
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
			param.put("moduleId", moduleId);
			param.put("parentModuleId", parentModuleId);
			param.put("sequence", sequence);
			param.put("moduleName", WebUtil.filterSpecialCharacters(moduleName));
			param.put("moduleAlias", WebUtil.filterSpecialCharacters(moduleAlias));
			param.put("showMenu", WebUtil.filterSpecialCharacters(showMenu));
			param.put("url", WebUtil.filterSpecialCharacters(url));
			String s = moduleServices.saveModule(param, ""+ul.getId());
			if("success".equals(s))
				message = null;
			else
				message = s;
		} catch (Exception e) {
			message = null;
		}
		return "success";
	}
	
	//删除菜单
	public String deleteModule()
	{
		try {
			Map session = ActionContext.getContext().getSession();
			UserLogin ul = (UserLogin) session.get("LOGIN_INFO");
			String userNo = ul.getUserNo();		
			if(crumb==null||!VerifyRequest.verifyCrumb(userNo, crumb))
			{
				message = MessageInfo.Verify;
				return "success";
			}
			String s = moduleServices.deleteModule(moduleId, ""+ul.getId());
			if("success".equals(s))
				message = "success";
			else
				message = s;
		} catch (Exception e) {
			message = MessageInfo.OperationType;
		}
		return "success";
	}
	
	//得到菜单信息
	public String getModuleInfo()
	{
		try {
			if(moduleId==0)
			{
				parentModuleId = 0;
				sequence = 0;
				moduleName = null;
				moduleAlias = null;
				showMenu = null;
				url = null;
			}
			else
			{
				ModuleConfig mc = moduleServices.getModuleConfigInfo(moduleId);
				if(mc!=null)
				{
					parentModuleId = mc.getParentModuleId();
					sequence = mc.getSequence();
					moduleName = mc.getModuleName();
					moduleAlias = mc.getModuleAlias();
					showMenu = mc.getShowMenu();
					url = mc.getUrl();
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "success";
	}
	
	//显示菜单页
	public String viewModule()
	{
		return "success";
	}

	//得到菜单列表
	public void menuList()
	{
		try {
			this.menuList = moduleServices.getMenuList();
		} catch (Exception e) {
			this.menuList = null;
		}
	}
}
