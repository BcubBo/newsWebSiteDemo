<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>c</title>
</head>
<body>


<%
	out.println("c.jsp===============<br/>");
	request.setAttribute("name","在c.jsp中设置b的attribute由A到B的request已经失效");
	
	out.println("name:"+request.getAttribute("name")+"<br/>");
	out.println("class:"+request.getParameter("class")+"<br/>");



%>
<jsp:forward page="d.jsp?id=000123124"/>
<!--作用域延长了-->
<!--作用域相关-->

</body>
</html>