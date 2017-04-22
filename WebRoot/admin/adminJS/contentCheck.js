/**
 * 
 */

			function returnForward(){
				
				window.location = "newsDetailList.jsp";
			}
			function checkIfIsNull(){
				//添加判断语句防止为空的情况
				var valueArray = new Array();
				var inputObj = document.getElementsByTagName("input");
				var checkPoint  = 0;
				for(var i = 0;i<inputObj.length; i++){
					valueArray[i] = inputObj[i].value;
					//注意var的使用

				}
				for(var i = 0;i<valueArray.length;i++){
					if(valueArray[i]!=null && valueArray[i]!=""){
						checkPoint+=1;
					}
				}
				if(checkPoint==valueArray.length){
					var docObj = document.getElementsByTagName("td");
					for(var i = 0;i<docObj.length;i++ ){
						docObj[i].style.color="green";
					}
					return confirm("是否提交数据");
					
					
				}else{
					var docObj = document.getElementsByTagName("td");
					for(var i = 0;i<docObj.length;i++ ){
						docObj[i].style.color="red";
					}
					alert("添加项目不可为空!");
					return false;
				}
				
			}