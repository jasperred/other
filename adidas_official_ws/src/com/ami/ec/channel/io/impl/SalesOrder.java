package com.ami.ec.channel.io.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@javax.xml.bind.annotation.XmlType(name="SalesOrder")
public class SalesOrder {
	private String ChannelType;
	private String OrderNo;
	private String BuyerID;
	private String BuyerName;
	private String BuyerEmail;
	private BigDecimal GoodsFee;
	private BigDecimal GoodsDiscountFee;
	private BigDecimal RealGoodsFee;
	/**2012.08.14 sunmw 增加官网的4种折扣方式*/
	private BigDecimal Coupon;
	private BigDecimal GiftCard;
	private BigDecimal RewardPoint;
	private BigDecimal StoreCredit;
	/**2012.08.14 sunmw 增加官网的4种折扣方式**/
	private BigDecimal PostFee;
	private Date CreateTime;
	private Date PayTime;
	private Date LastModifyTime;
	private String OrderStatus;
	private String Remark;
	private String PostType;
	private String DeliverCompany;
	private String ReceiverName;
	private String ReceiverState;
	private String ReceiverCity;
	private String ReceiverDistrinct;
	private String ReceiverZip;
	private String ReceiverAddress;
	private String ReceiverPhone;
	private String ReceiverMobile;
	private String InvoiceNeed;
	private String InvoiceTitle;
	private String InvoiceAddress;
	private String InvoiceComment;
	private List<OrderLine> OrderLines;
	
	public String getChannelType() {
		return ChannelType;
	}
	public void setChannelType(String channelType) {
		ChannelType = channelType;
	}
	public String getOrderNo() {
		return OrderNo;
	}
	public void setOrderNo(String orderNo) {
		OrderNo = orderNo;
	}
	public String getBuyerID() {
		return BuyerID;
	}
	public void setBuyerID(String buyerID) {
		BuyerID = buyerID;
	}
	public String getBuyerName() {
		return BuyerName;
	}
	public void setBuyerName(String buyerName) {
		BuyerName = buyerName;
	}
	public String getBuyerEmail() {
		return BuyerEmail;
	}
	public void setBuyerEmail(String buyerEmail) {
		BuyerEmail = buyerEmail;
	}
	public BigDecimal getGoodsFee() {
		return GoodsFee;
	}
	public void setGoodsFee(BigDecimal goodsFee) {
		GoodsFee = goodsFee;
	}
	public BigDecimal getGoodsDiscountFee() {
		return GoodsDiscountFee;
	}
	public void setGoodsDiscountFee(BigDecimal goodsDiscountFee) {
		GoodsDiscountFee = goodsDiscountFee;
	}
	public BigDecimal getRealGoodsFee() {
		return RealGoodsFee;
	}
	public void setRealGoodsFee(BigDecimal realGoodsFee) {
		RealGoodsFee = realGoodsFee;
	}
	public BigDecimal getCoupon() {
		return Coupon;
	}
	public void setCoupon(BigDecimal coupon) {
		Coupon = coupon;
	}
	public BigDecimal getGiftCard() {
		return GiftCard;
	}
	public void setGiftCard(BigDecimal giftCard) {
		GiftCard = giftCard;
	}
	public BigDecimal getRewardPoint() {
		return RewardPoint;
	}
	public void setRewardPoint(BigDecimal rewardPoint) {
		RewardPoint = rewardPoint;
	}
	public BigDecimal getStoreCredit() {
		return StoreCredit;
	}
	public void setStoreCredit(BigDecimal storeCredit) {
		StoreCredit = storeCredit;
	}
	public BigDecimal getPostFee() {
		return PostFee;
	}
	public void setPostFee(BigDecimal postFee) {
		PostFee = postFee;
	}
	public Date getCreateTime() {
		return CreateTime;
	}
	public void setCreateTime(Date createTime) {
		CreateTime = createTime;
	}
	public Date getPayTime() {
		return PayTime;
	}
	public void setPayTime(Date payTime) {
		PayTime = payTime;
	}
	public Date getLastModifyTime() {
		return LastModifyTime;
	}
	public void setLastModifyTime(Date lastModifyTime) {
		LastModifyTime = lastModifyTime;
	}
	public String getOrderStatus() {
		return OrderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		OrderStatus = orderStatus;
	}
	public String getRemark() {
		return Remark;
	}
	public void setRemark(String remark) {
		Remark = remark;
	}
	public String getPostType() {
		return PostType;
	}
	public void setPostType(String postType) {
		PostType = postType;
	}
	public String getDeliverCompany() {
		return DeliverCompany;
	}
	public void setDeliverCompany(String deliverCompany) {
		DeliverCompany = deliverCompany;
	}
	public String getReceiverName() {
		return ReceiverName;
	}
	public void setReceiverName(String receiverName) {
		ReceiverName = receiverName;
	}
	public String getReceiverState() {
		return ReceiverState;
	}
	public void setReceiverState(String receiverState) {
		ReceiverState = receiverState;
	}
	public String getReceiverCity() {
		return ReceiverCity;
	}
	public void setReceiverCity(String receiverCity) {
		ReceiverCity = receiverCity;
	}
	public String getReceiverDistrinct() {
		return ReceiverDistrinct;
	}
	public void setReceiverDistrinct(String receiverDistrinct) {
		ReceiverDistrinct = receiverDistrinct;
	}
	public String getReceiverZip() {
		return ReceiverZip;
	}
	public void setReceiverZip(String receiverZip) {
		ReceiverZip = receiverZip;
	}
	public String getReceiverAddress() {
		return ReceiverAddress;
	}
	public void setReceiverAddress(String receiverAddress) {
		ReceiverAddress = receiverAddress;
	}
	public String getReceiverPhone() {
		return ReceiverPhone;
	}
	public void setReceiverPhone(String receiverPhone) {
		ReceiverPhone = receiverPhone;
	}
	public String getReceiverMobile() {
		return ReceiverMobile;
	}
	public void setReceiverMobile(String receiverMobile) {
		ReceiverMobile = receiverMobile;
	}
	public String getInvoiceNeed() {
		return InvoiceNeed;
	}
	public void setInvoiceNeed(String invoiceNeed) {
		InvoiceNeed = invoiceNeed;
	}
	public String getInvoiceTitle() {
		return InvoiceTitle;
	}
	public void setInvoiceTitle(String invoiceTitle) {
		InvoiceTitle = invoiceTitle;
	}
	public String getInvoiceAddress() {
		return InvoiceAddress;
	}
	public void setInvoiceAddress(String invoiceAddress) {
		InvoiceAddress = invoiceAddress;
	}
	public String getInvoiceComment() {
		return InvoiceComment;
	}
	public void setInvoiceComment(String invoiceComment) {
		InvoiceComment = invoiceComment;
	}
	public List<OrderLine> getOrderLines() {
		return OrderLines;
	}
	public void setOrderLines(List<OrderLine> orderLines) {
		OrderLines = orderLines;
	}
}
