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

<script type="text/javascript">
	$(function(){
		$("#pay").click(function(){
			
			var obj = "{openid : '${openid}'}";
			alert(obj);
			
			
			$.ajax({
				url:"/weixin/web/pay/notify_url",
				type : "post",
				data:obj,
				dataType : "json",
				success : function(json) {
					
					alert(json.return_code);
					
					/* if(parseInt(obj.agent)<5){  
		                alert("您的微信版本低于5.0无法使用微信支付");  
		                return;  
		            } */
					
					
					WeixinJSBridge.invoke('getBrandWCPayRequest',{
		                "appId" : json.appid,                  //公众号名称，由商户传入  
		                "timeStamp":json.timeStamp,          //时间戳，自 1970 年以来的秒数  
		                "nonceStr" : json.nonce_str,         //随机串  
		                "package" : "prepay_id=" + obj.prepay_id,      //<span style="font-family:微软雅黑;">商品包信息</span>  
		                "signType" : json.signType,        //微信签名方式:  
		                "paySign" : json.sign           //微信签名  
		                },
		                function(res){ 
		                    alert(res.err_msg);  
			                if(res.err_msg == "get_brand_wcpay_request:ok" ) { 
			                    window.location.href=obj.sendUrl;  
			                }else{
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