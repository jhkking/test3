<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import = "reviewBoard.model.vo.*,java.sql.*, java.util.*"%>
<% ReviewBoard board = (ReviewBoard)request.getAttribute("board");
	int currentPage = ((Integer)request.getAttribute("currentPage")).intValue();
 	ArrayList<ReviewComment> list2 = (ArrayList<ReviewComment>)request.getAttribute("list");  
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
a{
	
	text-decoration:none;
	color : #369;
}
</style>

</head>
<body>
<%@ include file="../../header.jsp"%>
<br><br>
	<h4 align="center"><%=board.getReviewWriter()%>님의 <%=board.getReviewNum()%>번 글 상세보기</h4>

	<br>
	<table class="type09" align="center" width="90%" cellspacing="0" border="1">
		<thead><tr>
			<th >제 목</th>
			<td><%=board.getReviewTitle()%></td>
		</tr></thead>
		<thead><tr>
			<th >작성자</th>
			<td><%=board.getReviewWriter()%></td>
		</tr></thead>
		<%
			if (board.getReviewLevel() == 0) {
		%>
		<thead><tr>
			<th >첨부파일</th>
			<td>
				<%
					if (board.getReviewOriginalFilename() != null) {
				%> <img src="bupfiles/<%= board.getReviewReFilename()%>"/>
 	<%} else {%> 
 	첨부파일 없음 
 <%}%>
			</td>
		</tr></thead>
		<%
			}
		%>
		<thead><tr>
			<th scope="cols" >내 용</th>
			<td><%=board.getReviewContent()%></td>
		</tr></thead>

		<tr>
			<th colspan="2" scope="cols">
				<%
					if (member.getSmemberId().equals(board.getReviewWriter())) {
				%> <a
				href="/semi/rbupdateview?bnum=<%=board.getReviewNum()%>&page=<%=currentPage%>">수정페이지로
					이동</a> &nbsp; <a href="/semi/rdelete?bnum=<%=board.getReviewNum()%>&page=<%=currentPage%>">글삭제</a>
				<%
					}
				%>
			</th>
		</tr>
	</table>
	<br>
<div id="replydiv" align="center">
<h4 style="text-align:left;margin-left:50px;">댓글 작성</h4>
<!--댓글 달기 칸  -->
<form action="/semi/rrinsert?bnum=<%=board.getReviewNum()%>&page=<%=currentPage%>" method="post">
	<table class="type09" align="center" width="90%" cellspacing="0" border="1">
	<tr><th>작성자</th>
			<td><input type="text" name="bwriter" readonly value="<%= member.getSmemberId() %>" style="border:none" ></td></tr>
	<tr><th>내용</th>
			<td><textarea rows="2" cols="80" name="bcontent"></textarea></td></tr>
	<tr><th id="c"colspan="2"><input type="submit" id ="replybt"value="댓글달기" width="200px" onclick="showR();"></th></tr>
	</table>
</form>
<br>
<h4 style="text-align:left;margin-left:50px;"><%=board.getReviewNum()%>번 글의 댓글 개수 [<%=request.getAttribute("replyCount")%>개]</h4>
 <!--댓글 보여주기  -->
<%if(list2 != null){
for(ReviewComment c : list2){	
%>
<form action="/semi/rrupdate">
<table class="type09" align="center" width="90%" cellspacing="0" border="1">
	<tr><th>작성자</th>
			<td><input type="text" name="bwriter" readonly value="<%= c.getCwriter()%>" style="border:none" ></td></tr>
	
	<tr><th>내용</th>
			<td>
			<%if(member.getSmemberId().equals(c.getCwriter())){ %>
			<input type ="text" name="bcontent"  value="<%= c.getCcontent()%>" size="70">
			<input type="hidden" name = "cno" value="<%=c.getCno()%>">
			<input type="hidden" name = "bnum" value="<%=c.getBno()%>">
			<input type="hidden" name = "page" value="<%=currentPage%>">
			<%}else {%>
			<input type ="text" name="content" readonly value="<%= c.getCcontent() %>" style="border:none" >
			<%} %></td></tr>
	<%if(member.getSmemberId().equals(c.getCwriter())){ %>
	<tr><td colspan="2"><a href="/semi/rrdelete?cno=<%=c.getCno()%>&bnum=<%=c.getBno()%>&page=<%=currentPage%>">댓글 삭제
	&nbsp;&nbsp;&nbsp;<input type="submit" value="댓글 수정"></td></tr>
	<%} %>
	</table>
	<%}} %> 
	</form>
</div>
<br>
<div align="center">
<a href = "/semi/rblist?page=<%=currentPage%>">목록으로 이동</a>
</div>
	<br>

<%@ include file="../../footer.jsp"%>
</body>
</html>