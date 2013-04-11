<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<%@ taglib prefix="s" uri="/struts-tags"%>
	<%@ include file="../common/top.jsp"%>
	<script type="text/javascript"
		src="application/deliveryByRicoh/lib/delivery_info.js"></script>
	<body>
		<div id="search-box">
			<span class="rc-tp"><span></span> </span>
			<table width=100% class="hd"  id="delivery-info-banner">
				<tr><td align="left">发货管理</td><td align="right">[展开/隐藏]</td></tr>
			</table>
			<table width=100% id="delivery-info" rules="none" bdelivery="1">
				<tr>
					<td class="sdingle-col">
						<input type="text" class="pure-text" value="维修单流水号"
							readonly="readonly" />
						<input type="text" id="service-no" disabled="disabled"/>
						<a href="serviceInfoByRcnAction.action?serviceId=<s:property value="ServiceId"/>">查看维修单</a>
					</td>
					<td class="sdingle-col">
						<input type="text" class="pure-text" value="审核ID"
							readonly="readonly" />
						<input type="hidden" id="service-apply-id" disabled="disabled"/>
						<input type="text" id="service-apply-no" disabled="disabled"/>
					</td>
					<td class="sdingle-col">
						<input type="text" class="pure-text" value="审批者"
							readonly="readonly" />
						<input type="text" id="service-apply-audited-user" disabled="disabled"/>
					</td>
				</tr>
				<tr>
					<td class="sdingle-col">
						<input type="text" class="pure-text" value="发货ID"
							readonly="readonly" />
						<input type="hidden" id="service-delivery-id" disabled="disabled"/>
						<input type="text" id="service-delivery-no" disabled="disabled"/>
					</td>
					<td class="sdingle-col">
						<input type="text" class="pure-text" value="发货状态"
							readonly="readonly" />
						<input type="text" id="delivery-status" disabled="disabled"/>
					</td>
					<td class="sdingle-col">
						<input type="text" class="pure-text" value="发货部门分类"
							readonly="readonly" />
						<input type="text" id="department" disabled="disabled"/>
					</td>
				</tr>
				<tr>
					<td class="sdingle-col">
						<input type="text" class="pure-text" value="物流发货单号"
							readonly="readonly" />
						<input type="text" id="shipping-no" disabled="disabled" />
					</td>
					<td class="sdingle-col">
						<input type="text" class="pure-text" value="发货仓库"
							readonly="readonly" />
						<input type="text" id="delivery-stock" disabled="disabled" />
					</td>
					<td class="sdingle-col">
						<input type="text" class="pure-text" value="发货日期"
							readonly="readonly" />
						<input type="text" id="delivery-date" disabled="disabled" />
					</td>
				</tr>
				<tr id="rate-tr1">
					<td class="sdingle-col">
						<input type="text" class="pure-text" value="审核对应天数"
							readonly="readonly" />
						<input type="text" id="audited-time" disabled="disabled"/>
					</td>
					<td class="sdingle-col">
						<input type="text" class="pure-text" value="发货对应天数"
							readonly="readonly" />
						<input type="text" id="delivery-time" disabled="disabled"/>
					</td>
					<td class="sdingle-col">
						<input type="text" class="pure-text" value="总对应天数"
							readonly="readonly" />
						<input type="text" id="all-time" disabled="disabled"/>
					</td>
				</tr>
			</table>			
			<table width=100% class="hd" id="delivery-item-banner">
				<tr><td align="left">零件</td><td align="right">[展开/隐藏]</td></tr>
			</table>
			<table width=100% id="delivery-item" bdelivery="0" cellpadding="1"
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
						<th colspan="3">
							故障零件序列号码
						</th>
						</tr>
						<tr>
						<th>
						零件编号/商品变更
						</th>
						<th>
						新零件/商品编号
						</th>
						<th>
						零件/商品有库存
						</th>
						<th>
						零件或则商品订单号码
						</th>
						<th>
						零件订单日期
						</th>
						<th>
						零件/商品物流发货日
						</th>
						<th>
						预计零件/商品到货日
						</th>
						
					</tr>
				</thead>
				<tbody>
					<s:iterator value="serviceDeliveryItemList" status="li">
						<tr id="<s:property value="id"/>">
							<td><s:property value="#li.index+1"/></td>
							<td><s:property value="ItemCate"/></td>
							<td><s:property value="ItemNo"/></td>
							<td><s:property value="ItemName"/></td>
							<td><s:property value="ItemQty"/></td>
							<td colspan="3"><s:property value="ItemSerialNo"/></td>
							</tr>
							<tr>
							<td><s:if test="ItemChange!=null&&ItemChange.equals(\"Y\")">是</s:if>
							<s:else>否
							</s:else></td>
							<td><s:property value="NewItemNo"/></td>
							<td><s:if test="HasInv!=null&&HasInv.equals(\"Y\")">是
							</s:if>
							<s:else>否
							</s:else></td>
							<td><s:property value="ItemOrderNo"/></td>
							<td><s:property value="ItemOrderDate"/></td>
							<td><s:property value="ItemDeliveryDate"/></td>
							<td><s:property value="ItemArrivalDate"/></td>
						</tr>
					</s:iterator>
				</tbody>
			</table>
			
			<table width=100% class="hd" id="delivery-file-banner">
				<tr><td align="left">附件</td><td align="right">[展开/隐藏]</td></tr>
			</table>
			<table width=100% id="delivery-file" bdelivery="0" cellpadding="1"
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
					<s:iterator value="serviceApplyFileList" status="li">
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
					<s:iterator value="serviceDeliveryFileList" status="li">
						<tr>
							<td>
								<s:if test="serviceApplyFileList==null"><s:property value="#li.index+1"/></s:if>
								<s:else><s:property value="#li.index+1+serviceApplyFileList.size()"/></s:else>								
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
			<table align="right"><tr><td colspan="3"><input type="button" id="back-button" value="返回" /></td></tr></table>
		<%@ include file="../../framework/system/bottom.jsp"%>
	</body>
	<script type="text/javascript">
	$(document).ready(function() {
		$("#delivery-item-banner").bind('click', function() {
		hideAndShow('delivery-item');
	});
		$("#delivery-info-banner").bind('click', function() {
		hideAndShow('delivery-info');
	});
			var deliveryInfo = new Map();
			deliveryInfo.put('serviceDeliveryId',unicodeToString( '<s:property value="serviceDeliveryId"/>'));
			deliveryInfo.put('allTime',unicodeToString( '<s:property value="allTime"/>'));
			deliveryInfo.put('auditedTime',unicodeToString( '<s:property value="auditedTime"/>'));
			deliveryInfo.put('companyId',unicodeToString( '<s:property value="companyId"/>'));
			deliveryInfo.put('companyName',unicodeToString( '<s:property value="companyName"/>'));
			deliveryInfo.put('ctime',unicodeToString( '<s:property value="ctime"/>'));
			deliveryInfo.put('cuser',unicodeToString( '<s:property value="cuser"/>'));
			deliveryInfo.put('deliveryTime',unicodeToString( '<s:property value="deliveryTime"/>'));
			deliveryInfo.put('department',unicodeToString( '<s:property value="department"/>'));
			deliveryInfo.put('serviceApplyId',unicodeToString( '<s:property value="serviceApplyId"/>'));
			deliveryInfo.put('serviceApplyNo',unicodeToString( '<s:property value="serviceApplyNo"/>'));
			deliveryInfo.put('serviceId',unicodeToString( '<s:property value="serviceId"/>'));
			deliveryInfo.put('serviceNo',unicodeToString( '<s:property value="serviceNo"/>'));
			deliveryInfo.put('shippingNo',unicodeToString( '<s:property value="shippingNo"/>'));
			deliveryInfo.put('deliveryStock',unicodeToString( '<s:property value="deliveryStock"/>'));
			deliveryInfo.put('deliveryDate',unicodeToString( '<s:property value="deliveryDate"/>'));
			deliveryInfo.put('status',unicodeToString( '<s:property value="status"/>'));
			deliveryInfo.put('statusName',unicodeToString( '<s:property value="statusName"/>'));
			deliveryInfo.put('serviceDeliveryNo',unicodeToString( '<s:property value="serviceDeliveryNo"/>'));
			deliveryInfo.put('serviceApplyAuditedUser',unicodeToString( '<s:property value="serviceApplyAuditedUser"/>'));
			setDeliveryInfo(deliveryInfo);
			$("#back-button").bind('click', function() {
						window.history.go(-1);
					});
		});
</script>
</html>