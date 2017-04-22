<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
	
	//取得这个要修改的新闻信息明细







%>








<body>
<form name ="dataFrm" id="dataFrm" action="doAdd.jsp" method="post"
	enctype="multipart/form-data" onsubmit="return checkIfIsNull()"
>
	<table  width="100%" border="0" cellspacing="5" cellpadding="0">
		<thead>
			<tr><td align="center" colspan="2" class="text_tabledetail2">增加新闻</td></tr>
		</thead>
		<tbody>
			<tr>
				<td style="text-align:right;" class="text_tabledetail2" >分类</td>
				<td style="text-align:left;">
				<!-- 列出所有的新闻分类 -->
					<select name="categoryId">
	        			<option value="1">国内</option>
	        			<option value="2">国际</option>
	        			<option value="3">娱乐</option>
	        			<option value="4">军事</option>
	        			<option value="5">财经</option>
	        			<option value="6">天气</option>
	        		</select>
				</td>
			</tr>
			<tr>
				<td  style="text-align:right;" class="text_tabledetail2" id="checkPoint">标题</td>
				<td style="text-align:left;"><input type="text" name="title" value=""/></td>
			</tr>
			<tr>
				<td  style="text-align:right;" class="text_tabledetail2">作者</td>
				<td style="text-align:left;"><input type="text" name="author" value=""/></td>
			</tr>
			
			<tr>
				<td  style="text-align:right;" class="text_tabledetail2">摘要</td>
				<td style="text-align:left;"><textarea id="summary" name="summary" rows="8" cols="50"></textarea></td>
			</tr>
			<tr>
				<td  style="text-align:right;" class="text_tabledetail2">内容</td>
				<td style="text-align:left;">
				<div id="xToolbar"></div>
				<textarea id="newscontent" name="newscontent" rows="8" cols="30" class="ckeditor"></textarea></td>
			</tr>
			<tr>
				<td  style="text-align:right;" class="text_tabledetail2">上传图片 </td>
				<td style="text-align:left;"><input type="file" name="picPath" value=""/></td>
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