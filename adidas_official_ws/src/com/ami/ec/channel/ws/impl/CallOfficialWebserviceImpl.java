package com.ami.ec.channel.ws.impl;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.rpc.ServiceException;

import org.apache.log4j.Logger;

import Magento.Mage_Api_Model_Server_V2_HandlerBindingStub;
import Magento.Mage_Api_Model_Server_V2_HandlerPortType;
import Magento.MagentoService;
import Magento.MagentoServiceLocator;

import com.ami.ec.channel.util.WebConfigProperties;
import com.ami.ec.channel.ws.CallOfficialWebservice;
import com.ami.ec.channel.ws.OfficialXmlAnalyze;

public class CallOfficialWebserviceImpl implements CallOfficialWebservice {
	static Logger logger = Logger.getLogger(CallOfficialWebserviceImpl.class);

	public Map callOfficialDeliverResult(Map param) {
		Map result = new HashMap();
		List<Map> deliverResultList = (List) param.get("DeliverResultList");
		OfficialXmlAnalyze oxa = new OfficialXmlAnalyze();
		String paramXml = oxa.deliverResultParam(param);
		logger.info("发货上传参数："+paramXml);
		MagentoService ms = new MagentoServiceLocator();
		try {
			Mage_Api_Model_Server_V2_HandlerPortType ma = ms.getMage_Api_Model_Server_V2_HandlerPort(new URL(WebConfigProperties.getProperties("official.ws.url")));
			Mage_Api_Model_Server_V2_HandlerBindingStub stub = (Mage_Api_Model_Server_V2_HandlerBindingStub)ma;
			stub.setTimeout(new Integer(WebConfigProperties.getProperties("official.ws.timeout")));
			String login = ma.login(WebConfigProperties.getProperties("official.ws.userNo"), WebConfigProperties.getProperties("official.ws.appKey"));
			String rtn = ma.bysoftDeliverResultInfo(login, paramXml);
			ma.endSession(login);
			logger.info("发货上传结果："+rtn);
			Map rtnMap = oxa.deliverResultReturn(rtn);
			return rtnMap;
		} catch (ServiceException e) {
			result.put("Flag", "error");
			result.put("Message", e.getMessage());
			logger.error("发货上传信息："+e.getMessage());
		} catch (RemoteException e) {
			result.put("Flag", "error");
			result.put("Message", e.getMessage());
			logger.error("发货上传信息："+e.getMessage());
		} catch (MalformedURLException e) {
			result.put("Flag", "error");
			result.put("Message", e.getMessage());
			logger.error("发货上传信息："+e.getMessage());
		}
		return result;
	}

	public Map callOfficialPriceSynchronization(Map param) {
		Map result = new HashMap();
		OfficialXmlAnalyze oxa = new OfficialXmlAnalyze();
		String paramXml = oxa.priceSyncParam(param);
		logger.info("价格更新参数："+paramXml);
		MagentoService ms = new MagentoServiceLocator();
		try {
			Mage_Api_Model_Server_V2_HandlerPortType ma = ms.getMage_Api_Model_Server_V2_HandlerPort(new URL(WebConfigProperties.getProperties("official.ws.url")));
			Mage_Api_Model_Server_V2_HandlerBindingStub stub = (Mage_Api_Model_Server_V2_HandlerBindingStub)ma;
			stub.setTimeout(new Integer(WebConfigProperties.getProperties("official.ws.timeout")));
			String login = ma.login(WebConfigProperties.getProperties("official.ws.userNo"), WebConfigProperties.getProperties("official.ws.appKey"));
			String rtn = ma.bysoftPriceSynchronizationInfo(login, paramXml);
			ma.endSession(login);
			logger.info("价格更新结果："+rtn);
			Map rtnMap = oxa.priceSyncReturnV1(rtn);
			String comment = (String)rtnMap.get("Comment");
			if(comment!=null)
			{
				logger.error("价格更新信息："+comment);
			}
			rtnMap.put("Flag", "success");
			return rtnMap;
		} catch (ServiceException e) {
			result.put("Flag", "error");
			result.put("Message", e.getMessage());
			logger.error("价格更新信息："+e.getMessage());
		} catch (RemoteException e) {
			result.put("Flag", "error");
			result.put("Message", e.getMessage());
			logger.error("价格更新信息："+e.getMessage());
		} catch (MalformedURLException e) {
			result.put("Flag", "error");
			result.put("Message", e.getMessage());
			logger.error("价格更新信息："+e.getMessage());
		}
		return result;
	}

	public Map callOfficialReturnResult(Map param) {
		Map result = new HashMap();
		OfficialXmlAnalyze oxa = new OfficialXmlAnalyze();
		String paramXml = oxa.returnResultParam(param);
		logger.info("退货上传参数："+paramXml);
		MagentoService ms = new MagentoServiceLocator();
		try {
			Mage_Api_Model_Server_V2_HandlerPortType ma = ms.getMage_Api_Model_Server_V2_HandlerPort(new URL(WebConfigProperties.getProperties("official.ws.url")));
			Mage_Api_Model_Server_V2_HandlerBindingStub stub = (Mage_Api_Model_Server_V2_HandlerBindingStub)ma;
			stub.setTimeout(new Integer(WebConfigProperties.getProperties("official.ws.timeout")));
			String login = ma.login(WebConfigProperties.getProperties("official.ws.userNo"), WebConfigProperties.getProperties("official.ws.appKey"));
			String rtn = ma.bysoftReturnResultInfo(login, paramXml);
			ma.endSession(login);
			logger.info("退货上传结果："+rtn);
			Map rtnMap = oxa.returnResultReturn(rtn);
			return rtnMap;
		} catch (ServiceException e) {
			result.put("Flag", "error");
			result.put("Message", e.getMessage());
			logger.error("退货上传信息："+e.getMessage());
		} catch (RemoteException e) {
			result.put("Flag", "error");
			result.put("Message", e.getMessage());
			logger.error("退货上传信息："+e.getMessage());
		} catch (MalformedURLException e) {
			result.put("Flag", "error");
			result.put("Message", e.getMessage());
			logger.error("退货上传信息："+e.getMessage());
		}
		return result;
	}

	public Map callOfficialStockSynchronization(Map param) {
		Map result = new HashMap();
		OfficialXmlAnalyze oxa = new OfficialXmlAnalyze();
		String paramXml = oxa.stockSyncParam(param);
		logger.info("库存更新参数："+paramXml);
		MagentoService ms = new MagentoServiceLocator();
		try {
			Mage_Api_Model_Server_V2_HandlerPortType ma = ms.getMage_Api_Model_Server_V2_HandlerPort(new URL(WebConfigProperties.getProperties("official.ws.url")));
			Mage_Api_Model_Server_V2_HandlerBindingStub stub = (Mage_Api_Model_Server_V2_HandlerBindingStub)ma;
			stub.setTimeout(new Integer(WebConfigProperties.getProperties("official.ws.timeout")));
			String login = ma.login(WebConfigProperties.getProperties("official.ws.userNo"), WebConfigProperties.getProperties("official.ws.appKey"));
			String rtn = ma.bysoftStockSynchronizationInfo(login, paramXml);
			ma.endSession(login);
			logger.info("库存更新结果："+rtn);
			Map rtnMap = oxa.stockSyncReturnV1(rtn);
			String comment = (String)rtnMap.get("Comment");
			if(comment!=null)
			{
				logger.error("库存更新信息："+comment);
			}
			rtnMap.put("Flag", "success");
			return rtnMap;
		} catch (ServiceException e) {
			result.put("Flag", "error");
			result.put("Message", e.getMessage());
			logger.error("库存更新信息："+e.getMessage());
		} catch (RemoteException e) {
			result.put("Flag", "error");
			result.put("Message", e.getMessage());
			logger.error("库存更新信息："+e.getMessage());
		} catch (MalformedURLException e) {
			result.put("Flag", "error");
			result.put("Message", e.getMessage());
			logger.error("库存更新信息："+e.getMessage());
		}
		return result;
	}

}