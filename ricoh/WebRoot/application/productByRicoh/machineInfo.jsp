<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<%@ taglib prefix="s" uri="/struts-tags"%>
	<%@ include file="../common/top.jsp"%>
	<link type="text/css" href="css/ui/jquery.ui.all.css" rel="stylesheet" />
	<script type="text/javascript" src="js/jquery/ui/jquery.ui.core.js"></script>
	<script type="text/javascript" src="js/jquery/ui/jquery.ui.widget.js"></script>
	<script type="text/javascript" src="js/jquery/ui/jquery.ui.button.js"></script>
	<script type="text/javascript" src="js/jquery/ui/jquery.ui.position.js"></script>
	<script type="text/javascript" src="js/jquery/ui/jquery.ui.autocomplete.js"></script>
	<script language="javascript" type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="application/productByRicoh/lib/machine.js"></script>
	<s:action name="machineTypeListAction" id="machineTypeListAction"></s:action>
	<body>
		<div id="search-box">
			<span class="rc-tp"><span></span> </span>
			<div class="hd" id="machine-info-banner">
				<h3>
					机器信息
				</h3>
			</div>
			<table>
			
				<tr>
					<td class="sdingle-col">
						<input type="text" class="pure-text" value="机号管理ID:"
							readonly="readonly" />
						<input type="text" name="" id="machine-id" readonly="readonly" disabled="disabled"/>
					</td>
					<td class="sdingle-col">
						<input type="text" class="pure-text" value="发货对象:"
							readonly="readonly" />
						<input type="text" name="" id="customer-name" onchange="checkValueLength($(this),255)" />
					</td>
				</tr>
				<tr>
					<td class="sdingle-col">
						<input type="text" class="pure-text" value="机号:"
							readonly="readonly" />
						<input type="text" name="" id="machine-no" onchange="checkValueLength($(this),30)"/>
					</td>
					<td class="sdingle-col">
						<input type="text" class="pure-text" value="PPS号:"
							readonly="readonly" />
						<input type="text" name="" id="pps-no" onchange="checkValueLength($(this),100)" />
					</td>
				</tr>
				<tr>
					<td class="sdingle-col">
						<input type="text" class="pure-text" value="机型(↓):"
							readonly="readonly" />
						<s:push value="machineTypeListAction">
							<select name="" id="machine-type-id">
									<option value="">
									</option>
									<s:iterator value="machineTypeList">
									<option value='<s:property value="id"/>'><s:property value="MachineType"/></option>
									</s:iterator>
							</select>
							</s:push>
					</td>
					<td class="sdingle-col">
						<input type="text" class="pure-text" value="商品编号:"
							readonly="readonly" />
						<input type="text" name="" id="machine-cd" readonly="readonly" onchange="checkValueLength($(this),30)" disabled="disabled"/>
					</td>
				</tr>
				<tr>
					<td class="sdingle-col">
						<input type="text" class="pure-text" value="出库日期:"
							readonly="readonly" />
						<input type="text" name="" id="outdate" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate"/>
					</td>
					<td class="sdingle-col">
						<input type="text" class="pure-text" value="销售日期:"
							readonly="readonly" />
						<input type="text" name="" id="invoice-date" readonly="readonly" disabled="disabled"/>
					</td>
				</tr>
				<tr>
					<td class="sdingle-col">
						<input type="text" class="pure-text" value="保修期起始日:"
							readonly="readonly" />
						<input type="text" name="" id="service-from-date" onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'service-end-date\')}',dateFmt:'yyyy-MM-dd'})" class="Wdate"/>
					</td>
					<td class="sdingle-col">
						<input type="text" class="pure-text" value="保修期结束日:"
							readonly="readonly" />
						<input type="text" name="" id="service-end-date" onfocus="WdatePicker({minDate:'#F{$dp.$D(\'service-from-date\')}',dateFmt:'yyyy-MM-dd'})" class="Wdate"/>
					</td>
				</tr>
				<tr>
					<td class="sdingle-col">
						<input type="text" class="pure-text" value="最近一次维修日:"
							readonly="readonly" />
						<input type="text" name="" id="last-time" readonly="readonly" disabled="disabled"/>
					</td>
					<td class="sdingle-col">
						<input type="text" class="pure-text" value="最近一次维修店:"
							readonly="readonly" />
						<input type="text" name="" id="last-company" readonly="readonly" disabled="disabled"/>
					</td>
				</tr>
				<tr>
					<td class="sdingle-col">
						<input type="text" class="pure-text" value="机器状态:"
							readonly="readonly" />
						<input type="text" name="" id="machine-status" readonly="readonly" disabled="disabled"/>
					</td>
					<td class="sdingle-col">
						<input type="text" class="pure-text" value="服务费已支付:"
							readonly="readonly" />
						<input type="text" name="" id="payment-status" onchange="checkValueLength($(this),30)" />
					</td>
				</tr>
				<tr>
					<td class="sdingle-col">
						<input type="text" class="pure-text" value="服务费支付公司:"
							readonly="readonly" />
						<input type="text" name="" id="payment-company"  onchange="checkValueLength($(this),255)"/>
					</td>
					<td class="sdingle-col">
						<input type="text" class="pure-text" value="服务费支付公司代码:"
							readonly="readonly" />
						<input type="text" name="" id="payment-company-cd" onchange="checkValueLength($(this),30)" />
					</td>
				</tr>
				<tr>
					<td class="sdingle-col">
						<input type="text" class="pure-text" value="服务费支付日期:"
							readonly="readonly" />
						<input type="text" name="" id="payment-date" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate"/>
					</td>
					<td class="sdingle-col">
						<input type="text" class="pure-text" value="服务费支付金额:"
							readonly="readonly" />
						<input type="text" name="" id="payment-amt" onchange="checkPrice($(this));checkValueLength($(this),18)"/>
					</td>
				</tr>
				<tr>
					<td></td>
					<td align="right"><input type="button" value="保存" id="machine-save-button" /><input type="button" value="取消" id="machine-cancel-button" /></td>
				</tr>
			</table>
		</div>
		<div>
			<ul id="message" style="color: red;">
			</ul>
		</div>
		<%@ include file="../../framework/system/bottom.jsp"%>
	</body>
	<script type="text/javascript">
	(function( $ ) {
		$.widget( "ui.combobox", {
			_create: function() {
				var self = this;
				var select = this.element.hide(),
					selected = select.children( ":selected" ),
					value = selected.val() ? selected.text() : "";
				var input = $( "<input>" )
					.insertAfter( select )
					.val( value )
					.autocomplete({
						delay: 0,
						minLength: 0,
						source: function( request, response ) {
							var matcher = new RegExp( $.ui.autocomplete.escapeRegex(request.term), "i" );
							response( select.children( "option" ).map(function() {
								var text = $( this ).text(); 
								if ( this.value && ( !request.term || matcher.test(text) ) )
									return {
										label: text.replace(
											new RegExp(
												"(?![^&;]+;)(?!<[^<>]*)(" +
												$.ui.autocomplete.escapeRegex(request.term) +
												")(?![^<>]*>)(?![^&;]+;)", "gi"
											), "<strong>$1</strong>" ),
										value: text,
										option: this
									};
							}) );
						},
						select: function( event, ui ) {
							ui.item.option.selected = true;
							//select.val( ui.item.option.value );
							self._trigger( "selected", event, {
								item: ui.item.option
							});
						},
						change: function( event, ui ) {
							if ( !ui.item ) {
								var matcher = new RegExp( "^" + $.ui.autocomplete.escapeRegex( $(this).val() ) + "$", "i" ),
									valid = false;
								select.children( "option" ).each(function() {
									if ( this.value.match( matcher ) ) {
										this.selected = valid = true;
										return false;
									}
								});
								if ( !valid ) {
									// remove invalid value, as it didn't match anything
									$( this ).val( "" );
									select.val( "" );
									return false;
								}
							}
						}
					})
					.addClass( "" );
					//.addClass( "ui-widget ui-widget-content ui-corner-left" );

				input.data( "autocomplete" )._renderItem = function( ul, item ) {
					return $( "<li></li>" )
						.data( "item.autocomplete", item )
						.append( "<a>" + item.label + "</a>" )
						.appendTo( ul );
				};
			}
		});
	})(jQuery);

	$(document).ready(function() {

		$("#machine-save-button").bind('click', function() {
			saveMachine();
		});
		$("#machine-cancel-button").bind('click', function() {
			location.href = "viewMachineAction.action";
		});
		
		var machineId = unicodeToString('<s:property value="machineId"/>');
		var machineTypeId = unicodeToString('<s:property value="machineTypeId"/>');
		var machineCd = unicodeToString('<s:property value="machineCd"/>');
		var machineNo = unicodeToString('<s:property value="machineNo"/>');
		var ppsNo = unicodeToString('<s:property value="ppsNo"/>');
		var serviceFromDate = unicodeToString('<s:property value="serviceFromDate"/>');
		var serviceEndDate = unicodeToString('<s:property value="serviceEndDate"/>');
		var outDate = unicodeToString('<s:property value="outDate"/>');
		var invoiceDate = unicodeToString('<s:property value="invoiceDate"/>');
		var paymentStatus = unicodeToString('<s:property value="paymentStatus"/>');
		var paymentCompany = unicodeToString('<s:property value="paymentCompany"/>');
		var paymentCompanyCd = unicodeToString('<s:property value="paymentCompanyCd"/>');
		var paymentDate = unicodeToString('<s:property value="paymentDate"/>');
		var paymentAmt = unicodeToString('<s:property value="paymentAmt"/>');
		var lastTime = unicodeToString('<s:property value="lastTime"/>');
		var lastCompany = unicodeToString('<s:property value="lastCompany"/>');
		var machineStatus = unicodeToString('<s:property value="machineStatusName"/>');
		var origin = unicodeToString('<s:property value="origin"/>');
		var customerNo = unicodeToString('<s:property value="customerNo"/>');
		var customerName = unicodeToString('<s:property value="customerName"/>');
		setMachineInfo(machineId,machineTypeId,machineCd,machineNo,ppsNo,serviceFromDate,serviceEndDate,outDate,invoiceDate,paymentStatus,paymentCompany,paymentCompanyCd,paymentDate,paymentAmt,lastTime,lastCompany,machineStatus,origin,customerName);
		
	});
	</script>
</html>
