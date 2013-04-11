package com.ami.ifs.ws.item.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;

import com.ami.ifs.dao.IUnitItemMaster;
import com.ami.ifs.dao.IUnitItemMasterExample;
import com.ami.ifs.dao.IUnitItemMasterMapper;
import com.ami.ifs.dao.IUnitSkuMasterMapper;
import com.ami.ifs.dao.IfsDbLog;
import com.ami.ifs.dao.IfsDbLogMapper;
import com.ami.ifs.dao.IfsUnit;
import com.ami.ifs.dao.OUnitItemMasterExample;
import com.ami.ifs.io.MessageMapping;
import com.ami.ifs.io.item.ItemBatchListIFSAParams;
import com.ami.ifs.io.item.ItemBatchListIFSAReturn;
import com.ami.ifs.io.item.ItemListIFSAParams;
import com.ami.ifs.io.item.ItemListIFSAReturn;
import com.ami.ifs.util.WebUtil;
import com.ami.ifs.ws.common.Security;
import com.ami.ifs.ws.item.ItemServiceForAsp;

public class ItemServiceForAspImpl implements ItemServiceForAsp {

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

	public ItemBatchListIFSAReturn itemBatchListIFSA(ItemBatchListIFSAParams r) {
		//日志插入
		Date fromDate = new Date();
		IfsDbLog dblog = new IfsDbLog();
		dblog.setStartOperateTime(fromDate);
		dblog.setOperateType("ItemServiceForAsp.itemBatchListIFSA");
		dblog.setIfsACd(r.getIfsAspCd());
		ItemBatchListIFSAReturn or = new ItemBatchListIFSAReturn();
		MessageMapping mm = new MessageMapping();
		if(WebUtil.isNull(r.getIfsKey())||WebUtil.isNull(r.getIfsAspCd()))
		{
			or.setFlag("ERROR");
			or.setItemList(null);
			or.addMessage(mm.getKeyErrorMessageForAsp());
			//日志插入
			dblog.setEndOperateTime(new Date());
			dblog.setSuccess("ERROR");
			dblog.setRemark(mm.getKeyErrorMessageForAsp().getMessageCode()+mm.getKeyErrorMessageForAsp().getMessageContent());
			ifsDbLogMapper.insertSelective(dblog);
			return or;
		}
		//检查IFSKEY
		List<IfsUnit> iuList = security.checkSecurityForA( r.getIfsKey(), r.getIfsAspCd());
		if(WebUtil.isNullForList(iuList))
		{
			or.setFlag("ERROR");
			or.setItemList(null);
			or.addMessage(mm.getKeyErrorMessageForAsp());
			//日志插入
			dblog.setEndOperateTime(new Date());
			dblog.setSuccess("ERROR");
			dblog.setRemark(mm.getKeyErrorMessageForAsp().getMessageCode()+mm.getKeyErrorMessageForAsp().getMessageContent());
			ifsDbLogMapper.insertSelective(dblog);
			return or;
		}
		//检查Timestamp
		if(WebUtil.isNull(r.getTimestamp()))
		{
			or.setFlag("ERROR");
			or.setItemList(null);
			or.addMessage(mm.getTimestampErrorMessageForAsp());
			//日志插入
			dblog.setEndOperateTime(new Date());
			dblog.setSuccess("ERROR");
			dblog.setRemark(mm.getTimestampErrorMessageForAsp().getMessageCode()+mm.getTimestampErrorMessageForAsp().getMessageContent());
			ifsDbLogMapper.insertSelective(dblog);
			return or;
		}
		//设置查询条件
		IUnitItemMasterExample example = new IUnitItemMasterExample();
		com.ami.ifs.dao.IUnitItemMasterExample.Criteria c = example.createCriteria();
		List<Long> storeIdList = new ArrayList();
		for(IfsUnit i:iuList)
		{
			storeIdList.add(i.getStoreId());
		}
		c.andStoreIdIn(storeIdList);
		c.andIfsACdEqualTo(r.getIfsAspCd());
		c.andTimestampGreaterThan(r.getTimestamp());
		int count = iUnitItemMasterMapper.countByExample(example);
		List<IUnitItemMaster> itemList = null;
		if(count>0)
		{
			//设置查询条数
			example.setTop(true);
			if(r.getPageSize()>1000)
				example.setTop(1000);
			else
				example.setTop(r.getPageSize());
			//排序
			example.setOrderByClause("Timestamp");
			//得到top orderHeadId
			List<String> itemIdList = iUnitItemMasterMapper.selectUnitItemIdByExample(example);
			IUnitItemMasterExample example2 = new IUnitItemMasterExample();
			com.ami.ifs.dao.IUnitItemMasterExample.Criteria c2 = example2.createCriteria();
			c2.andUnitItemIdIn(itemIdList);
			//排序
			example2.setOrderByClause("i.Timestamp");
			itemList = iUnitItemMasterMapper.selectItemAndSkuByExample(example2);
		}
		
		or.setItemList(itemList);
		or.setRowCount(count);
		or.setFlag("SUCCESS");
		//日志插入
		dblog.setEndOperateTime(new Date());
		dblog.setSuccess("SUCCESS");
		ifsDbLogMapper.insertSelective(dblog);
		return or;
	}

	public ItemListIFSAReturn itemListIFSA(ItemListIFSAParams r) {
		//日志插入
		Date fromDate = new Date();
		IfsDbLog dblog = new IfsDbLog();
		dblog.setStartOperateTime(fromDate);
		dblog.setOperateType("ItemServiceForAsp.itemListIFSA");
		dblog.setIfsACd(r.getIfsAspCd());
		ItemListIFSAReturn or = new ItemListIFSAReturn();
		MessageMapping mm = new MessageMapping();
		if(WebUtil.isNull(r.getIfsKey())||WebUtil.isNull(r.getIfsAspCd()))
		{
			or.setFlag("ERROR");
			or.setItemList(null);
			or.addMessage(mm.getKeyErrorMessageForAsp());
			//日志插入
			dblog.setEndOperateTime(new Date());
			dblog.setSuccess("ERROR");
			dblog.setRemark(mm.getKeyErrorMessageForAsp().getMessageCode()+mm.getKeyErrorMessageForAsp().getMessageContent());
			ifsDbLogMapper.insertSelective(dblog);
			return or;
		}
		//检查IFSKEY
		List<IfsUnit> iuList = security.checkSecurityForA( r.getIfsKey(), r.getIfsAspCd(),r.getStoreCd());
		if(WebUtil.isNullForList(iuList))
		{
			or.setFlag("ERROR");
			or.setItemList(null);
			or.addMessage(mm.getKeyErrorMessageForAsp());
			//日志插入
			dblog.setEndOperateTime(new Date());
			dblog.setSuccess("ERROR");
			dblog.setRemark(mm.getKeyErrorMessageForAsp().getMessageCode()+mm.getKeyErrorMessageForAsp().getMessageContent());
			ifsDbLogMapper.insertSelective(dblog);
			return or;
		}
		//检查Timestamp
		if(WebUtil.isNull(r.getTimestamp()))
		{
			or.setFlag("ERROR");
			or.setItemList(null);
			or.addMessage(mm.getTimestampErrorMessageForAsp());
			//日志插入
			dblog.setEndOperateTime(new Date());
			dblog.setSuccess("ERROR");
			dblog.setRemark(mm.getTimestampErrorMessageForAsp().getMessageCode()+mm.getTimestampErrorMessageForAsp().getMessageContent());
			ifsDbLogMapper.insertSelective(dblog);
			return or;
		}
		//设置查询条件
		IUnitItemMasterExample example = new IUnitItemMasterExample();
		com.ami.ifs.dao.IUnitItemMasterExample.Criteria c = example.createCriteria();
		List<Long> storeIdList = new ArrayList();
		for(IfsUnit i:iuList)
		{
			storeIdList.add(i.getStoreId());
		}
		c.andStoreIdIn(storeIdList);
		c.andIfsACdEqualTo(r.getIfsAspCd());
		c.andTimestampGreaterThan(r.getTimestamp());
		int count = iUnitItemMasterMapper.countByExample(example);
		List<IUnitItemMaster> itemList = null;
		if(count>0)
		{
			//设置查询条数
			example.setTop(true);
			if(r.getPageSize()>1000)
				example.setTop(1000);
			else
				example.setTop(r.getPageSize());
			//排序
			example.setOrderByClause("Timestamp");
			//得到top orderHeadId
			List<String> itemIdList = iUnitItemMasterMapper.selectUnitItemIdByExample(example);
			IUnitItemMasterExample example2 = new IUnitItemMasterExample();
			com.ami.ifs.dao.IUnitItemMasterExample.Criteria c2 = example2.createCriteria();
			c2.andUnitItemIdIn(itemIdList);
			//排序
			example2.setOrderByClause("i.Timestamp");
			itemList = iUnitItemMasterMapper.selectItemAndSkuByExample(example2);
		}
		
		or.setItemList(itemList);
		or.setRowCount(count);
		or.setFlag("SUCCESS");
		//日志插入
		dblog.setEndOperateTime(new Date());
		dblog.setSuccess("SUCCESS");
		ifsDbLogMapper.insertSelective(dblog);
		return or;
	}

}
