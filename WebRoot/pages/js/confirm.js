/**
 * 
 */

var usernameCheckContainer = "";
var passwordCheckContainer = "";
var passwordConfirmCheckContainer = "";
var emailCheckContainer = "";

function getElementObject(attr) {

    return document.getElementById(attr);

}

function changeCssStyle(attr0, attr1, attr2, attr01, attr02, attr03, attr04) {
    attr0.innerHTML = attr01; //更改标签文本
    attr0.className = attr02; //更改标签样式
    attr1.style.border = attr03; //更改边界样式
    attr2.style.color = attr04; //更改字体的颜色

}


function objectSet(tag1, tag2, tag3) {
    var tag01 = getElementObject(tag1);
    var tag02 = getElementObject(tag2);
    var tag03 = getElementObject(tag3);
    var objectSets = new Array();
    objectSets[0] = tag01;
    objectSets[1] = tag02;
    objectSets[2] = tag03;
    return objectSets;
}
//获取标签对象集合

function checkUsernameEle() {
    // var uN = getElementObject("username");
    // var cObj = getElementObject("checkUsername");
    // var tB2 = getElementObject("textBox_2");
    var tagObjectSets = objectSet("checkUsername","username" ,"textBox_2");
    var checkUsernameReg = /^[A-Za-z]{3}\w{0,13}$/;
    var usernameValue = getElementObject("username").value;

    if (usernameValue != "") {
        if (checkUsernameReg.test(usernameValue)) {
            changeCssStyle(tagObjectSets[0], tagObjectSets[1], tagObjectSets[2], "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;输入正确", "confirmCorrectBox", "1px solid orange", "orange");
            usernameCheckContainer = true;
        } else {
            changeCssStyle(tagObjectSets[0], tagObjectSets[1], tagObjectSets[2], "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;输入错误,必须以字母开头且最少为3位最多位数为16位", 
            		"confirmIncorrectBox", "1px solid red", "red");
            usernameCheckContainer = false;
            }
    } else {

    	changeCssStyle(tagObjectSets[0],tagObjectSets[1],tagObjectSets[2],"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;必填选项，不可为空",
    			"confirmIncorrectBox","1px solid red","red");
        usernameCheckContainer = false;

    }
}
function checkPasswordEle() {

    var checkPasswordReg = /^\w{8,32}$/;
    var passwordValue = getElementObject("password").value;
    var tagObjectSets = objectSet("checkPassword","password","textBox_3");
    if (passwordValue != "") {
        if (checkPasswordReg.test(passwordValue)) {

            changeCssStyle(tagObjectSets[0],tagObjectSets[1],tagObjectSets[2],"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;正确","confirmCorrectBox",
            		"1px solid orange","orange");
            passwordCheckContainer = true;
        } else {
           
        	changeCssStyle(tagObjectSets[0],tagObjectSets[1],tagObjectSets[2],"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;输入错误，密码为字母数字下划线位数最少8位，最多32位",
        			"confirmIncorrectBox","1px solid red","red");
            passwordCheckContainer = false;
        }

    } else {
    	changeCssStyle(tagObjectSets[0],tagObjectSets[1],tagObjectSets[2],"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;必填选项，不可为空",
    			"confirmIncorrectBox","1px solid red","red");
        passwordCheckContainer = false;
    }


}

function checkPasswordConfirm() {
   
    var passwordValue = getElementObject("con_password").value;
    var confirmPasswordValue = getElementObject("con_password").value;
    var tagObjectSets = objectSet("checkConfirmPassword","con_password","textBox_4");
    if (passwordValue != "" && confirmPasswordValue != "") {
        if (passwordValue == confirmPasswordValue && passwordValue != null && passwordValue.length >= 8) {

        	changeCssStyle(tagObjectSets[0],tagObjectSets[1],tagObjectSets[2],"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;两次输入正确",
        			"confirmCorrectBox","1px solid orange","orange");
            passwordConfirmCheckContainer = true;


        } else {
        	
        	changeCssStyle(tagObjectSets[0],tagObjectSets[1],tagObjectSets[2],"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;两次输入不匹配，请重新输入",
        			"confirmIncorrectBox","1px solid red","red");
            passwordConfirmCheckContainer = false;


        }
    } else {
    	changeCssStyle(tagObjectSets[0],tagObjectSets[1],tagObjectSets[2],"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;必填选项，不可为空",
    			"confirmIncorrectBox","1px solid red","red");
        passwordConfirmCheckContainer = false;
    }

}

function checkEmail() {
    var emailReg = /^([A-Za-z]+\w*\@){1}(\w+\.)+[A-Za-z0-9]+$/ig;

    
    var tagObjectSets = objectSet("checkEmail","email","textBox_5");
    var emailCheck = getElementObject("email").value;
    if (emailCheck != "") {
        if (emailReg.test(emailCheck)) {

        	changeCssStyle(tagObjectSets[0],tagObjectSets[1],tagObjectSets[2],"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;正确",
        			"confirmCorrectBox","1px solid orange","orange");
            emailCheckContainer = true;




        } else {

        	changeCssStyle(tagObjectSets[0],tagObjectSets[1],tagObjectSets[2],"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;错误重新输入，例如vip@vip.com或vip@vip.cn或vip@vip.com.cn",
        			"confirmIncorrectBox","1px solid red","red");
            emailCheckContainer = false;

        }
    } else {

    	changeCssStyle(tagObjectSets[0],tagObjectSets[1],tagObjectSets[2],"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;必填选项，不可为空",
    			"confirmIncorrectBox","1px solid red","red");
        emailCheckContainer = false;

    }


} 

function submitCheck() {
    var finalCheck = getElementObject("finalCheck");
    var tB1 = getElementObject("textBox_1");
    var tB6 = getElementObject("textBox_6");
	
    if (usernameCheckContainer && passwordCheckContainer && passwordConfirmCheckContainer && emailCheckContainer) {
    	
        //进行submit事件验证
        finalCheck.className = "confirmCorrectBox";
        finalCheck.innerHTML = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;通过验证";
        tB1.style.color = "orange";
        tB6.style.color = "orange";
        return true;



    }
    finalCheck.className = "confirmIncorrectBox";

    finalCheck.innerHTML = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;无法通过验证,请填写必填选项";
    tB1.style.color = "red";
    tB6.style.color = "red";
    return false;




}