<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@include file="../common/common.jsp"%>
 <%@ page import="java.util.*,com.lovebcub.news.dao.impl.NewsDaoImpl,com.lovebcub.news.dao.NewsDao,com.lovebcub.news.entity.News"%>
<!DOCTYPE html ">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>DeletePage</title>
</head>
<body>
<%	
	News news = new News();
	String id = request.getParameter("id");
	news.setId(Integer.parseInt(id));
	NewsDao newsDao = new NewsDaoImpl();
	newsDao.delete(news);
	response.sendRedirect("newsDetailList.jsp");








%>
</body>
</html>