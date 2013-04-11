<%@ taglib prefix="s" uri="/struts-tags"%>
<table>

	<tr>
		<td>
			<label>
				区域代码:
			</label>
		</td>
		<td>
			<span><s:if test="areaCd==null">
					<input type="text" id="sg-area-cd" onchange="checkValueLength($(this),30)"
						value='<s:property value="areaCd"/>' />
				</s:if>
				<s:else>
					<input type="text" id="sg-area-cd"
						value='<s:property value="areaCd"/>' disabled="disabled" />
				</s:else> </span>
		</td>
	</tr>
	<tr>
		<td>
			<label>
				区域名称:
			</label>
		</td>
		<td>
			<span><input type="text" id="sg-area-name" onchange="checkValueLength($(this),255)"
					value='<s:property value="areaName"/>' /> </span>
		</td>
	</tr>
</table>

