package com.sunmw.web.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the temp_service_payment table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="temp_service_payment"
 */

public abstract class BaseTempServicePayment  implements Serializable {

	public static String REF = "TempServicePayment";
	public static String PROP_IMPORT_USER = "ImportUser";
	public static String PROP_READER_TIME = "ReaderTime";
	public static String PROP_FLAG = "Flag";
	public static String PROP_PAYMENT_AMT = "PaymentAmt";
	public static String PROP_MACHINE_NO = "MachineNo";
	public static String PROP_ID = "Id";
	public static String PROP_PAYMENT_DATE = "PaymentDate";
	public static String PROP_SERVICE_FROM_DATE = "ServiceFromDate";
	public static String PROP_WRITER_TIME = "WriterTime";
	public static String PROP_PAYMENT_STATUS = "PaymentStatus";
	public static String PROP_PAYMENT_COMPANY_CD = "PaymentCompanyCd";
	public static String PROP_PAYMENT_COMPANY = "PaymentCompany";


	// constructors
	public BaseTempServicePayment () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseTempServicePayment (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String machineNo;
	private java.util.Date serviceFromDate;
	private java.lang.String paymentStatus;
	private java.lang.String paymentCompany;
	private java.lang.String paymentCompanyCd;
	private java.util.Date paymentDate;
	private java.math.BigDecimal paymentAmt;
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
	 * Return the value associated with the column: machine_no
	 */
	public java.lang.String getMachineNo () {
		return machineNo;
	}

	/**
	 * Set the value related to the column: machine_no
	 * @param machineNo the machine_no value
	 */
	public void setMachineNo (java.lang.String machineNo) {
		this.machineNo = machineNo;
	}



	/**
	 * Return the value associated with the column: service_from_date
	 */
	public java.util.Date getServiceFromDate () {
		return serviceFromDate;
	}

	/**
	 * Set the value related to the column: service_from_date
	 * @param serviceFromDate the service_from_date value
	 */
	public void setServiceFromDate (java.util.Date serviceFromDate) {
		this.serviceFromDate = serviceFromDate;
	}



	/**
	 * Return the value associated with the column: payment_status
	 */
	public java.lang.String getPaymentStatus () {
		return paymentStatus;
	}

	/**
	 * Set the value related to the column: payment_status
	 * @param paymentStatus the payment_status value
	 */
	public void setPaymentStatus (java.lang.String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}



	/**
	 * Return the value associated with the column: payment_company
	 */
	public java.lang.String getPaymentCompany () {
		return paymentCompany;
	}

	/**
	 * Set the value related to the column: payment_company
	 * @param paymentCompany the payment_company value
	 */
	public void setPaymentCompany (java.lang.String paymentCompany) {
		this.paymentCompany = paymentCompany;
	}



	/**
	 * Return the value associated with the column: payment_company_cd
	 */
	public java.lang.String getPaymentCompanyCd () {
		return paymentCompanyCd;
	}

	/**
	 * Set the value related to the column: payment_company_cd
	 * @param paymentCompanyCd the payment_company_cd value
	 */
	public void setPaymentCompanyCd (java.lang.String paymentCompanyCd) {
		this.paymentCompanyCd = paymentCompanyCd;
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
	 * Return the value associated with the column: payment_amt
	 */
	public java.math.BigDecimal getPaymentAmt () {
		return paymentAmt;
	}

	/**
	 * Set the value related to the column: payment_amt
	 * @param paymentAmt the payment_amt value
	 */
	public void setPaymentAmt (java.math.BigDecimal paymentAmt) {
		this.paymentAmt = paymentAmt;
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
		if (!(obj instanceof com.sunmw.web.entity.TempServicePayment)) return false;
		else {
			com.sunmw.web.entity.TempServicePayment tempServicePayment = (com.sunmw.web.entity.TempServicePayment) obj;
			if (null == this.getId() || null == tempServicePayment.getId()) return false;
			else return (this.getId().equals(tempServicePayment.getId()));
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