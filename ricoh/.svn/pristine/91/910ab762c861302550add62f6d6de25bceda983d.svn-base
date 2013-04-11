<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<%@ taglib prefix="s" uri="/struts-tags"%>
	<%@ include file="../common/top.jsp"%>
	<script type="text/javascript" src="framework/user/lib/security_group.js"></script>
	<STYLE TYPE="text/css" MEDIA="screen, print, projection">
<!--
  div.jqi{
	width: 800px;
	height:1200px;
	font-family: Verdana, Geneva, Arial, Helvetica, sans-serif;
	background-color: #ffffff;
	font-size: 11px;
	text-align: left;
	border: solid 1px #eeeeee;
	border-radius: 10px;
	-moz-border-radius: 10px;
	-webkit-border-radius: 10px;
	padding: 7px;
}
-->
</STYLE>
	<body>
		<input type="hidden" name="currentPage" value="1" />
		<div id="search-box">
			<span class="rc-tp"><span></span> </span>
			<table width=100% class="hd" >
				<tr><td align="left">角色管理</td><td align="right">[展开/隐藏]</td></tr>
			</table>
			<form action="">
				<table width=100% id="security-group-search">

					<tr>
						<td class="double-cols">
							<input type="text" class="pure-text" value="ID:" readonly="readonly"/>
							<span class=""><input type="text" name="groupId"
									id="group-id" /> </span>
						</td>
						<td class="double-cols">
							<input type="text" class="pure-text" value="名称:" readonly="readonly"/>
							<span class=""><input type="text" name="groupName"
									id="group-name" /> </span>
						</td>
					</tr>

					<tr>
						<td align="left">
							<input type="button" value="新增角色" id="security-group-new-button" />
						</td>
						<td class="search-button" align="right">
							<input type="button" value="检索" id="security-group-search-button" />
							<input type="reset" value="清空" />
						</td>
					</tr>
				</table>
			</form>
		</div>
		<br>
			<table id="security-group-search-result" border="0" cellpadding="1"
				cellspacing="1" class="listing" width="100%" bgcolor="#CCCCCC">

				<thead>
					<tr>
						<th>
							ID
						</th>
						<th>
							名称
						</th>
						<th>
							级别
						</th>
						<th>
							修改
						</th>
						<th>
							权限
						</th>
						
					</tr>
				</thead>
				<tbody>
				</tbody>
			</table>
			<table cellspacing="0" cellpadding="0" border="0" width="100%"
				style="border: 0px none;" id="security-group-search-page">
				<tbody>

				</tbody>
			</table>
			<%@ include file="../system/bottom.jsp"%>
	</body>
	<script type="text/javascript">
	$(document).ready(function() {
		//$("#security-group-search").hide();
		$('.hd').bind('click', function() {
			hideAndShow('security-group-search');
		});
		$("#security-group-search-button").bind('click', function() {
			searchSecurityGroup(1);
		});
		searchSecurityGroup(1);
		$("#security-group-new-button").bind('click', function() {
			saveSecurityGroup('-1');
		});
	});
</script>
</html>