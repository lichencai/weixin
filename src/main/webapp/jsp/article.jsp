<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ page import="weixin.dao.entity.WxArticle" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="http://code.jquery.com/mobile/1.3.2/jquery.mobile-1.3.2.min.css">
<script src="http://code.jquery.com/jquery-1.8.3.min.js"></script>
<script src="http://code.jquery.com/mobile/1.3.2/jquery.mobile-1.3.2.min.js"></script>
<title>article</title>
<script type="text/javascript">
	

</script>
<style type="text/css">
	.divlab{
		text-align: center;
  		display: block;
	}
</style>
</head>
<body>
	<div data-role="page" id="page1">
		<!-- <div data-role="header" data-position="fixed">
			<h1>中共中央纪念陈云诞辰110周年</h1>
		</div> -->
		<div data-role="content" data-theme="c">
		<label class="divlab"><%=((WxArticle)request.getAttribute("article")).getTitle() %></label><br >
		<%=((WxArticle)request.getAttribute("article")).getContent() %>
		</div>
		<div data-role="footer" data-theme="d" data-position="fixed">
			<div align="center">
				2015A
			</div>
		</div>
	</div>
</body>
</html>