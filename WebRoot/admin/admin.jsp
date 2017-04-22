<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html >
<html xmlns="http://www.w3.org/1999/xhtml"><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>主页</title>
<base target = "rightIframe"/>
<link type="text/css" rel="stylesheet" href="../css/common.css"/>
<style type="text/css">
<!--

-->
<!---->
</style>
</head>

<body>
<%
	request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8");



%>
<!--页面顶部-->
<jsp:include page="adminTop.jsp"></jsp:include>
<!--页面中部-->
<div id="content" class="main-content clearfix">
	<jsp:include page="adminSidebar.jsp"></jsp:include>
	<jsp:include page="adminRightbar.jsp"></jsp:include>
</div>
<!--页面底部-->
<jsp:include page="adminBottom.jsp"></jsp:include>
</body>
</html>