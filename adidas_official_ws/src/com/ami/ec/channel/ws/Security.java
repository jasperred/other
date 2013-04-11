package com.ami.ec.channel.ws;

import java.util.ArrayList;
import java.util.List;

import com.ami.ec.channel.dao.officialPlugin.WsKeyMapper;
import com.ami.ec.channel.domain.officialPlugin.WsKey;
import com.ami.ec.channel.domain.officialPlugin.WsKeyExample;
import com.ami.ec.channel.util.WebUtil;

public class Security {
	private WsKeyMapper wsKeyMapper;

	public WsKeyMapper getWsKeyMapper() {
		return wsKeyMapper;
	}

	public void setWsKeyMapper(WsKeyMapper wsKeyMapper) {
		this.wsKeyMapper = wsKeyMapper;
	}
	
	public Long checkWsKey(String userNo,String wsKey)
	{
		if(WebUtil.isNull(userNo))
			return null;
		if(WebUtil.isNull(wsKey))
			return null;
		WsKeyExample ex = new WsKeyExample();
		com.ami.ec.channel.domain.officialPlugin.WsKeyExample.Criteria c = ex.createCriteria();
		c.andWsKeyEqualTo(wsKey);
		c.andUserNoEqualTo(userNo);
		c.andStatusEqualTo(1);
		List<WsKey> keyList = wsKeyMapper.selectByExample(ex);
		if(WebUtil.isNullForList(keyList))
			return null;
		WsKey key = keyList.get(0);
		return key.getStoreId();
	}
	
	public List checkWsKeyMultiple(String userNo,String wsKey)
	{
		if(WebUtil.isNull(userNo))
			return null;
		if(WebUtil.isNull(wsKey))
			return null;
		WsKeyExample ex = new WsKeyExample();
		com.ami.ec.channel.domain.officialPlugin.WsKeyExample.Criteria c = ex.createCriteria();
		c.andWsKeyEqualTo(wsKey);
		c.andUserNoEqualTo(userNo);
		c.andStatusEqualTo(1);
		List<WsKey> keyList = wsKeyMapper.selectByExample(ex);
		if(WebUtil.isNullForList(keyList))
			return null;
		List<Long> l = new ArrayList();
		for(WsKey wk:keyList)
			l.add(wk.getStoreId());
		return l;
	}
}
