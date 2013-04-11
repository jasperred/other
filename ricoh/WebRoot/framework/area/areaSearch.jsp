<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<%@ taglib prefix="s" uri="/struts-tags"%>
	<%@ include file="../common/top.jsp"%>
	<script type="text/javascript" src="framework/area/lib/area.js"></script>
			
	<body>
		<input type="hidden" name="currentPage" value="1" />
		<div id="search-box">
			<span class="rc-tp"><span></span> </span>
			<table width=100% class="hd" >
				<tr><td align="left">区域管理</td><td align="right">[展开/隐藏]</td></tr>
			</table>
			<form action="">
				<table width=100% id="area-search">

					<tr>
						<td class="double-cols">
							<input type="text" class="pure-text" value="区域代码:" readonly="readonly" onkeydown= "if(event.keyCode==9){event.returnValue=false;}" />
							<span class=""><input type="text" name="areaCd"
									id="area-cd" /> </span>
						</td>
						<td class="double-cols">
							<input type="text" class="pure-text" value="区域名称:" readonly="readonly" onkeydown= "if(event.keyCode==9){event.returnValue=false;}"/>
							<span class=""><input type="text" name="areaName"
									id="area-name" /> </span>
						</td>
					</tr>

					<tr>
						<td align="left">
							<input type="button" value="新增区域" id="area-new-button" />
						</td>
						<td class="search-button" align="right">
							<input type="button" value="检索" id="area-search-button" />
							<input type="reset" value="清空" />
						</td>
					</tr>
				</table>
			</form>
		</div>
		<br>
			<table id="area-search-result" border="0" cellpadding="1"
				cellspacing="1" class="listing" width="100%" bgcolor="#CCCCCC">

				<thead>
					<tr>
						<th>
							区域代码
						</th>
						<th>
							区域名称
						</th>
						<th>
							操作
						</th>
						<th>
							省份
						</th>
						
					</tr>
				</thead>
				<tbody>
				</tbody>
			</table>
			<table cellspacing="0" cellpadding="0" border="0" width="100%"
				style="border: 0px none;" id="area-search-page">
				<tbody>

				</tbody>
			</table>
			<%@ include file="../system/bottom.jsp"%>
	</body>
	<script type="text/javascript">
	$(document).ready(function() {
		//$("#area-search").hide();
		$('.hd').bind('click', function() {
			hideAndShow('area-search');
		});
		$("#area-search-button").bind('click', function() {
			searchArea(1);
		});
		searchArea(1);
		$("#area-new-button").bind('click', function() {
			saveArea('-1');
		});
	});
</script>
</html>