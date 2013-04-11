package com.sunmw.web.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the company_machine_type_ref table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="company_machine_type_ref"
 */

public abstract class BaseCompanyMachineTypeRef  implements Serializable {

	public static String REF = "CompanyMachineTypeRef";
	public static String PROP_MACHINE_CD = "MachineCd";
	public static String PROP_MTIME = "Mtime";
	public static String PROP_CUSER = "Cuser";
	public static String PROP_ID = "Id";
	public static String PROP_CTIME = "Ctime";
	public static String PROP_MUSER = "Muser";


	// constructors
	public BaseCompanyMachineTypeRef () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCompanyMachineTypeRef (com.sunmw.web.entity.CompanyMachineTypeRefPK id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private com.sunmw.web.entity.CompanyMachineTypeRefPK id;

	// fields
	private java.lang.String machineCd;
	private java.lang.String cuser;
	private java.util.Date ctime;
	private java.lang.String muser;
	private java.util.Date mtime;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     */
	public com.sunmw.web.entity.CompanyMachineTypeRefPK getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (com.sunmw.web.entity.CompanyMachineTypeRefPK id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.sunmw.web.entity.CompanyMachineTypeRef)) return false;
		else {
			com.sunmw.web.entity.CompanyMachineTypeRef companyMachineTypeRef = (com.sunmw.web.entity.CompanyMachineTypeRef) obj;
			if (null == this.getId() || null == companyMachineTypeRef.getId()) return false;
			else return (this.getId().equals(companyMachineTypeRef.getId()));
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