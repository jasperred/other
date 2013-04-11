function importExceed(filename,id)
{
	$("#import-message").html("");
	$.ajax( {
		type : "POST",
		url : "exceedImportAction.action",
		data : {
			exceedFileName : filename
		},
		success : function(msg) {
			$("#"+id).remove();
			$("#import-message").append(msg);

		}
	});
}
function importServiceRate(filename,id)
{
	$("#import-message").html("");
	$.ajax( {
		type : "POST",
		url : "serviceRateImportAction.action",
		data : {
			serviceRateFileName : filename
		},
		success : function(msg) {
			$("#"+id).remove();
			$("#import-message").append(msg);

		}
	});
}
function importCompanyMachineRef(filename,id)
{
	$("#import-message").html("");
	$.ajax( {
		type : "POST",
		url : "companyMachineTypeRefImportAction.action",
		data : {
			companyMachineTypeRefFileName : filename
		},
		success : function(msg) {
			$("#"+id).remove();
			$("#import-message").append(msg);

		}
	});
}
function fileUpload(form,upload)
{
	if($.trim($("#"+upload).val()).length==0)
	{
		alert('请选择上传文件');
		return;
	}
	$("#"+form).submit();
}