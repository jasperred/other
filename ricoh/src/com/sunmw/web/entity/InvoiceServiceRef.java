package com.sunmw.web.entity;

import com.sunmw.web.entity.base.BaseInvoiceServiceRef;



public class InvoiceServiceRef extends BaseInvoiceServiceRef {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public InvoiceServiceRef () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public InvoiceServiceRef (com.sunmw.web.entity.InvoiceServiceRefPK id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public InvoiceServiceRef (
		com.sunmw.web.entity.InvoiceServiceRefPK id,
		java.lang.Integer serviceApplyId) {

		super (
			id,
			serviceApplyId);
	}

/*[CONSTRUCTOR MARKER END]*/


}