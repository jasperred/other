<div id="loading" style="display: none;">
	<img src='images/ajax_loading.gif' />
</div>
<div id="fullbg"></div>
<script type="text/javascript">
	ajax_loading();
	function ajax_loading() {//ajax loading
		$("#loading").ajaxStart(function() {
			$(this).show();
			showBg();

		});
		$("#loading").ajaxStop(function() {
			$(this).hide();
			closeBg();
		});
	}
	//显示灰色 jQuery 遮罩层
	function showBg() {
	    var bh = $(document).height();
	    var bw = $("body").width();
	    $("#fullbg").css({
	        height:bh*5,
	        width: bw,
	        display: "block"
	    });
	}
	//关闭灰色 jQuery 遮罩
	function closeBg() {
	    $("#fullbg").hide();
	}
</script>