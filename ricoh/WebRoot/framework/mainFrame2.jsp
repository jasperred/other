<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<!-- saved from url=(0043)http://trirand.com/blog/jqgrid/jqgrid.html -->
<HTML lang=en xml:lang="en" xmlns="http://www.w3.org/1999/xhtml"><HEAD><TITLE>jqGrid Demos</TITLE>
<META content="text/html; charset=utf-8" http-equiv=Content-Type><LINK 
rel=stylesheet type=text/css 
href="css/ui/jquery-ui-1.8.1.custom.css" media=screen><LINK 
rel=stylesheet type=text/css href="css/ui/ui.jqgrid.css" 
media=screen><LINK rel=stylesheet type=text/css 
href="css/ui/ui.multiselect.css" media=screen>
<STYLE>HTML {
	PADDING-BOTTOM: 0px; MARGIN: 0px; PADDING-LEFT: 0px; PADDING-RIGHT: 0px; FONT-SIZE: 75%; OVERFLOW: hidden; PADDING-TOP: 0px
}
BODY {
	PADDING-BOTTOM: 0px; MARGIN: 0px; PADDING-LEFT: 0px; PADDING-RIGHT: 0px; FONT-SIZE: 75%; OVERFLOW: hidden; PADDING-TOP: 0px
}
#LeftPane {
	OVERFLOW: auto
}
#RightPane {
	PADDING-BOTTOM: 2px; PADDING-LEFT: 2px; PADDING-RIGHT: 2px; OVERFLOW: auto; PADDING-TOP: 2px
}
.ui-tabs-nav LI {
	POSITION: relative
}
.ui-tabs-selected A SPAN {
	PADDING-RIGHT: 10px
}
.ui-tabs-close {
	Z-INDEX: 800; POSITION: absolute; FONT-STYLE: normal; WIDTH: 16px; DISPLAY: none; HEIGHT: 14px; FONT-SIZE: 10px; TOP: 3px; CURSOR: pointer; RIGHT: 0px
}
.ui-tabs-selected .ui-tabs-close {
	DISPLAY: block
}
.ui-layout-west .ui-jqgrid TR.jqgrow TD {
	BORDER-BOTTOM: 0px
}
.ui-datepicker {
	Z-INDEX: 1200
}
.rotate {
	FILTER: progid:DXImageTransform.Microsoft.BasicImage(rotation=3); -webkit-transform: rotate(-90deg); -moz-transform: rotate(-90deg)
}
</STYLE>

<SCRIPT type=text/javascript src="js/jquery/jquery-1.4.4.js"></SCRIPT>

<SCRIPT type=text/javascript 
src="js/jquery/ui/jquery-ui-1.8.1.custom.min.js"></SCRIPT>

<SCRIPT type=text/javascript 
src="js/jquery/jquery.layout.js"></SCRIPT>

<SCRIPT type=text/javascript 
src="js/jquery/ui/grid.locale-en.js"></SCRIPT>

<SCRIPT type=text/javascript>
	$.jgrid.no_legacy_api = true;
	$.jgrid.useJSON = true;
</SCRIPT>

<SCRIPT type=text/javascript 
src="js/jquery/ui/ui.multiselect.js"></SCRIPT>

<SCRIPT type=text/javascript 
src="js/jquery/ui/jquery.jqGrid.min.js"></SCRIPT>

<SCRIPT type=text/javascript 
src="js/jquery/ui/jquery.tablednd.js"></SCRIPT>

<SCRIPT type=text/javascript 
src="js/jquery/ui/jquery.contextmenu.js"></SCRIPT>

<SCRIPT type=text/javascript>

jQuery(document).ready(function(){
    //$('#switcher').themeswitcher();

	$('body').layout({
		resizerClass: 'ui-state-default',
        west__onresize: function (pane, $Pane) {
            jQuery("#west-grid").jqGrid('setGridWidth',$Pane.innerWidth()-2);
		}
	});
	$.jgrid.defaults = $.extend($.jgrid.defaults,{loadui:"enable"});
	var maintab =jQuery('#tabs','#RightPane').tabs({
        add: function(e, ui) {
            // append close thingy
            $(ui.tab).parents('li:first')
                .append('<span class="ui-tabs-close ui-icon ui-icon-close" title="Close Tab"></span>')
                .find('span.ui-tabs-close')
                .click(function() {
                    maintab.tabs('remove', $('li', maintab).index($(this).parents('li:first')[0]));
                });
            // select just added tab
            maintab.tabs('select', '#' + ui.panel.id);
        }
    });
    jQuery("#west-grid").jqGrid({
        url: "http://localhost:8080/data/tree.xml",
        datatype: "xml",
        height: "auto",
        pager: false,
        loadui: "disable",
        colNames: ["id","Items","url"],
        colModel: [
            {name: "id",width:1,hidden:true, key:true},
            {name: "menu", width:150, resizable: false, sortable:false},
            {name: "url",width:1,hidden:true}
        ],
        treeGrid: true,
		caption: "jqGrid Demos",
        ExpandColumn: "menu",
        autowidth: true,
        //width: 180,
        rowNum: 200,
        ExpandColClick: true,
        treeIcons: {leaf:'ui-icon-document-b'},
        onSelectRow: function(rowid) {
            var treedata = $("#west-grid").jqGrid('getRowData',rowid);
            if(treedata.isLeaf=="true") {
                //treedata.url
                var st = "#t"+treedata.id;
				if($(st).html() != null ) {
					maintab.tabs('select',st);
				} else {
					maintab.tabs('add',st, treedata.menu);
					//$(st,"#tabs").load(treedata.url);
					$.ajax({
						url: treedata.url,
						type: "GET",
						dataType: "html",
						complete : function (req, err) {
							$(st,"#tabs").append(req.responseText);
							try { var pageTracker = _gat._getTracker("UA-5463047-4"); pageTracker._trackPageview(); } catch(err) {};
							var clck = '<p style="border: 1px solid; background-color: lemonchiffon; width:654px;height:25px;margin-bottom: 8px;padding-top: 8px;text-align: center">';
							clck += '<b>Please, support the jqGrid project by clicking on our sponsors ad! </b></p>';
 
							var fs = '<iframe src="adds.html" style="width:336px; height:290px;" scrolling="no" marginwidth="0" marginheight="0" frameborder="0" vspace="0" hspace="0"/>\
									&nbsp;&nbsp;&nbsp;&nbsp;<iframe src="adds3.html" style="width:336px; height:290px;" scrolling="no" marginwidth="0" marginheight="0" frameborder="0" vspace="0" hspace="0"/>\
									<br/><iframe src="adds2.html" style="width:336px; height:290px;" scrolling="no" marginwidth="0" marginheight="0" frameborder="0" vspace="0" hspace="0"/>\
									&nbsp;&nbsp;&nbsp;&nbsp;<iframe src="adds4.html" style="width:336px; height:290px;"scrolling="no" marginwidth="0" marginheight="0" frameborder="0" vspace="0" hspace="0"/>\
							';
							$(st,"#tabs").append(clck);
							$(st,"#tabs").append(fs);
						}
					});
				}
            }
        }
    });
	
// end splitter

});
</SCRIPT>

<META name=GENERATOR content="MSHTML 8.00.6001.18702"></HEAD>
<BODY>
<DIV id=LeftPane class="ui-layout-west ui-widget ui-widget-content">
<TABLE id=west-grid></TABLE></DIV><!-- #LeftPane -->
<DIV id=RightPane class="ui-layout-center ui-helper-reset ui-widget-content"><!-- Tabs pane -->
<DIV id=switcher></DIV>
<DIV id=tabs class=jqgtabs>
<UL>
  <LI><A href="http://trirand.com/blog/jqgrid/jqgrid.html#tabs-1">jqGrid 
  3.8</A></LI></UL>
<DIV style="FONT-SIZE: 12px" id=tabs-1>jqGrid 3.8 Add a grouping...<BR><BR>Enjoy 
<BR><BR>
<P 
style="BORDER-BOTTOM: 1px solid; TEXT-ALIGN: center; BORDER-LEFT: 1px solid; BACKGROUND-COLOR: lemonchiffon; WIDTH: 728px; MARGIN-BOTTOM: 8px; HEIGHT: 25px; BORDER-TOP: 1px solid; BORDER-RIGHT: 1px solid; PADDING-TOP: 8px"><B>Please, 
support the jqGrid project by clicking on our sponsors ad! </B></P><IFRAME 
style="WIDTH: 728px; HEIGHT: 100px" vspace=0 marginHeight=0 
src="jqGrid%20Demos_files/adds_c.htm" frameBorder=0 marginWidth=0 scrolling=no 
hspace=0></IFRAME></DIV></DIV></DIV></BODY></HTML>
