<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<style type="text/css">

body{
background-image:url(imger/a.png)}
input{
border:1px solid #CCCCCC;
	width:257px;
	height:35px;
	}
.inp1{
	border:2px solid #FF0000;
	}
.inp2{
	border:1px solid #CCCCCC;
	}
	#u {
border:0px solid #FF0000;
 background-color:#FF0000;
 background-repeat: no-repeat;
 color:#FFFFFF;
 size:36;
 width:300px;
 height:42px;
}
</style>
</head>

<body>
<form action="login" method="post" >
<div style="position:absolute; margin-top:278px; margin-left:920px">
	<input id="name" type="text" name="uname"/>

</div>
<div style="position:absolute; margin-top:340px; margin-left:920px">
	
	<input id="pwd" type="password" name="upass"/>
</div>
	<div style="position:absolute; margin-top:402px; margin-left:878px">
	<input type="submit" id="u" value="登录">
	
	</div>
</form>
</body>
</html>
<script>
<script>

window.onload=function (){

	
	var yhm=document.getElementById("name");
	var pwd=document.getElementById("pwd");
	var yzm=document.getElementById("yzm");
	
	yhm.onmouseover=function(){
		yhm.className="inp1";
	}
	yhm.onmouseout=function(){
		yhm.className="inp2";
	}
	pwd.onmouseover=function(){
		pwd.className="inp1";
	}
	pwd.onmouseout=function(){
		pwd.className="inp2";
	}
	yzm.onmouseover=function(){
		yzm.className="inp1";
	}
	yzm.onmouseout=function(){
		yzm.className="inp2";
	}
	yhm.onblur=function()
	{
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
	
	//获取验证码
		var code="";
		var codeLength=4;
		var checkCode=document.getElementById("v1").childNodes;
		var color=['blue','green','yellow','pink','orange','red'];
		var random=[0,1,2,3,4,5,6,7,8,9,'Q','W','E','R','T','Y','U','I','O','P','A','S','D','F','G','H','J','K','L','Z','X','C','V','B','N','M'];
		for(var i=0;i<codeLength;i++){
			var index1=Math.floor(Math.random()*6);
			var index=Math.floor(Math.random()*36);
			checkCode[i].style.color=color[index1];
			checkCode[i].innerHTML=random[index];
			code+=random[index];
		}
	
	
	
	
	//判断验证码
	yzm.onblur=function()
	{
		var dv=document.getElementById("v2");
		
		var inpCode=yzm.value.toUpperCase();//取得验证码并转化为大写
		if(inpCode.length<=0)
		{
			dv.innerHTML="请输入验证码";
		}
		else if(inpCode!=code)
		{
			dv.style.color="red";
			dv.innerHTML="验证码错误！";
			yzm.value="";
			
		}
		else
		{
			dv.style.color="green";
			dv.innerHTML="ok！";
		}
	}
	
}
</script>


