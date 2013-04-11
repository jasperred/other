package com.ami.ifs.dao;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.cxf.aegis.type.java5.XmlType;

@javax.xml.bind.annotation.XmlType(name="OUnitSkuMaster")
public class OUnitSkuMaster {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column O_Unit_Sku_Master.Store_Id
     *
     * @mbggenerated
     */
    private Long storeId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column O_Unit_Sku_Master.Operate_Type
     *
     * @mbggenerated
     */
    private String operateType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column O_Unit_Sku_Master.Ifs_A_Cd
     *
     * @mbggenerated
     */
    private String ifsACd;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column O_Unit_Sku_Master.Ifs_C_Cd
     *
     * @mbggenerated
     */
    private String ifsCCd;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column O_Unit_Sku_Master.Operate_Time
     *
     * @mbggenerated
     */
    private Date operateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column O_Unit_Sku_Master.Timestamp
     *
     * @mbggenerated
     */
    private Date timestamp;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column O_Unit_Sku_Master.Unit_Item_Id
     *
     * @mbggenerated
     */
    private String unitItemId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column O_Unit_Sku_Master.Unit_Sku_Id
     *
     * @mbggenerated
     */
    private String unitSkuId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column O_Unit_Sku_Master.Sku_Cd
     *
     * @mbggenerated
     */
    private String skuCd;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column O_Unit_Sku_Master.Inv_Qty
     *
     * @mbggenerated
     */
    private Long invQty;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column O_Unit_Sku_Master.Sold_Qty
     *
     * @mbggenerated
     */
    private Long soldQty;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column O_Unit_Sku_Master.Sku_Std_Price
     *
     * @mbggenerated
     */
    private BigDecimal skuPrice;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column O_Unit_Sku_Master.Remark
     *
     * @mbggenerated
     */
    private String remark;
    

    private Date lastOrderTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column O_Unit_Sku_Master.Store_Id
     *
     * @return the value of O_Unit_Sku_Master.Store_Id
     *
     * @mbggenerated
     */
    public Long getStoreId() {
        return storeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column O_Unit_Sku_Master.Store_Id
     *
     * @param storeId the value for O_Unit_Sku_Master.Store_Id
     *
     * @mbggenerated
     */
    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column O_Unit_Sku_Master.Operate_Type
     *
     * @return the value of O_Unit_Sku_Master.Operate_Type
     *
     * @mbggenerated
     */
    public String getOperateType() {
        return operateType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column O_Unit_Sku_Master.Operate_Type
     *
     * @param operateType the value for O_Unit_Sku_Master.Operate_Type
     *
     * @mbggenerated
     */
    public void setOperateType(String operateType) {
        this.operateType = operateType == null ? null : operateType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column O_Unit_Sku_Master.Ifs_A_Cd
     *
     * @return the value of O_Unit_Sku_Master.Ifs_A_Cd
     *
     * @mbggenerated
     */
    public String getIfsACd() {
        return ifsACd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column O_Unit_Sku_Master.Ifs_A_Cd
     *
     * @param ifsACd the value for O_Unit_Sku_Master.Ifs_A_Cd
     *
     * @mbggenerated
     */
    public void setIfsACd(String ifsACd) {
        this.ifsACd = ifsACd == null ? null : ifsACd.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column O_Unit_Sku_Master.Ifs_C_Cd
     *
     * @return the value of O_Unit_Sku_Master.Ifs_C_Cd
     *
     * @mbggenerated
     */
    public String getIfsCCd() {
        return ifsCCd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column O_Unit_Sku_Master.Ifs_C_Cd
     *
     * @param ifsCCd the value for O_Unit_Sku_Master.Ifs_C_Cd
     *
     * @mbggenerated
     */
    public void setIfsCCd(String ifsCCd) {
        this.ifsCCd = ifsCCd == null ? null : ifsCCd.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column O_Unit_Sku_Master.Operate_Time
     *
     * @return the value of O_Unit_Sku_Master.Operate_Time
     *
     * @mbggenerated
     */
    public Date getOperateTime() {
        return operateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column O_Unit_Sku_Master.Operate_Time
     *
     * @param operateTime the value for O_Unit_Sku_Master.Operate_Time
     *
     * @mbggenerated
     */
    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column O_Unit_Sku_Master.Timestamp
     *
     * @return the value of O_Unit_Sku_Master.Timestamp
     *
     * @mbggenerated
     */
    public Date getTimestamp() {
        return timestamp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column O_Unit_Sku_Master.Timestamp
     *
     * @param timestamp the value for O_Unit_Sku_Master.Timestamp
     *
     * @mbggenerated
     */
    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column O_Unit_Sku_Master.Unit_Item_Id
     *
     * @return the value of O_Unit_Sku_Master.Unit_Item_Id
     *
     * @mbggenerated
     */
    public String getUnitItemId() {
        return unitItemId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column O_Unit_Sku_Master.Unit_Item_Id
     *
     * @param unitItemId the value for O_Unit_Sku_Master.Unit_Item_Id
     *
     * @mbggenerated
     */
    public void setUnitItemId(String unitItemId) {
        this.unitItemId = unitItemId == null ? null : unitItemId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column O_Unit_Sku_Master.Unit_Sku_Id
     *
     * @return the value of O_Unit_Sku_Master.Unit_Sku_Id
     *
     * @mbggenerated
     */
    public String getUnitSkuId() {
        return unitSkuId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column O_Unit_Sku_Master.Unit_Sku_Id
     *
     * @param unitSkuId the value for O_Unit_Sku_Master.Unit_Sku_Id
     *
     * @mbggenerated
     */
    public void setUnitSkuId(String unitSkuId) {
        this.unitSkuId = unitSkuId == null ? null : unitSkuId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column O_Unit_Sku_Master.Sku_Cd
     *
     * @return the value of O_Unit_Sku_Master.Sku_Cd
     *
     * @mbggenerated
     */
    public String getSkuCd() {
        return skuCd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column O_Unit_Sku_Master.Sku_Cd
     *
     * @param skuCd the value for O_Unit_Sku_Master.Sku_Cd
     *
     * @mbggenerated
     */
    public void setSkuCd(String skuCd) {
        this.skuCd = skuCd == null ? null : skuCd.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column O_Unit_Sku_Master.Inv_Qty
     *
     * @return the value of O_Unit_Sku_Master.Inv_Qty
     *
     * @mbggenerated
     */
    public Long getInvQty() {
        return invQty;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column O_Unit_Sku_Master.Inv_Qty
     *
     * @param invQty the value for O_Unit_Sku_Master.Inv_Qty
     *
     * @mbggenerated
     */
    public void setInvQty(Long invQty) {
        this.invQty = invQty;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column O_Unit_Sku_Master.Sold_Qty
     *
     * @return the value of O_Unit_Sku_Master.Sold_Qty
     *
     * @mbggenerated
     */
    public Long getSoldQty() {
        return soldQty;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column O_Unit_Sku_Master.Sold_Qty
     *
     * @param soldQty the value for O_Unit_Sku_Master.Sold_Qty
     *
     * @mbggenerated
     */
    public void setSoldQty(Long soldQty) {
        this.soldQty = soldQty;
    }

    

    public BigDecimal getSkuPrice() {
		return skuPrice;
	}

	public void setSkuPrice(BigDecimal skuPrice) {
		this.skuPrice = skuPrice;
	}

	/**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column O_Unit_Sku_Master.Remark
     *
     * @return the value of O_Unit_Sku_Master.Remark
     *
     * @mbggenerated
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column O_Unit_Sku_Master.Remark
     *
     * @param remark the value for O_Unit_Sku_Master.Remark
     *
     * @mbggenerated
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

	public Date getLastOrderTime() {
		return lastOrderTime;
	}

	public void setLastOrderTime(Date lastOrderTime) {
		this.lastOrderTime = lastOrderTime;
	}
}