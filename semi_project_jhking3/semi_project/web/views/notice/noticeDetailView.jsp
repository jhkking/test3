<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page import="notice.model.vo.Notice,java.sql.*,java.util.*" %>
<%
	Notice notice = (Notice)request.getAttribute("notice");
	int currentPage = ((Integer)request.getAttribute("currentPage")).intValue();
	Notice pnotice=(Notice)request.getAttribute("pnotice");
	Notice nnotice=(Notice)request.getAttribute("nnotice");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 상세보기</title>
 <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
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
#tab2{
	line-height: 0.5;
}

</style>
</head>
<body>
<%@ include file="../../header.jsp"%>
<hr style="clear:both;">
<br><br><br>

<h3 align="center"><%=notice.getNoticeWriter()%>님의  글 상세보기</h3>
<br>
<% if(member!=null){ %>

<div align="center">
<table class="type03" align="center" width="700" cellspacing="0" border="1">
<tr>
<th scope="cols">제 목</th>
<td><%=notice.getNoticeTitle() %></td>
</tr>

<tr>
<th scope="cols">작성자</th>
<td><%=notice.getNoticeWriter() %></td>
</tr>

<tr>
<th scope="cols">첨부파일</th>
<td>
<% if(notice.getNoticeOriginalFilename()!=null){
	%><a href="/semi/nfdown?ofname=<%=notice.getNoticeOriginalFilename() %>&rfname=<%=notice.getNoticeRenameFilename() %>">
	<%=notice.getNoticeOriginalFilename() %></a>
<%}else{%>
	첨부파일 없음
	<% } %> 
</td>
</tr>
<tr>
	<th scope="cols">내 용</th>
	<td><%=notice.getNoticeContent()%></td>
</tr>
	<% if(member.getSmemberId().equals("admin01")) {%>
<tr>
	<th colspan="2" scope="cols">
	<a href ="/semi/nupdateView?num=<%=notice.getNoticeNum()%>&page=<%=currentPage%>">수정하기</a>&nbsp;
	<a href="/semi/ndelete?num=<%=notice.getNoticeNum() %>">글 삭제</a>
	</th>
</tr>
<% } %>
</table>

<table class="type03" id="tab2" align="center" width="700" cellspacing="0" border="1">	
	<%if(nnotice!=null){ %>	
	<tr>
	<th style="font-size:9pt;">다음 글</th>
	<td style="font-size:9pt;"><a href="/semi/ndetail?num=<%=nnotice.getNoticeNum()%>&page=<%= currentPage%>">
	<%=nnotice.getNoticeTitle() %></a></td>
	</tr>
	<%}else{ %>
	<tr>
	<th style="font-size:9pt;">다음 글</th>
	<td style="font-size:9pt;">다음 글이 없습니다.</td>
	</tr>

	<%} %>
	<%if(pnotice!=null){ %>
	<tr>
	<th style="font-size:9pt;">이전 글</th>
	<td style="font-size:9pt;">	
	<a href="/semi/ndetail?num=<%=pnotice.getNoticeNum()%>&page=<%=currentPage%>">
		<%=pnotice.getNoticeTitle() %></a></td>
	</tr>
	<%}else{ %>
	<tr>
	<th style="font-size:9pt;">이전 글</th>
	<td style="font-size:9pt;">이전 글이 없습니다.</td>
	</tr>
	<% } %>
</table>

<br>

</div>
<% }else{ %>

<div align="center">
<table class="type03" align="center" width="700" cellspacing="0" border="1">
<tr>
<th scope="cols">제 목</th>
<td><%=notice.getNoticeTitle() %></td>
</tr>

<tr>
<th scope="cols">작성자</th>
<td><%=notice.getNoticeWriter() %></td>
</tr>

<tr>
<th scope="cols">첨부파일</th>
<td>
<% if(notice.getNoticeOriginalFilename()!=null){
	%><a href="/semi/nfdown?ofname=<%=notice.getNoticeOriginalFilename() %>&rfname=<%=notice.getNoticeRenameFilename() %>">
	<%=notice.getNoticeOriginalFilename() %></a>
<%}else{%>
	첨부파일 없음
	<% } %> 
</td>
</tr>
<tr>
	<th scope="cols">내 용</th>
	<td><%=notice.getNoticeContent()%></td>
</tr>
</table>


<table class="type03" id="tab2" align="center" width="700" cellspacing="0" border="1">
	
	<%if(nnotice!=null){ %>	
	<tr>
	<th style="font-size:9pt;">다음 글</th>
	<td style="font-size:9pt;"><a href="/semi/ndetail?num=<%=nnotice.getNoticeNum()%>&page=<%= currentPage%>">
	<%=nnotice.getNoticeTitle() %></a></td>
	</tr>
	<%}else{ %>
	<tr>
	<th style="font-size:9pt;">다음 글</th>
	<td style="font-size:9pt;">다음 글이 없습니다.</td>
	</tr>
	<%} %>
	
	<%if(pnotice!=null){ %>
	<tr>
	<th style="font-size:9pt;">이전 글</th>
	<td style="font-size:9pt;">	
	<a href="/semi/ndetail?num=<%=pnotice.getNoticeNum()%>&page=<%=currentPage%>">
		<%=pnotice.getNoticeTitle() %></a></td>
	</tr>
	<%}else{ %>
	<tr>
	<th style="font-size:9pt;">이전 글</th>
	<td style="font-size:9pt;">이전 글이 없습니다.</td>
	</tr>
	<% } %>
	

	
</table>


</div>

<% } %>






<br>
<div align="center">
<a href = "/semi/nlist?page=<%=currentPage%>">목록으로 이동</a>
</div>
	<br>
	<script src="jqueryintro/bootstrap.bundle.min.js"></script>


<%@ include file="../../footer.jsp"%>
</body>
</html>