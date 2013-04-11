<%@ taglib prefix="s" uri="/struts-tags"%>
<s:action name="navigateListAction" id="navigateListAction"></s:action>
<s:push value="navigateListAction">
<div style="height: 100%; width: 100%; display: block;"
	id="gen-tabs-panel0">
	<ul>
		<s:iterator value="navigateList">
		
		</s:iterator>
		
	</ul>
</div>
</s:push>