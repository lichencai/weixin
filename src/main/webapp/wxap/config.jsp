<%@ page language="java" contentType="text/html; charset=GBK" pageEncoding="GBK"%>
<% 

//调试模式
 boolean DEBUG_ = true;
 String PARTNER		= "1241661102" ;	//财付通商户号
 String PARTNER_KEY	= "AAAaaa111";	//财付通密钥
 String APP_ID		= "wx70e836323253f6ac";	//appid
 String APP_SECRET	= "9cc084e873e077b8e9832a6ccf03613f";	//appsecret
 String APP_KEY		= "fdoikjmnhy58Kiujfyh90lkmjyseFVhy";	//paysignkey 128位字符串(非appkey)
 String NOTIFY_URL	= "http://lichencai.nat123.net/weixin/wxap/payNotifyUrl.jsp";  //支付完成后的回调处理页面,*替换成notify_url.asp所在路径
 String LOGING_DIR	= "E:\\log.txt";  //日志保存路径
%>
