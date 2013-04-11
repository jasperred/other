<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<%@ taglib prefix="s" uri="/struts-tags"%>
	<%@ include file="../common/top.jsp"%>
	<script type="text/javascript"
		src="application/invoiceByRicoh/lib/invoice_info.js"></script>
	<body>
		<div id="search-box">
			<span class="rc-tp"><span></span> </span>
			<table width=100% class="hd" id="invoice-info-banner">
				<tr><td align="left">费用结算</td><td align="right">[展开/隐藏]</td></tr>
			</table>
			<form id="generate-invoice-form" action="generateInvoiceInfoByRcnAction.action">
			<table width=100% id="invoice-info" rules="none" border="1">
				<tr>
					<td >
						<input type="text" class="pure-text" value="费用结算编号"
							readonly="readonly" />
							<input type="hidden" id="invoice-id" />
						<input type="text" id="invoice-cd" name="invoiceCd" disabled="disabled"/>
					</td>
					<td >
						<input type="text" class="pure-text" value="支付对象"
							readonly="readonly" />
							<input type="hidden" id="company-id" name="companyId"/>
						<input type="text" id="company-name"  disabled="disabled"/>
					</td>
					
					<td  colspan="3">
						<input type="text" class="pure-text" value="结算费用合计"
							readonly="readonly" />
						<input type="text" id="total-amt"  disabled="disabled"/>
					</td>
				</tr>
				<tr>
					<td >
						<input type="text" class="pure-text" value="支付维修费小计"
							readonly="readonly" />
						<input type="text" id="service-amt"  disabled="disabled"/>
					</td>
					<td >
						<input type="text" class="pure-text" value="支付上门费小计"
							readonly="readonly" />
						<input type="text" id="home-amt"  disabled="disabled"/>
					</td>
					<td >
						<input type="text" class="pure-text" value="支付其他费小计"
							readonly="readonly" />
						<input type="text" id="other-amt"  disabled="disabled"/>
					</td>
				</tr>
				<tr>
					<td colspan="3">
						<input type="text" class="pure-text" value="结算期间"
							readonly="readonly" />
						<input type="text" id="from-date" name="fromDate" disabled="disabled"/>
						-<input type="text" id="end-date" name="endDate" disabled="disabled"/>
					</td>
				</tr>
				<tr>
					<td >
						<input type="text" class="pure-text" value="发票开出日期"
							readonly="readonly" />
						<input type="text" id="invoice-date" name="invoiceDate" disabled="disabled"/>
					</td>
					<td >
						<input type="text" class="pure-text" value="发票接受日期"
							readonly="readonly" />
						<input type="text" id="invoice-receive-date"  disabled="disabled"/>
					</td>
					<td >
						<input type="text" class="pure-text" value="RCN付款日期"
							readonly="readonly" />
						<input type="text" id="payment-date"  disabled="disabled"/>
					</td>
				</tr>
				<tr>
					<td >
						<input type="text" class="pure-text" value="结算通知发出日期"
							readonly="readonly" />
						<input type="text" id="invoice-notice-date" disabled="disabled"/>
					</td>
					<td >
						<input type="text" class="pure-text" value="结算通知发出人"
							readonly="readonly" />
						<input type="text" id="invoice-notice-person" disabled="disabled" />
					</td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td align="right">
						<input type="button" id="back-button" value="返回" />
					</td>
				</tr>
			</table>
			
			</form>
			
			<table width=100% class="hd" id="invoice-item-banner">
				<tr><td align="left">本次支付维修单流水号清单</td><td align="right">[展开/隐藏]</td></tr>
			</table>
			<table width=100% id="invoice-item" border="0" cellpadding="1"
				cellspacing="1" class="listing" width="100%" bgcolor="#CCCCCC">
				<thead>
					<tr>
						<th></th>
						<th>
							维修单流水号
						</th>
						<th>
							机号
						</th>
						<th>
							维修费
						</th>
						<th>
							上门费
						</th>
						<th>
							其它费用
						</th>
					</tr>
				</thead>
				<tbody>
				
				<s:iterator value="invoiceItemList" status="li">
				<tr>
					<td><s:property value="#li.index+1"/></td>
					<td><s:property value="ServiceNo"/></td>
					<td><s:property value="MachineNo"/></td>
					<td><s:property value="ServiceAmt"/></td>
					<td><s:property value="HomeAmt"/></td>
					<td><s:property value="OtherAmt"/></td>
				</tr>
				</s:iterator>
				</tbody>
			</table>

		</div>
<%@ include file="../../framework/system/bottom.jsp"%>
	</body>
	<script type="text/javascript">
	$(document).ready(
		function() {
			initByShop();
			var invoiceInfoMap = new Map();
			invoiceInfoMap.put('invoiceId',unicodeToString('<s:property value="invoiceId"/>'));
			invoiceInfoMap.put('invoiceCd',unicodeToString('<s:property value="invoiceCd"/>'));
			invoiceInfoMap.put('invoiceDate',unicodeToString('<s:property value="invoiceDate"/>'));
			invoiceInfoMap.put('invoiceNoticeDate',unicodeToString('<s:property value="invoiceNoticeDate"/>'));
			invoiceInfoMap.put('invoiceNoticePerson',unicodeToString('<s:property value="invoiceNoticePerson"/>'));
			invoiceInfoMap.put('invoiceReceiveDate',unicodeToString('<s:property value="invoiceReceiveDate"/>'));
			invoiceInfoMap.put('invoiceStatus',unicodeToString('<s:property value="invoiceStatus"/>'));
			invoiceInfoMap.put('invoiceUrl',unicodeToString('<s:property value="invoiceUrl"/>'));
			invoiceInfoMap.put('companyId',unicodeToString('<s:property value="companyId"/>'));
			invoiceInfoMap.put('companyName',unicodeToString('<s:property value="companyName"/>'));
			invoiceInfoMap.put('fromDate',unicodeToString('<s:property value="fromDate"/>'));
			invoiceInfoMap.put('endDate',unicodeToString('<s:property value="endDate"/>'));
			invoiceInfoMap.put('homeAmt',unicodeToString('<s:property value="homeAmt"/>'));
			invoiceInfoMap.put('otherAmt',unicodeToString('<s:property value="otherAmt"/>'));
			invoiceInfoMap.put('serviceAmt',unicodeToString('<s:property value="serviceAmt"/>'));
			invoiceInfoMap.put('paymentDate',unicodeToString('<s:property value="paymentDate"/>'));
			invoiceInfoMap.put('totalAmt',unicodeToString('<s:property value="totalAmt"/>'));
			setInvoiceInfo(invoiceInfoMap);
	});
</script>
</html>