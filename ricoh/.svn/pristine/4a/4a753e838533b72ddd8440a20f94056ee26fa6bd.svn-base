package com.sunmw.web.action.login;

import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.sunmw.web.bean.login.UserServices;
import com.sunmw.web.common.message.MessageInfo;
import com.sunmw.web.entity.UserLogin;
import com.sunmw.web.util.VerifyRequest;
import com.sunmw.web.util.WebConfigProperties;
import com.sunmw.web.util.WebUtil;

public class UserInfoAction {

	private UserServices userServices;
	private int userId;
	private String userNo;
	private String userName;
	private int companyId;
	private String companyNo;
	private String companyName;
	private String companyStatus;
	private String email;
	private String enabled;
	private String password;
	private String newPassword;
	private String tecNo;
	private String message;
	private String crumb;

	public UserServices getUserServices() {
		return userServices;
	}

	public void setUserServices(UserServices userServices) {
		this.userServices = userServices;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getCompanyNo() {
		return companyNo;
	}

	public void setCompanyNo(String companyNo) {
		this.companyNo = companyNo;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyStatus() {
		return companyStatus;
	}

	public void setCompanyStatus(String companyStatus) {
		this.companyStatus = companyStatus;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public String getPassword() {
		return password;
	}

	public String getTecNo() {
		return tecNo;
	}

	public void setTecNo(String tecNo) {
		this.tecNo = tecNo;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
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

	public String updateUserInfo() {
		try {
			Map m = new HashMap();
			m.put("UserId", userId);
			m.put("Email", WebUtil.filterSpecialCharacters(email));
			m.put("UserName", WebUtil.filterSpecialCharacters(userName));
			m.put("Enabled", WebUtil.filterSpecialCharacters(enabled));
			m.put("CompanyId", companyId);
			m.put("TecNo", WebUtil.filterSpecialCharacters(tecNo));
			Map session = ActionContext.getContext().getSession();
			UserLogin ul = (UserLogin) session.get("LOGIN_INFO");
			String userNo = ul.getUserNo();		
			if(crumb==null||!VerifyRequest.verifyCrumb(userNo, crumb))
			{
				message = MessageInfo.Verify;
				return "error";
			}
			Map<String, String> r = userServices.updateUserLogin(m);
			String flag = r.get("FLAG");
			if (flag.equals("SUCCESS")) {

				message = r.get("UserId");
				return "success";
			} else {
				message = null;
				return "error";
			}
		} catch (Exception e) {
			message = null;
			return "error";
		}
	}

	public String getUserInfo() {
		try {
			if(userId<=0)
			{
				userNo = null;
				userName = null;
				email = null;
				companyId = -1;
				companyNo = null;
				companyName = null;
				companyStatus = null;
				tecNo = null;
				return "success";
			}
			Map session = ActionContext.getContext().getSession();
			//UserLogin ul2 = (UserLogin) session.get("LOGIN_INFO");
			Map m = this.userServices.getUserInfo(userId);
			if (m != null) {
				this.email = WebUtil.replaceSpecialCharacters((String)m.get("Email"));
				this.userName = WebUtil.replaceSpecialCharacters((String)m.get("UserName"));
				this.enabled = WebUtil.replaceSpecialCharacters((String)m.get("Enabled"));
				this.companyId = (Integer)m.get("CompanyId");
				this.companyNo = WebUtil.replaceSpecialCharacters((String)m.get("CompanyNo"));
				this.companyName = WebUtil.replaceSpecialCharacters((String)m.get("CompanyName"));
				this.companyStatus = WebUtil.replaceSpecialCharacters((String)m.get("CompanyStatus"));
				this.userNo = WebUtil.replaceSpecialCharacters((String)m.get("UserNo"));
				this.tecNo = WebUtil.replaceSpecialCharacters((String)m.get("TecNo"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "success";
	}

	public String newUser() {
		try {
			Map m = new HashMap();
			m.put("UserName", WebUtil.filterSpecialCharacters(userName));
			m.put("Email", WebUtil.filterSpecialCharacters(email));
			m.put("UserNo", WebUtil.filterSpecialCharacters(userNo));
			m.put("CompanyId", companyId);
			if(WebUtil.isNotNull(enabled))
			m.put("Enabled", WebUtil.filterSpecialCharacters(enabled.trim()));
			m.put("password", password);
			m.put("TecNo", WebUtil.filterSpecialCharacters(tecNo));
			Map session = ActionContext.getContext().getSession();
			UserLogin ul = (UserLogin) session.get("LOGIN_INFO");
			String userNo = ul.getUserNo();		
			if(crumb==null||!VerifyRequest.verifyCrumb(userNo, crumb))
			{
				message = MessageInfo.Verify;
				return "error";
			}
			Map<String, String> r = userServices.createUserLogin(m);
			String flag = r.get("FLAG");
			if (flag.equals("SUCCESS")) {

				message = r.get("UserId");
				return "success";
			} else {
				message = null;
				return "error";
			}
		} catch (Exception e) {
			message = null;
			return "error";
		}
	}

	public String modifyPassword() {
		try {
			Map m = new HashMap();
			m.put("UserId", userId);
			m.put("NewPassword", newPassword);
			m.put("Password", password);
			Map session = ActionContext.getContext().getSession();
			UserLogin ul = (UserLogin) session.get("LOGIN_INFO");
			Map<String, String> r = userServices.modifyPassowd(m);
			String flag = r.get("FLAG");
			if (flag.equals("SUCCESS")) {

				message = null;
				return "success";
			} else {
				message = r.get("MESSAGE");
				return "error";
			}
		} catch (Exception e) {
			message =null;
			return "error";
		}
	}
	
	//用户修改密码
	public String modifyPasswordByUser() {
		try {
			Map session = ActionContext.getContext().getSession();
			UserLogin ul = (UserLogin) session.get("LOGIN_INFO");
			Map m = new HashMap();
			m.put("UserId", ul.getId());
			m.put("NewPassword", newPassword);
			m.put("Password", password);
			Map<String, String> r = userServices.modifyPassowd(m);
			
			message = r.get("MESSAGE");
			if(r.get("FLAG").equals("SUCCESS"))
			{
				message = null;
				session.put("MODIFY_PWD", "N");
			}
			else
			{
				message = "操作错误";
			}
		} catch (Exception e) {
			message = MessageInfo.OperationType;
		}
		return "success";
	}
	
	//用户修改密码
	public String modifyPasswordByUserNo() {
		try {
			Map m = new HashMap();
			m.put("CompanyNo", companyNo);
			m.put("UserNo", userNo);
			m.put("NewPassword", newPassword);
			m.put("Password", password);
			Map<String, String> r = userServices.modifyPassowdByUserNo(m);
			
			message = r.get("MESSAGE");
			if(r.get("FLAG").equals("SUCCESS"))
			{
				message = null;
			}
			else
			{
				message = "操作错误";
			}
		} catch (Exception e) {
			message = MessageInfo.OperationType;
		}
		return "success";
	}
	
	public String resetPassword()
	{

		try {
			Map session = ActionContext.getContext().getSession();
			UserLogin ul = (UserLogin) session.get("LOGIN_INFO");
			Map m = new HashMap();
			m.put("UserId", userId);
			m.put("Password", WebConfigProperties.getProperties("web.password.reset"));
			Map<String, String> r = userServices.resetPassowd(m);
			
			message = r.get("MESSAGE");
			if(r.get("FLAG").equals("SUCCESS"))
			{
				message = null;
			}
		} catch (Exception e) {
			message = MessageInfo.OperationType;
		}
		return "success";
	
	}

	public String viewModifyPassword() {
		message = null;
		return "success";
	}
}
