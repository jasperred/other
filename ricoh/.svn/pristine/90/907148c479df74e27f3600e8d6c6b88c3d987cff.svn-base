function searchSecurityGroup(currentPage) {
	var groupId = replaceSpecialCharacters($("#group-id").val());
	var groupName = replaceSpecialCharacters($("#group-name").val());

	$.ajax( {
		type : "POST",
		url : "searchSecurityGroupAction.action",
		data : {
		groupId : groupId,
		groupName : groupName,
			currentPage : currentPage,
			pageRow:15
		},
		success : function(msg) {
			var tb = $("#security-group-search-result tbody");
			var tb_page = $("#security-group-search-page tbody");
			if ($.trim(msg).length > 0) {
				tb.html(msg);
				var page = getSearchPage("searchSecurityGroup");
				tb_page.html(page);
			} else {
				tb.html("");
				tb_page.html("<tr><td height='30' align='center'>未找到查询结果</td></tr>");
			}

		}
	});
}
function saveSecurityGroup(trid)
{
	var groupId;
	var groupName;
	var level;
	if(trid=='-1')
	{
		groupId = '';
		groupName = '';
		level = '1';
	}
	else
	{
		var tds = $('#'+trid).find('td');
		groupId = $.trim(tds.eq(0).text());
		groupName = $.trim(tds.eq(1).text());
		level = $.trim(tds.eq(2).text());
	}
	
	$.ajax( {

		type : "POST",
		url : "securityGroupInfoAction.action",
		data : {
		groupId : groupId,
		groupName:groupName,
		level : level
		},
		success : function(msg) {
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
								var groupId = replaceSpecialCharacters($("#sg-group-id").val());
								var groupName = replaceSpecialCharacters($("#sg-group-name").val());
								var level = replaceSpecialCharacters($("#sg-level").val());
								// 确定
								$.ajax( {

									type : "POST",
									url : "saveSecurityGroupAction.action",
									data : {
									groupId : groupId,
									groupName : groupName,
									level : level,
									crumb : $("#crumb").val()
									},
									success : function(msg) {
										if($.trim(msg)!="success")
											alert(msg);
										else
										{
											alert("保存成功");
											searchSecurityGroup(1);
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
				$("#sg-group-id").val(unicodeToString(groupId));
				$("#sg-group-name").val(unicodeToString(groupName));
				$("#sg-level").val(unicodeToString(level));
		}
	});
	
}
function saveSecurityGroupPermission(trid)
{
	var tds = $('#'+trid).find('td');
	var groupId = $.trim(tds.eq(0).text());
	groupId = replaceSpecialCharacters(groupId);
	$.ajax( {

		type : "POST",
		url : "securityGroupPermissionAction.action",
		data : {
		groupId : groupId
		},
		success : function(msg) {
			var statesdemo = {
					state0 : {
						html : msg,
						buttons : {
							取消 : false,
							保存 : true
						},
						focus : 1,
						top : 0,
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
								var checks = $("#security-group-permission").find("input[type=checkbox]");
								for(i=0;i<checks.size();i++)
								{
									if(!checks.eq(i).attr("checked"))
										continue;
									if(ids.length>0)
										ids += ',';
									ids += checks.eq(i).attr("permissionId");
								}
								// 确定
								$.ajax( {

									type : "POST",
									url : "saveSecurityGroupPermissionAction.action",
									data : {
									groupId : groupId,
									permissionIds : ids,
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

function saveSecurityGroupArea(trid)
{
	var tds = $('#'+trid).find('td');
	var groupId = $.trim(tds.eq(0).text());
	groupId = replaceSpecialCharacters(groupId);
	$.ajax( {

		type : "POST",
		url : "securityGroupAreaAction.action",
		data : {
		groupId : groupId
		},
		success : function(msg) {
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
								var checks = $("#security-group-area").find("input[type=checkbox]");
								for(i=0;i<checks.size();i++)
								{
									if(!checks.eq(i).attr("checked"))
										continue;
									if(ids.length>0)
										ids += ',';
									ids += checks.eq(i).attr("areaId");
								}
								// 确定
								$.ajax( {

									type : "POST",
									url : "saveSecurityGroupAreaAction.action",
									data : {
									groupId : groupId,
									areaIds : ids,
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