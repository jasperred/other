package com.sunmw.web.entity.base;

import java.io.Serializable;


public abstract class BaseSecurityGroupAreaPK implements Serializable {

	protected int hashCode = Integer.MIN_VALUE;

	private java.lang.String groupId;
	private java.lang.String areaCd;


	public BaseSecurityGroupAreaPK () {}
	
	public BaseSecurityGroupAreaPK (
		java.lang.String groupId,
		java.lang.String areaCd) {

		this.setGroupId(groupId);
		this.setAreaCd(areaCd);
	}


	/**
	 * Return the value associated with the column: group_id
	 */
	public java.lang.String getGroupId () {
		return groupId;
	}

	/**
	 * Set the value related to the column: group_id
	 * @param groupId the group_id value
	 */
	public void setGroupId (java.lang.String groupId) {
		this.groupId = groupId;
	}



	/**
	 * Return the value associated with the column: area_cd
	 */
	public java.lang.String getAreaCd () {
		return areaCd;
	}

	/**
	 * Set the value related to the column: area_cd
	 * @param areaCd the area_cd value
	 */
	public void setAreaCd (java.lang.String areaCd) {
		this.areaCd = areaCd;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.sunmw.web.entity.SecurityGroupAreaPK)) return false;
		else {
			com.sunmw.web.entity.SecurityGroupAreaPK mObj = (com.sunmw.web.entity.SecurityGroupAreaPK) obj;
			if (null != this.getGroupId() && null != mObj.getGroupId()) {
				if (!this.getGroupId().equals(mObj.getGroupId())) {
					return false;
				}
			}
			else {
				return false;
			}
			if (null != this.getAreaCd() && null != mObj.getAreaCd()) {
				if (!this.getAreaCd().equals(mObj.getAreaCd())) {
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
			if (null != this.getGroupId()) {
				sb.append(this.getGroupId().hashCode());
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


}