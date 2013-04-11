package com.sunmw.web.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the service_item table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="service_item"
 */

public abstract class BaseServiceItem  implements Serializable {

	public static String REF = "ServiceItem";
	public static String PROP_ITEM_CATE = "ItemCate";
	public static String PROP_QTY = "Qty";
	public static String PROP_MTIME = "Mtime";
	public static String PROP_ITEM_STATUS = "ItemStatus";
	public static String PROP_CUSER = "Cuser";
	public static String PROP_ITEM_TYPE = "ItemType";
	public static String PROP_ITEM_SERIAL_NO = "ItemSerialNo";
	public static String PROP_ITEM_NAME = "ItemName";
	public static String PROP_ITEM_NO = "ItemNo";
	public static String PROP_SERVICE_ID = "ServiceId";
	public static String PROP_CTIME = "Ctime";
	public static String PROP_ID = "Id";
	public static String PROP_MUSER = "Muser";


	// constructors
	public BaseServiceItem () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseServiceItem (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer serviceId;
	private java.lang.String itemType;
	private java.lang.String itemStatus;
	private java.lang.String itemName;
	private java.lang.String itemNo;
	private java.lang.Integer qty;
	private java.lang.String itemCate;
	private java.lang.String itemSerialNo;
	private java.util.Date ctime;
	private java.util.Date mtime;
	private java.lang.String cuser;
	private java.lang.String muser;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="identity"
     *  column="service_item_id"
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
	 * Return the value associated with the column: service_id
	 */
	public java.lang.Integer getServiceId () {
		return serviceId;
	}

	/**
	 * Set the value related to the column: service_id
	 * @param serviceId the service_id value
	 */
	public void setServiceId (java.lang.Integer serviceId) {
		this.serviceId = serviceId;
	}



	/**
	 * Return the value associated with the column: item_type
	 */
	public java.lang.String getItemType () {
		return itemType;
	}

	/**
	 * Set the value related to the column: item_type
	 * @param itemType the item_type value
	 */
	public void setItemType (java.lang.String itemType) {
		this.itemType = itemType;
	}



	/**
	 * Return the value associated with the column: item_status
	 */
	public java.lang.String getItemStatus () {
		return itemStatus;
	}

	/**
	 * Set the value related to the column: item_status
	 * @param itemStatus the item_status value
	 */
	public void setItemStatus (java.lang.String itemStatus) {
		this.itemStatus = itemStatus;
	}



	/**
	 * Return the value associated with the column: item_name
	 */
	public java.lang.String getItemName () {
		return itemName;
	}

	/**
	 * Set the value related to the column: item_name
	 * @param itemName the item_name value
	 */
	public void setItemName (java.lang.String itemName) {
		this.itemName = itemName;
	}



	/**
	 * Return the value associated with the column: item_no
	 */
	public java.lang.String getItemNo () {
		return itemNo;
	}

	/**
	 * Set the value related to the column: item_no
	 * @param itemNo the item_no value
	 */
	public void setItemNo (java.lang.String itemNo) {
		this.itemNo = itemNo;
	}



	/**
	 * Return the value associated with the column: qty
	 */
	public java.lang.Integer getQty () {
		return qty;
	}

	/**
	 * Set the value related to the column: qty
	 * @param qty the qty value
	 */
	public void setQty (java.lang.Integer qty) {
		this.qty = qty;
	}



	/**
	 * Return the value associated with the column: item_cate
	 */
	public java.lang.String getItemCate () {
		return itemCate;
	}

	/**
	 * Set the value related to the column: item_cate
	 * @param itemCate the item_cate value
	 */
	public void setItemCate (java.lang.String itemCate) {
		this.itemCate = itemCate;
	}



	/**
	 * Return the value associated with the column: item_serial_no
	 */
	public java.lang.String getItemSerialNo () {
		return itemSerialNo;
	}

	/**
	 * Set the value related to the column: item_serial_no
	 * @param itemSerialNo the item_serial_no value
	 */
	public void setItemSerialNo (java.lang.String itemSerialNo) {
		this.itemSerialNo = itemSerialNo;
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



	/**
	 * Return the value associated with the column: cuser
	 */
	public java.lang.String getCuser () {
		return cuser;
	}

	/**
	 * Set the value related to the column: cuser
	 * @param cuser the cuser value
	 */
	public void setCuser (java.lang.String cuser) {
		this.cuser = cuser;
	}



	/**
	 * Return the value associated with the column: muser
	 */
	public java.lang.String getMuser () {
		return muser;
	}

	/**
	 * Set the value related to the column: muser
	 * @param muser the muser value
	 */
	public void setMuser (java.lang.String muser) {
		this.muser = muser;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.sunmw.web.entity.ServiceItem)) return false;
		else {
			com.sunmw.web.entity.ServiceItem serviceItem = (com.sunmw.web.entity.ServiceItem) obj;
			if (null == this.getId() || null == serviceItem.getId()) return false;
			else return (this.getId().equals(serviceItem.getId()));
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