<%@ taglib prefix="s" uri="/struts-tags"%>
<s:if test="resultList!=null&&resultList.size()>0">
	<s:iterator value="resultList" status="rl" id="result">
		<tr id="service_<s:property value="ServiceId" />">
			<td>
				<s:property value='#rl.index+1'/>
			</td>
			<td>
				<a href="viewNewServiceInfoAction.action?serviceId=<s:property value="ServiceId" />"><s:property value='ServiceNo'/></a>
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
				<s:property value="ServiceApplyAuditedDate" />
			</td>
			<td>
				<a href="#" onclick="showVisitDialog('<s:property value="ServiceId" />','<s:property value="ServiceNo" />')">回访</a>
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