package com.ami.ec.channel.task.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.ami.ec.channel.bean.asp.ForAspServices;
import com.ami.ec.channel.bean.officialPlugin.OfficialPluginServices;
import com.ami.ec.channel.common.FtpUpload;
import com.ami.ec.channel.common.GetBeanServlet;
import com.ami.ec.channel.task.OfficialTask;
import com.ami.ec.channel.util.WebConfigProperties;
import com.ami.ec.channel.util.WebUtil;
import com.ami.ec.channel.ws.CallOfficialWebservice;

public class OfficialTaskImpl implements OfficialTask {
	static Logger logger = Logger.getLogger(OfficialTaskImpl.class);

	public Map exportArticleMasterCsv(Map param) {
		Map result = new HashMap();
		String path = WebConfigProperties.getProperties("article.save.path");
		String bakPath = WebConfigProperties.getProperties("article.ftp.bak");
		//清空CSV文件夹
		logger.info("清空CSV文件夹");
		File directory = new File(path);
		if(!directory.exists())
			directory.mkdirs();
		File bakdirectory = new File(path);
		if(!bakdirectory.exists())
			bakdirectory.mkdirs();
		File[] files = directory.listFiles();
		if(files.length>0)
		{
			System.gc();
			System.gc();
			for(File f:files)
			{
				if(f!=null&&f.isFile())
					f.delete();
			}
		}
		//生成CSV文件
		logger.info("准备生成CSV文件...");
		OfficialPluginServices officialPluginServices = (OfficialPluginServices)GetBeanServlet.getBean("officialPluginServices");
		Map m = officialPluginServices.exportArticleMasterCsv(param);
		String fileName = (String) m.get("ArticleCsvName");
		if(fileName==null)
		{
			logger.info("文件未生成");
			result.put("Flag", "success");
			result.put("Message", "文件未生成");
			return result;
		}
		else
		{
			logger.info("文件已生成，文件名："+fileName);
		}
		String csvFile = path+fileName;
		if(!new File(csvFile).exists())
		{
			logger.error("文件不存在");
			result.put("Flag", "error");
			result.put("Message", "文件不存在");
			return result;
		}
		
		//上传到FTP
		logger.info("准备上传到FTP...");
		try {
			String user = (String) param.get("FtpUser");
			String passwd = (String) param.get("FtpPassword");
			String host = (String) param.get("FtpHost");
			Integer port = (Integer) param.get("FtpPort");
			String dir = (String) param.get("FtpPath");
			if(WebUtil.isNull(user))
			{
				logger.error("FTP用户名未设置");
				result.put("Flag", "error");
				result.put("Message", "FTP用户名未设置");
				return result;
			}
			if(WebUtil.isNull(passwd))
			{
				logger.error("FTP用户密码未设置");
				result.put("Flag", "error");
				result.put("Message", "FTP用户密码未设置");
				return result;
			}
			if(WebUtil.isNull(host))
			{
				logger.error("FTP地址未设置");
				result.put("Flag", "error");
				result.put("Message", "FTP地址未设置");
				return result;
			}
			if(WebUtil.isNull(dir))
			{
				logger.error("FTP路径未设置");
				result.put("Flag", "error");
				result.put("Message", "FTP路径未设置");
				return result;
			}
			if(WebUtil.isNull(port))
				port = new Integer("21");
			try {
				FtpUpload fu = new FtpUpload(host, port, user, passwd);
				int r = fu.upload(dir, csvFile);
			} catch (NumberFormatException e1) {
				logger.error(e1.getMessage());
			}
			//文件备份到Bak目录
			try {
				Thread.sleep(60000);
			} catch (InterruptedException e) {
				logger.error(e.getMessage());
			}
			File f = new File(csvFile);
			File bak = new File(bakPath+fileName);
			f.renameTo(bak);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.info("ArticleMaster上传结束");
		result.put("Flag", "success");
		result.put("Message", "ArticleMaster上传结束");
		return result;
	}

	public Map uploadDeliverResult(Map param) {
		logger.info("【发货实绩上传】开始执行");
		Map result = new HashMap();
		if(WebUtil.isNull(param.get("StoreId")))
		{
			result.put("Flag", "error");
			result.put("Message", "StoreId没有传入");	
			logger.error("StoreId没有传入");
			return result;
		}
		param.put("OrigOrderType", "Official");
		ForAspServices forAspServices = (ForAspServices) GetBeanServlet.getBean("forAspServices");
		//从ASP中得到待发货订单列表
		Map m = forAspServices.deliverResultList(param);
		List<Map> deliverResultList = (List) m.get("DeliverResultList");
		if(WebUtil.isNullForList(deliverResultList))
		{
			result.put("Flag", "success");
			result.put("Message", "无发货信息");		
			logger.error("无发货信息");	
			return result;
		}
		//上传发货信息
		CallOfficialWebservice callOfficialWebservice = (CallOfficialWebservice) GetBeanServlet.getBean("callOfficialWebservice");
		m = callOfficialWebservice.callOfficialDeliverResult(WebUtil.toMap("StoreId", param.get("StoreId"),"DeliverResultList",deliverResultList));
		String flag = (String) m.get("Flag");
		if(flag.equals("error"))
		{
			result.put("Flag", "error");
			result.put("Message", m.get("Message"));	
			logger.error(m.get("Message"));		
			return result;
		}
		//把发货结果更新到ASP中
		m = forAspServices.updateDeliverStatus(WebUtil.toMap("StoreId", param.get("StoreId"),"SuccessList",m.get("SuccessList"),"ErrorList",m.get("ErrorList")));
		flag = (String) m.get("Flag");
		if(flag.equals("error"))
		{
			result.put("Flag", "error");
			result.put("Message", m.get("Message"));		
			logger.error(m.get("Message"));	
			return result;
		}
		else
			result.put("Flag", "success");			
		logger.info("【发货实绩上传】执行成功");
		return result;
	}

	public Map uploadInventory(Map param) {
		Map result = new HashMap();
		logger.info("库存更新时间："+WebUtil.formatDateString(new Date(), "yyyy-MM-dd HH:mm:ss"));
		//库存更新要先判断库存更新时间是否在任务最后执行时间之后，否则不更新
		Date ifTime1 = (Date) param.get("IfTime1");//库存更新完成时间
		if(ifTime1==null)
		{
			result.put("Flag", "success");
			result.put("Message", "无可更新库存1");			
			return result;
		}
		Date ifTime2 = (Date) param.get("IfTime2");//有效时间
		long time = 3600000;//默认1小时
		if(ifTime2!=null)
		{
			String h = WebUtil.formatDateString(ifTime2, "H");
			String m = WebUtil.formatDateString(ifTime2, "m");
			String s = WebUtil.formatDateString(ifTime2, "s");
			time = new Long(h)*3600000+new Long(m)*60000+new Long(s)*1000;
		}
		//时间偏移10分钟
		if(ifTime1.getTime()+time+600000<System.currentTimeMillis())
		{
			logger.info("未更新库存，时间："+(ifTime1.getTime()+time+600000)+"当前时间："+System.currentTimeMillis());
			result.put("Flag", "success");
			result.put("Message", "无可更新库存2");			
			return result;
		}
		Date lastExecTime = (Date) param.get("LastExecTime");
		if(lastExecTime!=null)
		{
			//时间偏移10分钟
			if(lastExecTime.getTime()-600000>ifTime1.getTime())
			{
				result.put("Flag", "success");
				result.put("Message", "无可更新库存3");			
				return result;
			}
		}
		if(WebUtil.isNull(param.get("StoreId")))
		{
			result.put("Flag", "error");
			result.put("Message", "StoreId没有传入");			
			return result;
		}
		OfficialPluginServices officialPluginServices = (OfficialPluginServices)GetBeanServlet.getBean("officialPluginServices");
		//得到待更新的库存列表
		Map m = officialPluginServices.inventoryUpdateItemList(param);
		List<Map> invList = (List) m.get("InventoryList");
		if(WebUtil.isNullForList(invList))
		{
			result.put("Flag", "success");
			result.put("Message", "没有需要更新的库存");			
			return result;
		}
		int skuCount = 0;
		List sList = new ArrayList();
		for(Map inv:invList)
		{
			List<Map> skuList = (List) inv.get("skuList");
			if(!WebUtil.isNullForList(skuList))
			{
				skuCount = skuCount+skuList.size();
				for(Map sm:skuList)
				{
					sList.add(sm.get("SkuCd"));
				}
			}
		}
		logger.info("需要更新库存的Sku数量："+skuCount);
		//通过WS上传到官网
		CallOfficialWebservice callOfficialWebservice = (CallOfficialWebservice) GetBeanServlet.getBean("callOfficialWebservice");
		m = callOfficialWebservice.callOfficialStockSynchronization(WebUtil.toMap("InventoryList", invList));
		String flag = (String) m.get("Flag");
		if(flag.equals("error"))
		{
			result.put("Flag", "error");
			result.put("Message", m.get("Message"));			
			return result;
		}
//		int s = 0;
//		if(WebUtil.isNotNull(m.get("SuccessList")))
//			s = ((List)m.get("SuccessList")).size();
//		int e = 0;
//		if(WebUtil.isNotNull(m.get("ErrorList")))
//			e = ((List)m.get("ErrorList")).size();
//		logger.info("成功更新库存的Sku数量："+s);
//		logger.info("失败更新库存的Sku数量："+e);
		//2012-07-25
		List successList = null;
		List errorList = null;
		if(m.get("isSuccess").equals("true"))
			successList = sList;
		else
			errorList = sList;
		//通过官网执行结果的反馈更新库存Flag
		m = officialPluginServices.updateInventoryUpdateFlag(WebUtil.toMap("StoreId", param.get("StoreId"),"SuccessList",successList,"ErrorList",errorList));
		flag = (String) m.get("Flag");
		if(flag.equals("error"))
		{
			result.put("Flag", "error");
			result.put("Message", m.get("Message"));			
			return result;
		}
		else
			result.put("Flag", "success");	
		return result;
	}

	public Map uploadPrice(Map param) {
		Map result = new HashMap();
		if(WebUtil.isNull(param.get("StoreId")))
		{
			result.put("Flag", "error");
			result.put("Message", "StoreId没有传入");			
			return result;
		}
		OfficialPluginServices officialPluginServices = (OfficialPluginServices)GetBeanServlet.getBean("officialPluginServices");
		//调用价格更新SP
		officialPluginServices.callPriceUpdateSP(param);
		//得到待更新的库存列表
		Map m = officialPluginServices.priceUpdateItemList(param);
		List<Map> priceList = (List) m.get("PriceList");
		if(WebUtil.isNullForList(priceList))
		{
			result.put("Flag", "success");
			result.put("Message", "没有需要更新的价格");			
			return result;
		}
		List pList = new ArrayList();
		int skuCount = 0;
		for(Map p:priceList)
		{
			List<Map> skuList = (List) p.get("skuList");
			if(!WebUtil.isNullForList(skuList))
			{
				skuCount = skuCount+skuList.size();
				for(Map sm:skuList)
				{
					pList.add(sm.get("SkuCd"));
				}
			}
		}
		logger.info("需要更新价格的Sku数量："+skuCount);
		//通过WS上传到官网
		CallOfficialWebservice callOfficialWebservice = (CallOfficialWebservice) GetBeanServlet.getBean("callOfficialWebservice");
		m = callOfficialWebservice.callOfficialPriceSynchronization(WebUtil.toMap("PriceList", priceList));
		String flag = (String) m.get("Flag");
		if(flag.equals("error"))
		{
			result.put("Flag", "error");
			result.put("Message", m.get("Message"));		
			logger.error("错误："+m.get("Message"));
			return result;
		}
//		int s = 0;
//		if(WebUtil.isNotNull(m.get("SuccessList")))
//			s = ((List)m.get("SuccessList")).size();
//		int e = 0;
//		if(WebUtil.isNotNull(m.get("ErrorList")))
//			e = ((List)m.get("ErrorList")).size();
//		
//		logger.info("成功更新价格的Sku数量："+s);
//		logger.info("失败更新价格的Sku数量："+e);
		//2012-07-25
		List successList = null;
		List errorList = null;
		if(m.get("isSuccess").equals("true"))
			successList = pList;
		else
			errorList = pList;
		//通过官网执行结果的反馈更新库存Flag
		m = officialPluginServices.updatePriceUpdateFlag(WebUtil.toMap("StoreId", param.get("StoreId"),"SuccessList",successList,"ErrorList",errorList));
		flag = (String) m.get("Flag");
		if(flag.equals("error"))
		{
			result.put("Flag", "error");
			result.put("Message", m.get("Message"));			
			return result;
		}
		else
			result.put("Flag", "success");	
		return result;
	}

	public Map uploadReturnResult(Map param) {
		Map result = new HashMap();
		if(WebUtil.isNull(param.get("StoreId")))
		{
			result.put("Flag", "error");
			result.put("Message", "StoreId没有传入");			
			return result;
		}
		param.put("OrigOrderType", "Official");
		ForAspServices forAspServices = (ForAspServices) GetBeanServlet.getBean("forAspServices");
		//从ASP中得到已退货订单列表
		Map m = forAspServices.returnResultList(param);
		List<Map> returnResultList = (List) m.get("ReturnResultList");
		if(WebUtil.isNullForList(returnResultList))
		{
			result.put("Flag", "success");
			result.put("Message", "无退货信息");			
			return result;
		}
		//上传发货信息
		CallOfficialWebservice callOfficialWebservice = (CallOfficialWebservice) GetBeanServlet.getBean("callOfficialWebservice");
		m = callOfficialWebservice.callOfficialReturnResult(WebUtil.toMap("StoreId", param.get("StoreId"),"ReturnResultList",returnResultList));
		String flag = (String) m.get("Flag");
		if(flag.equals("error"))
		{
			result.put("Flag", "error");
			result.put("Message", m.get("Message"));			
			return result;
		}
		//把发货结果更新到ASP中
		m = forAspServices.updateReturnStatus(WebUtil.toMap("StoreId", param.get("StoreId"),"SuccessList",m.get("SuccessList"),"ErrorList",m.get("ErrorList")));
		flag = (String) m.get("Flag");
		if(flag.equals("error"))
		{
			result.put("Flag", "error");
			result.put("Message", m.get("Message"));			
			return result;
		}
		else
			result.put("Flag", "success");			
		return result;
	}


}
