package com.sunmw.web.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the area_province_ref table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="area_province_ref"
 */

public abstract class BaseAreaProvinceRef  implements Serializable {

	public static String REF = "AreaProvinceRef";
	public static String PROP_MTIME = "Mtime";
	public static String PROP_CUSER = "Cuser";
	public static String PROP_CTIME = "Ctime";
	public static String PROP_MUSER = "Muser";


	// constructors
	public BaseAreaProvinceRef () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseAreaProvinceRef (
		java.lang.String provinceCd,
		java.lang.String areaCd) {

		this.setProvinceCd(provinceCd);
		this.setAreaCd(areaCd);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key

	private java.lang.String provinceCd;

	private java.lang.String areaCd;

	// fields
	private java.util.Date ctime;
	private java.util.Date mtime;
	private java.lang.String cuser;
	private java.lang.String muser;



	/**
     * @hibernate.property
     *  column=province_cd
	 * not-null=true
	 */
	public java.lang.String getProvinceCd () {
		return this.provinceCd;
	}

	/**
	 * Set the value related to the column: province_cd
	 * @param provinceCd the province_cd value
	 */
	public void setProvinceCd (java.lang.String provinceCd) {
		this.provinceCd = provinceCd;
		this.hashCode = Integer.MIN_VALUE;
	}

	/**
     * @hibernate.property
     *  column=area_cd
	 * not-null=true
	 */
	public java.lang.String getAreaCd () {
		return this.areaCd;
	}

	/**
	 * Set the value related to the column: area_cd
	 * @param areaCd the area_cd value
	 */
	public void setAreaCd (java.lang.String areaCd) {
		this.areaCd = areaCd;
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
		if (!(obj instanceof com.sunmw.web.entity.AreaProvinceRef)) return false;
		else {
			com.sunmw.web.entity.AreaProvinceRef areaProvinceRef = (com.sunmw.web.entity.AreaProvinceRef) obj;
			if (null != this.getProvinceCd() && null != areaProvinceRef.getProvinceCd()) {
				if (!this.getProvinceCd().equals(areaProvinceRef.getProvinceCd())) {
					return false;
				}
			}
			else {
				return false;
			}
			if (null != this.getAreaCd() && null != areaProvinceRef.getAreaCd()) {
				if (!this.getAreaCd().equals(areaProvinceRef.getAreaCd())) {
					return false;
				}
			}
			else {
				return false;
			}
			return true;
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			StringBuilder sb = new StringBuilder();
			if (null != this.getProvinceCd()) {
				sb.append(this.getProvinceCd().hashCode());
				sb.append(":");
			}
			else {
				return super.hashCode();
			}
			if (null != this.getAreaCd()) {
				sb.append(this.getAreaCd().hashCode());
				sb.append(":");
			}
			else {
				return super.hashCode();
			}
			this.hashCode = sb.toString().hashCode();
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}