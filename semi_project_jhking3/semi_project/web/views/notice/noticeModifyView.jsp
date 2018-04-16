<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="notice.model.vo.Notice"%>
<%
	Notice notice = (Notice) request.getAttribute("notice");
int currentPage = ((Integer)request.getAttribute("currentPage")).intValue();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 수정 폼</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/1-col-portfolio.css" rel="stylesheet">
<style>
a {
	text-decoration: none;
}

table.type03 {
	border-collapse: collapse;
	text-align: left;
	line-height: 1.5;
	border-top: 1px solid #ccc;
	border-left: 3px solid #369;
	margin: 20px 10px;
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
<hr style="clear:both;">
<br><br>
<h1 align="center">공지 글 수정</h1>
<br>

<form action="/semi/nupdate" method="post" enctype="multipart/form-data" align="center">
<div align="center">
<table class="type03" align="center" width="700" cellspacing="0" border="1">
	<input type="hidden" name="num" value="<%=notice.getNoticeNum() %>">
	<input type="hidden" name="page" value="<%=currentPage%>">
	<tr>
		<th>제목</th>
		<td><input type="text" name="ntitle" value="<%=notice.getNoticeTitle() %>"></td>
	</tr>
	<tr>
		<th>작성자</th>
		<td><input type="text" name="nwriter" readonly value="<%=member.getSmemberId()%>"></td>
	</tr>
	<tr>
		<th>첨부파일</th>
		<td><input type="file" name="nupfile"><%if(notice.getNoticeOriginalFilename()!=null){ %>
		<%=notice.getNoticeOriginalFilename() %>
		<input type = "hidden" name="noldfile" value="<%=notice.getNoticeOriginalFilename() %>">
		<% } %>
		</td>
	</tr>
	<tr>
		<th>내용</th>
		<td><textarea rows="10" cols="50" name="ncontent"><%=notice.getNoticeContent() %></textarea></td>
	</tr>
	<tr>
		<th colspan="2"><input type="submit" value="수정하기"></th>
	</tr>

</table>
</div>
</form>
<br>
<div align="center">
	<a href="/semi/nlist?page=1">목록으로 이동</a>
</div>
<br>
<br>
<br>
<br>
<br>
<br>
<%@ include file="../../footer.jsp" %>
</body>
</html>