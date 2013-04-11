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
		<input type="hidden" name="currentPage" value="1" />
		<div id="search-box">
			<span class="rc-tp"><span></span> </span>
			<table width=100% class="hd" >
				<tr><td align="left">机号管理</td><td align="right">[展开/隐藏]</td></tr>
			</table>
			<form action="">
				<table width=100% id="machine-search">
					<tr>
						
						<td class="sdingle-col">
							<input type="text" class="pure-text" value="机号" readonly="readonly"/>
							<input type="text" name="" id="machine-no" />
						</td>
						<td class="sdingle-col">
							<input type="text" class="pure-text" value="PPS号" readonly="readonly"/>
							<input type="text" name="" id="pps-no" />
						</td>
						
					</tr>
					<tr>
						<td class="sdingle-col">
							<input type="text" class="pure-text" value="机型" readonly="readonly"/>
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
							<input type="text" class="pure-text" value="商品编号" readonly="readonly"/>
							<input type="text" name="" id="machine-cd" />						
						</td>
							
					</tr>
					<tr>
						<td class="sdingle-col" colspan="2">
							<input type="text" class="pure-text" value="发货对象" readonly="readonly"/>
							<input type="text" name="" id="customer-name" />
						</td>
							
					</tr>
					<tr>
						<td class="sdingle-col" colspan="2">
							<input type="text" class="pure-text" value="出库日期" readonly="readonly"/>
							<input type="text" name="" id="from-outdate" onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'end-outdate\')}',dateFmt:'yyyy-MM-dd'})" class="Wdate"/>
							<input type="text" name="" id="end-outdate" onfocus="WdatePicker({minDate:'#F{$dp.$D(\'from-outdate\')}',dateFmt:'yyyy-MM-dd'})" class="Wdate" />
						</td>
							
					</tr>

					<tr>
						<td align="left">
							<input type="button" value="新建机器" id="machine-new-button" />
						</td>
						<td class="search-button" align="right">
							<input type="button" value="检索" id="machine-search-button" />
							<input type="reset" value="清空" />
						</td>
					</tr>
				</table>
			</form>
		</div>
		<br>
			<table id="machine-search-result" bmachine="0" cellpadding="1"
				cellspacing="1" class="listing" width="100%" bgcolor="#CCCCCC">

				<thead>
					<tr>
						<th></th>						
						<th>
							机号ID
						</th>
						<th>
							发货对象
						</th>
						<th>
							机号
						</th>
						<th>
							PPS号
						</th>

						<th>
							机型
						</th>
						<th>
							商品编号
						</th>
						<th>
							出库日期
						</th>
						<th>
							保修期起始日
						</th>
						<th>
							保修期结束日
						</th>
						<th>
							服务费已支付
						</th>
						<th>
							操作
						</th>
					</tr>
				</thead>
				<tbody>
				</tbody>
			</table>
			<table cellspacing="0" cellpadding="0" bmachine="0" width="100%"
				style="bmachine: 0px none;" id="machine-search-page">
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
				//$( "<button>&nbsp;</button>" )
				//	.attr( "tabIndex", -1 )
				//	.attr( "title", "Show All Items" )
				//	.insertAfter( input )
				//	.button({
				//		icons: {
				//			primary: "ui-icon-triangle-1-s"
				//		},
				//		text: false
				//	})
				//	.removeClass( "ui-corner-all" )
				//	.addClass( "ui-corner-right ui-button-icon" )
				//	.click(function() {
						// close if already visible
				//		if ( input.autocomplete( "widget" ).is( ":visible" ) ) {
				//			input.autocomplete( "close" );
				//			return;
				//		}
						// pass empty string as value to search for, displaying all results
				//		input.autocomplete( "search", "" );
				//		input.focus();
				//	});
			}
		});
	})(jQuery);

	$(document).ready(function() {
		//$("#machine-search").hide();
		$('.hd').bind('click', function() {
			hideAndShow('machine-search');
		});
		
		$("#machine-search-button").bind('click', function() {
			searchMachine(1);
		});		
		searchMachine(1);
		$("#machine-new-button").bind('click', function() {
			location.href="machineInfoAction.action?machineId=";
		});	
		$("#machine-type-id").combobox();
	});
</script>
</html>