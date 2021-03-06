<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List" %>
<%@ page import="weixin.dao.entity.WxArticle" %>
<%@ page import="weixin.util.DateUtil" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="http://code.jquery.com/mobile/1.3.2/jquery.mobile-1.3.2.min.css">
<script src="http://code.jquery.com/jquery-1.8.3.min.js"></script>
<script src="http://code.jquery.com/mobile/1.3.2/jquery.mobile-1.3.2.min.js"></script>
<title>今日资讯</title>
</head>
<body>
	<div data-role="page" id="page1">
		<div data-role="content" data-theme="c">
			<table data-role="table" id="movie-table" data-mode="reflow" class="ui-responsive table-stroke">
			  <thead>
			    <tr>
			      <th data-priority="1">标题</th>
			      <th data-priority="2">时间</th>
			      <th data-priority="3">价格</th>
			    </tr>
			  </thead>
			  <tbody>
			  	<%
		 			List<WxArticle> list = (List<WxArticle>)request.getAttribute("list");
		 			for(WxArticle each : list){
		 				%>
		 				<tr>
					      <td><a id="article1" href="/weixin/web/article/show.do?id=<%=each.getId() %>&type=<%=each.getType() %>" data-rel="external"><%=each.getTitle() %></a></td>
					      <td><%=DateUtil.dateToString(each.getCreatetime(), null) %></td>
					      <td><%=each.getPrice() / 100.0 %>元</td>
					    </tr>
		 				<%
		 			}
		 		%>
			  </tbody>
			</table>
		</div>
		<div data-role="footer" data-theme="d" data-position="fixed">
			<div align="center">
				2015A
			</div>
		</div>
	</div>
</body>
</html>