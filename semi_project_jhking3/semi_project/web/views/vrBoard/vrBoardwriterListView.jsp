<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="vrBoard.model.vo.vrBoard,java.util.*" %>
<%
ArrayList<vrBoard> list = (ArrayList<vrBoard>)request.getAttribute("list");
int listCount=((Integer)request.getAttribute("listCount")).intValue();
int currentPage = ((Integer)request.getAttribute("currentPage")).intValue();
int startPage=((Integer)request.getAttribute("startPage")).intValue();
int endPage = ((Integer)request.getAttribute("endPage")).intValue();
int maxPage = ((Integer)request.getAttribute("maxPage")).intValue();

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 리스트</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/1-col-portfolio.css" rel="stylesheet">
<link rel="stylesheet" href="css/bootstrap.css">
<script src="js/jquery-3.1.1.js"></script>

<script type="text/javascript">
<!-- 글쓰기 폼으로 이동하는 함수 -->
   function showInsertForm(){
      location.href="/semi/views/notice/noticeInsertForm.jsp";
   }
</script>

<style>
 a.bt{
   width:260px;
   height:100px;
   border:1px solid #369;
   border-radius:20px;
   background-color:#f3f6f7;
   color:#369;
   text-decoration:none;
}
table.type09 {
   border-collapse: collapse;
   text-align: center;
   line-height: 1.5;
   width:80%;
}

table.type09 #tr1 {
   padding: 10px;
   font-weight: bold;
   vertical-align: top;
   color: #369;
   border-bottom: 3px solid #036;
}

table.type09 tbody th {
   width :150px;
   padding: 5px;
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

button.bt {
   width: 150px;
   height: 40px;
   border: 1px dotted #369;
   border-radius: 20px;
   background-color: #f3f6f7;
   color: #369;
}

</style>

</head>
<body>
<%@ include file="../../header.jsp" %>
<br>
<br>



<div>

<h3 align="center">Board List</h3>




<br>
<table class="type09" align="center" cellspacing="0" width="80%">
      <tr id="tr1">
      <th scope="cols">글 번호</th>
      <th scope="cols" class="wid">글 제목</th>
      <th scope="cols">작성자</th>
      <th scope="cols">작성 날짜</th>
      
      <th scope="cols">첨부파일</th>
      </tr>
   <tbody  cellspacing="0" width="700">
   
   <%--  &prevPage=<%= list.get(i-1).getNoticeNum()%>&nextPage=<%= list.get(i+1).getNoticeNum()%>  --%>
   <%for(int i = 0; i < list.size(); i++) { %>
      <tr>
      <td scope="row"><%=list.get(i).getVrboardnum()%></td>
      <td class="wid" width="100"><a href="/semi/vrdetail?num=<%=list.get(i).getVrboardnum()%>&page=<%=currentPage%>">
      <%=list.get(i).getVrboardtitle() %></a>
      </td>
      <td><%=list.get(i).getVrboardwriter() %></td>
      <td><%=list.get(i).getVrboarddate() %></td>
      <td><% if(list.get(i).getVrboardoriginalfilename()!=null) {
      %> ★ <% 
       }else{
       %>χ<%
        }
       %>
      </td>
   
   </tr>
      <% } %>
   </tbody>
</table>
<br>

<div align="center">
<a href="/semi/vrworkerlist?page=1">[처음으로]</a>
<% if(currentPage<=1){ %>
[이전]
<%}else{ %>
<a href="/semi/vrworkerlist?page=<%=currentPage -1 %>">[이전]</a>
<% } %>
<%--페이지 숫자 연속 출력 --%>
<% for(int p = startPage;p<= endPage;p++){
   if(p==currentPage){
   %>
<font color="red" size="4"><b>[<%= p %>]</b></font> &nbsp;
<%      }else{ %>
<a href="/semi/vrworkerlist?page=<%= p %>"><%= p %></a> &nbsp;   
<% }} %>

<% if(currentPage >= maxPage){ %>
[다음]
<% }else{ %>
<a href="/semi/vrworkerlist?page=<%= currentPage + 1 %>">[다음]</a>
<% } %>
<a href="/semi/vrworkerlist?page=<%= maxPage %>">[맨끝으로]</a>
</div>

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