package com.sunmw.web.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the service_visit table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="service_visit"
 */

public abstract class BaseServiceVisit  implements Serializable {

	public static String REF = "ServiceVisit";
	public static String PROP_STATUS = "Status";
	public static String PROP_MTIME = "Mtime";
	public static String PROP_VISIT_FLAG = "VisitFlag";
	public static String PROP_CUSER = "Cuser";
	public static String PROP_SERVICE_NO = "ServiceNo";
	public static String PROP_VISIT_MEMO = "VisitMemo";
	public static String PROP_ID = "Id";
	public static String PROP_CTIME = "Ctime";
	public static String PROP_SERVICE_ID = "ServiceId";
	public static String PROP_MUSER = "Muser";
	public static String PROP_VISIT_RESULT = "VisitResult";
	public static String PROP_SERVICE_VISIT_NO = "ServiceVisitNo";


	// constructors
	public BaseServiceVisit () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseServiceVisit (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer serviceId;
	private java.lang.String serviceVisitNo;
	private java.lang.String serviceNo;
	private java.lang.String status;
	private java.lang.String visitFlag;
	private java.lang.String visitResult;
	private java.lang.String visitMemo;
	private java.util.Date ctime;
	private java.lang.String cuser;
	private java.util.Date mtime;
	private java.lang.String muser;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="identity"
     *  column="service_visit_id"
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
	 * Return the value associated with the column: service_visit_no
	 */
	public java.lang.String getServiceVisitNo () {
		return serviceVisitNo;
	}

	/**
	 * Set the value related to the column: service_visit_no
	 * @param serviceVisitNo the service_visit_no value
	 */
	public void setServiceVisitNo (java.lang.String serviceVisitNo) {
		this.serviceVisitNo = serviceVisitNo;
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
	 * Return the value associated with the column: visit_flag
	 */
	public java.lang.String getVisitFlag () {
		return visitFlag;
	}

	/**
	 * Set the value related to the column: visit_flag
	 * @param visitFlag the visit_flag value
	 */
	public void setVisitFlag (java.lang.String visitFlag) {
		this.visitFlag = visitFlag;
	}



	/**
	 * Return the value associated with the column: visit_result
	 */
	public java.lang.String getVisitResult () {
		return visitResult;
	}

	/**
	 * Set the value related to the column: visit_result
	 * @param visitResult the visit_result value
	 */
	public void setVisitResult (java.lang.String visitResult) {
		this.visitResult = visitResult;
	}



	/**
	 * Return the value associated with the column: visit_memo
	 */
	public java.lang.String getVisitMemo () {
		return visitMemo;
	}

	/**
	 * Set the value related to the column: visit_memo
	 * @param visitMemo the visit_memo value
	 */
	public void setVisitMemo (java.lang.String visitMemo) {
		this.visitMemo = visitMemo;
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
		if (!(obj instanceof com.sunmw.web.entity.ServiceVisit)) return false;
		else {
			com.sunmw.web.entity.ServiceVisit serviceVisit = (com.sunmw.web.entity.ServiceVisit) obj;
			if (null == this.getId() || null == serviceVisit.getId()) return false;
			else return (this.getId().equals(serviceVisit.getId()));
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