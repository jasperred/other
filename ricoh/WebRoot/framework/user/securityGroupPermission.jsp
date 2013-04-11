<%@ taglib prefix="s" uri="/struts-tags"%>
<table id="security-group-permission" width="800px" height="500px">
	<s:iterator value="permissionList" status="li">
	<tr bgcolor="#9097A9">
		<td align="left" colspan="10" width="100%" height="10">
			<span><input type="checkbox" id='permission_<s:property value="PermissionId"/>' permissionId='<s:property value="PermissionId"/>'/></span>
			<label>
				<s:property value="PermissionName"/>
			</label>
		</td>
	</tr>
		<tr>
		<s:iterator value="SubList" status="si">
			<td align="left" height="10">
				<span><input type="checkbox" id='permission_<s:property value="PermissionId"/>' permissionId='<s:property value="PermissionId"/>'/></span>
				<label>
					<s:property value="PermissionName"/>
				</label>
			</td>
			
		<s:if test="(#si.index+1)%10==0"></tr><tr></s:if>
		</s:iterator>
		</tr>
	</s:iterator>
	
</table>
<script type="text/javascript">
	$(document).ready(function(){
		var permissionIds = '<s:property value="permissionIds"/>';
		var pids = permissionIds.split(",");
		for(i=0;i<pids.length;i++)
		{
			$("#permission_"+pids[i]).attr("checked",true);
		}
		
		});
</script>
