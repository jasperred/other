<%@ taglib prefix="s" uri="/struts-tags"%>
<s:if test="resultList!=null&&resultList.size()>0">
	<s:iterator value="resultList" status="rl" id="result">
		<tr>
			<td>
				<s:property value='#rl.index+1'/>
			</td>
			<td>
				<a href="invoiceInfoByShopAction.action?invoiceId=<s:property value="InvoiceId" />"><s:property value='InvoiceCd'/></a>
			</td>
			<td>
				<s:property value="CompanyName" />
			</td>
			<td>
				<s:property value="ServiceAmt" />
			</td>
			<td>
				<s:property value="HomeAmt" />
			</td>
			<td>
				<s:property value="OtherAmt" />
			</td>
			<td>
				<s:property value="TotalAmt" />
			</td>
			<td>
				<s:property value="InvoiceDate" />
			</td>
			<td>
				<s:property value="InvoiceNoticeDate" />
			</td>
			<td>
				<a href="invoiceInfoByShopAction.action?invoiceId=<s:property value="InvoiceId"/>" >查看</a>
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