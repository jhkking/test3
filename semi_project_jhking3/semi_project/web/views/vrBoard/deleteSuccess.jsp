<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% 
	int boardnum = ((Integer)request.getAttribute("boardnum")).intValue();
%>
<!DOCTYPE html>

<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>delete</title>
<style>
table.type09 {
	border-collapse: collapse;
	text-align: left;
	line-height: 1.5;
}

table.type09 thead th {
	padding: 10px;
	font-weight: bold;
	vertical-align: top;
	color: #369;
	border-bottom: 3px solid #036;
}

table.type09 tbody th {
	width: 150px;
	padding: 10px;
	font-weight: bold;
	vertical-align: top;
	border-bottom: 1px solid #ccc;
	background: #f3f6f7;
}

table.type09 td {
	width: 350px;
	padding: 10px;
	vertical-align: top;
	border-bottom: 1px solid #ccc;
}

button#btn11 {
	border: 1px solid skyblue;
	color: white;
	text-align: center;
	background: #007bff;
	border-radius: 12px;
}
</style>
<!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="css/1-col-portfolio.css" rel="stylesheet">
<link href="cssintro/modern-business.css" rel="stylesheet">
</head>

<body>
	<form action="/semi/minsert" method="post">
		<!-- Navigation -->
		<%@ include file="../../header.jsp"%>
		<br><br><br>
<div align = "center">

<h3><게시물 삭제></h3>
<br><br>
<img src = "/semi/images/delete.png" width = "220px" height = "220px">
<br><br>
		<h1><%=boardnum %>번 글 삭제 완료!</h1>
		<!-- Footer -->
</div>
<br><br><br>
		<%@ include file="../../footer.jsp"%>

		<!-- Bootstrap core JavaScript -->

	</form>
</body>

</html>