<%@page import="com.lovebcub.news.entity.News"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@include file="../common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	
		String id = request.getParameter("id");
		News news = new News();
		news = newsService.getNewsById(Integer.parseInt(id));
	
	
	
	
	
	
	%>
	      		<div class="main-text-box-tbg">
	                <div class="main-text-box-bbg">
	                    <div class="article-box">
	                    	<!--新闻的标题-->
	                        <h1>
	                        <!--html注释-->
	                        
	                        </h1>
	                        <div class="source-bar">发布者：<%=news.getAuthor()%> 分类：<%=news.getCategoryName()%> 更新时间：<%=news.getCreateDate()%></div>
	                        <div class="article-content">
	                            <span class="article-summary"><b><%=news.getSummary()%></b></span>
	                            <p><%=news.getContent()%></p>
	                            
	                        </div>

	                        
	                    </div>
	                </div>
	            </div>
</body>
</html>