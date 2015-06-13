<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="http://code.jquery.com/mobile/1.3.2/jquery.mobile-1.3.2.min.css">
<script src="http://code.jquery.com/jquery-1.8.3.min.js"></script>
<script src="http://code.jquery.com/mobile/1.3.2/jquery.mobile-1.3.2.min.js"></script>
<title>index</title>
</head>
<body>
	<div data-role="page" id="page1">
		<div data-role="header" data-position="fixed">
			<h1>page1</h1>
		</div>
		<div data-role="content" data-theme="c">
			<table data-role="table" id="movie-table" data-mode="reflow" class="ui-responsive table-stroke">
			  <thead>
			    <tr>
			      <th data-priority="1">标题</th>
			      <th data-priority="2">时间</th>
			      <th data-priority="3">类型</th>
			      <th data-priority="4">价格</th>
			    </tr>
			  </thead>
			  <tbody>
			    <tr>
			      <td><a id="article1" href="/weixin/html/article.html" data-rel="external">Citizen Kane</a></td>
			      <td>1941</td>
			      <td>100%</td>
			      <td>74</td>
			    </tr>
			    <tr>
			      <td><a id="article1" href="/weixin/html/article.html" data-rel="external">Citizen Kane</a></td>
			      <td>1941</td>
			      <td>100%</td>
			      <td>74</td>
			    </tr>
			  </tbody>
			</table>
		</div>
	</div>
</body>
</html>