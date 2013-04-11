package com.sunmw.web.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the machine_type table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="machine_type"
 */

public abstract class BaseMachineType  implements Serializable {

	public static String REF = "MachineType";
	public static String PROP_MACHINE_CD = "MachineCd";
	public static String PROP_MACHINE_TYPE = "MachineType";
	public static String PROP_STATUS = "Status";
	public static String PROP_RATE1 = "Rate1";
	public static String PROP_MTIME = "Mtime";
	public static String PROP_RATE2 = "Rate2";
	public static String PROP_CUSER = "Cuser";
	public static String PROP_MACHINE_CAT = "MachineCat";
	public static String PROP_ID = "Id";
	public static String PROP_CTIME = "Ctime";
	public static String PROP_MUSER = "Muser";
	public static String PROP_SERVICE_PROVIDER_TYPE = "ServiceProviderType";


	// constructors
	public BaseMachineType () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMachineType (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String machineType;
	private java.lang.String machineCd;
	private java.lang.String machineCat;
	private java.lang.String serviceProviderType;
	private java.math.BigDecimal rate1;
	private java.math.BigDecimal rate2;
	private java.lang.String cuser;
	private java.util.Date ctime;
	private java.lang.String status;
	private java.util.Date mtime;
	private java.lang.String muser;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="identity"
     *  column="machine_type_id"
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
	 * Return the value associated with the column: machine_type
	 */
	public java.lang.String getMachineType () {
		return machineType;
	}

	/**
	 * Set the value related to the column: machine_type
	 * @param machineType the machine_type value
	 */
	public void setMachineType (java.lang.String machineType) {
		this.machineType = machineType;
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
	 * Return the value associated with the column: machine_cat
	 */
	public java.lang.String getMachineCat () {
		return machineCat;
	}

	/**
	 * Set the value related to the column: machine_cat
	 * @param machineCat the machine_cat value
	 */
	public void setMachineCat (java.lang.String machineCat) {
		this.machineCat = machineCat;
	}



	/**
	 * Return the value associated with the column: service_provider_type
	 */
	public java.lang.String getServiceProviderType () {
		return serviceProviderType;
	}

	/**
	 * Set the value related to the column: service_provider_type
	 * @param serviceProviderType the service_provider_type value
	 */
	public void setServiceProviderType (java.lang.String serviceProviderType) {
		this.serviceProviderType = serviceProviderType;
	}



	/**
	 * Return the value associated with the column: rate1
	 */
	public java.math.BigDecimal getRate1 () {
		return rate1;
	}

	/**
	 * Set the value related to the column: rate1
	 * @param rate1 the rate1 value
	 */
	public void setRate1 (java.math.BigDecimal rate1) {
		this.rate1 = rate1;
	}



	/**
	 * Return the value associated with the column: rate2
	 */
	public java.math.BigDecimal getRate2 () {
		return rate2;
	}

	/**
	 * Set the value related to the column: rate2
	 * @param rate2 the rate2 value
	 */
	public void setRate2 (java.math.BigDecimal rate2) {
		this.rate2 = rate2;
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
		if (!(obj instanceof com.sunmw.web.entity.MachineType)) return false;
		else {
			com.sunmw.web.entity.MachineType machineType = (com.sunmw.web.entity.MachineType) obj;
			if (null == this.getId() || null == machineType.getId()) return false;
			else return (this.getId().equals(machineType.getId()));
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