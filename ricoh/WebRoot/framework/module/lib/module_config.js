function saveModule(moduleId) {
	moduleId = replaceSpecialCharacters(moduleId);
	$.ajax( {

		type : "POST",
		url : "getModuleInfoAction.action",
		data : {
		moduleId : moduleId
		},
		success : function(msg) {
			showModuleInfo(msg);
		}
	});
}

function showModuleInfo(msg){
	var statesdemo = {
			state0 : {
				html : msg,
				buttons : {
					取消 : false,
					保存 : true
				},
				focus : 1,
				submit : function(v, m, f) {
					if (!v)
						return true;
					else
						$.prompt.goToState('state1');
					return false;
				}
			},
			state1 : {
				html : '是否保存?',
				buttons : {
					取消 : -1,
					确定 : 0
				},
				focus : 1,
				submit : function(v, m, f) {
					if (v == 0) {
						// 确定
						$.ajax( {

							type : "POST",
							url : "saveModuleAction.action",
							data : {
							moduleId : replaceSpecialCharacters($("#moduleId").val()),
							parentModuleId : replaceSpecialCharacters($("#parentModuleId").val()),
							sequence : replaceSpecialCharacters($("#sequence").val()),
							moduleName : replaceSpecialCharacters($("#moduleName").val()),
							moduleAlias : replaceSpecialCharacters($("#moduleAlias").val()),
							showMenu : replaceSpecialCharacters($("#showMenu").val()),
							url : replaceSpecialCharacters($("#moduleUrl").val()),
							crumb : $("#crumb").val()
							},
							success : function(msg) {
								if($.trim(msg).length!=0)
										alert(msg);
							}
						});
				$.prompt.close();
				return true;
			} else if (v = -1)
				$.prompt.goToState('state0');
			return false;
		}
			}
		};
		$.prompt(statesdemo);
}
function deleteModule(moduleId, trId) {
	moduleId = replaceSpecialCharacters(moduleId);
	trId = replaceSpecialCharacters(trId);
	var childs = $("#module-treetable tbody").find(
			".child-of-" + trId);
	if (childs.size() > 0) {
		alert("请先删除子菜单");
		return;
	}
	$.ajax( {

		type : "POST",
		url : "deleteModuleAction.action",
		data : {
			moduleId : moduleId,
			crumb : $("#crumb").val()
		},
		success : function(msg) {
			if ($.trim(msg) == "success") {
				alert("删除成功");
				$("#"+trId).remove();
			} else {
				alert("删除失败");
			}
		}
	});
}
