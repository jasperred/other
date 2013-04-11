package com.ami.ifs.ws.common;

import java.util.Date;
import java.util.List;

import com.ami.ifs.dao.IfsKey;
import com.ami.ifs.dao.IfsKeyExample;
import com.ami.ifs.dao.IfsKeyMapper;
import com.ami.ifs.dao.IfsUnit;
import com.ami.ifs.dao.IfsUnitExample;
import com.ami.ifs.dao.IfsUnitMapper;
import com.ami.ifs.util.WebUtil;

@javax.xml.bind.annotation.XmlType(name="Security")
public class Security {
	
	private IfsUnitMapper ifsUnitMapper;
	private IfsKeyMapper ifsKeyMapper;
	
	public IfsUnitMapper getIfsUnitMapper() {
		return ifsUnitMapper;
	}
	public void setIfsUnitMapper(IfsUnitMapper ifsUnitMapper) {
		this.ifsUnitMapper = ifsUnitMapper;
	}
	public IfsKeyMapper getIfsKeyMapper() {
		return ifsKeyMapper;
	}
	public void setIfsKeyMapper(IfsKeyMapper ifsKeyMapper) {
		this.ifsKeyMapper = ifsKeyMapper;
	}
	//IFS C 检查ifsKey是否有效
	public List<IfsUnit> checkSecurity(String ifsKey)
	{
		//检查KEY是否有效
		IfsKeyExample keyExample = new IfsKeyExample();
		com.ami.ifs.dao.IfsKeyExample.Criteria kc = keyExample.createCriteria();
		kc.andWsKeyEqualTo(ifsKey);
		//kc.andWsTypeEqualTo("C");
		kc.andStatusEqualTo("NORMAL");
		Date date = new Date();
		kc.andCreateTimeLessThan(date);
		kc.andInvalidTimeGreaterThanOrEqualTo(date);
		List<IfsKey> keyList = ifsKeyMapper.selectByExample(keyExample);
		if(WebUtil.isNullForList(keyList))
			return null;
		//返回相关店铺
		IfsUnitExample example = new IfsUnitExample();
		com.ami.ifs.dao.IfsUnitExample.Criteria c = example.createCriteria();
		com.ami.ifs.dao.IfsUnitExample.Criteria c2 = example.createCriteria();
		c.andWsCKeyEqualTo(ifsKey);
		c2.andWsAKeyEqualTo(ifsKey);
		example.or(c2);
		List<IfsUnit> iuList = ifsUnitMapper.selectByExample(example);
		return iuList;
	}
	//IFS C 检查ifsKey和ifsCCd是否有效
	public List<IfsUnit> checkSecurityForC(String ifsKey,String ifsCCd)
	{
		//检查KEY是否有效
		IfsKeyExample keyExample = new IfsKeyExample();
		com.ami.ifs.dao.IfsKeyExample.Criteria kc = keyExample.createCriteria();
		kc.andWsKeyEqualTo(ifsKey);
		kc.andIfsCdEqualTo(ifsCCd);
		kc.andWsTypeEqualTo("C");
		kc.andStatusEqualTo("NORMAL");
		Date date = new Date();
		kc.andCreateTimeLessThan(date);
		kc.andInvalidTimeGreaterThanOrEqualTo(date);
		List<IfsKey> keyList = ifsKeyMapper.selectByExample(keyExample);
		if(WebUtil.isNullForList(keyList))
			return null;
		//返回相关店铺
		IfsUnitExample example = new IfsUnitExample();
		com.ami.ifs.dao.IfsUnitExample.Criteria c = example.createCriteria();
		c.andWsCKeyEqualTo(ifsKey);
		c.andIfsCCdEqualTo(ifsCCd);
		List<IfsUnit> iuList = ifsUnitMapper.selectByExample(example);
		return iuList;
	}
	public List<IfsUnit> checkSecurityForC(String ifsKey,String ifsCCd,String storeCd)
	{
		//检查KEY是否有效
		IfsKeyExample keyExample = new IfsKeyExample();
		com.ami.ifs.dao.IfsKeyExample.Criteria kc = keyExample.createCriteria();
		kc.andWsKeyEqualTo(ifsKey);
		kc.andIfsCdEqualTo(ifsCCd);
		kc.andWsTypeEqualTo("C");
		kc.andStatusEqualTo("NORMAL");
		Date date = new Date();
		kc.andCreateTimeLessThan(date);
		kc.andInvalidTimeGreaterThanOrEqualTo(date);
		List<IfsKey> keyList = ifsKeyMapper.selectByExample(keyExample);
		if(WebUtil.isNullForList(keyList))
			return null;
		//返回相关店铺
		IfsUnitExample example = new IfsUnitExample();
		com.ami.ifs.dao.IfsUnitExample.Criteria c = example.createCriteria();
		c.andWsCKeyEqualTo(ifsKey);
		c.andIfsCCdEqualTo(ifsCCd);
		c.andStoreCdEqualTo(storeCd);
		List<IfsUnit> iuList = ifsUnitMapper.selectByExample(example);
		return iuList;
	}
	
	//IFS A 检查ifsKey和ifsACd是否有效
	public List<IfsUnit> checkSecurityForA(String ifsKey,String ifsACd)
	{
		//检查KEY是否有效
		IfsKeyExample keyExample = new IfsKeyExample();
		com.ami.ifs.dao.IfsKeyExample.Criteria kc = keyExample.createCriteria();
		kc.andWsKeyEqualTo(ifsKey);
		kc.andIfsCdEqualTo(ifsACd);
		kc.andWsTypeEqualTo("A");
		kc.andStatusEqualTo("NORMAL");
		Date date = new Date();
		kc.andCreateTimeLessThan(date);
		kc.andInvalidTimeGreaterThanOrEqualTo(date);
		List<IfsKey> keyList = ifsKeyMapper.selectByExample(keyExample);
		if(WebUtil.isNullForList(keyList))
			return null;
		//返回相关店铺
		IfsUnitExample example = new IfsUnitExample();
		com.ami.ifs.dao.IfsUnitExample.Criteria c = example.createCriteria();
		c.andWsAKeyEqualTo(ifsKey);
		c.andIfsACdEqualTo(ifsACd);
		List<IfsUnit> iuList = ifsUnitMapper.selectByExample(example);
		return iuList;
	}
	
	public List<IfsUnit> checkSecurityForA(String ifsKey,String ifsACd,String storeCd)
	{
		//检查KEY是否有效
		IfsKeyExample keyExample = new IfsKeyExample();
		com.ami.ifs.dao.IfsKeyExample.Criteria kc = keyExample.createCriteria();
		kc.andWsKeyEqualTo(ifsKey);
		kc.andIfsCdEqualTo(ifsACd);
		kc.andWsTypeEqualTo("A");
		kc.andStatusEqualTo("NORMAL");
		Date date = new Date();
		kc.andCreateTimeLessThan(date);
		kc.andInvalidTimeGreaterThanOrEqualTo(date);
		List<IfsKey> keyList = ifsKeyMapper.selectByExample(keyExample);
		if(WebUtil.isNullForList(keyList))
			return null;
		//返回相关店铺
		IfsUnitExample example = new IfsUnitExample();
		com.ami.ifs.dao.IfsUnitExample.Criteria c = example.createCriteria();
		c.andWsAKeyEqualTo(ifsKey);
		c.andIfsACdEqualTo(ifsACd);
		c.andStoreCdEqualTo(storeCd);
		List<IfsUnit> iuList = ifsUnitMapper.selectByExample(example);
		return iuList;
	}

}
