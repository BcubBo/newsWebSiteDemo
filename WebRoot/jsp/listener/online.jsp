<%@page import="com.lovebcub.news.entity.User, com.lovebcub.news.contants.userContants"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ONLINE</title>
</head>
<body>
<%
	User user = (User)session.getAttribute("guest");
	String guest = user.getUserName();


%>
当前用户:${guest}<br>
在线人数:${userContants.USER_ONLINE_COUNT}<br>
<a href="quit.jsp">退出</a>

</body>
</html>