<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<%@ taglib prefix="s" uri="/struts-tags"%>
	<%@ include file="../common/top.jsp"%>
	<script type="text/javascript" src="application/applyByRicoh/lib/apply_search.js"></script>
	<s:action name="machineTypeListAction" id="machineTypeListAction"></s:action>
	<s:action name="serviceStatusListAction" id="serviceStatusListAction"></s:action>
	<body>
		<input type="hidden" name="currentPage" value="1" />
		<div id="search-box">
			<span class="rc-tp"><span></span> </span>
			<table width=100% class="hd" >
				<tr><td align="left">维修申请检索</td><td align="right">[展开/隐藏]</td></tr>
			</table>
			<form action="">
				<table width=100% id="apply-search">

					<tr>
						<td class="">
							<input type="text" class="pure-text" value="维修单流水号" readonly="readonly"/>
							<input type="text" name="" id="service-no" />
						</td>
					
						<td class="">
							<input type="text" class="pure-text" value="申请状态" readonly="readonly"/>
							<select id="apply-status" >
								<option value=""></option>
								<option value="IN_APPLY">待审核</option>
								<option value="RE_APPLY">不通过</option>
								<option value="WAIT_DELIVERY">通过待发货</option>
								<option value="USE_INV">用库存</option>
								<option value="ADD_INV">补库存</option>
								<option value="DELIVERY">已发货</option>
								<option value="NO_INVOICE">通过未结</option>
								<option value="INVOICE">通知结算</option>
								<option value="INVOICE_COMPLETE">结算完成</option>
							</select>
						</td>
					
						<td class="">
							<input type="text" class="pure-text" value="申请类型" readonly="readonly"/>
							<select id="apply-type" >
								<option value=""></option>
								<option value="PART">零件申请</option>
								<option value="MACHINE">主机申请</option>
								<option value="RATE">费用申请</option>
							</select>
						</td>
					</tr>
					<tr align="right">
						<td></td>
						<td></td>
						<td class="search-button">
							<input type="button" value="检索" id="apply-search-button" />
							<input type="reset" value="清空" />
						</td>
					</tr>
				</table>
			</form>
		</div>
		<br>
			<table id="apply-search-result" border="0" cellpadding="1"
				cellspacing="1" class="listing" width="100%" bgcolor="#CCCCCC">

				<thead>
					<tr>
						<th></th>
						<th>
							申请ID
						</th>
						<th>
							维修单流水号
						</th>
						<th>
							特约维修店
						</th>
						<th>
							申请类型
						</th>
						<th>
							申请状态
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
				style="border: 0px none;" id="apply-search-page">
				<tbody>

				</tbody>
			</table><%@ include file="../../framework/system/bottom.jsp"%>
	</body>
	<script type="text/javascript">
	
	$(document)
			.ready(function() {
				//$("#order-search").hide();
				$('.hd').bind('click', function() {
					hideAndShow('apply-search');
				});

					$("#apply-search-button").bind('click', function() {
						searchApplyServiceByShop(1);
					});
					
				});
</script>
</html>