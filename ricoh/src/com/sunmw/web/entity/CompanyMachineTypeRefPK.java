package com.sunmw.web.entity;

import com.sunmw.web.entity.base.BaseCompanyMachineTypeRefPK;

public class CompanyMachineTypeRefPK extends BaseCompanyMachineTypeRefPK {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public CompanyMachineTypeRefPK () {}
	
	public CompanyMachineTypeRefPK (
		java.lang.Integer companyId,
		java.lang.Integer machineTypeId) {

		super (
			companyId,
			machineTypeId);
	}
/*[CONSTRUCTOR MARKER END]*/


}