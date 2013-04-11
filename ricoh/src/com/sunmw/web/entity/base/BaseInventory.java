package com.sunmw.web.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the inventory table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="inventory"
 */

public abstract class BaseInventory  implements Serializable {

	public static String REF = "Inventory";
	public static String PROP_MTIME = "Mtime";
	public static String PROP_QUANTITY = "Quantity";
	public static String PROP_INV_TYPE = "InvType";
	public static String PROP_INV_STATUS = "InvStatus";
	public static String PROP_ID = "Id";
	public static String PROP_CTIME = "Ctime";
	public static String PROP_WH_ID = "WhId";
	public static String PROP_AVAILABLE_QUANTITY = "AvailableQuantity";
	public static String PROP_SKU_CD = "SkuCd";
	public static String PROP_INV_CATE = "InvCate";
	public static String PROP_SKU_NAME = "SkuName";


	// constructors
	public BaseInventory () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseInventory (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	 java.lang.Integer version;

	// fields
	private java.lang.String invType;
	private java.lang.String invCate;
	private java.lang.String skuCd;
	private java.lang.String skuName;
	private java.lang.Integer quantity;
	private java.lang.Integer availableQuantity;
	private java.lang.String invStatus;
	private java.lang.String whId;
	private java.util.Date ctime;
	private java.util.Date mtime;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="identity"
     *  column="inv_id"
     */
	public java.lang.Integer getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (java.lang.Integer id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}



	/**
	 * Return the value associated with the column: version
	 */
	public java.lang.Integer getVersion () {
		return version;
	}

	/**
	 * Set the value related to the column: version
	 * @param version the version value
	 */
	public void setVersion (java.lang.Integer version) {
		this.version = version;
	}




	/**
	 * Return the value associated with the column: inv_type
	 */
	public java.lang.String getInvType () {
		return invType;
	}

	/**
	 * Set the value related to the column: inv_type
	 * @param invType the inv_type value
	 */
	public void setInvType (java.lang.String invType) {
		this.invType = invType;
	}



	/**
	 * Return the value associated with the column: inv_cate
	 */
	public java.lang.String getInvCate () {
		return invCate;
	}

	/**
	 * Set the value related to the column: inv_cate
	 * @param invCate the inv_cate value
	 */
	public void setInvCate (java.lang.String invCate) {
		this.invCate = invCate;
	}



	/**
	 * Return the value associated with the column: sku_cd
	 */
	public java.lang.String getSkuCd () {
		return skuCd;
	}

	/**
	 * Set the value related to the column: sku_cd
	 * @param skuCd the sku_cd value
	 */
	public void setSkuCd (java.lang.String skuCd) {
		this.skuCd = skuCd;
	}



	/**
	 * Return the value associated with the column: sku_name
	 */
	public java.lang.String getSkuName () {
		return skuName;
	}

	/**
	 * Set the value related to the column: sku_name
	 * @param skuName the sku_name value
	 */
	public void setSkuName (java.lang.String skuName) {
		this.skuName = skuName;
	}



	/**
	 * Return the value associated with the column: quantity
	 */
	public java.lang.Integer getQuantity () {
		return quantity;
	}

	/**
	 * Set the value related to the column: quantity
	 * @param quantity the quantity value
	 */
	public void setQuantity (java.lang.Integer quantity) {
		this.quantity = quantity;
	}



	/**
	 * Return the value associated with the column: available_quantity
	 */
	public java.lang.Integer getAvailableQuantity () {
		return availableQuantity;
	}

	/**
	 * Set the value related to the column: available_quantity
	 * @param availableQuantity the available_quantity value
	 */
	public void setAvailableQuantity (java.lang.Integer availableQuantity) {
		this.availableQuantity = availableQuantity;
	}



	/**
	 * Return the value associated with the column: inv_status
	 */
	public java.lang.String getInvStatus () {
		return invStatus;
	}

	/**
	 * Set the value related to the column: inv_status
	 * @param invStatus the inv_status value
	 */
	public void setInvStatus (java.lang.String invStatus) {
		this.invStatus = invStatus;
	}



	/**
	 * Return the value associated with the column: wh_id
	 */
	public java.lang.String getWhId () {
		return whId;
	}

	/**
	 * Set the value related to the column: wh_id
	 * @param whId the wh_id value
	 */
	public void setWhId (java.lang.String whId) {
		this.whId = whId;
	}



	/**
	 * Return the value associated with the column: ctime
	 */
	public java.util.Date getCtime () {
		return ctime;
	}

	/**
	 * Set the value related to the column: ctime
	 * @param ctime the ctime value
	 */
	public void setCtime (java.util.Date ctime) {
		this.ctime = ctime;
	}



	/**
	 * Return the value associated with the column: mtime
	 */
	public java.util.Date getMtime () {
		return mtime;
	}

	/**
	 * Set the value related to the column: mtime
	 * @param mtime the mtime value
	 */
	public void setMtime (java.util.Date mtime) {
		this.mtime = mtime;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.sunmw.web.entity.Inventory)) return false;
		else {
			com.sunmw.web.entity.Inventory inventory = (com.sunmw.web.entity.Inventory) obj;
			if (null == this.getId() || null == inventory.getId()) return false;
			else return (this.getId().equals(inventory.getId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}