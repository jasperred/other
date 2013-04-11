<%@ taglib prefix="s" uri="/struts-tags"%>
<table id="security-group-area" width="100%">
	<tr>
		<s:iterator value="areaList" status="li">
		<td align="left">
			<span><input type="checkbox" id='area_<s:property value="id"/>' areaId='<s:property value="id"/>'/></span>
			<label>
				<s:property value="AreaName"/>
			</label>
		</td>
		<s:if test="(#li.index+1)%4==0"></tr><tr></s:if>
		</s:iterator>
	</tr>
	
</table>
<script type="text/javascript">
	$(document).ready(function(){
		var areaIds = '<s:property value="areaIds"/>';
		var pids = areaIds.split(",");
		for(i=0;i<pids.length;i++)
		{
			$("#area_"+pids[i]).attr("checked",true);
		}
		
		});
</script>
