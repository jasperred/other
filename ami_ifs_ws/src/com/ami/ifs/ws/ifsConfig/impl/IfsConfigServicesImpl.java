package com.ami.ifs.ws.ifsConfig.impl;

import java.util.List;

import com.ami.ifs.dao.FieldMap;
import com.ami.ifs.dao.FieldMapExample;
import com.ami.ifs.dao.FieldMapLineMapper;
import com.ami.ifs.dao.FieldMapMapper;
import com.ami.ifs.dao.GlobalDefine;
import com.ami.ifs.dao.GlobalDefineExample;
import com.ami.ifs.dao.GlobalDefineMapper;
import com.ami.ifs.dao.IfsServiceMapper;
import com.ami.ifs.dao.IfsUnit;
import com.ami.ifs.dao.ValueMap;
import com.ami.ifs.dao.ValueMapExample;
import com.ami.ifs.dao.ValueMapLineMapper;
import com.ami.ifs.dao.ValueMapMapper;
import com.ami.ifs.io.MessageMapping;
import com.ami.ifs.io.ifConfig.FieldMapParams;
import com.ami.ifs.io.ifConfig.FieldMapReturn;
import com.ami.ifs.io.ifConfig.GlobalDefineParams;
import com.ami.ifs.io.ifConfig.GlobalDefineReturn;
import com.ami.ifs.io.ifConfig.ValueMapParams;
import com.ami.ifs.io.ifConfig.ValueMapReturn;
import com.ami.ifs.util.WebUtil;
import com.ami.ifs.ws.common.Security;
import com.ami.ifs.ws.ifsConfig.IfsConfigServices;

public class IfsConfigServicesImpl implements IfsConfigServices {
	private Security security;
	private IfsServiceMapper ifsServiceMapper;
	private FieldMapMapper fieldMapMapper;
	private FieldMapLineMapper fieldMapLineMapper;
	private GlobalDefineMapper globalDefineMapper;
	private ValueMapMapper valueMapMapper;
	private ValueMapLineMapper valueMapLineMapper;
	

	public Security getSecurity() {
		return security;
	}

	public void setSecurity(Security security) {
		this.security = security;
	}

	public IfsServiceMapper getIfsServiceMapper() {
		return ifsServiceMapper;
	}

	public void setIfsServiceMapper(IfsServiceMapper ifsServiceMapper) {
		this.ifsServiceMapper = ifsServiceMapper;
	}

	public FieldMapMapper getFieldMapMapper() {
		return fieldMapMapper;
	}

	public void setFieldMapMapper(FieldMapMapper fieldMapMapper) {
		this.fieldMapMapper = fieldMapMapper;
	}

	public FieldMapLineMapper getFieldMapLineMapper() {
		return fieldMapLineMapper;
	}

	public void setFieldMapLineMapper(FieldMapLineMapper fieldMapLineMapper) {
		this.fieldMapLineMapper = fieldMapLineMapper;
	}

	public GlobalDefineMapper getGlobalDefineMapper() {
		return globalDefineMapper;
	}

	public void setGlobalDefineMapper(GlobalDefineMapper globalDefineMapper) {
		this.globalDefineMapper = globalDefineMapper;
	}

	public ValueMapMapper getValueMapMapper() {
		return valueMapMapper;
	}

	public void setValueMapMapper(ValueMapMapper valueMapMapper) {
		this.valueMapMapper = valueMapMapper;
	}

	public ValueMapLineMapper getValueMapLineMapper() {
		return valueMapLineMapper;
	}

	public void setValueMapLineMapper(ValueMapLineMapper valueMapLineMapper) {
		this.valueMapLineMapper = valueMapLineMapper;
	}

	public FieldMapReturn getFieldMapInfo(FieldMapParams param) {
		FieldMapReturn fr = new FieldMapReturn();
		MessageMapping mm = new MessageMapping();
		if(WebUtil.isNull(param.getIfsKey()))
		{
			fr.setFlag("ERROR");
			fr.setFieldMapList(null);
			fr.addMessage(mm.getKeyErrorMessageForAsp());
			return fr;
		}
		//检查IFSKEY
		List<IfsUnit> iuList = security.checkSecurity( param.getIfsKey());
		if(WebUtil.isNullForList(iuList))
		{
			fr.setFlag("ERROR");
			fr.setFieldMapList(null);
			fr.addMessage(mm.getKeyErrorMessageForAsp());
			return fr;
		}
		FieldMapExample ex = new FieldMapExample();
		FieldMapExample.Criteria fc = ex.createCriteria();
		fc.andCd1EqualTo(param.getCd1());
		fc.andCd2EqualTo(param.getCd2());
		fc.andCd3EqualTo(param.getCd3());
		List<FieldMap> fieldMapList = this.ifsServiceMapper.selectFieldMapByExample(ex);
		fr.setFieldMapList(fieldMapList);
		fr.setFlag("SUCCESS");
		return fr;
	}

	public GlobalDefineReturn getGlobalDefineInfo(GlobalDefineParams param) {
		GlobalDefineReturn gr = new GlobalDefineReturn();
		MessageMapping mm = new MessageMapping();
		if(WebUtil.isNull(param.getIfsKey()))
		{
			gr.setFlag("ERROR");
			gr.setGlobalDefineList(null);
			gr.addMessage(mm.getKeyErrorMessageForAsp());
			return gr;
		}
		//检查IFSKEY
		List<IfsUnit> iuList = security.checkSecurity( param.getIfsKey());
		if(WebUtil.isNullForList(iuList))
		{
			gr.setFlag("ERROR");
			gr.setGlobalDefineList(null);
			gr.addMessage(mm.getKeyErrorMessageForAsp());
			return gr;
		}
		GlobalDefineExample ex = new GlobalDefineExample();
		GlobalDefineExample.Criteria gc = ex.createCriteria();
		gc.andStoreIdEqualTo(param.getStoreId());
		List<GlobalDefine> globalDefineList = this.globalDefineMapper.selectByExample(ex);
		gr.setFlag("SUCCESS");
		gr.setGlobalDefineList(globalDefineList);
		return gr;
	}

	public ValueMapReturn getValueMapInfo(ValueMapParams param) {
		ValueMapReturn vr = new ValueMapReturn();
		MessageMapping mm = new MessageMapping();
		if(WebUtil.isNull(param.getIfsKey()))
		{
			vr.setFlag("ERROR");
			vr.setValueMapList(null);
			vr.addMessage(mm.getKeyErrorMessageForAsp());
			return vr;
		}
		//检查IFSKEY
		List<IfsUnit> iuList = security.checkSecurity( param.getIfsKey());
		if(WebUtil.isNullForList(iuList))
		{
			vr.setFlag("ERROR");
			vr.setValueMapList(null);
			vr.addMessage(mm.getKeyErrorMessageForAsp());
			return vr;
		}
		ValueMapExample ex = new ValueMapExample();
		ValueMapExample.Criteria vc = ex.createCriteria();
		vc.andCd1EqualTo(param.getCd1());
		vc.andCd2EqualTo(param.getCd2());
		vc.andCd3EqualTo(param.getCd3());
		List<ValueMap> valueMapList = this.ifsServiceMapper.selectValueMapByExample(ex);
		vr.setValueMapList(valueMapList);
		vr.setFlag("SUCCESS");
		return vr;
	}

}
