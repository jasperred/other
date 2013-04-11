function searchArea(currentPage) {
	var areaCd = replaceSpecialCharacters($("#area-cd").val());
	var areaName = replaceSpecialCharacters($("#area-name").val());

	$.ajax( {
		type : "POST",
		url : "searchAreaAction.action",
		data : {
		areaCd : areaCd,
		areaName : areaName,
			currentPage : currentPage,
			pageRow:15
		},
		success : function(msg) {
			var tb = $("#area-search-result tbody");
			var tb_page = $("#area-search-page tbody");
			if ($.trim(msg).length > 0) {
				tb.html(msg);
				var page = getSearchPage("searchArea");
				tb_page.html(page);
			} else {
				tb.html("");
				tb_page.html("<tr><td height='30' align='center'>未找到查询结果</td></tr>");
			}

		}
	});
}
function saveArea(trid)
{
	
	var areaCd ;
	var areaName ;
	if(trid=='-1')
	{
		areaCd = '';
		areaName = '';
	}
	else
	{		
		var tds = $('#'+trid).find('td');
		areaCd = $.trim(tds.eq(0).text());
		areaName = $.trim(tds.eq(1).text());
	}
	$.ajax( {

		type : "POST",
		url : "areaInfoAction.action",
		data : {
		areaCd : areaCd,
		areaName:areaName
		},
		success : function(msg) {
			var statesdemo = {
					state0 : {
						html : unicodeToString(msg),
						buttons : {
							取消 : false,
							保存 : true
						},
						focus : 1,
						submit : function(v, m, f) {
							if (!v)
								return true;							
								$.prompt.goToState('state1');
								return false;							
						}
					},
					state1 : {
						html : '是否保存?',
						buttons : {
							取消 : -1,
							确定 : 0
						},
						focus : 1,
						submit : function(v, m, f) {
							if (v == 0) {
								var areaCd = replaceSpecialCharacters($("#sg-area-cd").val());
								var areaName = replaceSpecialCharacters($("#sg-area-name").val());
								// 确定
								$.ajax( {

									type : "POST",
									url : "saveAreaAction.action",
									data : {
									areaCd : areaCd,
									areaName : areaName,
									crumb : $("#crumb").val()
									},
									success : function(msg) {
										if($.trim(msg)!="success")
											alert(unicodeToString(msg));
										else
										{
											alert("保存成功");
											searchArea(1);
										}
									}
								});
						$.prompt.close();
						return true;
					} else if (v = -1)
						$.prompt.goToState('state0');
					return false;
				}
					}
				};
				$.prompt(statesdemo);
				$("#sg-area-cd").val(areaCd);				
				$("#sg-area-name").val(areaName);
		}
	});
	
}
function saveAreaProvince(trid)
{
	var tds = $('#'+trid).find('td');
	var areaCd = $.trim(tds.eq(0).text());
	areaCd = replaceSpecialCharacters(areaCd);
	$.ajax( {

		type : "POST",
		url : "areaProvinceAction.action",
		data : {
		areaCd : areaCd
		},
		success : function(msg) {
			if($.trim(msg).length==0)
			{
				alert('无可分配省份');
				return;
			}
			var statesdemo = {
					state0 : {
						html : msg,
						buttons : {
							取消 : false,
							保存 : true
						},
						focus : 1,
						submit : function(v, m, f) {
							if (!v)
								return true;
							
								$.prompt.goToState('state1');
								return false;
							
						}
					},
					state1 : {
						html : '是否保存?',
						buttons : {
							取消 : -1,
							确定 : 0
						},
						focus : 1,
						submit : function(v, m, f) {
							if (v == 0) {
								var ids = '';
								var checks = $("#area-province").find("input[type=checkbox]");
								for(i=0;i<checks.size();i++)
								{
									if(!checks.eq(i).attr("checked"))
										continue;
									if(ids.length>0)
										ids += ',';
									ids += checks.eq(i).attr("provinceId");
								}
								// 确定
								$.ajax( {

									type : "POST",
									url : "saveAreaProvinceAction.action",
									data : {
									areaCd : areaCd,
									provinceIds : ids,
									crumb : $("#crumb").val()
									},
									success : function(msg) {
											alert("保存成功");
									}
								});
						$.prompt.close();
						return true;
					} else if (v = -1)
						$.prompt.goToState('state0');
					return false;
				}
					}
				};
				$.prompt(statesdemo);
		}
	});
	
}
function deleteArea(trid)
{	
	var tds = $('#'+trid).find('td');
	var areaCd = $.trim(tds.eq(0).text());
	areaCd = replaceSpecialCharacters(areaCd);
	if(confirm("是否确认删除?"))
	{
		$.ajax( {
			type : "POST",
			url : "deleteAreaAction.action",
			data : {
				areaCd : areaCd,
				crumb : $("#crumb").val()
			},
			success : function(msg) {
				if ($.trim(msg)=="success") {
					alert("删除成功");
					$("#area_"+areaCd).remove();
				} else {
					alert(unicodeToString(msg));
				}

			}
		});
	}
	else
		return;
}
