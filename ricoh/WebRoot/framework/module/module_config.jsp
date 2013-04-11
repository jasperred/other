<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ include file="../common/top.jsp"%>
<SCRIPT type="text/javascript" src="js/jquery/ui/jquery-ui-latest.js"></SCRIPT>
<script type="text/javascript" src="js/jquery/ui/jquery.treeTable.js"></script>
<script type="text/javascript" src="framework/module/lib/module_config.js"></script>
<link type="text/css" href="css/ui/jquery.treeTable.css"
	rel="stylesheet" />
<script type="text/javascript"
	src="js/jquery/ui/jquery.mcdropdown.min.js"></script>
<link type="text/css" href="css/ui/jquery.mcdropdown.min.css"
	rel="stylesheet" media="all" />
<link type="text/css" href="css/my/my.css" rel="stylesheet" />
<s:action name="menuListAction" id="menuListAction"></s:action>
<div style="background: #DDDDDD">
	<h3>
		菜单配置
	</h3>
</div>
<p align="right">
	<input type="button" value="新建" onclick=
	saveModule(0);;
>
</p>
<table id="module-treetable" class="listing" width="100%" bgcolor="#CCCCCC">
	<thead>
		<tr>
			<th width="20%">
				标题
			</th>
			<th width="10%">
				别名
			</th>
			<th width="20%">
				链接
			</th>
			<th width="15%">
				是否显示
			</th>
			<th width="15%">
				排序
			</th>
			<th width="20%">
				操作
			</th>
		</tr>
	</thead>
	<tbody>
		<s:push value="menuListAction">
			<s:iterator value="menuList" status="uml">
				<tr id="node-<s:property value="(#uml.index+1)*100"/>">
					<td>
						<span class="folder"><s:property value="info.moduleName" />
						</span>
					</td>
					<td>
						<s:property value="info.moduleAlias" />
					</td>
					<td>
						<s:property value="info.url" />
					</td>
					<td>
						<s:property value="info.showMenu" />
					</td>
					<td>
						<s:property value="info.sequence" />
					</td>
					<td>
						<a href="#"
							onclick="saveModule('<s:property value="info.id" />');">修改</a><span></span><a
							href="#"
							onclick="deleteModule('<s:property value="info.id" />','node-<s:property value="(#uml.index+1)*100"/>');">删除</a>
					</td>
				</tr>
				<s:iterator value="subList" status="sl">
					<tr id="node-<s:property value="(#uml.index+1)*100+#sl.index+1"/>"
						class="child-of-node-<s:property value="(#uml.index+1)*100"/>">
						<td>
							<span class="file"><s:property value="info.moduleName" />
							</span>
						</td>
						<td>
							<s:property value="info.moduleAlias" />
						</td>
						<td>
							<s:property value="info.url" />
						</td>
						<td>
							<s:property value="info.showMenu" />
						</td>
						<td>
							<s:property value="info.sequence" />
						</td>
						<td>
							<a href="#"
								onclick="saveModule('<s:property value="info.id" />');">修改</a><span></span><a
								href="#"
								onclick="deleteModule('<s:property value="info.id" />', 'node-<s:property value="(#uml.index+1)*100+#sl.index+1"/>')">删除</a>
						</td>
					</tr>
				</s:iterator>
			</s:iterator>
		</s:push>
	</tbody>
</table>
<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$("#module-treetable").treeTable( {
							initialState : "collapsed",
							expandable : true
						});

						$("#module-treetable .folder")
								.each(
										function() {
											$($(this).parents("tr")[0])
													.droppable(
															{
																accept : ".file, .folder",
																drop : function(
																		e, ui) {
																	$(
																			$(
																					ui.draggable)
																					.parents(
																							"tr")[0])
																			.appendBranchTo(
																					this);
																},
																hoverClass : "accept",
																over : function(
																		e, ui) {
																	if (this.id != $(ui.draggable
																			.parents("tr")[0]).id
																			&& !$(
																					this)
																					.is(
																							".expanded")) {
																		$(this)
																				.expand();
																	}
																}
															});
										});

						// Make visible that a row is clicked
						$("table#module-treetable tbody tr").mousedown(
								function() {
									$("tr.selected").removeClass("selected"); // Deselect currently selected rows
									$(this).addClass("selected");
								});

						// Make sure row is selected when span is clicked
						$("table#module-treetable tbody tr span").mousedown(
								function() {
									$($(this).parents("tr")[0]).trigger(
											"mousedown");
								});
					});
</script>
