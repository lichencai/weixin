<%@ page language="java" contentType="text/html; charset=GBK" pageEncoding="GBK"%>
<%@ page import="weixin.wxap.util.TenpayUtil"%>
<%@ page import="weixin.wxap.util.MD5Util"%>
<%@ page import="weixin.wxap.RequestHandler"%>
<%@ page import="weixin.wxap.ResponseHandler"%>
<%@ page import="weixin.wxap.client.TenpayHttpClient"%>
<%@ include file="../config.jsp"%>
<% 
//=================================
//άȨ�ӿ�
//=================================
	//����֧��Ӧ�����
	RequestHandler queryReq = new RequestHandler(null, null);
	queryReq.init();
	//��ʼ��ҳ���ύ�����Ĳ���
	ResponseHandler resHandler = new ResponseHandler(request, response);
	resHandler.setKey(APP_KEY);
	
	//�ж�ǩ��
if(resHandler.isWXsign() == true) {
	//�ظ�����������ɹ�
	System.out.print("ok");
	}
	else{
	//SHA1ǩ��ʧ��
	System.out.print("fail");
	}


%>