<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<%@ taglib prefix="s" uri="/struts-tags"%>
	<%@ include file="../common/top.jsp"%>
	<script language="javascript" type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="application/serviceVisitByRicoh/lib/visit_search.js"></script>
	
	
	<body>
		<input type="hidden" name="currentPage" value="1" />
		<div id="search-box">
			<span class="rc-tp"><span></span> </span>
			<table width=100% class="hd" >
				<tr><td align="left">CS维修单回访查询</td><td align="right">[展开/隐藏]</td></tr>
			</table>
			<form action="">
				<table width=100% id="visit-search">

					<tr>
						<td >
							<input type="text" class="pure-text" value="特约维修店名"
								readonly="readonly" />
							
							<input type="text" name="" id="company-name" />
						</td>

						<td >
							<input type="text" class="pure-text" value="维修单流水号"
								readonly="readonly" />
							
							<input type="text" name="" id="service-no" />
						</td>
						<td >
							<input type="text" class="pure-text" value="用户回访人"
								readonly="readonly" />
							
							<input type="text" name="" id="visit-people" />
						</td>
					</tr>
					<tr>
						
						<td  colspan="3">
							<input type="text" class="pure-text" value="用户回访日期" readonly="readonly"/>
							<input type="text"  id="visit-from-date" onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'visit-end-date\')}',dateFmt:'yyyy-MM-dd'})" class="Wdate"/>
							-<input type="text"  id="visit-end-date" onfocus="WdatePicker({minDate:'#F{$dp.$D(\'visit-from-date\')}',dateFmt:'yyyy-MM-dd'})" class="Wdate" />
						</td>
					</tr>
					
					

					<tr align="right">
						<td></td>
						<td></td>
						<td class="search-button">
							<input type="button" value="检索" id="visit-search-button" />
							<input type="reset" value="清空" />
						</td>
					</tr>
				</table>
			</form>
		</div>
		<br>
			<table id="visit-search-result" bvisit="0" cellpadding="1"
				cellspacing="1" class="listing" width="100%" bgcolor="#CCCCCC">

				<thead>
					<tr>
						<th></th>
						<th>
							用户回访ID
						</th>
						<th>
							维修单流水号
						</th>
						<th>
							特约维修店
						</th>
						<th>
							抽样范围
						</th>
						<th>
							用户回访结果
						</th>
						<th>
							用户回访记录
						</th>
						<th>
							用户回访日期
						</th>
						<th>
							用户回访人
						</th>
						
					</tr>
				</thead>
				<tbody>
				</tbody>
			</table>
			<table cellspacing="0" cellpadding="0" bvisit="0" width="100%"
				style="bvisit: 0px none;" id="visit-search-page">
				<tbody>

				</tbody>
			</table><%@ include file="../../framework/system/bottom.jsp"%>
	</body>
	<script type="text/javascript">
	$(document)
			.ready(function() {
				//$("#visit-search").hide();
				$('.hd').bind('click', function() {
					hideAndShow('visit-search');
				});				
					$("#visit-search-button").bind('click', function() {
						searchVisit(1);
					});
				});
</script>
</html>