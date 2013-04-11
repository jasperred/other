<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<%@ taglib prefix="s" uri="/struts-tags"%>
	<%@ include file="../common/top.jsp"%>
	<link type="text/css" href="css/ui/jquery.ui.all.css" rel="stylesheet" />
	<script type="text/javascript" src="application/productByRicoh/lib/machineType.js"></script>
	
	<s:action name="machineCatListAction" id="machineCatListAction"></s:action>
	<body>
		<input type="hidden" name="currentPage" value="1" />
		<div id="search-box">
			<span class="rc-tp"><span></span> </span>
			<table width=100% class="hd" >
				<tr><td align="left">维修机型</td><td align="right">[展开/隐藏]</td></tr>
			</table>
			<form action="">
				<table width=100% id="machine-type-search">
					<tr>
						
						<td class="sdingle-col">
							<input type="text" class="pure-text" value="机型:" readonly="readonly"/>
							<input type="text" name="" id="machine-type" />
						</td>
						<td class="sdingle-col">
							<input type="text" class="pure-text" value="商品编号:" readonly="readonly"/>
							<input type="text" name="" id="machine-cd" />
						</td>
						
					</tr>
					<tr>
						<td class="sdingle-col">
							<input type="text" class="pure-text" value="机型分类:" readonly="readonly"/>
							
							<s:push value="machineCatListAction">
							<select name="" id="machine-cat">
								<s:iterator value="machineCatList">
										<option value='<s:property value="MachineCatCode"/>'>
											<s:property value="MachineCatName" />
										</option>
								</s:iterator>
							</select>
							</s:push>
						</td>
						<td class="sdingle-col">
							<input type="text" class="pure-text" value="保修期内服务商:" readonly="readonly"/>
							<select name="" id="service-provider-type">
									<option value="">
									</option>
									<option value="特约维修店">特约维修店</option>
									<option value="销售商服务">销售商服务</option>
							</select>							
						</td>
							
					</tr>

					<tr>
						<td align="left"><input type="button" value="新建维修机型" id="machine-type-new-button" /></td>
						<td class="search-button" align="right">							
							<input type="button" value="检索" id="machine-type-search-button" />
							<input type="reset" value="清空" />
						</td>
					</tr>
				</table>
			</form>
		</div>
		<br>
			<table id="machine-type-search-result" bmachine-type="0" cellpadding="1"
				cellspacing="1" class="listing" width="100%" bgcolor="#CCCCCC">

				<thead>
					<tr>
						<th></th>						
						<th>
							机型ID
						</th>
						<th>
							机型
						</th>
						<th>
							商品编号
						</th>
						<th>
							机型分类
						</th>
						<th>
							保修期内服务商
						</th>
						<th>
							特约维修服务费（元/次）
						</th>
						<th>
							委托维修服务费（元/次）
						</th>
						<th>
							操作
						</th>
					</tr>
				</thead>
				<tbody>
				</tbody>
			</table>
			<table cellspacing="0" cellpadding="0" bmachine-type="0" width="100%"
				style="bmachine-type: 0px none;" id="machine-type-search-page">
				<tbody>

				</tbody>
			</table>
			<%@ include file="../../framework/system/bottom.jsp"%>
	</body>
	<script type="text/javascript">
	$(document).ready(function() {
		//$("#machine-type-search").hide();
		$('.hd').bind('click', function() {
			hideAndShow('machine-type-search');
		});
		
		$("#machine-type-search-button").bind('click', function() {
			searchMachineType(1);
		});		
		searchMachineType(1);
		$("#machine-type-new-button").bind('click', function() {
			location.href="machineTypeInfoAction.action?machineTypeId=";
		});	
	});
</script>
</html>