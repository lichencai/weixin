var public = {};

/**
	正则验证(用户名,密码等等...)
	规则:6-20个字符(字母/数字/下划线)
*/
public.yzUsername = function(string) {
	if (string.length == 0) {
		return false;
	}

	if(/^(\w){6,20}$/.test(string) ) {
		return true;
	}else{
		return false;
	}
}

/**
	正则验证邮箱
*/
public.yzEmail = function (email){
	if (email.length == 0) {
		return false;
	}

	if( /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/.test(email) ) {
		return true;
	}else{
		return false;
	}
}

/**
	获取字符长度
*/
public.getStringLength = function(str) {
		if (str == '') return 0;

    var realLength = 0, len = str.length, charCode = -1;
    for (var i = 0; i < len; i++) {
        charCode = str.charCodeAt(i);
        if (charCode >= 0 && charCode <= 128) realLength += 1;
        else realLength += 2;
    }
    return realLength;
};

/**
	电话验证（支持座机和手机）
*/
public.yzTel = function(s) {
	var str=s;
	var reg=/(^(\d{2,4}[-_－—]?)?\d{3,8}([-_－—]?\d{3,8})?([-_－—]?\d{1,7})?$)|(^0?1[35]\d{9}$)/;
	if (reg.test(str)==false){
		return false;
	}else{
		return true;
	}
};

/**
	邮编验证
*/
public.yzPostcode = function(s) {
	var str=s;
	var reg=/^[0-9][0-9]{5}$/;
	if (reg.test(str)==false){
		return false;
	}else{
		return true;
	}
};

/**
	判断小数位是否有值，无没有转换成整形
*/
public.yzIsdecimal = function(str) {
	var reg=/(\.00)$/;
	if (reg.test(str)==false){
		return str;
	}else{
		return parseInt(str);
	}
};

/**
	验证手机
*/
public.yzMobile = function(tel) {
	var reg = /(^0{0,1}1[0-9]{1}[0-9]{9}$)/;
	if (reg.test(tel)) {
		tel = true;
		return tel;
	} else {
		tel = false;
		return tel;
	}
}

function showAllzz(tit, jsons){
	var
		allZZ = $('<div id="allZZ" class="allzz"><div class="alertDiv"><div class="promptText">回复成功</div><div class="promptBut"><a href="###">继续回复</a><a href="###">关闭</a></div></div></div>'),
		h = $("body").height(),
		ah = $(document).scrollTop()+$(window).height()/2,
		i=0;

	allZZ.find(".promptText").html(tit), alertDiv = allZZ.find(".alertDiv");

	if (!jsons) {
		jsons = {'关闭':'###'};
	}

	var x, aArray = "";
	for (var x in jsons) {
		i++;
		aArray += '<a href="' + jsons[x] + '">' + x + '</a>';
	}
	allZZ.find(".promptBut").html(aArray);


	allZZ.find(".promptBut").find("a").css({
		'width': 100 / i + "%"
	}).click(function() {
		allZZ.remove();
	});

	allZZ.css({
		"height": h + "px"
	}).appendTo('body');
	alertDiv.css({
		"margin-top": ah - alertDiv.height() / 2
	});
}

//判断是否为微信
function is_weixn(){
  var ua = navigator.userAgent.toLowerCase();
  if(ua.match(/MicroMessenger/i)=="micromessenger") {
     return false;
  } else {
    return true;
  }
}

// $('#shareModule span').live("click",function(){
// 	var ua = navigator.userAgent.toLowerCase();
//   var is_weixn = (ua.match(/MicroMessenger/i)=="micromessenger") ? 1 : 0;
//   if(is_weixn){
//     fJson.weixin()
//   }else{
// 		var tmpClass = $(this).attr('class');
// 		fJson[tmpClass]();
//   }

// });

// 将实体转换为字符
function decodeHtmlEntity(str) {
  return str.replace(/&#(\d+);/g, function(match, dec) {
    return String.fromCharCode(dec);
  });
};
//页面分享模块
$(function(){
  $('div.shareModule span').on("click",function(){
    var ua = navigator.userAgent.toLowerCase();
    var is_weixn = (ua.match(/MicroMessenger/i)=="micromessenger") ? 1 : 0;
    if(is_weixn){
      fJson.weixin()
    }else{
      var tmpClass = $(this).attr('class');
      fJson[tmpClass]();
    }

  });  
})
