package com.ami.ifs.io.ifConfig;

import java.util.List;

import com.ami.ifs.dao.ValueMap;
import com.ami.ifs.io.IfsWsReturn;

@javax.xml.bind.annotation.XmlType(name="ValueMapReturn")
public class ValueMapReturn extends IfsWsReturn {
	
	private List<ValueMap> valueMapList;

	public List<ValueMap> getValueMapList() {
		return valueMapList;
	}

	public void setValueMapList(List<ValueMap> valueMapList) {
		this.valueMapList = valueMapList;
	}

}
