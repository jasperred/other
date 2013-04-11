package com.sunmw.web.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the invoice_service_ref table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="invoice_service_ref"
 */

public abstract class BaseInvoiceServiceRef  implements Serializable {

	public static String REF = "InvoiceServiceRef";
	public static String PROP_MTIME = "Mtime";
	public static String PROP_CUSER = "Cuser";
	public static String PROP_COMPANY_ID = "CompanyId";
	public static String PROP_SERVICE_NO = "ServiceNo";
	public static String PROP_OTHER_AMT = "OtherAmt";
	public static String PROP_SERVICE_APPLY_ID = "ServiceApplyId";
	public static String PROP_SERVICE_AMT = "ServiceAmt";
	public static String PROP_ID = "Id";
	public static String PROP_HOME_AMT = "HomeAmt";
	public static String PROP_CTIME = "Ctime";
	public static String PROP_MUSER = "Muser";


	// constructors
	public BaseInvoiceServiceRef () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseInvoiceServiceRef (com.sunmw.web.entity.InvoiceServiceRefPK id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseInvoiceServiceRef (
		com.sunmw.web.entity.InvoiceServiceRefPK id,
		java.lang.Integer serviceApplyId) {

		this.setId(id);
		this.setServiceApplyId(serviceApplyId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private com.sunmw.web.entity.InvoiceServiceRefPK id;

	// fields
	private java.util.Date ctime;
	private java.util.Date mtime;
	private java.math.BigDecimal serviceAmt;
	private java.math.BigDecimal homeAmt;
	private java.math.BigDecimal otherAmt;
	private java.lang.String serviceNo;
	private java.lang.Integer companyId;
	private java.lang.Integer serviceApplyId;
	private java.lang.String cuser;
	private java.lang.String muser;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     */
	public com.sunmw.web.entity.InvoiceServiceRefPK getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (com.sunmw.web.entity.InvoiceServiceRefPK id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
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
	 * Return the value associated with the column: service_amt
	 */
	public java.math.BigDecimal getServiceAmt () {
		return serviceAmt;
	}

	/**
	 * Set the value related to the column: service_amt
	 * @param serviceAmt the service_amt value
	 */
	public void setServiceAmt (java.math.BigDecimal serviceAmt) {
		this.serviceAmt = serviceAmt;
	}



	/**
	 * Return the value associated with the column: home_amt
	 */
	public java.math.BigDecimal getHomeAmt () {
		return homeAmt;
	}

	/**
	 * Set the value related to the column: home_amt
	 * @param homeAmt the home_amt value
	 */
	public void setHomeAmt (java.math.BigDecimal homeAmt) {
		this.homeAmt = homeAmt;
	}



	/**
	 * Return the value associated with the column: other_amt
	 */
	public java.math.BigDecimal getOtherAmt () {
		return otherAmt;
	}

	/**
	 * Set the value related to the column: other_amt
	 * @param otherAmt the other_amt value
	 */
	public void setOtherAmt (java.math.BigDecimal otherAmt) {
		this.otherAmt = otherAmt;
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
		if (!(obj instanceof com.sunmw.web.entity.InvoiceServiceRef)) return false;
		else {
			com.sunmw.web.entity.InvoiceServiceRef invoiceServiceRef = (com.sunmw.web.entity.InvoiceServiceRef) obj;
			if (null == this.getId() || null == invoiceServiceRef.getId()) return false;
			else return (this.getId().equals(invoiceServiceRef.getId()));
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