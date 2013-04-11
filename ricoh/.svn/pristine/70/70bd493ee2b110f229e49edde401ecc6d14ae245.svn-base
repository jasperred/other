package com.sunmw.web.entity.base;

import java.io.Serializable;


public abstract class BaseInvoiceServiceRefPK implements Serializable {

	protected int hashCode = Integer.MIN_VALUE;

	private java.lang.Integer serviceId;
	private java.lang.Integer invoiceId;


	public BaseInvoiceServiceRefPK () {}
	
	public BaseInvoiceServiceRefPK (
		java.lang.Integer serviceId,
		java.lang.Integer invoiceId) {

		this.setServiceId(serviceId);
		this.setInvoiceId(invoiceId);
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
	 * Return the value associated with the column: invoice_id
	 */
	public java.lang.Integer getInvoiceId () {
		return invoiceId;
	}

	/**
	 * Set the value related to the column: invoice_id
	 * @param invoiceId the invoice_id value
	 */
	public void setInvoiceId (java.lang.Integer invoiceId) {
		this.invoiceId = invoiceId;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.sunmw.web.entity.InvoiceServiceRefPK)) return false;
		else {
			com.sunmw.web.entity.InvoiceServiceRefPK mObj = (com.sunmw.web.entity.InvoiceServiceRefPK) obj;
			if (null != this.getServiceId() && null != mObj.getServiceId()) {
				if (!this.getServiceId().equals(mObj.getServiceId())) {
					return false;
				}
			}
			else {
				return false;
			}
			if (null != this.getInvoiceId() && null != mObj.getInvoiceId()) {
				if (!this.getInvoiceId().equals(mObj.getInvoiceId())) {
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
			if (null != this.getInvoiceId()) {
				sb.append(this.getInvoiceId().hashCode());
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