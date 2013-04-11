<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<%@ taglib prefix="s" uri="/struts-tags"%>
	<%@ include file="../common/top.jsp"%>
	<script type="text/javascript"
		src="application/deliveryByRicoh/lib/delivery_search.js"></script>

	<body>
		<input type="hidden" name="currentPage" value="1" />
		<div id="search-box">
			<span class="rc-tp"><span></span> </span>
			<table width=100% class="hd" >
				<tr><td align="left">发货管理</td><td align="right">[展开/隐藏]</td></tr>
			</table>
			<form action="">
				<table width=100% id="delivery-search">

					<tr>
						<td class="double-cols">
							<input type="text" class="pure-text" value="特约维修店" readonly="readonly"/>
							<input type="text" name="" id="company-name" />
						</td>
						<td class="double-cols">
							<input type="text" class="pure-text" value="维修单流水号" readonly="readonly"/>
							<input type="text" name="" id="service-no" />
						</td>
						<td class="double-cols">
							<input type="text" class="pure-text" value="状态:"
								readonly="readonly" />
							
							<select name="" id="delivery-status">
								<option value="">
								</option>
								<option value="WAIT_DELIVERY" selected="selected">通过待发货
								</option>
								<option value="AREA_DELIVERY">区域发货
								</option>								
								<option value="ADD_INV">补库存
								</option>
								<option value="NO_DELIVERY">缺货等待
								</option>
								<option value="DELIVERY">已发货
								</option>
							</select>
						</td>
					</tr>
					<tr align="right">
						<td></td>
						<td></td>
						<td class="search-button">
							<input type="button" value="检索" id="delivery-search-button" />
							<input type="reset" value="清空" />
						</td>
					</tr>
				</table>
			</form>
		</div>
		<br>
			<table id="delivery-search-result" border="0" cellpadding="1"
				cellspacing="1" class="listing" width="100%" bgcolor="#CCCCCC">

				<thead>
					<tr>
						<th></th>
						<th>
							发货ID
						</th>
						<th>
							维修单流水号
						</th>
						<th>
							特约维修店
						</th>
						<th>
							物流发货发单号
						</th>
						<th>
							发货状态
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
				style="border: 0px none;" id="delivery-search-page">
				<tbody>

				</tbody>
			</table><%@ include file="../../framework/system/bottom.jsp"%>
	</body>
	<script type="text/javascript">
	$(document)
			.ready(function() {
				$('.hd').bind('click', function() {
					hideAndShow('delivery-search');
				});
					$("#delivery-search-button").bind('click', function() {
						searchDeliveryByCspc(1);
					});
				});
</script>
</html>