
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="com.yw.model.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页面</title>
<style>
div.d1{ background-image:url(imger/d.png);
		border:0px solid #FFFFFF;
		width:100%;
		height:547px}
div.d2{ 
	width:260px;
	height:25px;
	margin-left:260px;
	margin-top:10px;
	border:0px solid #FFFFFF;
	background:#CCCCFF;
	color:#999999}
div.d3{
	width:236px;
	height:387px;
	border:1px solid #CCCCCC;
	display:inline-block;
	margin-left:100px;
	
}
div.d4{
	display:inline-block;
	border:1px solid #CCCCCC;
	margin-left:100px;
}
div.d5{
	display:inline-block;
	border:1px solid #CCCCCC;
	
}
#id{
	border:1px solid #CCCCCC
}
.a{
border:2px solid red

}
.b{border:1px solid #CCCCCC
}
</style>

</head>

<body>
<div class="d1">

	<div class="d2">
		
		<%
		User user = (User)session.getAttribute("user");
		if(user!=null){
		%>
		
		欢迎<%=user.getUname()%>登录,
		<%}else{ %>
		请登录<%}
		%>
		
	</div>
	<div><a href="gwc.jsp">进入购物车</a></div>
</div>
<div id="id">

</div>
</body>
</html>
<script src="jquery/jquery-1.8.0.min.js"></script>
<script>
$(document).ready(function(){

	$.getJSON("showShopping",null,function(result){
		var sho="";
		
		for(var i = 0; i < result.length; i++){
			alert(1);
			sho+='<div class="d3"><a href="j'+(i+1)+'.jsp?id='+result[i].id+'"><img  id="j'+(i+1)+'" src="'+result[i].url+'"/></a><div class="d5">'+result[i].pname+'</div><div class="d4">￥'+result[i].jiage+'</div></div>'
		
		}
		$("#id").append(sho);
	});
});
</script>
	
		

			
					

		