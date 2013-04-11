<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<%@ taglib prefix="s" uri="/struts-tags"%>
	<%@ include file="../common/top.jsp"%>
	<div>
		<ul style="color: red">
			<li>
				<s:property value="message" />
			</li>
		</ul>
		<input   type="button"   value="返回"   onclick= "window.history.go(-1)"/> 
	</div>
</html>

