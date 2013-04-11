package com.ami.ifs.dao;

import com.ami.ifs.dao.IDnIfHead;
import java.util.List;

public interface IfsServiceMapper {
	/**
	 * 订单补充信息查询
	 */
	List<IDnIfHead> selectDnHeadAndDnLineByExample(IDnIfHeadExample example);

	/**
	 * 订单补充信息HeadId查询
	 * 
	 * @param example
	 * @return
	 */
	List<String> selectDnIfHeadIdByExample(IDnIfHeadExample example);

	/**
	 * FieldMap信息查询
	 */
	List<FieldMap> selectFieldMapByExample(FieldMapExample example);

	/**
	 * ValueMap信息查询
	 */
	List<ValueMap> selectValueMapByExample(ValueMapExample example);
}