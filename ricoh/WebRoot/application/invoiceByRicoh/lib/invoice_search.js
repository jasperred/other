function searchInvoiceByRcn(currentPage) {
	var companyName = replaceSpecialCharacters($("#company-name").val());
	var invoiceCd = replaceSpecialCharacters($("#invoice-cd").val());
	var invoiceNoticeFromDate = replaceSpecialCharacters($("#invoice-notice-from-date").val());
	var invoiceNoticeEndDate = replaceSpecialCharacters($("#invoice-notice-end-date").val());
	var invoiceFromDate = replaceSpecialCharacters($("#invoice-from-date").val());
	var invoiceEndDate = replaceSpecialCharacters($("#invoice-end-date").val());

	$.ajax( {
		type : "POST",
		url : "searchInvoiceByRcnAction.action",
		data : {
			companyName : companyName,
			invoiceCd : invoiceCd,
			invoiceFromDate : invoiceFromDate,
			invoiceEndDate : invoiceEndDate,
			invoiceNoticeFromDate : invoiceNoticeFromDate,
			invoiceNoticeEndDate : invoiceNoticeEndDate,
			currentPage : currentPage,
			pageRow : 15
		},
		success : function(msg) {
			var tb = $("#invoice-search-result tbody");
			var tb_page = $("#invoice-search-page tbody");
			if ($.trim(msg).length > 0) {
				tb.html(msg);
				var page = getSearchPage("searchInvoiceByRcn");
				tb_page.html(page);
			} else {
				tb.html("");
				tb_page.html("<tr><td height='30' align='center'>未找到查询结果</td></tr>");
			}

		}
	});
}
function searchInvoiceByShop(currentPage) {
	var invoiceCd = replaceSpecialCharacters($("#invoice-cd").val());
	var invoiceNoticeFromDate = replaceSpecialCharacters($("#invoice-notice-from-date").val());
	var invoiceNoticeEndDate = replaceSpecialCharacters($("#invoice-notice-end-date").val());
	var invoiceFromDate = replaceSpecialCharacters($("#invoice-from-date").val());
	var invoiceEndDate = replaceSpecialCharacters($("#invoice-end-date").val());

	$.ajax( {
		type : "POST",
		url : "searchInvoiceByShopAction.action",
		data : {
			invoiceCd : invoiceCd,
			invoiceFromDate : invoiceFromDate,
			invoiceEndDate : invoiceEndDate,
			invoiceNoticeFromDate : invoiceNoticeFromDate,
			invoiceNoticeEndDate : invoiceNoticeEndDate,
			currentPage : currentPage,
			pageRow : 15
		},
		success : function(msg) {
			var tb = $("#invoice-search-result tbody");
			var tb_page = $("#invoice-search-page tbody");
			if ($.trim(msg).length > 0) {
				tb.html(msg);
				var page = getSearchPage("searchInvoiceByShop");
				tb_page.html(page);
			} else {
				tb.html("");
				tb_page.html("<tr><td height='30' align='center'>未找到查询结果</td></tr>");
			}

		}
	});
}
function previewInvoiceList(currentPage) {
	var fromDate = replaceSpecialCharacters($("#from-date").val());
	var endDate = replaceSpecialCharacters($("#end-date").val());
	var companyId = replaceSpecialCharacters($("#company-id").val());

	$.ajax( {
		type : "POST",
		url : "previewInvoiceListByRcnAction.action",
		data : {
			fromDate : fromDate,
			endDate : endDate,
			companyId : companyId,
			currentPage : currentPage,
			pageRow : 15
		},
		success : function(msg) {
			var tb = $("#invoice-preview-result tbody");
			var tb_page = $("#invoice-preview-page tbody");
			if ($.trim(msg).length > 0) {
				tb.html(msg);
				var page = getSearchPage("previewInvoiceList");
				tb_page.html(page);
			} else {
				tb.html("");
				tb_page.html("<tr><td height='30' align='center'>未找到查询结果</td></tr>");
			}

		}
	});
}
function showPreviewInvoice(companyId)
{
	companyId = replaceSpecialCharacters(companyId);
	var fromDate = $("#from-date").val();
	var endDate = $("#end-date").val();
	location.href='previewInvoiceInfoByRcnAction.action?companyId='+companyId+'&fromDate='+fromDate+'&endDate='+endDate;
	//$("body").load("previewInvoiceInfoByRcnAction.action", {companyId : companyId,fromDate : fromDate,endDate : endDate});
}