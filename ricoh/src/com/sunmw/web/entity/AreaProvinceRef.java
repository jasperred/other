package com.sunmw.web.entity;

import com.sunmw.web.entity.base.BaseAreaProvinceRef;



public class AreaProvinceRef extends BaseAreaProvinceRef {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public AreaProvinceRef () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public AreaProvinceRef (
		java.lang.String provinceCd,
		java.lang.String areaCd) {

		super (
			provinceCd,
			areaCd);
	}

/*[CONSTRUCTOR MARKER END]*/


}