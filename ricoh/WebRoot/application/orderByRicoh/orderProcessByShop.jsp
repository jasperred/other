<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<%@ taglib prefix="s" uri="/struts-tags"%>
	<%@ include file="../common/top.jsp"%>
	<script type="text/javascript"
		src="application/orderByRicoh/lib/order_search.js"></script>

	<body>
		<input type="hidden" name="currentPage" value="1" />
		<div id="search-box">
			<span class="rc-tp"><span></span> </span>
			<table width=100% class="hd" >
				<tr><td align="left">维修登记</td><td align="right">[展开/隐藏]</td></tr>
			</table>
			<form action="">
				<table width=100% id="order-search">

					<tr>
						<td class="double-cols">
							<input type="text" class="pure-text" value="状态:"
								readonly="readonly" />
							
							<select name="ServiceStatus" id="service-status">
								<option value="REPAIRING">修理中
								</option>
							</select>
						</td>
					</tr>
					<tr align="right">
						<td></td>
						<td></td>
						<td class="search-button">
							<input type="button" value="检索" id="order-search-button" />
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
	$(document)
			.ready(function() {
				//$("#order-search").hide();
				$('.hd').bind('click', function() {
					hideAndShow('order-search');
				});
				searchOrderByStatus(1);
					$("#order-search-button").bind('click', function() {
						searchOrderByStatus(1);
					});
				});
</script>
</html>