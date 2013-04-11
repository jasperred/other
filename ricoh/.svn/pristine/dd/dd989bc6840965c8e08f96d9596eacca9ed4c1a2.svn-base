<%@ taglib prefix="s" uri="/struts-tags"%>
<s:if test="resultList!=null&&resultList.size()>0">
	<s:iterator value="resultList" status="rl" id="result">
		<tr id="order_<s:property value='ServiceId'/>">
			<td>
				<s:property value='#rl.index+1'/>
			</td>
			<td>
				<a href="serviceInfoByRcnAction.action?serviceId=<s:property value="ServiceId" />"><s:property value='ServiceNo'/></a>
			</td>
			<td>
				<s:property value="CompanyName" />
			</td>
			<td>
				<s:property value="MachineType" />
			</td>
			<td>
				<s:property value="MachineNo" />
			</td>
			<td>
				<s:property value="ServiceDate" />
			</td>
			<td>
				<s:property value="ServiceStatusName" />
			</td>
			<td>
				<a href="serviceInfoByRcnAction.action?serviceId=<s:property value="ServiceId"/>" >查看</a>
			</td>
		</tr>
	</s:iterator>
	<!-- 分页 -->
	<input type="hidden" value="<s:property value='currentPage' />"
		id="current-page" />
	<input type="hidden" value="<s:property value='rowCount' />"
		id="row-count" />
	<input type="hidden" value="<s:property value='pageCount' />"
		id="page-count" />
</s:if>