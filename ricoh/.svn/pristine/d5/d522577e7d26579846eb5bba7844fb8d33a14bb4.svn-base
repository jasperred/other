function searchMachine(currentPage) {
	var machineNo = replaceSpecialCharacters($("#machine-no").val());
	var ppsNo = replaceSpecialCharacters($("#pps-no").val());
	var machineTypeId = replaceSpecialCharacters($("#machine-type-id").val());
	var fromOutDate = replaceSpecialCharacters($("#from-outdate").val());
	var endOutDate = replaceSpecialCharacters($("#end-outdate").val());
	var machineCd = replaceSpecialCharacters($("#machine-cd").val());
	var customerName = replaceSpecialCharacters($("#customer-name").val());

	$.ajax( {
		type : "POST",
		url : "searchMachineAction.action",
		data : {
			machineNo : machineNo,
			machineCd : machineCd,
			ppsNo : ppsNo,
			machineTypeId : machineTypeId,
			customerName : customerName,
			fromOutDate : fromOutDate,
			endOutDate : endOutDate,
			currentPage : currentPage,
			pageRow : 15
		},
		success : function(msg) {
			var tb = $("#machine-search-result tbody");
			var tb_page = $("#machine-search-page tbody");
			if ($.trim(msg).length > 0) {
				tb.html(msg);
				var page = getSearchPage("searchMachine");
				tb_page.html(page);
			} else {
				tb.html("");
				tb_page.html("<tr><td height='30' align='center'>未找到查询结果</td></tr>");
			}

		}
	});
}
function setMachineInfo(machineId, machineTypeId, machineCd, machineNo, ppsNo,
		serviceFromDate, serviceEndDate, outDate, invoiceDate, paymentStatus,
		paymentCompany, paymentCompanyCd, paymentDate, paymentAmt, lastTime,
		lastCompany, machineStatus, origin,customerName) {

	$("#machine-id").val(machineId);
	$("#machine-type-id").val(machineTypeId);
	$("#machine-cd").val(machineCd);
	$("#machine-no").val(machineNo);
	$("#pps-no").val(ppsNo);
	$("#service-from-date").val(serviceFromDate);
	$("#service-end-date").val(serviceEndDate);
	$("#outdate").val(outDate);
	$("#invoice-date").val(invoiceDate);
	$("#payment-status").val(paymentStatus);
	$("#payment-company").val(paymentCompany);
	$("#payment-company-cd").val(paymentCompanyCd);
	$("#payment-date").val(paymentDate);
	$("#payment-amt").val(paymentAmt);
	$("#last-time").val(lastTime);
	$("#last-company").val(lastCompany);
	$("#machine-status").val(machineStatus);
	$("#customer-name").val(customerName);
	if (origin == "IMPORT") {
		$("#machine-type-id").attr("disabled", true);
		$("#machine-no").attr("readonly", true);
		$("#pps-no").attr("readonly", true);
		$("#outdate").attr("readonly", true);
		$("#machine-no").attr("disabled", true);
		$("#pps-no").attr("disabled", true);
		$("#outdate").attr("disabled", true);
		$("#customer-name").attr("disabled", true);
		$("#outdate").parent().children(".ui-datepicker-trigger").remove();
	}
	else
	{
		$("#machine-type-id").combobox();		
	}
}
function saveMachine() {
	$("#message").html("");
	var check = false;
	var machineId = replaceSpecialCharacters($.trim($("#machine-id").val()));

	var machineCd = replaceSpecialCharacters($.trim($("#machine-cd").val()));
	var machineNo = replaceSpecialCharacters($.trim($("#machine-no").val()));
	if ($.trim(machineNo).length == 0) {
		$("#message").append("<li>请输入机号</li>");
		check = true;
	}
	var ppsNo = $.trim($("#pps-no").val());
	if ($.trim(ppsNo).length == 0) {
		$("#message").append("<li>请输入PPS号</li>");
		check = true;
	}
	var machineTypeId = $.trim($("#machine-type-id").val());
	if ($.trim(machineTypeId).length == 0) {
		$("#message").append("<li>请输入机型</li>");
		check = true;
	}
	var serviceFromDate = replaceSpecialCharacters($.trim($("#service-from-date").val()));
	var serviceEndDate = replaceSpecialCharacters($.trim($("#service-end-date").val()));
	var outDate = replaceSpecialCharacters($.trim($("#outdate").val()));
	if ($.trim(outDate).length == 0) {
		$("#message").append("<li>请输入出库日期</li>");
		check = true;
	}
	if($.trim(serviceFromDate).length>0)
	{
		if(!Date.before($.trim(outDate),$.trim(serviceFromDate)))
		{
			$("#message").append("<li>保修期起始日不能在出库日期之前</li>");
			check = true;
		}
	}
	if($.trim(serviceEndDate).length>0&&$.trim(serviceFromDate).length>0)
	{
		if(Date.before($.trim(serviceEndDate),$.trim(serviceFromDate)))
		{
			$("#message").append("<li>保修期结束日要在保修期起始日之后</li>");
			check = true;
		}
	}
	if(check)
		return;
	if($.trim(machineId)==0)
	{
		$.ajax( {
		type : "POST",
		url : "checkMachineNoAction.action",
		async : false,
		data : {
			machineNo : machineNo
		},
		success : function(msg) {
			if ($.trim(msg).length > 0) {
				$("#message").append("<li>"+msg+"</li>");
				check = true;
			}
		}
	});
	}
	
	var paymentStatus = replaceSpecialCharacters($("#payment-status").val());
	var paymentCompany = replaceSpecialCharacters($("#payment-company").val());
	var paymentCompanyCd = replaceSpecialCharacters($("#payment-company-cd").val());
	var paymentDate = replaceSpecialCharacters($("#payment-date").val());
	var paymentAmt = replaceSpecialCharacters($("#payment-amt").val());
	var customerName = replaceSpecialCharacters($("#customer-name").val());
	if (check)
		return;
	$.ajax( {
		type : "POST",
		url : "machineInfoSaveAction.action",
		data : {
			machineId : machineId,
			machineTypeId : machineTypeId,
			machineCd : machineCd,
			machineNo : machineNo,
			ppsNo : ppsNo,
			serviceFromDate : serviceFromDate,
			serviceEndDate : serviceEndDate,
			outDate : outDate,
			paymentStatus : paymentStatus,
			paymentCompany : paymentCompany,
			paymentCompanyCd : paymentCompanyCd,
			paymentDate : paymentDate,
			paymentAmt : paymentAmt,
			customerName : customerName,
			crumb : $("#crumb").val()
		},
		success : function(msg) {
			if ($.trim(msg).length > 0) {
				alert("保存成功");
				//location.href = "machineInfoAction.action?machineId="+ $.trim(msg);
				location.href = "viewMachineAction.action";
			} else
				alert(unicodeToString(msg));
		}
	});
}
