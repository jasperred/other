package com.ami.ec.channel.bean.asp.impl;

import java.math.BigDecimal;
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
import org.apache.log4j.Logger;

import com.ami.ec.channel.bean.asp.ForAspServices;
import com.ami.ec.channel.common.GetBeanServlet;
import com.ami.ec.channel.dao.asp.AspIfsIDnIfHeadMapper;
import com.ami.ec.channel.dao.asp.AspIfsIDnIfLineMapper;
import com.ami.ec.channel.dao.asp.AspIfsIOrderHeadMapper;
import com.ami.ec.channel.dao.asp.AspIfsIOrderLineMapper;
import com.ami.ec.channel.dao.asp.AspIfsIUnitItemMasterMapper;
import com.ami.ec.channel.dao.asp.AspIfsIUnitSkuMasterMapper;
import com.ami.ec.channel.dao.asp.AspIfsKeyMapper;
import com.ami.ec.channel.dao.asp.AspIfsUnitMapper;
import com.ami.ec.channel.dao.asp.AspOrderHeadMapper;
import com.ami.ec.channel.dao.asp.AspOrderLineMapper;
import com.ami.ec.channel.dao.asp.AspZlogOrderHeadMapper;
import com.ami.ec.channel.dao.asp.WsOrderSearchMapper;
import com.ami.ec.channel.dao.officialPlugin.StatusMappingMapper;
import com.ami.ec.channel.domain.asp.AspIfsIDnIfHead;
import com.ami.ec.channel.domain.asp.AspIfsIDnIfHeadExample;
import com.ami.ec.channel.domain.asp.AspIfsIDnIfLine;
import com.ami.ec.channel.domain.asp.AspIfsIOrderHead;
import com.ami.ec.channel.domain.asp.AspIfsIOrderLine;
import com.ami.ec.channel.domain.asp.AspOrderHead;
import com.ami.ec.channel.domain.asp.AspOrderHeadExample;
import com.ami.ec.channel.domain.asp.AspOrderLine;
import com.ami.ec.channel.domain.asp.AspOrderLineExample;
import com.ami.ec.channel.domain.asp.OrderHeadForWs;
import com.ami.ec.channel.domain.officialPlugin.StatusMapping;
import com.ami.ec.channel.domain.officialPlugin.StatusMappingExample;
import com.ami.ec.channel.io.impl.ReturnOrder;
import com.ami.ec.channel.io.impl.SalesOrder;
import com.ami.ec.channel.util.WebUtil;

public class ForAspServicesImpl implements ForAspServices {
	static Logger logger = Logger.getLogger(ForAspServicesImpl.class);
	private SqlSessionFactory sqlSessionFactory;
	private AspIfsIOrderHeadMapper aspIfsIOrderHeadMapper;
	private AspIfsIOrderLineMapper aspIfsIOrderLineMapper;
	private AspIfsIDnIfHeadMapper aspIfsIDnIfHeadMapper;
	private AspIfsIDnIfLineMapper aspIfsIDnIfLineMapper;
	private AspIfsIUnitItemMasterMapper aspIfsIUnitItemMasterMapper;
	private AspIfsIUnitSkuMasterMapper aspIfsIUnitSkuMasterMapper;
	private AspIfsKeyMapper aspIfsKeyMapper;
	private AspIfsUnitMapper aspIfsUnitMapper;
	private AspOrderHeadMapper aspOrderHeadMapper;
	private AspOrderLineMapper aspOrderLineMapper;
	private AspZlogOrderHeadMapper aspZlogOrderHeadMapper;
	private WsOrderSearchMapper wsOrderSearchMapper;
	

	public SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	public AspIfsIOrderHeadMapper getAspIfsIOrderHeadMapper() {
		return aspIfsIOrderHeadMapper;
	}

	public void setAspIfsIOrderHeadMapper(
			AspIfsIOrderHeadMapper aspIfsIOrderHeadMapper) {
		this.aspIfsIOrderHeadMapper = aspIfsIOrderHeadMapper;
	}

	public AspIfsIOrderLineMapper getAspIfsIOrderLineMapper() {
		return aspIfsIOrderLineMapper;
	}

	public void setAspIfsIOrderLineMapper(
			AspIfsIOrderLineMapper aspIfsIOrderLineMapper) {
		this.aspIfsIOrderLineMapper = aspIfsIOrderLineMapper;
	}

	public AspIfsIDnIfHeadMapper getAspIfsIDnIfHeadMapper() {
		return aspIfsIDnIfHeadMapper;
	}

	public void setAspIfsIDnIfHeadMapper(AspIfsIDnIfHeadMapper aspIfsIDnIfHeadMapper) {
		this.aspIfsIDnIfHeadMapper = aspIfsIDnIfHeadMapper;
	}

	public AspIfsIDnIfLineMapper getAspIfsIDnIfLineMapper() {
		return aspIfsIDnIfLineMapper;
	}

	public void setAspIfsIDnIfLineMapper(AspIfsIDnIfLineMapper aspIfsIDnIfLineMapper) {
		this.aspIfsIDnIfLineMapper = aspIfsIDnIfLineMapper;
	}

	public AspIfsIUnitItemMasterMapper getAspIfsIUnitItemMasterMapper() {
		return aspIfsIUnitItemMasterMapper;
	}

	public void setAspIfsIUnitItemMasterMapper(
			AspIfsIUnitItemMasterMapper aspIfsIUnitItemMasterMapper) {
		this.aspIfsIUnitItemMasterMapper = aspIfsIUnitItemMasterMapper;
	}

	public AspIfsIUnitSkuMasterMapper getAspIfsIUnitSkuMasterMapper() {
		return aspIfsIUnitSkuMasterMapper;
	}

	public void setAspIfsIUnitSkuMasterMapper(
			AspIfsIUnitSkuMasterMapper aspIfsIUnitSkuMasterMapper) {
		this.aspIfsIUnitSkuMasterMapper = aspIfsIUnitSkuMasterMapper;
	}

	public AspIfsKeyMapper getAspIfsKeyMapper() {
		return aspIfsKeyMapper;
	}

	public void setAspIfsKeyMapper(AspIfsKeyMapper aspIfsKeyMapper) {
		this.aspIfsKeyMapper = aspIfsKeyMapper;
	}

	public AspIfsUnitMapper getAspIfsUnitMapper() {
		return aspIfsUnitMapper;
	}

	public void setAspIfsUnitMapper(AspIfsUnitMapper aspIfsUnitMapper) {
		this.aspIfsUnitMapper = aspIfsUnitMapper;
	}

	public AspOrderHeadMapper getAspOrderHeadMapper() {
		return aspOrderHeadMapper;
	}

	public void setAspOrderHeadMapper(AspOrderHeadMapper aspOrderHeadMapper) {
		this.aspOrderHeadMapper = aspOrderHeadMapper;
	}

	public AspOrderLineMapper getAspOrderLineMapper() {
		return aspOrderLineMapper;
	}

	public void setAspOrderLineMapper(AspOrderLineMapper aspOrderLineMapper) {
		this.aspOrderLineMapper = aspOrderLineMapper;
	}

	public AspZlogOrderHeadMapper getAspZlogOrderHeadMapper() {
		return aspZlogOrderHeadMapper;
	}

	public void setAspZlogOrderHeadMapper(
			AspZlogOrderHeadMapper aspZlogOrderHeadMapper) {
		this.aspZlogOrderHeadMapper = aspZlogOrderHeadMapper;
	}

	public WsOrderSearchMapper getWsOrderSearchMapper() {
		return wsOrderSearchMapper;
	}

	public void setWsOrderSearchMapper(WsOrderSearchMapper wsOrderSearchMapper) {
		this.wsOrderSearchMapper = wsOrderSearchMapper;
	}

	public Map uploadReturnOrder(ReturnOrder ro, Long storeId) {
		Map result = new HashMap();
		//查状态对应表
		Map<String,String> statusMap = new HashMap();
		StatusMappingMapper statusMappingMapper = (StatusMappingMapper)GetBeanServlet.getBean("statusMappingMapper");
		List<StatusMapping> statusList = statusMappingMapper.selectByExample(new StatusMappingExample());
		if(!WebUtil.isNullForList(statusList))
		{
			for(StatusMapping sm:statusList)
			{
				statusMap.put(sm.getOfficialStatus(), sm.getAmiStatus());
			}
		}
		// 事务控制
		SqlSession session = sqlSessionFactory.openSession();
		TransactionFactory transactionFactory = new JdbcTransactionFactory();
		Transaction newTransaction = transactionFactory.newTransaction(session
				.getConnection(), false);
		Date date = new Date();
		AspIfsIOrderHead oh = new AspIfsIOrderHead();
		oh.setIfsACd("A001");
		oh.setIfsCCd("C001");
		//固定为1
		oh.setExecFlag(new Short("1"));
		//退货单为-1
		oh.setRtn(new Short("-1"));
		oh.setOrderHeadId(UUID.randomUUID().toString());
		oh.setTimestamp(date);
		oh.setOperateTime(date);
		oh.setOperateType("UPDATE");
		oh.setStoreId(storeId);
		oh.setOrigOrderNo(ro.getOrderNo());
		//固定为Official
		oh.setOrigOrderType("Official");
		//转换官网状态和AMI状态
		oh.setOrderStatus(statusMap.get(ro.getOrderStatus()));
		oh.setOrigOrderStatus(ro.getOrderStatus());
		oh.setCreateTime(ro.getCreateTime());
		oh.setBuyerNick(ro.getBuyerID());
		oh.setOrderAmt(ro.getRealGoodsFee());
		if(WebUtil.isNotNull(ro.getPostFee()))
			oh.setPayment(ro.getRealGoodsFee().add(ro.getPostFee()));
		else
			oh.setPayment(ro.getRealGoodsFee());
		if(WebUtil.isNotNull(ro.getPostFee()))
			oh.setPayAmt(ro.getRealGoodsFee().add(ro.getPostFee()));
		else
			oh.setPayAmt(ro.getRealGoodsFee());

		if(WebUtil.isNotNull(ro.getPostFee()))
			oh.setPostAmt(ro.getPostFee());
		else
			oh.setPostAmt(new BigDecimal(0));
		oh.setRemark(ro.getRemark());
		oh.setOrigRefOrderNo(ro.getOrigOrderNo());
		//oh.setOrigRefOrderStatus("");
		session.insert(
				"com.ami.ec.channel.dao.asp.AspIfsIOrderHeadMapper.insertSelective",
				oh);
		AspIfsIOrderLine ol = new AspIfsIOrderLine();
		ol.setOrderHeadId(oh.getOrderHeadId());
		ol.setOrderLineId(UUID.randomUUID().toString());
		ol.setExecFlag(new Short("1"));
		ol.setTimestamp(date);
		ol.setOperateTime(date);
		ol.setOrigOrderLineNo(ro.getLineNo());
		//ol.setOrderLineStatus("");
		//ol.setOrigOrderLineStatus("");
		ol.setOrigSkuId(ro.getSkuCode());
		ol.setSkuCd(ro.getSkuCode());
		//ol.setSkuName("");
		ol.setQty(new BigDecimal(ro.getNum()));
		ol.setStdPrice(ro.getOrderRealPrice());
		ol.setPrice(ro.getOrderRealPrice());
		ol.setTotalAmt(ro.getRealGoodsFee());
		ol.setStdAmt(ro.getRealGoodsFee());		
		//这里目前使用SKUCD，确保SKUCD在同一个订单的明细中唯一
		ol.setOrigRefOrderLineNo(ro.getLineNo());
//		ol.setOrigRefOrderLineStatus(ro.getSkuCode());
		session.insert(
				"com.ami.ec.channel.dao.asp.AspIfsIOrderLineMapper.insertSelective",
				ol);

		try {
			newTransaction.commit();
		} catch (SQLException e) {
			result.put("Flag", "error");
			result.put("Message", e.getMessage());
		} finally {
			try {
				newTransaction.close();
				session.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		result.put("Flag", "success");
		return result;
	}

	public Map uploadSalesOrder(SalesOrder so, Long storeId) {
		Map result = new HashMap();
		//查状态对应表
		Map<String,String> statusMap = new HashMap();
		StatusMappingMapper statusMappingMapper = (StatusMappingMapper)GetBeanServlet.getBean("statusMappingMapper");
		List<StatusMapping> statusList = statusMappingMapper.selectByExample(new StatusMappingExample());
		if(!WebUtil.isNullForList(statusList))
		{
			for(StatusMapping sm:statusList)
			{
				statusMap.put(sm.getOfficialStatus(), sm.getAmiStatus());
			}
		}
		// 事务控制
		SqlSession session = sqlSessionFactory.openSession();
		TransactionFactory transactionFactory = new JdbcTransactionFactory();
		Transaction newTransaction = transactionFactory.newTransaction(session
				.getConnection(), false);
		Date date = new Date();
		AspIfsIOrderHead oh = new AspIfsIOrderHead();
		oh.setIfsACd("A001");
		oh.setIfsCCd("C001");
		//固定为1
		oh.setExecFlag(new Short("1"));
		//销售单为1
		oh.setRtn(new Short("1"));
		oh.setOrderHeadId(UUID.randomUUID().toString());
		oh.setTimestamp(date);
		oh.setOperateTime(date);
		oh.setOperateType("UPDATE");
		oh.setStoreId(storeId);
		oh.setOrigOrderNo(so.getOrderNo());
		//固定为Official
		oh.setOrigOrderType("Official");
		//转换官网状态和AMI状态
		oh.setOrderStatus(statusMap.get(so.getOrderStatus()));
		oh.setOrigOrderStatus(so.getOrderStatus());
		oh.setCreateTime(so.getCreateTime());
		oh.setPayTime(so.getPayTime());
		oh.setBuyerNick(so.getBuyerID());
		oh.setReceiverName(so.getReceiverName());
		oh.setReceiverDistrict(so.getReceiverDistrinct());
		oh.setReceiverAddress(so.getReceiverAddress());
		oh.setReceiverCity(so.getReceiverCity());
		oh.setReceiverState(so.getReceiverState());
		oh.setReceiverZip(so.getReceiverZip());
		oh.setReceiverPhone(so.getReceiverPhone());
		oh.setReceiverMobile(so.getReceiverMobile());
		oh.setBuyerEmail(so.getBuyerEmail());
		if(so.getInvoiceNeed()!=null&&so.getInvoiceNeed().toUpperCase().equals("Y"))
		{
			oh.setInvoiceName(so.getInvoiceTitle());
			oh.setInvoiceContent(so.getInvoiceComment());
			oh.setInvoiceAddress(so.getInvoiceAddress());
			oh.setShippingType(so.getPostType());			
		}
		//oh.setExpressName(so.getDeliverCompany());
		oh.setBuyerMessage(so.getRemark());
		oh.setOrderAmt(so.getRealGoodsFee());
		oh.setPayment(so.getRealGoodsFee().add(so.getPostFee()));
		oh.setPayAmt(so.getRealGoodsFee().add(so.getPostFee()));
		oh.setRemark(so.getRemark());
		//sum(价格*数量)
		List<com.ami.ec.channel.io.impl.OrderLine> olList = so.getOrderLines();
		BigDecimal orderAmt = new BigDecimal(0);
		for(com.ami.ec.channel.io.impl.OrderLine ol:olList)
		{
			orderAmt = orderAmt.add(ol.getSalePrice().multiply(new BigDecimal(ol.getNum())));
		}
		oh.setOrderAmt(orderAmt);
		oh.setDiscount(so.getGoodsDiscountFee());
		//支付的金额，订单商品实际总金额+运费
		oh.setPayment(so.getRealGoodsFee().add(so.getPostFee()));
		oh.setPayAmt(so.getRealGoodsFee().add(so.getPostFee()));
		//运费
		oh.setPostAmt(so.getPostFee());
		//sum(明细小计)
		oh.setTotalAmt(so.getGoodsFee());
		//支付金额扣除运费和其它费用
		oh.setActualTotalAmt(so.getRealGoodsFee());
		session.insert(
				"com.ami.ec.channel.dao.asp.AspIfsIOrderHeadMapper.insertSelective",
				oh);
		//DN插入，目前只插入官网的4种折扣方式,col001\col002\col003\col004,DN只插入一次
		//查询DN是否存在
		AspIfsIDnIfHeadExample dnEx = new AspIfsIDnIfHeadExample();
		AspIfsIDnIfHeadExample.Criteria dnc = dnEx.createCriteria();
		dnc.andOrigOrderNoEqualTo(oh.getOrigOrderNo());
		int dnCount = aspIfsIDnIfHeadMapper.countByExample(dnEx);
		//DN只插入一次,4种折扣必须有一种有值
		if(dnCount==0&&(so.getCoupon()!=null||so.getGiftCard()!=null||so.getRewardPoint()!=null||so.getStoreCredit()!=null))
		{
			AspIfsIDnIfHead dnHead = new AspIfsIDnIfHead();
			dnHead.setDnIfHeadId(oh.getOrderHeadId());
			dnHead.setExecFlag(new Short("1"));
			dnHead.setIfsACd(oh.getIfsACd());
			dnHead.setIfsCCd(oh.getIfsCCd());
			dnHead.setOperateTime(date);
			dnHead.setOperateType(oh.getOperateType());
			dnHead.setOrigOrderNo(oh.getOrigOrderNo());
			dnHead.setOrigOrderType(oh.getOrigOrderType());
			dnHead.setOrderStatus(oh.getOrderStatus());
			dnHead.setStoreId(oh.getStoreId());
			dnHead.setTimestamp(date);
			dnHead.setCol001(so.getCoupon()!=null?so.getCoupon().toString():"");
			dnHead.setCol002(so.getGiftCard()!=null?so.getGiftCard().toString():"");
			dnHead.setCol003(so.getRewardPoint()!=null?so.getRewardPoint().toString():"");
			dnHead.setCol004(so.getStoreCredit()!=null?so.getStoreCredit().toString():"");
			session.insert(
					"com.ami.ec.channel.dao.asp.AspIfsIDnIfHeadMapper.insertSelective",
					dnHead);
		}
		
		
		for(com.ami.ec.channel.io.impl.OrderLine l:olList)
		{
			AspIfsIOrderLine ol = new AspIfsIOrderLine();
			ol.setOrderHeadId(oh.getOrderHeadId());
			ol.setOrderLineId(UUID.randomUUID().toString());
			ol.setExecFlag(new Short("1"));
			ol.setTimestamp(date);
			ol.setOperateTime(date);
			ol.setOrigOrderLineNo(l.getLineNo());
			//ol.setOrderLineStatus("");
			//ol.setOrigOrderLineStatus("");
			ol.setOrigSkuId(l.getSkuCode());
			ol.setSkuCd(l.getSkuCode());
			ol.setSkuName(l.getArticleTitle());
			ol.setQty(new BigDecimal(l.getNum()));
			ol.setStdPrice(l.getSalePrice());
			ol.setPrice(l.getOrderPrice());
			ol.setTotalAmt(l.getOrderPriceAmt());
			ol.setStdAmt(l.getSalePrice().multiply(new BigDecimal(l.getNum())));
			ol.setDiscountFee(l.getDiscountPrice());
			ol.setDiscountAmt(l.getDiscountPriceAmt());
			ol.setRealPrice(l.getRealPrice());
			ol.setRealPriceAmt(l.getRealPriceAmt());
			ol.setOrigSkuProp1(l.getColorName());
			ol.setOrigSkuProp2(l.getSizeName());
			session.insert(
					"com.ami.ec.channel.dao.asp.AspIfsIOrderLineMapper.insertSelective",
					ol);
			//Dn的明细,目前无内容
			if(dnCount==0&&(so.getCoupon()!=null||so.getGiftCard()!=null||so.getRewardPoint()!=null||so.getStoreCredit()!=null))
			{
				AspIfsIDnIfLine dnLine = new AspIfsIDnIfLine();
				dnLine.setDnIfHeadId(oh.getOrderHeadId());
				dnLine.setExecFlag(new Short("1"));
				dnLine.setId(UUID.randomUUID().toString());
				dnLine.setOrigOrderLineNo(ol.getOrigOrderLineNo());
				session.insert(
						"com.ami.ec.channel.dao.asp.AspIfsIDnIfLineMapper.insertSelective",
						dnLine);
			}
		}	

		try {
			newTransaction.commit();
		} catch (SQLException e) {
			result.put("Flag", "error");
			result.put("Message", e.getMessage());
		} finally {
			try {
				newTransaction.close();
				session.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		result.put("Flag", "success");
		return result;
	}

	public Map incrementOrder(Map param) {
		Integer pageSize = (Integer)param.get("PageSize");
		if(pageSize==null)
			pageSize = 1000;
		StringBuffer storeIds = new StringBuffer();
		List<Long> storeIdList = (List) param.get("StoreId");
		if(!WebUtil.isNullForList(storeIdList))
		{
			for(Long storeId:storeIdList)
			{
				if(storeIds.length()>0)
					storeIds.append(",");
				storeIds.append(storeId);
			}
		}
		Map m = new HashMap();
		m.put("top", pageSize);
		m.put("PjId", param.get("PjId"));
		m.put("StoreId", storeIds.toString());
		m.put("Rnt", param.get("Rnt"));
		m.put("OrigOrderType", param.get("OrigOrderType"));
		if(WebUtil.isNotNull( param.get("FromDate")))
		m.put("FromDate", WebUtil.formatDateString((Date)param.get("FromDate"), "yyyy-MM-dd HH:mm:ss.sss"));
		m.put("TimeStamp", param.get("TimeStamp"));
		List<Integer> zlogIds = wsOrderSearchMapper.selectByIncrementCount(m);
		Map result = new HashMap();
		if(WebUtil.isNullForList(zlogIds))
		{
			result.put("OrderHeadList", null);
		}
		StringBuffer zls = new StringBuffer();
		for(Integer zlogId:zlogIds)
		{
			if(zls.length()>0)
				zls.append(",");
			zls.append(zlogId);
		}
		List<OrderHeadForWs> ohList = wsOrderSearchMapper.selectByIncrement(WebUtil.toMap("ZlogId", zls.toString()));
		result.put("OrderHeadList", ohList);
		return result;
	}

	public Map searchOrder(Map param) {
		StringBuffer storeIds = new StringBuffer();
		List<Long> storeIdList = (List) param.get("StoreId");
		if(!WebUtil.isNullForList(storeIdList))
		{
			for(Long storeId:storeIdList)
			{
				if(storeIds.length()>0)
					storeIds.append(",");
				storeIds.append(storeId);
			}
		}
		Map m = new HashMap();
		m.put("PjId", param.get("PjId"));
		m.put("StoreId", storeIds.toString());
		m.put("OrigOrderType", param.get("OrigOrderType"));
		m.put("OrigOrderNo", param.get("OrigOrderNo"));
		m.put("ReceiverTel", param.get("ReceiverTel"));
		m.put("BuyerNick", param.get("BuyerNick"));
		List<OrderHeadForWs> ohList = wsOrderSearchMapper.selectByCondition(m);
		Map result = new HashMap();
		result.put("OrderHeadList", ohList);
		return result;
	}

	public Map deliverResultList(Map param) {
		Map result = new HashMap();
		try {
			List<Map> deliverResultList = this.wsOrderSearchMapper.selectByDeliverResult(param);
			result.put("DeliverResultList", deliverResultList);
		} catch (RuntimeException e) {
			logger.error(e.getMessage());
		}
		return result;
	}

	public Map returnResultList(Map param) {
		Map result = new HashMap();
		try {
			List<Map> returnResultList = this.wsOrderSearchMapper.selectByReturnResult(param);
			result.put("ReturnResultList", returnResultList);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return result;
	}

	public Map updateDeliverStatus(Map param) {
		Map result = new HashMap();
		if(WebUtil.isNull(param.get("StoreId")))
		{
			result.put("Flag", "error");
			result.put("Message", "[StoreId] is null");
			return result;
		}
		long storeId = Long.parseLong(param.get("StoreId").toString());
		List<String> successList = (List) param.get("SuccessList");
		List<String> errorList = (List) param.get("ErrorList");
		if(!WebUtil.isNullForList(successList))
		{
			AspOrderHeadExample ae = new AspOrderHeadExample();
			AspOrderHeadExample.Criteria c = ae.createCriteria();
			c.andOrigOrderNoIn(successList);
			c.andRtnEqualTo(new Short((short) 1));
			c.andSuppIdEqualTo(storeId);
			AspOrderHead aoh = new AspOrderHead();
			aoh.setOrderStatus(new Short((short) 60));
			this.aspOrderHeadMapper.updateByExampleSelective(aoh, ae);
		}if(!WebUtil.isNullForList(errorList))
		{
			AspOrderHeadExample ae = new AspOrderHeadExample();
			AspOrderHeadExample.Criteria c = ae.createCriteria();
			c.andOrigOrderNoIn(errorList);
			c.andRtnEqualTo(new Short((short) 1));
			c.andSuppIdEqualTo(storeId);
			AspOrderHead aoh = new AspOrderHead();
			aoh.setOrderStatus(new Short((short) 50));
			this.aspOrderHeadMapper.updateByExampleSelective(aoh, ae);
		}
		result.put("Flag", "success");
		return result;
	}

	public Map updateReturnStatus(Map param) {
		Map result = new HashMap();
		if(WebUtil.isNull(param.get("StoreId")))
		{
			result.put("Flag", "error");
			result.put("Message", "[StoreId] is null");
			return result;
		}
		long storeId = Long.parseLong(param.get("StoreId").toString());
		List<String> successList = (List) param.get("SuccessList");
		List<String> errorList = (List) param.get("ErrorList");
		if(!WebUtil.isNullForList(successList))
		{
			AspOrderHeadExample ae = new AspOrderHeadExample();
			AspOrderHeadExample.Criteria c = ae.createCriteria();
			c.andOrigOrderNoIn(successList);
			c.andRtnEqualTo(new Short((short) -1));
			c.andSuppIdEqualTo(storeId);
			AspOrderHead aoh = new AspOrderHead();
			aoh.setOrderStatus(new Short((short) 60));
			this.aspOrderHeadMapper.updateByExampleSelective(aoh, ae);
		}if(!WebUtil.isNullForList(errorList))
		{
			AspOrderHeadExample ae = new AspOrderHeadExample();
			AspOrderHeadExample.Criteria c = ae.createCriteria();
			c.andOrigOrderNoIn(errorList);
			c.andRtnEqualTo(new Short((short) -1));
			c.andSuppIdEqualTo(storeId);
			AspOrderHead aoh = new AspOrderHead();
			aoh.setOrderStatus(new Short((short) 50));
			this.aspOrderHeadMapper.updateByExampleSelective(aoh, ae);
		}
		result.put("Flag", "success");
		return result;
	}

}
