function init() {
	$('#invoice-info-banner').bind('click', function() {
		hideAndShow('invoice-info');
	});
	$('#invoice-item-banner').bind('click', function() {
		hideAndShow('invoice-item');
	});
	$('#invoice-file-banner').bind('click', function() {
		hideAndShow('invoice-file-upload');
	});
}

function initByShop() {
	$('#invoice-info-banner').bind('click', function() {
		hideAndShow('invoice-info');
	});
	$('#invoice-item-banner').bind('click', function() {
		hideAndShow('invoice-item');
	});
	$('#back-button').bind('click', function() {
		window.history.go(-1);
	});
}

function setInvoiceInfo(invoiceInfoMap) {
	$("#invoice-id").val(invoiceInfoMap.get('invoiceId'));
	$("#invoice-cd").val(invoiceInfoMap.get('invoiceCd'));
	$("#invoice-date").val(invoiceInfoMap.get('invoiceDate'));
	$("#invoice-notice-date").val(invoiceInfoMap.get('invoiceNoticeDate'));
	$("#invoice-notice-person").val(invoiceInfoMap.get('invoiceNoticePerson'));
	$("#invoice-receive-date").val(invoiceInfoMap.get('invoiceReceiveDate'));
	//$("#invoice-status").val(invoiceInfoMap.get('invoiceStatus'));
	//$("#invoice-url").val(invoiceInfoMap.get('invoiceUrl'));
	$("#company-id").val(invoiceInfoMap.get('companyId'));
	$("#company-name").val(invoiceInfoMap.get('companyName'));
	$("#from-date").val(invoiceInfoMap.get('fromDate'));
	$("#end-date").val(invoiceInfoMap.get('endDate'));
	$("#home-amt").val(invoiceInfoMap.get('homeAmt'));
	$("#other-amt").val(invoiceInfoMap.get('otherAmt'));
	$("#service-amt").val(invoiceInfoMap.get('serviceAmt'));
	$("#payment-date").val(invoiceInfoMap.get('paymentDate'));
	$("#total-amt").val(invoiceInfoMap.get('totalAmt'));
	$("#invoice-memo").val(invoiceInfoMap.get('memo'));
}

function buttonControl(invoiceStatus) {
	$('#back-button').bind('click', function() {
		window.history.go(-1);
	});
	if($.trim(invoiceStatus).length==0)
	{
		$('#generate-invoice-button').bind('click', function() {
			generateInvoice();
		});
		$('#save-invoice-button').remove();
		$('#complete-invoice-button').remove();
		$('#invoice-file-banner').remove();
		$('#invoice-file-upload').remove();
	}
	if($.trim(invoiceStatus)=='INVOICE')
	{
		$('#generate-invoice-button').remove();
		$('#save-invoice-button').bind('click', function() {
			saveInvoice();
		});
		$('#complete-invoice-button').bind('click', function() {
			completeInvoice();
		});
		$("#invoice-cd").attr('disabled',true);
	}
	if($.trim(invoiceStatus)=='INVOICE_COMPLETE')
	{
		$('#generate-invoice-button').remove();
		$('#save-invoice-button').remove();
		$('#complete-invoice-button').remove();
		$("#invoice-cd").attr('disabled',true);
		$("#invoice-date").attr('disabled',true);
		$("#invoice-receive-date").attr('disabled',true);
		$("#payment-date").attr('disabled',true);
		$("#invoice-memo").attr('disabled',true);
		$("#invoice-date").parent().children(".ui-datepicker-trigger").remove();
		$("#invoice-receive-date").parent().children(".ui-datepicker-trigger").remove();
		$("#payment-date").parent().children(".ui-datepicker-trigger").remove();
	}
}
function generateInvoice()
{
	if($.trim($("#invoice-cd").val()).length==0)
	{
		alert('请填写费用结算编号');
		return;
	}
	//if($.trim($("#invoice-date").val()).length==0)
	//{
	//	alert('请填写发票开出日期');
	//	return;
	//}
	$("#generate-invoice-form").submit();
}
function saveInvoice()
{
	var invoiceId = replaceSpecialCharacters($("#invoice-id").val());
	var invoiceReceiveDate = replaceSpecialCharacters($("#invoice-receive-date").val());
	var paymentDate = replaceSpecialCharacters($("#payment-date").val());
	var memo = replaceSpecialCharacters($("#invoice-memo").val());
	$.ajax( {
		type : "POST",
		url : "saveInvoiceInfoByRcnAction.action",
		data : {
			invoiceId : invoiceId,
			invoiceReceiveDate : invoiceReceiveDate,
			paymentDate : paymentDate,
			memo : memo,
			crumb : $("#crumb").val()
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
function completeInvoice()
{
	var invoiceId = replaceSpecialCharacters($("#invoice-id").val());
	var invoiceDate = replaceSpecialCharacters($("#invoice-date").val());
	var invoiceReceiveDate = replaceSpecialCharacters($("#invoice-receive-date").val());
	var paymentDate = replaceSpecialCharacters($("#payment-date").val());
	var memo = replaceSpecialCharacters($("#invoice-memo").val());
	if($.trim($("#invoice-date").val()).length==0)
	{
		alert('请填写发票开出日期');
		return;
	}
	if($.trim($("#invoice-receive-date").val()).length==0)
	{
		alert('请填写发票接受日期');
		return;
	}
	$.ajax( {
		type : "POST",
		url : "completeInvoiceByRcnAction.action",
		data : {
			invoiceId : invoiceId,
			invoiceDate : invoiceDate,
			invoiceReceiveDate : invoiceReceiveDate,
			paymentDate : paymentDate,
			memo : memo,
			crumb : $("#crumb").val()
			
		},
		success : function(msg) {
			if ($.trim(msg).length == 0) {
				alert("操作成功");
				window.location.reload();
			} else {
				alert(unicodeToString(msg));
			}

		}
	});
}
function invoiceFileUpload()
{
	var file = $("#upload-file").val();
	if($.trim(file).length==0)
	{
		alert('请选择上传文件');
		return;
	}
	$("#file-upload-form").submit();
}