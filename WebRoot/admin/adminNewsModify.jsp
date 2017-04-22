<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@include file="../common/common.jsp"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.lovebcub.news.entity.News"%>
<%@page import="com.lovebcub.news.entity.NewsCategory"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="${request.getContextPath()}/css/common.css"
	type="text/css" rel="style"
	

/>
<script type="text/javascript" src="../ckeditor/ckeditor.js">
</script>
<script type="text/javascript" src="./adminJS/contentCheck.js">
</script>
</head>

<%
	//取得新闻分类列表
	List<NewsCategory> newsCategoryList = new ArrayList<NewsCategory>();
	newsCategoryList = newsCategoryService.getNewsCategoryList();
	request.setAttribute("newsCategoryList",newsCategoryList);
	//取得这个要修改的新闻信息明细
	String id = request.getParameter("id");
	News news = new News();
	news = newsService.getNewsById(Integer.parseInt(id));
	request.setAttribute("news",news);







%>








<body>
<form name ="dataFrm" id="dataFrm" action="doAdd.jsp" method="post"
	enctype="multipart/form-data" onsubmit="return checkIfIsNull()"
>
	<table  width="100%" border="0" cellspacing="5" cellpadding="0">
		<thead>
			<tr><td align="center" colspan="2" class="text_tabledetail2">修改新闻使用EL表达式和JSTL</td></tr>
		</thead>
		<tbody>
			<tr>
				<td style="text-align:right;" class="text_tabledetail2" >分类</td>
				<td style="text-align:left;">
				<!-- 列出所有的新闻分类 -->
					<select name="categoryId">
					<option value="0">--请选择--</option>
					<c:if test = "${newsCategoryList ne null}">
					<c:forEach var="newsCategory" items="${newsCategoryList}">
						
	        			<option 	        			
	        			<c:if test="${newsCategory.id eq news.categoryId}"> 							selected="selected"	        			
	        			</c:if>			
	        			value="${newsCategory.id}">${newsCategory.name}</option>		
	        			</c:forEach>
	        			</c:if>
	        		</select>
	        		
	        		
				</td>
			</tr>
			<tr>
				<td  style="text-align:right;" class="text_tabledetail2" id="checkPoint">标题</td>
				<td style="text-align:left;"><input type="text" name="title" value=""/></td>
			</tr>
			<tr>
				<td  style="text-align:right;" class="text_tabledetail2">作者</td>
				<td style="text-align:left;"><input type="text" name="author" value="${news.author}"/></td>
			</tr>
			
			<tr>
				<td  style="text-align:right;" class="text_tabledetail2">摘要</td>
				<td style="text-align:left;"><textarea id="summary" name="summary" rows="8" cols="50">${news.summary}</textarea></td>
			</tr>
			<tr>
				<td  style="text-align:right;" class="text_tabledetail2">内容</td>
				<td style="text-align:left;">
				<div id="xToolbar"></div>
				<textarea id="newscontent" name="newscontent" rows="8" cols="30" class="ckeditor">${news.content}</textarea></td>
			</tr>
			<tr>
				<td  style="text-align:right;" class="text_tabledetail2">上传图片 </td>
				<td style="text-align:left;"><input type="file" name="picPath" value="${request.getContextPath()}/upload/${news.picPath}"/></td>
			</tr>
			<tr>
				<td  style="text-align:center;" colspan="2">
					<button type="submit" class="page-btn" name="save">保存</button>
					<button type="button" class="page-btn" name="return" onclick="returnForward()">返回</button>
				</td>
			</tr>
		</tbody>
	</table>
</form>
</body>
</body>
</html>