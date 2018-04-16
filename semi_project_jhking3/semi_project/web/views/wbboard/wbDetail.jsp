<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="workerBoard.model.vo.WbBoard,java.sql.*,member.model.vo.Member, java.util.*"%>
<% WbBoard board = (WbBoard)request.getAttribute("board");
	int currentPage = ((Integer)request.getAttribute("currentPage")).intValue();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/1-col-portfolio.css" rel="stylesheet">
<style>
a{
	text-decoration:none;
}
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
</style>
</head>
<body>
<%@ include file="../../header.jsp"%>
<br><br>
	<h3 align="center"><%=board.getWbwriter()%>님의 <%=board.getWbnumber()%>번 글 상세보기</h3>

	<br>
	<table class="type09" align="center" width="900" cellspacing="0" border="1">
		<tr>
			<th scope="cols">제 목</th>
			<td><%=board.getWbtitle()%></td>
		</tr>
		<tr>
			<th scope="cols">작성자</th>
			<td><%=board.getWbwriter()%></td>
		</tr>
		<%
			if (board.getWblevel() == 0) {
		%>
		<tr>
			<th scope="cols">첨부파일</th>
			<td>
				<%
					if (board.getWboriginalfilename() != null) {
				%> <a
				href="/semi/wbfdown?ofname=<%=board.getWboriginalfilename()%>&rfname=<%=board.getRename()%>">
					<%=board.getWboriginalfilename()%></a> 
 	<%} else {%> 
 	첨부파일 없음 
 <%}%>
			</td>
		</tr>
		<%
			}
		%>
		<tr>
			<th scope="cols" >내 용</th>
			<td><%=board.getWbcontent()%></td>
		</tr>
		<%
			if (board.getWblevel() < 2) {
		%>
		<tr>
			<td colspan="2" align="center">
			<a href="/semi/views/wbboard/wbReplyForm.jsp?bnum=<%=board.getWbnumber()%>&page=<%=currentPage%>">[댓글달기]</a></td>
		</tr>
		<%
			}
		%>
		<tr>
			<th colspan="2" scope="cols">
				<%
					if (member.getSmemberId().equals(board.getWbwriter())) {
				%> <a
				href="/semi/wbupdate?bnum=<%=board.getWbnumber()%>&page=<%=currentPage%>">수정페이지로
					이동</a> &nbsp; <a href="/semi/wbdelete?bnum=<%=board.getWbnumber()%>&page=<%=currentPage%>">글삭제</a>
				<%
					}
				%>
			</th>
		</tr>
	</table>
<div align="center">
<a href = "/semi/wblist?page=<%=currentPage%>">목록으로 이동</a>
</div>
	<br>
<%@ include file="../../footer.jsp"%>
</body>
</html>