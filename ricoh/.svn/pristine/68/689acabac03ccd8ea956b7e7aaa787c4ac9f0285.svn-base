
function unicodeToString(s) {
	while(true)
	{
		if(s.indexOf("&amp;")<0)
			break;
		s = s.replace(new RegExp("&amp;","g"), "\&");
	}
	s = s.replace(new RegExp("&#35;","g"), "\#");
	s = s.replace(new RegExp("&#59;", "g"), "\;");	
	s = s.replace(new RegExp("&lt;", "g"), "\<");
	s = s.replace(new RegExp("&gt;", "g"), "\>");
	s = s.replace(new RegExp("&#96;","g"), "\`");
	s = s.replace(new RegExp("&#126;","g"), "\~");
	s = s.replace(new RegExp("&#33;","g"), "\!");
	s = s.replace(new RegExp("&#36;","g"), "\$");
	s = s.replace(new RegExp("&#37;", "g"), "\%");
	s = s.replace(new RegExp("&#64;", "g"), "\@");
	s = s.replace(new RegExp("&#94;","g"), "\^");
	s = s.replace(new RegExp("&#42;","g"), "\*");
	s = s.replace(new RegExp("&#40;","g"), "\(");
	s = s.replace(new RegExp("&#41;","g"), "\)");
	s = s.replace(new RegExp("&#95;","g"), "\_");
	s = s.replace(new RegExp("&#45;","g"), "\-");
	s = s.replace(new RegExp("&#43;","g"), "\+");
	s = s.replace(new RegExp("&#61;","g"), "\=");
	s = s.replace(new RegExp("&#91;","g"), "\[");
	s = s.replace(new RegExp("&#93;","g"), "\]");
	s = s.replace(new RegExp("&#123;","g"), "\{");
	s = s.replace(new RegExp("&#125;","g"), "\}");
	s = s.replace(new RegExp("&#92;","g"), "\\");
	s = s.replace(new RegExp("&#124;","g"), "\|");
	s = s.replace(new RegExp("&#58;", "g"), "\:");
	s = s.replace(new RegExp("&apos;", "g"), "\'");
	s = s.replace(new RegExp("&quot;", "g"), "\"");
	s = s.replace(new RegExp("&#44;", "g"), "\,");
	s = s.replace(new RegExp("&#46;","g"), "\.");
	s = s.replace(new RegExp("&#63;","g"), "\?");
	s = s.replace(new RegExp("&#47;","g"), "\/");
	s = s.replace(new RegExp("<BR/>", "gi"), "\r\n");
	s = s.replace(new RegExp("&nbsp;&nbsp;&nbsp;&nbsp;", "g"), "\t");
	s = s.replace(new RegExp("&middot;", "g"), "·");
	s = s.replace(new RegExp("&nbsp;", "g"), " ");
	var rs = "";
	var m = 0;
	while (true) {
		m = s.indexOf("&#");
		if (m < 0) {
			rs += s;
			break;
		}
		rs += s.substr(0, m) + String.fromCharCode(s.substr(m + 2, 5))
		s = s.substr(m + 8);
	}

	return rs;
}
function replaceSpecialCharacters(text)
{
	if(text == undefined || text == null)
		return '';
	text = $.trim(text);
		//text = text.replace(new RegExp(/\;/g), "&#59;");
		//text = text.replace(new RegExp(/\&/g), "&amp;");
		//text = text.replace(new RegExp(/\$/g), "&#36;");
		//text = text.replace(new RegExp(/\%/g), "&#37;");
		//text = text.replace(new RegExp(/\@/g), "&#64;");
		//text = text.replace(new RegExp(/\(/g), "&#40;");
		//text = text.replace(new RegExp(/\)/g), "&#41;");
		//text = text.replace(new RegExp(/\\/g), "&#92;");
		//text = text.replace(new RegExp(/\|/g), "&#124;");
		//text = text.replace(new RegExp(/\'/g), "&apos;");
		//text = text.replace(new RegExp(/\"/g), "&quot;");
		//text = text.replace(new RegExp(/\</g), "&lt;");
		//text = text.replace(new RegExp(/\>/g), "&gt;");
		//text = text.replace(new RegExp(/\,/g), "&#44;");
		//text = text.replace(new RegExp("\r\n", "g"), "<BR/>");
		//text = text.replace(new RegExp("\n", "g"), "<BR/>");
		//text = text.replace(new RegExp("\t", "g"), "&nbsp;&nbsp;&nbsp;&nbsp;");		
		//text = text.replace(new RegExp(/\`/g), "&#96;");
		//text = text.replace(new RegExp(/\~/g), "&#126;");
		//text = text.replace(new RegExp(/\!/g), "&#33;");
		//text = text.replace(new RegExp(/\#/g), "&#35;");
		//text = text.replace(new RegExp(/\^/g), "&#94;");
		//text = text.replace(new RegExp(/\*/g), "&#42;");
		//text = text.replace(new RegExp(/\_/g), "&#95;");
		//text = text.replace(new RegExp(/\-/g), "&#45;");
		//text = text.replace(new RegExp(/\+/g), "&#43;");
		//text = text.replace(new RegExp(/\=/g), "&#61;");
		//text = text.replace(new RegExp(/\[/g), "&#91;");
		//text = text.replace(new RegExp(/\]/g), "&#93;");
		//text = text.replace(new RegExp(/\{/g), "&#123;");
		//text = text.replace(new RegExp(/\}/g), "&#125;");
		//text = text.replace(new RegExp(/\:/g), "&#58;");
		//text = text.replace(new RegExp(/\./g), "&#46;");
		//text = text.replace(new RegExp(/\?/g), "&#63;");
		//text = text.replace(new RegExp(/\//g), "&#47;");
		//text = text.replace(new RegExp(/\·/g), "&middot;");
		var ln = text.length;
		var rs = "";
		var i=0;
		while(i<ln)
		{
			var s = text.charAt(i);
			if(s=='\;')s= '&#59;';
			else if(s=='\&')s= '&amp;';
			else if(s=='\$')s= '&#36;';
			else if(s=='\%')s= '&#37;';
			else if(s=='\@')s= '&#64;';
			else if(s=='\(')s= '&#40;';
			else if(s=='\)')s= '&#41;';
			else if(s=='\\')s= '&#92;';
			else if(s=='\|')s= '&#124;';
			else if(s=='\'')s= '&apos;';
			else if(s=='\"')s= '&quot;';
			else if(s=='\<')s= '&lt;';
			else if(s=='\>')s= '&gt;';
			else if(s=='\,')s= '&#44;';
			else if(s=='\n')s= '<BR/>';
			else if(s=='\t')s= '&nbsp;&nbsp;&nbsp;&nbsp;';		
			else if(s=='\`')s= '&#96;';
			else if(s=='\~')s= '&#126;';
			else if(s=='\!')s= '&#33;';
			else if(s=='\#')s= '&#35;';
			else if(s=='\^')s= '&#94;';
			else if(s=='\*')s= '&#42;';
			else if(s=='\_')s= '&#95;';
			else if(s=='\-')s= '&#45;';
			else if(s=='\+')s= '&#43;';
			else if(s=='\=')s= '&#61;';
			else if(s=='\[')s= '&#91;';
			else if(s=='\]')s= '&#93;';
			else if(s=='\{')s= '&#123;';
			else if(s=='\}')s= '&#125;';
			else if(s=='\:')s= '&#58;';
			else if(s=='\.')s= '&#46;';
			else if(s=='\?')s= '&#63;';
			else if(s=='\/')s= '&#47;';
			//else if(s=='\·')s= '&middot;';
			rs += s;
			i++;
		}
	return rs;
}

function parseObj(strData) {
	return (new Function("return " + strData))();
}
Date.prototype.format = function(format) {
	var o = {
		"M+" : this.getMonth() + 1, // month
		"d+" : this.getDate(), // day
		"h+" : this.getHours(), // hour
		"m+" : this.getMinutes(), // minute
		"s+" : this.getSeconds(), // second
		"q+" : Math.floor((this.getMonth() + 3) / 3), // quarter
		"S" : this.getMilliseconds()
	// millisecond
	}
	if (/(y+)/.test(format))
		format = format.replace(RegExp.$1, (this.getFullYear() + "")
				.substr(4 - RegExp.$1.length));
	for ( var k in o)
		if (new RegExp("(" + k + ")").test(format))
			format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k]
					: ("00" + o[k]).substr(("" + o[k]).length));
	return format;
}
Date.before = function(d1,d2){  
    if((typeof d1 == 'object' && d1.constructor == Date) && (typeof d2 == 'object' && d2.constructor == Date)){  
        if(d1<=d2){  
            return true;  
        }else{  
            return false;  
        }  
    }else if((typeof d1 == 'string' && d1.constructor == String) && (typeof d2 == 'string' && d2.constructor == String)){  
  
        var date1 = Date.isSimpleDate(d1)!=null?Date.isSimpleDate(d1):Date.isDateHH(d1);  
        date1 = date1!=null?date1:Date.isDateHHMM(d1);  
        date1 = date1!=null?date1:Date.isDateHHMMSS(d1);  
        var date2 = Date.isSimpleDate(d2)!=null?Date.isSimpleDate(d2):Date.isDateHH(d2);  
        date2 = date2!=null?date2:Date.isDateHHMM(d2)  
        date2 = date2!=null?date2:Date.isDateHHMMSS(d2);  
        if(date1==null||date2==null){  
            alert("日期格式不正确!");  
            return false;  
        }  
        if(date1<=date2){  
            return true;  
        }else{  
            return false;  
        }  
    }else if((typeof d1 == 'string' && d1.constructor == String) && (typeof d2 == 'object' && d2.constructor == Date)){  
  
        var date1 = Date.isSimpleDate(d1)!=null?Date.isSimpleDate(d1):Date.isDateHH(d1);  
        date1 = date1!=null?date1:Date.isDateHHMM(d1);  
        date1 = date1!=null?date1:Date.isDateHHMMSS(d1);  
        if(date1==null||d2==null){  
            alert("日期格式不正确!");  
            return false;  
        }  
        if(date1<=d2){  
            return true;  
        }else{  
            return false;  
        }  
    }else if((typeof d1 == 'object' && d1.constructor == Date) && (typeof d2 == 'string' && d2.constructor == String)){  
  
        var date2 = Date.isSimpleDate(d2)!=null?Date.isSimpleDate(d2):Date.isDateHH(d2);  
        date2 = date2!=null?date2:Date.isDateHHMM(d2)  
        date2 = date2!=null?date2:Date.isDateHHMMSS(d2);  
        if(d1==null||date2==null){  
            alert("日期格式不正确!");  
            return false;  
        }  
        if(d1<=date2){  
            return true;  
        }else{  
            return false;  
        }  
    }else{  
        alert("无法判断输入数据类型！");  
        return false;  
    }  
}  
Date.isSimpleDate = function(str){   
	str = unicodeToString(str);
    var   reg   =   /^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/;  
    var r = str.match(reg);  
    if(r==null)return   null;  
    var   d=   new   Date(r[1], r[3]-1,r[4]);  
    var   newStr=d.getFullYear() + "-";  
    newStr+=(((d.getMonth()+1)<10&&r[3].length>1)?('0'+(d.getMonth()+1)):(d.getMonth()+1)) + "-" ;  
    newStr+=(((d.getDate())<10 && r[4].length>1)?('0'+d.getDate()):d.getDate());  
    if(newStr==str){  
        return d;  
    }else{  
        return null;  
    }  
}   
Date.isDateHH = function(str){   
	str = unicodeToString(str);
    var   reg   =   /^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2}) (\d{1,2})$/;  
    var r = str.match(reg);  
    if(r==null)return   null;  
    var   d=   new   Date(r[1], r[3]-1,r[4],r[5]);  
    var   newStr=d.getFullYear() + "-";  
    newStr+=(((d.getMonth()+1)<10&&r[3].length>1)?('0'+(d.getMonth()+1)):(d.getMonth()+1)) + "-" ;  
    newStr+=(((d.getDate())<10 && r[4].length>1)?('0'+d.getDate()):d.getDate()) + " ";  
    newStr+=((d.getHours()<10&&r[5].length>1)?('0'+d.getHours()):d.getHours());  
    if(newStr==str){  
        return d;  
    }else{  
        return null;  
    }  
}  
Date.isDateHHMM = function(str){  
	str = unicodeToString(str);
    var   reg   =   /^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2}) (\d{1,2}):(\d{1,2})$/;  
    var   r   =   str.match(reg);  
    if(r==null)return   null;  
    var   d=   new   Date(r[1], r[3]-1,r[4],r[5],r[6]);  
    var   newStr=d.getFullYear() + "-";  
    newStr+=(((d.getMonth()+1)<10&&r[3].length>1)?('0'+(d.getMonth()+1)):(d.getMonth()+1)) + "-" ;  
    newStr+=(((d.getDate())<10 && r[4].length>1)?('0'+d.getDate()):d.getDate()) + " ";  
    newStr += ((d.getHours()<10&&r[5].length>1)?('0'+d.getHours()):d.getHours())+":";  
    newStr += ((d.getMinutes()<10&&r[6].length>1)?('0'+d.getMinutes()):d.getMinutes());  
    if(newStr==str){  
        return d;  
    }else{  
        return null;  
    }  
}  
Date.isDateHHMMSS = function(str){   
	str = unicodeToString(str);
    var   reg   =   /^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2}) (\d{1,2}):(\d{1,2}):(\d{1,2})$/;  
    var   r   =   str.match(reg);  
    if(r==null)return   null;  
    var   d=   new   Date(r[1], r[3]-1,r[4],r[5],r[6],r[7]);  
    var   newStr=d.getFullYear() + "-";  
    newStr+=(((d.getMonth()+1)<10&&r[3].length>1)?('0'+(d.getMonth()+1)):(d.getMonth()+1)) + "-" ;  
    newStr+=(((d.getDate())<10 && r[4].length>1)?('0'+d.getDate()):d.getDate()) + " ";  
    newStr += (((d.getHours()<10&&r[5].length>1)?('0'+d.getHours()):d.getHours()))+":";  
    newStr += (((d.getMinutes()<10&&r[6].length>1)?('0'+d.getMinutes()):d.getMinutes())) + ":";  
    newStr += ((d.getSeconds()<10&&r[7].length>1)?('0'+d.getSeconds()):d.getSeconds());  
    if(newStr==str){  
        return d;  
    }else{  
        return null;  
    }  
}
function checkPrice(input) {
	if (input.val().length == 0)
		return;
	var reg = /^([0-9]|[0-9]|(0[.])|((0[.])))[0-9]{0,}(([.]*\d{1,2})|[0-9]{0,})$/;
	if (!reg.test(input.val())) {
		if (reg.test($.trim(input.val())))
		{
			input.val($.trim(input.val()));
		}
		else
		{
			alert('请输入数字');
			input.val('');
		}
	}
}
function checkQty(input) {
	if (input.val().length == 0)
		return;
	var reg = /^([0-9]|[0-9]|(0[.])|((0[.])))[0-9]{0,}$/;
	if (!reg.test(input.val())) {
		if (reg.test($.trim(input.val())))
			input.val($.trim(input.val()));
		else
		{
			alert('请输入数字');
			input.val('');
		}
	}
}
function checkDateSimpleDate(input) {
	if (input.val().length == 0)
		return;
	var d = Date.isSimpleDate(input.val());
	if(d==null)
	{
		alert('日期格式错误');
		input.val('');
	}	
}
function checkDateHHMM(input) {
	if (input.val().length == 0)
		return;
	var d = Date.isDateHHMM(input.val());
	if(d==null)
	{
		d = Date.isSimpleDate(input.val());
		if(d==null)
		{
			alert('日期格式错误');
			input.val('');			
		}
	}
	
}
function checkValueLength(input,len)
{
	var str = $.trim(input.val());
	if(str.length>len)
	{
		alert('输入内容超过最大长度限制,最大长度为['+len+']');
		input.val(str.substring(0,len));
	}
}
function checkSpecialCharacters(str){
	//(\ )
    var re = RegExp(/[(\&)(\[)(\])(\{)(\})(\|)(\\)(\;)(\:)(\')(\")(\,)(\/)(\<)(\>)(\)]+/);  
    if (!re.test( str )) {   
       return true;   
    } else{  
     alert("输入内容中含有特殊字符,请检查.如需符号请使用全角符号.");   
     return false;   
 }
} 
//
function setReadonly(text) {
	text.attr("readonly", true);
	text.addClass("readonly-class");
}
function Map() {
	var struct = function(key, value) {
		this.key = key;
		this.value = value;
	}

	var put = function(key, value) {
		for ( var i = 0; i < this.arr.length; i++) {
			if (this.arr[i].key === key) {
				this.arr[i].value = value;
				return;
			}
		}
		this.arr[this.arr.length] = new struct(key, value);
	}

	var get = function(key) {
		for ( var i = 0; i < this.arr.length; i++) {
			if (this.arr[i].key === key) {
				return this.arr[i].value;
			}
		}
		return null;
	}

	var remove = function(key) {
		var v;
		for ( var i = 0; i < this.arr.length; i++) {
			v = this.arr.pop();
			if (v.key === key) {
				continue;
			}
			this.arr.unshift(v);
		}
	}

	var size = function() {
		return this.arr.length;
	}

	var isEmpty = function() {
		return this.arr.length <= 0;
	}
	this.arr = new Array();
	this.get = get;
	this.put = put;
	this.remove = remove;
	this.size = size;
	this.isEmpty = isEmpty;
}

function lockscreen(msg) {
	$.blockUI( {
		message : "<h1>" + msg + "</h1>",
		centerY : 0,
		css : {
			top : '10px',
			left : '',
			right : '10px',
			img : 'images/ajax_loading.gif'
		}
	});
}

function unLockScreen() {
	$.unblockUI();
}
function hideAndShow(id) {
	if ($("#" + id).is(":hidden")) {
		$("#" + id).show();
		isHide = false;
	} else {
		$("#" + id).hide();
		isHide = true;
	}
}