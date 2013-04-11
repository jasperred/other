package com.sunmw.web.action.serviceOrder;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;

import com.opensymphony.xwork2.ActionContext;
import com.sunmw.web.bean.serviceOrder.ServiceOrderServices;
import com.sunmw.web.common.message.MessageInfo;
import com.sunmw.web.entity.UserLogin;
import com.sunmw.web.util.WebConfigProperties;
import com.sunmw.web.util.WebUtil;

public class ServiceOrderFileUploadAction {
	private ServiceOrderServices serviceOrderServices;
	
	private File[] uploadFile;
	private String[] uploadFileFileName;
	private String[] uploadFileContentType;
	private String filePath;
	private String message;
	private String subDir;
	private String serviceOrderFileType;
	private String serviceId;
	private String serviceNo;
	private String machineNo;
	private String invoiceDate;

	public ServiceOrderServices getServiceOrderServices() {
		return serviceOrderServices;
	}

	public void setServiceOrderServices(ServiceOrderServices serviceOrderServices) {
		this.serviceOrderServices = serviceOrderServices;
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

	public String getServiceOrderFileType() {
		return serviceOrderFileType;
	}

	public void setServiceOrderFileType(String serviceOrderFileType) {
		this.serviceOrderFileType = serviceOrderFileType;
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

	public String getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
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
			if(WebUtil.isNull(filePath)||uploadFile==null||!uploadFile[0].exists()||uploadFile[0].length()>1048576L)
			{
				message = "文件上传失败,可能是文件大小超过限制";
				return "error";
			}
			if(WebUtil.isNull(serviceId))
			{
				message = "维修单ID没有传入";
				return "error";
			}
			if(WebUtil.isNull(serviceOrderFileType))
			{
				message = "附件上传类型没有传入";
				return "error";
			}
			String realpath = WebConfigProperties.getProperties(filePath);
			if(WebUtil.isNull(realpath))
			{
				message = "附件上传路径没有设置";
				return "error";
			}
			Map param = new HashMap();
			Map session = ActionContext.getContext().getSession();
			UserLogin ul = (UserLogin) session.get("LOGIN_INFO");
			param.put("UserLogin", ul);
			param.put("ServiceId", serviceId);
			String ff = uploadFileFileName[0].substring(uploadFileFileName[0].lastIndexOf("."),uploadFileFileName[0].length());//文件后缀
			//发票上传
			if(serviceOrderFileType.trim().equals("发票"))
			{
				if(WebUtil.isNull(invoiceDate))
				{
					message = "发票日期没有传入";
					return "error";
				}
				
				String p1 = realpath+"ServiceOrder//"+serviceNo.trim()+"//";
				String p2 = realpath+"Machine//"+machineNo.trim()+"//";
				File p1dir = new File(p1);
				if (!p1dir.exists()) {
					p1dir.mkdirs();
				}
				File p2dir = new File(p2);
				if (!p2dir.exists()) {
					p2dir.mkdirs();
				}
				File p1file = new File(p1dir, "发票"+ff);
				File p2file = new File(p2dir, "发票"+ff);
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
				if(p2file.exists())
				{
					boolean b = p2file.delete();
					if(!b)
					{
						System.gc();
						System.gc();
						p2file.delete();
					}
				}
				FileUtils.copyFile(uploadFile[0], p1file);
				FileUtils.copyFile(uploadFile[0], p2file);
				param.put("FileName", "发票"+ff);
				param.put("FileSize", p1file.length());
				param.put("FileUrl1", "ServiceOrder/"+serviceNo.trim()+"/发票"+ff);
				param.put("FileUrl2", "Machine/"+machineNo.trim()+"/发票"+ff);
				param.put("InvoiceDate", invoiceDate);
				Map r = serviceOrderServices.invoiceFileUpload(param);
				if(r.get("Flag").equals("ERROR"))
				{
					message = (String)r.get("Message");
					return "error";
				}
				else
				{
					serviceId = (String)r.get("ServiceId");
				}
			}
			//其它附件上传
			else
			{
				if(WebUtil.isNull(serviceNo))
				{
					message = "维修单号没有传入";
					return "error";
				}
				if(WebUtil.isNull(machineNo))
				{
					message = "机号没有传入";
					return "error";
				}
				String p1 = realpath+"ServiceOrder//"+serviceNo.trim()+"//";
				File p1dir = new File(p1);
				if (!p1dir.exists()) {
					p1dir.mkdirs();
				}
				File p1file = new File(p1dir, serviceOrderFileType.trim()+ff);
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
				param.put("FileName", serviceOrderFileType+ff);
				param.put("FileSize", p1file.length());
				param.put("FileUrl", "ServiceOrder/"+serviceNo.trim()+"/"+serviceOrderFileType+ff);
				param.put("FileType", serviceOrderFileType);
				Map r = serviceOrderServices.serviceOrderFileUpload(param);
				if(r.get("Flag").equals("ERROR"))
				{
					message = (String)r.get("Message");
					return "error";
				}
				else
				{
					serviceId = (String)r.get("ServiceId");
				}
			}
		} catch (Exception e) {
			message = MessageInfo.OperationType;
			return "error";
		}
		
		return "success";
	}}
