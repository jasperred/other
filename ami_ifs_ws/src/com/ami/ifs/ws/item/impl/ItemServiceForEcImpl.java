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

import com.ami.ifs.dao.IUnitItemMaster;
import com.ami.ifs.dao.IUnitItemMasterMapper;
import com.ami.ifs.dao.IUnitSkuMaster;
import com.ami.ifs.dao.IUnitSkuMasterMapper;
import com.ami.ifs.dao.IfsDbLog;
import com.ami.ifs.dao.IfsDbLogMapper;
import com.ami.ifs.dao.IfsUnit;
import com.ami.ifs.io.MessageMapping;
import com.ami.ifs.io.SuccessMapping;
import com.ami.ifs.io.item.ItemUploadIFSCParams;
import com.ami.ifs.io.item.ItemUploadIFSCReturn;
import com.ami.ifs.util.WebUtil;
import com.ami.ifs.ws.common.Message;
import com.ami.ifs.ws.common.Security;
import com.ami.ifs.ws.item.ItemServiceForEc;

public class ItemServiceForEcImpl implements ItemServiceForEc {

	private Security security;
	private IfsDbLogMapper ifsDbLogMapper;
	private IUnitItemMasterMapper iUnitItemMasterMapper;
	private IUnitSkuMasterMapper iUnitSkuMasterMapper;
	
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

	public IUnitItemMasterMapper getiUnitItemMasterMapper() {
		return iUnitItemMasterMapper;
	}

	public void setiUnitItemMasterMapper(IUnitItemMasterMapper iUnitItemMasterMapper) {
		this.iUnitItemMasterMapper = iUnitItemMasterMapper;
	}

	public IUnitSkuMasterMapper getiUnitSkuMasterMapper() {
		return iUnitSkuMasterMapper;
	}

	public void setiUnitSkuMasterMapper(IUnitSkuMasterMapper iUnitSkuMasterMapper) {
		this.iUnitSkuMasterMapper = iUnitSkuMasterMapper;
	}

	public SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	public ItemUploadIFSCReturn itemUploadIFSC(ItemUploadIFSCParams r) {
		//日志插入
		Date fromDate = new Date();
		IfsDbLog dblog = new IfsDbLog();
		dblog.setStartOperateTime(fromDate);
		dblog.setOperateType("ItemServiceForEc.itemUploadIFSC");
		dblog.setIfsCCd(r.getIfsEcCd());
		ItemUploadIFSCReturn or = new ItemUploadIFSCReturn();
		MessageMapping mm = new MessageMapping();
		if(WebUtil.isNull(r.getIfsKey())||WebUtil.isNull(r.getIfsEcCd()))
		{
			or.setFlag("ERROR");
			or.addMessage(mm.getKeyErrorMessageForEc());
			//日志插入
			dblog.setEndOperateTime(new Date());
			dblog.setSuccess("ERROR");
			dblog.setRemark(mm.getKeyErrorMessageForEc().getMessageCode()+mm.getKeyErrorMessageForEc().getMessageContent());
			ifsDbLogMapper.insertSelective(dblog);
			return or;
		}
		//检查IFSKEY
		List<IfsUnit> iuList = security.checkSecurityForC( r.getIfsKey(), r.getIfsEcCd());
		if(WebUtil.isNullForList(iuList))
		{
			or.setFlag("ERROR");
			or.addMessage(mm.getKeyErrorMessageForEc());
			//日志插入
			dblog.setEndOperateTime(new Date());
			dblog.setSuccess("ERROR");
			dblog.setRemark(mm.getKeyErrorMessageForEc().getMessageCode()+mm.getKeyErrorMessageForEc().getMessageContent());
			ifsDbLogMapper.insertSelective(dblog);
			return or;
		}
		//无ITEM内容
		List<IUnitItemMaster> itemList = r.getItemList();
		if(WebUtil.isNullForList(itemList))
		{
			or.setFlag("ERROR");
			or.addMessage(mm.getOrderHeadErrorMessageForEc());
			//日志插入
			dblog.setEndOperateTime(new Date());
			dblog.setSuccess("ERROR");
			dblog.setRemark(mm.getOrderHeadErrorMessageForEc().getMessageCode()+mm.getOrderHeadErrorMessageForEc().getMessageContent());
			ifsDbLogMapper.insertSelective(dblog);
			return or;
		}
		Map<Long,IfsUnit> m = new HashMap<Long, IfsUnit>();
		for(IfsUnit iu:iuList)
		{
			m.put(iu.getStoreId(), iu);			
		}
		StringBuffer itemCds = new StringBuffer();
		List<SuccessMapping> successList = new ArrayList<SuccessMapping>();
		int i = 0;
		for(IUnitItemMaster im:itemList)
		{
			MessageMapping mms = new MessageMapping();
			i++;
			//操作类型检查
			if(WebUtil.isNull(im.getOperateType()))
			{
				Message ms = mms.getOperateTypeErrorMessageForEc();
				ms.setMessageContent("第"+i+"条ItemCd["+im.getItemCd()+"]"+ms.getMessageContent());
				ms.setStoreId(im.getStoreId());
				or.addMessage(ms);
				continue;
			}
			//检查店铺ID是否为空
			if(WebUtil.isNull(im.getStoreId()))
			{
				Message ms = mms.getStoreErrorMessageForEc();
				ms.setMessageContent("第"+i+"条ItemCd["+im.getItemCd()+"]"+ms.getMessageContent());
				or.addMessage(ms);
				continue;
			}
			//检查店铺ID是否匹配IFSKEY
			IfsUnit iu = m.get(im.getStoreId());
			if(WebUtil.isNull(iu))
			{
				Message ms = mms.getStoreErrorMessageForEc();
				ms.setMessageContent("第"+i+"条ItemCd["+im.getItemCd()+"]"+ms.getMessageContent());
				ms.setStoreId(im.getStoreId());
				or.addMessage(ms);
				continue;
			}
			//检查item cd
			if(WebUtil.isNull(im.getItemCd()))
			{
				Message ms = mms.getItemCdErrorMessageForEc();
				ms.setMessageContent("第"+i+"条ItemCd["+im.getItemCd()+"]"+ms.getMessageContent());
				ms.setStoreId(im.getStoreId());
				or.addMessage(ms);
				continue;
			}
			//检查原ITEM类型
			if(WebUtil.isNull(im.getOrigItemType()))
			{
				Message ms = mms.getOrigItemTypeMessageForEc();
				ms.setMessageContent("第"+i+"条ItemCd["+im.getItemCd()+"]"+ms.getMessageContent());
				ms.setStoreId(im.getStoreId());
				or.addMessage(ms);
				continue;
			}
			//检查sku
			List<IUnitSkuMaster> skuList = im.getUnitSkuList();
			if(WebUtil.isNullForList(skuList))
			{
				Message ms = mms.getSkuListErrorMessageForEc();
				ms.setMessageContent("第"+i+"条ItemCd["+im.getItemCd()+"]"+ms.getMessageContent());
				ms.setStoreId(im.getStoreId());
				or.addMessage(ms);
				continue;
			}
			//事务控制
			SqlSession session = sqlSessionFactory.openSession();
			TransactionFactory transactionFactory = new JdbcTransactionFactory();
			Transaction newTransaction = transactionFactory.newTransaction(session.getConnection(), false);
			
			try {
				//生成UUID
				im.setUnitItemId(UUID.randomUUID().toString());
				im.setIfsCCd(iu.getIfsCCd());
				im.setIfsACd(iu.getIfsACd());
				im.setTimestamp(null);
				session.insert("com.ami.ifs.dao.IUnitItemMasterMapper.insertSelective", im);
				int l = 1;
				if(!WebUtil.isNullForList(skuList))
				{
					for(IUnitSkuMaster sm:skuList)
					{
//						if(WebUtil.isNull(sm.getSkuCd()))
//						{
//							Message ms = mms.getSkuCdErrorMessageForEc();
//							ms.setMessageContent("第"+i+"条ItemCd["+im.getItemCd()+"]"+ms.getMessageContent());
//							or.addMessage(ms);
//							continue;
//						}
						sm.setIfsACd(im.getIfsACd());
						sm.setIfsCCd(im.getIfsCCd());
						sm.setStoreId(im.getStoreId());
						sm.setUnitItemId(im.getUnitItemId());
						sm.setUnitSkuId(UUID.randomUUID().toString());	
						sm.setTimestamp(null);
						session.insert("com.ami.ifs.dao.IUnitSkuMasterMapper.insertSelective", sm);
						l++;
					}
				}				
				newTransaction.commit();
			} catch (NumberFormatException e) {
				try {
					newTransaction.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} catch (SQLException e) {
				try {
					newTransaction.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}finally {
				try {
					newTransaction.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(itemCds.length()>0)
				itemCds.append(",");
			itemCds.append(im.getItemCd());
			successList.add(new SuccessMapping(im.getItemCd(), im.getStoreId()));
		}
		or.setItemCds(itemCds.toString());
		or.setSuccessList(successList);
		or.setFlag("SUCCESS");
		//日志插入
		dblog.setEndOperateTime(new Date());
		dblog.setSuccess("SUCCESS");
		ifsDbLogMapper.insertSelective(dblog);
		return or;
	}

}