package com.sunmw.web.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the invoice table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="invoice"
 */

public abstract class BaseInvoice  implements Serializable {

	public static String REF = "Invoice";
	public static String PROP_COMPANY_ID = "CompanyId";
	public static String PROP_INVOICE_URL = "InvoiceUrl";
	public static String PROP_INVOICE_DATE = "InvoiceDate";
	public static String PROP_INVOICE_CD = "InvoiceCd";
	public static String PROP_FROM_DATE = "FromDate";
	public static String PROP_SERVICE_AMT = "ServiceAmt";
	public static String PROP_INVOICE_NOTICE_DATE = "InvoiceNoticeDate";
	public static String PROP_PAYMENT_DATE = "PaymentDate";
	public static String PROP_INVOICE_NOTICE_PERSON = "InvoiceNoticePerson";
	public static String PROP_MTIME = "Mtime";
	public static String PROP_END_DATE = "EndDate";
	public static String PROP_CUSER = "Cuser";
	public static String PROP_OTHER_AMT = "OtherAmt";
	public static String PROP_MEMO = "Memo";
	public static String PROP_ID = "Id";
	public static String PROP_CTIME = "Ctime";
	public static String PROP_HOME_AMT = "HomeAmt";
	public static String PROP_TOTAL_AMT = "TotalAmt";
	public static String PROP_MUSER = "Muser";
	public static String PROP_INVOICE_RECEIVE_DATE = "InvoiceReceiveDate";
	public static String PROP_INVOICE_STATUS = "InvoiceStatus";


	// constructors
	public BaseInvoice () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseInvoice (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String invoiceCd;
	private java.lang.Integer companyId;
	private java.util.Date fromDate;
	private java.util.Date endDate;
	private java.math.BigDecimal serviceAmt;
	private java.math.BigDecimal homeAmt;
	private java.math.BigDecimal otherAmt;
	private java.math.BigDecimal totalAmt;
	private java.util.Date invoiceDate;
	private java.lang.String invoiceStatus;
	private java.util.Date invoiceNoticeDate;
	private java.lang.String invoiceNoticePerson;
	private java.util.Date invoiceReceiveDate;
	private java.util.Date paymentDate;
	private java.lang.String invoiceUrl;
	private java.lang.String memo;
	private java.util.Date ctime;
	private java.util.Date mtime;
	private java.lang.String cuser;
	private java.lang.String muser;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="identity"
     *  column="invoice_id"
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
	 * Return the value associated with the column: invoice_cd
	 */
	public java.lang.String getInvoiceCd () {
		return invoiceCd;
	}

	/**
	 * Set the value related to the column: invoice_cd
	 * @param invoiceCd the invoice_cd value
	 */
	public void setInvoiceCd (java.lang.String invoiceCd) {
		this.invoiceCd = invoiceCd;
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
	 * Return the value associated with the column: from_date
	 */
	public java.util.Date getFromDate () {
		return fromDate;
	}

	/**
	 * Set the value related to the column: from_date
	 * @param fromDate the from_date value
	 */
	public void setFromDate (java.util.Date fromDate) {
		this.fromDate = fromDate;
	}



	/**
	 * Return the value associated with the column: end_date
	 */
	public java.util.Date getEndDate () {
		return endDate;
	}

	/**
	 * Set the value related to the column: end_date
	 * @param endDate the end_date value
	 */
	public void setEndDate (java.util.Date endDate) {
		this.endDate = endDate;
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
	 * Return the value associated with the column: total_amt
	 */
	public java.math.BigDecimal getTotalAmt () {
		return totalAmt;
	}

	/**
	 * Set the value related to the column: total_amt
	 * @param totalAmt the total_amt value
	 */
	public void setTotalAmt (java.math.BigDecimal totalAmt) {
		this.totalAmt = totalAmt;
	}



	/**
	 * Return the value associated with the column: invoice_date
	 */
	public java.util.Date getInvoiceDate () {
		return invoiceDate;
	}

	/**
	 * Set the value related to the column: invoice_date
	 * @param invoiceDate the invoice_date value
	 */
	public void setInvoiceDate (java.util.Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}



	/**
	 * Return the value associated with the column: invoice_status
	 */
	public java.lang.String getInvoiceStatus () {
		return invoiceStatus;
	}

	/**
	 * Set the value related to the column: invoice_status
	 * @param invoiceStatus the invoice_status value
	 */
	public void setInvoiceStatus (java.lang.String invoiceStatus) {
		this.invoiceStatus = invoiceStatus;
	}



	/**
	 * Return the value associated with the column: invoice_notice_date
	 */
	public java.util.Date getInvoiceNoticeDate () {
		return invoiceNoticeDate;
	}

	/**
	 * Set the value related to the column: invoice_notice_date
	 * @param invoiceNoticeDate the invoice_notice_date value
	 */
	public void setInvoiceNoticeDate (java.util.Date invoiceNoticeDate) {
		this.invoiceNoticeDate = invoiceNoticeDate;
	}



	/**
	 * Return the value associated with the column: invoice_notice_person
	 */
	public java.lang.String getInvoiceNoticePerson () {
		return invoiceNoticePerson;
	}

	/**
	 * Set the value related to the column: invoice_notice_person
	 * @param invoiceNoticePerson the invoice_notice_person value
	 */
	public void setInvoiceNoticePerson (java.lang.String invoiceNoticePerson) {
		this.invoiceNoticePerson = invoiceNoticePerson;
	}



	/**
	 * Return the value associated with the column: invoice_receive_date
	 */
	public java.util.Date getInvoiceReceiveDate () {
		return invoiceReceiveDate;
	}

	/**
	 * Set the value related to the column: invoice_receive_date
	 * @param invoiceReceiveDate the invoice_receive_date value
	 */
	public void setInvoiceReceiveDate (java.util.Date invoiceReceiveDate) {
		this.invoiceReceiveDate = invoiceReceiveDate;
	}



	/**
	 * Return the value associated with the column: payment_date
	 */
	public java.util.Date getPaymentDate () {
		return paymentDate;
	}

	/**
	 * Set the value related to the column: payment_date
	 * @param paymentDate the payment_date value
	 */
	public void setPaymentDate (java.util.Date paymentDate) {
		this.paymentDate = paymentDate;
	}



	/**
	 * Return the value associated with the column: invoice_url
	 */
	public java.lang.String getInvoiceUrl () {
		return invoiceUrl;
	}

	/**
	 * Set the value related to the column: invoice_url
	 * @param invoiceUrl the invoice_url value
	 */
	public void setInvoiceUrl (java.lang.String invoiceUrl) {
		this.invoiceUrl = invoiceUrl;
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
		if (!(obj instanceof com.sunmw.web.entity.Invoice)) return false;
		else {
			com.sunmw.web.entity.Invoice invoice = (com.sunmw.web.entity.Invoice) obj;
			if (null == this.getId() || null == invoice.getId()) return false;
			else return (this.getId().equals(invoice.getId()));
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