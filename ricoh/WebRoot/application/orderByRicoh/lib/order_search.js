function searchOrderByRcn(currentPage) {
	var shopName = replaceSpecialCharacters($("#shop-name").val());
var fixPeople = replaceSpecialCharacters($("#fix-people").val());
var serviceNo = replaceSpecialCharacters($("#service-no").val());
var machineNo = replaceSpecialCharacters($("#machine-no").val());
var machineTypeId = replaceSpecialCharacters($("#machine-type-id").val());
var serviceDateStatus = replaceSpecialCharacters($("#service-date-status").val());
var serviceMethod = replaceSpecialCharacters($("#service-method").val());
var serviceContract = replaceSpecialCharacters($("#service-contract").val());
var serviceOperation = replaceSpecialCharacters($("#service-operation").val());
var customerName = replaceSpecialCharacters($("#customer-name").val());
var thruTime = replaceSpecialCharacters($("#thru-time").val());
var actionNo = replaceSpecialCharacters($("#action-no").val());
var symptomNo = replaceSpecialCharacters($("#symptom-no").val());
var causeNo = replaceSpecialCharacters($("#cause-no").val());
var locationNo = replaceSpecialCharacters($("#location-no").val());
var serviceStatus = replaceSpecialCharacters($("#service-status").val());
var itemNo = replaceSpecialCharacters($("#item-no").val());
var fromServiceDate = replaceSpecialCharacters($("#from-service-date").val());
var endServiceDate = replaceSpecialCharacters($("#end-service-date").val());
var fromServiceFinishDate = replaceSpecialCharacters($("#from-service-finish-date").val());
var endServiceFinishDate = replaceSpecialCharacters($("#end-service-finish-date").val());
var fromCustomerRetrieveDate = replaceSpecialCharacters($("#from-customer-retrieve-date").val());
var endCustomerRetrieveDate = replaceSpecialCharacters($("#end-customer-retrieve-date").val());

	$.ajax( {
		type : "POST",
		url : "searchServiceByRcnAction.action",
		data : {
		shopName : shopName,
		fixPeople : fixPeople,
		serviceNo : serviceNo,
		machineNo : machineNo,
		machineTypeId : machineTypeId,
		serviceDateStatus : serviceDateStatus,
		serviceMethod : serviceMethod,
		serviceContract : serviceContract,
		serviceOperation : serviceOperation,
		customerName : customerName,
		thruTime : thruTime,
		actionNo : actionNo,
		symptomNo : symptomNo,
		causeNo : causeNo,
		locationNo : locationNo,
		serviceStatus : serviceStatus,
		itemNo : itemNo,
		fromServiceDate : fromServiceDate,
		endServiceDate : endServiceDate,
		fromServiceFinishDate : fromServiceFinishDate,
		endServiceFinishDate : endServiceFinishDate,
		fromCustomerRetrieveDate : fromCustomerRetrieveDate,
		endCustomerRetrieveDate : endCustomerRetrieveDate,
			currentPage : currentPage,
			pageRow:15
		},
		success : function(msg) {
			var tb = $("#order-search-result tbody");
			var tb_page = $("#order-search-page tbody");
			if ($.trim(msg).length > 0) {
				tb.html(msg);
				var page = getSearchPage("searchOrderByRcn");
				tb_page.html(page);
			} else {
				tb.html("");
				tb_page.html("<tr><td height='30' align='center'>未找到查询结果</td></tr>");
			}

		}
	});
}
function searchOrderByShop(currentPage) {
	var shopName = replaceSpecialCharacters($("#shop-name").val());
var fixPeople = replaceSpecialCharacters($("#fix-people").val());
var serviceNo = replaceSpecialCharacters($("#service-no").val());
var machineNo = replaceSpecialCharacters($("#machine-no").val());
var machineTypeId = replaceSpecialCharacters($("#machine-type-id").val());
var serviceDateStatus = replaceSpecialCharacters($("#service-date-status").val());
var serviceMethod = replaceSpecialCharacters($("#service-method").val());
var serviceContract = replaceSpecialCharacters($("#service-contract").val());
var serviceOperation = replaceSpecialCharacters($("#service-operation").val());
var customerName = replaceSpecialCharacters($("#customer-name").val());
var thruTime = replaceSpecialCharacters($("#thru-time").val());
var actionNo = replaceSpecialCharacters($("#action-no").val());
var symptomNo = replaceSpecialCharacters($("#symptom-no").val());
var causeNo = replaceSpecialCharacters($("#cause-no").val());
var locationNo = replaceSpecialCharacters($("#location-no").val());
var serviceStatus = replaceSpecialCharacters($("#service-status").val());
var itemNo = replaceSpecialCharacters($("#item-no").val());
var fromServiceDate = replaceSpecialCharacters($("#from-service-date").val());
var endServiceDate = replaceSpecialCharacters($("#end-service-date").val());
var fromServiceFinishDate = replaceSpecialCharacters($("#from-service-finish-date").val());
var endServiceFinishDate = replaceSpecialCharacters($("#end-service-finish-date").val());
var fromCustomerRetrieveDate = replaceSpecialCharacters($("#from-customer-retrieve-date").val());
var endCustomerRetrieveDate = replaceSpecialCharacters($("#end-customer-retrieve-date").val());

	$.ajax( {
		type : "POST",
		url : "searchServiceByShopAction.action",
		data : {
		shopName : shopName,
		fixPeople : fixPeople,
		serviceNo : serviceNo,
		machineNo : machineNo,
		machineTypeId : machineTypeId,
		serviceDateStatus : serviceDateStatus,
		serviceMethod : serviceMethod,
		serviceContract : serviceContract,
		serviceOperation : serviceOperation,
		customerName : customerName,
		thruTime : thruTime,
		actionNo : actionNo,
		symptomNo : symptomNo,
		causeNo : causeNo,
		locationNo : locationNo,
		serviceStatus : serviceStatus,
		itemNo : itemNo,
		fromServiceDate : fromServiceDate,
		endServiceDate : endServiceDate,
		fromServiceFinishDate : fromServiceFinishDate,
		endServiceFinishDate : endServiceFinishDate,
		fromCustomerRetrieveDate : fromCustomerRetrieveDate,
		endCustomerRetrieveDate : endCustomerRetrieveDate,
			currentPage : currentPage,
			pageRow:15
		},
		success : function(msg) {
			var tb = $("#order-search-result tbody");
			var tb_page = $("#order-search-page tbody");
			if ($.trim(msg).length > 0) {
				tb.html(msg);
				var page = getSearchPage("searchOrderByShop");
				tb_page.html(page);
			} else {
				tb.html("");
				tb_page.html("<tr><td height='30' align='center'>未找到查询结果</td></tr>");
			}

		}
	});
}

function searchOrderByStatus(currentPage) {
	var shopName = replaceSpecialCharacters($("#shop-name").val());
	var serviceStatus = replaceSpecialCharacters($("#service-status").val());

	$.ajax( {
		type : "POST",
		url : "searchServiceByStatusAction.action",
		data : {
		shopName : shopName,
		
		serviceStatus : serviceStatus,
		
			currentPage : currentPage,
			pageRow:15
		},
		success : function(msg) {
			var tb = $("#order-search-result tbody");
			var tb_page = $("#order-search-page tbody");
			if ($.trim(msg).length > 0) {
				tb.html(msg);
				var page = getSearchPage("searchOrderByStatus");
				tb_page.html(page);
			} else {
				tb.html("");
				tb_page.html("<tr><td height='30' align='center'>未找到查询结果</td></tr>");
			}

		}
	});
}


