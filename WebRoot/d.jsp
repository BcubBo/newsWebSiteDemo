<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>d</title>
</head>
<body>


<%
	out.println("d.jsp===============<br/>");
	//request.setAttribute("name","在d.jsp中设置b的attribute由b到c的request已经失效");
	
	out.println("name:"+request.getAttribute("name")+"<br/>");
	out.println("id:"+request.getParameter("id")+"<br/>");
	



%>

<!--作用域相关-->

</body>
</html>