function setDeliveryInfo(deliveryInfo) {
	$("#service-no").val(deliveryInfo.get('serviceNo'));
	$("#service-delivery-id").val(deliveryInfo.get('serviceDeliveryId'));
	$("#service-delivery-no").val(deliveryInfo.get('serviceDeliveryNo'));
	$("#service-apply-id").val(deliveryInfo.get('serviceApplyId'));
	$("#service-apply-no").val(deliveryInfo.get('serviceApplyNo'));
	$("#delivery-status").val(deliveryInfo.get('statusName'));
	$("#department").val(deliveryInfo.get('department'));
	$("#shipping-no").val(deliveryInfo.get('shippingNo'));
	$("#delivery-stock").val(deliveryInfo.get('deliveryStock'));
	$("#delivery-date").val(deliveryInfo.get('deliveryDate'));
	$("#audited-time").val(deliveryInfo.get('auditedTime'));
	$("#delivery-time").val(deliveryInfo.get('deliveryTime'));
	$("#all-time").val(deliveryInfo.get('allTime'));
	$("#service-apply-audited-user").val(deliveryInfo.get('serviceApplyAuditedUser'));
}

function deliveryServiceConfirmByScm() {
	if(!confirm('是否确认完成处理'))
		return;
	if($.trim($("#shipping-no").val()).length==0)
	{
		alert("请填写物流发货单号");
		return;
	}
	if($.trim($("#delivery-stock").val()).length==0)
	{
		alert("请填写发货仓库");
		return;
	}
	if($.trim($("#delivery-date").val()).length==0)
	{
		alert("请填写发货日期");
		return;
	}
	var info = '{';
	info += '"ShippingNo":"' + replaceSpecialCharacters($("#shipping-no").val()) + '",';
	info += '"DeliveryStock":"' + replaceSpecialCharacters($("#delivery-stock").val()) + '",';
	info += '"DeliveryDate":"' + replaceSpecialCharacters($("#delivery-date").val()) + '",';
	info += '"ServiceDeliveryId":"' + replaceSpecialCharacters($("#service-delivery-id").val()) + '",';
	var item = '[';
	var trs = $("#delivery-item tbody").find("tr");
	for (i = 0; i < trs.size(); i++) {
		item += '{';
		var inputs = trs.eq(i).find("input");
		for (j = 0; j < inputs.size(); j++) {
			item += '"' + inputs.eq(j).attr('key') + '":"' + replaceSpecialCharacters(inputs.eq(j).val())
					+ '",';
		}
		var selects = trs.eq(i).find("select");
		for (j = 0; j < selects.size(); j++) {
			item += '"' + selects.eq(j).attr('key') + '":"'
					+ replaceSpecialCharacters(selects.eq(j).val()) + '"';
			if (j < selects.size())
				item += ',';
		}
		if (i == trs.size())
			item += '}';
		else
			item += '},';
	}
	item += ']';
	info += 'ServiceDeliveryItemList:' + item;
	info += '}';
	$.ajax( {
		type : "POST",
		url : "deliveryServiceConfirmByScmAction.action",
		data : {
			serviceDeliveryInfo : info,
			crumb : $("#crumb").val()
		},
		success : function(msg) {
			if ($.trim(msg).length == 0)
				window.location.reload();
			else
				alert($.trim(unicodeToString(msg)));
		}
	});
}
function deliveryServiceWaitByScm() {	
	var info = '{';
	info += '"ShippingNo":"' + replaceSpecialCharacters($("#shipping-no").val()) + '",';
	info += '"DeliveryStock":"' + replaceSpecialCharacters($("#delivery-stock").val()) + '",';
	info += '"DeliveryDate":"' + replaceSpecialCharacters($("#delivery-date").val()) + '",';
	info += '"ServiceDeliveryId":"' + replaceSpecialCharacters($("#service-delivery-id").val()) + '",';
	var item = '[';
	var trs = $("#delivery-item tbody").find("tr");
	for (i = 0; i < trs.size(); i++) {
		item += '{';
		var inputs = trs.eq(i).find("input");
		for (j = 0; j < inputs.size(); j++) {
			item += '"' + inputs.eq(j).attr('key') + '":"' + replaceSpecialCharacters(inputs.eq(j).val())
					+ '",';
		}
		var selects = trs.eq(i).find("select");
		for (j = 0; j < selects.size(); j++) {
			item += '"' + selects.eq(j).attr('key') + '":"'
					+ replaceSpecialCharacters(selects.eq(j).val()) + '"';
			if (j < selects.size())
				item += ',';
		}
		if (i == trs.size())
			item += '}';
		else
			item += '},';
	}
	item += ']';
	info += 'ServiceDeliveryItemList:' + item;
	info += '}';
	$.ajax( {
		type : "POST",
		url : "deliveryServiceWaitByScmAction.action",
		data : {
			serviceDeliveryInfo : info,
			crumb : $("#crumb").val()
		},
		success : function(msg) {
			if ($.trim(msg).length == 0)
				window.location.reload();
			else
				alert($.trim(unicodeToString(msg)));
		}
	});
}
function deliveryServiceConfirmByCspc() {
	if(!confirm('是否确认完成处理'))
		return;

	if($.trim($("#shipping-no").val()).length==0)
	{
		alert("请填写物流发货单号");
		return;
	}
	if($.trim($("#delivery-stock").val()).length==0)
	{
		alert("请填写发货仓库");
		return;
	}
	if($.trim($("#delivery-date").val()).length==0)
	{
		alert("请填写发货日期");
		return;
	}
	var info = '{';
	info += '"ShippingNo":"' + replaceSpecialCharacters($("#shipping-no").val()) + '",';
	info += '"DeliveryStock":"' + replaceSpecialCharacters($("#delivery-stock").val()) + '",';
	info += '"DeliveryDate":"' + replaceSpecialCharacters($("#delivery-date").val()) + '",';
	info += '"ServiceDeliveryId":"' + replaceSpecialCharacters($("#service-delivery-id").val()) + '",';
	var item = '[';
	var trs = $("#delivery-item tbody").find("tr");
	for (i = 0; i < trs.size(); i++) {
		item += '{';
		var inputs = trs.eq(i).find("input");
		for (j = 0; j < inputs.size(); j++) {
			item += '"' + inputs.eq(j).attr('key') + '":"' + replaceSpecialCharacters(inputs.eq(j).val())
					+ '",';
		}
		var selects = trs.eq(i).find("select");
		for (j = 0; j < selects.size(); j++) {
			item += '"' + selects.eq(j).attr('key') + '":"'
					+ replaceSpecialCharacters(selects.eq(j).val()) + '"';
			if (j < selects.size())
				item += ',';
		}
		if (i == trs.size())
			item += '}';
		else
			item += '},';
	}
	item += ']';
	info += 'ServiceDeliveryItemList:' + item;
	info += '}';
	$.ajax( {
		type : "POST",
		url : "deliveryServiceConfirmByCspcAction.action",
		data : {
			serviceDeliveryInfo : info,
			crumb : $("#crumb").val()
		},
		success : function(msg) {
			if ($.trim(msg).length == 0)
				window.location.reload();
			else
				alert($.trim(unicodeToString(msg)));
		}
	});
}
function deliveryServiceWaitByCspc() {
	var info = '{';
	info += '"ShippingNo":"' + replaceSpecialCharacters($("#shipping-no").val()) + '",';
	info += '"DeliveryStock":"' + replaceSpecialCharacters($("#delivery-stock").val()) + '",';
	info += '"DeliveryDate":"' + replaceSpecialCharacters($("#delivery-date").val()) + '",';
	info += '"ServiceDeliveryId":"' + replaceSpecialCharacters($("#service-delivery-id").val()) + '",';
	var item = '[';
	var trs = $("#delivery-item tbody").find("tr");
	for (i = 0; i < trs.size(); i++) {
		item += '{';
		var inputs = trs.eq(i).find("input");
		for (j = 0; j < inputs.size(); j++) {
			item += '"' + inputs.eq(j).attr('key') + '":"' + replaceSpecialCharacters(inputs.eq(j).val())
					+ '",';
		}
		var selects = trs.eq(i).find("select");
		for (j = 0; j < selects.size(); j++) {
			item += '"' + selects.eq(j).attr('key') + '":"'
					+ replaceSpecialCharacters(selects.eq(j).val()) + '"';
			if (j < selects.size())
				item += ',';
		}
		if (i == trs.size())
			item += '}';
		else
			item += '},';
	}
	item += ']';
	info += 'ServiceDeliveryItemList:' + item;
	info += '}';
	$.ajax( {
		type : "POST",
		url : "deliveryServiceWaitByCspcAction.action",
		data : {
			serviceDeliveryInfo : info,
			crumb : $("#crumb").val()
		},
		success : function(msg) {
			if ($.trim(msg).length == 0)
				window.location.reload();
			else
				alert($.trim(unicodeToString(msg)));
		}
	});
}

function pageControlByScm(status) {
	$("#dialog").dialog("destroy");
	$("#dialog-form-backMemo").dialog( {
		autoOpen : false,
		height : 200,
		width : 350,
		modal : true,
		position: [550,'center'], //可以精确定位
		buttons : {
			'退回' : function() {
				deliveryBackApplyByScm();
				$(this).dialog('close');
			},
			'取消' : function() {
				$(this).dialog('close');
			}
		},
		close : function() {
			//allFields.val('').removeClass('ui-state-error');
		}
	});
	if (status == 'DELIVERY') {
		$("#shipping-no").attr("disabled", true);
		$("#delivery-stock").attr("disabled", true);
		$("#delivery-date").attr("disabled", true);
		$("#file-upload-form").remove();
		$("#delivery-button").remove();
		$("#wait-delivery-button").remove();
		$("#delivery-back-apply-button").remove();
		$("#delivery-date").parent().children(".ui-datepicker-trigger").remove();
	} else {
		$("#delivery-button").bind('click', function() {
			deliveryServiceConfirmByScm();
		});
		$("#wait-delivery-button").bind('click', function() {
			deliveryServiceWaitByScm();
		});
		
		$("#delivery-back-apply-button").bind('click', function() {
			$('#dialog-form-backMemo').dialog('open');
		});
	}
}
function pageControlByCspc(status) {
	$("#dialog").dialog("destroy");
	$("#dialog-form-backMemo").dialog( {
		autoOpen : false,
		height : 200,
		width : 350,
		modal : true,
		position: [550,'center'], //可以精确定位
		buttons : {
			'退回' : function() {
				deliveryBackApplyByCspc();
				$(this).dialog('close');
			},
			'取消' : function() {
				$(this).dialog('close');
			}
		},
		close : function() {
			//allFields.val('').removeClass('ui-state-error');
		}
	});
	if (status == 'DELIVERY') {
		$("#shipping-no").attr("disabled", true);
		$("#delivery-stock").attr("disabled", true);
		$("#delivery-date").attr("disabled", true);
		$("#file-upload-form").remove();
		$("#delivery-button").remove();
		$("#wait-delivery-button").remove();
		$("#delivery-back-apply-button").remove();
		$("#delivery-date").parent().children(".ui-datepicker-trigger").remove();
	} else {
		$("#delivery-button").bind('click', function() {
			deliveryServiceConfirmByCspc();
		});
		$("#wait-delivery-button").bind('click', function() {
			deliveryServiceWaitByCspc();
		});
		$("#delivery-back-apply-button").bind('click', function() {
			$('#dialog-form-backMemo').dialog('open');
		});
	}
}
function deliveryBackApplyByScm()
{
	var backMemo = replaceSpecialCharacters($("#back-memo").val());
	if($.trim(backMemo).length==0)
	{
		alert('请填写退回说明');
		return;
	}
	if(!confirm('是否要退回到审核?'))
		return;
	var deliveryServiceId = replaceSpecialCharacters($("#service-delivery-id").val());	
	$.ajax( {
		type : "POST",
		url : "deliveryServiceBackApplyAction.action",
		data : {
			serviceDeliveryId : deliveryServiceId,
			backMemo : backMemo,
			crumb : $("#crumb").val()
		},
		success : function(msg) {
			if ($.trim(msg).length == 0)
				location.href='deliveryByScmAction.action';
			else
				alert($.trim(unicodeToString(msg)));
		}
	});
}
function deliveryBackApplyByCspc()
{
	var backMemo = replaceSpecialCharacters($("#back-memo").val());
	if($.trim(backMemo).length==0)
	{
		alert('请填写退回说明');
		return;
	}
	if(!confirm('是否要退回到审核?'))
		return;
	var deliveryServiceId = replaceSpecialCharacters($("#service-delivery-id").val());
	$.ajax( {
		type : "POST",
		url : "deliveryServiceBackApplyAction.action",
		data : {
			serviceDeliveryId : deliveryServiceId,
			backMemo : backMemo,
			crumb : $("#crumb").val()
		},
		success : function(msg) {
			if ($.trim(msg).length == 0)
				location.href='deliveryByCspcAction.action';
			else
				alert($.trim(unicodeToString(msg)));
		}
	});
}
function deliveryFileUpload()
{
	var file = $("#upload-file").val();
	if($.trim(file).length==0)
	{
		alert('请选择上传文件');
		return;
	}
	$("#file-upload-form").submit();
}