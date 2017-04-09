<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.lovebcub.news.dao.*,java.sql.Connection"
    
    %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	BaseDao baseDao = new BaseDao();
	Connection connection = baseDao.getConnectionObjUseDataSource();



%>
<%=connection%>
</body>
</html>