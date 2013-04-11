//页面初始化内容
function init() {
	//隐藏控制
	$("#order-info-banner").bind('click', function() {
		hideAndShow('order-info');
	});
	$("#order-status").hide();
	$("#order-status-banner").bind('click', function() {
		hideAndShow('order-status');
	});
	$("#order-fault").hide();
	$("#order-fault-button").hide();
	$("#order-fault-banner").bind('click', function() {
		hideAndShow('order-fault');
		hideAndShow('order-fault-button');
	});
	$("#order-parts").hide();
	$("#order-parts-button").hide();
	$("#order-parts-banner").bind('click', function() {
		hideAndShow('order-parts');
		hideAndShow('order-parts-button');
	});
	$("#order-machine").hide();
	$("#order-machine-banner").bind('click', function() {
		hideAndShow('order-machine');
	});
	$("#order-audited").hide();
	$("#order-audited-banner").bind('click', function() {
		hideAndShow('order-audited');
	});
	$("#order-shopmemo").hide();
	$("#order-shopmemo-banner").bind('click', function() {
		hideAndShow('order-shopmemo');
	});
	$("#order-result").hide();
	$("#order-result-banner").bind('click', function() {
		hideAndShow('order-result');
	});
	$("#order-file").hide();
	$("#order-file-upload").hide();
	$("#order-file-banner").bind('click', function() {
		hideAndShow('order-file');
		hideAndShow('order-file-upload');
	});
	//各种事件
	$("#save-order").bind('click', function() {
		location.href = "serviceInfoByShopAction.action";
	});
	$("#cancel-order").bind('click', function() {
		location.href = "viewMachineSearchByShopAction.action";
	});
	//整机或零件
	$("input[name='type-select']").click(function() {
		var item = $("input[name='type-select']:checked").val();
		if (item == 'machine') {
			$("#order-parts-banner").hide();
			$("#order-parts").hide();
			$("#order-parts-button").hide();
			$("#order-machine-banner").show();
			$("#order-machine").show();
		} else {
			$("#order-parts-banner").show();
			$("#order-parts").show();
			$("#order-parts-button").show();
			$("#order-machine-banner").hide();
			$("#order-machine").hide();
		}
	});
	$("#dialog").dialog("destroy");
	$("#dialog-form-fault").dialog( {
		autoOpen : false,
		height : 200,
		width : 350,
		modal : true,
		position: [550,'center'], //可以精确定位
		buttons : {
			'增加' : function() {
				addFault();
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
	$("#dialog-form-applyRate").dialog( {
		autoOpen : false,
		height : 300,
		width : 550,
		modal : true,
		buttons : {
			'申请费用' : function() {
				var c = serviceApplyRate();
				if(!c)
					return;
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
	//增加故障
	$("#add-fault-button").bind('click', function() {
		addFaultDialog();
	});
	//增加零件
	$("#add-part-button").bind('click', function() {
		addPart();
	});
}

//页面初始化内容
function initByRcn() {
	//隐藏控制
	$("#order-info-banner").bind('click', function() {
		hideAndShow('order-info');
	});
	$("#order-status").hide();
	$("#order-status-banner").bind('click', function() {
		hideAndShow('order-status');
	});
	$("#order-fault").hide();
	$("#order-fault-button").hide();
	$("#order-fault-banner").bind('click', function() {
		hideAndShow('order-fault');
		hideAndShow('order-fault-button');
	});
	$("#order-parts").hide();
	$("#order-parts-button").hide();
	$("#order-parts-banner").bind('click', function() {
		hideAndShow('order-parts');
		hideAndShow('order-parts-button');
	});
	$("#order-machine").hide();
	$("#order-machine-banner").bind('click', function() {
		hideAndShow('order-machine');
	});
	$("#order-audited").hide();
	$("#order-audited-banner").bind('click', function() {
		hideAndShow('order-audited');
	});
	$("#order-shopmemo").hide();
	$("#order-shopmemo-banner").bind('click', function() {
		hideAndShow('order-shopmemo');
	});
	$("#order-result").hide();
	$("#order-result-banner").bind('click', function() {
		hideAndShow('order-result');
	});
	$("#order-file").hide();
	$("#order-file-upload").hide();
	$("#order-file-banner").bind('click', function() {
		hideAndShow('order-file');
		hideAndShow('order-file-upload');
	});
}

//增加故障
function addFaultDialog() {
	$('#dialog-form-fault').dialog('open');
}
function addFault() {
	var fault = $("input[name='fault']:checked").val();
	var str;
	if (fault == 'symptom') {
		str = $("#symptom-tr").html();
	} else if (fault == 'cause') {
		str = $("#cause-tr").html();
	} else if (fault == 'action') {
		str = $("#action-tr").html();
	} else if (fault == 'location') {
		str = $("#location-tr").html();
	} else if (fault == 'target') {
		str = $("#target-tr").html();
	}
	$("#order-fault tbody").append('<tr>' + str + '</tr>');

}
//增加零件
function addPart() {
	var str = $("#part-tr").html();
	$("#order-parts tbody").append('<tr>' + str + '</tr>');
}

//故障父类选择
function faultParentSelect(s) {
	var parentNo = replaceSpecialCharacters(s.val());
	var select = s.parent().next("td").children().eq(0);
	if ($.trim(parentNo).length == 0) {
		select.html('<option></option>');
		select.trigger('onchange');
	} else {
		$.ajax( {
			type : "POST",
			url : "faultChildListAction.action",
			async : false,
			data : {
				faultType : replaceSpecialCharacters(s.attr("name")),
				parentNo : parentNo
			},
			success : function(msg) {

				select.html('<option></option>' + msg);
				select.trigger('onchange');
			}
		});
	}
}
//故障子类选择
function faultChildSelect(s) {
	var no = s.val();
	var mustMemo = s.find("option:selected").attr("must-memo");
	var memo = s.find("option:selected").attr("memo");
	var notext = s.next("input");
	var mustmemotext = notext.next("input");
	var memotext = mustmemotext.next("input");
	if ($.trim(no).length == 0) {
		notext.val('');
		mustmemotext.val('');
		memotext.val('');
		mustmemotext.hide();
		memotext.hide();
	} else {
		notext.val(no);
		if ($.trim(mustMemo) == 0) {
			mustmemotext.val('');
			memotext.val('');
			mustmemotext.hide();
			memotext.hide();
		} else {
			mustmemotext.val(memo);
			memotext.val('');
			mustmemotext.show();
			memotext.show();
		}
	}
}
//零件选择
function partSelect(ps)
{
	if($.trim(ps.val())=='主机')
	{
		var ss = $("#order-parts tbody").find('select');
		var i = 0;
		for(j=0;j<ss.size();j++)
		{
			if($.trim(ss.eq(j).val())=='主机')
				i++;
		}
		if(i>=2)
		{
			alert('主机只能选择一次');
			ps.val('');
			return;
		}
		//2012.4.16 检查如果选择了主机，维修区分则必须是'建议换货'
		var serviceType = $("#service-type");
		if(serviceType.val()!='ON_CHANGE')
		{
			serviceType.val('ON_CHANGE');
			alert('因选择主机，维修区分自动设置为[建议换货]');
		}
		var ts = ps.parent().parent().find('input[type=text]');
		for(j=0;j<ts.size();j++)
		{
			if(ts.eq(j).attr('key')=='ItemName')
			{
				ts.eq(j).val($("#machine-type-name").val());
				ts.eq(j).attr('disabled',true);
			}
			if(ts.eq(j).attr('key')=='ItemNo')
			{
				ts.eq(j).val($("#machine-cd").val());
				ts.eq(j).attr('disabled',true);
			}
			if(ts.eq(j).attr('key')=='ItemQty')
			{
				ts.eq(j).val('1');
				ts.eq(j).attr('disabled',true);
			}
		}
	}
	else
	{
		var ts = ps.parent().parent().find('input[type=text]');
		for(j=0;j<ts.size();j++)
		{
			ts.eq(j).attr('disabled',false);
		}
	}
}

//设置信息
function setOrderInfo(serviceInfoMap) {
	$("#service-id").val(serviceInfoMap.get('serviceId'));
	$("#service-type").val(serviceInfoMap.get('serviceType'));
	$("#service-no").val(serviceInfoMap.get('serviceNo'));
	$("#machine-no").val(serviceInfoMap.get('machineNo'));
	$("#company-name").val(serviceInfoMap.get('companyName'));
	$("#machine-type-name").val(serviceInfoMap.get('machineTypeName'));
	if (serviceInfoMap.get('machineTypeCat') == '黑白机') {
		$("#plate-number").attr('disabled', true);
		$("#color-number").attr('disabled', true);
	}
	if (serviceInfoMap.get('machineTypeCat') == '彩色机') {
		$("#plate-number").attr('disabled', true);
	}
	if (serviceInfoMap.get('machineTypeCat') == '数码印刷机') {
		$("#color-number").attr('disabled', true);
	}
	$("#machine-cd").val(serviceInfoMap.get('machineCd'));
	$("#service-date-status").val(serviceInfoMap.get('serviceDateStatus'));
	$("#service-end-date").val(serviceInfoMap.get('serviceEndDate'));
	$("#invoice-date").val(serviceInfoMap.get('invoiceDate'));
	$("#service-date").val(serviceInfoMap.get('serviceDate'));
	$("#service-expected-finish-date").val(serviceInfoMap.get('serviceExpectedFinishDate'));
	$("#from-date").val(serviceInfoMap.get('fromDate'));
	$("#end-date").val(serviceInfoMap.get('endDate'));
	$("#service-method").val(serviceInfoMap.get('serviceMethod'));
	$("#service-contract").val(serviceInfoMap.get('serviceContract'));
	$("#service-operation").val(serviceInfoMap.get('serviceOperation'));
	$("#black-white-number").val(serviceInfoMap.get('blackWhiteNumber'));
	$("#color-number").val(serviceInfoMap.get('colorNumber'));
	$("#plate-number").val(serviceInfoMap.get('plateNumber'));
	if (serviceInfoMap.get('partOrMachine') == 'machine') {
		$("#part-type-select").attr("checked", false);
		$("#machine-type-select").attr("checked", true);
		$("#order-parts-banner").hide();
		$("#order-machine-banner").show();
	} else {
		$("#part-type-select").attr("checked", true);
		$("#machine-type-select").attr("checked", false);
		$("#order-machine-banner").hide();
		$("#order-part-banner").show();
	}
	//设置后隐藏零件或整机
	$("#order-parts").hide();
	$("#order-parts-button").hide();
	$("#order-machine").hide();
	$("#order-machine-button").hide();
	$("#machine-memo").val(serviceInfoMap.get('michaneMemo'));
	$("#customer-company").val(serviceInfoMap.get('customerCompany'));
	$("#customer-no").val(serviceInfoMap.get('customerNo'));
	$("#customer-zip").val(serviceInfoMap.get('customerZip'));
	$("#customer-name").val(serviceInfoMap.get('customerName'));
	$("#customer-tel").val(serviceInfoMap.get('customerTel'));
	$("#customer-address1").val(serviceInfoMap.get('customerAddress1'));
	$("#customer-address2").val(serviceInfoMap.get('customerAddress2'));
	$("#customer-address3").val(serviceInfoMap.get('customerAddress3'));
	$("#customer-address4").val(serviceInfoMap.get('customerAddress4'));
	$("#customer-address5").val(serviceInfoMap.get('customerAddress5'));
	$("#last-time").val(serviceInfoMap.get('lastDate'));
	$("#create-name").val(serviceInfoMap.get('createName'));
	$("#create-time").val(serviceInfoMap.get('createTime'));
	//机器相关信息 2012-08-16
	$("#machine-payment-status").val(serviceInfoMap.get('machinePaymentStatus'));
	$("#machine-payment-company").val(serviceInfoMap.get('machinePaymentCompany'));
	$("#machine-payment-date").val(serviceInfoMap.get('machinePaymentDate'));
	//销售日期
	if ($.trim(serviceInfoMap.get('invoiceDate')).length == 0
			|| $.trim(serviceInfoMap.get('serviceFromDate')) > $
					.trim(serviceInfoMap.get('invoiceDate'))
			|| $.trim(serviceInfoMap.get('outDate')) > $.trim(serviceInfoMap
					.get('invoiceDate'))) {
		$("#invoice-date").attr("disabled", false);
	} else {
		$("#invoice-date").attr("disabled", true);
	}

}
//按钮控制
function buttonControl(serviceStatusMap) {
		
		$("#file-upload-button").bind('click', function() {
			fileUpload(serviceStatusMap.get('outDate'));
		});
		$("#print-service-order-button").bind('click', function() {
			pringServiceOrder(serviceStatusMap.get('serviceId'));
		});
	//已取消状态控制
	//if(serviceStatusMap.get('serviceStatus') == 'CANCEL')
	//{
	//	$("#print-service-order-button").remove();
	//	$("#file-upload-form").remove();
	//}

	//可保存和取消控制，维修状态：修理中；申请零件状态：未申请；申请主机状态：未申请
	//维修完成不可用
	if (serviceStatusMap.get('serviceStatus') == 'REPAIRING'
			&& ((serviceStatusMap.get('applyPartStatus') == 'NO_APPLY')
			&&(serviceStatusMap.get('applyMachineStatus') == 'NO_APPLY'))) {
		$("#service-info-save-button").bind('click', function() {
			saveServiceOrderInfo();
		});
		$("#service-order-cancel-button").bind('click', function() {
			cancelServiceOrder();
		});
	}
	else
	{
			
		//$("#invoice-date").parent().children(".ui-datepicker-trigger").remove();
		//$("#service-date").parent().children(".ui-datepicker-trigger").remove();		
		//$("#from-date").parent().children(".ui-datepicker-trigger").remove();		
		//$("#end-date").parent().children(".ui-datepicker-trigger").remove();
		//零件重新审核时可增加零件
		if((serviceStatusMap.get('applyPartStatus') != 'RE_APPLY'))
			$("#add-part-button").remove();
		//已经进行过申请，不通过时只能修改[主机/零件/选购件或耗材]内容
		 if(serviceStatusMap.get('serviceStatus') == 'REPAIRING'
				&& ( serviceStatusMap.get('applyPartStatus') == 'RE_APPLY'|| serviceStatusMap.get('applyMachineStatus') == 'RE_APPLY'))
		{
			//维修区分可修改
			 $('#service-type').attr('disabled',false);
			 $('#from-date').attr('disabled',false);
			 $('#end-date').attr('disabled',false);
			 $('#service-expected-finish-date').attr('disabled',false);
			 $('#service-method').attr('disabled',false);
			 $('#service-contract').attr('disabled',false);
			 $('#service-operation').attr('disabled',false);
			 if (serviceStatusMap.get('machineTypeCat') == '黑白机') {
				$("#plate-number").attr('disabled', true);
				$("#color-number").attr('disabled', true);
			}
			if (serviceStatusMap.get('machineTypeCat') == '彩色机') {
				$("#plate-number").attr('disabled', true);
			}
			if (serviceStatusMap.get('machineTypeCat') == '数码印刷机') {
				$("#color-number").attr('disabled', true);
			}
			 $('#machine-memo').attr('disabled',false);
			 $('#customer-company').attr('disabled',false);
			 $('#customer-no').attr('disabled',false);
			 $('#customer-zip').attr('disabled',false);
			 $('#customer-name').attr('disabled',false);
			 $('#customer-tel').attr('disabled',false);
			 $('#customer-address1').attr('disabled',false);
			 $('#customer-address2').attr('disabled',false);
			 $('#customer-address3').attr('disabled',false);
			 $('#customer-address4').attr('disabled',false);
			 $('#customer-address5').attr('disabled',false);
			 $('#memo').attr('disabled',false);
			//判断主机和零件是否可修改
			var trs = $("#order-parts tbody").find('tr');
			//主机
			if( serviceStatusMap.get('applyMachineStatus') == 'RE_APPLY')
			{
				for(i=0;i<trs.size();i++)
				{
					var itemCateSelect = trs.eq(i).find("select[key=ItemCate]");
					if(itemCateSelect.val()=='主机'||itemCateSelect.val()=='选购件或耗材')
					{
						trs.eq(i).find("select[key=ItemCate]").attr('disabled',true);
						trs.eq(i).find("select[key=ItemStatus]").attr('disabled',false);
						if(itemCateSelect.val()=='选购件或耗材')
							trs.eq(i).find("input[key=ItemNo]").attr('disabled',false);
						if(itemCateSelect.val()=='选购件或耗材')
							trs.eq(i).find("input[key=ItemName]").attr('disabled',false);
						if(itemCateSelect.val()=='选购件或耗材')
							trs.eq(i).find("input[key=ItemQty]").attr('disabled',false);
						trs.eq(i).find("input[key=ItemSerialNo]").attr('disabled',false);
						continue;
					}
				}
			}
			else
			{
				for(i=0;i<trs.size();i++)
				{
					var itemCateSelect = trs.eq(i).find("select[key=ItemCate]");
					if(itemCateSelect.val()=='主机'||itemCateSelect.val()=='选购件或耗材')
					{
						trs.eq(i).find("select[key=ItemCate]").attr('disabled',true);
						trs.eq(i).find("select[key=ItemStatus]").attr('disabled',true);
						trs.eq(i).find("input[key=ItemNo]").attr('disabled',true);
						trs.eq(i).find("input[key=ItemName]").attr('disabled',true);
						trs.eq(i).find("input[key=ItemQty]").attr('disabled',true);
						trs.eq(i).find("input[key=ItemSerialNo]").attr('disabled',true);						
					}
					else
					{
						itemCateSelect.find('option:eq(2)').remove();
						itemCateSelect.find('option:eq(2)').remove();
					}
				}
			}
			//零件
			if(serviceStatusMap.get('applyPartStatus') == 'RE_APPLY')
			{
				for(i=0;i<trs.size();i++)
				{
					var itemCateSelect = trs.eq(i).find("select[key=ItemCate]");
					if(itemCateSelect.val()=='零件'||itemCateSelect.val()=='')
					{
						trs.eq(i).find("select[key=ItemCate]").attr('disabled',false);
						trs.eq(i).find("select[key=ItemStatus]").attr('disabled',false);
						trs.eq(i).find("input[key=ItemNo]").attr('disabled',false);
						trs.eq(i).find("input[key=ItemName]").attr('disabled',false);
						trs.eq(i).find("input[key=ItemQty]").attr('disabled',false);
						trs.eq(i).find("input[key=ItemSerialNo]").attr('disabled',false);
					}
				}
			}
			else
			{
				for(i=0;i<trs.size();i++)
				{
					var itemCateSelect = trs.eq(i).find("select[key=ItemCate]");
					if(itemCateSelect.val()=='零件')
					{
						trs.eq(i).find("select[key=ItemCate]").attr('disabled',true);
						trs.eq(i).find("select[key=ItemStatus]").attr('disabled',true);
						trs.eq(i).find("input[key=ItemNo]").attr('disabled',true);
						trs.eq(i).find("input[key=ItemName]").attr('disabled',true);
						trs.eq(i).find("input[key=ItemQty]").attr('disabled',true);
						trs.eq(i).find("input[key=ItemSerialNo]").attr('disabled',true);
					}
					else
					{
						itemCateSelect.find('option:eq(1)').remove();						
					}
				}
			}
			$("#service-info-save-button").bind('click', function() {
				//saveServiceOrderItemInfo();
				saveServiceOrderInfo();
			});
			//$("#service-order-cancel-button").remove();
			//未申请主机情况下可取消维修单
			if(serviceStatusMap.get('applyMachineStatus') == 'NO_APPLY')
			{
				$("#service-order-cancel-button").bind('click', function() {
					cancelServiceOrder();
				});
			}
		}
		 //其它情况
		else {	
			
			$("#add-fault-button").remove();
			//控制不可录入  2012-06-25 控制审核不通过时可修改
			var ins = $('body').find('input[type=text]');
			var ss = $('body').find('select');
			var areas = $('body').find('textarea');
			for(i=0;i<ins.size();i++)
			{
				if(ins.eq(i).attr('readonly'))
					continue;
				ins.eq(i).attr('disabled',true);
			}
			for(i=0;i<ss.size();i++)
			{
				ss.eq(i).attr('disabled',true);
			}
			for(i=0;i<areas.size();i++)
			{
				areas.eq(i).attr('disabled',true);
			}	
			$("#service-info-save-button").remove();
			$("#service-order-cancel-button").remove();
			//非维修和建议换货申请后不能上传
			if(!(serviceStatusMap.get('serviceType').length==0||serviceStatusMap.get('serviceType') == 'SERVICE_ORDER'||serviceStatusMap.get('serviceType') == 'ON_CHANGE'))
			{
				$("#file-upload-form").remove();
				$("#print-service-order-button").remove();
			}
			else
			{
				//维修和建议换货结算完成前都可上传
				if(serviceStatusMap.get('applyRateStatus') == 'INVOICE_COMPLETE')
				{
					$("#print-service-order-button").remove();
					$("#file-upload-form").remove();
				}
			}
		}		
	}
	$("#upload-type").attr('disabled',false);
	
	//零件申请和整机申请,不通过状态不显示维修申请
	if (serviceStatusMap.get('serviceStatus') == 'REPAIRING'
			&& (serviceStatusMap.get('applyPartStatus') == 'NO_APPLY')
			&& (serviceStatusMap.get('applyMachineStatus') == 'NO_APPLY')) {
		$("#apply-button").bind('click', function() {
			serviceApply();
		});
	} else {
		$("#apply-button").remove();
	}
	//费用申请,维修和建议换货可以费用申请
	if (serviceStatusMap.get('serviceStatus') == 'REPAIR_COMPLETE'&&serviceStatusMap.get('applyRateStatus') == 'NO_APPLY'&&(serviceStatusMap.get('serviceType') == 'SERVICE_ORDER'||serviceStatusMap.get('serviceType') == 'ON_CHANGE')) {
		$("#apply-home-rate").attr('disabled',false);
		$("#apply-other-rate").attr('disabled',false);
		$("#apply-other-rate-memo").attr('disabled',false);
		$("#rate-apply-button").bind('click', function() {
			serviceApplyRateDialog();
		});
	} else {
		$("#rate-apply-button").remove();
	}
	//维修完成
	
	if ((serviceStatusMap.get('applyPartStatus') == 'NO_APPLY'||serviceStatusMap.get('applyPartStatus') == 'USE_INV'
		|| serviceStatusMap.get('applyPartStatus') == 'WAIT_DELIVERY'|| serviceStatusMap.get('applyPartStatus') == 'DELIVERY')
			&&( serviceStatusMap.get('applyMachineStatus') == 'NO_APPLY'||serviceStatusMap.get('applyMachineStatus') == 'USE_INV'
			|| serviceStatusMap.get('applyMachineStatus') == 'DELIVERY')&&!(serviceStatusMap.get('applyMachineStatus') == 'NO_APPLY'&&serviceStatusMap.get('applyPartStatus') == 'NO_APPLY')) {
		$("#service-finish-date").attr('disabled',true);
		$("#customer-retrieve-date").attr('disabled',false);
		$("#fix-people").attr('disabled',false);
		$("#service-finish-button").bind('click', function() {
			finishServiceOrder();
		});
	} else {
		$("#service-finish-button").remove();
		$("#service-finish-date").attr('disabled',true);
		$("#customer-retrieve-date").attr('disabled',true);
		$("#fix-people").attr('disabled',true);
		//$("#service-finish-date").parent().children(".ui-datepicker-trigger").remove();		
		//$("#customer-retrieve-date").parent().children(".ui-datepicker-trigger").remove();
	}
	if(serviceStatusMap.get('serviceStatus') == 'REPAIR_COMPLETE')
	{
		$("#service-finish-button").remove();
	}
}
//设置维修单状态
function setOrderStatus(serviceStatusMap) {
	$("#service-status-no").val(serviceStatusMap.get('serviceStatus'));
	$("#service-status-name").val(serviceStatusMap.get('serviceStatusName'));
	$("#apply-part-status-no").val(serviceStatusMap.get('applyPartStatus'));
	$("#apply-part-status-name").val(
			serviceStatusMap.get('applyPartStatusName'));
	$("#apply-machine-status-no").val(
			serviceStatusMap.get('applyMachineStatus'));
	$("#apply-machine-status-name").val(
			serviceStatusMap.get('applyMachineStatusName'));
	$("#apply-rate-status-no").val(serviceStatusMap.get('applyRateStatus'));
	$("#apply-rate-status-name").val(
			serviceStatusMap.get('applyRateStatusName'));
	$("#visit-status-no").val(serviceStatusMap.get('visitStatus'));
	$("#visit-status-name").val(serviceStatusMap.get('visitStatusName'));
	$("#visit-result").val(serviceStatusMap.get('visitResult'));
}
//设置维修结果
function setOrderResult(serviceResultMap) {
	$("#service-finish-date").val(serviceResultMap.get('serviceFinishDate'));
	$("#customer-retrieve-date").val(
			serviceResultMap.get('customerRetrieveDate'));
	$("#fix-people").val(serviceResultMap.get('fixPeople'));
	$("#thru-time").val(serviceResultMap.get('thruTime'));
	$("#response-time").val(serviceResultMap.get('responseTime'));
	$("#move-time").val(serviceResultMap.get('moveTime'));
	$("#service-amt").val(serviceResultMap.get('serviceAmt'));
	$("#home-amt").val(serviceResultMap.get('homeAmt'));
	$("#part-amt").val(serviceResultMap.get('partsAmt'));
	$("#consumables-amt").val(serviceResultMap.get('consumablesAmt'));
	$("#other-amt").val(serviceResultMap.get('otherAmt'));
	$("#other-amt-memo").val(serviceResultMap.get('otherAmtMemo'));
	$("#memo").val(serviceResultMap.get('memo'));
	$("#apply-tec-rate").val(serviceResultMap.get('applyTecRate'));
	//$("#apply-home-rate").val(serviceResultMap.get('applyHomeRate'));
	//$("#apply-other-rate").val(serviceResultMap.get('applyOtherRate'));
	//$("#apply-other-rate-memo").val(serviceResultMap.get('applyOtherRateMemo'));
}
//维修单保存
function saveServiceOrderInfo() {
	var info = getServiceOrderInfo();
	if($.trim(info).length==0)
		return;
	$.ajax( {
		type : "POST",
		url : "saveServiceInfoByShopAction.action",
		data : {
			serviceOrderInfo : info,
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

//维修单保存
function saveServiceOrderItemInfo() {
	var info = '{';
	//维修单信息
	info += '"ServiceId":"' + replaceSpecialCharacters($("#service-id").val()) + '",';
	//零件或整机
	var pm = '[';
	
	{
		var ptrs = $("#order-parts tbody").find("tr");
		for (i = 0; i < ptrs.size(); i++) {
			if (ptrs.eq(i).css("display") == "none")
				continue;
			var itemCateSelect = ptrs.eq(i).find("select[key=ItemCate]");
			//只保存可修改内容,通过ItemStatus判断
			if(ptrs.eq(i).find("select[key=ItemStatus]").attr('disabled'))
				continue;
			pm += "{";
			var serviceItemId = ptrs.eq(i).attr("service-item-id");
			if (serviceItemId == undefined)
				serviceItemId = '';
			pm += '"ServiceItemId":"' + serviceItemId + '"';
			//pm+='"ItemType":"'+type+'"';
			//分类和状态
			var ss = ptrs.eq(i).find("select");
			for (j = 0; j < ss.size(); j++) {
				pm += ',"' + ss.eq(j).attr("key") + '":"' + replaceSpecialCharacters(ss.eq(j).val())
						+ '"';
			}
			//编号、名称、数量、零件序列号
			var ins = ptrs.eq(i).find("input");
			if($.trim(ins.eq(0).val()).length>0)
			{
				if($.trim(ins.eq(2).val()).length==0)
				{
					alert("[主机/零件/选购件或耗材]第"+i+"行未填写数量");
					return '';
				}
			}
			for (j = 0; j < ins.size(); j++) {
				pm += ',"' + ins.eq(j).attr("key") + '":"' + replaceSpecialCharacters(ins.eq(j).val())
						+ '"';
			}
			if (i < ptrs.size() - 1)
				pm += "},";
			else
				pm += "}";
		}
	}
	pm += ']';
	info += '"PartOrMachineList":' + pm;
	info += "}";
	if($.trim(info).length==0)
		return;
	$.ajax( {
		type : "POST",
		url : "saveServiceItemInfoByShopAction.action",
		data : {
			serviceOrderItemInfo : info,
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
function getServiceOrderInfo()
{
	var info = '{';
	//维修单信息
	info += '"ServiceId":"' + replaceSpecialCharacters($("#service-id").val()) + '",';
	info += '"ServiceType":"' + replaceSpecialCharacters($("#service-type").val()) + '",';
	info += '"ServiceDate":"' + replaceSpecialCharacters($("#service-date").val()) + '",';
	info += '"FromDate":"' + replaceSpecialCharacters($("#from-date").val()) + '",';
	info += '"EndDate":"' + replaceSpecialCharacters($("#end-date").val()) + '",';
	info += '"ServiceMethod":"' + replaceSpecialCharacters($("#service-method").val()) + '",';
	info += '"ServiceContract":"' + replaceSpecialCharacters($("#service-contract").val()) + '",';
	info += '"ServiceOperation":"' + replaceSpecialCharacters($("#service-operation").val()) + '",';
	info += '"BlackWhiteNumber":"' + replaceSpecialCharacters($("#black-white-number").val()) + '",';
	info += '"ColorNumber":"' + replaceSpecialCharacters($("#color-number").val()) + '",';
	info += '"PlateNumber":"' + replaceSpecialCharacters($("#plate-number").val()) + '",';	
	info += '"ServiceExpectedFinishDate":"' + replaceSpecialCharacters($("#service-expected-finish-date").val()) + '",';
	var machineMemo = replaceSpecialCharacters($("#machine-memo").val());
	info += '"MachineMemo":"' + machineMemo + '",';
	info += '"CustomerCompany":"' + replaceSpecialCharacters($("#customer-company").val()) + '",';
	info += '"CustomerNo":"' + replaceSpecialCharacters($("#customer-no").val()) + '",';
	info += '"CustomerZip":"' + replaceSpecialCharacters($("#customer-zip").val()) + '",';
	info += '"CustomerAddress1":"' + replaceSpecialCharacters($("#customer-address1").val()) + '",';
	info += '"CustomerAddress2":"' + replaceSpecialCharacters($("#customer-address2").val()) + '",';
	info += '"CustomerAddress3":"' + replaceSpecialCharacters($("#customer-address3").val()) + '",';
	info += '"CustomerAddress4":"' + replaceSpecialCharacters($("#customer-address4").val()) + '",';
	info += '"CustomerAddress5":"' + replaceSpecialCharacters($("#customer-address5").val()) + '",';
	info += '"CustomerName":"' + replaceSpecialCharacters($("#customer-name").val()) + '",';
	info += '"CustomerTel":"' + replaceSpecialCharacters($("#customer-tel").val()) + '",';
	info += '"ServiceAmt":"' + replaceSpecialCharacters($("#service-amt").val()) + '",';
	info += '"HomeAmt":"' + replaceSpecialCharacters($("#home-amt").val()) + '",';
	info += '"PartsAmt":"' + replaceSpecialCharacters($("#part-amt").val()) + '",';
	info += '"ConsumablesAmt":"' + replaceSpecialCharacters($("#consumables-amt").val()) + '",';
	info += '"OtherAmt":"' + replaceSpecialCharacters($("#other-amt").val()) + '",';
	info += '"OtherAmtMemo":"' + replaceSpecialCharacters($("#other-amt-memo").val()) + '",';
	info += '"ServiceFinishDate":"' + replaceSpecialCharacters($("#service-finish-date").val()) + '",';
	info += '"FixPeople":"' + replaceSpecialCharacters($("#fix-people").val()) + '",';
	info += '"CustomerRetrieveDate":"' + replaceSpecialCharacters($("#customer-retrieve-date").val()) + '",';
	info += '"Memo":"' + replaceSpecialCharacters($("#memo").val()) + '",';
	info += '"ApplyHomeRate":"' + replaceSpecialCharacters($("#apply-tec-rate").val()) + '",';
	info += '"ApplyOtherRate":"' + replaceSpecialCharacters($("#apply-home-rate").val()) + '",';
	info += '"ApplyOtherRateMemo":"' + replaceSpecialCharacters($("#apply-other-rate").val()) + '",';
	//维修故障
	var fault = '[';
	var faultTrs = $("#order-fault tbody").find("tr");
	for (i = 0; i < faultTrs.size(); i++) {
		if (faultTrs.eq(i).css("display") == "none")
			continue;
		var faultId = faultTrs.eq(i).attr("fault-id");
		fault += '{';
		if (faultId == undefined)
			faultId = '';
		fault += '"ServiceFaultId":"' + faultId + '",';

		var fcns = faultTrs.eq(i).find("select");
		for (j = 0; j < fcns.size(); j++) {
			if (fcns.eq(j).attr("key") == 'FaultCateNo') {
				fault += '"FaultCateNo":"' + replaceSpecialCharacters(fcns.eq(j).val()) + '",';
				fault += '"FaultType":"' + fcns.eq(j).attr('name') + '",';
			}
			if (fcns.eq(j).attr("key") == 'FaultName') {
				fault += '"FaultNo":"' + replaceSpecialCharacters(fcns.eq(j).val()) + '",';
				fault += '"FaultName":"' + $.trim(fcns.eq(j).find(
						'option:selected').text()) + '",';
				fault += '"MustMemo":"' + fcns.eq(j).find('option:selected')
						.attr('must-memo') + '",';
				fault += '"Memo":"' + fcns.eq(j).find('option:selected').attr(
						'memo') + '",';
			}
		}
		var fcnt = faultTrs.eq(i).find("input");
		for (j = 0; j < fcnt.size(); j++) {
			if (fcnt.eq(j).attr("key") == 'Content') {
				fault += '"Content":"' + replaceSpecialCharacters(fcnt.eq(j).val()) + '"';
			}
		}
		if (i < faultTrs.size() - 1)
			fault += '},';
		else
			fault += '}';
	}
	fault += '],';
	info += '"FaultList":' + fault;
	//零件或整机
	var pm = '[';
	
	{
		var ptrs = $("#order-parts tbody").find("tr");
		for (i = 0; i < ptrs.size(); i++) {
			if (ptrs.eq(i).css("display") == "none")
				continue;
			pm += "{";
			var serviceItemId = ptrs.eq(i).attr("service-item-id");
			if (serviceItemId == undefined)
				serviceItemId = '';
			pm += '"ServiceItemId":"' + serviceItemId + '"';
			//pm+='"ItemType":"'+type+'"';
			//分类和状态
			var ss = ptrs.eq(i).find("select");
			for (j = 0; j < ss.size(); j++) {
				pm += ',"' + ss.eq(j).attr("key") + '":"' + replaceSpecialCharacters(ss.eq(j).val())
						+ '"';
			}
			//编号、名称、数量、零件序列号
			var ins = ptrs.eq(i).find("input");
			if($.trim(ins.eq(0).val()).length>0)
			{
				if($.trim(ins.eq(2).val()).length==0)
				{
					alert("[主机/零件/选购件或耗材]第"+i+"行未填写数量");
					return '';
				}
			}
			for (j = 0; j < ins.size(); j++) {
				pm += ',"' + ins.eq(j).attr("key") + '":"' + replaceSpecialCharacters(ins.eq(j).val())
						+ '"';
			}
			if (i < ptrs.size() - 1)
				pm += "},";
			else
				pm += "}";
		}
	}
	pm += ']';
	info += '"PartOrMachineList":' + pm;
	info += "}";
	return info;
}
//取消维修单
function cancelServiceOrder() {
	if (!confirm("取消维修单后不可恢复,是否确定要取消该维修单?"))
		return;
	var serviceId = replaceSpecialCharacters($("#service-id").val());
	$.ajax( {
		type : "POST",
		url : "cancelServiceByShopAction.action",
		data : {
			serviceId : serviceId,
			crumb : $("#crumb").val()
		},
		success : function(msg) {
			if ($.trim(msg).length == 0)
				window.location.reload();
			else
				alert(unicodeToString($.trim(msg)));
		}
	});
}
//完成维修单
function finishServiceOrder() {
	if (!confirm("是否确定要完成该维修单?"))
		return;
	var serviceId = replaceSpecialCharacters($("#service-id").val());
	var serviceFinishDate = replaceSpecialCharacters($("#service-finish-date").val());
	var customerRetrieveDate = replaceSpecialCharacters($("#customer-retrieve-date").val());
	var serviceDate = replaceSpecialCharacters($("#service-date").val());
	var fixPeople = replaceSpecialCharacters($("#fix-people").val());
//	if($.trim(serviceFinishDate).length==0)
//	{
//		alert('请填写修理完成日期');
//		return;
//	}
	var date  = new Date();
	if($.trim(customerRetrieveDate).length==0)
	{
		alert('请填写用户取回机器日期');
		return;
	}
	if($.trim(fixPeople).length==0)
	{
		alert('请填写维修人姓名');
		return;
	}
//	if(!Date.before($.trim(serviceDate),$.trim(serviceFinishDate)))
//	{
//		alert("修理完成日期不能早于维修受理日期");
//		return;
//	}
//	if(!Date.before($.trim(serviceFinishDate),$.trim(customerRetrieveDate)))
//	{
//		alert("用户取回机器日期不能早于修理完成日期");
//		return;
//	}
	if(!Date.before($.trim(customerRetrieveDate),date))
	{
		alert("用户取回机器日期不能晚于当天日期");
		return;
	}
	$.ajax( {
		type : "POST",
		url : "finishServiceOrderAction.action",
		data : {
			serviceId : serviceId,
			serviceFinishDate:serviceFinishDate,
			customerRetrieveDate:customerRetrieveDate,
			fixPeople:fixPeople,
			crumb : $("#crumb").val()
		},
		success : function(msg) {
			if ($.trim(msg).length == 0)
				window.location.reload();
			else
				alert(unicodeToString($.trim(msg)));
		}
	});
}
//文件上传
function fileUpload(outDate) {
	var fileType = $("#upload-type").val();
	if ($.trim(fileType).length == 0) {
		alert("请选择上传类型");
		return;
	}
	var file = $("#upload-file").val();
	if($.trim(file).length==0)
	{
		alert('请选择上传文件');
		return;
	}
	if ($.trim(fileType) == "发票") {
		if(!confirm('请确认销售日期是否正确,发票扫描件上传后将不能修改,是否上传?'))
			return;
		if ($("#invoice-date").attr("disabled")) {
			alert("发票不能上传");
			return;
		} else {
			if ($.trim($("#invoice-date").val()).length == 0) {
				alert("请填写销售日期");
				return;
			}
			if(Date.isSimpleDate($.trim($("#invoice-date").val()))==null)
			{
				alert("日期格式错误");
				return;
			}
			//发票日期判断，销售日期晚于出库日期，早于当天
			if(Date.before($.trim($("#invoice-date").val()),outDate))
			{
				alert("销售日期不能早于出库日期");
				return;
			}
			var date  = new Date();
			if(Date.before(date,$.trim($("#invoice-date").val())))
			{
				alert("销售日期要早于当天日期");
				return;
			}
			
			$("#file-upload-invoice-date")
					.val($.trim($("#invoice-date").val()));
		}
	}
	$("#file-upload-invoice-date")
					.val($.trim($("#invoice-date").val()));
	//上传时先保存
	var info = getServiceOrderInfo();
	if($.trim(info).length==0)
		return;
	$.ajax( {
		type : "POST",
		url : "saveServiceInfoByShopAction.action",
		data : {
			serviceOrderInfo : info
		},
		success : function(msg) {
			$("#file-upload-form").submit();
		}
	});
}
//维修申请
function serviceApply() {
	if(!$("#invoice-date").attr('disabled')&&$.trim($("#invoice-date").val()).length>0)
	{
		alert('请上传发票扫描件');
		return;
	}
	if (!confirm('是否确认进行维修申请'))
		return;
	//检查信息是否完整
	var serviceType = replaceSpecialCharacters($("#service-type").val());
	var serviceDate = replaceSpecialCharacters($("#service-date").val());
	var endDate = replaceSpecialCharacters($("#end-date").val());
	var serviceExpectedFinishDate = replaceSpecialCharacters($("#service-expected-finish-date").val());
	var serviceMethod = replaceSpecialCharacters($("#service-method").val());
	var serviceContract = replaceSpecialCharacters($("#service-contract").val());
	var serviceOperation = replaceSpecialCharacters($("#service-operation").val());
	var blackWhiteNumber = replaceSpecialCharacters($("#black-white-number").val());
	var customerCompany = replaceSpecialCharacters($("#customer-company").val());
	var customerName = replaceSpecialCharacters($("#customer-name").val());
	var customerTel = replaceSpecialCharacters($("#customer-tel").val());
	var customerAddress1 = replaceSpecialCharacters($("#customer-address1").val());
	var customerAddress2 = replaceSpecialCharacters($("#customer-address2").val());
	var customerAddress3 = replaceSpecialCharacters($("#customer-address3").val());
	var customerAddress4 = replaceSpecialCharacters($("#customer-address4").val());
	var customerAddress5 = replaceSpecialCharacters($("#customer-address5").val());
	if($.trim(serviceType).length==0)
	{
		alert('请选择维修区分');
		return;
	}
	if($("#service-type").val()=='ON_CHANGE'&&$.trim($("#invoice-date").val()).length==0)
	{
		alert('选择建议换货必须填写销售日期');
		return;
	}
	if($.trim(serviceDate).length==0)
	{
		alert('请填写维修受理日时间');
		return;
	}
	if($.trim(endDate).length==0)
	{
		alert('请填写到达时间(维修开始时间)');
		return;
	}
	if($.trim(serviceMethod).length==0)
	{
		alert('请选择服务形式');
		return;
	}
	if($.trim(serviceContract).length==0)
	{
		alert('请选择维修合同形态');
		return;
	}
	if($.trim(serviceOperation).length==0)
	{
		alert('请选择维修作业项目');
		return;
	}
	if($.trim(blackWhiteNumber).length==0)
	{
		alert('请填写黑白计数器读数');
		return;
	}
	if($.trim(serviceExpectedFinishDate).length==0)
	{
		alert('预计维修完成时间');
		return;
	}
	if(Date.before($.trim(serviceExpectedFinishDate),$.trim(endDate)))
	{
		alert("预计维修完成时间不能早于到达时间(维修开始时间)");
		return;
	}
	if($.trim(customerCompany).length==0)
	{
		alert('请填写用户公司');
		return;
	}
	if($.trim(customerName).length==0)
	{
		alert('请填写送修人');
		return;
	}
	if($.trim(customerTel).length==0)
	{
		alert('请填写联系电话');
		return;
	}
	if($.trim(customerAddress1).length==0)
	{
		alert('请填写省/直辖市/自治区');
		return;
	}
	if($.trim(customerAddress2).length==0)
	{
		alert('请填写市/县');
		return;
	}
	if($.trim(customerAddress3).length==0)
	{
		alert('请填写区/乡');
		return;
	}
	if($.trim(customerAddress4).length==0)
	{
		alert('请填写街道/小区/村');
		return;
	}
	if($.trim(customerAddress5).length==0)
	{
		alert('请填写门牌号/室/小组');
		return;
	}
	var symptom = 0;
	var cause = 0;
	var action = 0;
	var location = 0;
	//SYMPTOM,CAUSE,ACTION,LOCATION
	var faults = $("#order-fault tbody").find("tr");
	for(i=0;i<faults.size();i++)
	{
		var tr = faults.eq(i);
		if(tr.css("display") == "none")
			continue;
		var faultName = $.trim(tr.find('td').eq(0).text());
		var select = tr.find('select');
		for(j=0;j<select.size();j++)
		{
			if(select.attr('name')=='SYMPTOM')
				symptom ++;
			if(select.attr('name')=='CAUSE')
				cause ++;
			if(select.attr('name')=='ACTION')
				action ++;
			if(select.attr('name')=='LOCATION')
				location ++;
			if($.trim(select.val()).length==0&&select.attr('name')!='TARGET')
			{
				alert('['+faultName+']'+'信息不全');
				return;
			}
		}
		var text = tr.find('input[type=text]');
		for(j=0;j<text.size();j++)
		{
			if(text.eq(j).css("display") == "none")
				continue;
			if(faultName=='故障零件')
				continue;
			if($.trim(text.eq(j).val()).length==0)
			{
				alert('['+faultName+']'+'信息不全');
				return;
			}
		}
	}
	if(symptom==0)
	{
		alert('请填写故障现象');
		return;
	}
	if(cause==0)
	{
		alert('请填写故障原因');
		return;
	}
	if(action==0)
	{
		alert('请填写故障措施');
		return;
	}
	if(location==0)
	{
		alert('请填写故障部位');
		return;
	}
	//零件检查
	var partcheck = false;
	var machinecheck = false;
	var parts = $("#order-parts tbody").find("tr");
	for(i=0;i<parts.size();i++)
	{
		var tr = parts.eq(i);
		if(tr.css("display") == "none")
			continue;
		var itemNo = $.trim(tr.find('input').eq(2).val());
		if(itemNo.length>0)
			partcheck = true;		
		var itemCate = $.trim(tr.find('select').val());
		if(itemCate=='主机')
			machinecheck = true;
	}
	if(!partcheck)
	{
		if(!confirm('你没有填写任何[主机/零件/选购件或耗材]信息,确认就这样提交维修申请吗?'))
			return;
	}
	//在特约维修店维修受理画面，要求如果“故障零件分类”选择“更换主机”，维修区分里面强制要求选择“建议换货”以避免选成维修产生错误 
	if(machinecheck&&$("#service-type").val()!='ON_CHANGE')
	{
		alert('故障零件分类 选择了[主机]，维修区分必须选择[建议换货]');
		return;
	}
	//在维修区分中，只要选择“建议换货”下面相关联的“故障零件分类”中必须选择主机
	if(!machinecheck&&$("#service-type").val()=='ON_CHANGE')
	{
		alert('维修区分选择了[建议换货],故障零件分类 必须选择[主机]');
		return;
	}
	//申请时先保存
	var info = getServiceOrderInfo();
	if($.trim(info).length==0)
		return;
	$.ajax( {
		type : "POST",
		url : "saveServiceInfoByShopAction.action",
		data : {
			serviceOrderInfo : info,
			crumb : $("#crumb").val()
		},
		success : function(msg) {
			if ($.trim(msg).length == 0)
			{
				//维修单内容审核
				var serviceId = $("#service-id").val();
				$.ajax( {
					type : "POST",
					url : "applyPartOrMachineAction.action",
					data : {
						serviceId : serviceId
					},
					success : function(msg) {
						if ($.trim(msg).length == 0)
						{
							alert("申请成功,请在[维修申请检索]中查看!");
							window.location.reload();
						}
						else
							alert(unicodeToString($.trim(msg)));
					}
				});
			}
			else
				alert($.trim(unicodeToString(msg)));
		}
	});
	
}
function serviceApplyRateDialog() {
	var serviceDate = $("#service-date-status").val();
	if(serviceDate!='保修期内')
	{
		alert('机器已经过保修期，不能申请维修费');
		return;
	}
	//检查维修单是否上传
	var trs = $("#order-file tbody").find('tr');
	var b = false;
	for(i=0;i<trs.size();i++)
	{
		if($.trim(trs.eq(i).find('td').eq(2).text())=='维修单')
			b = true;
	}
	if(!b)
	{
		alert('请上传维修单扫描件');
		return;
	}
	//检查是否可申请费用
	var serviceId = replaceSpecialCharacters($("#service-id").val());
	$.ajax( {
		type : "POST",
		url : "checkApplyRateAction.action",
		data : {
			serviceId : serviceId
		},
		success : function(msg) {
			if ($.trim(msg) == 'true')
			{
				$('#dialog-form-applyRate').dialog('open');
			}
			else
			{
				alert("不能申请维修费用,原因：此机号两次维修时间小于30天");
			}
		}
	});
}
//维修费用申请
function serviceApplyRate() {
	//维修单内容审核
	var serviceId = replaceSpecialCharacters($("#service-id").val());
	var homeRate = replaceSpecialCharacters($("#apply-home-rate").val());
	var otherRate = replaceSpecialCharacters($("#apply-other-rate").val());
	var otherRateMemo = replaceSpecialCharacters($("#apply-other-rate-memo").val());
	if($.trim(otherRate).length>0)
	{
		if($.trim(otherRateMemo).length==0)
		{
			alert('请填写其它费用说明');
			return false;
		}
	}
	$.ajax( {
		type : "POST",
		url : "applyRateAction.action",
		data : {
			serviceId : serviceId,
			homeRate : homeRate,
			otherRate : otherRate,
			otherRateMemo : otherRateMemo,
			crumb : $("#crumb").val()
		},
		success : function(msg) {
			if ($.trim(msg).length == 0)
				{alert("申请成功,请在[维修申请检索]中查看!");
			window.location.reload();}
			else
				alert(unicodeToString($.trim(msg)));
		}
	});
	return true;
}
function pringServiceOrder(serviceId)
{
	window.open("printServiceOrderAction?serviceId="+serviceId,"维修单打印",'');
}