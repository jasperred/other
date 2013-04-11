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
	
	<script type="text/javascript"
		src="application/invoiceByRicoh/lib/invoice_search.js"></script>
	<s:action name="companyListByShopAction" id="companyListByShopAction"></s:action>
	<body>
		<input type="hidden" name="currentPage" value="1" />
		<div id="search-box">
			<span class="rc-tp"><span></span> </span>
			<table width=100% class="hd" >
				<tr><td align="left">费用结算</td><td align="right">[展开/隐藏]</td></tr>
			</table>
			<form id="preview-invoice-form" action="previewInvoiceInfoByRcnAction.action">
				<table width=100% id="order-search">

					<tr>
						<s:push value="companyListByShopAction">
						<td class="sdingle-col">
							<input type="text" class="pure-text" value="特约维修店(↓)" readonly="readonly"/>
							<select name="companyId" id="company-id">
									<option value="">
									</option>
									<s:iterator value="companyList">
									<option value="<s:property value="id"/>"><s:property value="CompanyName"/>
									</option>
									</s:iterator>
								</select>
						</td>
						</s:push>
						<td class="sdingle-col">
							<input type="text" class="pure-text" value="结算期间" readonly="readonly"/>
							<input type="text" name="fromDate" id="from-date" onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'end-date\')}',dateFmt:'yyyy-MM-dd'})" class="Wdate"/>
							-<input type="text" name="endDate" id="end-date" onfocus="WdatePicker({minDate:'#F{$dp.$D(\'from-date\')}',dateFmt:'yyyy-MM-dd'})" class="Wdate"/>
						</td>
					</tr>
					<tr><td></td><td align="right"><input type="button" id="invoice-settlement" value="结算预览" /><input type="reset" value="清空" /></td></tr>

				</table>
			</form>

		</div>
		<table id="invoice-preview-result" binvoice="0" cellpadding="1"
				cellspacing="1" class="listing" width="100%" bgcolor="#CCCCCC">

				<thead>
					<tr>
						<th></th>
						<th>
							特约维修店
						</th>
						<th>
							费用合计
						</th>
						<th>
							操作
						</th>
					</tr>
				</thead>
				<tbody>
				</tbody>
			</table>
			<table cellspacing="0" cellpadding="0" binvoice="0" width="100%"
				style="binvoice: 0px none;" id="invoice-preview-page">
				<tbody>

				</tbody>
			</table>
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
		$("#invoice-settlement").bind('click', function() {
						if($.trim($("#from-date").val()).length==0)
						{
							alert("请选择结算期间");
							return;
						}
						if($.trim($("#end-date").val()).length==0)
						{
							alert("请选择结算期间");
							return;
						}
						previewInvoiceList(1);
					});
		$("#company-id").combobox();
		
	});
</script>
</html>