function searchNoVisit(currentPage) {
	var companyName = replaceSpecialCharacters($("#company-name").val());
	var serviceNo = replaceSpecialCharacters($("#service-no").val());
	var fromServiceApplyAuditedDate = replaceSpecialCharacters($("#from-service-apply-audited-date").val());
	var endServiceApplyAuditedDate = replaceSpecialCharacters($("#end-service-apply-audited-date").val());

	$.ajax( {
		type : "POST",
		url : "searchNoVisitServiceOrderAction.action",
		data : {
		companyName : companyName,
		serviceNo:serviceNo,
		fromServiceApplyAuditedDate:fromServiceApplyAuditedDate,
		endServiceApplyAuditedDate:endServiceApplyAuditedDate,
			currentPage : currentPage,
			pageRow:15
		},
		success : function(msg) {
			var tb = $("#novisit-search-result tbody");
			var tb_page = $("#novisit-search-page tbody");
			if ($.trim(msg).length > 0) {
				tb.html(msg);
				var page = getSearchPage("searchNoVisit");
				tb_page.html(page);
			} else {
				tb.html("");
				tb_page.html("<tr><td height='30' align='center'>未找到查询结果</td></tr>");
			}

		}
	});
}
function searchVisit(currentPage) {
	var companyName = replaceSpecialCharacters($("#company-name").val());
	var serviceNo = replaceSpecialCharacters($("#service-no").val());
	var visitPeople = replaceSpecialCharacters($("#visit-people").val());
	var visitFromDate = replaceSpecialCharacters($("#visit-from-date").val());
	var visitEndDate = replaceSpecialCharacters($("#visit-end-date").val());
	$.ajax( {
		type : "POST",
		url : "searchServiceVisitAction.action",
		data : {
		companyName : companyName,
		serviceNo:serviceNo,
		visitPeople:visitPeople,
		visitFromDate:visitFromDate,
		visitEndDate:visitEndDate,
			currentPage : currentPage,
			pageRow:15
		},
		success : function(msg) {
			var tb = $("#visit-search-result tbody");
			var tb_page = $("#visit-search-page tbody");
			if ($.trim(msg).length > 0) {
				tb.html(msg);
				var page = getSearchPage("searchVisit");
				tb_page.html(page);
			} else {
				tb.html("");
				tb_page.html("<tr><td height='30' align='center'>未找到查询结果</td></tr>");
			}

		}
	});
}
function showVisitDialog(serviceId,serviceNo)
{
	$("#visit-service-id").val(serviceId);
	$("#visit-service-no").val(serviceNo);
	$("#visit-flag").val('');
	$("#visit-result").val('');
	$("#visit-memo").val('');
	$('#dialog-form-visit').dialog('open');
}
function visitServiceOrder()
{
	var serviceId = replaceSpecialCharacters($("#visit-service-id").val());
	var visitFlag = replaceSpecialCharacters($("#visit-flag").val());
	var visitMemo = replaceSpecialCharacters($("#visit-memo").val());
	var visitResult = replaceSpecialCharacters($("#visit-result").val());
	var b = false;
	$.ajax( {
		type : "POST",
		url : "visitServiceOrderAction.action",
		async : false,
		data : {
		serviceId : serviceId,
		visitFlag:visitFlag,
		visitMemo:visitMemo,
		visitResult:visitResult,
		crumb : $("#crumb").val()
		},
		success : function(msg) {
			if ($.trim(msg).length > 0) {
				b = true;
				alert(unicodeToString($.trim(msg)));
			} else {
				alert('回访成功');
				$("#service_"+serviceId).remove();
				b = false;
			}

		}
	});
	return b;
}