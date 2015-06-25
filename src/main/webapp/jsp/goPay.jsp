<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<%@ page import="weixin.dao.entity.WxArticle" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

<script type="text/javascript">
</script>

<title>提示</title>
</head>
<body>
<div data-role="page" id="page1">
	<div data-role="content" data-theme="c">
		<div>
			该文章需要购买后才能进行查看，是否进行购买?
		</div>
		<a href="/weixin/web/oauth/redirect.do?id=<%=((WxArticle)request.getAttribute("article")).getId() %>" target="_blank">进行购买</a>
		<a href="/weixin/web/index/welcome.do" target="_blank">返回首页</a>
	</div>
</div>
</body>
</html>