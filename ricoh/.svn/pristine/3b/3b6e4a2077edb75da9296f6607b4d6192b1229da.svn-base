<%@ taglib prefix="s" uri="/struts-tags"%>
<s:if test="resultList!=null&&resultList.size()>0">
	<s:iterator value="resultList" status="rl" id="result">
		<tr id="company_<s:property value='CompanyId'/>">
			<td>
				<input type="checkbox" company-id="<s:property value='CompanyId'/>" onclick="companySelect($(this));"/>
			</td>
			<td>
				<s:property value='CompanyNo'/>
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