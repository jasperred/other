package com.ami.ifs.ws.order.impl;

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

import com.ami.ifs.dao.IDnIfHead;
import com.ami.ifs.dao.IDnIfHeadExample;
import com.ami.ifs.dao.IDnIfHeadMapper;
import com.ami.ifs.dao.IDnIfLineMapper;
import com.ami.ifs.dao.IOrderHead;
import com.ami.ifs.dao.IOrderHeadExample;
import com.ami.ifs.dao.IOrderHeadMapper;
import com.ami.ifs.dao.IOrderLineMapper;
import com.ami.ifs.dao.IfsDbLog;
import com.ami.ifs.dao.IfsDbLogMapper;
import com.ami.ifs.dao.IfsServiceMapper;
import com.ami.ifs.dao.IfsUnit;
import com.ami.ifs.dao.OOrderHead;
import com.ami.ifs.dao.OOrderHeadMapper;
import com.ami.ifs.dao.OOrderLine;
import com.ami.ifs.dao.OOrderLineMapper;
import com.ami.ifs.io.MessageMapping;
import com.ami.ifs.io.SuccessMapping;
import com.ami.ifs.io.order.DnBatchListIFSAParams;
import com.ami.ifs.io.order.DnBatchListIFSAReturn;
import com.ami.ifs.io.order.OrderBatchListIFSAParams;
import com.ami.ifs.io.order.OrderBatchListIFSAReturn;
import com.ami.ifs.io.order.OrderListIFSAParams;
import com.ami.ifs.io.order.OrderListIFSAReturn;
import com.ami.ifs.io.order.OrderUploadIFSAParams;
import com.ami.ifs.io.order.OrderUploadIFSAReturn;
import com.ami.ifs.util.WebUtil;
import com.ami.ifs.ws.common.Message;
import com.ami.ifs.ws.common.Security;
import com.ami.ifs.ws.order.OrderServiceForAsp;


public class OrderServiceForAspImpl implements OrderServiceForAsp {
	
	private Security security;
	private IfsDbLogMapper ifsDbLogMapper;
	private IOrderHeadMapper iOrderHeadMapper;
	private IOrderLineMapper iOrderLineMapper;
	private OOrderHeadMapper oOrderHeadMapper;
	private OOrderLineMapper oOrderLineMapper;
	private IDnIfHeadMapper iDnIfHeadMapper;
	private IDnIfLineMapper iDnIfLineMapper;
	private IfsServiceMapper ifsServiceMapper;
	
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

	public IOrderHeadMapper getiOrderHeadMapper() {
		return iOrderHeadMapper;
	}

	public void setiOrderHeadMapper(IOrderHeadMapper iOrderHeadMapper) {
		this.iOrderHeadMapper = iOrderHeadMapper;
	}

	public IOrderLineMapper getiOrderLineMapper() {
		return iOrderLineMapper;
	}

	public void setiOrderLineMapper(IOrderLineMapper iOrderLineMapper) {
		this.iOrderLineMapper = iOrderLineMapper;
	}

	public OOrderHeadMapper getoOrderHeadMapper() {
		return oOrderHeadMapper;
	}

	public void setoOrderHeadMapper(OOrderHeadMapper oOrderHeadMapper) {
		this.oOrderHeadMapper = oOrderHeadMapper;
	}

	public OOrderLineMapper getoOrderLineMapper() {
		return oOrderLineMapper;
	}

	public void setoOrderLineMapper(OOrderLineMapper oOrderLineMapper) {
		this.oOrderLineMapper = oOrderLineMapper;
	}

	public IDnIfHeadMapper getiDnIfHeadMapper() {
		return iDnIfHeadMapper;
	}

	public void setiDnIfHeadMapper(IDnIfHeadMapper iDnIfHeadMapper) {
		this.iDnIfHeadMapper = iDnIfHeadMapper;
	}

	public IDnIfLineMapper getiDnIfLineMapper() {
		return iDnIfLineMapper;
	}

	public void setiDnIfLineMapper(IDnIfLineMapper iDnIfLineMapper) {
		this.iDnIfLineMapper = iDnIfLineMapper;
	}

	public IfsServiceMapper getIfsServiceMapper() {
		return ifsServiceMapper;
	}

	public void setIfsServiceMapper(IfsServiceMapper ifsServiceMapper) {
		this.ifsServiceMapper = ifsServiceMapper;
	}

	public SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	public OrderBatchListIFSAReturn orderBatchListIFSA(
			OrderBatchListIFSAParams r) {
		//日志插入
		Date fromDate = new Date();
		IfsDbLog dblog = new IfsDbLog();
		dblog.setStartOperateTime(fromDate);
		dblog.setOperateType("OrderServiceForAsp.orderBatchListIFSA");
		dblog.setIfsACd(r.getIfsAspCd());
		OrderBatchListIFSAReturn or = new OrderBatchListIFSAReturn();
		MessageMapping mm = new MessageMapping();
		if(WebUtil.isNull(r.getIfsKey())||WebUtil.isNull(r.getIfsAspCd()))
		{
			or.setFlag("ERROR");
			or.setOrderHeadList(null);
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
			or.setOrderHeadList(null);
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
			or.setOrderHeadList(null);
			or.addMessage(mm.getTimestampErrorMessageForAsp());
			//日志插入
			dblog.setEndOperateTime(new Date());
			dblog.setSuccess("ERROR");
			dblog.setRemark(mm.getTimestampErrorMessageForAsp().getMessageCode()+mm.getTimestampErrorMessageForAsp().getMessageContent());
			ifsDbLogMapper.insertSelective(dblog);
			return or;
		}
		//设置查询条件
		IOrderHeadExample example = new IOrderHeadExample();
		com.ami.ifs.dao.IOrderHeadExample.Criteria c = example.createCriteria();
		List<Long> storeIdList = new ArrayList();
		for(IfsUnit i:iuList)
		{
			storeIdList.add(i.getStoreId());
		}
		c.andStoreIdIn(storeIdList);
		c.andIfsACdEqualTo(r.getIfsAspCd());
		c.andTimestampGreaterThan(r.getTimestamp());
		int count = iOrderHeadMapper.countByExample(example);
		List<IOrderHead> ohList = null;
		if(count>0)
		{
			//设置查询条数
			example.setTop(true);
			if(r.getPageSize()>1000)
				example.setTop(1000);
			else
				example.setTop(r.getPageSize());
			//排序
			example.setOrderByClause("Timestamp,Order_Head_Id");
			//得到top orderHeadId
			List<String> orderHeadIdList = iOrderHeadMapper.selectOrderHeadIdByExample(example);
			IOrderHeadExample example2 = new IOrderHeadExample();
			com.ami.ifs.dao.IOrderHeadExample.Criteria c2 = example2.createCriteria();
			c2.andOrderHeadIdIn(orderHeadIdList);
			//排序
			example2.setOrderByClause("h.Timestamp,h.Order_Head_Id,l.Disp_Index");
			ohList = iOrderHeadMapper.selectOrderHeadAndOrderLineByExample(example2);
		}
		or.setOrderHeadList(ohList);
		or.setRowCount(count);
		or.setFlag("SUCCESS");
		//日志插入
		dblog.setEndOperateTime(new Date());
		dblog.setSuccess("SUCCESS");
		ifsDbLogMapper.insertSelective(dblog);
		return or;
	}

	public OrderListIFSAReturn orderListIFSA(OrderListIFSAParams r) {
		//日志插入
		Date fromDate = new Date();
		IfsDbLog dblog = new IfsDbLog();
		dblog.setStartOperateTime(fromDate);
		dblog.setOperateType("OrderServiceForAsp.orderListIFSA");
		dblog.setIfsACd(r.getIfsAspCd());
		OrderListIFSAReturn or = new OrderListIFSAReturn();
		MessageMapping mm = new MessageMapping();
		if(WebUtil.isNull(r.getIfsKey())||WebUtil.isNull(r.getIfsAspCd()))
		{
			or.setFlag("ERROR");
			or.setOrderHeadList(null);
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
			or.setOrderHeadList(null);
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
			or.setOrderHeadList(null);
			or.addMessage(mm.getTimestampErrorMessageForAsp());
			//日志插入
			dblog.setEndOperateTime(new Date());
			dblog.setSuccess("ERROR");
			dblog.setRemark(mm.getTimestampErrorMessageForAsp().getMessageCode()+mm.getTimestampErrorMessageForAsp().getMessageContent());
			ifsDbLogMapper.insertSelective(dblog);
			return or;
		}
		//设置查询条件
		IOrderHeadExample example = new IOrderHeadExample();
		com.ami.ifs.dao.IOrderHeadExample.Criteria c = example.createCriteria();
		List<Long> storeIdList = new ArrayList();
		for(IfsUnit i:iuList)
		{
			storeIdList.add(i.getStoreId());
		}
		c.andStoreIdIn(storeIdList);
		c.andIfsACdEqualTo(r.getIfsAspCd());
		c.andTimestampGreaterThan(r.getTimestamp());
		int count = iOrderHeadMapper.countByExample(example);
		List<IOrderHead> ohList = null;
		if(count>0)
		{
			//设置查询条数
			example.setTop(true);
			if(r.getPageSize()>1000)
				example.setTop(1000);
			else
				example.setTop(r.getPageSize());
			//排序
			example.setOrderByClause("Timestamp,Order_Head_Id");
			//得到top orderHeadId
			List<String> orderHeadIdList = iOrderHeadMapper.selectOrderHeadIdByExample(example);
			IOrderHeadExample example2 = new IOrderHeadExample();
			com.ami.ifs.dao.IOrderHeadExample.Criteria c2 = example2.createCriteria();
			c2.andOrderHeadIdIn(orderHeadIdList);
			//排序
			example2.setOrderByClause("h.Timestamp,h.Order_Head_Id,l.Disp_Index");
			ohList = iOrderHeadMapper.selectOrderHeadAndOrderLineByExample(example2);			
		}
		or.setOrderHeadList(ohList);
		or.setRowCount(count);
		or.setFlag("SUCCESS");
		//日志插入
		dblog.setEndOperateTime(new Date());
		dblog.setSuccess("SUCCESS");
		ifsDbLogMapper.insertSelective(dblog);
		return or;
	}

	public OrderUploadIFSAReturn orderUploadIFSA(OrderUploadIFSAParams r) {
		//日志插入
		Date fromDate = new Date();
		IfsDbLog dblog = new IfsDbLog();
		dblog.setStartOperateTime(fromDate);
		dblog.setOperateType("OrderServiceForAsp.orderUploadIFSA");
		dblog.setIfsACd(r.getIfsAspCd());
		OrderUploadIFSAReturn or = new OrderUploadIFSAReturn();
		MessageMapping mm = new MessageMapping();
		if(WebUtil.isNull(r.getIfsKey())||WebUtil.isNull(r.getIfsAspCd()))
		{
			or.setFlag("ERROR");
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
			or.addMessage(mm.getKeyErrorMessageForAsp());
			//日志插入
			dblog.setEndOperateTime(new Date());
			dblog.setSuccess("ERROR");
			dblog.setRemark(mm.getKeyErrorMessageForAsp().getMessageCode()+mm.getKeyErrorMessageForAsp().getMessageContent());
			ifsDbLogMapper.insertSelective(dblog);
			return or;
		}
		//无订单内容
		List<OOrderHead> ohl = r.getOrderHeadList();
		if(WebUtil.isNullForList(r.getOrderHeadList()))
		{
			or.setFlag("ERROR");
			or.addMessage(mm.getOrderHeadErrorMessageForAsp());
			//日志插入
			dblog.setEndOperateTime(new Date());
			dblog.setSuccess("ERROR");
			dblog.setRemark(mm.getOrderHeadErrorMessageForAsp().getMessageCode()+mm.getOrderHeadErrorMessageForAsp().getMessageContent());
			ifsDbLogMapper.insertSelective(dblog);
			return or;
		}
		Map<Long,IfsUnit> m = new HashMap<Long, IfsUnit>();
		for(IfsUnit iu:iuList)
		{
			m.put(iu.getStoreId(), iu);			
		}
		StringBuffer orderNos = new StringBuffer();
		List<SuccessMapping> successList = new ArrayList<SuccessMapping>();
		int i = 0;
		for(OOrderHead oh:ohl)
		{
			MessageMapping mms = new MessageMapping();
			i++;
			//操作类型检查
			if(WebUtil.isNull(oh.getOperateType()))
			{
				Message ms = mms.getOperateTypeErrorMessageForAsp();
				ms.setMessageContent("第"+i+"条OrigOrderNo["+oh.getOrigOrderNo()+"]"+ms.getMessageContent());
				ms.setStoreId(oh.getStoreId());
				or.addMessage(ms);
				continue;
			}
			//检查店铺ID是否为空
			if(WebUtil.isNull(oh.getStoreId()))
			{
				Message ms = mms.getStoreErrorMessageForAsp();
				ms.setMessageContent("第"+i+"条OrigOrderNo["+oh.getOrigOrderNo()+"]"+ms.getMessageContent());
				or.addMessage(ms);
				continue;
			}
			//检查店铺ID是否匹配IFSKEY
			IfsUnit iu = m.get(oh.getStoreId());
			if(WebUtil.isNull(iu))
			{
				Message ms = mms.getStoreErrorMessageForAsp();
				ms.setMessageContent("第"+i+"条OrigOrderNo["+oh.getOrigOrderNo()+"]"+ms.getMessageContent());
				ms.setStoreId(oh.getStoreId());
				or.addMessage(ms);
				continue;
			}
			//检查原订单号
			if(WebUtil.isNull(oh.getOrigOrderNo()))
			{
				Message ms = mms.getOrigOrderNoErrorMessageForAsp();
				ms.setMessageContent("第"+i+"条OrigOrderNo["+oh.getOrigOrderNo()+"]"+ms.getMessageContent());
				ms.setStoreId(oh.getStoreId());
				or.addMessage(ms);
				continue;
			}
			//检查订单状态
			if(WebUtil.isNull(oh.getOrderStatus()))
			{
				Message ms = mms.getOrderStatusErrorMessageForAsp();
				ms.setMessageContent("第"+i+"条OrigOrderNo["+oh.getOrigOrderNo()+"]"+ms.getMessageContent());
				ms.setStoreId(oh.getStoreId());
				or.addMessage(ms);
				continue;
			}
			//检查订单明细
			List<OOrderLine> orderLineList = oh.getOrderLineList();
//			if(WebUtil.isNullForList(orderLineList))
//			{
//				or.addMessage(mms.getOrderLineErrorMessageForAsp);
//				continue;
//			}
			//事务控制
			SqlSession session = sqlSessionFactory.openSession();
			TransactionFactory transactionFactory = new JdbcTransactionFactory();
			Transaction newTransaction = transactionFactory.newTransaction(session.getConnection(), false);
			try {
				//生成UUID,做OrderHeadId
				oh.setOrderHeadId(UUID.randomUUID().toString());
				oh.setIfsCCd(iu.getIfsCCd());
				oh.setIfsACd(iu.getIfsACd());
				//设置RTN
				//oh.setRtn(new Short("1"));
				//插入时间
				oh.setTimestamp(null);
				//oOrderHeadMapper.insert(oh);
				session.insert("com.ami.ifs.dao.OOrderHeadMapper.insertSelective", oh);
				if(!WebUtil.isNullForList(orderLineList))
				{
					int l = 1;
					for(OOrderLine ol:orderLineList)
					{
						ol.setOrderHeadId(oh.getOrderHeadId());
						ol.setTimestamp(null);
						ol.setOrderLineId(UUID.randomUUID().toString());	
						ol.setDispIndex(l);
						//oOrderLineMapper.insert(ol);
						session.insert("com.ami.ifs.dao.OOrderLineMapper.insertSelective", ol);
						l++;
					}
				}
				if(orderNos.length()>0)
					orderNos.append(",");
				orderNos.append(oh.getOrigOrderNo());
				successList.add(new SuccessMapping(oh.getOrigOrderNo(), oh.getStoreId()));
				newTransaction.commit();
			} catch (Exception e) {
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
		}
		or.setOrderNos(orderNos.toString());
		or.setSuccessList(successList);
		or.setFlag("SUCCESS");
		//日志插入
		dblog.setEndOperateTime(new Date());
		dblog.setSuccess("SUCCESS");
		ifsDbLogMapper.insertSelective(dblog);
		return or;
	}

	public DnBatchListIFSAReturn dnBatchListIFSA(DnBatchListIFSAParams r) {
		//日志插入
		Date fromDate = new Date();
		IfsDbLog dblog = new IfsDbLog();
		dblog.setStartOperateTime(fromDate);
		dblog.setOperateType("OrderServiceForAsp.dnBatchListIFSA");
		dblog.setIfsACd(r.getIfsAspCd());
		DnBatchListIFSAReturn dr = new DnBatchListIFSAReturn();
		MessageMapping mm = new MessageMapping();
		if(WebUtil.isNull(r.getIfsKey())||WebUtil.isNull(r.getIfsAspCd()))
		{
			dr.setFlag("ERROR");
			dr.setDnIfHeadList(null);
			dr.addMessage(mm.getKeyErrorMessageForAsp());
			//日志插入
			dblog.setEndOperateTime(new Date());
			dblog.setSuccess("ERROR");
			dblog.setRemark(mm.getKeyErrorMessageForAsp().getMessageCode()+mm.getKeyErrorMessageForAsp().getMessageContent());
			ifsDbLogMapper.insertSelective(dblog);
			return dr;
		}
		//检查IFSKEY
		List<IfsUnit> iuList = security.checkSecurityForA( r.getIfsKey(), r.getIfsAspCd());
		if(WebUtil.isNullForList(iuList))
		{
			dr.setFlag("ERROR");
			dr.setDnIfHeadList(null);
			dr.addMessage(mm.getKeyErrorMessageForAsp());
			//日志插入
			dblog.setEndOperateTime(new Date());
			dblog.setSuccess("ERROR");
			dblog.setRemark(mm.getKeyErrorMessageForAsp().getMessageCode()+mm.getKeyErrorMessageForAsp().getMessageContent());
			ifsDbLogMapper.insertSelective(dblog);
			return dr;
		}
		//检查Timestamp
		if(WebUtil.isNull(r.getTimestamp()))
		{
			dr.setFlag("ERROR");
			dr.setDnIfHeadList(null);
			dr.addMessage(mm.getTimestampErrorMessageForAsp());
			//日志插入
			dblog.setEndOperateTime(new Date());
			dblog.setSuccess("ERROR");
			dblog.setRemark(mm.getTimestampErrorMessageForAsp().getMessageCode()+mm.getTimestampErrorMessageForAsp().getMessageContent());
			ifsDbLogMapper.insertSelective(dblog);
			return dr;
		}
		//设置查询条件
		IDnIfHeadExample example = new IDnIfHeadExample();
		IDnIfHeadExample.Criteria c = example.createCriteria();
		List<Long> storeIdList = new ArrayList();
		for(IfsUnit i:iuList)
		{
			storeIdList.add(i.getStoreId());
		}
		c.andStoreIdIn(storeIdList);
		c.andIfsACdEqualTo(r.getIfsAspCd());
		c.andTimestampGreaterThan(r.getTimestamp());
		int count = this.iDnIfHeadMapper.countByExample(example);
		List<IDnIfHead> dhList = null;
		if(count>0)
		{
			//设置查询条数
			example.setTop(true);
			if(r.getPageSize()>1000)
				example.setTop(1000);
			else
				example.setTop(r.getPageSize());
			//排序
			example.setOrderByClause("Timestamp,Dn_if_head_id");
			//得到top orderHeadId
			List<String> orderHeadIdList = this.ifsServiceMapper.selectDnIfHeadIdByExample(example);
			IDnIfHeadExample example2 = new IDnIfHeadExample();
			IDnIfHeadExample.Criteria c2 = example2.createCriteria();
			c2.andDnIfHeadIdIn(orderHeadIdList);
			//排序
			example2.setOrderByClause("h.Timestamp,h.Dn_if_head_id");
			dhList = this.ifsServiceMapper.selectDnHeadAndDnLineByExample(example2);
		}
		dr.setDnIfHeadList(dhList);
		dr.setRowCount(count);
		dr.setFlag("SUCCESS");
		//日志插入
		dblog.setEndOperateTime(new Date());
		dblog.setSuccess("SUCCESS");
		ifsDbLogMapper.insertSelective(dblog);
		return dr;
	}

}
