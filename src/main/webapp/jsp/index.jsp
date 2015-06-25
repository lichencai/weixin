<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List" %>
<%@ page import="weixin.dao.entity.WxArticle" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="http://code.jquery.com/mobile/1.3.2/jquery.mobile-1.3.2.min.css">
<script src="http://code.jquery.com/jquery-1.8.3.min.js"></script>
<script src="http://code.jquery.com/mobile/1.3.2/jquery.mobile-1.3.2.min.js"></script>
<title>首页</title>

<script type="text/javascript">
</script>
<style type="text/css">
  .ui-grid-a>:nth-child(n) {
  	width: 100%;
  	margin-right: -.5px;
  }
</style>
</head>
<body>


<div data-role="page" id="page1">
 
    <div data-role="content" data-theme="c">
	    <div data-role="navbar">
		    <ul>
		      <li><a href="/weixin/web/daynews/getList.do"  target="_blank">今日资讯</a></li>
		      <li><a href="/weixin/web/news/getList.do"  target="_blank">新闻类</a></li>
		      <li><a href="/weixin/web/economy/getList.do"  target="_blank">财经类</a></li>
		    </ul>
		 </div>
		 <div class="ui-grid-a">
		 	<div class="ui-block-a">
		 		<%
		 			List<WxArticle> list = (List<WxArticle>)request.getAttribute("list");
		 			for(WxArticle each : list){
		 				%>
			 			<div class="ui-bar ui-bar-e" style="height:129px">
				 			<a href="/weixin/web/article/show.do?id=<%=each.getId() %>&type=<%=each.getType() %>" target="_blank"><%=each.getTitle() %></a>
				 			<%=each.getSummary() %>
				 		</div>
		 				<%
		 			}
		 		%>
		 	</div>
		 </div>
	</div>
	
	<div data-role="footer" data-theme="d" data-position="fixed">
		<div align="center">
			2015A
		</div>
	</div>
</div>

</body>
</html>