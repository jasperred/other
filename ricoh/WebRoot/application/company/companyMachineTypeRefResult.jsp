<%@ taglib prefix="s" uri="/struts-tags"%>
<s:if test="resultList!=null&&resultList.size()>0">
	<s:iterator value="resultList" status="rl" id="result">
		<tr id="company_machine_type_<s:property value='CompanyId'/><s:property value="MachineTypeId" />">
			<td>
				<s:property value='#rl.index+1'/>
			</td>
			<td>
				<s:property value='CompanyNo'/>
			</td> 
			<td>
				<s:property value="CompanyName" />
			</td>
			<td>
				<s:property value="MachineCd" />
			</td>
			<td>
				<s:property value="MachineType" />
			</td>
			<td>
				<s:property value="CUser" />
			</td>
			<td>
				<s:property value="CTime" />
			</td>
			<td>
				<a href="#" onclick="deleteCompanyMachineTypeRef('<s:property value="CompanyId" />','<s:property value="MachineTypeId" />')">删除</a>
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