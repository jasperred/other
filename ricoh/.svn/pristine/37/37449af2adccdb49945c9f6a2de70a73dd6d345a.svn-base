//删除文件
function deleteFile(fileName, path,id) {
	$.ajax( {

		type : "POST",
		url : "fileDeleteAction.action",
		data : {
			deleteFileName : fileName,
			filePath : path
		},
		success : function(msg) {
			if ($.trim(msg) != "success") {
				alert("删除失败");
				return;
			} else {
				
				$("#" + id).remove();
			}
		}
	});
}
//查询分页
function getSearchPage(search_function)
{
	if($("#row-count").val() == undefined)
	{
		return "<tr><td height='30' align='center'>未找到查询结果</td></tr>";
	}
	var current_page = new Number($("#current-page").val());
	var row_count = new Number($("#row-count").val());
	
	var page_count = new Number($("#page-count").val());
	var page = "<tr><td height='30' align='center'>";
	page += "<a href='#' onclick='"+search_function+"(1)'>首页</a>";
	if (current_page == 1)
		page += "&nbsp;上一页";
	else
		page += "&nbsp;<a href='#' onclick='"+search_function+"("
				+ (current_page - 1) + ")'>上一页</a>";
	for (i = current_page - 4; i < current_page; i++) {
		if (i > 0)
			page += "&nbsp;<a href='#' onclick='"+search_function+"(" + i
					+ ")'>" + i + "</a>";
	}
	page += "&nbsp;[" + current_page + "]";
	for (i = current_page + 1; i <= current_page + 4; i++)
		if (i <= page_count)
			page += "&nbsp;<a href='#' onclick='"+search_function+"(" + i
					+ ")'>" + i + "</a>";
	if (current_page == page_count)
		page += "&nbsp;下一页";
	else
		page += "&nbsp;<a href='#' onclick='"+search_function+"("
				+ (current_page + 1) + ")'>下一页</a>";
	page += "&nbsp;<a href='#' onclick='"+search_function+"("
			+ (page_count) + ")'>末页</a>";
	page += "&nbsp;&nbsp;当前第" + current_page + "页,共" + page_count
			+ "页,总共有" + row_count + "条数据.</td></tr>";
	return page;
}
function newLine(tableId,fields,types)
{
	var line = "";
	line+="<tr>";
	for(i=0;i<fields.length;i++)
	{
		line+="<td>";
		line+="<input class='"+types[i]+"' name='"+fields[i]+"' type='text' />";
		line+="</td>";
	}
	line+="</tr>";
	alert(line);
	$("#"+tableId+" tbody").addend(line);
}