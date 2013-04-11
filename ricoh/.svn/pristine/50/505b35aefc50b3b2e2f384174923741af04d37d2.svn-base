<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<%@ taglib prefix="s" uri="/struts-tags"%>
	<%@ include file="../common/top.jsp"%>
	<script type="text/javascript" src="framework/user/lib/user_search.js">
</script>

	<body>
		<div id="search-box">
			<span class="rc-tp"><span></span> </span>
			<div class="hd">
				<h3>
					修改密码
				</h3>
			</div>
			<table>
				<tr>
					<td>
						<label>
							公司NO:
						</label>
					</td>
					<td>
						<input type="text" id="mp-company-no"/>
					</td>
				</tr>
				<tr>
					<td>
						<label>
							用户:
						</label>
					</td>
					<td>
						<input type="text" id="mp-user-name"/>
					</td>
				</tr>
				<tr>
					<td>
						<label>
							原密码:
						</label>
					</td>
					<td>
						<span><input type="password" id="mp-old-pwd" /> </span>
					</td>
				</tr>
				<tr>
					<td>
						<label>
							新密码:
						</label>
					</td>
					<td>
						<span><input type="password" id="mp-new-pwd" onchange="checkValueLength($(this),100)" /> </span>
					</td>
				</tr>
				<tr>
					<td>
						<label>
							确认密码:
						</label>
					</td>
					<td>
						<span><input type="password" id="mp-renew-pwd" /> </span>
					</td>
				</tr>
				<tr>
					<td>
					</td>
					<td align="right">
						<input id="modify-ps-button" type="button" value="确认" />
						<input id="cancel-button" type="button" value="取消" />
					</td>
				</tr>
			</table>
			<div>
				<ul id="message" style="color: red">
				</ul>
			</div>
	</body>
	<script type="text/javascript">
$(document).ready(function() {
	$("#modify-ps-button").bind('click', function() {
		modifyUserPassword();
	});
	$("#cancel-button").bind('click', function() {
		location.href = "viewLogin.action";
	});
});
function modifyUserPassword() {
	$("#message").html("");
	var companyNo = $("#mp-company-no").val();
	var userNo = $("#mp-user-name").val();
	var password = $("#mp-old-pwd").val();
	var newPassword = $("#mp-new-pwd").val();
	var rePassword = $("#mp-renew-pwd").val();
	var check = false;
	if ($.trim(companyNo).length == 0) {
		$("#message").append("<li>请输入公司NO</li>");
		check = true;
	}
	if ($.trim(userNo).length == 0) {
		$("#message").append("<li>请输入用户</li>");
		check = true;
	}
	if ($.trim(password).length == 0) {
		$("#message").append("<li>请输入原密码</li>");
		check = true;
	}
	if ($.trim(newPassword).length == 0) {
		$("#message").append("<li>请输入新密码</li>");
		check = true;
	}
	if ($.trim(newPassword).length <6) {
		$("#message").append("<li>密码长度不能小于6位</li>");
		check = true;
	}
	if (newPassword != rePassword) {
		$("#message").append("<li>两次输入的密码不一致</li>");
		check = true;
	}
	if (newPassword == password) {
		$("#message").append("<li>新密码不能和原密码相同</li>");
		check = true;
	}
	if (check)
		return;
	$.ajax( {

		type : "POST",
		url : "modifyPasswordByUserNoAction.action",
		data : {
		companyNo : companyNo,
		userNo : userNo,
			newPassword : $.trim(newPassword),
			password : $.trim(password)
		},
		success : function(msg) {
			if ($.trim(msg) == "SUCCESS") {
				location.href = "index.action";
				return;
			}
			$("#message").append("<li>" + msg + "</li>");
		}
	});
}
</script>
</html>