<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 글쓰기</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/1-col-portfolio.css" rel="stylesheet">
<style>
a{
	text-decoration:none;
}
table.type03 {
    border-collapse: collapse;
    text-align: left;
    line-height: 1.5;
    border-top: 1px solid #ccc;
    border-left: 3px solid #369;
    margin : 20px 10px;
}
table.type03 th {
    width: 147px;
    padding: 10px;
    font-weight: bold;
    vertical-align: top;
    color: #153d73;
    border-right: 1px solid #ccc;
    border-bottom: 1px solid #ccc;

}
table.type03 td {
    width: 349px;
    padding: 10px;
    vertical-align: top;
    border-right: 1px solid #ccc;
    border-bottom: 1px solid #ccc;
}
</style>


</head>


<body>

<%@ include file="../../header.jsp"%>
<br>
<h3 align="center">공지 작성</h3>
<hr style="clear:both;"><br>

<form action="/semi/ninsert" method="post" enctype="multipart/form-data" align="center">
<div align="center">
<table class="type03" align="center" width="700" cellspacing="0" border="1">
	<tr>
		<th>제목</th>
		<td><input type="text" name="ntitle"></td>
	</tr>
	<tr>
		<th>작성자</th>
		<td><input type="text" name="nwriter" readonly value="<%=member.getSmemberId()%>"></td>
	</tr>
	<tr>
		<th>첨부파일</th>
		<td><input type="file" name="nupfile"></td>
	</tr>
	<tr>
		<th>내용</th>
		<td><textarea rows="10" cols="50" name="ncontent"></textarea></td>
	</tr>
	<tr>
		<th colspan="2"><input type="submit" value="등록하기"></th>
	</tr>

</table>
</div>
</form>
<br>
<br>

<%@ include file="../../footer.jsp" %>
</body>
</html>