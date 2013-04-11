<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<%@ taglib prefix="s" uri="/struts-tags"%>
	<%@ include file="../common/top.jsp"%>
	<script type="text/javascript" src="application/company/lib/company_info.js"></script>
	<s:action name="provinceListAction" id="provinceListAction"></s:action>
	<s:action name="companyCategoryListAction"
		id="companyCategoryListAction"></s:action>
	<body>
		<div id="search-box">
			<span class="rc-tp"><span></span> </span>
			<table width=100% class="hd" >
				<tr><td align="left">公司信息</td></tr>
			</table>
			<table>
				<tr>
					<td class="sdingle-col">
						<input type="text" class="pure-text" value="公司ID:"
							readonly="readonly" />
						<input type="hidden" name="companyId" id="company-id" disabled="disabled"/>
						<input type="text" name="companyNo" id="company-no" disabled="disabled"/>
					</td>
					<td class="sdingle-col">
						<input type="text" class="pure-text" value="公司名称:"
							readonly="readonly" />
						<input type="text" name="companyName" id="company-name" onchange="checkValueLength($(this),100)" />
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
						<input type="text" class="pure-text" value="RCN经销商代码:"
							readonly="readonly" />
						<input type="text" name="rcnNo" id="rcn-no" onchange="checkValueLength($(this),30)" />
					</td>
				</tr>
				<tr>
					<td class="sdingle-col">
						<input type="text" class="pure-text" value="公司所属省份:"
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
					<td class="sdingle-col">
						<input type="text" class="pure-text" value="公司所属城市:"
							readonly="readonly" />
						<input type="text" name="companyCity" id="company-city" onchange="checkValueLength($(this),30)" />
					</td>
				</tr>
				<tr>
					<td class="sdingle-col">
						<input type="text" class="pure-text" value="公司联系地址:"
							readonly="readonly" />
						<input type="text" name="companyAddress" id="company-address" onchange="checkValueLength($(this),255)" />
					</td>
					<td class="sdingle-col">
						<input type="text" class="pure-text" value="公司邮政编码:"
							readonly="readonly" />
						<input type="text" name="companyZip" id="company-zip" onchange="checkValueLength($(this),10)" />
					</td>
				</tr>
				<tr>
					<td class="sdingle-col">
						<input type="text" class="pure-text" value="公司联系电话:"
							readonly="readonly" />
						<input type="text" name="companyTel" id="company-tel" onchange="checkValueLength($(this),20)" />
					</td>
					<td class="sdingle-col">
						<input type="text" class="pure-text" value="公司收件人:"
							readonly="readonly" />
						<input type="text" name="companyContact" id="company-contact" onchange="checkValueLength($(this),30)" />
					</td>
				</tr>
				<tr>
					<td></td>
					<td align="right">
						<input type="button" value="保存" id="company-save-button" />
						<input type="button" value="取消" id="company-cancel-button" />
					</td>
				</tr>
			</table>
		</div>
		<div>
			<ul id="message" style="color: red;">
			</ul>
		</div>
		<%@ include file="../../framework/system/bottom.jsp"%>
	</body>
	<script type="text/javascript">
	$(document).ready(function() {

		$("#company-save-button").bind('click', function() {
			saveCompany();
		});
		$("#company-cancel-button").bind('click', function() {
			if(!confirm('是否取消?'))
				return;
			location.href = "viewCompanyAction.action";
		});
		var companyId = unicodeToString('<s:property value="companyId"/>');
		var companyNo = unicodeToString('<s:property value="companyNo"/>');
		var companyName = unicodeToString('<s:property value="companyName"/>');
		var companyCategoryNo = unicodeToString('<s:property value="companyCategoryNo"/>');
		var rcnNo = unicodeToString('<s:property value="rcnNo"/>');
		var provinceNo = unicodeToString('<s:property value="provinceNo"/>');
		var companyCity = unicodeToString('<s:property value="companyCity"/>');
		var companyAddress = unicodeToString('<s:property value="companyAddress"/>');
		var companyZip = unicodeToString('<s:property value="companyZip"/>');
		var companyTel = unicodeToString('<s:property value="companyTel"/>');
		var companyContact = unicodeToString('<s:property value="companyContact"/>');
		setCompanyInfo(companyId,companyNo,companyName,companyCategoryNo,rcnNo,provinceNo,companyCity,companyAddress,companyZip,companyTel,companyContact);
	});
	</script>
</html>
