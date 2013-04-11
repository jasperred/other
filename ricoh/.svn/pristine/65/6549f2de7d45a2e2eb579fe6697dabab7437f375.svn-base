function setCompanyInfo(companyId,companyNo,companyName,companyCategoryNo,rcnNo,provinceNo,companyCity,companyAddress,companyZip,companyTel,companyContact)
{
	
	$("#company-id").val(companyId);
	$("#company-no").val(companyNo);
	$("#company-name").val(companyName);
	$("#company-category-no").val(companyCategoryNo);
	$("#rcn-no").val(rcnNo);
	$("#company-province-no").val(provinceNo);
	$("#company-city").val(companyCity);
	$("#company-address").val(companyAddress);
	$("#company-zip").val(companyZip);
	$("#company-tel").val(companyTel);
	$("#company-contact").val(companyContact);
}
function saveCompany()
{
	$("#message").html("");
	var check = false;
	var companyId = replaceSpecialCharacters($("#company-id").val());
	var companyName = replaceSpecialCharacters($("#company-name").val());
	if($.trim(companyName).length==0)
	{
		$("#message").append("<li>请输入公司名称</li>");
		check = true;
	}
	var companyCategoryNo = replaceSpecialCharacters($("#company-category-no").val());
	if($.trim(companyCategoryNo).length==0)
	{
		$("#message").append("<li>请选择公司分类</li>");
		check = true;
	}
	var provinceNo = replaceSpecialCharacters($("#company-province-no").val());
	if($.trim(provinceNo).length==0)
	{
		$("#message").append("<li>请选择公司所属省份</li>");
		check = true;
	}
	var rcnNo = $("#rcn-no").val();
	var companyCity = $("#company-city").val();
	var companyAddress = $("#company-address").val();
	var companyZip = $("#company-zip").val();
	var companyTel = $("#company-tel").val();
	var companyContact = $("#company-contact").val();
	if(check)return;
	$.ajax( {
		type : "POST",
		url : "companyInfoSaveAction.action",
		data : {
		companyId : companyId,
		companyName:companyName,
		companyCategoryNo:companyCategoryNo,
		provinceNo:$.trim(provinceNo),
		rcnNo:rcnNo,
		companyCity:companyCity,
		companyAddress:companyAddress,
		companyZip:companyZip,
		companyTel:companyTel,
		companyContact:companyContact,
		crumb : $("#crumb").val()
		},
		success : function(msg) {
			if ($.trim(msg).length>0) {
				alert(unicodeToString(msg));
			} else
				{
				alert('保存成功');
				//window.location.reload();
				location.href = "viewCompanyAction.action";
				};
		}
	});
}
