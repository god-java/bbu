<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
html,body,div,ul,li,a,span{margin:0; padding:0; outline:0; text-align:center; font-size:12px;}
a{text-decoration:none; color:silver;}
#header{width:100%; height:50px; border-bottom:1px solid black; position:fixed; top:0; left:0;}
#header ul{width:100%; height:50px; line-height:50px;}
#header li{width:10%; height:30px;}
#top{width:100%; height:200px; text-align:center; line-height:200px; position:relative; margin-top:50px; border-bottom:1px solid #D8D8D8;}
#top span{font-size:50px; font-weight:bolder;}
#center{width:100%;}
</style>
</head>
<body>
	<div id="header">
		<ul>
			<li><a href="code_register">코드등록</a></li>
		</ul>
	</div>
	<div id="top">
		<span>JUBU물품관리 시스템</span>
	</div>
	<div id="center">
		<jsp:include page="${center }"/>
	</div>
	<div id="footer">
	
	</div>
</body>
</html>