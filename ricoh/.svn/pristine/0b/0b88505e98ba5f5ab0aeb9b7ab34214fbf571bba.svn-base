function searchCompanyMachineType(currentPage) {
	var companyId = replaceSpecialCharacters($("#company-id").val());
	var companyName = replaceSpecialCharacters($("#company-name").val());
	var machineTypeId = replaceSpecialCharacters($("#machine-type-id").val());
	var machineCd = replaceSpecialCharacters($("#machine-cd").val());

	$.ajax( {
		type : "POST",
		url : "companyMachineTypeSearchAction.action",
		data : {
			companyId : companyId,
			companyName : companyName,
			machineTypeId : machineTypeId,
			machineCd : machineCd,
			currentPage : currentPage,
			pageRow : 15
		},
		success : function(msg) {
			var tb = $("#company-machine-type-search-result tbody");
			var tb_page = $("#company-machine-type-search-page tbody");
			if ($.trim(msg).length > 0) {
				tb.html(msg);
				var page = getSearchPage("searchCompanyMachineType");
				tb_page.html(page);
			} else {
				tb.html("");
				tb_page.html("");
			}

		}
	});
}

function deleteCompanyMachineTypeRef(companyId,machineTypeId)
{
	companyId = replaceSpecialCharacters(companyId);
	machineTypeId = replaceSpecialCharacters(machineTypeId);
	if(!confirm("是否删除?"))
		return;
	$.ajax( {
		type : "POST",
		url : "deleteCompanyMachineTypeRefAction.action",
		data : {
		companyId : companyId,
		machineTypeId : machineTypeId,
		crumb : $("#crumb").val()
		},
		success : function(msg) {
			if($.trim(msg)=="success")
			{
				alert("删除成功");
				$("#company_machine_type_"+companyId+machineTypeId).remove();
			}
			else
			{
				alert(unicodeToString(msg));
			}
		}
	});
}
