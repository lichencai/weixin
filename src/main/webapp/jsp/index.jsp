<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="http://code.jquery.com/mobile/1.3.2/jquery.mobile-1.3.2.min.css">
<script src="http://code.jquery.com/jquery-1.8.3.min.js"></script>
<script src="http://code.jquery.com/mobile/1.3.2/jquery.mobile-1.3.2.min.js"></script>
<title>index</title>

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
 
    <div data-role="header" data-position="fixed">
		<h1>和悦资讯</h1>
	</div>
 	
    <div data-role="content" data-theme="c">
	    <div data-role="navbar">
		    <ul>
		      <li><a href="/weixin/html/page1.html"  target="_blank">今日资讯</a></li>
		      <li><a href="#anylink">新闻类</a></li>
		      <li><a href="#anylink">财经类</a></li>
		    </ul>
		 </div>
		 <div class="ui-grid-a">
		 	<div class="ui-block-a">
		 		
		 		<div class="ui-bar ui-bar-e" style="height:129px">
		 			<a href="/weixin/web/article/show" target="_blank">中共中央纪念陈云诞辰110周年</a>
		 			中共中央12日上午在人民大会堂举行座谈会，纪念陈云同志诞辰110周年。中共中央总书记、国家主席、中央军委主席习近平发表重要讲话
		 		</div>
		 		
		 		<c:forEach var="each" items="${list}">
		 			<div class="ui-bar ui-bar-e" style="height:129px">
			 			<a href="/weixin/web/article/show?id=${each.id}" target="_blank">${each.title}</a>
			 			${each.summary}
			 		</div>
		 		</c:forEach>
		 		
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