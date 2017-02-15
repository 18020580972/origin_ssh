<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	div.d1{
		border:border:0px solid #FFFFFF;
		width:100%;
		height:662px;
		background-image:url(imger/j3.png);
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
<input style="display:none" name="sname" value="oppoR9s">
<input style="display:none" name="jiage" value="3499.00">
<div class="d3"><input class="i1" type="submit" value="" ></div>
<div class="d3"><input class="i2" type="submit" value=""></div>
</form>

</div>
</body>
</html>