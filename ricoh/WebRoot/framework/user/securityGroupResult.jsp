<%@ taglib prefix="s" uri="/struts-tags"%>
<s:if test="resultList!=null&&resultList.size()>0">
	<s:iterator value="resultList" status="rl" id="result">
		<tr id="sg_<s:property value='GroupId'/>">			
			<td>
				<s:property value="GroupId" />
			</td>
			<td>
				<s:property value="GroupName" />
			</td>
			<td>
				<s:property value="Level" />
			</td>
			<td>
				<a href="#" onclick="saveSecurityGroup('sg_<s:property value='GroupId'/>');">修改</a>
			</td>
			<td>
				<a href="#" onclick="saveSecurityGroupPermission('sg_<s:property value='GroupId'/>');">权限</a>&nbsp;&nbsp;
				<a href="#" onclick="saveSecurityGroupArea('sg_<s:property value='GroupId'/>');">区域</a>
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