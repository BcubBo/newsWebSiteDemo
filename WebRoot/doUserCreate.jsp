<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.net.URLEncoder"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>中间跳转</title>
</head>
<body>
<%
/* 	post请求处理方式
	//设置请求的编码格式
	request.setCharacterEncoding("UTF-8");
	//设置响应的编码格式
	response.setCharacterEncoding("UTF-8");	
	
	get请求处理方式
	useBodyEncodingForURI="true";
	
	*/
	
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	out.println("username:"+username+"<br/>");
	out.println("password:"+password+"<br>");
	out.print(request.getParameter("con_password")+"<br/>");//confirm password
	String email = request.getParameter("email");
	out.println("email:"+email+"<br/>");
	//URLEncoder.encode(username,"utf-8")
	
	if(username.equals("admin")){
		//提示用户已经存在，不能注册
		request.setAttribute("message","用户已存在");
		request.getRequestDispatcher("userCreate.jsp").forward(request,response);
		//转发将信息携带并返还给上一个请求页面
	}else{
		//提示注册成功
		Cookie cookie = new Cookie("user",username);
		cookie.setMaxAge(60*60);
		response.addCookie(cookie);
		session.setAttribute("user",URLEncoder.encode(username,"utf8"));
		//session设置属性将值进行传递
		//request.getRequestDispatcher("NewFile.jsp").forward(request,response);
		//请求调度器进行页面的调度，转发
		//<jsp:forward page="NewFile.jsp"/>
		response.sendRedirect("NewFile.jsp?class=test");
		//重定向
	} 
	



%>




&copy;BcubBo

</body>
</html>