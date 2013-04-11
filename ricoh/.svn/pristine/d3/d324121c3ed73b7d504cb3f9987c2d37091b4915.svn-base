<%@ taglib prefix="s" uri="/struts-tags"%>
<s:if test="resultList!=null&&resultList.size()>0">
	<s:iterator value="resultList" status="rl" id="result">
		<tr >
			<td>
				<s:property value="#rl.index+1" />
			</td> 
			<td>
				<s:property value="CompanyName" />
			</td>
			<td>
				<s:property value="SkuCd" />
			</td>

			<td>
				<s:property value="SkuName" />
			</td>
			<td>
				<s:property value="InvQty" />
			</td>
			<td>
				<s:property value="InvCate" />
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