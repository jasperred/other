<%@ taglib prefix="s" uri="/struts-tags"%>
<s:if test="resultList!=null&&resultList.size()>0">
	<s:iterator value="resultList" status="rl" id="result">
		<tr id="order_<s:property value='LocalOrderHeadId'/>">
			<td>
				<s:property value='#rl.index+1'/>
			</td>
			<td>
				<a href="applyServiceInfoByRcnAction.action?serviceApplyId=<s:property value="ServiceApplyId" />"><s:property value='ServiceApplyNo'/></a>
			</td>
			<td>
				<s:property value='ServiceNo'/>
			</td>
			<td>
				<s:property value='MachineNo'/>
			</td>
			<td>
				<s:property value="CompanyName" />
			</td>
			<td>
				<s:property value="ServiceApplyTypeName" />
			</td>
			<td>
				<s:property value="StatusName" />
			</td>
			<td>
				<s:property value="Muser" />
			</td>
			<td>
				<a href="applyServiceInfoByRcnAction.action?serviceApplyId=<s:property value="ServiceApplyId"/>" >查看</a>
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