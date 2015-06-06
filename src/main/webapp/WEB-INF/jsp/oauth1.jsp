<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML charset="utf-8">
<html>
<head>
<title>eror</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="http://code.jquery.com/mobile/1.3.2/jquery.mobile-1.3.2.min.css">
<script src="http://code.jquery.com/jquery-1.8.3.min.js"></script>
<script src="http://code.jquery.com/mobile/1.3.2/jquery.mobile-1.3.2.min.js"></script>
<script src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>

<script type="text/javascript">
	
	var appId,timeStamp,nonceStr,varpackage,signType,paySign;
	
	$(function(){
		
		
		/* wx.config({
		    debug: true, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
		    appId: 'wx70e836323253f6ac', // 必填，公众号的唯一标识
		    timestamp: "12312312", // 必填，生成签名的时间戳
		    nonceStr: '412434141', // 必填，生成签名的随机串
		    signature: 'MD5',// 必填，签名，见附录1
		    jsApiList: [chooseWXPay] // 必填，需要使用的JS接口列表，所有JS接口列表见附录2
		}); */
		
		
		/* function callpay()
		{
			if (typeof WeixinJSBridge == "undefined"){
			    if( document.addEventListener ){
			        document.addEventListener('WeixinJSBridgeReady', jsApiCall, false);
			    }else if (document.attachEvent){
			        document.attachEvent('WeixinJSBridgeReady', jsApiCall); 
			        document.attachEvent('onWeixinJSBridgeReady', jsApiCall);
			    }
			}else{
			    jsApiCall();
			}
		}
		
		function jsApiCall(){
		} */
		
		
		
		$("#pay").click(function(){
			
			var obj = {openid : '${openid}'};
			alert(obj);
			
			
			$.ajax({
				url:"/weixin/web/pay/notify_url",
				type : "post",
				data : obj,
				dataType : "json",
				success : function(json) {
					
					alert("appid:" + json.appId + ",timeStamp:" + json.timeStamp + ",nonceStr:" + json.nonceStr + ",package:" + json.package + ",signType:" + json.signType + ",paySign:" + json.paySign);
					/* alert(json.appId);
					alert("timeStamp");
					alert(json.timeStamp);
					alert("nonceStr");
					alert(json.nonceStr);
					alert("package");
					alert(json.package);
					alert("signType");
					alert(json.signType);
					alert("paySign");
					alert(json.paySign); */
					
					/* if(parseInt(obj.agent)<5){  
		                alert("您的微信版本低于5.0无法使用微信支付");  
		                return;  
		            } */
					
		            if (typeof WeixinJSBridge == "undefined"){
		            	alert("WeixinJSBridge is undefined");
		            	return ;
		            }
		            
		            /* wx.chooseWXPay({
		                timestamp: json.timeStamp, // 支付签名时间戳，注意微信jssdk中的所有使用timestamp字段均为小写。但最新版的支付后台生成签名使用的timeStamp字段名需大写其中的S字符
		                nonceStr: json.nonceStr, // 支付签名随机串，不长于 32 位
		                package: json.package, // 统一支付接口返回的prepay_id参数值，提交格式如：prepay_id=***）
		                signType: json.signType, // 签名方式，默认为'SHA1'，使用新版支付需传入'MD5'
		                paySign: json.paySign, // 支付签名
		                success: function (res) {
		                    // 支付成功后的回调函数
		                }
		            }); */
					WeixinJSBridge.invoke('getBrandWCPayRequest',{
		                "appId" : json.appId,                  //公众号名称，由商户传入  
		                "timeStamp":json.timeStamp,          //时间戳，自 1970 年以来的秒数  
		                "nonceStr" : json.nonceStr,         //随机串  
		                "package" : json.package,      //<span style="font-family:微软雅黑;">商品包信息</span>  
		                "signType" : json.signType,        //微信签名方式:  
		                "paySign" : json.paySign           //微信签名  
		                },
		                function(res){ 
		                	alert("=======");
		                    alert(res.err_msg);  
			                if(res.err_msg == "get_brand_wcpay_request:ok" ) {
			                	alert("-------");
			                    alert(res);
			                }else{
			                	alert("+++++++");
			                    alert("fail");  
			                }
		                });
		            
		            
				},
				error : function(json){
					console.log(json);
				}
			 });
		})
	})
</script>


</head>
<body>

<input id="pay" type="button" value="支付"/>


</body>
</html>