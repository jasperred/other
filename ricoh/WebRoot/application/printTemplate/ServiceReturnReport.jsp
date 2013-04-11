<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<%@ taglib prefix="s" uri="/struts-tags"%>
	<%@ include file="../common/top.jsp"%>
	<s:action name="serviceTypeListAction" id="serviceTypeListAction"></s:action>
	<s:action name="symptomListAction" id="symptomListAction"></s:action>
	<s:action name="actionListAction" id="actionListAction"></s:action>
	<s:action name="causeListAction" id="causeListAction"></s:action>
	<s:action name="locationListAction" id="locationListAction"></s:action>
	<s:action name="targetListAction" id="targetListAction"></s:action>
	<body>
		<div id="search-box">
			<span class="rc-tp"><span></span> </span>
			<table width=1000 class="hd" id="order-info-banner">
				<tr>
					<td align="left">
						退/换 机 申 请 书打印信息填写
					</td>
				</tr>
			</table>
			<table width=1100 id="order-info" rules="none" border="1">
				<tr>
					<td class="">
						<input type="text" class="pure-text" value="PPS号"
							readonly="readonly" />
						<input type="text" name="PpsNo" style="width:300px;" disabled="disabled"/>
					</td>
					<td class="" colspan="2">
						<input type="text" class="pure-text" value="发行No"
							readonly="readonly" />
						<input type="text" name="Field1"/>
					</td>
				</tr>
				<tr>
					<td class="" colspan="6">
						<input type="text" class="pure-text" value="部　门"
							readonly="readonly" />
						○华北&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;○华东&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;○华南&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;○华西
					</td>
				</tr>
				<tr>
					<td class="">
						<input type="text" class="pure-text" value="申请公司"
							readonly="readonly" />
						<input type="text" name="CustomerName" style="width:200px;" disabled="disabled"/>
					</td>
					<td class="" colspan="5">
						<input type="text" class="pure-text" value="公司地址"
							readonly="readonly" />
						<input type="text" name="CompanyAddress" style="width:250px;" disabled="disabled"/>
					</td>
				</tr>
				<tr>
					<td class="">
						<input type="text" class="pure-text" value="联系人"
							readonly="readonly" />
						<input type="text" name="Field38"/>
					</td>
					<td class="" colspan="4">
						<input type="text" class="pure-text" value="联系电话"
							readonly="readonly" />
						<input type="text" name="CompanyTel" disabled="disabled"/>
						<input type="text" class="pure-text" value="传真"
							readonly="readonly" />
						<input type="text" name="Field2"/>
					</td>
				</tr>
				<tr>
					<td class="">
						<input type="text" class="pure-text" value="最终客户名称"
							readonly="readonly" />
						<input type="text" name="CustomerCompany" disabled="disabled"/>
					</td>
					<td class="">
						<input type="text" class="pure-text" value="销售店名称（服务实施店）"
							readonly="readonly" />
						<input type="text" name="Field3"/>
					</td>
				</tr>
				<tr>
					<td class="">
						<input type="text" class="pure-text" value="开始使用日"
							readonly="readonly" />
						<input type="text" name="InvoiceDate" disabled="disabled"/>
					</td>
					<td class="" colspan="4">
						<input type="text" class="pure-text" value="支社申报日"
							readonly="readonly" />
						<input type="text" name="Field4" style="width: 100px;" onchange="checkQty($(this));checkValueLength($(this),4)"/>
						年
						<input type="text" name="Field5" style="width: 50px;" onchange="checkQty($(this));checkValueLength($(this),2)"/>
						月
						<input type="text" name="Field6" style="width: 50px;" onchange="checkQty($(this));checkValueLength($(this),2)"/>
						日
					</td>

				</tr>
				<tr>
					<td class="">
						<input type="text" class="pure-text" value="经销商申请日"
							readonly="readonly" />
						<input type="text" name="ApplyDate" disabled="disabled"/>
					</td>
					<td class="">
						<input type="text" class="pure-text" value="使用张数"
							readonly="readonly" />
						<input type="text" name="BlackWhiteNumber" disabled="disabled"/>
					</td>
				</tr>
				<tr>
					<td class="" colspan="6">
						<input type="text" class="pure-text" value="退机区分"
							readonly="readonly" />
						○运作不良&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ○开箱不良&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;○运输损坏&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;○其它
					</td>
				</tr>
				<tr>
					<td class="" colspan="6">
						<table  border="1" cellpadding="0" cellspacing="0" width="100%">
							<thead>
								<tr>
									<th>
										EDP
									</th>
									<th>
										商品名称
									</th>
									<th style="width: 50px;">
										数量
									</th>
									<th>
										机身号码
									</th>
									<th>
										其他相关情况
									</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>
										<input type="text" name="Field7"/>
									</td>
									<td>
										<input type="text" name="Field8"/>
									</td>
									<td>
										<input type="text" name="Field9" style="width: 50px;" />
									</td>
									<td>
										<input type="text" name="Field10"/>
									</td>
									<td>
										<input type="text" class="pure-text"
											value="○说明书  ○耗材未使用  ○内外包装良好  ○保修卡未填写" readonly="readonly"
											style="width: 400px;" />
									</td>
								</tr>
								<tr>
									<td>
										<input type="text" name="Field11"/>
									</td>
									<td>
										<input type="text" name="Field12"/>
									</td>
									<td>
										<input type="text" name="Field13" style="width: 50px;" />
									</td>
									<td>
										<input type="text" name="Field14"/>
									</td>
									<td>
										<input type="text" class="pure-text"
											value="○说明书  ○耗材未使用  ○内外包装良好  ○保修卡未填写" readonly="readonly"
											style="width: 400px;" />
									</td>
								</tr>
								<tr>
									<td>
										<input type="text" name="Field15"/>
									</td>
									<td>
										<input type="text" name="Field16"/>
									</td>
									<td>
										<input type="text" name="Field17" style="width: 50px;" />
									</td>
									<td>
										<input type="text" name="Field18"/>
									</td>
									<td>
										<input type="text" class="pure-text"
											value="○说明书  ○耗材未使用  ○内外包装良好  ○保修卡未填写" readonly="readonly"
											style="width: 400px;" />
									</td>
								</tr>
								<tr>
									<td>
										<input type="text" name="Field19"/>
									</td>
									<td>
										<input type="text" name="Field20"/>
									</td>
									<td>
										<input type="text" name="Field21" style="width: 50px;" />
									</td>
									<td>
										<input type="text" name="Field22"/>
									</td>
									<td>
										<input type="text" class="pure-text"
											value="○说明书  ○耗材未使用  ○内外包装良好  ○保修卡未填写" readonly="readonly"
											style="width: 400px;" />
									</td>
								</tr>
								<tr>
									<td>
										<input type="text" name="Field23"/>
									</td>
									<td>
										<input type="text" name="Field24"/>
									</td>
									<td>
										<input type="text" name="Field25" style="width: 50px;" />
									</td>
									<td>
										<input type="text" name="Field26"/>
									</td>
									<td>
										<input type="text" class="pure-text"
											value="○说明书  ○耗材未使用  ○内外包装良好  ○保修卡未填写" readonly="readonly"
											style="width: 400px;" />
									</td>
								</tr>
							</tbody>
						</table>
					</td>
				</tr>

				<tr>
					<td class="">
						<input type="text" class="pure-text" value="货品存放地"
							readonly="readonly" />
						<input type="text" name="Field27" style="width:300px;"/>
					</td>
					<td class="">
						<input type="text" class="pure-text" value="联系人"
							readonly="readonly" />
						<input type="text" name="Field28"/>
					</td>
					<td class="">
						<input type="text" class="pure-text" value="联系电话"
							readonly="readonly" />
						<input type="text" name="Field29"/>
					</td>
				</tr>
				<tr>
					<td class="" colspan="6">
						<table  border="1" cellpadding="0" cellspacing="0" width="100%">
							<thead>
								<tr>
									<th>
										申请理由
									</th>
									<th>
										※决定退机的主要理由？
									</th>
									<th>
										※采取过何种对策？
									</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td valign="middle" align="center">
										RCN支社填写
									</td>
									<td>
										<textarea rows="3" cols="80" name="Field30"></textarea>
									</td>
									<td>
										<textarea rows="3" cols="80" name="Field31"></textarea>
									</td>
								</tr>
							</tbody>
						</table>
					</td>
				</tr>
				<tr>
					<td class="">
						<input type="text" class="pure-text" value="处理方法"
							readonly="readonly" />
					</td>

				</tr>
				<tr>
					<td class="">
						<input type="text" class="pure-text" value="○ 机器交换 "
							readonly="readonly" />
					</td>
					<td class="">
						<input type="text" class="pure-text" value="新品收货方"
							readonly="readonly" />
						<input type="text" name="Field32"/>
					</td>
				</tr>
				<tr>
					<td class="">
						<input type="text" class="pure-text" value="○ 红票处理"
							readonly="readonly" />
						金额（
						<input type="text" name="Field37" onchange="checkQty($(this));checkValueLength($(this),10)" style="width: 50px" />
						）
					</td>

					<td class="">
						<input type="text" class="pure-text" value="收货地点"
							readonly="readonly" />
						<input type="text" name="Field33"/>
					</td>
				</tr>
				<tr>
					<td class="">
						<input type="text" class="pure-text" value="○ A4代零件"
							readonly="readonly" />
					</td>
					<td class="">
						<input type="text" class="pure-text" value="联系人"
							readonly="readonly" />
						<input type="text" name="Field34"/>
					</td>
					<td class="">
						<input type="text" class="pure-text" value="联系电话"
							readonly="readonly" />
						<input type="text" name="Field35"/>
					</td>
				</tr>
				<tr>
					<td class="">
						<input type="text" class="pure-text" value="○ 其它"
							readonly="readonly" />
					</td>
					<td class="">
					</td>
				</tr>
				<tr>
					<td class="" colspan="3">
						<table  border="1" cellpadding="0" cellspacing="0" width="100%">
							<thead>
								<tr>
									<th>
										部门/支社代表签字
									</th>
									<th>
										支社技术部门签字
									</th>
									<th>
										最终判定部门：SCM推进课
									</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td width="200px" height="80px" valign="bottom" align="right">
										印
									</td>
									<td width="200px" height="80px" valign="bottom" align="right">
									印
									</td>
									<td valign="top">
									<table width="100%">
										<tr><td height="60px">处理意见：</td><td></td></tr>
										<tr><td valign="bottom" align="right">&nbsp;&nbsp;&nbsp;&nbsp;年&nbsp;&nbsp;&nbsp;&nbsp;月&nbsp;&nbsp;&nbsp;&nbsp;日</td><td valign="bottom" align="right">印</td></tr>
									</table>
									
									</td>
								</tr>
							</tbody>
						</table>
					</td>
				</tr>
			</table>
			<table width=1100><tr><td align="right"><input type="button" id="print" value="打印"/><input type="button" id="close" value="关闭"/></td></tr></table>
			<form id="print-form" action="printServiceReturnAction.action" method="post">
				<table><tr><td><input type="hidden" name="serviceReturnPrintInfo" id="print-info"/></td></tr></table>
			</form>
		</div>
	</body>
	<script type="text/javascript">
$(document).ready(function() {
	$("#print").bind('click', function() {
		printServiceReturn();
	});
	$("#close").bind('click', function() {
		self.close();
	});
	$("input[name=ApplyDate]").val(unicodeToString('<s:property value="serviceReturnPrintBean.ApplyDate"/>'));
	$("input[name=BlackWhiteNumber]").val(unicodeToString('<s:property value="serviceReturnPrintBean.BlackWhiteNumber"/>'));
	$("input[name=CompanyAddress]").val(unicodeToString('<s:property value="serviceReturnPrintBean.CompanyAddress"/>'));
	$("input[name=CompanyTel]").val(unicodeToString('<s:property value="serviceReturnPrintBean.CompanyTel"/>'));
	$("input[name=CustomerCompany]").val(unicodeToString('<s:property value="serviceReturnPrintBean.CustomerCompany"/>'));
	$("input[name=CustomerName]").val(unicodeToString('<s:property value="serviceReturnPrintBean.CustomerName"/>'));
	$("input[name=PpsNo]").val(unicodeToString('<s:property value="serviceReturnPrintBean.PpsNo"/>'));
	$("input[name=InvoiceDate]").val(unicodeToString('<s:property value="serviceReturnPrintBean.InvoiceDate"/>'));
});
function printServiceReturn()
{
	$("#print-info").val('');
	var ins = $("body").find('input');
	var printInfo = '{';
	for(i=0;i<ins.size();i++)
	{
		if($.trim(ins.eq(i).attr('name')).length==0)
			continue;
		if(printInfo.length>1)
			printInfo += ',';
		printInfo += '"'+replaceSpecialCharacters($.trim(ins.eq(i).attr('name')))+'":"' + replaceSpecialCharacters($.trim(ins.eq(i).val())) + '"';
	}
	var tareas = $("body").find('textarea');
	for(i=0;i<tareas.size();i++)
	{
		if($.trim(tareas.eq(i).attr('name')).length==0)
			continue;
		if(printInfo.length>1)
			printInfo += ',';
		printInfo += '"'+replaceSpecialCharacters($.trim(tareas.eq(i).attr('name')))+'":"' + replaceSpecialCharacters($.trim(tareas.eq(i).val())) + '"';
	}
	printInfo += '}';
	$("#print-info").val(printInfo);
	$("#print-form").submit();
}
</script>
</html>