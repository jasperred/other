package com.sunmw.web.action.serviceInvoice;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;

import com.opensymphony.xwork2.ActionContext;
import com.sunmw.web.bean.invoice.ServiceInvoiceServices;
import com.sunmw.web.common.message.MessageInfo;
import com.sunmw.web.entity.UserLogin;
import com.sunmw.web.util.WebConfigProperties;
import com.sunmw.web.util.WebUtil;

public class InvoiceFileUploadAction {
	private ServiceInvoiceServices invoiceServices;

	private File[] uploadFile;
	private String[] uploadFileFileName;
	private String[] uploadFileContentType;
	private String filePath;
	private String message;
	private String subDir;
	private String serviceOrderFileType;
	private String invoiceId;

	public ServiceInvoiceServices getInvoiceServices() {
		return invoiceServices;
	}

	public void setInvoiceServices(ServiceInvoiceServices invoiceServices) {
		this.invoiceServices = invoiceServices;
	}

	public String getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(String invoiceId) {
		this.invoiceId = invoiceId;
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
			if (WebUtil.isNull(invoiceId)) {
				message = "维修单结算ID没有传入";
				return "error";
			}
			String realpath = WebConfigProperties.getProperties(filePath);
			Map param = new HashMap();
			Map session = ActionContext.getContext().getSession();
			UserLogin ul = (UserLogin) session.get("LOGIN_INFO");
			param.put("UserLogin", ul);
			param.put("InvoiceId", invoiceId);
			String ff = uploadFileFileName[0].substring(uploadFileFileName[0]
					.lastIndexOf("."), uploadFileFileName[0].length());// 文件后缀
			// 发票上传

			String p1 = realpath + "Invoice//" ;
			File p1dir = new File(p1);
			if (!p1dir.exists()) {
				p1dir.mkdirs();
			}
			File p1file = new File(p1dir, invoiceId.trim() +ff);
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
			param.put("FileName", invoiceId.trim() +ff);
			param.put("FileSize", p1file.length());
			param.put("FileUrl", "Invoice/" + invoiceId.trim() + ff);
			Map r = invoiceServices.invoiceFileUpload(param);
			if (r.get("Flag").equals("ERROR")) {
				message = (String) r.get("Message");
				return "error";
			} else {
				invoiceId = (String) r.get("InvoiceId");
			}
		} catch (Exception e) {
			message = MessageInfo.OperationType;
			return "error";
		}

		return "success";
	}
}
