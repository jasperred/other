package com.ami.ifs.ws.item.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.transaction.Transaction;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import com.ami.ifs.dao.IfsDbLog;
import com.ami.ifs.dao.IfsDbLogMapper;
import com.ami.ifs.dao.IfsUnit;
import com.ami.ifs.dao.OUnitItemMaster;
import com.ami.ifs.dao.OUnitItemMasterMapper;
import com.ami.ifs.dao.OUnitSkuMaster;
import com.ami.ifs.dao.OUnitSkuMasterMapper;
import com.ami.ifs.io.MessageMapping;
import com.ami.ifs.io.SuccessMapping;
import com.ami.ifs.io.item.InventoryUploadIFSAParams;
import com.ami.ifs.io.item.InventoryUploadIFSAReturn;
import com.ami.ifs.io.item.PriceUploadIFSAParams;
import com.ami.ifs.io.item.PriceUploadIFSAReturn;
import com.ami.ifs.util.WebUtil;
import com.ami.ifs.ws.common.Message;
import com.ami.ifs.ws.common.Security;
import com.ami.ifs.ws.item.InventoryAndPriceServiceForAsp;

public class InventoryAndPriceServiceForAspImpl implements InventoryAndPriceServiceForAsp {
	
	private Security security;
	private IfsDbLogMapper ifsDbLogMapper;
	private OUnitItemMasterMapper oUnitItemMasterMapper;
	private OUnitSkuMasterMapper oUnitSkuMasterMapper;
	
	private SqlSessionFactory sqlSessionFactory;

	public Security getSecurity() {
		return security;
	}

	public void setSecurity(Security security) {
		this.security = security;
	}

	public IfsDbLogMapper getIfsDbLogMapper() {
		return ifsDbLogMapper;
	}

	public void setIfsDbLogMapper(IfsDbLogMapper ifsDbLogMapper) {
		this.ifsDbLogMapper = ifsDbLogMapper;
	}

	public OUnitItemMasterMapper getoUnitItemMasterMapper() {
		return oUnitItemMasterMapper;
	}

	public void setoUnitItemMasterMapper(OUnitItemMasterMapper oUnitItemMasterMapper) {
		this.oUnitItemMasterMapper = oUnitItemMasterMapper;
	}

	public OUnitSkuMasterMapper getoUnitSkuMasterMapper() {
		return oUnitSkuMasterMapper;
	}

	public void setoUnitSkuMasterMapper(OUnitSkuMasterMapper oUnitSkuMasterMapper) {
		this.oUnitSkuMasterMapper = oUnitSkuMasterMapper;
	}

	public SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	public InventoryUploadIFSAReturn inventoryUploadIFSA(
			InventoryUploadIFSAParams r) {
		//日志插入
		Date fromDate = new Date();
		IfsDbLog dblog = new IfsDbLog();
		dblog.setStartOperateTime(fromDate);
		dblog.setOperateType("InventoryAndPriceServiceForAsp.inventoryUploadIFSA");
		dblog.setIfsACd(r.getIfsAspCd());
		InventoryUploadIFSAReturn ir = new InventoryUploadIFSAReturn();
		MessageMapping mm = new MessageMapping();
		if(WebUtil.isNull(r.getIfsKey())||WebUtil.isNull(r.getIfsAspCd()))
		{
			ir.setFlag("ERROR");
			ir.addMessage(mm.getKeyErrorMessageForAsp());
			//日志插入
			dblog.setEndOperateTime(new Date());
			dblog.setSuccess("ERROR");
			dblog.setRemark(mm.getKeyErrorMessageForAsp().getMessageCode()+mm.getKeyErrorMessageForAsp().getMessageContent());
			ifsDbLogMapper.insertSelective(dblog);
			return ir;
		}
		//检查IFSKEY
		List<IfsUnit> iuList = security.checkSecurityForA( r.getIfsKey(), r.getIfsAspCd());
		if(WebUtil.isNullForList(iuList))
		{
			ir.setFlag("ERROR");
			ir.addMessage(mm.getKeyErrorMessageForAsp());
			//日志插入
			dblog.setEndOperateTime(new Date());
			dblog.setSuccess("ERROR");
			dblog.setRemark(mm.getKeyErrorMessageForAsp().getMessageCode()+mm.getKeyErrorMessageForAsp().getMessageContent());
			ifsDbLogMapper.insertSelective(dblog);
			return ir;
		}
		//检查上传内容
		 List<OUnitItemMaster> unitItemList = r.getUnitItemList();
		 if(WebUtil.isNullForList(unitItemList))
		 {
			 ir.setFlag("ERROR");
			ir.addMessage(mm.getInvErrorMessageForAsp());
				//日志插入
			 dblog.setEndOperateTime(new Date());
				dblog.setSuccess("ERROR");
				dblog.setRemark(mm.getInvErrorMessageForAsp().getMessageCode()+mm.getInvErrorMessageForAsp().getMessageContent());
				ifsDbLogMapper.insertSelective(dblog);
			 return ir;
		 }
		 Map<Long,IfsUnit> m = new HashMap<Long, IfsUnit>();
		for(IfsUnit iu:iuList)
		{
			m.put(iu.getStoreId(), iu);			
		}
		int i = 0;
		StringBuffer itemCds = new StringBuffer();
		List<SuccessMapping> successList = new ArrayList<SuccessMapping>();
		for(OUnitItemMaster im:unitItemList)
		{
			i++;
			MessageMapping mms = new MessageMapping();
			//操作类型检查
			if(WebUtil.isNull(im.getOperateType()))
			{
				Message ms = mms.getOperateTypeErrorMessageForAsp();
				ms.setMessageContent("第"+i+"条ITEM["+im.getItemCd()+"]"+ms.getMessageContent());
				ms.setStoreId(im.getStoreId());
				ir.addMessage(ms);
				continue;
			}
			//检查店铺ID是否为空
			if(WebUtil.isNull(im.getStoreId()))
			{
				Message ms = mms.getStoreErrorMessageForAsp();
				ms.setMessageContent("第"+i+"条ITEM["+im.getItemCd()+"]"+ms.getMessageContent());
				ir.addMessage(ms);
				continue;
			}
			//检查店铺ID是否匹配IFSKEY
			IfsUnit iu = m.get(im.getStoreId());
			if(WebUtil.isNull(iu))
			{
				Message ms = mms.getStoreErrorMessageForAsp();
				ms.setMessageContent("第"+i+"条ITEM["+im.getItemCd()+"]"+ms.getMessageContent());
				ms.setStoreId(im.getStoreId());
				ir.addMessage(ms);
				continue;
			}
			//检查item_cd是否为空
			if(WebUtil.isNull(im.getItemCd()))
			{
				Message ms = mms.getInvItemCdErrorMessageForAsp();
				ms.setMessageContent("第"+i+"条ITEM["+im.getItemCd()+"]"+ms.getMessageContent());
				ms.setStoreId(im.getStoreId());
				ir.addMessage(ms);
				continue;
			}
			//检查skulist是否为空
			List<OUnitSkuMaster> unitSkuList = im.getUnitSkuList();
			if(WebUtil.isNullForList(unitSkuList))
			{
				Message ms = mms.getInvSkuListErrorMessageForAsp();
				ms.setMessageContent("第"+i+"条ITEM["+im.getItemCd()+"]"+ms.getMessageContent());
				ms.setStoreId(im.getStoreId());
				ir.addMessage(ms);
				continue;
			}
			//事务控制
			SqlSession session = sqlSessionFactory.openSession();
			TransactionFactory transactionFactory = new JdbcTransactionFactory();
			Transaction newTransaction = transactionFactory.newTransaction(session.getConnection(), false);
			try {
				im.setIfsCCd(iu.getIfsCCd());
				im.setIfsACd(iu.getIfsACd());
				//插入时间
				im.setTimestamp(null);
				im.setUnitItemId(UUID.randomUUID().toString());
				session.insert("com.ami.ifs.dao.OUnitItemMasterMapper.insertSelective", im);
				for(OUnitSkuMaster sm:unitSkuList)
				{

					//检查item_cd是否为空
					if(WebUtil.isNull(sm.getSkuCd()))
					{
						Message ms = mms.getInvSkuCdErrorMessageForAsp();
						ms.setMessageContent("第"+i+"条ITEM["+im.getItemCd()+"]"+ms.getMessageContent());
						ms.setStoreId(im.getStoreId());
						ir.addMessage(ms);
						continue;
					}
					sm.setUnitItemId(im.getUnitItemId());
					sm.setTimestamp(null);
					sm.setIfsCCd(iu.getIfsCCd());
					sm.setIfsACd(iu.getIfsACd());
					sm.setStoreId(im.getStoreId());
					sm.setUnitSkuId(UUID.randomUUID().toString());
					session.insert("com.ami.ifs.dao.OUnitSkuMasterMapper.insertSelective", sm);
				}
				if(itemCds.length()>0)
					itemCds.append(",");
				itemCds.append(im.getItemCd());
				successList.add(new SuccessMapping(im.getItemCd(), im.getStoreId()));
				newTransaction.commit();
			} catch (Exception e) {
				try {
					newTransaction.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} finally{
				try {
					newTransaction.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		ir.setItemCds(itemCds.toString());
		ir.setFlag("SUCCESS");
		ir.setSuccessList(successList);
		//日志插入
		dblog.setEndOperateTime(new Date());
		dblog.setSuccess("SUCCESS");
		ifsDbLogMapper.insertSelective(dblog);
		return ir;
	}

	public PriceUploadIFSAReturn priceUploadIFSA(PriceUploadIFSAParams r) {
		//日志插入
		Date fromDate = new Date();
		IfsDbLog dblog = new IfsDbLog();
		dblog.setStartOperateTime(fromDate);
		dblog.setOperateType("InventoryAndPriceServiceForAsp.priceUploadIFSA");
		dblog.setIfsACd(r.getIfsAspCd());
		PriceUploadIFSAReturn pr = new PriceUploadIFSAReturn();
		MessageMapping mm = new MessageMapping();
		if(WebUtil.isNull(r.getIfsKey())||WebUtil.isNull(r.getIfsAspCd()))
		{
			pr.setFlag("ERROR");
			pr.addMessage(mm.getKeyErrorMessageForAsp());
			//日志插入
			dblog.setEndOperateTime(new Date());
			dblog.setSuccess("ERROR");
			dblog.setRemark(mm.getKeyErrorMessageForAsp().getMessageCode()+mm.getKeyErrorMessageForAsp().getMessageContent());
			ifsDbLogMapper.insertSelective(dblog);
			return pr;
		}
		//检查IFSKEY
		List<IfsUnit> iuList = security.checkSecurityForA( r.getIfsKey(), r.getIfsAspCd());
		if(WebUtil.isNullForList(iuList))
		{
			pr.setFlag("ERROR");
			pr.addMessage(mm.getKeyErrorMessageForAsp());
			//日志插入
			dblog.setEndOperateTime(new Date());
			dblog.setSuccess("ERROR");
			dblog.setRemark(mm.getKeyErrorMessageForAsp().getMessageCode()+mm.getKeyErrorMessageForAsp().getMessageContent());
			ifsDbLogMapper.insertSelective(dblog);
			return pr;
		}
		//检查上传内容
		 List<OUnitItemMaster> unitItemList = r.getUnitItemList();
		 if(WebUtil.isNullForList(unitItemList))
		 {
			 pr.setFlag("ERROR");
			pr.addMessage(mm.getPriceErrorMessageForAsp());
			//日志插入
			dblog.setEndOperateTime(new Date());
			dblog.setSuccess("ERROR");
			dblog.setRemark(mm.getPriceErrorMessageForAsp().getMessageCode()+mm.getPriceErrorMessageForAsp().getMessageContent());
			ifsDbLogMapper.insertSelective(dblog);
			return pr;
		 }
		 Map<Long,IfsUnit> m = new HashMap<Long, IfsUnit>();
		for(IfsUnit iu:iuList)
		{
			m.put(iu.getStoreId(), iu);			
		}
		int i = 0;
		StringBuffer itemCds = new StringBuffer();
		List<SuccessMapping> successList = new ArrayList<SuccessMapping>();
		for(OUnitItemMaster im:unitItemList)
		{
			i++;
			MessageMapping mms = new MessageMapping();
			//操作类型检查
			if(WebUtil.isNull(im.getOperateType()))
			{
				Message ms = mms.getOperateTypeErrorMessageForAsp();
				ms.setMessageContent("第"+i+"条ITEM["+im.getItemCd()+"]"+ms.getMessageContent());
				ms.setStoreId(im.getStoreId());
				pr.addMessage(ms);
				continue;
			}
			//检查店铺ID是否为空
			if(WebUtil.isNull(im.getStoreId()))
			{
				Message ms = mms.getStoreErrorMessageForAsp();
				ms.setMessageContent("第"+i+"条ITEM["+im.getItemCd()+"]"+ms.getMessageContent());
				pr.addMessage(ms);
				continue;
			}
			//检查店铺ID是否匹配IFSKEY
			IfsUnit iu = m.get(im.getStoreId());
			if(WebUtil.isNull(iu))
			{
				Message ms = mms.getStoreErrorMessageForAsp();
				ms.setMessageContent("第"+i+"条ITEM["+im.getItemCd()+"]"+ms.getMessageContent());
				ms.setStoreId(im.getStoreId());
				pr.addMessage(ms);
				continue;
			}
			//检查item_cd是否为空
			if(WebUtil.isNull(im.getItemCd()))
			{
				Message ms = mms.getPriceItemCdErrorMessageForAsp();
				ms.setMessageContent("第"+i+"条ITEM["+im.getItemCd()+"]"+ms.getMessageContent());
				ms.setStoreId(im.getStoreId());
				pr.addMessage(ms);
				continue;
			}
			//检查skulist是否为空
			List<OUnitSkuMaster> unitSkuList = im.getUnitSkuList();
			if(WebUtil.isNullForList(unitSkuList))
			{
				Message ms = mms.getPriceSkuListErrorMessageForAsp();
				ms.setMessageContent("第"+i+"条ITEM["+im.getItemCd()+"]"+ms.getMessageContent());
				ms.setStoreId(im.getStoreId());
				pr.addMessage(ms);
				continue;
			}
			//事务控制
			SqlSession session = sqlSessionFactory.openSession();
			TransactionFactory transactionFactory = new JdbcTransactionFactory();
			Transaction newTransaction = transactionFactory.newTransaction(session.getConnection(), false);
			try {
				im.setIfsCCd(iu.getIfsCCd());
				im.setIfsACd(iu.getIfsACd());
				//插入时间
				im.setTimestamp(null);
				im.setUnitItemId(UUID.randomUUID().toString());
				session.insert("com.ami.ifs.dao.OUnitItemMasterMapper.insertSelective", im);
				for(OUnitSkuMaster sm:unitSkuList)
				{

					//检查item_cd是否为空
					if(WebUtil.isNull(sm.getSkuCd()))
					{
						Message ms = mms.getPriceSkuCdErrorMessageForAsp();
						ms.setMessageContent("第"+i+"条ITEM["+im.getItemCd()+"]"+ms.getMessageContent());
						ms.setStoreId(im.getStoreId());
						pr.addMessage(ms);
						continue;
					}
					sm.setUnitItemId(im.getUnitItemId());
					sm.setTimestamp(null);
					sm.setIfsCCd(iu.getIfsCCd());
					sm.setIfsACd(iu.getIfsACd());
					sm.setStoreId(im.getStoreId());
					sm.setUnitSkuId(UUID.randomUUID().toString());
					session.insert("com.ami.ifs.dao.OUnitSkuMasterMapper.insertSelective", sm);
				}
				if(itemCds.length()>0)
					itemCds.append(",");
				itemCds.append(im.getItemCd());
				successList.add(new SuccessMapping(im.getItemCd(), im.getStoreId()));
				newTransaction.commit();
			} catch (Exception e) {
				try {
					newTransaction.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} finally{
				try {
					newTransaction.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		pr.setItemCds(itemCds.toString());
		pr.setSuccessList(successList);
		//日志插入
		dblog.setEndOperateTime(new Date());
		dblog.setSuccess("SUCCESS");
		ifsDbLogMapper.insertSelective(dblog);
		pr.setFlag("SUCCESS");
		return pr;
	}

}
