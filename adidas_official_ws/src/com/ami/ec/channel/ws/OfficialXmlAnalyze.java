package com.ami.ec.channel.ws;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.log4j.Logger;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

import com.ami.ec.channel.io.impl.FailedOrders;
import com.ami.ec.channel.io.impl.OrderLine;
import com.ami.ec.channel.io.impl.ReturnOrder;
import com.ami.ec.channel.io.impl.SalesOrder;
import com.ami.ec.channel.io.impl.UploadReturnOrderReturn;
import com.ami.ec.channel.io.impl.UploadSalesOrderReturn;
import com.ami.ec.channel.util.WebUtil;

public class OfficialXmlAnalyze {
	static Logger logger = Logger.getLogger(OfficialXmlAnalyze.class);

	public Map saleOrderParam(String content) {
		logger.info("销售单上传参数："+content);
		Map result = new HashMap();
		Document document = readStrToXml(content, result);
		if (document == null)
			return result;
		List<SalesOrder> salesOrderList = new ArrayList();
		Element root = document.getRootElement();
		List<Element> ordersElementList = root.getChildren("order");
		if (WebUtil.isNullForList(ordersElementList)) {
			result.put("Flag", "error");
			result.put("Message", "无参数内容");
			return result;
		}
		for (Element el : ordersElementList) {
			SalesOrder so = new SalesOrder();
			so.setBuyerEmail(el.getChildTextTrim("BuyerEmail"));
			so.setBuyerID(el.getChildTextTrim("BuyerID"));
			so.setBuyerName(el.getChildTextTrim("BuyerName"));
			so.setChannelType(el.getChildTextTrim("ChannelType"));
			if (WebUtil.isNotNull(el.getChildTextTrim("CreateTime")))
				so
						.setCreateTime(WebUtil.toDateForString(el
								.getChildTextTrim("CreateTime"),
								"yyyy-MM-dd HH:mm:ss"));
			so.setDeliverCompany(el.getChildTextTrim("DeliverCompany"));
			if (WebUtil.isNotNull(el.getChildTextTrim("GoodsDiscountFee")))
				so.setGoodsDiscountFee(new BigDecimal(el
						.getChildTextTrim("GoodsDiscountFee")));
			if (WebUtil.isNotNull(el.getChildTextTrim("GoodsFee")))
				so.setGoodsFee(new BigDecimal(el.getChildTextTrim("GoodsFee")));
			/**2012.08.14 sunmw 增加官网的4种折扣方式*/
			if (WebUtil.isNotNull(el.getChildTextTrim("Coupon")))
				so.setCoupon(new BigDecimal(el.getChildTextTrim("Coupon")));
			if (WebUtil.isNotNull(el.getChildTextTrim("GiftCard")))
				so.setGiftCard(new BigDecimal(el.getChildTextTrim("GiftCard")));
			if (WebUtil.isNotNull(el.getChildTextTrim("RewardPoint")))
				so.setRewardPoint(new BigDecimal(el.getChildTextTrim("RewardPoint")));
			if (WebUtil.isNotNull(el.getChildTextTrim("StoreCredit")))
				so.setStoreCredit(new BigDecimal(el.getChildTextTrim("StoreCredit")));
			so.setInvoiceAddress(el.getChildTextTrim("InvoiceAddress"));
			so.setInvoiceComment(el.getChildTextTrim("InvoiceComment"));
			so.setInvoiceNeed(el.getChildTextTrim("InvoiceNeed"));
			so.setInvoiceTitle(el.getChildTextTrim("InvoiceTitle"));
			if (WebUtil.isNotNull(el.getChildTextTrim("LastModifyTime")))
				so.setLastModifyTime(WebUtil.toDateForString(el
						.getChildTextTrim("LastModifyTime"),
						"yyyy-MM-dd HH:mm:ss"));
			so.setOrderNo(el.getChildTextTrim("OrderNo"));
			so.setOrderStatus(el.getChildTextTrim("OrderStatus"));
			if (WebUtil.isNotNull(el.getChildTextTrim("PayTime")))
				so.setPayTime(WebUtil.toDateForString(el
						.getChildTextTrim("PayTime"), "yyyy-MM-dd HH:mm:ss"));
			if (WebUtil.isNotNull(el.getChildTextTrim("PostFee")))
				so.setPostFee(new BigDecimal(el.getChildTextTrim("PostFee")));
			so.setPostType(el.getChildTextTrim("PostType"));
			if (WebUtil.isNotNull(el.getChildTextTrim("RealGoodsFee")))
				so.setRealGoodsFee(new BigDecimal(el
						.getChildTextTrim("RealGoodsFee")));
			so.setReceiverAddress(el.getChildTextTrim("ReceiverAddress"));
			so.setReceiverCity(el.getChildTextTrim("ReceiverCity"));
			so.setReceiverDistrinct(el.getChildTextTrim("ReceiverDistrinct"));
			so.setReceiverMobile(el.getChildTextTrim("ReceiverMobile"));
			so.setReceiverName(el.getChildTextTrim("ReceiverName"));
			so.setReceiverPhone(el.getChildTextTrim("ReceiverPhone"));
			so.setReceiverState(el.getChildTextTrim("ReceiverState"));
			so.setReceiverZip(el.getChildTextTrim("ReceiverZip"));
			so.setRemark(el.getChildTextTrim("Remark"));
			List<Element> olElementList = el.getChildren("OrderLines");
			if (!WebUtil.isNullForList(olElementList)) {
				List<OrderLine> orderLines = new ArrayList();
				for (Element olel : olElementList) {
					OrderLine ol = new OrderLine();
					ol.setArticleNo(olel.getChildTextTrim("ArticleNo"));
					ol.setArticleTitle(olel.getChildTextTrim("ArticleTitle"));
					ol.setColorName(olel.getChildTextTrim("ColorName"));
					if (WebUtil.isNotNull(olel
							.getChildTextTrim("DiscountPrice")))
						ol.setDiscountPrice(new BigDecimal(olel
								.getChildTextTrim("DiscountPrice")));
					if (WebUtil.isNotNull(olel
							.getChildTextTrim("DiscountPriceAmt")))
						ol.setDiscountPriceAmt(new BigDecimal(olel
								.getChildTextTrim("DiscountPriceAmt")));
					if (WebUtil.isNotNull(olel.getChildTextTrim("LineIndex")))
						ol.setLineIndex(new Integer(olel
								.getChildTextTrim("LineIndex")));
					ol.setLineNo(olel.getChildTextTrim("LineNo"));
					if (WebUtil.isNotNull(olel.getChildTextTrim("Num")))
						ol.setNum(new Integer(olel.getChildTextTrim("Num")));
					if (WebUtil.isNotNull(olel.getChildTextTrim("OrderPrice")))
						ol.setOrderPrice(new BigDecimal(olel
								.getChildTextTrim("OrderPrice")));
					if (WebUtil.isNotNull(olel
							.getChildTextTrim("OrderPriceAmt")))
						ol.setOrderPriceAmt(new BigDecimal(olel
								.getChildTextTrim("OrderPriceAmt")));
					if (WebUtil.isNotNull(olel.getChildTextTrim("RealPrice")))
						ol.setRealPrice(new BigDecimal(olel
								.getChildTextTrim("RealPrice")));
					if (WebUtil
							.isNotNull(olel.getChildTextTrim("RealPriceAmt")))
						ol.setRealPriceAmt(new BigDecimal(olel
								.getChildTextTrim("RealPriceAmt")));
					if (WebUtil.isNotNull(olel.getChildTextTrim("SalePrice")))
						ol.setSalePrice(new BigDecimal(olel
								.getChildTextTrim("SalePrice")));
					ol.setSizeName(olel.getChildTextTrim("SizeName"));
					ol.setSkuCode(olel.getChildTextTrim("SkuCode"));
					orderLines.add(ol);
				}
				so.setOrderLines(orderLines);
			}
			salesOrderList.add(so);
		}
		result.put("SalesOrderList", salesOrderList);
		result.put("Flag", "success");
		return result;
	}

	public String saleOrderReturn(UploadSalesOrderReturn r) {
		Element rootElement = new Element("sales_order_return");
		Element startDate = new Element("started_at");
		if (r.getStartDate() != null)
			startDate.addContent(WebUtil.formatDateString(r.getStartDate(),
					"yyyy-MM-dd HH:mm:ss"));
		rootElement.addContent(startDate);
		Element endDate = new Element("end_at");
		if (r.getEndDate() != null)
			endDate.addContent(WebUtil.formatDateString(r.getEndDate(),
					"yyyy-MM-dd HH:mm:ss"));
		rootElement.addContent(endDate);
		Element success = new Element("success");
		success.addContent("" + r.getSuccess());
		rootElement.addContent(success);
		Element failed = new Element("failed");
		failed.addContent("" + r.getFailed());
		rootElement.addContent(failed);
		Element requestTotal = new Element("request_total");
		requestTotal.addContent("" + r.getRequestTotal());
		rootElement.addContent(requestTotal);
		Element failedOrders = new Element("failed_orders");
		if (!WebUtil.isNullForList(r.getFailedOrders())) {
			for (FailedOrders fo : r.getFailedOrders()) {
				Element order = new Element("order");
				Element orderNo = new Element("OrderNo");
				orderNo.addContent(fo.getOrderNo());
				Element errors = new Element("errors");
				errors.addContent(fo.getErrors());
				Element comment = new Element("comment");
				comment.addContent(fo.getComment());
				Element reserve = new Element("reserve");
				reserve.addContent(fo.getReserve());
				order.addContent(orderNo);
				order.addContent(errors);
				order.addContent(comment);
				order.addContent(reserve);
				failedOrders.addContent(order);
			}
		}
		rootElement.addContent(failedOrders);
		Element successOrders = new Element("success_orders");
		if (!WebUtil.isNullForList(r.getSuccessOrders())) {
			for (String s : r.getSuccessOrders()) {
				Element order = new Element("order");
				Element orderNo = new Element("OrderNo");
				orderNo.addContent(s);
				order.addContent(orderNo);
				successOrders.addContent(order);
			}
		}
		rootElement.addContent(successOrders);
		Element comment = new Element("comment");
		comment.addContent(r.getComment());
		rootElement.addContent(comment);
		Element reserve = new Element("reserve");
		reserve.addContent(r.getFlag());
		rootElement.addContent(reserve);
		String str = xmlToString(rootElement);
		logger.info("销售单返回结果："+str);
		return str;
	}

	public Map returnOrderParam(String content) {
		logger.info("退货单上传参数："+content);
		Map result = new HashMap();
		Document document = readStrToXml(content, result);
		if (document == null)
			return result;
		List<ReturnOrder> returnOrderList = new ArrayList();
		Element root = document.getRootElement();
		List<Element> ordersElementList = root.getChildren("order");
		if (WebUtil.isNullForList(ordersElementList)) {
			result.put("Flag", "error");
			result.put("Message", "无参数内容");
			return result;
		}
		for (Element el : ordersElementList) {
			ReturnOrder ro = new ReturnOrder();
			ro.setArticleNo(el.getChildTextTrim("ArticleNo"));
			ro.setBuyerID(el.getChildTextTrim("BuyerID"));
			ro.setChannelType(el.getChildTextTrim("ChannelType"));
			if (WebUtil.isNotNull(el.getChildTextTrim("ConfirmTime")))
				ro.setConfirmTime(WebUtil
						.toDateForString(el.getChildTextTrim("ConfirmTime"),
								"yyyy-MM-dd HH:mm:ss"));
			if (WebUtil.isNotNull(el.getChildTextTrim("CreateTime")))
				ro
						.setCreateTime(WebUtil.toDateForString(el
								.getChildTextTrim("CreateTime"),
								"yyyy-MM-dd HH:mm:ss"));
			ro.setDeliverCompany(el.getChildTextTrim("DeliverCompany"));
			ro.setDeliverNo(el.getChildTextTrim("DeliverNo"));
			if (WebUtil.isNotNull(el.getChildTextTrim("LastModifyTime")))
				ro.setLastModifyTime(WebUtil.toDateForString(el
						.getChildTextTrim("LastModifyTime"),
						"yyyy-MM-dd HH:mm:ss"));
			ro.setLineNo(el.getChildTextTrim("LineNo"));
			if (WebUtil.isNotNull(el.getChildTextTrim("Num")))
				ro.setNum(new Integer(el.getChildTextTrim("Num")));
			ro.setOrderNo(el.getChildTextTrim("OrderNo"));
			if (WebUtil.isNotNull(el.getChildTextTrim("OrderRealPrice")))
				ro.setOrderRealPrice(new BigDecimal(el
						.getChildTextTrim("OrderRealPrice")));
			ro.setOrderStatus(el.getChildTextTrim("OrderStatus"));
			ro.setOrigOrderNo(el.getChildTextTrim("OrigOrderNo"));
			if (WebUtil.isNotNull(el.getChildTextTrim("PostFee")))
				ro.setPostFee(new BigDecimal(el.getChildTextTrim("PostFee")));
			ro.setPostType(el.getChildTextTrim("PostType"));
			if (WebUtil.isNotNull(el.getChildTextTrim("RealGoodsFee")))
				ro.setRealGoodsFee(new BigDecimal(el
						.getChildTextTrim("RealGoodsFee")));
			ro.setRemark(el.getChildTextTrim("Remark"));
			ro.setSkuCode(el.getChildTextTrim("SkuCode"));
			returnOrderList.add(ro);
		}
		result.put("ReturnOrderList", returnOrderList);
		result.put("Flag", "success");
		return result;
	}

	private Document readStrToXml(String content, Map result) {
		SAXBuilder builder = new SAXBuilder();
		Document document = null;
		ByteArrayInputStream bais = null;
		try {
			bais = new ByteArrayInputStream(content.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			result.put("Flag", "error");
			result.put("Message", e.getMessage());
		}
		if (bais != null) {
			try {
				document = builder.build(bais);
			} catch (IOException e) {
				result.put("Flag", "error");
				result.put("Message", e.getMessage());
			} catch (JDOMException e) {
				result.put("Flag", "error");
				result.put("Message", e.getMessage());
			}
		} else {
			result.put("Flag", "error");
			result.put("Message", "无参数内容");
		}
		return document;
	}

	public String returnOrderReturn(UploadReturnOrderReturn r) {
		Element rootElement = new Element("Return_Request_Return");
		Element startDate = new Element("started_at");
		if (r.getStartDate() != null)
			startDate.addContent(WebUtil.formatDateString(r.getStartDate(),
					"yyyy-MM-dd HH:mm:ss"));
		rootElement.addContent(startDate);
		Element endDate = new Element("end_at");
		if (r.getEndDate() != null)
			endDate.addContent(WebUtil.formatDateString(r.getEndDate(),
					"yyyy-MM-dd HH:mm:ss"));
		rootElement.addContent(endDate);
		Element success = new Element("success");
		success.addContent("" + r.getSuccess());
		rootElement.addContent(success);
		Element failed = new Element("failed");
		failed.addContent("" + r.getFailed());
		rootElement.addContent(failed);
		Element requestTotal = new Element("request_total");
		requestTotal.addContent("" + r.getRequestTotal());
		rootElement.addContent(requestTotal);
		Element failedOrders = new Element("failed_orders");
		if (!WebUtil.isNullForList(r.getFailedOrders())) {
			for (FailedOrders fo : r.getFailedOrders()) {
				Element order = new Element("order");
				Element orderNo = new Element("OrderNo");
				orderNo.addContent(fo.getOrderNo());
				Element errors = new Element("errors");
				errors.addContent(fo.getErrors());
				Element comment = new Element("comment");
				comment.addContent(fo.getComment());
				Element reserve = new Element("reserve");
				reserve.addContent(fo.getReserve());
				order.addContent(orderNo);
				order.addContent(errors);
				order.addContent(comment);
				order.addContent(reserve);
				failedOrders.addContent(order);
			}
		}
		rootElement.addContent(failedOrders);
		Element successOrders = new Element("success_orders");
		if (!WebUtil.isNullForList(r.getSuccessOrders())) {
			for (String s : r.getSuccessOrders()) {
				Element order = new Element("order");
				Element orderNo = new Element("OrderNo");
				orderNo.addContent(s);
				order.addContent(orderNo);
				successOrders.addContent(order);
			}
		}
		rootElement.addContent(successOrders);
		Element comment = new Element("comment");
		comment.addContent(r.getComment());
		rootElement.addContent(comment);
		Element reserve = new Element("reserve");
		reserve.addContent(r.getFlag());
		rootElement.addContent(reserve);
		String str = xmlToString(rootElement);
		logger.info("退货单返回结果："+str);
		return str;
	}

	private String xmlToString(Element rootElement) {
		Document document = new Document(rootElement);
		Format format = Format.getPrettyFormat();
		format.setEncoding("utf-8");
		XMLOutputter xmlout = new XMLOutputter(format);
		ByteArrayOutputStream bo = new ByteArrayOutputStream();
		try {
			xmlout.output(document, bo);
		} catch (IOException e) {
			logger.error(e.getMessage());
			return null;
		}
		byte[] lens = bo.toByteArray();
		
        String result = null;
		try {
			result = new String(lens,"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public String deliverResultParam(Map param) {
		List<Map> deliverResultList = (List) param.get("DeliverResultList");
		Element rootElement = new Element("Deliver_Result");
		Element fieldsElement = new Element("fields");
		for (Map m : deliverResultList) {
			
			Element orderElement = new Element("order");
			
			Element ChannelType = new Element("ChannelType");
			ChannelType.addContent("Official");
			
			Element OrderNo = new Element("OrderNo");
			OrderNo.addContent((String) m.get("OrderNo"));
			
			Element PostType = new Element("PostType");
			PostType.addContent((String) m.get("PostType"));
			
			Element DeliverCompany = new Element("DeliverCompany");
			DeliverCompany.addContent((String) m.get("DeliverCompany"));
			
			Element DeliverNo = new Element("DeliverNo");
			DeliverNo.addContent((String) m.get("DeliverNo"));
			
			Element DeliverTime = new Element("DeliverTime");
			if (WebUtil.isNotNull(m.get("DeliverTime")))
				DeliverTime.addContent(WebUtil.formatDateString((Date) m
						.get("DeliverTime"), "yyyy-MM-dd HH:mm:ss"));
			
			orderElement.addContent(ChannelType);
			orderElement.addContent(OrderNo);
			orderElement.addContent(PostType);
			orderElement.addContent(DeliverCompany);
			orderElement.addContent(DeliverNo);
			orderElement.addContent(DeliverTime);
			fieldsElement.addContent(orderElement);
		}
		rootElement.addContent(fieldsElement);
		return xmlToString(rootElement);
	}

	public Map deliverResultReturn(String str) {
		Map result = new HashMap();
		Document document = readStrToXml(str, result);
		if (document == null)
		{
			result.put("Flag", "error");
			result.put("Message", "XML格式解析错误");
			return result;
		}
		Element root = document.getRootElement();
		List<Element> orderElementList = root.getChildren("order");
		List<String> successList = new ArrayList();
		List<String> errorList = new ArrayList();
		if(!WebUtil.isNullForList(orderElementList))
		{
			for(Element el:orderElementList)
			{
				if(el.getChildTextTrim("result").equalsIgnoreCase("true"))
				{
					successList.add(el.getChildTextTrim("OrderNo"));
				}
				else
				{
					errorList.add(el.getChildTextTrim("OrderNo"));
					logger.error("发货信息上传错误：OrderNo："+el.getChildTextTrim("OrderNo")+",message:"+el.getChildTextTrim("comment"));
				}
			}
		}
		result.put("Flag", "success");
		result.put("SuccessList", successList);
		result.put("ErrorList", errorList);
		return result;
	}

	public String returnResultParam(Map param) {
		List<Map> returnResultList = (List) param.get("ReturnResultList");
		Element rootElement = new Element("Return_Result");
		for (Map m : returnResultList) {
			Element orderElement = new Element("order");
			Element ChannelType = new Element("ChannelType");
			ChannelType.addContent("Official");
			
			Element OrderNo = new Element("OrderNo");
			OrderNo.addContent((String) m.get("OrderNo"));
			
			Element OrigOrderNo = new Element("OrigOrderNo");
			OrigOrderNo.addContent((String) m.get("OrigOrderNo"));
			
			Element ArticleNo = new Element("ArticleNo");
			ArticleNo.addContent((String) m.get("ArticleNo"));
			
			Element SkuCode = new Element("SkuCode");
			SkuCode.addContent((String) m.get("SkuCode"));
			
			Element Num = new Element("Num");
			if(WebUtil.isNotNull(m.get("Num")))
				Num.addContent( m.get("Num").toString());
			else
				Num.addContent("0");
			
			Element RamLine = new Element("RamLine");

			RamLine.addContent(ArticleNo);
			RamLine.addContent(SkuCode);
			RamLine.addContent(Num);
			
			orderElement.addContent(ChannelType);
			orderElement.addContent(OrderNo);
			orderElement.addContent(OrigOrderNo);
			orderElement.addContent(RamLine);
			rootElement.addContent(orderElement);
		}
		return xmlToString(rootElement);
	}

	public Map returnResultReturn(String str) {
		Map result = new HashMap();
		Document document = readStrToXml(str, result);
		if (document == null)
		{
			result.put("Flag", "error");
			result.put("Message", "XML格式解析错误");
			return result;
		}
		Element root = document.getRootElement();
		List<Element> orderElementList = root.getChildren("order");
		List<String> successList = new ArrayList();
		List<String> errorList = new ArrayList();
		if(!WebUtil.isNullForList(orderElementList))
		{
			for(Element el:orderElementList)
			{
				if(el.getChildTextTrim("result").equalsIgnoreCase("true"))
				{
					successList.add(el.getChildTextTrim("OrderNo"));
				}
				else
				{
					errorList.add(el.getChildTextTrim("OrderNo"));
					logger.error("退货信息上传错误：OrderNo："+el.getChildTextTrim("OrderNo")+",message:"+el.getChildTextTrim("comment"));
				}
			}
		}
		result.put("Flag", "success");
		result.put("SuccessList", successList);
		result.put("ErrorList", errorList);
		return result;
	}

	public String stockSyncParam(Map param) {
		List<Map> inventoryList = (List) param.get("InventoryList");
		Element rootElement = new Element("Stock_Synchronization");
		for (Map m : inventoryList) {
			Element productElement = new Element("product");
			Element ChannelType = new Element("ChannelType");
			ChannelType.addContent("Official");
			Element LastUpdateTime = new Element("LastUpdateTime");
			if (WebUtil.isNotNull(m.get("StockUpdateTime")))
				LastUpdateTime.addContent(WebUtil.formatDateString((Date) m
						.get("StockUpdateTime"), "yyyy-MM-dd HH:mm:ss"));
			Element ArticleNo = new Element("ArticleNo");
			ArticleNo.addContent((String) m.get("ArticleNo"));
			Element SkuStock = new Element("SkuStock");
			SkuStock.addContent((String) m.get("SkuStock"));
			// Element qty = new Element("qty");
			// qty.addContent("");
			productElement.addContent(ChannelType);
			productElement.addContent(LastUpdateTime);
			productElement.addContent(ArticleNo);
			productElement.addContent(SkuStock);
			// productElement.addContent(qty);
			rootElement.addContent(productElement);
		}
		return xmlToString(rootElement);
	}

	public Map stockSyncReturn(String str) {
		Map result = new HashMap();
		Document document = readStrToXml(str, result);
		if (document == null)
		{
			result.put("Flag", "error");
			result.put("Message", "XML格式解析错误");
			return result;
		}
		Element root = document.getRootElement();

		result.put("Flag", "success");
		result.put("StartDate", root.getChildTextTrim("started_at"));
		result.put("EndDate", root.getChildTextTrim("end_at"));
		result.put("RequestTotal", root.getChildTextTrim("request_total"));
		//成功信息
		if(root.getChild("success")!=null)
		{
			result.put("Success", root.getChild("success")
					.getChildTextTrim("count"));
			List<Element> successList = root.getChild("success").getChildren(
					"product");
			if (!WebUtil.isNullForList(successList)) {
				List sList = new ArrayList();
				for (Element el : successList) {
//					Map m = new HashMap();
//					m.put("SkuCd", el.getChildTextTrim("sku"));
//					m.put("OrigStock", el.getChildTextTrim("orignal_stock"));
//					m.put("NewStock", el.getChildTextTrim("new_stock"));
//					sList.add(m);
					sList.add(el.getChildTextTrim("sku"));
				}
				result.put("SuccessList", sList);
			}
		}
		if(root.getChild("failed")!=null)
		{
			//错误信息
			result.put("Error", root.getChild("failed").getChildTextTrim("count"));
			List<Element> errorList = root.getChild("failed")
					.getChildren("product");
			if (!WebUtil.isNullForList(errorList)) {
				List sList = new ArrayList();
				for (Element el : errorList) {
//					Map m = new HashMap();
//					m.put("SkuCd", el.getChildTextTrim("sku"));
//					m.put("errors", el.getChildTextTrim("errors"));
//					sList.add(m);
					sList.add(el.getChildTextTrim("sku"));
				}
				result.put("ErrorList", sList);
				if(root.getChild("failed").getChildText("comment")!=null)
				result.put("Comment", root.getChild("failed").getChildTextTrim(
						"comment"));
				if(root.getChild("failed").getChildText("reserve")!=null)
				result.put("Reserve", root.getChild("failed").getChildTextTrim(
						"reserve"));
			}
		}		
		return result;
	}
	//库存返回参数，有变化，只返回是否成功
	public Map stockSyncReturnV1(String str) {
		Map result = new HashMap();
		Document document = readStrToXml(str, result);
		if (document == null)
		{
			result.put("Flag", "error");
			result.put("Message", "XML格式解析错误");
			return result;
		}
		result.put("Flag", "success");
		Element root = document.getRootElement();
		String rs = root.getChildTextTrim("result");
		String error = root.getChildTextTrim("error");
		if(rs!=null&&rs.equals("true"))
			result.put("isSuccess", "true");
		else
			result.put("isSuccess", "false");
		result.put("Comment", error);		
		return result;
	}

	public String priceSyncParam(Map param) {
		List<Map> priceList = (List) param.get("PriceList");
		Element rootElement = new Element("Price_Synchronization");
		for (Map m : priceList) {
			Element productElement = new Element("product");
			Element ChannelType = new Element("ChannelType");
			ChannelType.addContent("Official");
			Element ArticleNo = new Element("ArticleNo");
			ArticleNo.addContent((String) m.get("ArticleNo"));
			Element SkuPrice = new Element("SkuPrice");
			SkuPrice.addContent((String) m.get("SkuPrice"));
			productElement.addContent(ChannelType);
			productElement.addContent(ArticleNo);
			productElement.addContent(SkuPrice);
			rootElement.addContent(productElement);
		}
		return xmlToString(rootElement);
	}

	public Map priceSyncReturn(String str) {
		Map result = new HashMap();
		Document document = readStrToXml(str, result);
		if (document == null)
		{
			result.put("Flag", "error");
			result.put("Message", "XML格式解析错误");
			return result;
		}
		Element root = document.getRootElement();

		result.put("Flag", "success");
		result.put("StartDate", root.getChildTextTrim("started_at"));
		result.put("EndDate", root.getChildTextTrim("end_at"));
		result.put("RequestTotal", root.getChildTextTrim("request_total"));
		//成功信息
		result.put("Success", root.getChild("success")
				.getChildTextTrim("count"));
		List<Element> successList = root.getChild("success").getChildren(
				"product");
		if (!WebUtil.isNullForList(successList)) {
			List sList = new ArrayList();
			for (Element el : successList) {
//				Map m = new HashMap();
//				m.put("SkuCd", el.getChildTextTrim("sku"));
//				m.put("OrigPrice", el.getChildTextTrim("orignal_price"));
//				m.put("NewPrice", el.getChildTextTrim("new_price"));
//				sList.add(m);
				sList.add(el.getChildTextTrim("sku"));
			}
			result.put("SuccessList", sList);
		}
		//错误信息
		result.put("Error", root.getChild("failed").getChildTextTrim("count"));
		List<Element> errorList = root.getChild("failed")
				.getChildren("product");
		if (!WebUtil.isNullForList(errorList)) {
			List sList = new ArrayList();
			for (Element el : errorList) {
//				Map m = new HashMap();
//				m.put("SkuCd", el.getChildTextTrim("sku"));
//				m.put("errors", el.getChildTextTrim("errors"));
//				sList.add(m);
				sList.add(el.getChildTextTrim("sku"));
			}
			result.put("ErrorList", sList);
			if(root.getChild("failed").getChildText("comment")!=null)
			result.put("Comment", root.getChild("failed").getChildTextTrim(
					"comment"));
			if(root.getChild("failed").getChildText("reserve")!=null)
			result.put("Reserve", root.getChild("failed").getChildTextTrim(
					"reserve"));
		}
		return result;
	}
	//价格返回参数，有变化，只返回是否成功
	public Map priceSyncReturnV1(String str) {
		Map result = new HashMap();
		Document document = readStrToXml(str, result);
		if (document == null)
		{
			result.put("Flag", "error");
			result.put("Message", "XML格式解析错误");
			return result;
		}
		result.put("Flag", "success");
		Element root = document.getRootElement();
		String rs = root.getChildTextTrim("result");
		String error = root.getChildTextTrim("error");
		if(rs!=null&&rs.equals("true"))
			result.put("isSuccess", "true");
		else
			result.put("isSuccess", "false");
		result.put("Comment", error);		
		return result;
	}
}