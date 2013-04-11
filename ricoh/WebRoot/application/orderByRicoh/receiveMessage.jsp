<%@ taglib prefix="s" uri="/struts-tags"%>

<table>
	<tr>
		<td>
			<label>
				保留原因:
			</label>
			<span class=""><select name="receiveMessage" id="receive-message">
						<s:iterator value="statusList">

							<option value="<s:property value='statusCode'/>">
								<s:property value='description' />
							</option>
						</s:iterator>
				</select> </span>
		</td>
	</tr>
</table>