package com.sunmw.web.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the service_delivery table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="service_delivery"
 */

public abstract class BaseServiceDelivery  implements Serializable {

	public static String REF = "ServiceDelivery";
	public static String PROP_DELIVERY_DATE = "DeliveryDate";
	public static String PROP_SERVICE_NO = "ServiceNo";
	public static String PROP_COMPANY_ID = "CompanyId";
	public static String PROP_SERVICE_APPLY_ID = "ServiceApplyId";
	public static String PROP_ALL_TIME = "AllTime";
	public static String PROP_SERVICE_DELIVERY_NO = "ServiceDeliveryNo";
	public static String PROP_STATUS = "Status";
	public static String PROP_MTIME = "Mtime";
	public static String PROP_CUSER = "Cuser";
	public static String PROP_DELIVERY_TIME = "DeliveryTime";
	public static String PROP_ID = "Id";
	public static String PROP_CTIME = "Ctime";
	public static String PROP_SERVICE_ID = "ServiceId";
	public static String PROP_MUSER = "Muser";
	public static String PROP_DELIVERY_STOCK = "DeliveryStock";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_AUDITED_TIME = "AuditedTime";
	public static String PROP_SHIPPING_NO = "ShippingNo";


	// constructors
	public BaseServiceDelivery () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseServiceDelivery (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String serviceDeliveryNo;
	private java.lang.Integer serviceApplyId;
	private java.lang.Integer serviceId;
	private java.lang.String serviceNo;
	private java.lang.Integer companyId;
	private java.lang.String department;
	private java.lang.String shippingNo;
	private java.lang.String deliveryStock;
	private java.util.Date deliveryDate;
	private java.lang.String status;
	private java.lang.String auditedTime;
	private java.lang.String deliveryTime;
	private java.lang.String allTime;
	private java.util.Date ctime;
	private java.lang.String cuser;
	private java.util.Date mtime;
	private java.lang.String muser;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="identity"
     *  column="service_delivery_id"
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
	 * Return the value associated with the column: service_delivery_no
	 */
	public java.lang.String getServiceDeliveryNo () {
		return serviceDeliveryNo;
	}

	/**
	 * Set the value related to the column: service_delivery_no
	 * @param serviceDeliveryNo the service_delivery_no value
	 */
	public void setServiceDeliveryNo (java.lang.String serviceDeliveryNo) {
		this.serviceDeliveryNo = serviceDeliveryNo;
	}



	/**
	 * Return the value associated with the column: service_apply_id
	 */
	public java.lang.Integer getServiceApplyId () {
		return serviceApplyId;
	}

	/**
	 * Set the value related to the column: service_apply_id
	 * @param serviceApplyId the service_apply_id value
	 */
	public void setServiceApplyId (java.lang.Integer serviceApplyId) {
		this.serviceApplyId = serviceApplyId;
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
	 * Return the value associated with the column: service_no
	 */
	public java.lang.String getServiceNo () {
		return serviceNo;
	}

	/**
	 * Set the value related to the column: service_no
	 * @param serviceNo the service_no value
	 */
	public void setServiceNo (java.lang.String serviceNo) {
		this.serviceNo = serviceNo;
	}



	/**
	 * Return the value associated with the column: company_id
	 */
	public java.lang.Integer getCompanyId () {
		return companyId;
	}

	/**
	 * Set the value related to the column: company_id
	 * @param companyId the company_id value
	 */
	public void setCompanyId (java.lang.Integer companyId) {
		this.companyId = companyId;
	}



	/**
	 * Return the value associated with the column: department
	 */
	public java.lang.String getDepartment () {
		return department;
	}

	/**
	 * Set the value related to the column: department
	 * @param department the department value
	 */
	public void setDepartment (java.lang.String department) {
		this.department = department;
	}



	/**
	 * Return the value associated with the column: shipping_no
	 */
	public java.lang.String getShippingNo () {
		return shippingNo;
	}

	/**
	 * Set the value related to the column: shipping_no
	 * @param shippingNo the shipping_no value
	 */
	public void setShippingNo (java.lang.String shippingNo) {
		this.shippingNo = shippingNo;
	}



	/**
	 * Return the value associated with the column: delivery_stock
	 */
	public java.lang.String getDeliveryStock () {
		return deliveryStock;
	}

	/**
	 * Set the value related to the column: delivery_stock
	 * @param deliveryStock the delivery_stock value
	 */
	public void setDeliveryStock (java.lang.String deliveryStock) {
		this.deliveryStock = deliveryStock;
	}



	/**
	 * Return the value associated with the column: delivery_date
	 */
	public java.util.Date getDeliveryDate () {
		return deliveryDate;
	}

	/**
	 * Set the value related to the column: delivery_date
	 * @param deliveryDate the delivery_date value
	 */
	public void setDeliveryDate (java.util.Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}



	/**
	 * Return the value associated with the column: status
	 */
	public java.lang.String getStatus () {
		return status;
	}

	/**
	 * Set the value related to the column: status
	 * @param status the status value
	 */
	public void setStatus (java.lang.String status) {
		this.status = status;
	}



	/**
	 * Return the value associated with the column: audited_time
	 */
	public java.lang.String getAuditedTime () {
		return auditedTime;
	}

	/**
	 * Set the value related to the column: audited_time
	 * @param auditedTime the audited_time value
	 */
	public void setAuditedTime (java.lang.String auditedTime) {
		this.auditedTime = auditedTime;
	}



	/**
	 * Return the value associated with the column: delivery_time
	 */
	public java.lang.String getDeliveryTime () {
		return deliveryTime;
	}

	/**
	 * Set the value related to the column: delivery_time
	 * @param deliveryTime the delivery_time value
	 */
	public void setDeliveryTime (java.lang.String deliveryTime) {
		this.deliveryTime = deliveryTime;
	}



	/**
	 * Return the value associated with the column: all_time
	 */
	public java.lang.String getAllTime () {
		return allTime;
	}

	/**
	 * Set the value related to the column: all_time
	 * @param allTime the all_time value
	 */
	public void setAllTime (java.lang.String allTime) {
		this.allTime = allTime;
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
		if (!(obj instanceof com.sunmw.web.entity.ServiceDelivery)) return false;
		else {
			com.sunmw.web.entity.ServiceDelivery serviceDelivery = (com.sunmw.web.entity.ServiceDelivery) obj;
			if (null == this.getId() || null == serviceDelivery.getId()) return false;
			else return (this.getId().equals(serviceDelivery.getId()));
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