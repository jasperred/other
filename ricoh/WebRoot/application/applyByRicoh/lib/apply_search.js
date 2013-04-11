function searchApplyServiceByShop(currentPage) {
	var serviceNo = replaceSpecialCharacters($("#service-no").val());
	var applyStatus = replaceSpecialCharacters($("#apply-status").val());
	var applyType = replaceSpecialCharacters($("#apply-type").val());
	$.ajax( {
		type : "POST",
		url : "searchApplyServiceByShopAction.action",
		data : {
			serviceNo : serviceNo,
			applyStatus : applyStatus,
			applyType : applyType,
			currentPage : currentPage,
			pageRow : 15
		},
		success : function(msg) {
			var tb = $("#apply-search-result tbody");
			var tb_page = $("#apply-search-page tbody");
			if ($.trim(msg).length > 0) {
				tb.html(msg);
				var page = getSearchPage("searchApplyServiceByShop");
				tb_page.html(page);
			} else {
				tb.html("");
				tb_page.html("<tr><td height='30' align='center'>未找到查询结果</td></tr>");
			}

		}
	});
}
function searchApplyServiceByRcn(currentPage) {
	var serviceNo = replaceSpecialCharacters($("#service-no").val());
	var applyStatus = replaceSpecialCharacters($("#apply-status").val());
	var applyType = replaceSpecialCharacters($("#apply-type").val());
	var companyName = replaceSpecialCharacters($("#company-name").val());
	if(companyName==undefined)
		companyName = '';
	$.ajax( {
		type : "POST",
		url : "searchApplyServiceByRcnAction.action",
		data : {
			serviceNo : serviceNo,
			applyStatus : applyStatus,
			applyType : applyType,
			companyName:companyName,
			currentPage : currentPage,
			pageRow : 15
		},
		success : function(msg) {
			var tb = $("#apply-search-result tbody");
			var tb_page = $("#apply-search-page tbody");
			if ($.trim(msg).length > 0) {
				tb.html(msg);
				var page = getSearchPage("searchApplyServiceByRcn");
				tb_page.html(page);
			} else {
				tb.html("");
				tb_page.html("<tr><td height='30' align='center'>未找到查询结果</td></tr>");
			}

		}
	});
}
