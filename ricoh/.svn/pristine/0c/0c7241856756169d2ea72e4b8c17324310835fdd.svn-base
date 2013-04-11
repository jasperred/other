<%@ taglib prefix="s" uri="/struts-tags"%>
<s:if test="resultList!=null&&resultList.size()>0">
	<s:iterator value="resultList" status="rl" id="result">
		<tr id="delivery_<s:property value='ServiceDeliveryId'/>">
			<td>
				<s:property value='#rl.index+1'/>
			</td>
			<td>
				<s:if test="Department.equals(\"SCM\")">
					<a href="deliveryServiceScmInfoByRcnAction.action?serviceDeliveryId=<s:property value="ServiceDeliveryId" />"><s:property value='ServiceDeliveryNo'/></a>
				</s:if>
				<s:else>
					<a href="deliveryServiceCspcInfoByRcnAction.action?serviceDeliveryId=<s:property value="ServiceDeliveryId" />"><s:property value='ServiceDeliveryNo'/></a>
				</s:else>
				
			</td>
			<td>
				<s:property value="ServiceNo" />
			</td>
			<td>
				<s:property value="CompanyName" />
			</td>
			<td>
				<s:property value="ShippingNo" />
			</td>
			<td>
				<s:property value="StatusName" />
			</td>
			<td>
				<s:if test="Department.equals(\"SCM\")">
				<a href="deliveryServiceScmInfoByRcnAction.action?serviceDeliveryId=<s:property value="ServiceDeliveryId" />">查看</a>
				</s:if>
				<s:else>
				<a href="deliveryServiceCspcInfoByRcnAction.action?serviceDeliveryId=<s:property value="ServiceDeliveryId" />">查看</a>
				</s:else>
				
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