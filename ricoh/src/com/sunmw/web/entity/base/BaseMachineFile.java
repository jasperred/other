package com.sunmw.web.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the machine_file table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="machine_file"
 */

public abstract class BaseMachineFile  implements Serializable {

	public static String REF = "MachineFile";
	public static String PROP_FILE_SIZE = "FileSize";
	public static String PROP_MTIME = "Mtime";
	public static String PROP_CUSER = "Cuser";
	public static String PROP_FILE_NAME = "FileName";
	public static String PROP_FILE_URL = "FileUrl";
	public static String PROP_ID = "Id";
	public static String PROP_CTIME = "Ctime";
	public static String PROP_MUSER = "Muser";


	// constructors
	public BaseMachineFile () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMachineFile (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String fileUrl;
	private java.util.Date ctime;
	private java.util.Date mtime;
	private java.lang.String cuser;
	private java.lang.String muser;
	private java.lang.String fileName;
	private java.lang.Integer fileSize;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="assigned"
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
	 * Return the value associated with the column: file_url
	 */
	public java.lang.String getFileUrl () {
		return fileUrl;
	}

	/**
	 * Set the value related to the column: file_url
	 * @param fileUrl the file_url value
	 */
	public void setFileUrl (java.lang.String fileUrl) {
		this.fileUrl = fileUrl;
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
	 * Return the value associated with the column: file_name
	 */
	public java.lang.String getFileName () {
		return fileName;
	}

	/**
	 * Set the value related to the column: file_name
	 * @param fileName the file_name value
	 */
	public void setFileName (java.lang.String fileName) {
		this.fileName = fileName;
	}



	/**
	 * Return the value associated with the column: file_size
	 */
	public java.lang.Integer getFileSize () {
		return fileSize;
	}

	/**
	 * Set the value related to the column: file_size
	 * @param fileSize the file_size value
	 */
	public void setFileSize (java.lang.Integer fileSize) {
		this.fileSize = fileSize;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.sunmw.web.entity.MachineFile)) return false;
		else {
			com.sunmw.web.entity.MachineFile machineFile = (com.sunmw.web.entity.MachineFile) obj;
			if (null == this.getId() || null == machineFile.getId()) return false;
			else return (this.getId().equals(machineFile.getId()));
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