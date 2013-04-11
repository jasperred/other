<%@ taglib prefix="s" uri="/struts-tags"%>
<s:if test="provinceList!=null&&provinceList.size()>0">
<table id="area-province" width="100%">
	<tr>
		<s:iterator value="provinceList" status="li">
		<td align="left">
			<span><input type="checkbox" id='province_<s:property value="id"/>' provinceId='<s:property value="id"/>'/></span>
			<label>
				<s:property value="ProvinceName"/>
			</label>
		</td>
		<s:if test="(#li.index+1)%4==0"></tr><tr></s:if>
		</s:iterator>
	</tr>
	
</table>
<script type="text/javascript">
	$(document).ready(function(){
		var provinceIds = '<s:property value="provinceIds"/>';
		var pids = provinceIds.split(",");
		for(i=0;i<pids.length;i++)
		{
			$("#province_"+pids[i]).attr("checked",true);
		}
		
		});
</script>
</s:if>
