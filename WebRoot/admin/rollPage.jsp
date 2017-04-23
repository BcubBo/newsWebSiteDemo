<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
           <div class="page-bar">
			<ul class="page-num-ul clearfix">
				<li>共${totalCount}条记录 ${currentPageNo}/${totalPageCount}页</li>
				<c:if test="${currentPageNo>1}">
				<li><a href="javascript:page_nav(document.forms[0],1)">首页</a></li>
				<li><a href="javascript:page_nav(document.forms[0],${currentPgeNo-1})">上一页</a></li>
				
				</c:if>
				<c:if test="${currentPageNo<totalPageCount}">
				<li><a href="javascript:page_nav(document.forms[0],${currentPageNo+1})">下一页</a></li>
				<li><a href="javascript:page_nav(document.forms[0],${totalPageCount})">最后一页</a></li>
				
				</c:if>
			</ul>
		 <span class="page-go-form"><label>跳转至</label>
	     <input type="text" name="inputPage" id="inputPage" class="page-key" />页
	     <button type="button" class="page-btn" onClick='jump_to(document.forms[0],document.getElementById("inputPage").value)'>GO</button>
		</span>
		</div> 
</body>
</html>