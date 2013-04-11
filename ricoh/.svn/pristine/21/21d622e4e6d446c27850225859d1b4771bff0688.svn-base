<%@ taglib prefix="s" uri="/struts-tags"%>

<s:action name="menuListAction" id="menuListAction"></s:action>
<table cellspacing="0" cellpadding="4" border="0" width="480">
	<tbody>
		<tr>
			<td align="right">
			<input id="moduleId" type="hidden" name="moduleId" value="<s:property value='moduleId'/>" />
				所属菜单：
			</td>
			<td>
				<p>
					<input type="text" name="parentModuleId" id="parentModuleId" value="<s:property value='parentModuleId'/>" />
				</p>
				<s:push value="menuListAction">
				<ul id="categorymenu" class="mcdropdown_menu">
					<li rel="0">默认分类</li>
					<s:iterator value="menuList">
					<li rel="<s:property value="info.id"/>">
						<s:property value="info.moduleName" />
						<ul>
							<s:iterator value="subList">
							<li rel="<s:property value="info.id"/>">
								<s:property value="info.moduleName" />
							</li>
							</s:iterator>
						</ul>
					</li>
					</s:iterator>
					
				</ul>
				</s:push>
			</td>
			<td></td>
		</tr>
		<tr>
			<td align="right">
				菜单名称：
			</td>
			<td>
				<input type="text" value="<s:property value="moduleName" />" style="width: 150px;" name="moduleName"
					id="moduleName" class="textbox" onchange="checkValueLength($(this),255)">
			</td>
		</tr>
		<tr>
			<td align="right">
				菜单别名：
			</td>
			<td>
				<input type="text" value="<s:property value="moduleAlias" />" style="width: 150px;" name="moduleAlias"
					id="moduleAlias" class="textbox" onchange="checkValueLength($(this),255)">
			</td>
		</tr>
		<tr>
			<td align="right">
				菜单链接：
			</td>
			<td>
				<input type="text" value="<s:property value="url" />" style="width: 190px;" name="url"
					id="moduleUrl" class="textbox" onchange="checkValueLength($(this),255)">
			</td>
		</tr>
		<tr>
			<td align="right">
				是否显示：
			</td>
			<td>
				<select name="showMenu" id="showMenu">
					<option value="Y">
						显示
					</option>
					<option value="N">
						隐藏
					</option>
				</select>
			</td>
		</tr>
		<tr>
			<td align="right" width="120">
				菜单排序：
			</td>
			<td width="180">
				<input type="text" value="<s:property value="sequence" />" style="width: 50px;" name="sequence"
					id="sequence" class="textbox" onchange="checkValueLength($(this),10);checkQty($(this))">
			</td>
		</tr>

	</tbody>
</table>
<script>
	$(document).ready(function() {
		$("#parentModuleId").mcDropdown("#categorymenu");
	});
</script>