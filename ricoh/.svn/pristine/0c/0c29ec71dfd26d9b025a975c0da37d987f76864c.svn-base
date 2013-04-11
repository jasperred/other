<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<%@ taglib prefix="s" uri="/struts-tags"%>
	<%@ include file="../common/top.jsp"%>
	<link type="text/css" href="css/ui/jquery.ui.all.css" rel="stylesheet" />
	<script type="text/javascript" src="js/jquery/ui/jquery.ui.core.js"></script>
	<script type="text/javascript" src="js/jquery/ui/jquery.ui.widget.js"></script>
	<script type="text/javascript" src="js/jquery/ui/jquery.ui.mouse.js"></script>
	<script type="text/javascript" src="js/jquery/ui/jquery.ui.datepicker.js"></script>
	<script type="text/javascript" src="js/jquery/ui/jquery.ui.slider.js"></script>
	<script type="text/javascript" src="js/jquery/timepicker/jquery-ui-timepicker-addon-0.5.js"></script>
	<script type="text/javascript" src="js/jquery/ui/i18n/jquery.ui.datepicker-zh-CN.js"></script>
	<script type="text/javascript" src="application/orderByRicoh/lib/order_create.js"></script>
	<s:action name="serviceTypeListAction" id="serviceTypeListAction"></s:action>
	<s:action name="symptomListAction" id="symptomListAction"></s:action>
	<s:action name="actionListAction" id="actionListAction"></s:action>
	<s:action name="causeListAction" id="causeListAction"></s:action>
	<s:action name="locationListAction" id="locationListAction"></s:action>
	<s:action name="targetListAction" id="targetListAction"></s:action>
	<body>
		<div id="search-box">
			<span class="rc-tp"><span></span> </span>
			<table width=100% class="hd" id="order-info-banner">
				<tr><td align="left">维修单</td><td align="right">[展开/隐藏]</td></tr>
			</table>
			<table width=100% id="order-info" rules="none" border="1">
				<tr>
					<td class="sdingle-col">
						<input type="text" class="pure-text" value="流水号"
							readonly="readonly" />
						<input type="hidden" id = "service-id"/>
						<input type="text" id="service-no" readonly="readonly"/>
					</td>
					<td class="sdingle-col">
						<input type="text" class="pure-text" value="维修单类型"
							readonly="readonly" />
						<s:push value="serviceTypeListAction">
						<select name="" id="service-method">
							<s:iterator value="serviceTypeList">
								<option value="<s:property value="UnitNo"/>"><s:property value="UnitName"/></option>
							</s:iterator>
						</select>
						</s:push>
					</td>
					<td class="sdingle-col">
						<input type="text" class="pure-text" value="特约维修店名"
							readonly="readonly" />
						<input type="text" id="company-name" readonly="readonly"/>
					</td>
				</tr>
				<tr>
					<td class="sdingle-col">
						<input type="text" class="pure-text" value="机号"
							readonly="readonly" />
						<input type="text" id="machine-no" readonly="readonly"/>
					</td>
					<td class="sdingle-col">
						<input type="text" class="pure-text" value="机型"
							readonly="readonly" />
						<input type="text" id="machine-type-name" readonly="readonly"/>
					</td>
				
					<td class="sdingle-col">
						<input type="text" class="pure-text" value="商品编号"
							readonly="readonly" />
						<input type="text" id="machine-cd" readonly="readonly"/>
					</td>
				</tr>
				<tr>
					<td class="sdingle-col">
						<input type="text" class="pure-text" value="保修期"
							readonly="readonly" />
						<input type="text" id="service-date-status" readonly="readonly"/>
					</td>
					<td class="sdingle-col">
						<input type="text" class="pure-text" value="保修期结束日"
							readonly="readonly" />
						<input type="text" id="service-end-date" readonly="readonly"/>
					</td>
					<td class="sdingle-col">
						<input type="text" class="pure-text" value="销售日期"
							readonly="readonly" />
						<input type="text" id="invoice-date" />
					</td>
				</tr>
				<tr>
					<td class="sdingle-col">
						<input type="text" class="pure-text" value="维修受理日时间"
							readonly="readonly" />
						<input type="text" id="service-date" />
					</td>
					<td class="sdingle-col">
						<input type="text" class="pure-text" value="出发时间"
							readonly="readonly" />
						<input type="text" id="from-date" />
					</td>
				
					<td class="sdingle-col">
						<input type="text" class="pure-text" value="到达时间"
							readonly="readonly" />
						<input type="text" id="end-date" />
					</td>	
				</tr>
				<tr>		
					<td class="sdingle-col">
						<input type="text" class="pure-text" value="服务形式"
							readonly="readonly" />
						<select name="" id="service-method">
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
					<td class="sdingle-col">
						<input type="text" class="pure-text" value="维修合同形态"
							readonly="readonly" />
						<select name="" id="service-contract">
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
					<td class="sdingle-col">
						<input type="text" class="pure-text" value="维修作业项目"
							readonly="readonly" />
						<select name="" id="service-operation">
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
						<input type="text" class="pure-text" value="黑白计数器读数"
							readonly="readonly" />
						<input type="text" id="black-white-number" />
					</td>
					<td class="sdingle-col">
						<input type="text" class="pure-text" value="彩色计数器读数"
							readonly="readonly" />
						<input type="text" id="color-number" />
					</td>
				
					<td class="sdingle-col">
						<input type="text" class="pure-text" value="制版计数器读数"
							readonly="readonly" />
						<input type="text" id="plate-number" />
					</td>
				</tr>
				<tr>
					<td class="sdingle-col" colspan="3">
						<input type="text" class="pure-text" style="width:170px;" value="受理时随机附件以及送修商品外观备注"
							readonly="readonly" />
					</td>
				</tr>
				<tr>
					<td colspan="3"> 
						<textarea style="width:95%"   id="machine-memo" rows="2"></textarea>
					</td>
				</tr>
				<tr>
					<td class="sdingle-col">
						<input type="text" class="pure-text" value="用户公司"
							readonly="readonly" />
						<input type="text" id="customer-company" />
					</td>
					<td class="sdingle-col">
						<input type="text" class="pure-text" value="客户代码"
							readonly="readonly" />
						<input type="text" id="customer-no" />
					</td>	
					<td class="sdingle-col">
						<input type="text" class="pure-text" value="邮政编码"
							readonly="readonly" />
						<input type="text" id="customer-zip" />
					</td>
				</tr>
				<tr>			
					<td class="sdingle-col">
						<input type="text" class="pure-text" value="送修人/保修人"
							readonly="readonly" />
						<input type="text" id="customer-name" />
					</td>
					<td class="sdingle-col">
						<input type="text" class="pure-text" value="联系电话"
							readonly="readonly" />
						<input type="text" id="customer-tel" />
					</td>					
				</tr>
				<tr>
					<td class="sdingle-col" colspan="3">
						<input type="text" class="pure-text" value="用户地址"
							readonly="readonly" />
						<input type="text" id="customer-address" style="width: 600px;"/>
					</td>
				</tr>
				<tr>
					<td class="sdingle-col">
						<input type="text" class="pure-text" value="信息输入人姓名"
							readonly="readonly" />
						<input type="text" id="create-name" readonly="readonly"/>
					</td>
					<td class="sdingle-col">
						<input type="text" class="pure-text" value="信息输入时间"
							readonly="readonly" />
						<input type="text" id="create-time" readonly="readonly"/>
					</td>	
					<td class="sdingle-col">
						<input type="text" class="pure-text" value="上次故障受理日"
							readonly="readonly" />
						<input type="text" id="last-time" readonly="readonly"/>
					</td>
				</tr>
			</table>

			<table width=100% class="hd" id="order-fault-banner">
				<tr><td align="left">故障</td><td align="right">[展开/隐藏]</td></tr>
			</table>
			<table width=100% id="order-fault" border="0" cellpadding="1"
				cellspacing="1" class="listing" width="100%" bgcolor="#CCCCCC">
				<tr>
					<td>
						故障现象
					</td>
					<s:push value="symptomListAction">
					<td>
						分类：
						<select name="" id="">
						<s:iterator value="symptomList">
							<option value="<s:property value="UnitNo"/>"><s:property value="UnitName"/></option>
						</s:iterator>
						</select>
					</td>
					</s:push>
					<td>
						现象：<select name="" id="">
							<option value="">
							</option>
						</select>
						代码：<input type="text" id="" />
						备注：<input type="text" id="" />
					</td>
				</tr>
				<tr>
					<td>
						故障原因
					</td>
					<s:push value="causeListAction">
					<td>
						分类：
						<select name="" id="">
						<s:iterator value="causeList">
							<option value="<s:property value="UnitNo"/>"><s:property value="UnitName"/></option>
						</s:iterator>
						</select>
					</td>
					</s:push>
					<td>
						原因：<select name="" id="">
							<option value="">
							</option>
						</select>
						代码：<input type="text" id="" />
						备注：<input type="text" id="" />
					</td>
				</tr>
				<tr>
					<td>
						故障措施
					</td>
					<s:push value="actionListAction">
					<td>
						分类：
						<select name="" id="">
						<s:iterator value="actionList">
							<option value="<s:property value="UnitNo"/>"><s:property value="UnitName"/></option>
						</s:iterator>
						</select>
					</td>
					</s:push>
					<td>
						措施：<select name="" id="">
							<option value="">
							</option>
						</select>
						代码：<input type="text" id="" />
						备注：<input type="text" id="" />
					</td>
				</tr>
				<tr>
					<td>
						故障部位
					</td>
					<s:push value="locationListAction">
					<td>
						分类：
						<select name="" id="">
						<s:iterator value="locationList">
							<option value="<s:property value="UnitNo"/>"><s:property value="UnitName"/></option>
						</s:iterator>
						</select>
					</td>
					</s:push>
					<td>
						部位：<select name="" id="">
							<option value="">
							</option>
						</select>
						代码：<input type="text" id="" />
						备注：<input type="text" id="" />
					</td>
				</tr>
				<tr>
					<td>
						故障零件
					</td>
					<s:push value="targetListAction">
					<td>
						分类：
						<select name="" id="">
						<s:iterator value="targetList">
							<option value="<s:property value="UnitNo"/>"><s:property value="UnitName"/></option>
						</s:iterator>
						</select>
					</td>
					</s:push>
					<td>
						部位：<select name="" id="">
							<option value="">
							</option>
						</select>
						代码：<input type="text" id="" />
						备注：<input type="text" id="" />
					</td>
				</tr>
			</table>
			<table width=100% id="order-fault-button"><tr><td align="left"><input type="button" value="增加故障"/></td></tr></table>
			<table>
				<tr>
					<td>
						<input type="text" class="pure-text" value="维修确认"
							readonly="readonly" />
						<input type="radio" value="parts" name="type-select"
							checked="checked">
							更换零件</input>
						<input name="type-select" type="radio" value="machine">
							更换整机</input>
					</td>
				</tr>
			</table>
			<table width=100% class="hd" id="order-parts-banner">
				<tr><td align="left">零件</td><td align="right">[展开/隐藏]</td></tr>
			</table>
			<table width=100% id="order-parts" border="0" cellpadding="1"
				cellspacing="1" class="listing" width="100%" bgcolor="#CCCCCC">
				<thead>
					<tr>
						<th></th>
						<th>
							故障零件分类
						</th>
						<th>
							更换零件/耗材编号
						</th>
						<th>
							更换零件/耗材名称
						</th>
						<th>
							更换零件/耗材数量
						</th>
						<th>
							故障零件序列号码
						</th>
					</tr>
				</thead>
				<tbody>
					<tr><td></td><td><select style='width:100%;'><option value="零件">零件</option><option value="选购件或耗材">选购件或耗材</option></select></td><td><input type='text' style='width:100%;'/></td><td><input type='text' style='width:100%;'/></td><td><input type='text' style='width:100%;'/></td><td><input type='text' style='width:100%;'/></td></tr>
				</tbody>
			</table>
			<table width=100% id="order-parts-button"><tr><td align="left"><input type="button" value="增加零件"/></td></tr></table>
			<table width=100% class="hd" id="order-machine-banner" style="display: none">
				<tr><td align="left">整机</td><td align="right">[展开/隐藏]</td></tr>
			</table>
			<table width=100% id="order-machine" style="display: none" border="0"
				cellpadding="1" cellspacing="1" class="listing" width="100%"
				bgcolor="#CCCCCC">
				<thead>
					<tr>
						<th>
							整机编号
						</th>
						<th>
							整机名称
						</th>
						<th>
							整机数量
						</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>
							<input type="text" style='width: 100%;' />
						</td>
						<td>
							<input type="text" style='width: 100%;' />
						</td>
						<td>
							<input type="text" style='width: 100%;' />
						</td>
					</tr>
				</tbody>
			</table>
			
		</div>
		<table width="100%" align="right">
				<tr align="right">
					<td>
						<input type="button" id="create-order" value="受理" />
						<input type="button" id="cancel-order" value="取消受理" />
					</td>

				</tr>
			</table>
	</body>
	<script type="text/javascript">
	$(document).ready(function() {
		init();
		var serviceId = '<s:property value="serviceId"/>';
		var serviceNo = '<s:property value="serviceNo"/>';
		var serviceDateStatus = unicodeToString('<s:property value="serviceDateStatus"/>');
		var  machineId= '<s:property value="machineId"/>';
		var  machineTypeName= unicodeToString('<s:property value="machineTypeName"/>');
		var  machineCd= '<s:property value="machineCd"/>';
		var  machineNo= '<s:property value="machineNo"/>';
		var  ppsNo= '<s:property value="ppsNo"/>';
		var  serviceFromDate= '<s:property value="serviceFromDate"/>';
		var  serviceEndDate= '<s:property value="serviceEndDate"/>';
		var  outDate= '<s:property value="outDate"/>';
		var  lastTime= '<s:property value="lastTime"/>';
		var  invoiceDate= '<s:property value="invoiceDate"/>';
		var  paymentStatus= '<s:property value="paymentStatus"/>';
		var  paymentCompany= unicodeToString('<s:property value="paymentCompany"/>');
		var  paymentCompanyCd= '<s:property value="paymentCompanyCd"/>';
		var companyName = unicodeToString('<s:property value="#session.COMPANY_INFO.CompanyName"/>');
		var machineFlag = '<s:property value="machineFlag"/>';
		var createTime = '<s:property value="createTime"/>';
		var createName = '<s:property value="createName"/>';
		setOrderInfo(serviceId,serviceNo,serviceDateStatus,machineNo,companyName,machineTypeName,machineCd,machineFlag,serviceEndDate,lastTime,outDate,serviceFromDate,invoiceDate,createTime,createName);
	});
</script>
</html>