package com.sunmw.web.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the machine_cat table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="machine_cat"
 */

public abstract class BaseMachineCat  implements Serializable {

	public static String REF = "MachineCat";
	public static String PROP_SORT = "Sort";
	public static String PROP_SERVICE_DATE = "ServiceDate";
	public static String PROP_MACHINE_CAT_CODE = "MachineCatCode";
	public static String PROP_ID = "Id";
	public static String PROP_MACHINE_CAT_NAME = "MachineCatName";


	// constructors
	public BaseMachineCat () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMachineCat (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String machineCatName;
	private java.math.BigDecimal serviceDate;
	private java.lang.String machineCatCode;
	private java.lang.Integer sort;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="identity"
     *  column="machine_cat_id"
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
	 * Return the value associated with the column: machine_cat_name
	 */
	public java.lang.String getMachineCatName () {
		return machineCatName;
	}

	/**
	 * Set the value related to the column: machine_cat_name
	 * @param machineCatName the machine_cat_name value
	 */
	public void setMachineCatName (java.lang.String machineCatName) {
		this.machineCatName = machineCatName;
	}



	/**
	 * Return the value associated with the column: service_date
	 */
	public java.math.BigDecimal getServiceDate () {
		return serviceDate;
	}

	/**
	 * Set the value related to the column: service_date
	 * @param serviceDate the service_date value
	 */
	public void setServiceDate (java.math.BigDecimal serviceDate) {
		this.serviceDate = serviceDate;
	}



	/**
	 * Return the value associated with the column: machine_cat_code
	 */
	public java.lang.String getMachineCatCode () {
		return machineCatCode;
	}

	/**
	 * Set the value related to the column: machine_cat_code
	 * @param machineCatCode the machine_cat_code value
	 */
	public void setMachineCatCode (java.lang.String machineCatCode) {
		this.machineCatCode = machineCatCode;
	}



	/**
	 * Return the value associated with the column: sort
	 */
	public java.lang.Integer getSort () {
		return sort;
	}

	/**
	 * Set the value related to the column: sort
	 * @param sort the sort value
	 */
	public void setSort (java.lang.Integer sort) {
		this.sort = sort;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.sunmw.web.entity.MachineCat)) return false;
		else {
			com.sunmw.web.entity.MachineCat machineCat = (com.sunmw.web.entity.MachineCat) obj;
			if (null == this.getId() || null == machineCat.getId()) return false;
			else return (this.getId().equals(machineCat.getId()));
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