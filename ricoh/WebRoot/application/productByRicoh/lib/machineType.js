function searchMachineType(currentPage) {
	var machineType = $.trim($("#machine-type").val());
	var machineCd = $.trim($("#machine-cd").val());
	var machineCat = $.trim($("#machine-cat").val());
	var serviceProviderType = $.trim($("#service-provider-type").val());

	$.ajax( {
		type : "POST",
		url : "searchMachineTypeAction.action",
		data : {
		machineType : machineType,
		machineCd : machineCd,
		machineCat : machineCat,
		serviceProviderType : serviceProviderType,
			currentPage : currentPage,
			pageRow:15
		},
		success : function(msg) {
			var tb = $("#machine-type-search-result tbody");
			var tb_page = $("#machine-type-search-page tbody");
			if ($.trim(msg).length > 0) {
				tb.html(msg);
				var page = getSearchPage("searchMachineType");
				tb_page.html(page);
			} else {
				tb.html("");
				tb_page.html("");
			}

		}
	});
}
function setMachineTypeInfo(machineTypeId,machineType,machineCd,machineCat,serviceProviderType,rate1,rate2,ctime,cuser)
{
	
	$("#machine-type-id").val(machineTypeId);
	$("#machine-type").val(machineType);
	$("#machine-cd").val(machineCd);
	$("#machine-cat").val(machineCat);
	$("#service-provider-type").val(serviceProviderType);
	$("#rate1").val(rate1);
	$("#rate2").val(rate2);
	$("#ctime").val(ctime);
	$("#cuser").val(cuser);
	$("#ctime").attr("readonly",true);
	$("#cuser").attr("readonly",true);
}
function saveMachineType()
{
	$("#message").html("");
	var check = false;
	var machineTypeId = replaceSpecialCharacters($.trim($("#machine-type-id").val()));
	var machineType = replaceSpecialCharacters($.trim($("#machine-type").val()));
	if($.trim(machineType).length==0)
	{
		$("#message").append("<li>请输入机型</li>");
		check = true;
	}
	var machineCd = replaceSpecialCharacters($.trim($("#machine-cd").val()));
	if($.trim(machineCd).length==0)
	{
		$("#message").append("<li>请选择商品编号</li>");
		check = true;
	}
	var serviceProviderType = replaceSpecialCharacters($.trim($("#service-provider-type").val()));
	var machineCat = replaceSpecialCharacters($.trim($("#machine-cat").val()));
	var rate1 = $.trim($("#rate1").val());
	var rate2 = $.trim($("#rate2").val());
	if($.trim(rate1).length==0&&$.trim(rate2).length==0)
	{
		$("#message").append("<li>请输入服务费</li>");
		check = true;
	}
	if($.trim(machineTypeId)==0)
	{
		$.ajax( {
		type : "POST",
		async : false,
		url : "checkMachineCdAction.action",
		data : {
			machineCd : machineCd
		},
		success : function(msg) {
			if ($.trim(msg).length > 0) {
				$("#message").append("<li>"+msg+"</li>");
				check = true;
			}
		}
	});
	}
	if(check)return;
	$.ajax( {
		type : "POST",
		url : "machineTypeInfoSaveAction.action",
		data : {
		machineTypeId : machineTypeId,
		machineType:machineType,
		machineCd:machineCd,
		serviceProviderType:serviceProviderType,
		machineCat:machineCat,
		rate1:rate1,
		rate2:rate2,
		crumb : $("#crumb").val()
		},
		success : function(msg) {
			if ($.trim(msg).length>0) {
				alert("保存成功");
				//location.href="machineTypeInfoAction.action?machineTypeId="+$.trim(msg);
				location.href = "viewMachineTypeAction.action";
			} else
				alert(unicodeToString(msg));
		}
	});
}
function deleteMachineType(machineTypeId)
{
	if(!confirm("是否删除?"))
		return;
	$.ajax( {
		type : "POST",
		url : "deleteMachineTypeAction.action",
		data : {
		machineTypeId : machineTypeId,
		crumb : $("#crumb").val()
		},
		success : function(msg) {
			if($.trim(msg)=="success")
			{
				alert("删除成功");
				$("#machine_type_"+machineTypeId).remove();
			}
			else
			{
				alert(unicodeToString(msg));
			}
		}
	});
}
