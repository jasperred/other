function searchCompany(currentPage) {
	var companyNo = replaceSpecialCharacters($("#company-id").val());
	var companyName = replaceSpecialCharacters($("#company-name").val());
	var companyCategoryNo = replaceSpecialCharacters($("#company-category-no").val());
	var companyProvinceNo = replaceSpecialCharacters($("#company-province-no").val());
	var rcnNo = replaceSpecialCharacters($("#rcn-no").val());

	$.ajax( {
		type : "POST",
		url : "companySearchAction.action",
		data : {
		companyNo : companyNo,
		companyName : companyName,
		companyCategoryNo : companyCategoryNo,
		provinceNo : companyProvinceNo,
		rcnNo : rcnNo,
			currentPage : currentPage,
			pageRow:15
		},
		success : function(msg) {
			var tb = $("#company-search-result tbody");
			var tb_page = $("#company-search-page tbody");
			if ($.trim(msg).length > 0) {
				tb.html(msg);
				var page = getSearchPage("searchCompany");
				tb_page.html(page);
			} else {
				tb.html("");
				tb_page.html("<tr><td height='30' align='center'>未找到查询结果</td></tr>");
			}

		}
	});
}

function deleteCompany(companyId)
{
	companyId = replaceSpecialCharacters(companyId);
	if(!confirm("是否删除?"))
		return;
	$.ajax( {
		type : "POST",
		url : "deleteCompanyAction.action",
		data : {
		companyId : companyId,
		crumb : $("#crumb").val()
		},
		success : function(msg) {
			if($.trim(msg).length==0)
			{
				alert("删除成功");
				$("#company_"+companyId).remove();
			}
			else
			{
				alert(unicodeToString(msg));
			}
		}
	});
}
function searchDialogCompany(currentPage) {
	var companyId = replaceSpecialCharacters($("#company-id").val());
	var companyName = replaceSpecialCharacters($("#company-name").val());
	var companyCategoryNo = replaceSpecialCharacters($("#company-category-no").val());
	var companyProvinceNo = replaceSpecialCharacters($("#company-province-no").val());
	var rcnNo = replaceSpecialCharacters($("#rcn-no").val());

	$.ajax( {
		type : "POST",
		url : "companyDialogSearchAction.action",
		data : {
		companyId : companyId,
		companyName : companyName,
		companyCategoryNo : companyCategoryNo,
		provinceNo : companyProvinceNo,
		rcnNo : rcnNo,
			currentPage : currentPage,
			pageRow:15
		},
		success : function(msg) {
			var tb = $("#company-search-result tbody");
			var tb_page = $("#company-search-page tbody");
			if ($.trim(msg).length > 0) {
				tb.html(msg);
				var page = getSearchPage("searchDialogCompany");
				tb_page.html(page);
			} else {
				tb.html("");
				tb_page.html("<tr><td height='30' align='center'>未找到查询结果</td></tr>");
			}

		}
	});
}
