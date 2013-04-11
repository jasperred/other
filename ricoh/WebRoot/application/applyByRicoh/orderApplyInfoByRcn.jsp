<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<%@ taglib prefix="s" uri="/struts-tags"%>
	<%@ include file="../common/top.jsp"%>
	<script type="text/javascript"
		src="application/applyByRicoh/lib/apply_info.js"></script>
	<body>
		<div id="search-box">
			<span class="rc-tp"><span></span> </span>
			<table width=100% class="hd"  id="apply-info-banner">
				<tr><td align="left"><s:if test="serviceApplyType.equals(\"RATE\")">
						 维修费申请
						 </s:if>
						 <s:else>
						 维修单申请</s:else></td><td align="right">[展开/隐藏]</td></tr>
			</table>
			<table width=100% id="apply-info" rules="none" bapply="1">
				<tr>
					<td colspan="3">
					<input type="text" class="pure-text" value="申请ID"
							readonly="readonly" />
					<input type="text" id="service-apply-no" disabled="disabled"/>
					</td>
				</tr>
				<tr>
					<td class="sdingle-col">
						<input type="text" class="pure-text" value="维修单流水号"
							readonly="readonly" />
						<input type="hidden" id="service-apply-id" />
						<input type="hidden" id="service-id" />
						<input type="text" id="service-no" disabled="disabled"/>
						<a href="serviceInfoByRcnAction.action?serviceId=<s:property value="ServiceId"/>">查看维修单</a>
					</td>
					<td class="sdingle-col">
						<input type="text" class="pure-text" value="主机/耗材分类"
							readonly="readonly" />
						<input type="text" id="machine-cat" disabled="disabled"/>
					</td>
					<td class="sdingle-col">
						<input type="text" class="pure-text" value="申请类型"
							readonly="readonly" />
						<input type="hidden" id="apply-service-type" />
						<input type="text" id="apply-service-type-name" disabled="disabled"/>
					</td>
				</tr>
				<tr id="rate-tr1">
					<td class="sdingle-col">
						<input type="text" class="pure-text" value="技术费"
							readonly="readonly" />
						<input type="text" id="apply-tec-rate" disabled="disabled"/>
					</td>
					<td class="sdingle-col">
						<input type="text" class="pure-text" value="上门费"
							readonly="readonly" />
						<input type="text" id="apply-home-rate" disabled="disabled"/>
					</td>
					<td class="sdingle-col">
						<input type="text" class="pure-text" value="其它费用"
							readonly="readonly" />
						<input type="text" id="apply-other-rate" disabled="disabled"/>
					</td>
				</tr>
				<tr id="rate-tr2">
					<td class="" colspan="3">
						<input type="text" class="pure-text" style="width:300px;" value="其它费用说明"
							readonly="readonly" />
					</td>
				</tr>
				<tr id="rate-tr3">
					<td colspan="3"> 
						<textarea style="width:95%" id="apply-other-rate-memo" rows="5" disabled="disabled"></textarea>
					</td>
				</tr>
				<tr>
					<td class="sdingle-col">
						<input type="text" class="pure-text" value="审核结果"
							readonly="readonly" />
						<select id="audited-result">
						 <s:if test="serviceApplyType.equals(\"RATE\")">
						 <option value="NO_INVOICE">通过</option><option value="RE_APPLY">不通过</option>
						 </s:if>
						 <s:else>
						 	<s:if test="serviceType.equals(\"SERVICE_ORDER\")">
						 		<option value="WAIT_DELIVERY">通过</option><option value="RE_APPLY">不通过</option><option value="USE_INV">用库存</option>
						 		<s:if test="serviceApplyType.equals(\"PART\")">
						 		<option value="AREA_DELIVERY">区域发货</option>
						 		</s:if>
						 	</s:if>
						 	<s:if test="serviceType.equals(\"ON_CHANGE\")">
						 		<option value="WAIT_DELIVERY">通过</option><option value="RE_APPLY">不通过</option><option value="USE_INV">用库存</option>
						 	</s:if>
						 	<s:if test="serviceType.equals(\"INV_IN\")">
						 		<option value="RE_APPLY">不通过</option><option value="ADD_INV">补库存</option>
						 	</s:if>
						 	<s:if test="serviceType.equals(\"INV_OUT\")">
						 		<option value="RE_APPLY">不通过</option><option value="USE_INV">用库存</option>
						 	</s:if>
						 
						 </s:else>
						</select>
					</td>
					<td class="sdingle-col">
						<input type="text" class="pure-text" value="申请状态"
							readonly="readonly" />
						<input type="text" id="apply-status" disabled="disabled"/>
					</td>
					<td class="sdingle-col">
						<input type="text" class="pure-text" value="回访状态"
							readonly="readonly" />
						<input type="hidden" id="visit-id"/>
						<input type="text" id="visit-status" disabled="disabled"/>
					</td>
					<td class="sdingle-col" id="part-type-td">
						<input type="text" class="pure-text" value="零件索赔类型"
							readonly="readonly" />
						<select id="part-type">
							<option value="零件类">零件类</option>
							<option value="商品类">商品类</option>
							<option value="A4机代零件">A4机代零件</option>
						</select>
					</td>
				</tr>
				<tr>
					<td><input type="text" class="pure-text" value="审批者"
							readonly="readonly" />
						<input type="text" id="muser" disabled="disabled"/>
					</td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td class="" colspan="3">
						<input type="text" class="pure-text" style="width:300px;" value="审核结果说明"
							readonly="readonly" />
					</td>
				</tr>
				<tr>
					<td colspan="3"> 
						<textarea style="width:95%" onchange="checkValueLength($(this),255)" id="result-memo" rows="5"></textarea>
					</td>
				</tr>
				<tr id="shop-memo-tr1">
					<td class="" colspan="3">
						<input type="text" class="pure-text" style="width:300px;" value="特约维修店申述说明"
							readonly="readonly" />
					</td>
				</tr>
				<tr id="shop-memo-tr2">
					<td colspan="3"> 
						<textarea style="width:95%" id="shop-memo" rows="5" disabled="disabled"></textarea>
					</td>
				</tr>
				<s:if test="backMemo!=null">
				<tr>
					<td class="" colspan="3">
						<input type="text" class="pure-text" style="width:300px;" value="发货退回说明"
							readonly="readonly" />
					</td>
				</tr>
				<tr>
					<td colspan="3"> 
						<textarea style="width:95%" id="back-memo" rows="5" disabled="disabled" onchange="checkValueLength($(this),255)" ></textarea>
					</td>
				</tr>
				</s:if>
				<tr id="return-tr">
					<td class="sdingle-col">
						<input type="text" class="pure-text" value="故障零件/机器返回"
							readonly="readonly" />
						<select id="return-flag">
							<option value="Y">是</option>
							<option value="N">否</option>
						</select>
					</td>
					<td class="sdingle-col">
						<input type="text" class="pure-text" value="确认者"
							readonly="readonly" />
						<input type="text" id="return-confirm" onchange="checkValueLength($(this),20)" />
					</td>
					<td class="sdingle-col" colspan="2">
						<input type="text" class="pure-text" value="零件/机器返回是否需要改进"
							readonly="readonly" style="width: 200px"/>
						<select id="return-improve">
							<option value="Y">是</option>
							<option value="N">否</option>
						</select>
					</td>
				</tr>
				<tr id="return-tr2">
					<td colspan="3">
						<input type="text" class="pure-text" value="故障零件/机器返回后记录"
							readonly="readonly" style="width: 200px" />
					</td>
				</tr>
				<tr id="return-tr3">
					<td colspan="3">
						<textarea style="width:95%" onchange="checkValueLength($(this),255)" id="return-memo" rows="2"><s:property value="returnMemo"/></textarea>
					</td>
				</tr>
				<tr>
					<td class="sdingle-col">
						<input type="text" class="pure-text" value="信息输入人姓名"
							readonly="readonly" />
						<input type="text" id="cuser" disabled="disabled"/>
					</td>
					<td class="sdingle-col">
						<input type="text" class="pure-text" value="信息输入人公司名称"
							readonly="readonly" />
						<input type="text" id="ccompany" disabled="disabled"/>
					</td>
					<td class="sdingle-col">
						<input type="text" class="pure-text" value="信息输入时间"
							readonly="readonly" />
						<input type="text" id="ctime" disabled="disabled"/>
					</td>
				</tr>
				
			</table>
			<table width=100% class="hd" id="apply-fault-banner">
				<tr><td align="left">故障</td><td align="right">[展开/隐藏]</td></tr>
			</table>
			<table width=100% id="apply-fault" bapply="0" cellpadding="1"
				cellspacing="1" class="listing" width="100%" bgcolor="#CCCCCC">
				<s:iterator value="faultList">
				<tr>
					<td>
						<s:property value="FaultType"/>
					</td>
					<td>
						分类：<s:property value="FaultCateNo"/>
					</td>
					<td>
						现象：<s:property value="FaultName"/>
					</td>
					<td>
						代码：<s:property value="FaultNo"/>
					</td>
					<td>
						<s:if test="Content!=null&&Content.trim().length>0"><s:property value="Memo"/>：<s:property value="Content"/></s:if>	
					</td>
				</tr>
				</s:iterator>
				
				
			</table>
			<table width=100% class="hd" id="apply-parts-banner">
				<tr><td align="left">主机/零件/选购件或耗材</td><td align="right">[展开/隐藏]</td></tr>
			</table>
			<table width=100% id="apply-parts" bapply="0" cellpadding="1"
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
					<s:iterator value="serviceItemList" status="li">
						<tr >
						<td><s:property value="#li.index+1"/></td>
						<td><s:property value="ItemCate"/></td>
						<td><s:property value="ItemNo"/></td>
						<td><s:property value="ItemName"/></td>
						<td><s:property value="Qty"/></td>
						<td><s:property value="ItemSerialNo"/></td>
						</tr>
					</s:iterator>
				</tbody>
			</table>
			
			<table width=100% class="hd" id="apply-file-banner">
				<tr><td align="left">附件</td><td align="right">[展开/隐藏]</td></tr>
			</table>
			<table width=100% id="apply-file" bapply="0" cellpadding="1"
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
				</tbody>
			</table>
			<form id="file-upload-form" action="serviceApplyFileUploadAction.action" method="post"
				enctype="multipart/form-data">
			<table width=100% id="apply-file-upload">

					<tr>

						<td class="">
							<input type="hidden" name="filePath"
								value="file.upload.path" />
							<input type="hidden" name="serviceApplyId"
								value="<s:property value="serviceApplyId"/>" />
							<label>
								文件:
							</label>
							<select name="serviceApplyFileType" id="upload-type">
								<option value="附件1">
									附件1
								</option>
								<option value="附件2">
									附件2
								</option>
								<option value="附件3">
									附件3
								</option>
							</select>
							<input type="file" name="uploadFile" id="upload-file" />
						</td>
						<td>
							<input type="button" id="file-upload-button" value="上传" onclick="serviceApplyFileUpload()" />
						</td>

					</tr>
				</table>
				</form>
			</div>
			<table align="right"><tr><td><input id="save-return-button" type="button" value="保存零件返回信息" /><input id="audited-button" type="button" value="审核完成" /><input id="service-return-print-button" type="button" value="退/换机申请书打印" /><input type="button" id="back-button" value="返回" /></td></tr></table>
		<%@ include file="../../framework/system/bottom.jsp"%>

	</body>
	<script type="text/javascript">
	$(document).ready(function() {
			//init(unicodeToString( '<s:property value="serviceApplyType"/>'));
			var applyInfo = new Map();
			applyInfo.put('serviceApplyId',unicodeToString( '<s:property value="serviceApplyId"/>'));
			applyInfo.put('auditedResult',unicodeToString( '<s:property value="auditedResult"/>'));
			applyInfo.put('companyId',unicodeToString( '<s:property value="companyId"/>'));
			applyInfo.put('companyName',unicodeToString( '<s:property value="companyName"/>'));
			applyInfo.put('homeRate',unicodeToString( '<s:property value="homeRate"/>'));
			applyInfo.put('machineCat',unicodeToString( '<s:property value="machineCat"/>'));
			applyInfo.put('otherRate',unicodeToString( '<s:property value="otherRate"/>'));
			applyInfo.put('otherRateMemo',unicodeToString( '<s:property value="otherRateMemo"/>'));
			applyInfo.put('partType',unicodeToString( '<s:property value="partType"/>'));
			applyInfo.put('resultMemo',unicodeToString( '<s:property value="resultMemo"/>'));
			applyInfo.put('serviceApplyType',unicodeToString( '<s:property value="serviceApplyType"/>'));
			applyInfo.put('serviceApplyTypeName',unicodeToString( '<s:property value="serviceApplyTypeName"/>'));
			applyInfo.put('serviceId',unicodeToString( '<s:property value="serviceId"/>'));
			applyInfo.put('serviceNo',unicodeToString( '<s:property value="serviceNo"/>'));
			applyInfo.put('shopMemo',unicodeToString( '<s:property value="shopMemo"/>'));
			applyInfo.put('status',unicodeToString( '<s:property value="status"/>'));
			applyInfo.put('statusName',unicodeToString( '<s:property value="statusName"/>'));
			applyInfo.put('tecRate',unicodeToString( '<s:property value="tecRate"/>'));
			applyInfo.put('ctime',unicodeToString( '<s:property value="ctime"/>'));
			applyInfo.put('cuser',unicodeToString( '<s:property value="cuser"/>'));
			applyInfo.put('ccompany',unicodeToString( '<s:property value="ccompany"/>'));
			applyInfo.put('muser',unicodeToString( '<s:property value="muser"/>'));
			applyInfo.put('returnFlag',unicodeToString( '<s:property value="returnFlag"/>'));
			applyInfo.put('returnMemo',unicodeToString( '<s:property value="returnMemo"/>'));
			applyInfo.put('returnImprove',unicodeToString( '<s:property value="returnImprove"/>'));
			applyInfo.put('returnConfirm',unicodeToString( '<s:property value="returnConfirm"/>'));
			applyInfo.put('visitId',unicodeToString( '<s:property value="visitId"/>'));
			applyInfo.put('visitResult',unicodeToString( '<s:property value="visitResult"/>'));
			applyInfo.put('serviceApplyNo',unicodeToString( '<s:property value="serviceApplyNo"/>'));
			applyInfo.put('serviceType',unicodeToString( '<s:property value="serviceType"/>'));
			applyInfo.put('backMemo',unicodeToString( '<s:property value="backMemo"/>'));
			setApplyInfo(applyInfo);
			$("#back-button").bind('click', function() {
						window.history.go(-1);
					});
			pageControlByRcn(unicodeToString( '<s:property value="serviceApplyType"/>'),unicodeToString( '<s:property value="status"/>'));
			$("#apply-info-banner").bind('click', function() {
						hideAndShow('apply-info');
					});
			$("#apply-fault-banner").bind('click', function() {
						hideAndShow('apply-fault');
					});
			$("#apply-parts-banner").bind('click', function() {
						hideAndShow('apply-parts');
					});
			$("#apply-file-banner").bind('click', function() {
						hideAndShow('apply-file');
					});
		});
</script>
</html>