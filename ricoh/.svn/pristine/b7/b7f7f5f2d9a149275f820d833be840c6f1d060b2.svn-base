<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<%@ taglib prefix="s" uri="/struts-tags"%>
	<%@ include file="../common/top.jsp"%>
	<script type="text/javascript"
		src="application/productByRicoh/lib/machineImport.js"></script>

	<body>
		<div id="search-box">
			<table width=100% class="hd" >
				<tr><td align="left">EXCEED导入</td></tr>
			</table>
			<form action="machineFileUploadAction.action" method="post"
				enctype="multipart/form-data" id="exceed-form">
				<table width=100% id="order-search">

					<tr>

						<td class="sdingle-col">
							<input type="hidden" name="filePath"
								value="file.import.exceed.path" />
							<label>
								文件:
							</label>
							<span class=""><input type="file" name="uploadFile"
									id="exceed-upload-file" /> </span>
						</td>
						<td>
							<input type="button" value="上传" onclick="fileUpload('exceed-form','exceed-upload-file')" />
						</td>

					</tr>
				</table>
			</form>
			<table id="inventory-search-result" border="0" cellpadding="1"
				cellspacing="1" class="listing" width="100%" bgcolor="#CCCCCC">

				<thead>
					<tr>
						<th>
							文件
						</th>
						<th>
							时间
						</th>
						<th>
							大小
						</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="exceedFileList" status="li">
						<tr id='exceed_<s:property value="#li.index"/>'>
							<td><s:property value="fileName"/></td>
							<td><s:property value="fileDate"/></td>
							<td><s:property value="fileSize"/></td>
							<td>
								<input type="button" value="执行" onclick="importExceed('<s:property value="fileName"/>','exceed_<s:property value="#li.index"/>')"/>
								<input type="button" value="删除" onclick="deleteFile('<s:property value="fileName"/>','file.import.exceed.path','exceed_<s:property value="#li.index"/>')"/>
							</td>
						</tr>
					</s:iterator>
				</tbody>
			</table>
			<table width=100% class="hd" >
				<tr><td align="left">服务费导入</td></tr>
			</table>
			<form action="machineFileUploadAction.action" method="post"
				enctype="multipart/form-data" id="service-rate-form">
				<table width=100% id="order-search">

					<tr>

						<td class="sdingle-col">
							<input type="hidden" name="filePath"
								value="file.import.srate.path" />
							<label>
								文件:
							</label>
							<span class=""><input type="file" name="uploadFile"
									id="rate-upload-file" /> </span>
						</td>
						<td>
							<input type="button" value="上传" onclick="fileUpload('service-rate-form','rate-upload-file')" />
						</td>

					</tr>
				</table>
			</form>
			<table id="inventory-search-result" border="0" cellpadding="1"
				cellspacing="1" class="listing" width="100%" bgcolor="#CCCCCC">

				<thead>
					<tr>
						<th>
							文件
						</th>
						<th>
							时间
						</th>
						<th>
							大小
						</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="serviceRateFileList" status="li">
						<tr id='service_rate_<s:property value="#li.index"/>'>
							<td><s:property value="fileName"/></td>
							<td><s:property value="fileDate"/></td>
							<td><s:property value="fileSize"/></td>
							<td>
							<input type="button" value="执行" onclick="importServiceRate('<s:property value="fileName"/>','service_rate_<s:property value="#li.index"/>')"/>
							<input type="button" value="删除" onclick="deleteFile('<s:property value="fileName"/>','file.import.srate.path','service_rate_<s:property value="#li.index"/>')"/>
							</td>
						</tr>
					</s:iterator>
				</tbody>
			</table>
			<table width=100% class="hd" >
				<tr><td align="left">维修能力导入</td></tr>
			</table>
			<form action="machineFileUploadAction.action" method="post"
				enctype="multipart/form-data" id="company-machine-ref-form">
				<table width=100% id="order-search">

					<tr>

						<td class="sdingle-col">
							<input type="hidden" name="filePath"
								value="file.import.cmr.path" />
							<label>
								文件:
							</label>
							<span class=""><input type="file" name="uploadFile"
									id="cmr-upload-file" /> </span>
						</td>
						<td>
							<input type="button" value="上传" onclick="fileUpload('company-machine-ref-form','cmr-upload-file')" />
							
						</td>

					</tr>
				</table>
			</form>
			<table id="inventory-search-result" border="0" cellpadding="1"
				cellspacing="1" class="listing" width="100%" bgcolor="#CCCCCC">

				<thead>
					<tr>
						<th>
							文件
						</th>
						<th>
							时间
						</th>
						<th>
							大小
						</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="companyMachineTypeRefFileList" status="li">
						<tr id='cmtrf_<s:property value="#li.index"/>'>
							<td><s:property value="fileName"/></td>
							<td><s:property value="fileDate"/></td>
							<td><s:property value="fileSize"/></td>
							<td><input type="button" value="执行" onclick="importCompanyMachineRef('<s:property value="fileName"/>','cmtrf_<s:property value="#li.index"/>')"/>
							<input type="button" value="删除" onclick="deleteFile('<s:property value="fileName"/>','file.import.cmr.path','cmtrf_<s:property value="#li.index"/>')"/></td>
						</tr>
					</s:iterator>
				</tbody>
			</table>
		</div>
		<div>
			<ul id="import-message" style="color: red;">
			</ul>
		</div>
		<%@ include file="../../framework/system/bottom.jsp"%>
	</body>

</html>