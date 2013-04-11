<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<%@ taglib prefix="s" uri="/struts-tags"%>
	<%@ include file="../common/top.jsp"%>
	<link type="text/css" href="css/ui/jquery.ui.all.css" rel="stylesheet" />
	<script type="text/javascript" src="application/inventoryByRicoh/lib/inventory_search.js"></script>
	
	<body>
		<input type="hidden" name="currentPage" value="1" />
		<div id="search-box">
			<span class="rc-tp"><span></span> </span>
			<table width=100% class="hd" >
				<tr><td align="left">借用品查询</td><td align="right">[展开/隐藏]</td></tr>
			</table>
			<form action="">
				<table width=100% id="inventory-search">

					<tr>
						
						<td class="sdingle-col">
							<input type="text" class="pure-text" value="特约维修店名" readonly="readonly"/>
							<input type="text" name="" id="shop-name" />
						</td>
						
					</tr>
					<tr>
						<td class="sdingle-col">
							<input type="text" class="pure-text" value="机器/零件编号" readonly="readonly"/>
							<input type="text" name="" id="sku-cd" />
						</td>
						<td class="sdingle-col">
							<input type="text" class="pure-text" value="机器/零件名称" readonly="readonly"/>
							<input type="text" name="" id="sku-name" />
						</td>
							
					</tr>
					

					<tr align="right">
						<td></td>
						<td class="search-button">
							<input type="button" value="检索" id="inventory-search-button" />
							<input type="reset" value="清空" />
						</td>
					</tr>
				</table>
			</form>
		</div>
		<br>
			<table id="inventory-search-result" binventory="0" cellpadding="1"
				cellspacing="1" class="listing" width="100%" bgcolor="#CCCCCC">

				<thead>
					<tr>
						<th></th>
						<th>特约维修店</th>
						<th>
							机器/零件编号
						</th>
						<th>
							机器/零件名称
						</th>
						<th>
							机器/零件数量
						</th>

						<th>
							类型
						</th>
						
					</tr>
				</thead>
				<tbody>
				</tbody>
			</table>
			<table cellspacing="0" cellpadding="0" binventory="0" width="100%"
				style="binventory: 0px none;" id="inventory-search-page">
				<tbody>

				</tbody>
			</table>
			<%@ include file="../../framework/system/bottom.jsp"%>
	</body>
	<script type="text/javascript">
	$(document).ready(function() {
		//$("#inventory-search").hide();
		$('.hd').bind('click', function() {
			hideAndShow('inventory-search');
		});
		
		$("#inventory-search-button").bind('click', function() {
			searchInventoryByRcn(1);
		});		
	});
</script>
</html>