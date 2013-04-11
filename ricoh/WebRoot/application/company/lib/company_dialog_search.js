
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

function companySelect(check)
{
	var c = check.attr("checked");
	if(c)
	{
		var checks = $("#company-search-result ").find("input[type='checkbox']");
		for(i=0;i<checks.length;i++)
		{
			checks.eq(i).attr("checked",false);
		}
		check.attr("checked",true);
	}
}
