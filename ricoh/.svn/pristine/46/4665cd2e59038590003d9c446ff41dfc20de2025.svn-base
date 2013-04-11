package com.sunmw.web.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the machine table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="machine"
 */

public abstract class BaseMachine  implements Serializable {

	public static String REF = "Machine";
	public static String PROP_MACHINE_CD = "MachineCd";
	public static String PROP_PAYMENT_AMT = "PaymentAmt";
	public static String PROP_LAST_TIME = "LastTime";
	public static String PROP_OUT_DATE = "OutDate";
	public static String PROP_INVOICE_DATE = "InvoiceDate";
	public static String PROP_CUSTOMER_NO = "CustomerNo";
	public static String PROP_SERVICE_END_DATE = "ServiceEndDate";
	public static String PROP_ORIGIN = "Origin";
	public static String PROP_PAYMENT_DATE = "PaymentDate";
	public static String PROP_CUSTOMER_NAME = "CustomerName";
	public static String PROP_MACHINE_TYPE_ID = "MachineTypeId";
	public static String PROP_PAYMENT_STATUS = "PaymentStatus";
	public static String PROP_PPS_NO = "PpsNo";
	public static String PROP_PAYMENT_COMPANY = "PaymentCompany";
	public static String PROP_PAYMENT_COMPANY_CD = "PaymentCompanyCd";
	public static String PROP_LAST_COMPANY_ID = "LastCompanyId";
	public static String PROP_STATUS = "Status";
	public static String PROP_MTIME = "Mtime";
	public static String PROP_CUSER = "Cuser";
	public static String PROP_MACHINE_NO = "MachineNo";
	public static String PROP_ID = "Id";
	public static String PROP_CTIME = "Ctime";
	public static String PROP_MUSER = "Muser";
	public static String PROP_SERVICE_FROM_DATE = "ServiceFromDate";


	// constructors
	public BaseMachine () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMachine (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date outDate;
	private java.lang.String machineCd;
	private java.lang.Integer machineTypeId;
	private java.lang.String machineNo;
	private java.lang.String ppsNo;
	private java.util.Date serviceFromDate;
	private java.util.Date serviceEndDate;
	private java.util.Date invoiceDate;
	private java.lang.String status;
	private java.lang.String paymentStatus;
	private java.lang.String paymentCompany;
	private java.lang.String paymentCompanyCd;
	private java.util.Date paymentDate;
	private java.math.BigDecimal paymentAmt;
	private java.lang.String customerNo;
	private java.lang.String customerName;
	private java.util.Date ctime;
	private java.util.Date mtime;
	private java.lang.String cuser;
	private java.lang.String muser;
	private java.util.Date lastTime;
	private java.lang.Integer lastCompanyId;
	private java.lang.String origin;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="identity"
     *  column="machine_id"
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
	 * Return the value associated with the column: out_date
	 */
	public java.util.Date getOutDate () {
		return outDate;
	}

	/**
	 * Set the value related to the column: out_date
	 * @param outDate the out_date value
	 */
	public void setOutDate (java.util.Date outDate) {
		this.outDate = outDate;
	}



	/**
	 * Return the value associated with the column: machine_cd
	 */
	public java.lang.String getMachineCd () {
		return machineCd;
	}

	/**
	 * Set the value related to the column: machine_cd
	 * @param machineCd the machine_cd value
	 */
	public void setMachineCd (java.lang.String machineCd) {
		this.machineCd = machineCd;
	}



	/**
	 * Return the value associated with the column: machine_type_id
	 */
	public java.lang.Integer getMachineTypeId () {
		return machineTypeId;
	}

	/**
	 * Set the value related to the column: machine_type_id
	 * @param machineTypeId the machine_type_id value
	 */
	public void setMachineTypeId (java.lang.Integer machineTypeId) {
		this.machineTypeId = machineTypeId;
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
	 * Return the value associated with the column: pps_no
	 */
	public java.lang.String getPpsNo () {
		return ppsNo;
	}

	/**
	 * Set the value related to the column: pps_no
	 * @param ppsNo the pps_no value
	 */
	public void setPpsNo (java.lang.String ppsNo) {
		this.ppsNo = ppsNo;
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
	 * Return the value associated with the column: service_end_date
	 */
	public java.util.Date getServiceEndDate () {
		return serviceEndDate;
	}

	/**
	 * Set the value related to the column: service_end_date
	 * @param serviceEndDate the service_end_date value
	 */
	public void setServiceEndDate (java.util.Date serviceEndDate) {
		this.serviceEndDate = serviceEndDate;
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



	/**
	 * Return the value associated with the column: last_time
	 */
	public java.util.Date getLastTime () {
		return lastTime;
	}

	/**
	 * Set the value related to the column: last_time
	 * @param lastTime the last_time value
	 */
	public void setLastTime (java.util.Date lastTime) {
		this.lastTime = lastTime;
	}



	/**
	 * Return the value associated with the column: last_company_id
	 */
	public java.lang.Integer getLastCompanyId () {
		return lastCompanyId;
	}

	/**
	 * Set the value related to the column: last_company_id
	 * @param lastCompanyId the last_company_id value
	 */
	public void setLastCompanyId (java.lang.Integer lastCompanyId) {
		this.lastCompanyId = lastCompanyId;
	}



	/**
	 * Return the value associated with the column: origin
	 */
	public java.lang.String getOrigin () {
		return origin;
	}

	/**
	 * Set the value related to the column: origin
	 * @param origin the origin value
	 */
	public void setOrigin (java.lang.String origin) {
		this.origin = origin;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.sunmw.web.entity.Machine)) return false;
		else {
			com.sunmw.web.entity.Machine machine = (com.sunmw.web.entity.Machine) obj;
			if (null == this.getId() || null == machine.getId()) return false;
			else return (this.getId().equals(machine.getId()));
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