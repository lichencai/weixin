var public = {};

/**
	������֤(�û���,����ȵ�...)
	����:6-20���ַ�(��ĸ/����/�»���)
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
	������֤����
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
	��ȡ�ַ�����
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
	�绰��֤��֧���������ֻ���
*/
public.yzTel = function(s) {
	var str=s;
	var reg=/(^(\d{2,4}[-_����]?)?\d{3,8}([-_����]?\d{3,8})?([-_����]?\d{1,7})?$)|(^0?1[35]\d{9}$)/;
	if (reg.test(str)==false){
		return false;
	}else{
		return true;
	}
};

/**
	�ʱ���֤
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
	�ж�С��λ�Ƿ���ֵ����û��ת��������
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
	��֤�ֻ�
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
		allZZ = $('<div id="allZZ" class="allzz"><div class="alertDiv"><div class="promptText">�ظ��ɹ�</div><div class="promptBut"><a href="###">�����ظ�</a><a href="###">�ر�</a></div></div></div>'),
		h = $("body").height(),
		ah = $(document).scrollTop()+$(window).height()/2,
		i=0;

	allZZ.find(".promptText").html(tit), alertDiv = allZZ.find(".alertDiv");

	if (!jsons) {
		jsons = {'�ر�':'###'};
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

//�ж��Ƿ�Ϊ΢��
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

// ��ʵ��ת��Ϊ�ַ�
function decodeHtmlEntity(str) {
  return str.replace(/&#(\d+);/g, function(match, dec) {
    return String.fromCharCode(dec);
  });
};
//ҳ�����ģ��
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
