package com.sunmw.web.entity.base;

import java.io.Serializable;


public abstract class BaseServiceOrderFilePK implements Serializable {

	protected int hashCode = Integer.MIN_VALUE;

	private java.lang.Integer serviceId;
	private java.lang.String fileType;


	public BaseServiceOrderFilePK () {}
	
	public BaseServiceOrderFilePK (
		java.lang.Integer serviceId,
		java.lang.String fileType) {

		this.setServiceId(serviceId);
		this.setFileType(fileType);
	}


	/**
	 * Return the value associated with the column: service_id
	 */
	public java.lang.Integer getServiceId () {
		return serviceId;
	}

	/**
	 * Set the value related to the column: service_id
	 * @param serviceId the service_id value
	 */
	public void setServiceId (java.lang.Integer serviceId) {
		this.serviceId = serviceId;
	}



	/**
	 * Return the value associated with the column: file_type
	 */
	public java.lang.String getFileType () {
		return fileType;
	}

	/**
	 * Set the value related to the column: file_type
	 * @param fileType the file_type value
	 */
	public void setFileType (java.lang.String fileType) {
		this.fileType = fileType;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.sunmw.web.entity.ServiceOrderFilePK)) return false;
		else {
			com.sunmw.web.entity.ServiceOrderFilePK mObj = (com.sunmw.web.entity.ServiceOrderFilePK) obj;
			if (null != this.getServiceId() && null != mObj.getServiceId()) {
				if (!this.getServiceId().equals(mObj.getServiceId())) {
					return false;
				}
			}
			else {
				return false;
			}
			if (null != this.getFileType() && null != mObj.getFileType()) {
				if (!this.getFileType().equals(mObj.getFileType())) {
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
			if (null != this.getServiceId()) {
				sb.append(this.getServiceId().hashCode());
				sb.append(":");
			}
			else {
				return super.hashCode();
			}
			if (null != this.getFileType()) {
				sb.append(this.getFileType().hashCode());
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