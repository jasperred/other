package com.sunmw.web.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the temp_company_machine_type_ref table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="temp_company_machine_type_ref"
 */

public abstract class BaseTempCompanyMachineTypeRef  implements Serializable {

	public static String REF = "TempCompanyMachineTypeRef";
	public static String PROP_IMPORT_USER = "ImportUser";
	public static String PROP_MACHINE_TYPE = "MachineType";
	public static String PROP_MACHINE_CD = "MachineCd";
	public static String PROP_READER_TIME = "ReaderTime";
	public static String PROP_FLAG = "Flag";
	public static String PROP_TEMP_NO = "TempNo";
	public static String PROP_COMPANY_NO = "CompanyNo";
	public static String PROP_ID = "Id";
	public static String PROP_COMPANY_NAME = "CompanyName";
	public static String PROP_WRITER_TIME = "WriterTime";


	// constructors
	public BaseTempCompanyMachineTypeRef () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseTempCompanyMachineTypeRef (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String companyNo;
	private java.lang.String companyName;
	private java.lang.String machineCd;
	private java.lang.String machineType;
	private java.lang.String flag;
	private java.lang.String tempNo;
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
	 * Return the value associated with the column: company_no
	 */
	public java.lang.String getCompanyNo () {
		return companyNo;
	}

	/**
	 * Set the value related to the column: company_no
	 * @param companyNo the company_no value
	 */
	public void setCompanyNo (java.lang.String companyNo) {
		this.companyNo = companyNo;
	}



	/**
	 * Return the value associated with the column: company_name
	 */
	public java.lang.String getCompanyName () {
		return companyName;
	}

	/**
	 * Set the value related to the column: company_name
	 * @param companyName the company_name value
	 */
	public void setCompanyName (java.lang.String companyName) {
		this.companyName = companyName;
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
	 * Return the value associated with the column: temp_no
	 */
	public java.lang.String getTempNo () {
		return tempNo;
	}

	/**
	 * Set the value related to the column: temp_no
	 * @param tempNo the temp_no value
	 */
	public void setTempNo (java.lang.String tempNo) {
		this.tempNo = tempNo;
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
		if (!(obj instanceof com.sunmw.web.entity.TempCompanyMachineTypeRef)) return false;
		else {
			com.sunmw.web.entity.TempCompanyMachineTypeRef tempCompanyMachineTypeRef = (com.sunmw.web.entity.TempCompanyMachineTypeRef) obj;
			if (null == this.getId() || null == tempCompanyMachineTypeRef.getId()) return false;
			else return (this.getId().equals(tempCompanyMachineTypeRef.getId()));
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