package com.sunmw.web.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the service_fault table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="service_fault"
 */

public abstract class BaseServiceFault  implements Serializable {

	public static String REF = "ServiceFault";
	public static String PROP_MUST_MEMO = "MustMemo";
	public static String PROP_FAULT_NAME = "FaultName";
	public static String PROP_MTIME = "Mtime";
	public static String PROP_FAULT_CATE_NO = "FaultCateNo";
	public static String PROP_CUSER = "Cuser";
	public static String PROP_FAULT_NO = "FaultNo";
	public static String PROP_MEMO = "Memo";
	public static String PROP_SERVICE_ID = "ServiceId";
	public static String PROP_CTIME = "Ctime";
	public static String PROP_ID = "Id";
	public static String PROP_FAULT_TYPE = "FaultType";
	public static String PROP_MUSER = "Muser";
	public static String PROP_CONTENT = "Content";


	// constructors
	public BaseServiceFault () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseServiceFault (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer serviceId;
	private java.lang.String faultType;
	private java.lang.String faultCateNo;
	private java.lang.String faultNo;
	private java.lang.String faultName;
	private java.lang.String mustMemo;
	private java.lang.String memo;
	private java.util.Date ctime;
	private java.lang.String cuser;
	private java.util.Date mtime;
	private java.lang.String muser;
	private java.lang.String content;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="identity"
     *  column="service_fault_id"
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
	 * Return the value associated with the column: fault_type
	 */
	public java.lang.String getFaultType () {
		return faultType;
	}

	/**
	 * Set the value related to the column: fault_type
	 * @param faultType the fault_type value
	 */
	public void setFaultType (java.lang.String faultType) {
		this.faultType = faultType;
	}



	/**
	 * Return the value associated with the column: fault_cate_no
	 */
	public java.lang.String getFaultCateNo () {
		return faultCateNo;
	}

	/**
	 * Set the value related to the column: fault_cate_no
	 * @param faultCateNo the fault_cate_no value
	 */
	public void setFaultCateNo (java.lang.String faultCateNo) {
		this.faultCateNo = faultCateNo;
	}



	/**
	 * Return the value associated with the column: fault_no
	 */
	public java.lang.String getFaultNo () {
		return faultNo;
	}

	/**
	 * Set the value related to the column: fault_no
	 * @param faultNo the fault_no value
	 */
	public void setFaultNo (java.lang.String faultNo) {
		this.faultNo = faultNo;
	}



	/**
	 * Return the value associated with the column: fault_name
	 */
	public java.lang.String getFaultName () {
		return faultName;
	}

	/**
	 * Set the value related to the column: fault_name
	 * @param faultName the fault_name value
	 */
	public void setFaultName (java.lang.String faultName) {
		this.faultName = faultName;
	}



	/**
	 * Return the value associated with the column: must_memo
	 */
	public java.lang.String getMustMemo () {
		return mustMemo;
	}

	/**
	 * Set the value related to the column: must_memo
	 * @param mustMemo the must_memo value
	 */
	public void setMustMemo (java.lang.String mustMemo) {
		this.mustMemo = mustMemo;
	}



	/**
	 * Return the value associated with the column: memo
	 */
	public java.lang.String getMemo () {
		return memo;
	}

	/**
	 * Set the value related to the column: memo
	 * @param memo the memo value
	 */
	public void setMemo (java.lang.String memo) {
		this.memo = memo;
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



	/**
	 * Return the value associated with the column: content
	 */
	public java.lang.String getContent () {
		return content;
	}

	/**
	 * Set the value related to the column: content
	 * @param content the content value
	 */
	public void setContent (java.lang.String content) {
		this.content = content;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.sunmw.web.entity.ServiceFault)) return false;
		else {
			com.sunmw.web.entity.ServiceFault serviceFault = (com.sunmw.web.entity.ServiceFault) obj;
			if (null == this.getId() || null == serviceFault.getId()) return false;
			else return (this.getId().equals(serviceFault.getId()));
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