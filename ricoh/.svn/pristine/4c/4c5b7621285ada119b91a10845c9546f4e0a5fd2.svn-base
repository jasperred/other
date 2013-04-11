<%@ taglib prefix="s" uri="/struts-tags"%>
<s:if test="resultList!=null&&resultList.size()>0">
	<s:iterator value="resultList" status="rl" id="result">
		<tr id="machine_type_<s:property value='MachineTypeId'/>">
			<td>
				<s:property value='#rl.index+1'/>
			</td>
			<td>
				<s:property value='MachineTypeId'/>
			</td>
			<td>
				<s:property value="MachineType" />
			</td>
			<td>
				<s:property value="MachineCd" />
			</td>
			<td>
				<s:property value="MachineCat" />
			</td>
			<td>
				<s:property value="ServiceProviderType" />
			</td>
			<td>
				<s:property value="Rate1" />
			</td>
			<td>
				<s:property value="Rate2" />
			</td>
			<td>
				<a href="machineTypeInfoAction.action?machineTypeId=<s:property value="MachineTypeId" />">查看</a>
				<a href="#" onclick="deleteMachineType('<s:property value="MachineTypeId" />')">删除</a>
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