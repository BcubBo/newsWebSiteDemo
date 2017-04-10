<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>b</title>
</head>
<body>


<%
	out.println("b.jsp===============<br/>");
	out.println("id:"+request.getParameter("id")+"<br/>");
	request.setAttribute("name","谁知道呢");
	out.println("name:"+request.getAttribute("name")+"<br/>");
	//a.jsp中的attribute就消亡了，因为链接了bc的request作用域改变



%>
<a href="c.jsp?class=T01">链接到c.jsp，参数class=T01，requestBC诞生</a>
</body>
</html>