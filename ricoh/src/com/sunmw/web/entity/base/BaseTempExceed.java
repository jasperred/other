package com.sunmw.web.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the temp_exceed table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="temp_exceed"
 */

public abstract class BaseTempExceed  implements Serializable {

	public static String REF = "TempExceed";
	public static String PROP_READER_TIME = "ReaderTime";
	public static String PROP_FLAG = "Flag";
	public static String PROP_EXTERN_ORDER_KEY = "ExternOrderKey";
	public static String PROP_CUSTOMER_NO = "CustomerNo";
	public static String PROP_CUSTOMER_NAME = "CustomerName";
	public static String PROP_IMPORT_USER = "ImportUser";
	public static String PROP_EDIT_DATE = "EditDate";
	public static String PROP_EXCEED_DBID = "ExceedDbid";
	public static String PROP_ITEM_NO = "ItemNo";
	public static String PROP_SERIAL_NO = "SerialNo";
	public static String PROP_ID = "Id";
	public static String PROP_WRITER_TIME = "WriterTime";
	public static String PROP_ITEM_DESCRIPTION = "ItemDescription";


	// constructors
	public BaseTempExceed () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseTempExceed (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String exceedDbid;
	private java.util.Date editDate;
	private java.lang.String externOrderKey;
	private java.lang.String customerNo;
	private java.lang.String customerName;
	private java.lang.String itemNo;
	private java.lang.String itemDescription;
	private java.lang.String serialNo;
	private java.lang.String flag;
	private java.util.Date writerTime;
	private java.util.Date readerTime;
	private java.lang.String importUser;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="identity"
     *  column="id"
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
	 * Return the value associated with the column: exceed_dbid
	 */
	public java.lang.String getExceedDbid () {
		return exceedDbid;
	}

	/**
	 * Set the value related to the column: exceed_dbid
	 * @param exceedDbid the exceed_dbid value
	 */
	public void setExceedDbid (java.lang.String exceedDbid) {
		this.exceedDbid = exceedDbid;
	}



	/**
	 * Return the value associated with the column: edit_date
	 */
	public java.util.Date getEditDate () {
		return editDate;
	}

	/**
	 * Set the value related to the column: edit_date
	 * @param editDate the edit_date value
	 */
	public void setEditDate (java.util.Date editDate) {
		this.editDate = editDate;
	}



	/**
	 * Return the value associated with the column: extern_order_key
	 */
	public java.lang.String getExternOrderKey () {
		return externOrderKey;
	}

	/**
	 * Set the value related to the column: extern_order_key
	 * @param externOrderKey the extern_order_key value
	 */
	public void setExternOrderKey (java.lang.String externOrderKey) {
		this.externOrderKey = externOrderKey;
	}



	/**
	 * Return the value associated with the column: customer_no
	 */
	public java.lang.String getCustomerNo () {
		return customerNo;
	}

	/**
	 * Set the value related to the column: customer_no
	 * @param customerNo the customer_no value
	 */
	public void setCustomerNo (java.lang.String customerNo) {
		this.customerNo = customerNo;
	}



	/**
	 * Return the value associated with the column: customer_name
	 */
	public java.lang.String getCustomerName () {
		return customerName;
	}

	/**
	 * Set the value related to the column: customer_name
	 * @param customerName the customer_name value
	 */
	public void setCustomerName (java.lang.String customerName) {
		this.customerName = customerName;
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
	 * Return the value associated with the column: item_description
	 */
	public java.lang.String getItemDescription () {
		return itemDescription;
	}

	/**
	 * Set the value related to the column: item_description
	 * @param itemDescription the item_description value
	 */
	public void setItemDescription (java.lang.String itemDescription) {
		this.itemDescription = itemDescription;
	}



	/**
	 * Return the value associated with the column: serial_no
	 */
	public java.lang.String getSerialNo () {
		return serialNo;
	}

	/**
	 * Set the value related to the column: serial_no
	 * @param serialNo the serial_no value
	 */
	public void setSerialNo (java.lang.String serialNo) {
		this.serialNo = serialNo;
	}



	/**
	 * Return the value associated with the column: flag
	 */
	public java.lang.String getFlag () {
		return flag;
	}

	/**
	 * Set the value related to the column: flag
	 * @param flag the flag value
	 */
	public void setFlag (java.lang.String flag) {
		this.flag = flag;
	}



	/**
	 * Return the value associated with the column: writer_time
	 */
	public java.util.Date getWriterTime () {
		return writerTime;
	}

	/**
	 * Set the value related to the column: writer_time
	 * @param writerTime the writer_time value
	 */
	public void setWriterTime (java.util.Date writerTime) {
		this.writerTime = writerTime;
	}



	/**
	 * Return the value associated with the column: reader_time
	 */
	public java.util.Date getReaderTime () {
		return readerTime;
	}

	/**
	 * Set the value related to the column: reader_time
	 * @param readerTime the reader_time value
	 */
	public void setReaderTime (java.util.Date readerTime) {
		this.readerTime = readerTime;
	}



	/**
	 * Return the value associated with the column: import_user
	 */
	public java.lang.String getImportUser () {
		return importUser;
	}

	/**
	 * Set the value related to the column: import_user
	 * @param importUser the import_user value
	 */
	public void setImportUser (java.lang.String importUser) {
		this.importUser = importUser;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.sunmw.web.entity.TempExceed)) return false;
		else {
			com.sunmw.web.entity.TempExceed tempExceed = (com.sunmw.web.entity.TempExceed) obj;
			if (null == this.getId() || null == tempExceed.getId()) return false;
			else return (this.getId().equals(tempExceed.getId()));
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