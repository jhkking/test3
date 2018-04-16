<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import = "vrBoard.model.vo.*,java.sql.*, java.util.*"%>
<% vrBoard board = (vrBoard)request.getAttribute("board");
	VrBoardDetail detail = (VrBoardDetail)request.getAttribute("detail");
	int currentPage = ((Integer)request.getAttribute("page")).intValue();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>reviewDetail</title>
    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/1-col-portfolio.css" rel="stylesheet">
<style>
h6,h4{
color: #036;
}
a{
	text-decoration:none;
	color : #369;
}

table.type09 {
	border-collapse: collapse;
	line-height: 1.5;
}

table.type09 thead th {
	padding: 10px;
	font-weight: bold;
	vertical-align: top;
	color: #369;
	border-bottom: 3px solid #036;
}

table.type09 th {
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
	<h4 align="center">admin01 님의 <%=board.getVrboardnum()%>번 글 상세보기</h4>

	<br>
	<table class="type09" align="center"cellspacing="0" border="1">
		<thead><tr>
			<th >제 목</th>
			<td><%=board.getVrboardtitle()%></td>
		</tr></thead>
		<thead><tr>
			<th >작성자</th>
			<td>admin01</td>
		</tr><tr>
			<th >첨부파일</th>
			<td>
				<%
					if (board.getVrboardoriginalfilename() != null) {
				%> <%= board.getVrboardoriginalfilename()%>
 	<%} else {%> 
 	첨부파일 없음 
 <%}%>
			</td>
		</tr>
		<tr>
			<th>주소</th>
			<td><%=detail.getVrdetailaddress() %></td>
		</tr>
		<tr>
			<th>영업시간</th>
			<td><%=detail.getVropentime() %></td>
		</tr>
		<tr>
			<th>전화번호</th>
			<td><%=detail.getVrphone()%></td>
		</tr>
		<tr>
			<th>홈페이지주소</th>
			<td><%=detail.getVrhomepage() %></td>
		</tr>
		</thead>
	
		<thead><tr>
			<th scope="cols" >내 용</th>
			<td><%=board.getVrboardcontent()%></td>
		</tr></thead>
	</table>
	
<div id="replydiv" align="center">



	
</div>
<br>
<div align="center">
<a href = "/semi/vrworkerlist?page=<%= currentPage%>"><button class="btn btn-primary">목록으로 이동</button></a>
<a href = "/semi/vrmodify?boardnum=<%=board.getVrboardnum()%>"><button class="btn btn-primary">수정 페이지로 이동</button></a>
<a href = "/semi/vrdelete?boardnum=<%=board.getVrboardnum()%>"><button class="btn btn-primary" >삭제하기</button></a>
</div>
<br>

<%@ include file="../../footer.jsp"%>
</body>
</html>