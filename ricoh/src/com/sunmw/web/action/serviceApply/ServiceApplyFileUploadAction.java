package com.sunmw.web.action.serviceApply;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;

import com.opensymphony.xwork2.ActionContext;
import com.sunmw.web.bean.serviceOrder.ServiceApplyServices;
import com.sunmw.web.common.message.MessageInfo;
import com.sunmw.web.entity.UserLogin;
import com.sunmw.web.util.WebConfigProperties;
import com.sunmw.web.util.WebUtil;

public class ServiceApplyFileUploadAction {
	private ServiceApplyServices serviceApplyServices;

	private File[] uploadFile;
	private String[] uploadFileFileName;
	private String[] uploadFileContentType;
	private String filePath;
	private String message;
	private String subDir;
	private String serviceApplyFileType;
	private String serviceApplyId;

	public ServiceApplyServices getServiceApplyServices() {
		return serviceApplyServices;
	}

	public void setServiceApplyServices(ServiceApplyServices serviceApplyServices) {
		this.serviceApplyServices = serviceApplyServices;
	}

	public String getServiceApplyFileType() {
		return serviceApplyFileType;
	}

	public void setServiceApplyFileType(String serviceApplyFileType) {
		this.serviceApplyFileType = serviceApplyFileType;
	}

	public String getServiceApplyId() {
		return serviceApplyId;
	}

	public void setServiceApplyId(String serviceApplyId) {
		this.serviceApplyId = serviceApplyId;
	}

	public File[] getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(File[] uploadFile) {
		this.uploadFile = uploadFile;
	}

	public String[] getUploadFileFileName() {
		return uploadFileFileName;
	}

	public void setUploadFileFileName(String[] uploadFileFileName) {
		this.uploadFileFileName = uploadFileFileName;
	}

	public String[] getUploadFileContentType() {
		return uploadFileContentType;
	}

	public void setUploadFileContentType(String[] uploadFileContentType) {
		this.uploadFileContentType = uploadFileContentType;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getSubDir() {
		return subDir;
	}

	public void setSubDir(String subDir) {
		this.subDir = subDir;
	}


	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	// 文件上传
	public String fileUpload() throws Exception {
		try {
			System.gc();
			System.gc();
			if (WebUtil.isNull(filePath) || uploadFile == null
					|| !uploadFile[0].exists()) {
				message = "文件上传失败,可能是文件大小超过限制";
				return "error";
			}
			if (WebUtil.isNull(serviceApplyId)) {
				message = "维修单申请ID没有传入";
				return "error";
			}
			if (WebUtil.isNull(serviceApplyFileType)) {
				message = "维修单申请附件类型没有传入";
				return "error";
			}
			String realpath = WebConfigProperties.getProperties(filePath);
			Map param = new HashMap();
			Map session = ActionContext.getContext().getSession();
			UserLogin ul = (UserLogin) session.get("LOGIN_INFO");
			param.put("UserLogin", ul);
			param.put("ServiceApplyId", serviceApplyId);
			param.put("FileType", serviceApplyFileType);
			String ff = uploadFileFileName[0].substring(uploadFileFileName[0]
					.lastIndexOf("."), uploadFileFileName[0].length());// 文件后缀
			// 发票上传

			String p1 = realpath + "ServiceApply//" + serviceApplyId.trim() + "//";
			File p1dir = new File(p1);
			if (!p1dir.exists()) {
				p1dir.mkdirs();
			}
			File p1file = new File(p1dir, serviceApplyFileType+ ff);
			if(p1file.exists())
			{
				boolean b = p1file.delete();
				if(!b)
				{
					System.gc();
					System.gc();
					p1file.delete();
				}
			}
			FileUtils.copyFile(uploadFile[0], p1file);
			param.put("FileName", serviceApplyFileType+ ff);
			param.put("FileSize", p1file.length());
			param.put("FileUrl", "ServiceApply/" + serviceApplyId.trim() + "/" +serviceApplyFileType+ ff);
			Map r = serviceApplyServices.serviceApplyFileUpload(param);
			if (r.get("Flag").equals("ERROR")) {
				message = (String) r.get("Message");
				return "error";
			} else {
				serviceApplyId = (String) r.get("ServiceApplyId");
			}
		} catch (Exception e) {
			message = MessageInfo.OperationType;
			return "error";
		}

		return "success";
	}
}
