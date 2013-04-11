
<%@ taglib prefix="s" uri="/struts-tags"%>
<div>
	<ul id="message" style="color: red"></ul>
</div>
<table id="machine-info" style="display: none">
	<tr>
		<td class="sdingle-col">
			<input type="hidden" id="machine-flag" value="<s:property value="machineFlag"/>"/>
			<input type="text" class="pure-text" value="机号" readonly="readonly" />
			<input type="text" readonly="readonly"  disabled="disabled" id="machine-no" value="<s:property value="machineNo"/>"/>
		</td>
		<td class="sdingle-col">
			<input type="text" class="pure-text" value="机型" readonly="readonly" />
			<input type="text" readonly="readonly"  disabled="disabled" id="" value="<s:property value="machineTypeName"/>"/>
		</td>
	</tr>
	<tr>
		<td class="sdingle-col">
			<input type="text" class="pure-text" value="商品编号" readonly="readonly" />
			<input type="text" readonly="readonly"  disabled="disabled" id="" value="<s:property value="machineCd"/>" />
		</td>

		<td class="sdingle-col">
			<input type="text" class="pure-text" value="PPS号" readonly="readonly" />
			<input type="text" readonly="readonly"  disabled="disabled" id="" value="<s:property value="ppsNo"/>" />
		</td>
	</tr>
	<tr>
		<td class="sdingle-col">
			<input type="text" class="pure-text" value="服务费支付公司"
				readonly="readonly" />
			<input type="text" readonly="readonly"  disabled="disabled" id="" value="<s:property value="paymentCompany"/>" />
		</td>
		<td class="sdingle-col">
			<input type="text" class="pure-text" value="服务费支付公司代码"
				readonly="readonly" />
			<input type="text" readonly="readonly"  disabled="disabled" id="" value="<s:property value="paymentCompanyCd"/>" />
		</td>
	</tr>
	<tr>
		<td class="sdingle-col">
			<input type="text" class="pure-text" value="保修期起始日"
				readonly="readonly" />
			<input type="text"  readonly="readonly"  disabled="disabled" id="" value="<s:property value="serviceFromDate"/>" />
		</td>
		<td class="sdingle-col">
			<input type="text" class="pure-text" value="保修期结束日"
				readonly="readonly" />
			<input type="text" readonly="readonly"  disabled="disabled" id="" value="<s:property value="serviceEndDate"/>" />
		</td>
	</tr>
	<tr>
		<td class="sdingle-col">
			<input type="text" class="pure-text" value="发票日期" readonly="readonly" />
			<input type="text" readonly="readonly"  disabled="disabled" id="" value="<s:property value="invoiceDate"/>" />
		</td>

		<td class="sdingle-col">
			<input type="text" class="pure-text" value="出库日期" readonly="readonly" />
			<input type="text" readonly="readonly"  disabled="disabled" id="" value="<s:property value="outDate"/>" />
		</td>
	</tr>
	<tr>
		<td></td>
		<td align="right">
			<input id="create-order" type="button" value="受理此机器" />
		</td>
	</tr>
</table>
<script type="text/javascript">
	$(document).ready(function() {
		$("#create-order").bind('click', function() {
			toOrder();
		});
		$("#message").html('');
		var machineFlag = '<s:property value="machineFlag"/>';
		var message = '<s:property value="message"/>';
		if(machineFlag=='E')
			{
				$("#machine-info").hide();
				$("#message").html('<li>'+message+'</li>');
			}
		else
			{
				if(machineFlag=='C'||machineFlag=='SC')
					$("#message").html('<li>'+message+'</li>');
			$("#machine-info").show();
			}
	});
	function toOrder()
	{
		//保修期外提示是否受理
		var machineFlag = $("#machine-flag").val();
		if(machineFlag=='E')
			return;
		if(machineFlag=='C')
		{
			var b = confirm("此机器在保修期外,是否要受理?");
			if(!b)
				return;
		}
		else
		{
			var b = confirm("是否确定受理此机器?");
			if(!b)
				return;
		}
		var machineNo = $.trim($("#machine-no").val());
		location.href="newServiceOrderAction.action?machineNo="+machineNo+"&crumb="+$("#crumb").val();
	}
</script>