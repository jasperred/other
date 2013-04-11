<link type="text/css" href="css/ui/jquery.ui.all.css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery/ui/jquery.ui.core.js"></script>
<script type="text/javascript" src="js/jquery/ui/jquery.ui.widget.js"></script>
<script type="text/javascript" src="js/jquery/ui/jquery.ui.mouse.js"></script>
<script type="text/javascript" src="js/jquery/ui/jquery.ui.button.js"></script>
<script type="text/javascript" src="js/jquery/ui/jquery.ui.draggable.js"></script>
<script type="text/javascript" src="js/jquery/ui/jquery.ui.position.js"></script>
<script type="text/javascript" src="js/jquery/ui/jquery.ui.resizable.js"></script>
<script type="text/javascript" src="js/jquery/ui/jquery.ui.dialog.js"></script>
<script type="text/javascript"
	src="application/company/lib/company_dialog_search.js"></script>
<s:action name="provinceListAction" id="provinceListAction"></s:action>
<s:action name="companyCategoryListAction"
	id="companyCategoryListAction"></s:action>
<div id="dialog-form-company" title="公司查询">
	<form action="">
	<table width=100% id="company-search">
		<tr>
			<td class="sdingle-col">
				公司名称:
				<input type="text" name="companyName" id="company-name" />
			</td>
			<td class="sdingle-col" id="company-category">
				公司分类:
				<s:push value="companyCategoryListAction">
					<select name="companyCategoryNo" id="company-category-no">
						<option value="">
						</option>
						<s:iterator value="companyCategoryList">
							<option value='<s:property value="UnitNo"/>'>
								<s:property value="UnitName" />
							</option>
						</s:iterator>
					</select>
				</s:push>
			</td>
			<tr>
				<td class="sdingle-col">
					公司省份:
					<s:push value="provinceListAction">
						<select name="companyProvinceNo" id="company-province-no">
							<option value="">
							</option>
							<s:iterator value="provinceList">
								<option value='<s:property value="id"/>'>
									<s:property value="ProvinceName" />
								</option>
							</s:iterator>
						</select>
					</s:push>
				</td>

				<td>
					RCN代码:
					<input type="text" name="rcnNo" id="rcn-no" />
				</td>

			</tr>
		<tr align="right">
			<td></td>
			<td class="search-button">
				<input type="button" value="检索" id="company-search-button" />
				<input type="reset" value="清空" />
			</td>
		</tr>
	</table>
	</form>
	<table id="company-search-result" cellpadding="1" cellspacing="1"
		width="100%">

		<thead bgcolor="#CCCCCC">
			<tr>
				<th></th>
				<th>
					公司ID
				</th>
				<th>
					公司名称
				</th>
				<th>
					公司分类
				</th>

				<th>
					RCN经销商代码
				</th>
				<th>
					公司所属省份
				</th>
			</tr>
		</thead>
		<tbody>
		</tbody>
	</table>
	<table cellspacing="0" cellpadding="0" bcompany="0" width="100%"
		style="bcompany: 0px none;" id="company-search-page">
		<tbody>

		</tbody>
	</table>
</div>
<script type="text/javascript">
	$(document).ready(function() {

		$("#company-search-button").bind('click', function() {
			searchDialogCompany(1);
		});
	});
</script>