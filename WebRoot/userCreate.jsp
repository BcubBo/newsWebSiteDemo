<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户注册</title>
<script type="text/javascript"  src="pages/js/confirm.js">



</script>
<link type="text/css" rel="stylesheet" href="pages/css/confirmCheck.css"/>

</head>
<body  ><!--submit事件的错误处理注意-->
<form name ="dataForm" id="dataForm" action="doUserCreate.jsp" method="post" onsubmit="javascript:return submitCheck()" >
	<table class="tb" border="0" cellspacing="5" cellpadding="0" align="center">
		<tr><td align="center" colspan="2" style="text-align:center;" class="text_tabledetail2"id="textBox_1">用户注册</td></tr>
		<tr id="usernameBox">
			<td class="text_tabledetail2"id="textBox_2">用户名</td>
			<td ><input type="text" name="username"  onblur="javascript:checkUsernameEle()" id="username" value="" /></td>
			<td><div id="checkUsername" style="width:520px;height:21;" >*必填</div></td>
		</tr>
		<tr>
			<td class="text_tabledetail2"id="textBox_3">密码</td>
			<td><input type="password" name="password" value="" id="password" onblur="javascript:checkPasswordEle()"/></td>
			<td><div id="checkPassword" style="width:520px;height:21;">*必填</div></td>
		</tr> 
		<tr>
			<td class="text_tabledetail2"id="textBox_4">确认密码</td>
			<td><input type="password" name="con_password" value="" id="con_password" onblur="javascript:checkPasswordConfirm()"/></td>
			<td><div id="checkConfirmPassword"style="width:520px;height:21;">*必填</div></td>
		</tr>
		<tr>
			<td class="text_tabledetail2" id="textBox_5">email</td>
			<td><input type="text" name="email" value="" id="email" onblur="javascript:checkEmail()"/></td>
			<td><div id="checkEmail" style="width:520px;height:21;">*必填</div></td>
		</tr>

		<tr style="text-align:center">
			<td>
		
			</td>
			<td  style="text-align:center;" colspan="">				
				<button type="submit" class="page-btn" name="save" id="textBox_6" style="width:78px">注册</button>
				<button type="button" class="page-btn" name="return" onclick="javascript:location.href='<%=request.getContextPath() %>/index.jsp'" style="width:78px">返回</button>
			</td>
		</tr>
		<tr>
		<td colspan="2" style="text-align:center;" onclick="submitCheck()"> &copy;BcubBo
		</td>
		<td>
			<div id="finalCheck" >
				<%
				Object messageGet = request.getAttribute("message");
				if(null!=messageGet){
				
				out.println(messageGet.toString());
				
				}else{
				
				}
			
			
				%>
			</div>
		</td>
		</tr>
	</table>
	

</form>
</body>
</html>
