<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<%@ taglib prefix="s" uri="/struts-tags"%>
	<%@ include file="../common/top.jsp"%>
	
	<script type="text/javascript" src="application/orderByRicoh/lib/order_info.js"></script>
	
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
					<td class="">
						<input type="text" class="pure-text" value="流水号"
							readonly="readonly" />
						<input type="hidden" id = "service-id"/>
						<input type="text" id="service-no" readonly="readonly" disabled="disabled"/>
					</td>
					<td class="">
						<input type="text" class="pure-text" value="维修区分"
							readonly="readonly" />
						<s:push value="serviceTypeListAction">
						<select name="" id="service-type" disabled="disabled">
							<s:iterator value="serviceTypeList">
								<option value="<s:property value="UnitNo"/>"><s:property value="UnitName"/></option>
							</s:iterator>
						</select>
						</s:push>
					</td>
					<td class="">
						<input type="text" class="pure-text" value="特约维修店名"
							readonly="readonly" />
						<input type="text" id="company-name" readonly="readonly" disabled="disabled"/>
					</td>
				</tr>
				<tr>
					<td class="">
						<input type="text" class="pure-text" value="机号"
							readonly="readonly" />
						<input type="text" id="machine-no" readonly="readonly" disabled="disabled"/>
					</td>
					<td class="">
						<input type="text" class="pure-text" value="机型"
							readonly="readonly" />
						<input type="text" id="machine-type-name" readonly="readonly" disabled="disabled"/>
					</td>
				
					<td class="">
						<input type="text" class="pure-text" value="商品编号"
							readonly="readonly" />
						<input type="text" id="machine-cd" readonly="readonly" disabled="disabled"/>
					</td>
				</tr>
				<tr>
					<td class="">
						<input type="text" class="pure-text" value="保修期"
							readonly="readonly" />
						<input type="text" id="service-date-status" readonly="readonly" disabled="disabled"/>
					</td>
					<td class="">
						<input type="text" class="pure-text" value="保修期结束日"
							readonly="readonly" />
						<input type="text" id="service-end-date" readonly="readonly" disabled="disabled"/>
					</td>
					<td class="">
						<input type="text" class="pure-text" value="销售日期"
							readonly="readonly" />
						<input type="text" id="invoice-date" disabled="disabled" />
					</td>
				</tr>
				<tr>
					<td class="">
						<input type="text" class="pure-text" value="维修受理日时间"
							readonly="readonly" />
						<input type="text" id="service-date" disabled="disabled" />
					</td>
					<td class="">
						<input type="text" class="pure-text" value="出发时间"
							readonly="readonly" />
						<input type="text" id="from-date" disabled="disabled" />
					</td>
				
					<td class="">
						<input type="text" class="pure-text" value="到达时间(维修开始时间)"
							readonly="readonly" />
						<input type="text" id="end-date" disabled="disabled" />
					</td>	
				</tr>
				<tr>		
					<td class="">
						<input type="text" class="pure-text" value="服务形式"
							readonly="readonly" />
						<select name="" id="service-method" disabled="disabled">
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
					<td class="">
						<input type="text" class="pure-text" value="维修合同形态"
							readonly="readonly" />
						<select name="" id="service-contract" disabled="disabled">
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
					<td class="">
						<input type="text" class="pure-text" value="维修作业项目"
							readonly="readonly" />
						<select name="" id="service-operation" disabled="disabled">
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
					<td class="">
						<input type="text" class="pure-text" value="黑白计数器读数"
							readonly="readonly" />
						<input type="text" id="black-white-number" disabled="disabled" />
					</td>
					<td class="">
						<input type="text" class="pure-text" value="彩色计数器读数"
							readonly="readonly" />
						<input type="text" id="color-number" disabled="disabled" />
					</td>
				
					<td class="">
						<input type="text" class="pure-text" value="制版计数器读数"
							readonly="readonly" />
						<input type="text" id="plate-number" disabled="disabled" />
					</td>
				</tr>
				
				<tr>
					<td class="">
						<input type="text" class="pure-text" value="服务费已支付"
							readonly="readonly" />
						<input type="text" id="machine-payment-status" disabled="true"/>
					</td>
					<td class="">
						<input type="text" class="pure-text" value="服务费支付公司"
							readonly="readonly" />
						<input type="text" id="machine-payment-company"  disabled="true" />
					</td>
				
					<td class="">
						<input type="text" class="pure-text" value="服务费支付日期"
							readonly="readonly" />
						<input type="text" id="machine-payment-date"  disabled="true" />
					</td>
				</tr>
				<tr>
					<td class="">
						<input type="text" class="pure-text" value="预计维修完成时间"
							readonly="readonly" />
						<input type="text" id="service-expected-finish-date" disabled="disabled" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm'})" class="Wdate" />
						
					</td>
					<td class="">
					</td>
					<td class="">
					</td>
				</tr>
				<tr>
					<td class="" colspan="3">
						<input type="text" class="pure-text" style="width:300px;" value="受理时随机附件以及送修商品外观备注"
							readonly="readonly" />
					</td>
				</tr>
				<tr>
					<td colspan="3"> 
						<textarea style="width:95%"   id="machine-memo" rows="5" disabled="disabled"></textarea>
					</td>
				</tr>
				<tr>
					<td class="">
						<input type="text" class="pure-text" value="用户公司"
							readonly="readonly" />
						<input type="text" id="customer-company" disabled="disabled" />
					</td>
					<td class="">
						<input type="text" class="pure-text" value="客户代码"
							readonly="readonly" />
						<input type="text" id="customer-no" disabled="disabled" />
					</td>	
					<td class="">
						<input type="text" class="pure-text" value="邮政编码"
							readonly="readonly" />
						<input type="text" id="customer-zip" disabled="disabled" />
					</td>
				</tr>
				<tr>			
					<td class="">
						<input type="text" class="pure-text" value="送修人/保修人"
							readonly="readonly" />
						<input type="text" id="customer-name" disabled="disabled" />
					</td>
					<td class="">
						<input type="text" class="pure-text" value="联系电话"
							readonly="readonly" />
						<input type="text" id="customer-tel" disabled="disabled" />
					</td>					
				</tr>
				<tr>
					<td class="">
						<input type="text" class="pure-text" value="省/直辖市/自治区" readonly="readonly" />
						<input type="text" id="customer-address1" onchange="checkValueLength($(this),255)" disabled="disabled"/>
					</td>
					<td class="" >
						<input type="text" class="pure-text" value="市/县" readonly="readonly" />
						<input type="text" id="customer-address2" onchange="checkValueLength($(this),255)" disabled="disabled"/>
					</td>
					<td class="" >
						<input type="text" class="pure-text" value="区/乡" readonly="readonly" />
						<input type="text" id="customer-address3" onchange="checkValueLength($(this),255)" disabled="disabled"/>
					</td>
				</tr>
				<tr>
					<td class="" >
						<input type="text" class="pure-text" value="街道/小区/村" readonly="readonly" />
						<input type="text" id="customer-address4" onchange="checkValueLength($(this),255)" disabled="disabled"/>
					</td>
					<td class="" colspan="2">
						<input type="text" class="pure-text" value="门牌号/室/小组" readonly="readonly" />
						<input type="text" id="customer-address5" style="width:500px;" onchange="checkValueLength($(this),255)" disabled="disabled"/>
					</td>
				</tr>
				
				<tr>
					<td class="">
						<input type="text" class="pure-text" value="客户应付维修费"
							readonly="readonly" />
						<input type="text" id="service-amt" disabled="disabled"/>
					</td>
					<td class="">
						<input type="text" class="pure-text" value="客户应付上门费"
							readonly="readonly" />
						<input type="text" id="home-amt" disabled="disabled"/>
					</td>
					<td class="">
						<input type="text" class="pure-text" value="客户应付零件费"
							readonly="readonly" />
						<input type="text" id="part-amt" disabled="disabled"/>
					</td>
				</tr>
				<tr>
					<td class="">
						<input type="text" class="pure-text" value="客户应付耗材费"
							readonly="readonly" />
						<input type="text" id="consumables-amt" disabled="disabled"/>
					</td>
					<td class="">
						<input type="text" class="pure-text" value="客户应付其它费用"
							readonly="readonly" />
						<input type="text" id="other-amt" disabled="disabled"/>
					</td>
					<td class="" colspan="2">
						<input type="text" class="pure-text" value="客户其它费用说明"
							readonly="readonly" />
						<input type="text" id="other-amt-memo" disabled="disabled" value="<s:property value="applyOtherRateMemo"/>"/>
					</td>
				</tr>
				<tr>
					<td class="" colspan="3">
						<input type="text" class="pure-text" value="备注" readonly="readonly" />
					
						<textarea style="width:85%"   id="memo" rows="5" disabled="disabled"></textarea>
					</td>
				</tr>
				<tr>
					<td class="">
						<input type="text" class="pure-text" value="修理完成日期"
							readonly="readonly" />
						<input type="text" id="service-finish-date" disabled="disabled" />
					</td>
					<td class="">
						<input type="text" class="pure-text" value="用户取回机器日期"
							readonly="readonly" />
						<input type="text" id="customer-retrieve-date" disabled="disabled" />
					</td>
					<td class="">
						<input type="text" class="pure-text" value="维修人姓名"
							readonly="readonly" />
						<input type="text" id="fix-people" disabled="disabled" />
					</td>
				</tr>
				<tr>
					<td class="">
						<input type="text" class="pure-text" value="已过时日"
							readonly="readonly" />
						<input type="text" id="thru-time" readonly="readonly" disabled="disabled"/>
					</td>
					
					<td class="">
						<input type="text" class="pure-text" value="反应时间"
							readonly="readonly" />
						<input type="text" id="response-time" readonly="readonly" disabled="disabled"/>
					</td>
					
					<td class="">
						<input type="text" class="pure-text" value="移动时间"
							readonly="readonly" />
						<input type="text" id="move-time" readonly="readonly" disabled="disabled"/>
					</td>
				</tr>
				<tr>
					<td class="">
						<input type="text" class="pure-text" value="信息输入人姓名"
							readonly="readonly" />
						<input type="text" id="create-name" readonly="readonly" disabled="disabled"/>
					</td>
					<td class="">
						<input type="text" class="pure-text" value="信息输入时间"
							readonly="readonly" />
						<input type="text" id="create-time" readonly="readonly" disabled="disabled"/>
					</td>	
					<td class="">
						<input type="text" class="pure-text" value="上次故障受理日"
							readonly="readonly" />
						<input type="text" id="last-time" readonly="readonly" disabled="disabled"/>
					</td>
				</tr>
			</table>
			
			<table width=100% class="hd" id="order-status-banner">
				<tr><td align="left">维修单状态</td><td align="right">[展开/隐藏]</td></tr>
			</table>
			<table width=100% id="order-status" rules="none" border="1">
				<tr>
					<td class="">
						<input type="text" class="pure-text" value="维修状态"
							readonly="readonly" />
						<input type="hidden" id="service-status-no" />
						<input type="text" readonly="readonly" id="service-status-name" disabled="disabled" />
					</td>
					<td class="">
						<input type="text" class="pure-text" value="零件申请状态"
							readonly="readonly" />
						<input type="hidden" id="apply-part-status-no" />
						<input type="text" readonly="readonly" id="apply-part-status-name" disabled="disabled" />
					</td>
					<td class="">
						<input type="text" class="pure-text" value="整机申请状态"
							readonly="readonly" />
						<input type="hidden" id="apply-machine-status-no" />
						<input type="text" readonly="readonly" id="apply-machine-status-name" disabled="disabled" />
					</td>
				</tr>
				<tr>		
					<td class="">
						<input type="text" class="pure-text" value="费用申请状态"
							readonly="readonly" />
						<input type="hidden" id="apply-rate-status-no" />
						<input type="text" readonly="readonly" id="apply-rate-status-name"  disabled="disabled"/>
					</td>		
					<td class="">
						<input type="text" class="pure-text" value="回访状态"
							readonly="readonly" />
						<input type="hidden" id="visit-status-no" />
						<input type="text" readonly="readonly" id="visit-status-name" disabled="disabled" />
					</td>		
					<td class="">
						<input type="text" class="pure-text" value="回访结果"
							readonly="readonly" />
						<input type="text" readonly="readonly" id="visit-result" disabled="disabled" />
					</td>					
				</tr>
			</table>
			<table width=100% class="hd" id="order-fault-banner">
				<tr><td align="left">故障</td><td align="right">[展开/隐藏]</td></tr>
			</table>
			<table width=100% id="order-fault" border="0" cellpadding="1"
				cellspacing="1" class="listing" width="100%" bgcolor="#CCCCCC">
				<tr id="symptom-tr" style="display: none">
					<td width="60px">
						故障现象
					</td>
					<s:push value="symptomListAction">
					<td width="200px">
						分类：
						<select name="SYMPTOM" key="FaultCateNo" id="" onchange="faultParentSelect($(this))" disabled="disabled">
						<option></option>
						<s:iterator value="symptomList">
							<option value="<s:property value="UnitNo"/>"><s:property value="UnitName"/></option>
						</s:iterator>
						</select>
					</td>
					</s:push>
					<td>
						现象：<select name="" key="FaultName" id="" onchange="faultChildSelect($(this))" disabled="disabled">
							<option value="">
							</option>
						</select>
						代码：<input type="text" key="FaultNo" id="" class="pure-text" readonly="readonly" />
						<input type="text" key="Memo" id="" class="pure-text" readonly="readonly" align="right" style="display: none" disabled="disabled"/><input type="text" key="Content" id="" style="display: none;width:300px;" disabled="disabled"/>
					</td>
				</tr>
				<tr id="cause-tr" style="display: none">
					<td>
						故障原因
					</td>
					<s:push value="causeListAction">
					<td>
						分类：
						<select name="CAUSE" id="" key="FaultCateNo" onchange="faultParentSelect($(this))" disabled="disabled">
						<option></option>
						<s:iterator value="causeList">
							<option value="<s:property value="UnitNo"/>"><s:property value="UnitName"/></option>
						</s:iterator>
						</select>
					</td>
					</s:push>
					<td>
						原因：<select name="" key="FaultName" id="" onchange="faultChildSelect($(this))" disabled="disabled">
							<option value="">
							</option>
						</select>
						代码：<input type="text" key="FaultNo" id="" class="pure-text" readonly="readonly"  />
						<input type="text" key="Memo" id="" class="pure-text" readonly="readonly" align="right" style="display: none" disabled="disabled"/><input type="text" key="Content" id="" style="display: none;width:300px;" disabled="disabled"/>
					</td>
				</tr>
				<tr id="action-tr" style="display: none">
					<td>
						故障措施
					</td>
					<s:push value="actionListAction">
					<td>
						分类：
						<select name="ACTION" key="FaultCateNo" id="" onchange="faultParentSelect($(this))" disabled="disabled">
						<option></option>
						<s:iterator value="actionList">
							<option value="<s:property value="UnitNo"/>"><s:property value="UnitName"/></option>
						</s:iterator>
						</select>
					</td>
					</s:push>
					<td>
						措施：<select name="" key="FaultName" id="" onchange="faultChildSelect($(this))" disabled="disabled">
							<option value="">
							</option>
						</select>
						代码：<input type="text" key="FaultNo" id="" class="pure-text" readonly="readonly" />
						<input type="text" key="Memo" id="" class="pure-text" readonly="readonly" align="right" style="display: none" disabled="disabled"/><input type="text" key="Content" id="" style="display: none;width:300px;" disabled="disabled"/>
					</td>
				</tr>
				<tr id="location-tr" style="display: none">
					<td>
						故障部位
					</td>
					<s:push value="locationListAction">
					<td>
						分类：
						<select name="LOCATION" key="FaultCateNo" id="" onchange="faultParentSelect($(this))" disabled="disabled">
						<option></option>
						<s:iterator value="locationList">
							<option value="<s:property value="UnitNo"/>"><s:property value="UnitName"/></option>
						</s:iterator>
						</select>
					</td>
					</s:push>
					<td>
						部位：<select name="" key="FaultName" id="" onchange="faultChildSelect($(this))" disabled="disabled">
							<option value="">
							</option>
						</select>
						代码：<input type="text" key="FaultNo" id="" class="pure-text" readonly="readonly" />
						<input type="text" key="Memo" id="" class="pure-text" readonly="readonly" align="right" style="display: none"/><input type="text" key="Content" id="" style="display: none;width:300px;" disabled="disabled"/>
					</td>
				</tr>
				<tr id="target-tr" style="display: none">
					<td>
						故障零件
					</td>
					<s:push value="targetListAction">
					<td>
						分类：
						<select name="TARGET" key="FaultCateNo" id="" onchange="faultParentSelect($(this))" disabled="disabled">
						<option></option>
						<s:iterator value="targetList">
							<option value="<s:property value="UnitNo"/>"><s:property value="UnitName"/></option>
						</s:iterator>
						</select>
					</td>
					</s:push>
					<td>
						零件：<select name="" key="FaultName" id="" onchange="faultChildSelect($(this))" disabled="disabled">
							<option value="">
							</option>
						</select>
						代码：<input type="text" key="FaultNo" id="" class="pure-text" readonly="readonly" />
						<input type="text" key="Memo" id="" class="pure-text" readonly="readonly" align="right" style="display: none" disabled="disabled"/><input type="text" key="Content" id="" style="display: none;width:300px;" disabled="disabled"/>
					</td>
				</tr>
				<!-- 默认显示 -->
				<s:if test="faultList==null||faultList.size()==0">
				<tr>
					<td width="60px">
						故障现象
					</td>
					<s:push value="symptomListAction">
					<td width="200px">
						分类：
						<select name="SYMPTOM" key="FaultCateNo" id="" onchange="faultParentSelect($(this))" disabled="disabled">
						<option></option>
						<s:iterator value="symptomList">
							<option value="<s:property value="UnitNo"/>"><s:property value="UnitName"/></option>
						</s:iterator>
						</select>
					</td>
					</s:push>
					<td>
						现象：<select name="" key="FaultName" id="" onchange="faultChildSelect($(this))" disabled="disabled">
							<option value="">
							</option>
						</select>
						代码：<input type="text" key="FaultNo" id="" class="pure-text" readonly="readonly" />
						<input type="text" key="Memo" id="" class="pure-text" readonly="readonly" align="right" style="display: none" disabled="disabled"/><input type="text" key="Content" id="" style="display: none;width:300px;" disabled="disabled"/>
					</td>
				</tr>
				<tr>
					<td>
						故障原因
					</td>
					<s:push value="causeListAction">
					<td>
						分类：
						<select name="CAUSE" key="FaultCateNo" id="" onchange="faultParentSelect($(this))" disabled="disabled">
						<option></option>
						<s:iterator value="causeList">
							<option value="<s:property value="UnitNo"/>"><s:property value="UnitName"/></option>
						</s:iterator>
						</select>
					</td>
					</s:push>
					<td>
						原因：<select name="" key="FaultName" id="" onchange="faultChildSelect($(this))" disabled="disabled">
							<option value="">
							</option>
						</select>
						代码：<input type="text" key="FaultNo" id="" class="pure-text" readonly="readonly" />
						<input type="text" key="Memo" id="" class="pure-text" readonly="readonly" align="right" style="display: none" disabled="disabled"/><input type="text" key="Content" id="" style="display: none;width:300px;" disabled="disabled"/>
					</td>
				</tr>
				<tr>
					<td>
						故障措施
					</td>
					<s:push value="actionListAction">
					<td>
						分类：
						<select name="ACTION" key="FaultCateNo" id="" onchange="faultParentSelect($(this))" disabled="disabled">
						<option></option>
						<s:iterator value="actionList">
							<option value="<s:property value="UnitNo"/>"><s:property value="UnitName"/></option>
						</s:iterator>
						</select>
					</td>
					</s:push>
					<td>
						措施：<select name="" key="FaultName" id="" onchange="faultChildSelect($(this))" disabled="disabled">
							<option value="">
							</option>
						</select>
						代码：<input type="text" key="FaultNo" id="" class="pure-text" readonly="readonly" />
						<input type="text" key="Memo" id="" class="pure-text" readonly="readonly" align="right" style="display: none" disabled="disabled"/><input type="text" key="Content" id="" style="display: none;width:300px;" disabled="disabled"/>
					</td>
				</tr>
				<tr>
					<td>
						故障部位
					</td>
					<s:push value="locationListAction">
					<td>
						分类：
						<select name="LOCATION" key="FaultCateNo" id="" onchange="faultParentSelect($(this))" disabled="disabled">
						<option></option>
						<s:iterator value="locationList">
							<option value="<s:property value="UnitNo"/>"><s:property value="UnitName"/></option>
						</s:iterator>
						</select>
					</td>
					</s:push>
					<td>
						部位：<select name="" key="FaultName" id="" onchange="faultChildSelect($(this))" disabled="disabled">
							<option value="">
							</option>
						</select>
						代码：<input type="text" key="FaultNo" id="" class="pure-text" readonly="readonly" />
						<input type="text" key="Memo" id="" class="pure-text" readonly="readonly" align="right" style="display: none" disabled="disabled"/><input type="text" key="Content" id="" style="display: none;width:300px;" disabled="disabled"/>
					</td>
				</tr>
				<tr>
					<td>
						故障零件
					</td>
					<s:push value="targetListAction">
					<td>
						分类：
						<select name="TARGET" key="FaultCateNo" id="" onchange="faultParentSelect($(this))" disabled="disabled">
						<option></option>
						<s:iterator value="targetList">
							<option value="<s:property value="UnitNo"/>"><s:property value="UnitName"/></option>
						</s:iterator>
						</select>
					</td>
					</s:push>
					<td>
						零件：<select name="" key="FaultName" id="" onchange="faultChildSelect($(this))" disabled="disabled">
							<option value="">
							</option>
						</select>
						代码：<input type="text" key="FaultNo" id="" class="pure-text" readonly="readonly" />
						<input type="text" key="Memo" id="" class="pure-text" readonly="readonly" align="right" style="display: none" disabled="disabled"/><input type="text" key="Content" id="" style="display: none;width:300px;" disabled="disabled"/>
					</td>
				</tr>
				</s:if>
			</table>
			
			<table width=100% class="hd" id="order-parts-banner">
				<tr><td align="left">主机/零件/选购件或耗材</td><td align="right">[展开/隐藏]</td></tr>
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
						<th>
							是否申请
						</th>
					</tr>
				</thead>
				<tbody>
					<tr id="part-tr" style="display: none"><td></td><td><select key="ItemCate" style='width:100%;' disabled="disabled"><option></option><option value="零件">零件</option><option value="选购件或耗材">选购件或耗材</option><option value="主机">主机</option></select></td><td><input key="ItemNo" type='text' style='width:100%;' disabled="disabled"/></td><td><input key="ItemName" type='text' style='width:100%;' disabled="disabled"/></td><td><input key="ItemQty" type='text' style='width:100%;' disabled="disabled"/></td><td><input key="ItemSerialNo" type='text' style='width:100%;' disabled="disabled"/></td><td><select key="ItemStatus" disabled="disabled"><option value="APPLY">是</option><option value="NONE">否</option></select></td></tr>
					<s:if test="partOrMachineList==null||partOrMachineList.size()==0||(partOrMachine!=null&&partOrMachine.equals(\"machine\"))">
					<tr><td></td><td><select key="ItemCate" style='width:100%;' disabled="disabled"><option></option><option value="零件">零件</option><option value="选购件或耗材">选购件或耗材</option><option value="主机">主机</option></select></td><td><input key="ItemNo" type='text' style='width:100%;' disabled="disabled"/></td><td><input key="ItemName" type='text' style='width:100%;' disabled="disabled"/></td><td><input key="ItemQty" type='text' style='width:100%;' disabled="disabled"/></td><td><input key="ItemSerialNo" type='text' style='width:100%;' disabled="disabled"/></td><td><select key="ItemStatus" disabled="disabled"><option value="APPLY">是</option><option value="NONE">否</option></select></td></tr>
					</s:if>
				</tbody>
			</table>
			<table width=100% class="hd" id="order-file-banner">
				<tr><td align="left">附件</td><td align="right">[展开/隐藏]</td></tr>
			</table>
			<table width=100% id="order-file" border="0" cellpadding="1"
				cellspacing="1" class="listing" width="100%" bgcolor="#CCCCCC">
				<thead>
					<tr>
						<th></th>
						<th>附件名称</th>
						<th>类型</th>
						<th>
							附件查看
						</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="fileList" status="li">
						<tr>
							<td>
								<s:property value="#li.index+1"/>
							</td>
							<td>
								<s:property value="FileName"/>
							</td>
							<td>
								<s:property value="id.FileType"/>
							</td>
							<td>
								<a href="<s:property value="fileUploadUrl"/><s:property value="FileUrl"/>" target="_">查看</a>
							</td>
						</tr>
					</s:iterator>
				</tbody>
			</table>
			
		</div>
		<table align="right">
			<tr>
				<td>
					<input type="button" id="back-button" value="返回"/>
				</td>
			</tr>
		</table>
		<%@ include file="../../framework/system/bottom.jsp"%>
	</body>
	<script type="text/javascript">
	$(document).ready(function() {
		$("#back-button").bind('click', function() {
			window.history.go(-1);
		});
		//初始化
		initByRcn();
		//维修信息
		var serviceInfoMap = new Map();
		serviceInfoMap.put('serviceId',unicodeToString('<s:property value="serviceId"/>'));
		serviceInfoMap.put('serviceType',unicodeToString('<s:property value="serviceType"/>'));
		serviceInfoMap.put('serviceNo',unicodeToString('<s:property value="serviceNo"/>'));
		serviceInfoMap.put('serviceDateStatus',unicodeToString('<s:property value="serviceDateStatus"/>'));
		serviceInfoMap.put('machineId',unicodeToString('<s:property value="machineId"/>'));
		serviceInfoMap.put('machineTypeName',unicodeToString('<s:property value="machineTypeName"/>'));
		serviceInfoMap.put('machineTypeCat',unicodeToString('<s:property value="machineTypeCat"/>'));
		serviceInfoMap.put('machineCd',unicodeToString('<s:property value="machineCd"/>'));
		serviceInfoMap.put('machineNo',unicodeToString('<s:property value="machineNo"/>'));
		serviceInfoMap.put('serviceFromDate',unicodeToString('<s:property value="serviceFromDate"/>'));
		serviceInfoMap.put('serviceEndDate',unicodeToString('<s:property value="serviceEndDate"/>'));
		serviceInfoMap.put('outDate',unicodeToString('<s:property value="outDate"/>'));
		serviceInfoMap.put('lastDate',unicodeToString('<s:property value="lastDate"/>'));
		serviceInfoMap.put('invoiceDate',unicodeToString('<s:property value="invoiceDate"/>'));
		serviceInfoMap.put('companyName',unicodeToString('<s:property value="companyName"/>'));
		serviceInfoMap.put('machineFlag',unicodeToString('<s:property value="machineFlag"/>'));
		serviceInfoMap.put('serviceDate',unicodeToString('<s:property value="serviceDate"/>'));
		serviceInfoMap.put('fromDate',unicodeToString('<s:property value="fromDate"/>'));
		serviceInfoMap.put('endDate',unicodeToString('<s:property value="endDate"/>'));
		serviceInfoMap.put('serviceMethod',unicodeToString('<s:property value="serviceMethod"/>'));
		serviceInfoMap.put('serviceContract',unicodeToString('<s:property value="serviceContract"/>'));
		serviceInfoMap.put('serviceOperation',unicodeToString('<s:property value="serviceOperation"/>'));
		serviceInfoMap.put('blackWhiteNumber',unicodeToString('<s:property value="blackWhiteNumber"/>'));
		serviceInfoMap.put('colorNumber',unicodeToString('<s:property value="colorNumber"/>'));
		serviceInfoMap.put('plateNumber',unicodeToString('<s:property value="plateNumber"/>'));
		serviceInfoMap.put('partOrMachine',unicodeToString('<s:property value="partOrMachine"/>'));
		serviceInfoMap.put('michaneMemo',unicodeToString('<s:property value="michaneMemo"/>'));
		serviceInfoMap.put('customerCompany',unicodeToString('<s:property value="customerCompany"/>'));
		serviceInfoMap.put('customerNo',unicodeToString('<s:property value="customerNo"/>'));
		serviceInfoMap.put('customerZip',unicodeToString('<s:property value="customerZip"/>'));
		serviceInfoMap.put('customerName',unicodeToString('<s:property value="customerName"/>'));
		serviceInfoMap.put('customerTel',unicodeToString('<s:property value="customerTel"/>'));
		serviceInfoMap.put('customerAddress1',unicodeToString('<s:property value="customerAddress1"/>'));
		serviceInfoMap.put('customerAddress2',unicodeToString('<s:property value="customerAddress2"/>'));
		serviceInfoMap.put('customerAddress3',unicodeToString('<s:property value="customerAddress3"/>'));
		serviceInfoMap.put('customerAddress4',unicodeToString('<s:property value="customerAddress4"/>'));
		serviceInfoMap.put('customerAddress5',unicodeToString('<s:property value="customerAddress5"/>'));
		serviceInfoMap.put('createTime',unicodeToString('<s:property value="createTime"/>'));
		serviceInfoMap.put('createName',unicodeToString('<s:property value="createName"/>'));
		serviceInfoMap.put('serviceExpectedFinishDate',unicodeToString('<s:property value="serviceExpectedFinishDate"/>'));
		//机器相关信息 2012-08-16
		serviceInfoMap.put('machinePaymentStatus',unicodeToString('<s:property value="machinePaymentStatus"/>'));
		serviceInfoMap.put('machinePaymentCompany',unicodeToString('<s:property value="machinePaymentCompany"/>'));
		serviceInfoMap.put('machinePaymentDate',unicodeToString('<s:property value="machinePaymentDate"/>'));
		setOrderInfo(serviceInfoMap);
		//维修状态
		var serviceStatusMap = new Map();
		serviceStatusMap.put('serviceStatus',unicodeToString('<s:property value="serviceStatus"/>'));
		serviceStatusMap.put('serviceStatusName',unicodeToString('<s:property value="serviceStatusName"/>'));
		serviceStatusMap.put('applyRateStatus',unicodeToString('<s:property value="applyRateStatus"/>'));
		serviceStatusMap.put('applyRateStatusName',unicodeToString('<s:property value="applyRateStatusName"/>'));
		serviceStatusMap.put('applyPartStatus',unicodeToString('<s:property value="applyPartStatus"/>'));
		serviceStatusMap.put('applyPartStatusName',unicodeToString('<s:property value="applyPartStatusName"/>'));
		serviceStatusMap.put('applyMachineStatus',unicodeToString('<s:property value="applyMachineStatus"/>'));
		serviceStatusMap.put('applyMachineStatusName',unicodeToString('<s:property value="applyMachineStatusName"/>'));
		serviceStatusMap.put('visitStatus',unicodeToString('<s:property value="visitStatus"/>'));
		serviceStatusMap.put('visitStatusName',unicodeToString('<s:property value="visitStatusName"/>'));
		serviceStatusMap.put('serviceAmt',unicodeToString('<s:property value="serviceAmt"/>'));
		serviceStatusMap.put('outDate',unicodeToString('<s:property value="outDate"/>'));
		serviceStatusMap.put('serviceId',unicodeToString('<s:property value="serviceId"/>'));
		serviceStatusMap.put('visitResult',unicodeToString('<s:property value="visitResult"/>'));
		setOrderStatus(serviceStatusMap);
		//维修结果
		var serviceResultMap = new Map();
		serviceResultMap.put('serviceAmt',unicodeToString('<s:property value="serviceAmt"/>'));
		serviceResultMap.put('homeAmt',unicodeToString('<s:property value="homeAmt"/>'));
		serviceResultMap.put('partsAmt',unicodeToString('<s:property value="partsAmt"/>'));
		serviceResultMap.put('consumablesAmt',unicodeToString('<s:property value="consumablesAmt"/>'));
		serviceResultMap.put('otherAmt',unicodeToString('<s:property value="otherAmt"/>'));
		serviceResultMap.put('otherAmtMemo',unicodeToString('<s:property value="otherAmtMemo"/>'));
		serviceResultMap.put('serviceFinishDate',unicodeToString('<s:property value="serviceFinishDate"/>'));
		serviceResultMap.put('serviceResult',unicodeToString('<s:property value="serviceResult"/>'));
		serviceResultMap.put('fixPeople',unicodeToString('<s:property value="fixPeople"/>'));
		serviceResultMap.put('customerRetrieveDate',unicodeToString('<s:property value="customerRetrieveDate"/>'));
		serviceResultMap.put('thruTime',unicodeToString('<s:property value="thruTime"/>'));
		serviceResultMap.put('responseTime',unicodeToString('<s:property value="responseTime"/>'));
		serviceResultMap.put('moveTime',unicodeToString('<s:property value="moveTime"/>'));
		serviceResultMap.put('memo',unicodeToString('<s:property value="memo"/>'));
		serviceResultMap.put('applyTecRate',unicodeToString('<s:property value="applyTecRate"/>'));
		serviceResultMap.put('applyHomeRate',unicodeToString('<s:property value="applyHomeRate"/>'));
		serviceResultMap.put('applyOtherRate',unicodeToString('<s:property value="applyOtherRate"/>'));
		serviceResultMap.put('applyOtherRateMemo',unicodeToString('<s:property value="applyOtherRateMemo"/>'));
		setOrderResult(serviceResultMap);
		
		//故障
		<s:if test="faultList!=null">
		<s:iterator value="faultList">
		var faultId =unicodeToString( '<s:property value="id"/>');
		var faultType = unicodeToString('<s:property value="FaultType"/>');
		var faultCateNo = unicodeToString('<s:property value="FaultCateNo"/>');
		var faultNo = unicodeToString('<s:property value="FaultNo"/>');
		var faultName = unicodeToString('<s:property value="FaultName"/>');
		var mustMemo = unicodeToString('<s:property value="MustMemo"/>');
		var memo = unicodeToString('<s:property value="Memo"/>');
		var content = unicodeToString('<s:property value="Content"/>');
		var str;
		if(faultType=='SYMPTOM')
		{
			str = $("#symptom-tr").html();
		}else if(faultType=='CAUSE')
		{
			str = $("#cause-tr").html();
		}else if(faultType=='ACTION')
		{
			str = $("#action-tr").html();
		}else if(faultType=='LOCATION')
		{
			str = $("#location-tr").html();
		}else if(faultType=='TARGET')
		{
			str = $("#target-tr").html();
		}
		$("#order-fault tbody").append('<tr id="fault-id-'+faultId+'" fault-id="'+faultId+'">'+str+'</tr>');
		var tds = $("#fault-id-"+faultId).find("td");
		var faultCateNoSelect = tds.eq(1).find("select");
		faultCateNoSelect.val(faultCateNo);
		faultCateNoSelect.trigger("onchange");
		var faultNoSelect = tds.eq(2).find("select");
		faultNoSelect.val(faultNo);
		faultNoSelect.trigger("onchange");
		var fault_inputs = tds.eq(2).find("input");
		fault_inputs.eq(0).val(faultNo);
		if(fault_inputs.size()==3)
		{
			fault_inputs.eq(1).val(memo);
			fault_inputs.eq(2).val(content);
		}
		</s:iterator>
		</s:if>
		//零件或机器
		<s:if test="partOrMachineList!=null">
		<s:iterator value="partOrMachineList">
			var serviceItemId = unicodeToString('<s:property value="id"/>');
			var itemCate = unicodeToString('<s:property value="ItemCate"/>');
			var itemName = unicodeToString('<s:property value="ItemName"/>');
			var itemNo = unicodeToString('<s:property value="ItemNo"/>');
			var itemSerialNo = unicodeToString('<s:property value="ItemSerialNo"/>');
			var itemType = unicodeToString('<s:property value="ItemType"/>');
			var itemQty = unicodeToString('<s:property value="Qty"/>');
			var itemStatus = unicodeToString('<s:property value="ItemStatus"/>');
			//整机
			//if(itemType=='machine')
			//{
			//	var str = '<tr id="machine-item-id-"'+serviceItemId+'" service-item-id="'+serviceItemId+'"><td><input key="ItemName" value="<s:property value="ItemName"/>" type="text" style="width: 100%;" /></td><td><input key="ItemNo" value="<s:property value="ItemNo"/>" type="text" style="width: 100%;" /></td><td><input key="ItemQty" value="<s:property value="Qty"/>" type="text" style="width: 100%;" /></td></tr>'
			//	$("#order-machine tbody").append(str);
			//}
			//零件
			//else
			{
				var str = $("#part-tr").html();
				$("#order-parts tbody").append('<tr id="part-item-id-'+serviceItemId+'" service-item-id="'+serviceItemId+'">'+str+'</tr>');
				var tds = $("#part-item-id-"+serviceItemId).find("td");
				tds.eq(1).children("select").val(itemCate);
				tds.eq(2).children("input").val(itemNo);
				tds.eq(3).children("input").val(itemName);
				tds.eq(4).children("input").val(itemQty);
				tds.eq(5).children("input").val(itemSerialNo);
				tds.eq(6).children("select").val(itemStatus);
			}
		</s:iterator>
		</s:if>
	});
</script>
</html>