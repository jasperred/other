<%@ taglib prefix="s" uri="/struts-tags"%>
<s:if test="resultList!=null&&resultList.size()>0">
	<s:iterator value="resultList" status="rl" id="result">
		<tr id="machine_<s:property value="MachineId"/>">
			<td>
				<s:property value='#rl.index+1'/>
			</td>
			<td>
				<s:property value="MachineId"/>
			</td>
			<td>
				<s:property value="CustomerName"/>
			</td>
			<td>
				<s:property value="MachineNo" />
			</td>
			<td>
				<s:property value="PpsNo" />
			</td>
			<td>
				<s:property value="MachineType" />
			</td>
			<td>
				<s:property value="MachineCd" />
			</td>
			<td>
				<s:property value="OuterDate" />
			</td>
			<td>
				<s:property value="ServiceFromDate" />
			</td>
			<td>
				<s:property value="ServiceEndDate" />
			</td>
			<td>
				<s:property value="PaymentStatus" />
			</td>
			<td>
				<a href="machineInfoAction.action?machineId=<s:property value="MachineId" />">查看</a>
				
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