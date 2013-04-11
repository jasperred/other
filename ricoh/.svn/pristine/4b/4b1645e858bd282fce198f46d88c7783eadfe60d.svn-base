<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<%@ taglib prefix="s" uri="/struts-tags"%>
	<%@ include file="../common/top.jsp"%>

	<body>
		<input type="hidden" name="currentPage" value="1" />
		<div id="search-box">
			<span class="rc-tp"><span></span> </span>
			<table width=100% class="hd" >
				<tr><td align="left">机器查询</td></tr>
			</table>
			<form action="">
				<table width=100% id="order-search">

					<tr>
						<td class="sdingle-col">
							<input type="text" class="pure-text" value="机号"
								readonly="readonly" />
							<input type="text" id="machine-no" />
							<input type="button" id="machine-search" value="查询" />
						</td>
					</tr>


				</table>
			</form>

		</div>
		<div id="machine-check">
			
		</div>
		<%@ include file="../../framework/system/bottom.jsp"%>
	</body>
	<script type="text/javascript">
	$(document).ready(function() {
		$("#machine-search").bind('click', function() {
			machineCheck();
		});
	});
	function machineCheck()
	{
		var machineNo = $.trim($("#machine-no").val());
		if(machineNo.length==0)
			return;
		$.ajax( {
		type : "POST",
		url : "checkMachineAction.action",
		data : {
			machineNo : replaceSpecialCharacters(machineNo)
		},
		success : function(msg) {
			$("#machine-check").html(msg);
		}
	});
	}
</script>
</html>