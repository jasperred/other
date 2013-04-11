<%@ taglib prefix="s" uri="/struts-tags"%>
<table id="user-shop">
	<tr>
		<s:iterator value="shopList" status="li">
		<td>
			<label>
				<s:property value="ShopName"/>
			</label><span><input type="checkbox" id='usershop_<s:property value="ShopCode"/>' shop-code='<s:property value="ShopCode"/>'/></span>
		</td>
		<s:if test="(#li.index+1)%10==0"></tr><tr></s:if>
		</s:iterator>
	</tr>
	
</table>
<script type="text/javascript">
	$(document).ready(function(){
		var shopCodes = '<s:property value="shopCodes"/>';
		var sids = shopCodes.split(",");
		for(i=0;i<sids.length;i++)
		{
			$("#usershop_"+sids[i]).attr("checked",true);
		}
		
		});
</script>
