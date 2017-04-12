<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@page import="com.lovebcub.news.entity.News,java.util.Date"%>
 <%@include file="../common/common.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%

	//设置请求的字符编码utf-8
	request.setCharacterEncoding("utf-8");
	String categoryId = request.getParameter("categoryId");
	String title = request.getParameter("title");
	String author = request.getParameter("author");
	String summary = request.getParameter("summary");
	String content = request.getParameter("newscontent");
	//从请求中取出数据，提交数据库
	News news = new News();
	news.setAuthor(author);
	news.setCategoryId(Integer.parseInt(categoryId));
	news.setContent(content);
	news.setSummary(summary);
	news.setTitle(title);
	news.setCreateDate(new Date());
	
	%>
	
	<%
	if(newsService.add(news)){
		
		//request.getRequestDispatcher("newsDetailList.jsp").forward(request,response);
	%>
	
	<jsp:forward page="newsDetailList.jsp"/>
		
		
	<%}%>
	






</body>
</html>