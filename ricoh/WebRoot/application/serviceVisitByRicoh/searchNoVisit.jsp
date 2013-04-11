<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<%@ taglib prefix="s" uri="/struts-tags"%>
	<%@ include file="../common/top.jsp"%>
	<link type="text/css" href="css/ui/jquery.ui.all.css" rel="stylesheet" />
	<script type="text/javascript" src="js/jquery/ui/jquery.ui.core.js"></script>
	<script type="text/javascript" src="js/jquery/ui/jquery.ui.widget.js"></script>
	<script type="text/javascript" src="js/jquery/ui/jquery.ui.mouse.js"></script>
	<script type="text/javascript" src="js/jquery/ui/jquery.ui.button.js"></script>
	<script type="text/javascript" src="js/jquery/ui/jquery.ui.draggable.js"></script>
	<script type="text/javascript" src="js/jquery/ui/jquery.ui.position.js"></script>
	<script type="text/javascript" src="js/jquery/ui/jquery.ui.resizable.js"></script>
	<script type="text/javascript" src="js/jquery/ui/jquery.ui.dialog.js"></script>
	<script language="javascript" type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="application/serviceVisitByRicoh/lib/visit_search.js"></script>
	
	<s:action name="machineTypeListAction" id="machineTypeListAction"></s:action>
	<s:action name="serviceStatusListAction" id="serviceStatusListAction"></s:action>
	<body>
		<input type="hidden" name="currentPage" value="1" />
		<div id="search-box">
			<span class="rc-tp"><span></span> </span>
			<table width=100% class="hd" >
				<tr><td align="left">CS维修单回访</td><td align="right">[展开/隐藏]</td></tr>
			</table>
			<form action="">
				<table width=100% id="novisit-search">
					<tr>
						<td class="sdingle-col">
							<input type="text" class="pure-text" value="特约维修店名"
								readonly="readonly" />
							
							<input type="text" name="" id="company-name" />
						</td>

						<td class="double-cols">
							<input type="text" class="pure-text" value="维修单流水号"
								readonly="readonly" />
							
							<input type="text" name="" id="service-no" />
						</td>
					</tr>
					<tr>
						<td class="double-cols" colspan="3">
							<input type="text" class="pure-text" value="回访日期"
								readonly="readonly" />
							<input type="text" name="" id="from-service-apply-audited-date" onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'end-service-date\')}'})" class="Wdate" />
							-<input type="text" name="" id="end-service-apply-audited-date" onfocus="WdatePicker({minDate:'#F{$dp.$D(\'from-service-date\')}'})" class="Wdate" />
						</td>
					</tr>
					<tr align="right">
						<td></td>
						<td class="search-button">
							<input type="button" value="检索" id="novisit-search-button" />
							<input type="reset" value="清空" />
						</td>
					</tr>
				</table>
			</form>
		</div>
		<br>
			<table id="novisit-search-result" bnovisit="0" cellpadding="1"
				cellspacing="1" class="listing" width="100%" bgcolor="#CCCCCC">

				<thead>
					<tr>
						<th></th>
						<th>
							维修单流水号
						</th>
						<th>
							机型
						</th>
						<th>
							机号
						</th>
						<th>
							维修受理日
						</th>
						<th>
							费用审核日
						</th>
						<th>
							操作
						</th>

					</tr>
				</thead>
				<tbody>
				</tbody>
			</table>
			<table cellspacing="0" cellpadding="0" bnovisit="0" width="100%"
				style="bnovisit: 0px none;" id="novisit-search-page">
				<tbody>

				</tbody>
			</table><%@ include file="../../framework/system/bottom.jsp"%>
			<div id="dialog-form-visit" title="维修单回访">		
			<form>
			<table width="100%">
				<tr><td colspan="2"><font color="red">请仔细填写,确认回访后不可修改!</font></td></tr>
				<tr></tr>
				<tr></tr>
				<tr></tr>
				<tr>
				<td width="30%">
					<label >维修单流水号</label>
				</td>
				<td width="70%">
				<input type="hidden" id="visit-service-id"/>
					<input type="text" id="visit-service-no" disabled="disabled"/>
				</td>
				</tr>
			<tr>
				<td>
					<label >抽样范围</label>
				</td>
				<td>
					<input type="text" id="visit-flag" onchange="checkValueLength($(this),30)"/>
				</td>
				</tr>
			<tr>
				<td>
					<label >用户回访结果</label>
				</td>
				<td>
					<select id="visit-result">
						<option value="电话无人">电话无人</option>
						<option value="没有发生维修">没有发生维修</option>
						<option value="有维修不满意">有维修不满意</option>
						<option value="有维修一般">有维修一般</option>
						<option value="有维修满意">有维修满意</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>
					<label>用户回访记录</label>
				</td>
				<td>
					<textarea rows="3" cols="30" id="visit-memo" onchange="checkValueLength($(this),500)"></textarea>
				</td>
				</tr>
			</table>
			</form>
		</div>
	</body>
	<script type="text/javascript">
	
$(document)
		.ready(
				function() {
					//$("#novisit-search").hide();
					$('.hd').bind('click', function() {
						hideAndShow('novisit-search');
					});
					$("#novisit-search-button").bind('click', function() {
						searchNoVisit(1);
					});
					$("#dialog").dialog("destroy");
					$("#dialog-form-visit").dialog( {
						autoOpen : false,
						height : 300,
						width : 500,
						modal : true,
						buttons : {
							'回访结果确认' : function() {
								if(!confirm('是否确认回访结果?'))
									return;
								var v = visitServiceOrder();
								if(v)
									return;
								$(this).dialog('close');
							},
							'取消' : function() {
								$(this).dialog('close');
							}
						},
						close : function() {
							//allFields.val('').removeClass('ui-state-error');
						}
					});
					
				});
</script>
</html>