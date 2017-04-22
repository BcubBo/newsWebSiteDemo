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
		request.setAttribute("news",news);
		
		//out.println("newsPicpath:"+news.getPicPath());
	
	
	
	
	%>
	      		<div class="main-text-box-tbg">
	                <div class="main-text-box-bbg">
	                    <div class="article-box">
	                    	<!--新闻的标题-->
	                        <h1>
	                        <!--html注释-->
	                        ${news.title}
	                        </h1>
	                        <div class="source-bar">发布者：${news.author}&nbsp;&nbsp; 分类：${news.categoryName}&nbsp;&nbsp; 更新时间：${news.createDate}</div>
	                        <div class="article-content">
	                            <span class="article-summary"><b>摘要:${news.summary}</b></span>
	                            <%if(news.getPicPath()==null||news.getPicPath().equals("")){%>
	                            新闻图片:暂无
	                            <%}else{%>
	                            <img alt="Git" src="${request.getContextPath()}/upload/${news.picPath}" width="500px"height="300px"/>
	                            <%}
	                            
	                            %>
	                            <br/>
	                            <p>${news.content}</p>
	                            
	                        </div>
							<div>修改为JSTL表达式模式</div>
	                        
	                    </div>
	                </div>
	               <input type="button" name="backButton" value="返回" onclick="javascript:location.href='newsDetailList.jsp'"/>
	            </div>
	             
</body>
</html>