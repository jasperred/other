function searchDeliveryByRcn(currentPage) {
	var serviceNo = replaceSpecialCharacters($("#service-no").val());
	var status = replaceSpecialCharacters($("#delivery-status").val());
	var shopName = replaceSpecialCharacters($("#company-name").val());	
	var department = replaceSpecialCharacters($("#delivery-department").val());
	$.ajax( {
		type : "POST",
		url : "deliverySearchByRcnAction.action",
		data : {
			serviceNo : serviceNo,
			status : status,
			shopName : shopName,
			department : department,
			currentPage : currentPage,
			pageRow : 15
		},
		success : function(msg) {
			var tb = $("#delivery-search-result tbody");
			var tb_page = $("#delivery-search-page tbody");
			if ($.trim(msg).length > 0) {
				tb.html(msg);
				var page = getSearchPage("searchDeliveryByRcn");
				tb_page.html(page);
			} else {
				tb.html("");
				tb_page.html("<tr><td height='30' align='center'>未找到查询结果</td></tr>");
			}

		}
	});
}
function searchDeliveryByScm(currentPage) {
	var serviceNo = replaceSpecialCharacters($("#service-no").val());
	var status = replaceSpecialCharacters($("#delivery-status").val());
	var shopName = replaceSpecialCharacters($("#company-name").val());
	$.ajax( {
		type : "POST",
		url : "deliverySearchByScmAction.action",
		data : {
			serviceNo : serviceNo,
			status : status,
			shopName : shopName,
			currentPage : currentPage,
			pageRow : 15
		},
		success : function(msg) {
			var tb = $("#delivery-search-result tbody");
			var tb_page = $("#delivery-search-page tbody");
			if ($.trim(msg).length > 0) {
				tb.html(msg);
				var page = getSearchPage("searchDeliveryByScm");
				tb_page.html(page);
			} else {
				tb.html("");
				tb_page.html("<tr><td height='30' align='center'>未找到查询结果</td></tr>");
			}

		}
	});
}
function searchDeliveryByCspc(currentPage) {
	var serviceNo = replaceSpecialCharacters($("#service-no").val());
	var status = replaceSpecialCharacters($("#delivery-status").val());
	var shopName = replaceSpecialCharacters($("#company-name").val());
	$.ajax( {
		type : "POST",
		url : "deliverySearchByCspcAction.action",
		data : {
			serviceNo : serviceNo,
			status : status,
			shopName : shopName,
			currentPage : currentPage,
			pageRow : 15
		},
		success : function(msg) {
			var tb = $("#delivery-search-result tbody");
			var tb_page = $("#delivery-search-page tbody");
			if ($.trim(msg).length > 0) {
				tb.html(msg);
				var page = getSearchPage("searchDeliveryByCspc");
				tb_page.html(page);
			} else {
				tb.html("");
				tb_page.html("<tr><td height='30' align='center'>未找到查询结果</td></tr>");
			}

		}
	});
}
