<%@page import="com.lovebcub.news.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String guest = request.getParameter("guest");
	if(guest!= null&& !guest.equals("")){
		
		User user  = new User();
		user.setUserName(guest);
		session.setAttribute("guest",user);
		response.sendRedirect("online.jsp");
	}else{
		
		response.sendRedirect("enter.jsp");
		
		
	}






%>
</body>
</html>