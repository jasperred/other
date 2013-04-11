<%@ taglib prefix="s" uri="/struts-tags"%>
<s:if test="resultList!=null&&resultList.size()>0">
	<s:iterator value="resultList" status="rl" id="result">
		<tr id="area_<s:property value='#rl.index'/>">			
			<td>
				<s:property value="AreaCd" />
			</td>
			<td>
				<s:property value="AreaName" />
			</td>
			<td>
				<a href="#" onclick="saveArea('area_<s:property value='#rl.index'/>');">修改</a>
				<a href="#" onclick="deleteArea('area_<s:property value='#rl.index'/>');">删除</a>
			</td>
			<td>
				<a href="#" onclick="saveAreaProvince('area_<s:property value='#rl.index'/>');">省份</a>
			</td>
			
		</tr>
	</s:iterator>
	<!-- 分页 -->
	<input type="hidden" value='<s:property value="currentPage" />'
		id="current-page" />
	<input type="hidden" value="<s:property value='rowCount' />"
		id="row-count" />
	<input type="hidden" value="<s:property value='pageCount' />"
		id="page-count" />
</s:if>