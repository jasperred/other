package com.ami.ifs.ws.item.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;

import com.ami.ifs.dao.IfsDbLog;
import com.ami.ifs.dao.IfsDbLogMapper;
import com.ami.ifs.dao.IfsUnit;
import com.ami.ifs.dao.OOrderHeadExample;
import com.ami.ifs.dao.OUnitItemMaster;
import com.ami.ifs.dao.OUnitItemMasterExample;
import com.ami.ifs.dao.OUnitItemMasterMapper;
import com.ami.ifs.dao.OUnitSkuMasterMapper;
import com.ami.ifs.dao.UnitSkuExpands;
import com.ami.ifs.io.MessageMapping;
import com.ami.ifs.io.item.InventoryAndPriceBatchListIFSCParams;
import com.ami.ifs.io.item.InventoryAndPriceBatchListIFSCReturn;
import com.ami.ifs.io.item.InventoryAndPriceListIFSCParams;
import com.ami.ifs.io.item.InventoryAndPriceListIFSCReturn;
import com.ami.ifs.util.WebUtil;
import com.ami.ifs.ws.common.Security;
import com.ami.ifs.ws.item.InventoryAndPriceServiceForEc;

public class InventoryAndPriceServiceForEcImpl implements
		InventoryAndPriceServiceForEc {
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

	public InventoryAndPriceBatchListIFSCReturn inventoryAndPriceBatchListIFSC(
			InventoryAndPriceBatchListIFSCParams r) {
		//日志插入
		Date fromDate = new Date();
		IfsDbLog dblog = new IfsDbLog();
		dblog.setStartOperateTime(fromDate);
		dblog.setOperateType("InventoryAndPriceServiceForEc.inventoryAndPriceBatchListIFSC");
		dblog.setIfsCCd(r.getIfsEcCd());
		InventoryAndPriceBatchListIFSCReturn ir = new InventoryAndPriceBatchListIFSCReturn();
		MessageMapping mm = new MessageMapping();
		if(WebUtil.isNull(r.getIfsKey())||WebUtil.isNull(r.getIfsEcCd()))
		{
			ir.setFlag("ERROR");
			ir.setUnitItemList(null);
			ir.addMessage(mm.getKeyErrorMessageForEc());
			//日志插入
			dblog.setEndOperateTime(new Date());
			dblog.setSuccess("ERROR");
			dblog.setRemark(mm.getKeyErrorMessageForEc().getMessageCode()+mm.getKeyErrorMessageForEc().getMessageContent());
			ifsDbLogMapper.insertSelective(dblog);
			return ir;
		}
		//检查IFSKEY
		List<IfsUnit> iuList = security.checkSecurityForC( r.getIfsKey(), r.getIfsEcCd());
		if(WebUtil.isNullForList(iuList))
		{
			ir.setFlag("ERROR");
			ir.setUnitItemList(null);
			ir.addMessage(mm.getKeyErrorMessageForEc());
			//日志插入
			dblog.setEndOperateTime(new Date());
			dblog.setSuccess("ERROR");
			dblog.setRemark(mm.getKeyErrorMessageForEc().getMessageCode()+mm.getKeyErrorMessageForEc().getMessageContent());
			ifsDbLogMapper.insertSelective(dblog);
			return ir;
		}
		//检查Timestamp
		if(WebUtil.isNull(r.getTimestamp()))
		{
			ir.setFlag("ERROR");
			ir.setUnitItemList(null);
			ir.addMessage(mm.getTimestampErrorMessageForEc());
			//日志插入
			dblog.setEndOperateTime(new Date());
			dblog.setSuccess("ERROR");
			dblog.setRemark(mm.getTimestampErrorMessageForEc().getMessageCode()+mm.getTimestampErrorMessageForEc().getMessageContent());
			ifsDbLogMapper.insertSelective(dblog);
			return ir;
		}
		//设置查询条件
		OUnitItemMasterExample example = new OUnitItemMasterExample();
		com.ami.ifs.dao.OUnitItemMasterExample.Criteria c = example.createCriteria();
		List<Long> storeIdList = new ArrayList();
		for(IfsUnit i:iuList)
		{
			storeIdList.add(i.getStoreId());
		}
		c.andStoreIdIn(storeIdList);
		c.andIfsCCdEqualTo(r.getIfsEcCd());
		c.andTimestampGreaterThan(r.getTimestamp());
		int count = oUnitItemMasterMapper.countByExample(example);
		List<OUnitItemMaster> unitItemList = null;
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
			List<String> itemIdList = oUnitItemMasterMapper.selectUnitItemIdByExample(example);
			OUnitItemMasterExample example2 = new OUnitItemMasterExample();
			com.ami.ifs.dao.OUnitItemMasterExample.Criteria c2 = example2.createCriteria();
			c2.andUnitItemIdIn(itemIdList);
			//排序
			example2.setOrderByClause("i.Timestamp");
			unitItemList = oUnitItemMasterMapper.selectItemAndSkuByExample(example2);
		}
		
		ir.setUnitItemList(unitItemList);
		ir.setRowCount(count);
		ir.setFlag("SUCCESS");
		//日志插入
		dblog.setEndOperateTime(new Date());
		dblog.setSuccess("SUCCESS");
		ifsDbLogMapper.insertSelective(dblog);
		return ir;
	}

	public InventoryAndPriceListIFSCReturn inventoryAndPriceListIFSC(
			InventoryAndPriceListIFSCParams r) {
		//日志插入
		Date fromDate = new Date();
		IfsDbLog dblog = new IfsDbLog();
		dblog.setStartOperateTime(fromDate);
		dblog.setOperateType("InventoryAndPriceServiceForEc.inventoryAndPriceListIFSC");
		dblog.setIfsCCd(r.getIfsEcCd());
		InventoryAndPriceListIFSCReturn ir = new InventoryAndPriceListIFSCReturn();
		MessageMapping mm = new MessageMapping();
		if(WebUtil.isNull(r.getIfsKey())||WebUtil.isNull(r.getIfsEcCd()))
		{
			ir.setFlag("ERROR");
			ir.setUnitItemList(null);
			ir.addMessage(mm.getKeyErrorMessageForEc());
			//日志插入
			dblog.setEndOperateTime(new Date());
			dblog.setSuccess("ERROR");
			dblog.setRemark(mm.getKeyErrorMessageForEc().getMessageCode()+mm.getKeyErrorMessageForEc().getMessageContent());
			ifsDbLogMapper.insertSelective(dblog);
			return ir;
		}
		//检查IFSKEY
		List<IfsUnit> iuList = security.checkSecurityForC( r.getIfsKey(), r.getIfsEcCd(),r.getStoreCd());
		if(WebUtil.isNullForList(iuList))
		{
			ir.setFlag("ERROR");
			ir.setUnitItemList(null);
			ir.addMessage(mm.getKeyErrorMessageForEc());
			//日志插入
			dblog.setEndOperateTime(new Date());
			dblog.setSuccess("ERROR");
			dblog.setRemark(mm.getKeyErrorMessageForEc().getMessageCode()+mm.getKeyErrorMessageForEc().getMessageContent());
			ifsDbLogMapper.insertSelective(dblog);
			return ir;
		}
		//检查Timestamp
		if(WebUtil.isNull(r.getTimestamp()))
		{
			ir.setFlag("ERROR");
			ir.setUnitItemList(null);
			ir.addMessage(mm.getTimestampErrorMessageForEc());
			//日志插入
			dblog.setEndOperateTime(new Date());
			dblog.setSuccess("ERROR");
			dblog.setRemark(mm.getTimestampErrorMessageForEc().getMessageCode()+mm.getTimestampErrorMessageForEc().getMessageContent());
			ifsDbLogMapper.insertSelective(dblog);
			return ir;
		}
		//设置查询条件
		OUnitItemMasterExample example = new OUnitItemMasterExample();
		com.ami.ifs.dao.OUnitItemMasterExample.Criteria c = example.createCriteria();
		List<Long> storeIdList = new ArrayList();
		for(IfsUnit i:iuList)
		{
			storeIdList.add(i.getStoreId());
		}
		c.andStoreIdIn(storeIdList);
		c.andIfsCCdEqualTo(r.getIfsEcCd());
		c.andTimestampGreaterThan(r.getTimestamp());
		int count = oUnitItemMasterMapper.countByExample(example);
		List<OUnitItemMaster> unitItemList = null;
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
			List<String> itemIdList = oUnitItemMasterMapper.selectUnitItemIdByExample(example);
			OUnitItemMasterExample example2 = new OUnitItemMasterExample();
			com.ami.ifs.dao.OUnitItemMasterExample.Criteria c2 = example2.createCriteria();
			c2.andUnitItemIdIn(itemIdList);
			//排序
			example2.setOrderByClause("i.Timestamp");
			unitItemList = oUnitItemMasterMapper.selectItemAndSkuByExample(example2);
		}
		
		ir.setUnitItemList(unitItemList);
		ir.setRowCount(count);
		ir.setFlag("SUCCESS");
		//日志插入
		dblog.setEndOperateTime(new Date());
		dblog.setSuccess("SUCCESS");
		ifsDbLogMapper.insertSelective(dblog);
		return ir;
	}


}
