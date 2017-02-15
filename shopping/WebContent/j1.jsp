<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<style>
	div.d1{
		border:border:0px solid #FFFFFF;
		width:100%;
		height:662px;
		background-image:url(imger/j1.png);
	}
	input.i1{
		border:border:0px solid red;
		width:180px;
		height:40px;
		background-image:url(imger/mai.png);
	
	}
	input.i2{
		border:border:0px solid red;
		background-image:url(imger/che.png);
		width:180px;
		height:40px;
	}
	div.d3{
	
	border:1px solid #CCCCCC;
	display:inline-block;
	margin-left:100px;
	
}
</style>
<body>
<div class="d1"></div>


<div>
<form action="addGwc" method="post">
<input style="display:none" name="sname" value="rongyao">
<input style="display:none" name="jiage" value="3699.00">
<div class="d3"><input class="i1" type="submit" value="" ></div>
<div class="d3"><input class="i2" type="submit" value=""></div>
<div class="d3" style="display:none">添加成功</div>
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

window.onload=function()
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
				
			}else
			{
				document.getElementById("checku").style.display = "none";
			}
			
		}
	}
}



</script>