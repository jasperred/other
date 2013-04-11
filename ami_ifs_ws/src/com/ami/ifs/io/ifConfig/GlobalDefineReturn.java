package com.ami.ifs.io.ifConfig;

import java.util.List;

import com.ami.ifs.dao.GlobalDefine;
import com.ami.ifs.io.IfsWsReturn;
@javax.xml.bind.annotation.XmlType(name="GlobalDefineReturn")
public class GlobalDefineReturn extends IfsWsReturn {
	private List<GlobalDefine> globalDefineList;

	public List<GlobalDefine> getGlobalDefineList() {
		return globalDefineList;
	}

	public void setGlobalDefineList(List<GlobalDefine> globalDefineList) {
		this.globalDefineList = globalDefineList;
	}
	
}
