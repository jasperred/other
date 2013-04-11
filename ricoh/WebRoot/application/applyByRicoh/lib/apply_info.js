function init(serviceApplyType) {
	if (serviceApplyType == 'RATE') {
		$("#audited-result")
				.append(
						'<option value="NO_INVOICE">通过</option><option value="RE_APPLY">不通过</option>');
	} else {
		$("#audited-result")
				.append(
						'<option value="WAIT_DELIVERY">通过</option><option value="RE_APPLY">不通过</option><option value="USE_INV">用库存</option><option value="ADD_INV">补库存</option>');
	}
}
function setApplyInfo(applyInfo) {
	$("#service-apply-id").val(applyInfo.get('serviceApplyId'));
	$("#service-apply-no").val(applyInfo.get('serviceApplyNo'));
	$("#service-id").val(applyInfo.get('serviceId'));
	$("#service-no").val(applyInfo.get('serviceNo'));
	$("#machine-cat").val(applyInfo.get('machineCat'));
	$("#apply-service-type").val(applyInfo.get('serviceApplyType'));
	$("#apply-service-type-name").val(applyInfo.get('serviceApplyTypeName'));
	$("#apply-tec-rate").val(applyInfo.get('tecRate'));
	$("#apply-home-rate").val(applyInfo.get('homeRate'));
	$("#apply-other-rate").val(applyInfo.get('otherRate'));
	$("#apply-other-rate-memo").val(applyInfo.get('otherRateMemo'));
	$("#audited-result").val(applyInfo.get('auditedResult'));
	$("#apply-status").val(applyInfo.get('statusName'));
	$("#part-type").val(applyInfo.get('partType'));
	$("#result-memo").val(applyInfo.get('resultMemo'));
	$("#shop-memo").val(applyInfo.get('shopMemo'));
	$("#return-flag").val(applyInfo.get('returnFlag'));
	$("#return-memo").val(applyInfo.get('returnMemo'));
	$("#return-improve").val(applyInfo.get('returnImprove'));
	$("#return-confirm").val(applyInfo.get('returnConfirm'));
	$("#cuser").val(applyInfo.get('cuser'));
	$("#ccompany").val(applyInfo.get('ccompany'));
	$("#ctime").val(applyInfo.get('ctime'));
	$("#muser").val(applyInfo.get('muser'));
	$("#back-memo").val(applyInfo.get('backMemo'));
	if($.trim(applyInfo.get('serviceApplyType'))=='RATE')
	{
		if($.trim(applyInfo.get('visitId')).length==0)
		{
			$("#visit-status").val('未回访');
			$("#visit-id").val('');
		}
		else
		{
			$("#visit-id").val(applyInfo.get('visit-id'));
			$("#visit-status").val('已回访'+':'+$.trim(applyInfo.get('visitResult')));
		}
	}
	else
	{
		$("#visit-status").parent().remove();		
	}
}

function auditedApplyService() {
	//var applyServiceType = $("#apply-service-type").val();
	//if($.trim(applyServiceType)=='RATE'&&$("#audited-result").val()=='NO_INVOICE')
	//{
	//	var visitId = $("#visit-id").val();
	//	if($.trim(visitId).length==0)
	//	{
	//		if(!confirm('该维修单还未进行回访,是否确认审核通过?'))
	//			return;
	//	}
	//}
	var serviceApplyId = replaceSpecialCharacters($("#service-apply-id").val());
	var auditedResult = replaceSpecialCharacters($("#audited-result").val());
	var resultMemo = replaceSpecialCharacters($("#result-memo").val());
	var partType = replaceSpecialCharacters($("#part-type").val());
	if($.trim(auditedResult)==0)
	{
		alert('请选择审核结果');
		return;
	}
	if(!confirm('是否确认审核结果'))
		return;
	$.ajax( {
		type : "POST",
		url : "auditedApplyServiceAction.action",
		data : {
			serviceApplyId : serviceApplyId,
			auditedResult : auditedResult,
			resultMemo : resultMemo,
			partType : partType
		},
		success : function(msg) {
			if ($.trim(msg).length == 0) {
				alert("审核成功");
				window.location.reload();
			} else {
				alert(unicodeToString(msg));
			}

		}
	});
}
function reApplyService() {
	var serviceApplyId = replaceSpecialCharacters($("#service-apply-id").val());
	var shopMemo = replaceSpecialCharacters($("#shop-memo").val());
	var homeRate = replaceSpecialCharacters($("#apply-home-rate").val());
	var otherRate = replaceSpecialCharacters($("#apply-other-rate").val());
	var otherRateMemo = replaceSpecialCharacters($("#apply-other-rate-memo").val());
	$.ajax( {
		type : "POST",
		url : "reApplyServiceAction.action",
		data : {
			serviceApplyId : serviceApplyId,
			shopMemo : shopMemo,
			homeRate : homeRate,
			otherRate : otherRate,
			otherRateMemo : otherRateMemo
		},
		success : function(msg) {
			if ($.trim(msg).length == 0) {
				alert("申述成功");
				window.location.reload();
			} else {
				alert(unicodeToString(msg));
			}

		}
	});
}
function pageControlByShop(applyType, status) {
	if (applyType != 'RATE') {
		$("#rate-tr1").remove();
		$("#rate-tr2").remove();
		$("#rate-tr3").remove();
		if(!(status=='NO_APPLY'||status=='RE_APPLY'))
		{
			$("#shop-memo").attr('disabled',true);			
		}
	}
	else
	{
		if(!(status=='NO_APPLY'||status=='RE_APPLY'))
		{
			$("#apply-tec-rate").attr('disabled',true);
			$("#apply-home-rate").attr('disabled',true);
			$("#apply-other-rate").attr('disabled',true);
			$("#apply-other-rate-memo").attr('disabled',true);
			$("#shop-memo").attr('disabled',true);
		}
	}
	if (applyType != 'PART') {
		$("#part-type-td").remove();
	}
	if (status == 'RE_APPLY') {
		$("#re-apply-button").bind('click', function() {
						reApplyService();
					});
	} else {
		$("#re-apply-button").remove();
	}
	
	

}
function pageControlByRcn(applyType, status) {
	if (applyType != 'RATE') {
		$("#rate-tr1").remove();
		$("#rate-tr2").remove();
		$("#rate-tr3").remove();
		$("#visit-status").parent().remove();
		if(status!='IN_APPLY')
		{
			$("#audited-result").attr('disabled',true);
			$("#result-memo").attr('disabled',true);
		}
	}
	else
	{
		$("#save-return-button").remove();
		$("#return-tr").remove();
		$("#return-tr2").remove();
		$("#return-tr3").remove();
		if(status!='IN_APPLY')
		{
			$("#audited-result").attr('disabled',true);
			$("#result-memo").attr('disabled',true);
		}
		
	}
	if (applyType != 'PART') {
		$("#part-type-td").remove();
	}
	if (status == 'IN_APPLY') {
		$("#audited-button").bind('click', function() {
			auditedApplyService();
		});
		
		$("#service-return-print-button").bind('click', function() {
			pringServiceReturn();
		});
		$("#save-return-button").remove();
	} 
	else if(status == 'RE_APPLY')
	{
		$("#audited-button").remove();
		$("#service-return-print-button").remove();
		$("#save-return-button").remove();
	}
	else {
		$("#audited-button").remove();
		$("#service-return-print-button").bind('click', function() {
			pringServiceReturn();
		});
		$("#audited-result").attr("disabled",true);
		$("#result-memo").attr("disabled",true);
		$("#save-return-button").bind('click', function() {
			saveReturnInfo();
		});
	}
}
function saveReturnInfo() {
	var serviceApplyId = replaceSpecialCharacters($("#service-apply-id").val());
	var returnFlag = replaceSpecialCharacters($("#return-flag").val());
	var returnMemo = replaceSpecialCharacters($("#return-memo").val());
	var returnImprove = replaceSpecialCharacters($("#return-improve").val());
	var returnConfirm = replaceSpecialCharacters($("#return-confirm").val());
	$.ajax( {
		type : "POST",
		url : "saveServiceReturnInfoAction.action",
		data : {
			serviceApplyId : serviceApplyId,
			returnFlag : returnFlag,
			returnMemo : returnMemo,
			returnImprove : returnImprove,
			returnConfirm : returnConfirm
		},
		success : function(msg) {
			if ($.trim(msg).length == 0) {
				alert("保存成功");
				window.location.reload();
			} else {
				alert(unicodeToString(msg));
			}

		}
	});
}
function pringServiceReturn()
{
	window.open("viewServiceReturnInfoAction?serviceApplyId="+$("#service-apply-id").val(),"退\换机申请书打印",'');
}
function serviceApplyFileUpload()
{
	var file = $("#upload-file").val();
	if($.trim(file).length==0)
	{
		alert('请选择上传文件');
		return;
	}
	$("#file-upload-form").submit();
}