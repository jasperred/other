<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<%@ taglib prefix="s" uri="/struts-tags"%>
	<%@ include file="../common/top.jsp"%>
	<script language="javascript" type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript"
		src="application/invoiceByRicoh/lib/invoice_search.js"></script>

	<body>
		<input type="hidden" name="currentPage" value="1" />
		<div id="search-box">
			<span class="rc-tp"><span></span> </span>
			<table width=100% class="hd" >
				<tr><td align="left">费用查询</td><td align="right">[展开/隐藏]</td></tr>
			</table>
			<form action="">
				<table width=100% id="invoice-search">

					<tr>
						<td colspan="2">
							<input type="text" class="pure-text" value="费用结算编号" readonly="readonly"/>
							<input type="text"  id="invoice-cd" />
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="text" class="pure-text" value="结算日期" readonly="readonly"/>
							<input type="text"  id="invoice-notice-from-date" onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'invoice-notice-end-date\')}',dateFmt:'yyyy-MM-dd'})" class="Wdate" />
							-<input type="text"  id="invoice-notice-end-date" onfocus="WdatePicker({minDate:'#F{$dp.$D(\'invoice-notice-from-date\')}',dateFmt:'yyyy-MM-dd'})" class="Wdate" />
							
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="text" class="pure-text" value="发票开出日期" readonly="readonly"/>
							<input type="text"  id="invoice-from-date" onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'invoice-end-date\')}',dateFmt:'yyyy-MM-dd'})" class="Wdate"/>
							-<input type="text"  id="invoice-end-date" onfocus="WdatePicker({minDate:'#F{$dp.$D(\'invoice-from-date\')}',dateFmt:'yyyy-MM-dd'})" class="Wdate"/>
						</td>
					</tr>									

					<tr align="right">
						<td></td>
						<td class="search-button">
							<input type="button" value="检索" id="invoice-search-button" />
							<input type="reset" value="清空" />
						</td>
					</tr>
				</table>
			</form>
		</div>
		<br>
			<table id="invoice-search-result" binvoice="0" cellpadding="1"
				cellspacing="1" class="listing" width="100%" bgcolor="#CCCCCC">

				<thead>
					<tr>
						<th></th>
						<th>
							费用结算编号
						</th>
						<th>
							支付对象
						</th>
						<th>
							支付维修费小计
						</th>
						<th>
							支付上门费小计
						</th>
						<th>
							支付其他费小计
						</th>
						<th>
							结算费用合计
						</th>
						<th>发票开出日期</th>
						<th>结算通知发出日期</th>
						<th>
							操作
						</th>
					</tr>
				</thead>
				<tbody>
				</tbody>
			</table>
			<table cellspacing="0" cellpadding="0" binvoice="0" width="100%"
				style="binvoice: 0px none;" id="invoice-search-page">
				<tbody>

				</tbody>
			</table><%@ include file="../../framework/system/bottom.jsp"%>
	</body>
	<script type="text/javascript">
	$(document)
			.ready(function() {
				//$("#invoice-search").hide();
				$('.hd').bind('click', function() {
					hideAndShow('invoice-search');
				});
				$("#invoice-search-button").bind('click', function() {
						searchInvoiceByShop(1);
					});
				});
</script>
</html>