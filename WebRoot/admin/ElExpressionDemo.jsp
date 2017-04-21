<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EL Expression</title>
</head>
<body>
<%
	String name = "EL>>>>>ExpressionDemonstration";
	request.setAttribute("name",name);
	ArrayList<String> list = new ArrayList<String>();
	list.add("EL___Demo_StatementOne");
	list.add("EL___Demo_StatementTwo");
	list.add("EL___Demo_StatementThree");
	request.setAttribute("listArray",list);
%>
<div>${name}</div>
<div>${listArray[0]}</div>
<div>${listArray[1]}</div>
<div>${listArray[2]}</div>
</body>
</html>