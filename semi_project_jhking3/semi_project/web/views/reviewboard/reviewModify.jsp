<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="reviewBoard.model.vo.ReviewBoard"%>
    <%
    	ReviewBoard board = (ReviewBoard)request.getAttribute("board");
   	 int currentPage = ((Integer) request.getAttribute("page")).intValue();
    %>
<!DOCTYPE html>
<html>
<head>
<meta  charset="UTF-8">
<title>reviewModify</title>
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
<br>
<h3 align="center">리뷰 수정</h3>
<%@ include file="../../header.jsp" %>
<hr style="clear:both;">
<br>
<!--그냥 전송했을 때는 request로 받지만 multipart로 전송시에는 multipart로 받음  -->
<% if(board.getReviewLevel() >0){ %>
<form action="/semi/rbreplyup" method="post" >
   <table  class="type09" align="center" width="600" border="1">
   
   <input type="hidden" name="bnum" value="<%=board.getReviewNum() %>">
   <input type="hidden" name="page" value="<%=currentPage%>">
   
  <thead><tr><th scope="cols">번호</th><th scope="cols"><%=board.getReviewNum()%></th></tr></thead>
  <tbody> <tr><th>제목</th>
         <td><input type="text" name="btitle"  value="<%=board.getReviewTitle() %>"></td></tr>
   <tr><th>작성자</th>         <td><input type="text" name="bwriter" readonly value="<%=board.getReviewWriter() %>"></td></tr>
   <tr><th>첨부파일</th>
         <td><input type="file" name="bupfile">
         <% if(board.getReviewOriginalFilename() != null){ %>
            <%=board.getReviewOriginalFilename()%>
            <input type="hidden" name="boldfile" value="<%=board.getReviewOriginalFilename()%>">
         <%} %>
         </td></tr>
   <tr><th>내용</th>
         <td><textarea rows="5" cols="50" name="bcontent"  ><%=board.getReviewContent()%></textarea></td></tr>
  <tr><th colspan="2"><input type="submit" value=" 수정하기 "></th></tr>
   </table>
</form>
<%}else{ %>
<form action="/semi/rbupdate" method="post"  enctype="multipart/form-data">
   <table  class="type09" align="center" width="600" cellspacing="0" border="1">
   
      <input type="hidden" name="bnum" value="<%=board.getReviewNum() %>">
   <input type="hidden" name="page" value="<%=currentPage%>">
   
   <tr><th>번호</th><th><%=board.getReviewNum()%></th></tr>
   <tr><th>제목</th>
         <td><input type="text" name="btitle"  value="<%=board.getReviewTitle() %>"></td></tr>
   <tr><th>작성자</th>         <td><input type="text" name="bwriter" readonly value="<%=board.getReviewWriter() %>"></td></tr>
   <tr><th>첨부파일</th>
         <td><input type="file" name="bupfile">
         <% if(board.getReviewOriginalFilename() != null){ %>
            <%=board.getReviewOriginalFilename()%>
            <input type="hidden" name="boldfile" value="<%=board.getReviewReFilename()%>">
         <%} %>
         </td></tr>
   <tr><th>내용</th>
         <td><textarea rows="5" cols="50" name="bcontent"  ><%=board.getReviewContent()%></textarea></td></tr>
   <tr><th colspan="2"><input type="submit" value=" 수정하기 "></th></tr></tbody>
   </table>
</form>
<%} %>
<br>
<div align="center">
   <a href="/semi/rblist?page=1">목록으로 이동</a>
</div>


<%@ include file="../../footer.jsp" %>
</body>
</html>