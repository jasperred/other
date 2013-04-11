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
	<script type="text/javascript" src="application/company/lib/company_machine_type_search.js"></script>
	
	<s:action name="machineTypeListAction" id="machineTypeListAction"></s:action>
	<body>
		<input type="hidden" name="currentPage" value="1" />
		<div id="search-box">
			<span class="rc-tp"><span></span> </span>
			<table width=100% class="hd" >
				<tr><td align="left">维修能力查询</td><td align="right">[展开/隐藏]</td></tr>
			</table>
			<form action="">
				<table width=100% id="company-machine-type-search">

					<tr>
						<td class="sdingle-col">
							<input type="text" class="pure-text" value="维修机型:" readonly="readonly"/>
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
							<input type="text" class="pure-text" value="商品编号:" readonly="readonly"/>
							<input type="text" name="" id="machine-cd" />
						</td>
					</tr>
					<tr>
						<td class="sdingle-col">
							<input type="text" class="pure-text" value="维修店ID:" readonly="readonly"/>
							<input type="text" name="" id="company-id" />
						</td>
						<td class="sdingle-col">
							<input type="text" class="pure-text" value="维修店名称:" readonly="readonly"/>
							<input type="text" name="" id="company-name" />							
						</td>
							
					</tr>
					

					<tr align="right">
						<td></td>
						<td class="search-button">
							<input type="button" value="检索" id="company-machine-type-search-button" />
							<input type="reset" value="清空" />
						</td>
					</tr>
				</table>
			</form>
		</div>
		<br>
			<table id="company-machine-type-search-result" bcompany="0" cellpadding="1"
				cellspacing="1" class="listing" width="100%" bgcolor="#CCCCCC">

				<thead>
					<tr>
						<th></th>						
						<th>
							公司ID
						</th>
						<th>
							公司名称
						</th>
						<th>
							能维修机型商品编号
						</th>

						<th>
							能维修机型
						</th>
						<th>
							记录创建者
						</th>
						<th>
							记录创建时间
						</th>
						<th>
							操作
						</th>
					</tr>
				</thead>
				<tbody>
				</tbody>
			</table>
			<table cellspacing="0" cellpadding="0" bcompany="0" width="100%"
				style="bcompany: 0px none;" id="company-machine-type-search-page">
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
		//$("#company-machine-type-search").hide();
		$('.hd').bind('click', function() {
			hideAndShow('company-machine-type-search');
		});
		
		$("#company-machine-type-search-button").bind('click', function() {
			searchCompanyMachineType(1);
		});	
		searchCompanyMachineType(1);
		$("#machine-type-id").combobox();
	});
</script>
</html>