<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<%@ taglib prefix="s" uri="/struts-tags"%>
	<%@ include file="../common/top.jsp"%>
	<link type="text/css" href="css/ui/jquery.ui.all.css" rel="stylesheet" />
	<script type="text/javascript" src="js/jquery/ui/jquery.ui.core.js"></script>
	<script type="text/javascript" src="js/jquery/ui/jquery.ui.widget.js"></script>
	<script type="text/javascript" src="js/jquery/ui/jquery.ui.button.js"></script>
	<script type="text/javascript" src="js/jquery/ui/jquery.ui.position.js"></script>
	<script type="text/javascript" src="js/jquery/ui/jquery.ui.autocomplete.js"></script>	
	<script type="text/javascript" src="framework/user/lib/user_search.js"></script>
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
	<s:action name="companyListAction" id="companyListAction"></s:action>
	<body>
		<input type="hidden" name="currentPage" value="1" />
		<div id="search-box">
			<span class="rc-tp"><span></span> </span>
			<table width=100% class="hd" >
				<tr><td align="left">用户查询</td><td align="right">[展开/隐藏]</td></tr>
			</table>
			<form action="">
				<table width=100% id="user-search">

					<tr>
						<td class="double-cols">
							<input type="text" class="pure-text" value="系统ID:" readonly="readonly"/>
							<span class=""><input type="text" name="userId"
									id="user-id" onchange="checkQty($(this))"/> </span>
						</td>
						<td class="double-cols">
							<input type="text" class="pure-text" value="用户NO:" readonly="readonly"/>
							<span class=""><input type="text" name="userNo"
									id="user-no" /> </span>
						</td>

						<td class="double-cols">
							<input type="text" class="pure-text" value="用户名称:" readonly="readonly"/>
							<span class=""><input type="text" name="username"
									id="user-name" /> </span>
						</td>
					</tr>
					
					<tr>
						<s:push value="companyListAction">
						<td class="double-cols">
							<input type="text" class="pure-text" value="公司:" readonly="readonly"/>
							<span class="">
							<select name="companyId" id="company-id">
							<option value=""></option>
							<s:iterator value="companyList">
							<option value="<s:property value="id"/>"><s:property value="CompanyName"/></option>
							</s:iterator>
							</select> </span>
						</td>
						</s:push>
						<td class="double-cols">
							<input type="text" class="pure-text" value="邮件:" readonly="readonly"/>
							<span class=""><input type="text" name="email"
									id="email" /> </span>
						</td>

						<td class="double-cols">
							<input type="text" class="pure-text" value="状态:" readonly="readonly"/>
							<span class=""><select name="enabled" id="enabled"><option value=""></option><option value="Y">有效</option><option value="N">无效</option></select> </span>
						</td>
					</tr>
					<tr>
						<td class="double-cols">
							<input type="text" class="pure-text" value="技术员代码:" readonly="readonly"/>
							<span class=""><input type="text" name="tecNo"
									id="tec-no" /></span>
						</td>
					</tr>

					<tr>
						<td align="left">
							<input type="button" value="新增用户" id="user-new-button" />
						</td>
						<td></td>
						<td class="search-button" align="right">
							<input type="button" value="检索" id="user-search-button" />
							<input type="reset" value="清空" />
						</td>
					</tr>
				</table>
			</form>
		</div>
		<br>
			<table id="user-search-result" border="0" cellpadding="1"
				cellspacing="1" class="listing" width="100%" bgcolor="#CCCCCC">

				<thead>
					<tr>
						<th>
							系统ID
						</th>
						<th>
							用户NO
						</th>
						<th>
							用户姓名
						</th>
						<th>
							邮件
						</th>
						<th>
							公司
						</th>
						<th>
							状态
						</th>
						<th>
							修改
						</th>
						<th>
							角色
						</th>
						
					</tr>
				</thead>
				<tbody>
				</tbody>
			</table>
			<table cellspacing="0" cellpadding="0" border="0" width="100%"
				style="border: 0px none;" id="user-search-page">
				<tbody>

				</tbody>
			</table>
			<%@ include file="../system/bottom.jsp"%>
	</body>
	<script type="text/javascript">
	(function( $ ) {
		$.widget( "ui.combobox", {
			_create: function() {
				var self = this;
				var select = this.element.hide(),
					selected = select.children( ":selected" ),
					value = selected.val() ? selected.text() : "";
				var input = $( "<input>" )
					.insertAfter( select )
					.val( value )
					.autocomplete({
						delay: 0,
						minLength: 0,
						source: function( request, response ) {
							var matcher = new RegExp( $.ui.autocomplete.escapeRegex(request.term), "i" );
							response( select.children( "option" ).map(function() {
								var text = $( this ).text(); 
								if ( this.value && ( !request.term || matcher.test(text) ) )
									return {
										label: text.replace(
											new RegExp(
												"(?![^&;]+;)(?!<[^<>]*)(" +
												$.ui.autocomplete.escapeRegex(request.term) +
												")(?![^<>]*>)(?![^&;]+;)", "gi"
											), "<strong>$1</strong>" ),
										value: text,
										option: this
									};
							}) );
						},
						select: function( event, ui ) {
							ui.item.option.selected = true;
							//select.val( ui.item.option.value );
							self._trigger( "selected", event, {
								item: ui.item.option
							});
						},
						change: function( event, ui ) {
							if ( !ui.item ) {
								var matcher = new RegExp( "^" + $.ui.autocomplete.escapeRegex( $(this).val() ) + "$", "i" ),
									valid = false;
								select.children( "option" ).each(function() {
									if ( this.value.match( matcher ) ) {
										this.selected = valid = true;
										return false;
									}
								});
								if ( !valid ) {
									// remove invalid value, as it didn't match anything
									$( this ).val( "" );
									select.val( "" );
									return false;
								}
							}
						}
					})
					.addClass( "" );
					//.addClass( "ui-widget ui-widget-content ui-corner-left" );

				input.data( "autocomplete" )._renderItem = function( ul, item ) {
					return $( "<li></li>" )
						.data( "item.autocomplete", item )
						.append( "<a>" + item.label + "</a>" )
						.appendTo( ul );
				};
			}
		});
	})(jQuery);
	$(document).ready(function() {
		//$("#user-search").hide();
		$('.hd').bind('click', function() {
			hideAndShow('user-search');
		});
		$("#user-search-button").bind('click', function() {
			searchUser(1);
		});
		searchUser(1);
		$("#user-new-button").bind('click', function() {
			//newUser();
			location.href="getUserInfoAction.action?userId=-1";
		});
		$("#company-id").combobox();
	});
</script>
</html>