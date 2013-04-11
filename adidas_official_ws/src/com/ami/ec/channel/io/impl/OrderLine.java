package com.ami.ec.channel.io.impl;

import java.math.BigDecimal;

@javax.xml.bind.annotation.XmlType(name="OrderLine")
public class OrderLine {
	private int LineIndex;
	private String LineNo;
	private String ArticleNo;
	private String ArticleTitle;
	private String SkuCode;
	private String ColorName;
	private String SizeName;
	private int Num;
	private BigDecimal SalePrice;
	private BigDecimal DiscountPrice;
	private BigDecimal DiscountPriceAmt;
	private BigDecimal OrderPrice;
	private BigDecimal OrderPriceAmt;
	private BigDecimal RealPrice;
	private BigDecimal RealPriceAmt;
	public int getLineIndex() {
		return LineIndex;
	}
	public void setLineIndex(int lineIndex) {
		LineIndex = lineIndex;
	}
	public String getLineNo() {
		return LineNo;
	}
	public void setLineNo(String lineNo) {
		LineNo = lineNo;
	}
	public String getArticleNo() {
		return ArticleNo;
	}
	public void setArticleNo(String articleNo) {
		ArticleNo = articleNo;
	}
	public String getArticleTitle() {
		return ArticleTitle;
	}
	public void setArticleTitle(String articleTitle) {
		ArticleTitle = articleTitle;
	}
	public String getSkuCode() {
		return SkuCode;
	}
	public void setSkuCode(String skuCode) {
		SkuCode = skuCode;
	}
	public String getColorName() {
		return ColorName;
	}
	public void setColorName(String colorName) {
		ColorName = colorName;
	}
	public String getSizeName() {
		return SizeName;
	}
	public void setSizeName(String sizeName) {
		SizeName = sizeName;
	}
	public int getNum() {
		return Num;
	}
	public void setNum(int num) {
		Num = num;
	}
	public BigDecimal getSalePrice() {
		return SalePrice;
	}
	public void setSalePrice(BigDecimal salePrice) {
		SalePrice = salePrice;
	}
	public BigDecimal getDiscountPrice() {
		return DiscountPrice;
	}
	public void setDiscountPrice(BigDecimal discountPrice) {
		DiscountPrice = discountPrice;
	}
	public BigDecimal getDiscountPriceAmt() {
		return DiscountPriceAmt;
	}
	public void setDiscountPriceAmt(BigDecimal discountPriceAmt) {
		DiscountPriceAmt = discountPriceAmt;
	}
	public BigDecimal getOrderPrice() {
		return OrderPrice;
	}
	public void setOrderPrice(BigDecimal orderPrice) {
		OrderPrice = orderPrice;
	}
	public BigDecimal getOrderPriceAmt() {
		return OrderPriceAmt;
	}
	public void setOrderPriceAmt(BigDecimal orderPriceAmt) {
		OrderPriceAmt = orderPriceAmt;
	}
	public BigDecimal getRealPrice() {
		return RealPrice;
	}
	public void setRealPrice(BigDecimal realPrice) {
		RealPrice = realPrice;
	}
	public BigDecimal getRealPriceAmt() {
		return RealPriceAmt;
	}
	public void setRealPriceAmt(BigDecimal realPriceAmt) {
		RealPriceAmt = realPriceAmt;
	}
}
