package com.sunmw.web.entity.base;

import java.io.Serializable;


public abstract class BaseCompanyMachineTypeRefPK implements Serializable {

	protected int hashCode = Integer.MIN_VALUE;

	private java.lang.Integer companyId;
	private java.lang.Integer machineTypeId;


	public BaseCompanyMachineTypeRefPK () {}
	
	public BaseCompanyMachineTypeRefPK (
		java.lang.Integer companyId,
		java.lang.Integer machineTypeId) {

		this.setCompanyId(companyId);
		this.setMachineTypeId(machineTypeId);
	}


	/**
	 * Return the value associated with the column: company_id
	 */
	public java.lang.Integer getCompanyId () {
		return companyId;
	}

	/**
	 * Set the value related to the column: company_id
	 * @param companyId the company_id value
	 */
	public void setCompanyId (java.lang.Integer companyId) {
		this.companyId = companyId;
	}



	/**
	 * Return the value associated with the column: machine_type_id
	 */
	public java.lang.Integer getMachineTypeId () {
		return machineTypeId;
	}

	/**
	 * Set the value related to the column: machine_type_id
	 * @param machineTypeId the machine_type_id value
	 */
	public void setMachineTypeId (java.lang.Integer machineTypeId) {
		this.machineTypeId = machineTypeId;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.sunmw.web.entity.CompanyMachineTypeRefPK)) return false;
		else {
			com.sunmw.web.entity.CompanyMachineTypeRefPK mObj = (com.sunmw.web.entity.CompanyMachineTypeRefPK) obj;
			if (null != this.getCompanyId() && null != mObj.getCompanyId()) {
				if (!this.getCompanyId().equals(mObj.getCompanyId())) {
					return false;
				}
			}
			else {
				return false;
			}
			if (null != this.getMachineTypeId() && null != mObj.getMachineTypeId()) {
				if (!this.getMachineTypeId().equals(mObj.getMachineTypeId())) {
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
			if (null != this.getCompanyId()) {
				sb.append(this.getCompanyId().hashCode());
				sb.append(":");
			}
			else {
				return super.hashCode();
			}
			if (null != this.getMachineTypeId()) {
				sb.append(this.getMachineTypeId().hashCode());
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