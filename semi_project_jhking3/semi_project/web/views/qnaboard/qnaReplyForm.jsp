<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
   int boardNum = Integer.parseInt(request.getParameter("bnum"));
   int currentPage = Integer.parseInt(request.getParameter("page"));
%>
<!DOCTYPE html>
<html>
<head>
<meta  charset="UTF-8">
<title>QnaModify</title>
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
a{
   text-decoration:none;
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
<%@ include file="../../header.jsp" %>
<hr style="clear:both;">
<h1 align="center"><%= boardNum %>번 글의 댓글달기</h1>
<br>
<form action="/semi/qreply" method="post">
<input type="hidden" name ="bnum" value ="<%= boardNum %>">
<input type="hidden" name ="page" value="<%=currentPage %>">
<table align="center" width="500" border="1" cellspacing="0">
<tr><th>제목</th><td><input name="btitle"></td></tr>
<tr><th>작성자</th><td>
<input readonly name="bwriter" value="<%= member.getSmemberId()%>"></td></tr>
<tr><th>내용</th>
<td><textarea rows="5"colse="50" name="bcontent"></textarea></td></tr>
<tr><th colspan="2"><input type ="submit" value="댓글등록"></th></tr>
</table>
</form>
<div align="center">
<a href="javascript:history.go(-1);">이전페이지로이동</a>
</div>


<%@include file="../../footer.jsp" %>
</body>
</html>