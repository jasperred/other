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
	<script type="text/javascript" src="application/orderByRicoh/lib/order_search.js"></script>
	<s:action name="machineTypeListAction" id="machineTypeListAction"></s:action>
	<s:action name="serviceStatusListAction" id="serviceStatusListAction"></s:action>
	<body>
		<input type="hidden" name="currentPage" value="1" />
		<div id="search-box">
			<span class="rc-tp"><span></span> </span>
			<table width=100% class="hd" >
				<tr><td align="left">维修检索</td><td align="right">[展开/隐藏]</td></tr>
			</table>
			<form action="">
				<table width=100% id="order-search">

					<tr>
						<td class="sdingle-col">
							<input type="text" class="pure-text" value="特约维修店名"
								readonly="readonly" />
							:
							<input type="text" name="" id="shop-name" />
						</td>
						<td class="double-cols">
							<input type="text" class="pure-text" value="维修人姓名"
								readonly="readonly" />
							:
							<input type="text" name="" id="fix-people" />
						</td>

						<td class="double-cols">
							<input type="text" class="pure-text" value="维修单流水号"
								readonly="readonly" />
							:
							<input type="text" name="" id="service-no" />
						</td>
					</tr>
					<tr>
						<td class="sdingle-col">
							<input type="text" class="pure-text" value="机号"
								readonly="readonly" />
							:
							<input type="text" name="" id="machine-no" />
						</td>
						<td class="double-cols">
							<input type="text" class="pure-text" value="机型"
								readonly="readonly" />
							:
							<s:push value="machineTypeListAction">
								<select name="" id="machine-type-id">
									<option value=""></option>
									<s:iterator value="machineTypeList">
										<option value='<s:property value="id"/>'><s:property value="MachineType" /></option>
									</s:iterator>
								</select>
							</s:push>
						</td>

						<td class="double-cols">
							<input type="text" class="pure-text" value="保修期"
								readonly="readonly" />
							:
							<select name="" id="service-date-status">
								<option value="">
								</option>
								<option value="保修期内">
									保修期内
								</option>
								<option value="保修期外">
									保修期外
								</option>
								<option value="维护合同期">
									维护合同期
								</option>
							</select>
						</td>
					</tr>
					<tr>
						<td class="sdingle-col">
							<input type="text" class="pure-text" value="服务形式"
								readonly="readonly" />
							:
							<select name="ShopCode" id="service-method">
								<option value="">
								</option>
								<option value="送修">
									送修
								</option>
								<option value="寄修">
									寄修
								</option>
								<option value="现场">
									现场
								</option>
							</select>
						</td>
						<td class="double-cols">
							<input type="text" class="pure-text" value="维修合同形态"
								readonly="readonly" />
							:
							<select name="ShopCode" id="service-contract">
								<option value="">
								</option>
								<option value="随时">
									随时
								</option>
								<option value="维修合同">
									维修合同
								</option>
								<option value="MC">
									MC
								</option>
							</select>
						</td>

						<td class="double-cols">
							<input type="text" class="pure-text" value="维修作业项目"
								readonly="readonly" />
							:
							<select name="ShopCode" id="service-operation">
								<option value=""></option>
								<option value="定期检查">
									定期检查
								</option>
								<option value="修理">
									修理
								</option>
								<option value="定期修理">
									定期修理
								</option>
								<option value="继续作业">
									继续作业
								</option>
								<option value="更换零件">
									更换零件
								</option>
								<option value="送货">
									送货
								</option>
								<option value="说明">
									说明
								</option>
								<option value="合同签约">
									合同签约
								</option>
								<option value="安装机器">
									安装机器
								</option>
								<option value="搬回修理">
									搬回修理
								</option>
							</select>
						</td>
					</tr>
					<tr>

						<td class="sdingle-col">
							<input type="text" class="pure-text" value="送修人"
								readonly="readonly" />
							:
							<input type="text" name="" id="customer-name" />
						</td>
						<td class="double-cols">
							<input type="text" class="pure-text" value="已过时日"
								readonly="readonly" />
							:
							<input type="text" name="" id="thru-time" />
						</td>
						<td class="double-cols">
							<input type="text" class="pure-text" value="维修措施代码"
								readonly="readonly" />
							:
							<input type="text" name="" id="action-no" />
						</td>
					</tr>
					<tr>
						<td class="double-cols">
							<input type="text" class="pure-text" value="故障现象代码"
								readonly="readonly" />
							:
							<input type="text" name="" id="symptom-no" />
						</td>
						<td class="sdingle-col">
							<input type="text" class="pure-text" value="故障原因代码"
								readonly="readonly" />
							:
							<input type="text" name="" id="cause-no" />
						</td>
						<td class="sdingle-col">
							<input type="text" class="pure-text" value="故障部位代码"
								readonly="readonly" />
							:
							<input type="text" name="" id="location-no" />
						</td>
					</tr>
					<tr>
						<td class="double-cols">
							<input type="text" class="pure-text" value="维修单状态"
								readonly="readonly" />
							:
							<s:push value="serviceStatusListAction">
								<select name="" id="service-status">
									<option value=""></option>
									<s:iterator value="serviceStatusList">
										<option value="<s:property value="UnitNo"/>">
											<s:property value="UnitName" />
										</option>
									</s:iterator>
								</select>
							</s:push>
						</td>
						<td class="double-cols" colspan="2">
							<input type="text" class="pure-text" value="更换零件/选购件/耗材编号"
								style="width: 170px;" readonly="readonly" />
							:
							<input type="text" name="" id="item-no" />
						</td>
					</tr>
					<tr>
						<td class="double-cols" colspan="3">
							<input type="text" class="pure-text" value="维修受理日时间"
								readonly="readonly" />
							:
							<input type="text" name="" id="from-service-date" onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'end-service-date\')}'})" class="Wdate" />
							-<input type="text" name="" id="end-service-date" onfocus="WdatePicker({minDate:'#F{$dp.$D(\'from-service-date\')}'})" class="Wdate" />
						</td>
					</tr>
					<tr>
						<td class="double-cols" colspan="3">
							<input type="text" class="pure-text" value="修理完成日期时间"
								readonly="readonly" />
							:
							<input type="text" name="" id="from-service-finish-date"  onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'end-service-finish-date\')}'})" class="Wdate"/>
							-<input type="text" name="" id="end-service-finish-date"  onfocus="WdatePicker({minDate:'#F{$dp.$D(\'from-service-finish-date\')}'})" class="Wdate" />
						</td>
					</tr>
					<tr>
						<td class="sdingle-col" colspan="3">
							<input type="text" class="pure-text" value="用户取回机器日期"
								readonly="readonly" />
							:
							<input type="text" name="" id="from-customer-retrieve-date"  onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'end-customer-retrieve-date\')}'})" class="Wdate" />
							-<input type="text" name="" id="end-customer-retrieve-date"  onfocus="WdatePicker({minDate:'#F{$dp.$D(\'from-customer-retrieve-date\')}'})" class="Wdate" />
						</td>
					</tr>


					<tr align="right">
						<td></td>
						<td></td>
						<td class="search-button">
							<input type="button" value="检索" id="order-search-button" />
							<input type="reset" value="清空" />
						</td>
					</tr>
				</table>
			</form>
		</div>
		<br>
			<table id="order-search-result" border="0" cellpadding="1"
				cellspacing="1" class="listing" width="100%" bgcolor="#CCCCCC">

				<thead>
					<tr>
						<th></th>
						<th>
							维修单流水号
						</th>
						<th>特约维修店</th>
						<th>
							机型
						</th>
						<th>
							机号
						</th>
						<th>
							维修受理日
						</th>
						<th>
							维修单状态
						</th>
						<th>
							操作
						</th>

					</tr>
				</thead>
				<tbody>
				</tbody>
			</table>
			<table cellspacing="0" cellpadding="0" border="0" width="100%"
				style="border: 0px none;" id="order-search-page">
				<tbody>

				</tbody>
			</table><%@ include file="../../framework/system/bottom.jsp"%>
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
$(document)
		.ready(
				function() {
					//$("#order-search").hide();
					$('.hd').bind('click', function() {
						hideAndShow('order-search');
					});
					$("#order-search-button").bind('click', function() {
						searchOrderByRcn(1);
					});
					
					$("#machine-type-id").combobox();
				});
</script>
</html>