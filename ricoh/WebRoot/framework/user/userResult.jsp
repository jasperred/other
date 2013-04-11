<%@ taglib prefix="s" uri="/struts-tags"%>
<s:if test="resultList!=null&&resultList.size()>0">
	<s:iterator value="resultList" status="rl" id="result">
		<tr id="order_<s:property value='UserName'/>">	
			<td>
				<s:property value="UserId" />
			</td>	
			<td>
				<s:property value="UserNo" />
			</td>	
			<td>
				<s:property value="UserName" />
			</td>
			<td>
				<s:property value="Email" />
			</td>
			<td>
				<s:if test="CompanyStatus.equals(\"NORMAL\")">
				<s:property value="CompanyName" />
				</s:if>
			</td>
			<td>
				<s:property value="EnabledName" />
			</td>
			<td>
				<a href="getUserInfoAction.action?userId=<s:property value="UserId"/>" >修改</a>&nbsp;
				<a href="#" onclick="modify_pwd('<s:property value="UserId"/>','<s:property value="UserNo"/>');">密码</a>
				<a href="#" onclick="reset_pwd('<s:property value="UserId"/>','<s:property value="UserNo"/>');">密码重置</a>
			</td>
			<td>
				<a href="#" onclick="userSecurityGroup('<s:property value="UserId"/>');">角色</a>
			</td>
			
		</tr>
	</s:iterator>
	<!-- 分页 -->
	<input type="hidden" value='<s:property value="currentPage" />'
		id="current-page" />
	<input type="hidden" value="<s:property value='rowCount' />"
		id="row-count" />
	<input type="hidden" value="<s:property value='pageCount' />"
		id="page-count" />
</s:if>