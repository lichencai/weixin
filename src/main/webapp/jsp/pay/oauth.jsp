<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>       
<!DOCTYPE HTML charset="utf-8">
<html>
<head>
<title>pay</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="http://code.jquery.com/mobile/1.3.2/jquery.mobile-1.3.2.min.css">
<script src="http://code.jquery.com/jquery-1.8.3.min.js"></script>
<script src="http://code.jquery.com/mobile/1.3.2/jquery.mobile-1.3.2.min.js"></script>
<script src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>

<script type="text/javascript">
	
	var appId,timeStamp,nonceStr,varpackage,signType,paySign;
	
	var wxConfig = {jssdkURL : location.href.split('#')[0]};
	
	$(function(){
		
		$.ajax({
			
			url : "/weixin/web/jssdk/getConfigData",
			type : "post",
			data : wxConfig,
			dataType : "json",
			success : function(json) {
				wx.config({
				    debug: true, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
				    appId: json.appid, // 必填，公众号的唯一标识
				    timestamp: json.timestamp, // 必填，生成签名的时间戳
				    nonceStr: json.noncestr, // 必填，生成签名的随机串
				    signature: json.signature,// 必填，签名，见附录1
				    jsApiList: ['chooseWXPay'] // 必填，需要使用的JS接口列表，所有JS接口列表见附录2
				});
			},
			error : function(json){
				
			}
			
		});
		
		wx.ready(function(){
			/* wx.checkJsApi({
			    jsApiList: ['chooseImage'], // 需要检测的JS接口列表，所有JS接口列表见附录2,
			    success: function(res) {
			        // 以键值对的形式返回，可用的api值true，不可用为false
			        // 如：{"checkResult":{"chooseImage":true},"errMsg":"checkJsApi:ok"}
			    }
			}); */
		});
		
		
		$("#pay").click(function(){
			
			var obj = {openid : $("#openid").val(), id : '${article.id}'};
			
			alert(obj.openid+","+obj.id);
			
			$.ajax({
				url:"/weixin/web/pay/getPayData",
				type : "post",
				data : obj,
				dataType : "json",
				success : function(json) {
					
					alert("appid:" + json.appId + ",timeStamp:" + json.timeStamp + ",nonceStr:" + json.nonceStr + ",package:" + json.package + ",signType:" + json.signType + ",paySign:" + json.paySign);
					
		            wx.chooseWXPay({
		                timestamp: json.timeStamp, // 支付签名时间戳，注意微信jssdk中的所有使用timestamp字段均为小写。但最新版的支付后台生成签名使用的timeStamp字段名需大写其中的S字符
		                nonceStr: json.nonceStr, // 支付签名随机串，不长于 32 位
		                package: json.package, // 统一支付接口返回的prepay_id参数值，提交格式如：prepay_id=***）
		                signType: json.signType, // 签名方式，默认为'SHA1'，使用新版支付需传入'MD5'
		                paySign: json.paySign, // 支付签名
		                success: function (res) {
		                    // 支付成功后的回调函数
		                }
		            });
		            
				},
				error : function(json){
					
				}
			 });
			 
		})
	})
</script>


</head>
<body>
文章标题:${article.title}<br />
价格:${article.price / 100.0}元<br />
<input id="pay" type="button" value="支付"/>
<input id="openid" type="hidden" value="<%=request.getAttribute("openid")%>">
</body>
</html>