package com.sunmw.web.action.common;

import java.io.File;

import org.apache.commons.io.FileUtils;

import com.opensymphony.xwork2.ActionContext;
import com.sunmw.web.common.message.MessageInfo;
import com.sunmw.web.util.WebConfigProperties;
import com.sunmw.web.util.WebUtil;

public class FileUploadAction {

	private File[] uploadFile;
	private String[] uploadFileFileName;
	private String[] uploadFileContentType;
	private String filePath;
	private String[] deleteFileName;
	private String message;
	private String subDir;

	

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

	public String[] getDeleteFileName() {
		return deleteFileName;
	}

	public void setDeleteFileName(String[] deleteFileName) {
		this.deleteFileName = deleteFileName;
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
			if(WebUtil.isNull(filePath)||uploadFile==null||!uploadFile[0].exists())
			{
				message = "文件上传失败,可能是文件大小超过限制";
				return "error";
			}
			String realpath = WebConfigProperties.getProperties(filePath);
			if(subDir!=null&&subDir.trim().length()>0)
				realpath += subDir+"\\";
			if (uploadFile != null) {
				File savedir = new File(realpath);
				if (!savedir.exists()) {
					savedir.mkdirs();
				}
				for (int i = 0; i < uploadFile.length; i++) {

					System.out.println("imageContentType[" + i + "] = "
							+ uploadFileContentType[i]);
					File savefile = new File(savedir, uploadFileFileName[i]);
					if(!uploadFile[i].exists())
						continue;
					if(savefile.exists())
					{
						boolean b = savefile.delete();
						if(!b)
						{
							System.gc();
							System.gc();
							savefile.delete();
						}
					}
					FileUtils.copyFile(uploadFile[i], savefile);
				}
				ActionContext.getContext().put("message", "上传成功");
			}
		} catch (Exception e) {
			message = MessageInfo.OperationType;
			return "error";
		}
		return "success";
	}
	
	//文件删除
	public String fileDelete()
	{
		try {
			System.gc();
			System.gc();
			String realpath = WebConfigProperties.getProperties(filePath);
			for(String df:deleteFileName)
			{
				if(subDir!=null&&subDir.trim().length()>0)
					realpath += subDir+"\\";
				File f = new File(realpath+df);
				if(f.exists())
				{
					boolean b = f.delete();
					if(!b)
					{
						System.gc();
						System.gc();
						f.delete();
					}
				}
			}
			message = "success";
		} catch (Exception e) {
			message = MessageInfo.OperationType;
		}
		return "success";
	}

}
