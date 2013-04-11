<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<%@ taglib prefix="s" uri="/struts-tags"%>
	<%@ include file="../common/top.jsp"%>
	<link type="text/css" href="css/ui/jquery.ui.all.css" rel="stylesheet" />
	<script type="text/javascript"
		src="application/company/lib/company_search.js"></script>
	<s:action name="provinceListAction" id="provinceListAction"></s:action>
	<s:action name="companyCategoryListAction"
		id="companyCategoryListAction"></s:action>
	<body>
		<input type="hidden" name="currentPage" value="1" />
		<div id="search-box">
			<span class="rc-tp"><span></span> </span>
			<table width=100% class="hd" >
				<tr><td align="left">公司查询</td><td align="right">[展开/隐藏]</td></tr>
			</table>
			<form action="">
				<table width=100% id="company-search">

					<tr>

						<td class="sdingle-col">
							<input type="text" class="pure-text" value="公司ID:"
								readonly="readonly" />
							<input type="text" name="companyId" id="company-id" />
						</td>
						<td class="sdingle-col">
							<input type="text" class="pure-text" value="公司名称:"
								readonly="readonly" />
							<input type="text" name="companyName" id="company-name" />
						</td>

					</tr>
					<tr>
						<td class="sdingle-col">
							<input type="text" class="pure-text" value="公司分类:"
								readonly="readonly" />
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
						<td class="sdingle-col">
							<input type="text" class="pure-text" value="公司所在省份:"
								readonly="readonly" />
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

					</tr>
					<tr>
						<td class="sdingle-col">
							<input type="text" class="pure-text" value="RCN经销商代码:"
								readonly="readonly" />
							<input type="text" name="rcnNo" id="rcn-no" />
						</td>

					</tr>

					<tr>
						<td align="left">
							<input type="button" value="新建公司" id="company-new-button" />
						</td>
						<td class="search-button" align="right">
							<input type="button" value="检索" id="company-search-button" />
							<input type="reset" value="清空" />
						</td>
					</tr>
				</table>
			</form>
		</div>
		<br>
			<table id="company-search-result" bcompany="0" cellpadding="1"
				cellspacing="1" class="listing" width="100%" bgcolor="#CCCCCC">

				<thead>
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
						<th>
							公司所属省份代码
						</th>
						<th>
							操作
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
			<%@ include file="../../framework/system/bottom.jsp"%>
	</body>
	<script type="text/javascript">
	$(document).ready(function() {
		//$("#company-search").hide();
		$('.hd').bind('click', function() {
			hideAndShow('company-search');
		});

		$("#company-search-button").bind('click', function() {
			searchCompany(1);
		});
		$("#company-new-button").bind('click', function() {
			location.href = "companyInfoAction.action?companyId=";
		});
		searchCompany(1);
	});
	</script>
</html>