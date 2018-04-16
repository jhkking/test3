<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>reviewListView</title>

     <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/1-col-portfolio.css" rel="stylesheet">
    
<style>
button.bt{
	width:150px;
	height:40px;
	border:1px dotted #369;
	border-radius:20px;
	background-color:#f3f6f7;
	color:#369;
}
table.type09 {
	border-collapse: collapse;
	text-align: left;
	line-height: 1.5;
	width:100%;
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

</style>

</head>
<body>
<%@ include file="../../header.jsp"%>
<br>
<h2 align="center">리뷰 작성</h2>
<hr style="clear:both;"><br>
<!--그냥 전송했을 때는 request로 받지만 multipart로 전송시에는 multipart로 받음  -->
<form action="/semi/qinsert" method="post"  enctype="multipart/form-data">
	<table class="type09" align="center" width="600" cellspacing="0" border="1">
	<tr><th>제목</th>
			<td><input type="text" name="btitle"></td></tr>
	<tr><th>작성자</th>
			<td><input type="text" name="bwriter" readonly value="<%= member.getSmemberId() %>"></td></tr>
	<tr><th>첨부파일</th>
			<td><input type="file" name="bupfile"></td></tr>
	<tr><th>내용</th>
			<td><textarea rows="5" cols="50" name="bcontent"></textarea></td></tr>
	<tr><th id="c"colspan="2"><input type="submit" value=" 등록하기 " width="200px"></th></tr>
	</table>
</form>
<br>
<%@include file="../../footer.jsp" %>
</body>
</html>