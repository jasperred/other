<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
		<meta http-equiv="Cache-Control" content="no-cache,no-store" />
		<%@ taglib prefix="s" uri="/struts-tags"%>
		<title><s:text name="global.title"/></title>
		<link rel="shortcut icon" href="images/favicon.ico">
		
	</head>
	<body>
		<table width="100%" style="font-size: 14px;font-family: '宋体';">
			<tr>
				<td><input type="image" src="images/ricoh-logo-red.jpg" width="180px" height="30px"/></td>
				<td align="center"><label style="font-style: inherit;font-size: 24;"><s:text name="global.top_title"/></label></td>
				<td align="right">
					<s:if test="#session.LOGIN_INFO!=null">
						<label id="show-msg" style="color:red;"></label>
						<label>
							<s:if test="#session.COMPANY_INFO.CompanyName!=null&&#session.COMPANY_INFO.CompanyName.length()>20">
								<s:property value="#session.COMPANY_INFO.CompanyName.substring(0,20)"/>
							</s:if>
							<s:else>
								<s:property value="#session.COMPANY_INFO.CompanyName"/>
							</s:else>&nbsp;&nbsp;
							<s:text name="global.login.weblcome"/></label>
							<s:if test="#session.LOGIN_INFO.UserName!=null&&#session.LOGIN_INFO.UserName.length()>20">
								<s:property value="#session.LOGIN_INFO.UserName.substring(0,10)"/>
							</s:if>
							<s:else>
								<s:property value="#session.LOGIN_INFO.UserName"/>
							</s:else>
							&nbsp;&nbsp;
							<a href="logoutAction.action"><s:text name="global.logout"/></a>
							&nbsp;&nbsp;</s:if>
				</td>
			</tr>
		</table>
	</body>
	<script type="text/javascript">
	$(document).ready(function () {
		showMsg();
		setInterval("showMsg()",3600000);
		}); 
	function showMsg()
	{
		$.ajax( {
			type : "POST",
			url : "userLoginMessageAction.action",
			success : function(msg) {
				if($.trim(msg).length>0)
					$("#show-msg").html("消息："+msg);
			}
		});
	}
	</script>
</html>