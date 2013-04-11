<%@ taglib prefix="s" uri="/struts-tags"%>
<body onmousemove= "window.status= '欢迎 '"> 
<!-- menu -->
<s:action name="userMenuAction" id="userMenuAction"></s:action>
<s:push value="userMenuAction">
	<div id="menu">
		<s:iterator value="userMenuList">
			<h3>
				<a href="#"><s:property value="info.moduleName" /></a>
			</h3>
			<div>
				<ul>
					<s:iterator value="subList">
						<li>
							<a href="<s:property value="info.url"/>" target="mainFrame"><s:property
									value="info.moduleName" />
							</a>
						</li>
					</s:iterator>
				</ul>
			</div>
		</s:iterator>
	</div>
</s:push>
</body>
<script type="text/javascript">
	$(function() {
		var icons = {
			header : "ui-icon-circle-arrow-e",
			headerSelected : "ui-icon-circle-arrow-s"
		};
		$("#menu").accordion( {
			icons : icons,
			fillSpace : true
		});
		$("#toggle").button().toggle(function() {
			$("#menu").accordion("option", "icons", false);
		}, function() {
			$("#menu").accordion("option", "icons", icons);
		});
	});
</script>
<!-- end menu -->

