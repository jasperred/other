<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<%@ taglib prefix="s" uri="/struts-tags"%>
	<%@ include file="../common/top.jsp"%>
	<link type="text/css" href="css/ui/jquery.ui.all.css" rel="stylesheet" />
	<script type="text/javascript" src="js/jquery/ui/jquery.ui.core.js"></script>
	<script type="text/javascript" src="js/jquery/ui/jquery.ui.widget.js"></script>
	<script type="text/javascript"
		src="js/jquery/ui/jquery.ui.datepicker.js"></script>
	<script type="text/javascript"
		src="js/jquery/ui/i18n/jquery.ui.datepicker-zh-CN.js"></script>
	<script type="text/javascript"
		src="application/order/lib/order_search.js"></script>

	<body>
		<input type="hidden" name="currentPage" value="1" />
		<div id="search-box">
			<span class="rc-tp"><span></span> </span>
			<table width=100% class="hd" >
				<tr><td align="left">维修单审核</td><td align="right">[展开/隐藏]</td></tr>
			</table>
			<form action="">
				<table width=100% id="order-search">
					<tr>
						<td class="double-cols">
							<input type="text" class="pure-text" value="特约店:" readonly="readonly"/>
							<select name="ShopCode" id="shop-code">
									<option value="">
									</option>
								</select>
						</td>
						<td class="double-cols">
							<input type="text" class="pure-text" value="状态:" readonly="readonly"/>
							<select name="ShopCode" id="shop-code">
									<option value="">
									</option>
								</select>
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
							维修结果
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
	$(document)
			.ready(function() {
				$("#order-search").hide();
				$('.hd').bind('click', function() {
					hideAndShow('order-search');
				});
				//日期
					$("#order-from-date").val("");
					$("#order-end-date").val("");
					var dates = $('#order-from-date, #order-end-date')
							.datepicker(
									{
										defaultDate : "+0w",
										changeMonth : true,
										numberOfMonths : 3,
										onSelect : function(selectedDate) {
											var option = this.id == "order-from-date" ? "minDate"
													: "maxDate";
											var instance = $(this).data(
													"datepicker");
											var date = $.datepicker
													.parseDate(
															instance.settings.dateFormat
																	|| $.datepicker._defaults.dateFormat,
															selectedDate,
															instance.settings);
											dates.not(this).datepicker(
													"option", option, date);
										}
									});

					$("#order-search-button").bind('click', function() {
						searchOrder(1);
					});
					$("#order-export-button").bind('click', function() {
						showExportOrder();
					});
				});
</script>
</html>