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
		
		$("#pay").click(function(){
			
			var obj = {openid : $("#openid").val()};
			$.ajax({
				url:"/weixin/web/pay/getPayData",
				type : "post",
				data : obj,
				dataType : "json",
				success : function(json) {
					
					alert("appid:" + json.appId + ",timeStamp:" + json.timeStamp + ",nonceStr:" + json.nonceStr + ",package:" + json.package + ",signType:" + json.signType + ",paySign:" + json.paySign);
					
		            if (typeof WeixinJSBridge == "undefined"){
		            	alert("WeixinJSBridge is undefined");
		            	return ;
		            }

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
<input id="openid" type="hidden" value="<%=request.getAttribute("openid")%>">

</body>
</html>