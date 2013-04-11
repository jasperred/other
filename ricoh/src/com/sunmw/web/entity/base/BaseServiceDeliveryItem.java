package com.sunmw.web.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the service_delivery_item table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="service_delivery_item"
 */

public abstract class BaseServiceDeliveryItem  implements Serializable {

	public static String REF = "ServiceDeliveryItem";
	public static String PROP_SERVICE_DELIVERY_ID = "ServiceDeliveryId";
	public static String PROP_ITEM_ORDER_DATE = "ItemOrderDate";
	public static String PROP_ITEM_CHANGE = "ItemChange";
	public static String PROP_ITEM_CATE = "ItemCate";
	public static String PROP_ITEM_DELIVERY_DATE = "ItemDeliveryDate";
	public static String PROP_ITEM_ARRIVAL_DATE = "ItemArrivalDate";
	public static String PROP_HAS_INV = "HasInv";
	public static String PROP_MTIME = "Mtime";
	public static String PROP_CUSER = "Cuser";
	public static String PROP_ITEM_TYPE = "ItemType";
	public static String PROP_ITEM_SERIAL_NO = "ItemSerialNo";
	public static String PROP_ITEM_NAME = "ItemName";
	public static String PROP_ITEM_NO = "ItemNo";
	public static String PROP_ID = "Id";
	public static String PROP_CTIME = "Ctime";
	public static String PROP_MUSER = "Muser";
	public static String PROP_NEW_ITEM_NO = "NewItemNo";
	public static String PROP_ITEM_ORDER_NO = "ItemOrderNo";
	public static String PROP_ITEM_QTY = "ItemQty";


	// constructors
	public BaseServiceDeliveryItem () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseServiceDeliveryItem (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer serviceDeliveryId;
	private java.lang.String itemType;
	private java.lang.String itemCate;
	private java.lang.String itemName;
	private java.lang.String itemNo;
	private java.lang.Integer itemQty;
	private java.lang.String itemSerialNo;
	private java.lang.String itemChange;
	private java.lang.String newItemNo;
	private java.lang.String hasInv;
	private java.lang.String itemOrderNo;
	private java.util.Date itemOrderDate;
	private java.util.Date itemDeliveryDate;
	private java.util.Date itemArrivalDate;
	private java.util.Date ctime;
	private java.lang.String cuser;
	private java.util.Date mtime;
	private java.lang.String muser;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="identity"
     *  column="service_delivery_item_id"
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
	 * Return the value associated with the column: service_delivery_id
	 */
	public java.lang.Integer getServiceDeliveryId () {
		return serviceDeliveryId;
	}

	/**
	 * Set the value related to the column: service_delivery_id
	 * @param serviceDeliveryId the service_delivery_id value
	 */
	public void setServiceDeliveryId (java.lang.Integer serviceDeliveryId) {
		this.serviceDeliveryId = serviceDeliveryId;
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
	 * Return the value associated with the column: item_qty
	 */
	public java.lang.Integer getItemQty () {
		return itemQty;
	}

	/**
	 * Set the value related to the column: item_qty
	 * @param itemQty the item_qty value
	 */
	public void setItemQty (java.lang.Integer itemQty) {
		this.itemQty = itemQty;
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
	 * Return the value associated with the column: item_change
	 */
	public java.lang.String getItemChange () {
		return itemChange;
	}

	/**
	 * Set the value related to the column: item_change
	 * @param itemChange the item_change value
	 */
	public void setItemChange (java.lang.String itemChange) {
		this.itemChange = itemChange;
	}



	/**
	 * Return the value associated with the column: new_item_no
	 */
	public java.lang.String getNewItemNo () {
		return newItemNo;
	}

	/**
	 * Set the value related to the column: new_item_no
	 * @param newItemNo the new_item_no value
	 */
	public void setNewItemNo (java.lang.String newItemNo) {
		this.newItemNo = newItemNo;
	}



	/**
	 * Return the value associated with the column: has_inv
	 */
	public java.lang.String getHasInv () {
		return hasInv;
	}

	/**
	 * Set the value related to the column: has_inv
	 * @param hasInv the has_inv value
	 */
	public void setHasInv (java.lang.String hasInv) {
		this.hasInv = hasInv;
	}



	/**
	 * Return the value associated with the column: item_order_no
	 */
	public java.lang.String getItemOrderNo () {
		return itemOrderNo;
	}

	/**
	 * Set the value related to the column: item_order_no
	 * @param itemOrderNo the item_order_no value
	 */
	public void setItemOrderNo (java.lang.String itemOrderNo) {
		this.itemOrderNo = itemOrderNo;
	}



	/**
	 * Return the value associated with the column: item_order_date
	 */
	public java.util.Date getItemOrderDate () {
		return itemOrderDate;
	}

	/**
	 * Set the value related to the column: item_order_date
	 * @param itemOrderDate the item_order_date value
	 */
	public void setItemOrderDate (java.util.Date itemOrderDate) {
		this.itemOrderDate = itemOrderDate;
	}



	/**
	 * Return the value associated with the column: item_delivery_date
	 */
	public java.util.Date getItemDeliveryDate () {
		return itemDeliveryDate;
	}

	/**
	 * Set the value related to the column: item_delivery_date
	 * @param itemDeliveryDate the item_delivery_date value
	 */
	public void setItemDeliveryDate (java.util.Date itemDeliveryDate) {
		this.itemDeliveryDate = itemDeliveryDate;
	}



	/**
	 * Return the value associated with the column: item_arrival_date
	 */
	public java.util.Date getItemArrivalDate () {
		return itemArrivalDate;
	}

	/**
	 * Set the value related to the column: item_arrival_date
	 * @param itemArrivalDate the item_arrival_date value
	 */
	public void setItemArrivalDate (java.util.Date itemArrivalDate) {
		this.itemArrivalDate = itemArrivalDate;
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
		if (!(obj instanceof com.sunmw.web.entity.ServiceDeliveryItem)) return false;
		else {
			com.sunmw.web.entity.ServiceDeliveryItem serviceDeliveryItem = (com.sunmw.web.entity.ServiceDeliveryItem) obj;
			if (null == this.getId() || null == serviceDeliveryItem.getId()) return false;
			else return (this.getId().equals(serviceDeliveryItem.getId()));
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