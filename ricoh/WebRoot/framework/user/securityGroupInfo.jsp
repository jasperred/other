<%@ taglib prefix="s" uri="/struts-tags"%>
<table>

	<tr>
		<td>
			<label>
				角色ID:
			</label>
		</td>
		<td>
			<span><s:if test="groupId==null">
					<input type="text" id="sg-group-id" onchange="checkValueLength($(this),255)"
						value='<s:property value="groupId"/>' />
				</s:if>
				<s:else>
					<input type="text" id="sg-group-id"
						value='<s:property value="groupId"/>' disabled="disabled" />
				</s:else> </span>
		</td>
	</tr>
	<tr>
		<td>
			<label>
				名称:
			</label>
		</td>
		<td>
			<span><input type="text" id="sg-group-name" onchange="checkValueLength($(this),255)"
					value='<s:property value="groupName"/>' /> </span>
		</td>
	</tr>
	<tr>
		<td>
			<label>
				级别:
			</label>
		</td>
		<td>
			<span><select id="sg-level"><option value="1">1</option><option value="2">2</option><option value="3">3</option><option value="4">4</option></select> </span>
		</td>
	</tr>
</table>
<script type="text/javascript">
<!--
	$(document).ready(function() {
		var level = '<s:property value="level"/>';
		$("#sg-level").val(level);
	});
//-->
</script>
