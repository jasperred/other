function searchInventoryByRcn(currentPage) {
	var shopName = replaceSpecialCharacters($("#shop-name").val());
	var skuCd = replaceSpecialCharacters($("#sku-cd").val());
	var skuName = replaceSpecialCharacters($("#sku-name").val());

	$.ajax( {
		type : "POST",
		url : "searchInventoryByRcnAction.action",
		data : {
			shopName : shopName,
			skuCd : skuCd,
			skuName : skuName,
			currentPage : currentPage,
			pageRow:15
		},
		success : function(msg) {
			var tb = $("#inventory-search-result tbody");
			var tb_page = $("#inventory-search-page tbody");
			if ($.trim(msg).length > 0) {
				tb.html(msg);
				var page = getSearchPage("searchInventoryByRcn");
				tb_page.html(page);
			} else {
				tb.html("");
				tb_page.html("<tr><td height='30' align='center'>未找到查询结果</td></tr>");
			}

		}
	});
}
function searchInventoryByShop(currentPage) {
	var skuCd = replaceSpecialCharacters($("#sku-cd").val());
	var skuName = replaceSpecialCharacters($("#sku-name").val());

	$.ajax( {
		type : "POST",
		url : "searchInventoryByShopAction.action",
		data : {
			skuCd : skuCd,
			skuName : skuName,
			currentPage : currentPage,
			pageRow:15
		},
		success : function(msg) {
			var tb = $("#inventory-search-result tbody");
			var tb_page = $("#inventory-search-page tbody");
			if ($.trim(msg).length > 0) {
				tb.html(msg);
				var page = getSearchPage("searchInventoryByShop");
				tb_page.html(page);
			} else {
				tb.html("");
				tb_page.html("<tr><td height='30' align='center'>未找到查询结果</td></tr>");
			}

		}
	});
}
