function searchUser(currentPage) {
	var userName = replaceSpecialCharacters($("#user-name").val());
	var userId = replaceSpecialCharacters($("#user-id").val());
	var userNo = replaceSpecialCharacters($("#user-no").val());
	var companyId = replaceSpecialCharacters($("#company-id").val());
	var email = replaceSpecialCharacters($("#email").val());
	var enabled = replaceSpecialCharacters($("#enabled").val());
	var tecNo = replaceSpecialCharacters($("#tec-no").val());

	if($.trim(userId).length==0)
		userId = -1;
	if($.trim(companyId).length==0)
		companyId = -1;
	$.ajax( {
		type : "POST",
		url : "userSearchAction.action",
		data : {
		userName : userName,
		userId : userId,
		userNo : userNo,
		companyId : companyId,
		email : email,
		enabled : enabled,
		tecNo:tecNo,
			currentPage : currentPage,
			pageRow:15
		},
		success : function(msg) {
			var tb = $("#user-search-result tbody");
			var tb_page = $("#user-search-page tbody");
			if ($.trim(msg).length > 0) {
				tb.html(msg);
				var page = getSearchPage("searchUser");
				tb_page.html(page);
			} else {
				tb.html("");
				tb_page.html("<tr><td height='30' align='center'>未找到查询结果</td></tr>");
			}

		}
	});
}

function modify_pwd(userId,userNo)
{
	userId = replaceSpecialCharacters(userId);
	userNo = replaceSpecialCharacters(userNo);
	$.ajax( {

		type : "POST",
		url : "viewModifyPasswordAction.action",
		data : {
		userId : userId,
		userNo:userNo
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
							else
							{
								var userName = $("#mp-user-id").val();
								var password = $("#mp-old-pwd").val();
								var newPassword = $("#mp-new-pwd").val();
								var rePassword = $("#mp-renew-pwd").val();
								if($.trim(password).length==0)
								{
									alert("请输入原密码");
									$.prompt.goToState('state0');
									return false;
								}
								if($.trim(newPassword).length==0)
								{
									alert("请输入新密码");
									$.prompt.goToState('state0');
									return false;
								}
								if($.trim(newPassword).length<6)
								{
									alert("密码长度不能小于6位");
									$.prompt.goToState('state0');
									return false;
								}
								if(newPassword!=rePassword)
								{
									alert("密码不一致");
									$.prompt.goToState('state0');
									return false;
								}
								if(newPassword==password)
								{
									alert("新密码不能和原密码相同");
									$.prompt.goToState('state0');
									return false;
								}
								$.prompt.goToState('state1');
								return false;
							}
							
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
								var userId = $("#mp-user-id").val();
								var userName = $("#mp-user-name").val();
								var password = $("#mp-old-pwd").val();
								var newPassword = $("#mp-new-pwd").val();
								var rePassword = $("#mp-renew-pwd").val();
								// 确定
								$.ajax( {

									type : "POST",
									url : "modifyPasswordAction.action",
									data : {
									userId : userId,
									newPassword : $.trim(newPassword),
									password : $.trim(password)
									},
									success : function(msg) {
										if($.trim(msg).length!=0)
										{
											alert($.trim(unicodeToString(msg)));
											modify_pwd(userId,userName);
										}
										else
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

function reset_pwd(userId,userNo)
{
	userId = replaceSpecialCharacters(userId);
	userNo = replaceSpecialCharacters(userNo);
	if(!confirm('是否确认重置用户['+userNo+']的密码?'))
		return;
	$.ajax( {

		type : "POST",
		url : "resetPasswordAction.action",
		data : {
		userId : userId
		},
		success : function(msg) {
			if($.trim(msg).length==0)
			{
				alert('重置成功');
			}
			else
			{
				alert(unicodeToString(msg));
			}
		}
	});
	

}

function saveUserByDialog(userId)
{
	userId = replaceSpecialCharacters(userId);
	$.ajax( {

		type : "POST",
		url : "getUserInfoAction.action",
		data : {
		userId : userId
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
								var userId = replaceSpecialCharacters($("#u-user-id").val());
								var email = replaceSpecialCharacters($("#u-email").val());
								var userName = replaceSpecialCharacters($("#u-user-name").val());
								var enabled = replaceSpecialCharacters($("#u-enabled").val());
								// 确定
								$.ajax( {

									type : "POST",
									url : "userUpdateAction.action",
									data : {
									userId : userId,
									userName : userName,
									email:email,
									enabled : enabled,
									crumb : $("#crumb").val()
									},
									success : function(msg) {
										if($.trim(msg).length!=0)
											alert(unicodeToString(msg));
										else
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

function newUser()
{

	$.ajax( {

		type : "POST",
		url : "getUserInfoAction.action",
		data : {
		userId : -1
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
							else
							{
								var userName = replaceSpecialCharacters($("#u-user-name").val());
								var userNo = replaceSpecialCharacters($("#u-user-no").val());
								var password = replaceSpecialCharacters($("#u-pwd").val());
								var rePassword = replaceSpecialCharacters($("#u-re-pwd").val());
								var email = replaceSpecialCharacters($("#u-email").val());
								if($.trim(userNo).length==0)
								{
									alert("请输入用户NO");
									$.prompt.goToState('state0');
									return false;
								}
								if($.trim(userName).length==0)
								{
									alert("请输入用户姓名");
									$.prompt.goToState('state0');
									return false;
								}
								if($.trim(password).length==0)
								{
									alert("请输入密码");
									$.prompt.goToState('state0');
									return false;
								}								
								if(password!=rePassword)
								{
									alert("密码不一致");
									$.prompt.goToState('state0');
									return false;
								}
								if($.trim(email).length==0)
								{
									alert("请输入邮件");
									$.prompt.goToState('state0');
									return false;
								}
								$.prompt.goToState('state1');
								return false;
							}
							
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
								var userName = replaceSpecialCharacters($("#u-user-name").val());
								var password = replaceSpecialCharacters($("#u-pwd").val());
								var email = replaceSpecialCharacters($("#u-email").val());
								var userNo = replaceSpecialCharacters($("#u-user-no").val());
								var enabled = replaceSpecialCharacters($("#u-enabled").val());
								// 确定
								$.ajax( {

									type : "POST",
									url : "newUserAction.action",
									data : {
									userName : userName,
									password : password,
									email:email,
									userNo:userNo,
									enabled:enabled,
									crumb : $("#crumb").val()
									},
									success : function(msg) {
										if($.trim(msg).length!=0)
											alert(unicodeToString(msg));
										else
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

function userSecurityGroup(userId)
{
	userId = replaceSpecialCharacters(userId);
	$.ajax( {

		type : "POST",
		url : "userSecurityGroupAction.action",
		data : {
		userId : userId
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
								var checks = $("#user-security-group").find("input[type=checkbox]");
								for(i=0;i<checks.size();i++)
								{
									if(!checks.eq(i).attr("checked"))
										continue;
									if(ids.length>0)
										ids += ',';
									ids += replaceSpecialCharacters(checks.eq(i).attr("groupId"));
								}
								// 确定
								$.ajax( {

									type : "POST",
									url : "saveUserSecurityGroupAction.action",
									data : {
									userId : userId,
									groupIds : ids,
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
