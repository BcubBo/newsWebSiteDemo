<%@page import="java.text.SimpleDateFormat,java.util.Date,java.text.SimpleDateFormat"%>
<%@ page language="java"  pageEncoding="UTF-8"%>
<%@page import="java.util.Date ,java.text.SimpleDateFormat,java.net.URLDecoder"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

	<%!
		/* String timeNow = "";
		public String showTime(){
		
		
		Date date = new Date();
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd,hh-mm-ss");
		
		timeNow = format.format(date);
		
		return timeNow;
		
		
	} */
		
	
	
	
	
	%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>JSP开始界面</title>
    <meta http-equiv="Content-Type" content="text/html charset=UTF-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		
		var timeString = "";
		
		function showTimeLoop(){
			var date = new Date();
			var year =date.getFullYear("yyyy");
			var month = date.getMonth("MM")+1;
			var dateOfMonth = date.getDate("dd");
			var hour = date.getHours("hh");
			var minute = date.getMinutes("mm");
			var second = date.getSeconds("ss");
			if(month<=9){
				
				month = "0"+month;
			}
			if(dateOfMonth<=9){
				dateOfMonth="0"+dateOfMonth;
			}
			if(hour<=9){
				hour="0"+hour;
			}
			if(minute<=9){
				minute="0"+minute;
				
			}
			if(second<=9){
				second="0"+second;
			}
			timeString = year+"-"+month+"-"+dateOfMonth+"-"+hour+":"+minute+":"+second;
			document.getElementById("divBlock_3").innerHTML = timeString;
			
		}
		function timeloop(){
			 var timeloop = setInterval("showTimeLoop()",100);
		}
	
	
	
	
	
	</script>
	<link type="text/css" rel="stylesheet" href="pages/css/common.css" />
	<style type="text/css">
	.divBlock_1{
		font-size:40px;
		color:green;
		background-color:lightgreen;
		text-align:center;
	
	}
	.divBlock_2{
		font-size:30px;
		color:red;
		background-color:yellowgreen;
		text-align:center;
	
	}
	.divBlock_3{
		color:green;
		background-color:greenyellow ;
		font-size:20px;
		text-align:center;
	
	
	}
	
	</style>
  </head>
  
  <body style="align:center" onload="timeloop()">
	  <div class="divBlock_1"><%out.print("JSP测试标题>使用JAVA语句输出"); %></div>
	  <div class="divBlock_2" ><%=session.getId()%></div>
	    <div class="divBlock_3" id="divBlock_3">时间块 </div><br>
	    <div class="dviBlock_3">
	    <%
	    	Object attributeGet  = request.getAttribute("message");
	    if(null!=attributeGet){
	    	
	    	out.print(attributeGet.toString());
	    	
	    	
	    	
	   	 }
	    
	    
	    
		%>
	    
	    
	    </div>
	
	    
	    <!--页面的头部-->
	<div id="header">
	    <!--页面顶部-->
	    <div class="main-top">
	        <div class="logo"><a href=""><span>新闻大视野</span></a></div>
	        <div class="login-box">
	        <%
	        //session.invalidate();
	        //session.removeAttribute("");
	        Cookie [] cookies = request.getCookies();
	        String temp="";
	        for(int i =0;i<cookies.length;i++){
	        	if(cookies[i].getName().equals("user")){
	        		
	        		temp = URLDecoder.decode(cookies[i].getValue(),"UTF-8");
	        		
	        	}
	        	
	        	
	        }
	        session.setMaxInactiveInterval(20);
			Object sessionObj = session.getAttribute("user");
			if(sessionObj ==null){
			
			%>
				<label>用户名</label><input type="text" name="uname" id="name" value=<%=temp%>/><label>密码</label><input type="text" name="upassword" /><button>登录</button>
		
			<% }else
			{
			%>
			<div >欢迎<%=sessionObj.toString()%></div>
			<%
			
			}	
			%>
	            
	        </div>
	         <!--导航-->
	        <div class="nav">
	            <ul class="clearfix">
	                <li><a href="#">首页</a></li>
	                <li><a href="#">国内</a></li>
	                <li><a href="#">国际</a></li>
	                <li><a href="#">娱乐</a></li>
	                <li><a href="#">军事</a></li>
	            </ul>
	        </div>
	    </div>
	    <!--banner-->
	    <div class="main-banner"><img src="pages/images/banner.png" /></div>
	    <!--搜索横框-->
	    <div class="search-box">
	        <div class="sl">
	            <div class="sr clearfix">
	                <span class="left-search clearfix">
	                    <label>站内搜索</label><input type="text" name="keyword" value="关键词" /><button class="go-btn"></button>
	                </span>
	                <span class="right-link">
	                    <label>快速链接</label><select><option>-----专题选择-----</option></select><button class="go-btn"></button>
	                </span>
	            </div>
	        </div>    
	    </div>
	</div>
	<!--页面的主体-->
	<div id="content" class="main-content clearfix">
		<!--主体的的左边部分-->
	    <div class="main-content-left">
	        <!--新闻专题分类-->
	        <div class="class-box">
	            <div class="class-box-header">
	                <span class="fr"><a href="#">更多...</a></span>
	                <h3>新闻专题</h3>
	            </div>
	            <div class="class-box-content">
	                <ul>
	                    <li><a href="#">国内</a></li>
	                    <li><a href="#">国际</a></li>
	                    <li><a href="#">娱乐</a></li>
	                    <li><a href="#">军事</a></li>
	                    <li><a href="#">财经</a></li>
	                    <li><a href="#">天气</a></li>
	                    <li class="clear-bottom-line"><a href="#">科技</a></li>
	                </ul>
	            </div>
	        </div>
	        <!--最新新闻-->
	        <div class="left-box">
	            <div class="left-box-tbg">
	                <div class="left-box-bbg">
	                    <div class="left-box-header"><h3>最新新闻</h3></div>
	                    <div class="left-box-content">
	                        <ul>
	                            <li><a href="#">詹姆斯26+9+7热火2-1雷霆 詹姆斯快速实战迷踪步2+1</a></li>
	                            <li><a href="#">詹姆斯26+9+7热火2-1雷霆 詹姆斯快速实战迷踪步2+1</a></li>
	                            <li><a href="#">詹姆斯26+9+7热火2-1雷霆 詹姆斯快速实战迷踪步2+1</a></li>
	                        </ul>
	                    </div>
	                </div>
	            </div>
	        </div>
	        <!--最新评论-->
	        <div class="left-box">
	            <div class="left-box-tbg">
	                <div class="left-box-bbg">
	                    <div class="left-box-header"><h3>最新评论</h3></div>
	                    <div class="left-box-content">
	                        <ul>
	                            <li><a href="#">詹姆斯26+9+7热火2-1雷霆 詹姆斯快速实战迷踪步2+1</a></li>
	                            <li><a href="#">詹姆斯26+9+7热火2-1雷霆 詹姆斯快速实战迷踪步2+1</a></li>
	                            <li><a href="#">詹姆斯26+9+7热火2-1雷霆 詹姆斯快速实战迷踪步2+1</a></li>
	                        </ul>
	                    </div>
	                </div>
	            </div>
	        </div>
	    </div>
	    <!--页面主体的右部，包括新闻的列表和评论内容 -->
	    <div class="main-content-right">
	        <!--各专题的新闻列表-->
	        <div class="main-text-box">
	            <div class="article-place"><a href="#">新闻中心</a> > <a href="#">国内</a></div>
	      		<div class="main-text-box-tbg">
	                <div class="main-text-box-bbg">
	                    <div class="article-box">
	                    	<!--新闻的标题-->
	                        <h1>
	                        <!--html注释-->
	                        <%
	                        	
	                        	out.print("\"再\"谈\"北京精神\"");
	                        	Date date = new Date();
	                        	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
	                        	String timeNow = dateFormat.format(date);
	                     		String author = "BcubBo";
	                        
	                        	String summary = "摘要：北京是一座拥有灿烂文明的古城，厚重的历史积淀，涵育了辉煌的北京文化。而这种融贯北京万众情怀、铸造北京城市特质、传沿北京文化基因、孕育北京创新灵魂的文化精髓，就是北京精神。侯仁之先生在谈到北京的城市建设时曾经提到过3个里程碑：紫禁城，天安门广场和国家奥林匹克体育中心、亚运村。侯先生认为，紫禁城是封建社会宫殿建筑中最有代表性的一组建筑群，是历史上封建皇权统治的中心，无论在文化上还是古迹上都举世闻名。新中国把天安门广场这样一个旧时代的宫廷广场，改造成人民的广场，给北京带来了一个全新的景象，这在北京城市建设发展史上具有重要意义。";
	                        	String introduce = "   国家奥林匹克体育中心和亚运村的建设是对北京城传统中轴线的延伸，代表着北京走向国际、走向世界。北京的城市建设和建筑是与民族的兴衰联系在一起的，就像北京的中轴线，从北京厚重的历史中出发，奔向充满光明、充满希望的未来，奔向广阔的世界、无垠的宇宙。北京有着3000多年的建城史，800多年的建都史。从西周时期到辽金时期，北京作为地方首府，城市的中心点和中轴线不断改变。直到元代，蒙古铁骑扫荡了华夏四方，北京才真正成为全国的政治中心，中轴线也确定下来。中轴线在北京城市规划上具有重要意义，它就像一条奔涌着民族血液的动脉，为我们的民族、我们的国家、我们的北京时刻输送着营养和活力。中轴线凝聚了北京人民的爱国情怀，显示了北京的宽容、厚重与博大，也体现了北京的吸纳与创新。纵观世界，多少历史古城在浩瀚的风云中固守而亡，而北京几经磨难，依然能迈着豪迈的步伐，坚定自信地向充满希望的未来走去，我们不能不为北京的吸纳与创新而自豪！  ";
	                        //java注释
	                        //jsp注释
	                        
	                        
	                        %>
	                        
	                        
	                        
	                        </h1>
	                        <div class="source-bar">发布者：<%=author%> 分类：新闻信息 更新时间：<%=timeNow%></div>
	                        <div class="article-content">
	                            <span class="article-summary"><b><%=summary%></b></span>
	                            <p><%=introduce%></p>
	                            
	                        </div>
	                        <div class="comment">
	                            <dl>
	                                <dt class="comment-top">
	                                    <span class="fr">2011-09-25 13:33:55</span>
	                                    <b>1楼</b> <b>水上漂</b>
	                                </dt>
	                                <dd class="comment-body">
	                                    <span class="fr"><a href="#">支持</a>（0） <a href="#">回复</a>（0）</span>
	                                    我支持华莱士去拉大斯
	                                </dd>
	                            </dl>
	                            <dl>
	                                <dt class="comment-top">
	                                    <span class="fr">2011-09-25 13:33:55</span>
	                                    <b>2楼</b> <b>拉娜</b>
	                                </dt>
	                                <dd class="comment-body">
	                                    <span class="fr"><a href="#">支持</a>（1） <a href="#">回复</a>（0）</span>
	                                    还是早点退役吧
	                                </dd>
	                            </dl>
	                        </div>
	                        <div class="comment-form">
	                            <div class="comment-form-header">
	                                <span>用户：Landodo</span>
	                                <h3>发表评论：</h3>
	                            </div>
	                            <div class="comment-form-content">
	                                <textarea class="comment-textarea"></textarea>
	                                <button type="submit" class="comment-btn">评论</button>
	                            </div>
	                        </div>
	                    </div>
	                </div>
	            </div>
	        </div>
	        <!--//-->
	        
	        
	    </div>
	</div>
	<!--页面底部-->
	<div class="main-footer-box">
	    24小时客户服务热线：010-68988888 常见问题解答 新闻热线：010-627488888<br />
	    文明办网文明上网举报电话：010-627488888 举报邮箱：jubao@bj-aptech.com.cn<br />
	    Copyright&copy;2017-2017 News China gov,All Right Reserved.<br />
	    新闻中心版权所有
	    <%
	    	Object count = application.getAttribute("count");
	    	if(count==null){
	    		application.setAttribute("count",1);
	    		
	    		
	    	}else{
	    		application.setAttribute("count",(Integer)count+1);
	    		
	    	}
	    	
	    
	    
	    
	    
	    %>
	    <div>网站统计:<%=count%></div>
	</div>
  </body>
</html>
