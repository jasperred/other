package com.sunmw.web.action.machine;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import au.com.bytecode.opencsv.CSVReader;

import com.opensymphony.xwork2.ActionContext;
import com.sunmw.web.bean.machine.MachineImportServices;
import com.sunmw.web.entity.UserLogin;
import com.sunmw.web.util.WebConfigProperties;
import com.sunmw.web.util.WebUtil;

public class MachineImportAction {
	
	private MachineImportServices machineImportServices;
	
	private List exceedFileList;
	private List serviceRateFileList;
	private List companyMachineTypeRefFileList;
	
	private String exceedFileName;
	private String serviceRateFileName;
	private String companyMachineTypeRefFileName;
	private List messageList;
	
	
	public MachineImportServices getMachineImportServices() {
		return machineImportServices;
	}

	public void setMachineImportServices(MachineImportServices machineImportServices) {
		this.machineImportServices = machineImportServices;
	}

	public List getExceedFileList() {
		return exceedFileList;
	}

	public void setExceedFileList(List exceedFileList) {
		this.exceedFileList = exceedFileList;
	}

	public List getServiceRateFileList() {
		return serviceRateFileList;
	}

	public void setServiceRateFileList(List serviceRateFileList) {
		this.serviceRateFileList = serviceRateFileList;
	}

	public List getCompanyMachineTypeRefFileList() {
		return companyMachineTypeRefFileList;
	}

	public void setCompanyMachineTypeRefFileList(List companyMachineTypeRefFileList) {
		this.companyMachineTypeRefFileList = companyMachineTypeRefFileList;
	}

	public String getExceedFileName() {
		return exceedFileName;
	}

	public void setExceedFileName(String exceedFileName) {
		this.exceedFileName = exceedFileName;
	}

	public String getServiceRateFileName() {
		return serviceRateFileName;
	}

	public void setServiceRateFileName(String serviceRateFileName) {
		this.serviceRateFileName = serviceRateFileName;
	}

	public String getCompanyMachineTypeRefFileName() {
		return companyMachineTypeRefFileName;
	}

	public void setCompanyMachineTypeRefFileName(
			String companyMachineTypeRefFileName) {
		this.companyMachineTypeRefFileName = companyMachineTypeRefFileName;
	}

	public List getMessageList() {
		return messageList;
	}

	public void setMessageList(List messageList) {
		this.messageList = messageList;
	}

	public String viewMachineImport()
	{
		try {
			exceedFileList = uploadFileList("file.import.exceed.path");
			serviceRateFileList = uploadFileList("file.import.srate.path");
			companyMachineTypeRefFileList = uploadFileList("file.import.cmr.path");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "success";
	}
	
	private List uploadFileList(String path) {
		try {
			System.gc();
			System.gc();
			List fileList = new ArrayList();
			fileList.clear();
			String dir = WebConfigProperties.getProperties(path);
			if (dir == null)
				return null;
			File filedir = new File(dir);
			// 主目录列表
			File[] files = filedir.listFiles();
			if(files==null)
				return null;
			// 目录分类
			for (File file : files) {
				Map m = new HashMap();
				m.put("fileName", file.getName());
				m.put("fileDate", WebUtil.formatDateString(new Date(file
						.lastModified()), "yyyy-MM-dd HH:mm:ss"));
				m.put("filePath", file.getAbsolutePath());
				m.put("fileSize", WebUtil.round(new BigDecimal(file.length()/1024.0), 2)+"KB");
				fileList.add(m);
			}
			Collections.sort(fileList, new Comparator<Map<String, String>>() {

				public int compare(Map<String, String> o1, Map<String, String> o2) {
					if (o1.get("fileDate").compareTo(o2.get("fileDate")) < 0)
						return 1;
					return 0;
				}
			});
			return fileList;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//导入EXCEED
	public String importExceed()
	{
		try {
			if(this.messageList==null)
				this.messageList = new ArrayList();
			this.messageList.clear();
			if(WebUtil.isNull(exceedFileName))
			{
				this.messageList.add("EXCEED文件名错误");
				return "success";
			}
			String dir = WebConfigProperties.getProperties("file.import.exceed.path");
			File exceed = new File(dir+exceedFileName.trim());
			if(!exceed.exists())
			{
				this.messageList.add("文件不存在,请刷新页面");
				return "success";
			}
			try {
				CSVReader reader = new CSVReader(new FileReader(exceed));
				List<String[]> l = reader.readAll();
				if(WebUtil.isNullForList(l)||l.size()<2)
				{
					this.messageList.add("文件没有内容");
					return "success";
				}
				Map session = ActionContext.getContext().getSession();
				UserLogin ul = (UserLogin) session.get("LOGIN_INFO");
				Map param = new HashMap();
				param.put("UserLogin", ul);
				l.remove(0);
				param.put("ExceedList", l);
				List r = machineImportServices.importTempExceed(param);
				this.messageList.addAll(r);
				List r2 = machineImportServices.importExceed();
				this.messageList.addAll(r2);
			} catch (FileNotFoundException e) {
				this.messageList.add("错误:"+e.getMessage());
			} catch (IOException e) {
				this.messageList.add("错误:"+e.getMessage());
			}
			//文件备份和删除
			String bakpath = WebConfigProperties.getProperties("file.bak.path")+"\\exceed\\";
			File bp = new File(bakpath);
			if(!bp.exists())
				bp.mkdirs();
			File bak = new File(bakpath+exceedFileName.trim());
			try {
				if(!bak.exists())
					bak.createNewFile();
				
					WebUtil.fileCopy(exceed, bak);
					System.gc();
					System.gc();
					exceed.delete();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "success";
	}
	
	public String importServiceRate()
	{
		try {
			if(this.messageList==null)
				this.messageList = new ArrayList();
			this.messageList.clear();
			if(WebUtil.isNull(serviceRateFileName))
			{
				this.messageList.add("EXCEED文件名错误");
				return "success";
			}
			String dir = WebConfigProperties.getProperties("file.import.srate.path");
			File serviceRate = new File(dir+serviceRateFileName.trim());
			if(!serviceRate.exists())
			{
				this.messageList.add("文件不存在,请刷新页面");
				return "success";
			}
			try {
				CSVReader reader = new CSVReader(new FileReader(serviceRate));
				List<String[]> l = reader.readAll();
				if(WebUtil.isNullForList(l)||l.size()<2)
				{
					this.messageList.add("文件没有内容");
					return "success";
				}
				l.remove(0);

				Map session = ActionContext.getContext().getSession();
				UserLogin ul = (UserLogin) session.get("LOGIN_INFO");
				Map param = new HashMap();
				param.put("UserLogin", ul);
				param.put("ServiceRateList", l);
				List r = machineImportServices.importTempServiceRate(param);
				this.messageList.addAll(r);
				List r2 = machineImportServices.importServiceRate();
				this.messageList.addAll(r2);
			} catch (FileNotFoundException e) {
				this.messageList.add("错误:"+e.getMessage());
			} catch (IOException e) {
				this.messageList.add("错误:"+e.getMessage());
			}

			//文件备份和删除
			String bakpath = WebConfigProperties.getProperties("file.bak.path")+"\\srate\\";
			File bp = new File(bakpath);
			if(!bp.exists())
				bp.mkdirs();
			File bak = new File(bakpath+serviceRateFileName.trim());
			try {
				if(!bak.exists())
					bak.createNewFile();
				
					WebUtil.fileCopy(serviceRate, bak);
					System.gc();
					System.gc();
					serviceRate.delete();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "success";
	}
	
	public String importCompanyMachineTypeRef()
	{
		try {
			if(this.messageList==null)
				this.messageList = new ArrayList();
			this.messageList.clear();
			if(WebUtil.isNull(companyMachineTypeRefFileName))
			{
				this.messageList.add("EXCEED文件名错误");
				return "success";
			}
			String dir = WebConfigProperties.getProperties("file.import.cmr.path");
			File cmr = new File(dir+companyMachineTypeRefFileName.trim());
			if(!cmr.exists())
			{
				this.messageList.add("文件不存在,请刷新页面");
				return "success";
			}
			try {
				CSVReader reader = new CSVReader(new FileReader(cmr));
				List<String[]> l = reader.readAll();
				if(WebUtil.isNullForList(l)||l.size()<2)
				{
					this.messageList.add("文件没有内容");
					return "success";
				}

				Map session = ActionContext.getContext().getSession();
				UserLogin ul = (UserLogin) session.get("LOGIN_INFO");
				Map param = new HashMap();
				param.put("UserLogin", ul);
				param.put("CmtrList", l.subList(1, l.size()));
				List r = machineImportServices.importTempCompanyMachineTypeRef(param);
				this.messageList.addAll(r);
				List r2 = machineImportServices.importCompanyMachineTypeRef();
				this.messageList.addAll(r2);
			} catch (FileNotFoundException e) {
				this.messageList.add("错误:"+e.getMessage());
			} catch (IOException e) {
				this.messageList.add("错误:"+e.getMessage());
			}

			//文件备份和删除
			String bakpath = WebConfigProperties.getProperties("file.bak.path")+"cmr\\";
			File bp = new File(bakpath);
			if(!bp.exists())
				bp.mkdirs();
			File bak = new File(bakpath+companyMachineTypeRefFileName.trim());
			try {
			if(!bak.exists())
				bak.createNewFile();
			
				WebUtil.fileCopy(cmr, bak);
				System.gc();
				System.gc();
				cmr.delete();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "success";
	}

}
