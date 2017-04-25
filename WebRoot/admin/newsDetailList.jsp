<%@page import="com.lovebcub.news.util.PageSupport"%>
<%@page import="com.lovebcub.news.entity.News"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../common/common.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script type="text/javascript">
 function addNews(){
	 window.location = "newsDetailCreateSimple.jsp";
 }
 function page_nav(frm,num){
	
	 frm.pageIndex.value = num ;
	 frm.submit();
	 
 }
 function jump_to(frm,num){
	 //用户输入验证
	 var regExp = /^[1-9]\d*$/;
	 var totalPageCount = document.getElementById("totalPageCount").value;
	 if(!regExp.test(num)){
		 alert("请输入大于0的正整数!");
		 
		 return false;
	 }else if((num-totalPageCount)>0){
		 alert("请输入"+totalPageCount+"以内的数字");
		 return false;
		 
		 
	 }else{
		 page_nav(frm,num);
	 }
 }
</script>
  <div class="main-content-right">
        <!--即时新闻-->
        <div class="main-text-box">
            <div class="main-text-box-tbg">
                <div class="main-text-box-bbg">
                    <form name ="searchForm" id="searchForm" action="newsDetailList.jsp" method="post">
		 	<div>
		 				新闻分类：
		 					<select name="categoryId">
		 						<option value="0">全部</option>
			        			
			        				<option value='1' >国内</option>
			        			
			        				<option value='2' >国际</option>
			        			
			        				<option value='3' >娱乐</option>
			        			
			        				<option value='4' >军事</option>
			        			
			        				<option value='5' >财经</option>
			        			
			        				<option value='6' >天气</option>
			        			
	        				</select>
		 				新闻标题<input type="text" name="title" id="title" value=''/>
		 					
		 					<button type="submit" class="page-btn">GO</button>
		 					<button type="button" onclick="addNews();" class="page-btn">增加</button>
		 					<input type="hidden" id="pageIndex" name="pageIndex" value="1"/>					
		 					

		 	</div>
		 	</form>
			<table style="cellpadding:1, cellspacing:1" class="admin-list">
				<thead >
					<tr class="admin-list-head">
						<th>新闻标题</th>
                        <th>作者</th>
                        <th>时间</th>
                        <th>操作</th>
                    </tr>
                </thead>
                <%
                	//页面容量
                	int pageSize = 2;
               		//StirngUtils.isNullOrEmpty(arg);
                	//当前页码
                	String pageIndex = request.getParameter("pageIndex");
                	//获取的getParameter是表单提交中的name的值所以取得的name的值为pageIndex的input标签中value的值 name和value是一对键值对
                	int currentPageNo = 1;
                	if(pageIndex==null){
                		currentPageNo = 1;
                	}else{
                		try{
                			
                			currentPageNo = Integer.parseInt(pageIndex);
                			
                		}catch(NumberFormatException e){
                			response.sendRedirect("error.jsp");
                			
                		}
                		
                	}
                	
                	
                	//总记录数
                	int totalCount = newsService.getNewsCount();
                	//总页数
                	PageSupport pageSupportObj = new PageSupport();
                	pageSupportObj.setPageSize(pageSize);
                	pageSupportObj.setCurrentPageNo(currentPageNo);
                	pageSupportObj.setTotalCount(totalCount);
                	int totalPageCount = pageSupportObj.getTotalPageCount();
                	//首页和尾页的异常控制
                	if(currentPageNo<0){
                		currentPageNo = 1;
                		
                	}
                	
                	if(currentPageNo>totalPageCount){
                		
                		currentPageNo = totalPageCount;
                		
                	}
                	request.setAttribute("totalCount",totalCount);
                	request.setAttribute("totalPageCount",totalPageCount);
                	request.setAttribute("currentPageNo",currentPageNo);
                	
                	List<News> newsList = newsService.getPageNewsList(currentPageNo,pageSize);
request.setAttribute("newsList",newsList);

                %>
                
                <tbody>
                <c:forEach var="news" items="${newsList}" varStatus="status" >
                	<tr <c:if test="${status.count%2!=0}">class="admin-list-td-h2"</c:if>>
                		<td><input type="hidden" id="totalPageCount" name="totalPageCount" value="${totalPageCount}"/>
                		<a href='adminNewsView.jsp?id=${news.getId()}'>
                		<c:out  value = "${news.title}"  escapeXml="false"/></a></td>
                		<td><c:out value="${news.author}" default="暂无"/></td>
                		<td><c:out value="${news.createDate}" default="暂无"/></td>
                		<td><a href=
                		<c:url value="${request.getContextPath()}/doModify">
                			<c:param name="id" value="${news.id}"></c:param>
                			<!--获取了id-->
                		
                		
                		</c:url>
                		
                		
                		
                		
                		>修改</a>
                			<a href="javascript:if(confirm('确认是否删除此新闻？')) location='adminNewsDel.jsp?id=${news.id}'">删除</a>
                		</td>
                	</tr> 
                	 </c:forEach>
                </tbody>
               

            </table>
            <jsp:include page="rollPage.jsp"></jsp:include>
            <%--直接做一个动态包含就好了--%>
                    <%--  <div class="page-bar">
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
		</div>  --%>

        </div>
       </div>
   </div>
 </div>
 </body>
