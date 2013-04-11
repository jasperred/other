<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<%@ taglib prefix="s" uri="/struts-tags"%>
	<%@ include file="../common/top.jsp"%>
	<script type="text/javascript" src="application/productByRicoh/lib/machineType.js"></script>
	
	<s:action name="machineCatListAction" id="machineCatListAction"></s:action>
	<body>
		<div id="search-box">
			<span class="rc-tp"><span></span> </span>
			<table width=100% class="hd" >
				<tr><td align="left">机型信息</td></tr>
			</table>
			<table>
				<tr>
					<td >
						<input type="text" class="pure-text" value="机型ID:"
							readonly="readonly" />
						<input type="text" name="" id="machine-type-id" readonly="readonly" disabled="disabled"/>
					</td>
				</tr>
				<tr>
					<td >
						<input type="text" class="pure-text" value="机型:"
							readonly="readonly" />
						<input type="text" name="" id="machine-type" onchange="checkValueLength($(this),255)" />
					</td>
					<td >
						<input type="text" class="pure-text" value="商品编号:"
							readonly="readonly" />
						<input type="text" name="" id="machine-cd" onchange="checkValueLength($(this),30)" />
					</td>
				</tr>
				<tr>
					<td >
						<input type="text" class="pure-text" value="机型分类:"
							readonly="readonly" />
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
					<td >
						<input type="text" class="pure-text" value="保修期内服务商:"
							readonly="readonly" />
						<select name="" id="service-provider-type">
							<option value="特约维修店">
								特约维修店
							</option>
							<option value="销售商服务">
								销售商服务
							</option>
						</select>
					</td>
				</tr>
				<tr>
					<td >
						<input type="text" class="pure-text" value="特约维修服务费（元/次）:"
							readonly="readonly" />
						<input type="text" name="" id="rate1" onchange="checkPrice($(this));checkValueLength($(this),18)"/>
					</td>
					<td >
						<input type="text" class="pure-text" value="委托维修服务费（元/次）:"
							readonly="readonly" />
						<input type="text" name="" id="rate2" onchange="checkPrice($(this));checkValueLength($(this),18)"/>
					</td>
				</tr>
				<tr>
					<td >
						<input type="text" class="pure-text" value="创建者:"
							readonly="readonly" />
						<input type="text" name="" id="cuser" readonly="readonly" disabled="disabled"/>
					</td>
					<td >
						<input type="text" class="pure-text" value="创建时间:"
							readonly="readonly" />
						<input type="text" name="" id="ctime" readonly="readonly" disabled="disabled"/>
					</td>
				</tr>

				<tr>
					<td></td>
					<td align="right">
						<input type="button" value="保存" id="machine-type-save-button" />
						<input type="button" value="取消" id="machine-type-cancel-button" />
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

		$("#machine-type-save-button").bind('click', function() {
			saveMachineType();
		});
		$("#machine-type-cancel-button").bind('click', function() {
			location.href = "viewMachineTypeAction.action";
		});
		var machineTypeId = unicodeToString('<s:property value="machineTypeId"/>');
		var machineType = unicodeToString('<s:property value="machineType"/>');
		var machineCd = unicodeToString('<s:property value="machineCd"/>');
		var machineCat = unicodeToString('<s:property value="machineCat"/>');
		var serviceProviderType = unicodeToString('<s:property value="serviceProviderType"/>');
		var rate1 = unicodeToString('<s:property value="rate1"/>');
		var rate2 = unicodeToString('<s:property value="rate2"/>');
		var ctime = unicodeToString('<s:property value="ctime"/>');
		var cuser = unicodeToString('<s:property value="cuser"/>');
		setMachineTypeInfo(machineTypeId,machineType,machineCd,machineCat,serviceProviderType,rate1,rate2,ctime,cuser);
	});
	</script>
</html>
