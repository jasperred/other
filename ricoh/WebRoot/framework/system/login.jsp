<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<link rel="shortcut icon" href="images/favicon.ico">
		<script type="text/javascript" src="js/jquery/jquery-1.4.4.js"></script>
	<script type="text/javascript" src="js/common/common.js"></script>
		<%@ taglib prefix="s" uri="/struts-tags"%>
		<title><s:text name="global.title"/></title>
	</head>
	<style>
		body{
			TEXT-ALIGN: center;
			background-color: white;
		}
		#main-frame
	    {
	    	margin:0 auto;
	    	text-align:center; 
	        width:900px;
	        border:0px solid #2E9AFE;
	        background-color: white;
	        height: 100%;
	    }
	    .one 
		{ 
		display:block; 
		overflow:hidden; 
		height:1px; 
		margin:0 4px; 
		border-left:1px solid #D8D8D8; 
		border-right:1px solid #D8D8D8; 
		background:#D8D8D8; 
		} 
		.two 
		{ 
		display:block; 
		overflow:hidden; 
		height:1px;/*线的高度为1px*/ 
		margin:0 3px;/*距离外层DIV的左右边距各3px*/ 
		border-left:1px solid #D8D8D8;/*只显示线的左边的1px*/ 
		border-right:1px solid #D8D8D8;/*只显示线的右边的1px*/ 
		background:#D8D8D8;/*配合内层Div的颜色变化，*/ 
		} 
		.three 
		{ 
		display:block; 
		overflow:hidden; 
		height:1px; 
		margin:0 2px; 
		border-left:1px solid #D8D8D8; 
		border-right:1px solid #D8D8D8; 
		background:#EDF7FF; 
		} 
		.four 
		{ 
		display:block; 
		overflow:hidden; 
		height:1px; 
		margin:0 1px; 
		border-left:1px solid #D8D8D8; 
		border-right:1px solid #D8D8D8; 
		background:#EDF7FF; 
		} 
		.rou/*DIV只显示左右的边框，颜色和p标签的一致*/ 
		{ 
		border-left:1px solid #D8D8D8; 
		border-right:1px solid #D8D8D8; 
		
		} 
		.rou2 
		{ 
		border-left:1px solid #D8D8D8; 
		border-right:1px solid #D8D8D8; 
		}
	</style>
	
	<body>
		<div id="main-frame">
		<table width="90%">
			<tr>
				<td valign="bottom">
					<img alt="" src="images/ricoh-logo-red.jpg"><font>CSMS</font>
				</td>
				<td align="right" valign="bottom"><font>version:1.0</font></td>
			</tr>
		</table>    
		<div style="width: 880px;margin:0 auto;margin-top: 30px;">
		<p class="two"> </p>
		<p class="three"> </p>
		<p class="four"> </p>
		<div class="rou2">
		<table width="100%" style="margin-top: 30px;">
				<tr>
					<td align="center">
						<form action="loginAction.action" method="POST" id="loginForm">
						<table align="center">
							
							<tr>
								<td align="right">
									<s:text name="login.companyNo"/>:
								</td>
								<td>
									<input type="text" name="companyNo"
										value="" id="company-no" style="width: 200px;height: 30px;background-color: #E8F2F6;border: 2px solid #084357;" onkeydown="if(event.keyCode==13)login();"></input>
								</td>
							</tr>
							<tr>
								<td align="right">
									<s:text name="login.username"/>:
								</td>
								<td>
									<input type="text" name="userName"
										value="" id="user-id" style="width: 200px;height: 30px;background-color: #E8F2F6;border: 2px solid #084357;" onkeydown="if(event.keyCode==13)login();"></input>
								</td>
							</tr>
							<tr>
								<td align="right">
									<s:text name="login.password"/>:
								</td>
								<td>
									<input type="password" name="password" id="password"
										style="width: 200px;height: 30px;background-color: #E8F2F6;border: 2px solid #084357;"  onkeydown="if(event.keyCode==13)login();"></input>
								</td>
							</tr>
							<tr>
								<td align="right">
									验证码:
								</td>
								<td>
									<input type="text" name="rand"
										value="" id="rand" style="width: 80px;height: 25px;background-color: #E8F2F6;border: 2px solid #084357;" onkeydown="if(event.keyCode==13)login();"></input><img src="rand.action" onclick="changeValidateCode(this)" title="点击图片刷新验证码"/>
								</td>
							</tr>
							<tr>
								<td align="right" colspan="2">
									<%--<input type="button" id="modify-password-button" value="<s:text name="login.modifyPassword"/>"
										style="width: 120px;"/>
									--%><input type="button" id="login-button" value="<s:text name="login.login"/>"
										style="width: 100px;height:30px;"/>
								</td>
							</tr>
			
							<tr>
								<td></td>
								<td id="message" style="color: red;display: none;">
									<s:property value="message" />
								</td>
							</tr>
						</table>
					</form>
					</td>
				</tr>
				<tr>
					<td align="center"><img alt="" src="images/l1.jpg" width="270px;">
					<img alt="" src="images/l2.jpg" width="270px;">
					<img alt="" src="images/l3.jpg" width="270px;"></td>
				</tr>
				<tr><td>建议屏幕分辨率:1280*1024</td></tr>
		</table></div>
		<p class="four"> </p>
		<p class="three"> </p>
		<p class="two"> </p>
		
		
		</div>
		</div>
	</body>
	<script type="text/javascript">
		$(document).ready(function(){
			$('#login-button').bind('click', function() {
					login();
				});
			//$('#modify-password-button').bind('click', function() {
			//		location.href="viewModifyPasswordByUserNoAction.action";
			//	});
		});
		 function changeValidateCode(obj) {   
	           //获取当前的时间作为参数，无具体意义   
	        var timenow = new Date().getTime();   
	           //每次请求需要一个不同的参数，否则可能会返回同样的验证码   
	        //这和浏览器的缓存机制有关系，也可以把页面设置为不缓存，这样就不用这个参数了。   
	        obj.src="rand.action?d="+timenow;   
	    }   
		function login()
		{
			var m = $("#message");
			m.hide();
			var companyNo = $("#company-no").val();
			var user = $("#user-id").val();
			var password = $("#password").val();
			var rand = $("#rand").val();
			if($.trim(rand).length==0)
			{
				m.html("请输入验证码");
				m.show();
				return;
			}
			if($.trim(companyNo).length==0)
			{
				m.html("<s:text name='login.error.companyNo'/>");
				m.show();
				return;
			}
			if($.trim(user).length==0)
			{
				m.html("<s:text name='login.error.username'/>");
				m.show();
				return;
			}
			if($.trim(password).length==0)
			{
				m.html("<s:text name='login.error.password'/>");
				m.show();
				return;
			}

			$.ajax( {
				type : "POST",
				url : "loginActionByAjax.action",
				data : {
				companyNo:companyNo,
					userName : user,
					password:password,
					rand : rand
				},
				success : function(msg) {
					if ($.trim(msg).length==0) {
						// 刷新
						location.href="index.action";
				} else if($.trim(msg)=="MODIFY_PWD"){
					location.href="viewModifyPasswordByUserAction.action";
				} else
				{
					m.html(unicodeToString($.trim(msg)));
					m.show();
				}
			}
			});
					
		}
	</script>
</html>