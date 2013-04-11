package com.ami.ifs.ws.ifsConfig;

import javax.jws.WebService;

import com.ami.ifs.io.ifConfig.FieldMapParams;
import com.ami.ifs.io.ifConfig.FieldMapReturn;
import com.ami.ifs.io.ifConfig.GlobalDefineParams;
import com.ami.ifs.io.ifConfig.GlobalDefineReturn;
import com.ami.ifs.io.ifConfig.ValueMapParams;
import com.ami.ifs.io.ifConfig.ValueMapReturn;

@WebService(name="IfsConfigServices")
public interface IfsConfigServices {
	
	/**
	 * 得到GlobalDefine信息
	 * @param param
	 * @return
	 */
	public GlobalDefineReturn getGlobalDefineInfo(GlobalDefineParams param);
	
	/**
	 * 得到FieldMap信息
	 * @param param
	 * @return
	 */
	public FieldMapReturn getFieldMapInfo(FieldMapParams param);
	
	/**
	 * 得到ValueMap信息
	 * @param param
	 * @return
	 */
	public ValueMapReturn getValueMapInfo(ValueMapParams param);

}
