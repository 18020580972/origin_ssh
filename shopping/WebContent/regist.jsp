<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>


<style>
.a{
border:2px solid red

}
.b{border:1px solid #CCCCCC
}
div.d2{color:#CCCCCC;
	size:12;

}

input{
border:1px solid #CCCCCC;
width:300px;
height:40px;}
div.d1{background-image:url(imger/top.png); 
		width:100%; 
		height:100px;
		border:0px solid #999999;
}
table{
border:0px solid #999999;
width:550px;
height:600px;
margin:auto;
text-align:center;
size:36px;

}
#u {
border:0px solid #FF0000;
 background-color:#FF0000;
 background-repeat: no-repeat;
 color:#FFFFFF;
}
</style>
</head>

<body>
<div class="d1"></div>
<div  >
	<form action="regist" method="post">
		<table >
			<tr> 
				<td>用户名</td><td><input type="text" id="yhm" name="uname"/></td><td><div class="d2" id="nameTip">30长度以内的字母，数字和下划线的组合</div></td>
			</tr>
			<tr> 
				<td>密码</td><td><input type="password" id="pwd" name="upass" /></td><td><div class="d2" id="pwdTip">30长度以内的字母，数字和下划线的组合</div></td>
			</tr>
			<tr> 
				<td>密码</td><td><input type="password"  id="nwd"/></td><td><div class="d2" id="nwdTip">两次密码必须相同</div></td>
			</tr>
			<tr> 
				<td>手机号</td><td><input type="text" id="phone" name="phone" /></td><td><div class="d2" id="phoneTip">正确的电话号码格式：手机或固话</div></td>
			</tr>
			<tr> 
				<td></td><td><input type="submit"  value="注册" id="u"/></td><td></td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>
<script type="text/javascript">

var xmlhttprequest = null;

function createXmlHttpRequest()
{
	//创建xmlhttprequest;根据浏览器不同创建方式不同
	if(window.ActiveXObject)//ie5或者ie6
	{
		xmlhttprequest = new ActiveXObject("Microsoft.XMLHTTP");
	}else if(window.XMLHttpRequest)//其他浏览器创建方式
	{
		xmlhttprequest = new XMLHttpRequest();
	}	
}

function checkUname()
{
	
	var uname = document.getElementById("yhm").value;
	createXmlHttpRequest();
	//准备请求参数
	xmlhttprequest.open("post","checkUser");//post:请求方式  js:请求地址（servlet/jsp）
	var postStr="uname="+uname; //包装请求参数 
	xmlhttprequest.onreadystatechange = func;
	xmlhttprequest.setRequestHeader("content-type","application/x-www-form-urlencoded");
	xmlhttprequest.send(postStr);//给服务器发送请求
}

function func(){//定义一个方法，供服务调用（方法回调）
	if(xmlhttprequest.readyState ==4){
		if(xmlhttprequest.status == 200)
		{
			var text = xmlhttprequest.responseText;
			alert(text);
			if(text.trim()=="no")
			{
				document.getElementById("checku").style.display = "block";
				document.getElementById("yhm").value="";
				document.getElementById("yhm").focus();
			}else
			{
				document.getElementById("checku").style.display = "none";
			}
			
		}
	}
}



</script>
<script>
window.onload=function(){
	
	
		var yhm=document.getElementById("yhm");
		var pwd=document.getElementById("pwd");
		var nwd=document.getElementById("nwd");
		var yzm=document.getElementById("phone");
		
		yhm.onmouseover=function(){
			yhm.className="a";
		}
		yhm.onmouseout=function(){
			yhm.className="b";
		}
		pwd.onmouseover=function(){
			pwd.className="a";
		}
		pwd.onmouseout=function(){
			pwd.className="b";
		}
		nwd.onmouseover=function(){
			nwd.className="a";
		}
		nwd.onmouseout=function(){
			nwd.className="b";
		}
		yzm.onmouseover=function(){
			yzm.className="a";
		}
		yzm.onmouseout=function(){
			yzm.className="b";
		}
		
		yhm.onblur=function()
		{
			checkUname();
			var reg=/^\w*$/;
			var nameTip=document.getElementById("nameTip");
			if(yhm.value.length>30)
			{
				nameTip.style.color="red";
				nameTip.innerHTML="输入错误！";
				
			}else
			{
				nameTip.style.color="green";
				nameTip.innerHTML="ok！";
			}
		}
		pwd.onblur=function()
		{
			var reg=/^\w*$/;
			var pwdTip=document.getElementById("pwdTip");
			if(pwd.value.length>30)
			{
				pwdTip.style.color="red";
				pwdTip.innerHTML="输入错误！";
			
			}else
			{
				pwdTip.style.color="green";
				pwdTip.innerHTML="ok！";
			}
		}
		nwd.onblur=function()
		{
		
			var nwdTip=document.getElementById("nwdTip");
			if(pwd.value!=nwd.value)
			{
				nwdTip.style.color="red";
				nwdTip.innerHTML="两次密码不相同！";
				
				
			}else
			{	
				nwdTip.style.color="green";
				nwdTip.innerHTML="ok！";
			}
		}
		yzm.onblur=function()
		{
			var reg=/^\d{11}$/;
			var phoneTip=document.getElementById("phoneTip");
			if(!reg.test(yzm.value))
			{
				phoneTip.style.color="red";
				phoneTip.innerHTML="输入错误！";
			}else
			{
				
				phoneTip.style.color="green";
				phoneTip.innerHTML="ok！";
			}
		}
		
	}
</script>