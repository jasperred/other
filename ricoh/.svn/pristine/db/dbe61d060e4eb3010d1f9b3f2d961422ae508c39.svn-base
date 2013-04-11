<%@ taglib prefix="s" uri="/struts-tags"%>
<table id="user-security-group">
	<tr>
		<s:iterator value="securityGroupList" status="li">
		<td align="right">
			<label>
				<s:property value="Description"/>
			</label><span><input type="checkbox" id='group_<s:property value="id"/>' groupId='<s:property value="id"/>'/></span>
		</td>
		<s:if test="(#li.index+1)%5==0"></tr><tr></s:if>
		</s:iterator>
	</tr>
	
</table>
<script type="text/javascript">
	$(document).ready(function(){
		var groupIds = unicodeToString('<s:property value="groupIds"/>');
		var gids = groupIds.split(",");
		for(i=0;i<gids.length;i++)
		{
			$("#group_"+gids[i]).attr("checked",true);
		}
		
		});
</script>
