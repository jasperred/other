<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<%@ taglib prefix="s" uri="/struts-tags"%>
	<%@ include file="../common/top.jsp"%>
	<script type="text/javascript" src="framework/user/lib/user_info.js"></script>
	<body>
		<div id="search-box">
			<span class="rc-tp"><span></span> </span>
			<div class="hd" id="user-info-banner">
				<h3>
					用户信息
				</h3>
			</div>
			<table>
				<tr>
					<td>
						<label>
							用户NO:
						</label>
					</td>
					<td>
						<span> <s:if test="userId<=0">
								<input type="text" id="u-user-no"  disabled="disabled"/>
								<input type="hidden" id="u-user-id"
									value='-1' />
							</s:if> <s:else>
								<input type="text" disabled="disabled" id="u-user-no"
									value='<s:property value="userNo"/>' />
								<input type="hidden" id="u-user-id"
									value='<s:property value="userId"/>' />
							</s:else> </span>
					</td>
				</tr>
				<tr>
					<td>
						<label>
							用户姓名:
						</label>
					</td>
					<td>
						<span><input type="text" id="u-user-name" onchange="checkValueLength($(this),50)"  /></span>
					</td>
				</tr>
				<s:if test="userId<0">
					<tr>
						<td>
							<label>
								密码:
							</label>
						</td>
						<td>
							<span><input type="password" id="u-pwd"  onchange="checkValueLength($(this),60)"/> </span>
						</td>
					</tr>
					<tr>
						<td>
							<label>
								确认密码:
							</label>
						</td>
						<td>
							<span><input type="password" id="u-re-pwd"  onchange="checkValueLength($(this),60)"/> </span>
						</td>
					</tr>
				</s:if>
				<tr>
					<td>
						<label>
							邮件:
						</label>
					</td>
					<td>
						<span> <input type="text" id="u-email" onchange="checkValueLength($(this),255)" /> </span>
					</td>
				</tr>
				<tr>
					<td>
						<label>
							技术员代码:
						</label>
					</td>
					<td>
						<span> <input type="text" id="u-tec-no" onchange="checkValueLength($(this),30)" /> </span>
					</td>
				</tr>
				<tr>
					<td>
						<label>
							状态:
						</label>
					</td>
					<td>
						<span><select name="enabled" id="u-enabled">
								<s:if test="enabled==null||enabled.equals(\"Y\")">
									<option value="Y" selected="selected">
										有效
									</option>
									<option value="N">
										无效
									</option>
								</s:if>
								<s:else>
									<option value="Y">
										有效
									</option>
									<option value="N" selected="selected">
										无效
									</option>
								</s:else>

							</select> </span>
					</td>
				</tr>
				<tr>
					<td>
						<label>
							公司:
						</label>
					</td>
					<td>
						<s:if test="CompanyStatus.equals(\"NORMAL\")">
							<input id="u-company-id" type="hidden" readonly="readonly" disabled="disabled" name="" value="<s:property value="companyId"/>"/>
							<input id="u-company-no" type="text" readonly="readonly" disabled="disabled"  name="" value="<s:property value="companyNo"/>"/>
							<input id="u-company-name" type="text" name="" readonly="readonly" disabled="disabled"  value="<s:property value="companyName"/>"/>
						</s:if>
						<s:else>
							<input id="u-company-id" type="hidden" readonly="readonly" disabled="disabled"  name="" value=""/>
							<input id="u-company-no" type="text" readonly="readonly" disabled="disabled"  name="" value=""/>
							<input id="u-company-name" type="text" name="" readonly="readonly" disabled="disabled"  value=""/>
						</s:else>
						<input type="button" id="company-search" value="查询"/>
					</td>
				</tr>
				<tr align="right"><td></td><td><input id="user-save-button" type="button" value="保存"/><input id="user-cancel-button" type="button" value="返回"/></td></tr>
			</table>
		</div>
		<div><ul style="color: red" id="user-message"></ul></div>
		<%@ include file="../../application/company/companyDialogSearch.jsp"%>
		<%@ include file="../../framework/system/bottom.jsp"%>
	</body>
	<script type="text/javascript">
	$(document).ready(function() {
		$("#user-save-button").bind('click', function() {
			saveUser();
		});
		$("#user-cancel-button").bind('click', function() {
			location.href="viewUserSearchAction.action";
		});
		$("#company-search").bind('click', function() {
			$('#dialog-form-company').dialog('open');
		});
		$("#dialog-form-company").dialog({
			autoOpen: false,
			height: 500,
			width: 550,
			position : [450,'center'],
			modal: true,
			buttons: {
				'选择': function() {
					var checks = $("#company-search-result ").find("input[type='checkbox']:checked");
					if(checks.length==0)
						return;
					var tds = checks.eq(0).parent().parent().find("td");
					$("#u-company-id").val($.trim(checks.eq(0).attr("company-id")));
					$("#u-company-no").val($.trim(tds.eq(1).text()));
					$("#u-company-name").val($.trim(tds.eq(2).text()));
					$(this).dialog('close');
				},
				'取消': function() {
					$(this).dialog('close');
				}
			},
			close: function() {
				//allFields.val('').removeClass('ui-state-error');
			}
		});
		$("#u-user-name").val(unicodeToString('<s:property value="userName"/>'));
		$("#u-email").val(unicodeToString('<s:property value="email"/>'));
		$("#u-tec-no").val(unicodeToString('<s:property value="tecNo"/>'));
	});
</script>
</html>