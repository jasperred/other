function saveUser()
{
	$("#user-message").html("");
	var userId = $("#u-user-id").val();
	var userNo = replaceSpecialCharacters($("#u-user-no").val());
	var userName = replaceSpecialCharacters($("#u-user-name").val());
	var password = $("#u-pwd").val();
	var rePassword = $("#u-re-pwd").val();
	var email = replaceSpecialCharacters($("#u-email").val());
	var enabled = replaceSpecialCharacters($("#u-enabled").val());
	var companyId = $("#u-company-id").val();
	var tecNo = replaceSpecialCharacters($("#u-tec-no").val());
	var check = false;
	//if($.trim(userNo).length==0)
	//{
	//	$("#user-message").append("<li>请填写用户NO</li>");
	//	check = true;
	//}
	if($.trim(userName).length==0)
	{
		$("#user-message").append("<li>请填写用户姓名</li>");
		check = true;
	}
	if(userId<=0)
	{
		if($.trim(password).length==0)
		{
			$("#user-message").append("<li>请输入密码</li>");
			check = true;
		}
		if($.trim(password).length<6)
		{
			$("#user-message").append("<li>密码长度不能小于6位</li>");
			check = true;
		}
		else if($.trim(rePassword).length==0)
		{
			$("#user-message").append("<li>请再次输入密码</li>");
			check = true;
		}
		else if($.trim(password)!=$.trim(rePassword))
		{
			$("#user-message").append("<li>两次输入的密码不一致</li>");
			check = true;
		}
	}
	if($.trim(companyId).length==0)
	{
		$("#user-message").append("<li>请填写公司</li>");
		check = true;
	}
	if(check)
		return;
	if(userId<=0)
	{
		$.ajax( {

			type : "POST",
			url : "newUserAction.action",
			data : {
			userName : userName,
			password : password,
			email:email,
			userNo:userNo,
			enabled:enabled,
			companyId:companyId,
			tecNo:tecNo,
			crumb : $("#crumb").val()
			},
			success : function(msg) {
				if($.trim(msg).length!=0)
				{
					alert("保存成功");
					//location.href="getUserInfoAction.action?userId="+$.trim(msg);
					location.href = "viewUserSearchAction.action";
				}
				else
					alert("保存失败");
			}
		});
	}
	else
	{
		$.ajax( {

			type : "POST",
			url : "userUpdateAction.action",
			data : {
			userId : userId,
			userName : userName,
			email:email,
			enabled : enabled,
			companyId:companyId,
			tecNo:tecNo,
			crumb : $("#crumb").val()
			},
			success : function(msg) {
				if($.trim(msg).length!=0)
				{
					alert("保存成功");
					//location.href="getUserInfoAction.action?userId="+$.trim(msg);
					location.href = "viewUserSearchAction.action";
				}
				else
					alert("保存失败");
			}
		});
	}
	
}