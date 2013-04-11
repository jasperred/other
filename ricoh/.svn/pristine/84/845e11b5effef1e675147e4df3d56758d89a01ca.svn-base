<%@ taglib prefix="s" uri="/struts-tags"%>
<s:if test="resultList!=null&&resultList.size()>0">
	<s:iterator value="resultList" status="rl" id="result">
		<tr id="company_<s:property value='CompanyId'/>">
			<td>
				<s:property value='#rl.index+1'/>
			</td>
			<td>
				<a href="companyInfoAction.action?companyId=<s:property value="CompanyId" />"><s:property value='CompanyNo'/></a>
			</td>
			<td>
				<s:property value="CompanyName" />
			</td>
			<td>
				<s:property value="CompanyCategoryName" />
			</td>
			<td>
				<s:property value="RcnNo" />
			</td>
			<td>
				<s:property value="ProvinceName" />
			</td>
			<td>
				<s:property value="ProvinceCd" />
			</td>
			<td>
				<a href="companyInfoAction.action?companyId=<s:property value="CompanyId" />">修改</a>
				<a href="#" onclick="deleteCompany('<s:property value="CompanyId" />')">删除</a>
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