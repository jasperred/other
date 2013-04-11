package com.sunmw.web.entity.base;

import java.io.Serializable;


public abstract class BaseServiceDeliveryFilePK implements Serializable {

	protected int hashCode = Integer.MIN_VALUE;

	private java.lang.Integer serviceDeliveryId;
	private java.lang.String fileType;


	public BaseServiceDeliveryFilePK () {}
	
	public BaseServiceDeliveryFilePK (
		java.lang.Integer serviceDeliveryId,
		java.lang.String fileType) {

		this.setServiceDeliveryId(serviceDeliveryId);
		this.setFileType(fileType);
	}


	/**
	 * Return the value associated with the column: service_delivery_id
	 */
	public java.lang.Integer getServiceDeliveryId () {
		return serviceDeliveryId;
	}

	/**
	 * Set the value related to the column: service_delivery_id
	 * @param serviceDeliveryId the service_delivery_id value
	 */
	public void setServiceDeliveryId (java.lang.Integer serviceDeliveryId) {
		this.serviceDeliveryId = serviceDeliveryId;
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
		if (!(obj instanceof com.sunmw.web.entity.ServiceDeliveryFilePK)) return false;
		else {
			com.sunmw.web.entity.ServiceDeliveryFilePK mObj = (com.sunmw.web.entity.ServiceDeliveryFilePK) obj;
			if (null != this.getServiceDeliveryId() && null != mObj.getServiceDeliveryId()) {
				if (!this.getServiceDeliveryId().equals(mObj.getServiceDeliveryId())) {
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
			if (null != this.getServiceDeliveryId()) {
				sb.append(this.getServiceDeliveryId().hashCode());
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