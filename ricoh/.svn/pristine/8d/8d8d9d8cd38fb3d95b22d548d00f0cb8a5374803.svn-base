package com.sunmw.web.entity.base;

import java.io.Serializable;


public abstract class BaseServiceApplyFilePK implements Serializable {

	protected int hashCode = Integer.MIN_VALUE;

	private int serviceApplyId;
	private java.lang.String fileType;


	public BaseServiceApplyFilePK () {}
	
	public BaseServiceApplyFilePK (
		int serviceApplyId,
		java.lang.String fileType) {

		this.setServiceApplyId(serviceApplyId);
		this.setFileType(fileType);
	}


	/**
	 * Return the value associated with the column: service_apply_id
	 */
	public int getServiceApplyId () {
		return serviceApplyId;
	}

	/**
	 * Set the value related to the column: service_apply_id
	 * @param serviceApplyId the service_apply_id value
	 */
	public void setServiceApplyId (int serviceApplyId) {
		this.serviceApplyId = serviceApplyId;
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
		if (!(obj instanceof com.sunmw.web.entity.ServiceApplyFilePK)) return false;
		else {
			com.sunmw.web.entity.ServiceApplyFilePK mObj = (com.sunmw.web.entity.ServiceApplyFilePK) obj;
			if (this.getServiceApplyId() != mObj.getServiceApplyId()) {
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
			sb.append(new java.lang.Integer(this.getServiceApplyId()).hashCode());
			sb.append(":");
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