<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"
   import="workerBoard.model.vo.WbBoard,java.sql.*,member.model.vo.Member, java.util.*"%>
<% ArrayList<WbBoard> list = (ArrayList<WbBoard>)request.getAttribute("list"); 
   int listCount = ((Integer)request.getAttribute("listCount")).intValue();
   int currentPage = ((Integer)request.getAttribute("currentPage")).intValue();
   int startPage = ((Integer)request.getAttribute("startPage")).intValue();
   int endPage = ((Integer)request.getAttribute("endPage")).intValue();
   int maxPage = ((Integer)request.getAttribute("maxPage")).intValue();%>
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
button.bt {
   width: 150px;
   height: 40px;
   border: 1px dotted #369;
   border-radius: 20px;
   background-color: #f3f6f7;
   color: #369;
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
<script type="text/javascript">
   function showInsertForm() {
      location.href = "/semi/views/wbboard/wbInsertForm.jsp"
   }
</script>
</head>
<body>
   <%@ include file="../../header.jsp"%>
   <br>
   <h3 align="center">
      총 게시글 갯수 :
      <%= listCount %></h3>
   <Br>
   <% if(member != null){ %>
   <div align="center">
      <button class="bt" onclick="showInsertForm();">글쓰기</button>
   </div>

   <br>
   <table class="type09" align="center" cellspacing="0" width="80%">
      <thead>


         <tr>
            <th scope="cols">글 번호</th>
            <th scope="cols">글 제목</th>
            <th scope="cols">작성자</th>
            <th scope="cols">작성날짜</th>
            <th scope="cols">조회수</th>
            <th scope="cols">첨부파일 유무</th>
                     <% if(member.getSmemberId().equals("admin01")){ %>
            <th scope="cols">삭제</th>
            <%} %>

         </tr>
      </thead>
      <tbody>
         <%for(WbBoard r : list){ %>
         <tr>
            <th scope="row"><%if(r.getWblevel() > 0){ %>
            <%=r.getWbref()%>-<%=r.getWblevel()%>
            <%}else{ %>
            <%=r.getWbnumber()%>
            <%} %></th>
            <th>
               <%--댓글 들여쓰기 --%> <% if(r.getWblevel() == 1) { //원글의 댓글일때%>
               &nbsp;&nbsp;re <% }else if(r.getWblevel() == 2){ %>
               &nbsp;&nbsp;&nbsp;&nbsp;rere <%} %> <%if (member != null) {%> <a
               href="/semi/wbdetail?bnum=<%=r.getWbnumber()%>&page=<%=currentPage%>"><%=r.getWbtitle()%></a>
               <%} else {%> <%=r.getWbtitle()%> <%}%>
            </th>
            <th><%=r.getWbwriter() %></th>
            <th><%=r.getWbdate() %></th>
            <th><%=r.getWb_readcount() %></th>

            <th>
               <%
               if (r.getWboriginalfilename() != null) {
            %> ☆☆☆<%
               } else {
            %> χ<%
    }
 %>
             <% if(member.getSmemberId().equals("admin01")){ %>
            <th></a> &nbsp; <a
               href="/semi/wbdelete?bnum=<%=r.getWbnumber()%>&page=<%=currentPage%>">글삭제</a></th>
            <%} %>

            </th>
   
         
         <%
         }
      %>
         
      </tr>
      </tbody>
      
      
   </table>
   <% }else{ %>
   
   
   
   
   <table class="type09">
      <thead>


         <tr>
            <th scope="cols">글 번호</th>
            <th scope="cols">글 제목</th>
            <th scope="cols">작성자</th>
            <th scope="cols">작성날짜</th>
            <th scope="cols">조회수</th>
            <th scope="cols">첨부파일 유무</th>
         

         </tr>
      </thead>
      <tbody>
         <%for(WbBoard r : list){ %>
         <tr>
            <th scope="row"><%if(r.getWblevel() > 0){ %>
            <%=r.getWbref()%>-<%=r.getWblevel()%>
            <%}else{ %>
            <%=r.getWbnumber()%>
            <%} %></th>
            <th>
               <%--댓글 들여쓰기 --%> <% if(r.getWblevel() == 1) { //원글의 댓글일때%>
               &nbsp;&nbsp; re <% }else if(r.getWblevel() == 2){ %>
               &nbsp;&nbsp;&nbsp;&nbsp; rere <%} %> <%if (member != null) {%> <a
               href="/semi/qdetail?bnum=<%=r.getWbnumber()%>&page=<%=currentPage%>"><%=r.getWbtitle()%></a>
               <%} else {%> <%=r.getWbtitle()%> <%}%>
            </th>
            <th><%=r.getWbwriter() %></th>
            <th><%=r.getWbdate() %></th>
            <th><%=r.getWb_readcount() %></th>

            <th>
               <%
               if (r.getWboriginalfilename() != null) {
            %> ☆☆☆<%
               } else {
            %> χ<%
    }
 %>

            </th>
   
         
         <%
         }
      %>
      </tr>
      </tbody>
   </table>
         <%
         }
      %>
      
      <!-- 페이지 숫자 출력 -->
   <div align="center">
   <a href="/semi/wblist?page=1">[ 처음으로 ]</a>
      <%
         if (currentPage <= 1) {
      %>
      [ 이전 ]
      <%
         } else {
      %>
      <a href="/semi/wblist?page=<%=currentPage - 1%>">[ 이전 ]</a>
      <%} %>
      <%--페이지 숫자 연속 출력 --%>
      <% for(int p = startPage; p<= endPage; p++){ 
         if(p == currentPage){
         %><font color="red" size="4"><b><%=p %></b></font>&nbsp;
         <% } else{%>
            <a href="/semi/wblist?page=<%=p %>"><%=p %></a>&nbsp;
      <% } }%>
      <% if(currentPage >= maxPage){ %>
      [ 다음 ]
      <% } else{%>
         <a href="/semi/wblist?page=<%= currentPage + 1%>">[ 다음 ]</a>
      <% } %>
      <a href="/semi/wblist?page=<%=maxPage%>">[ 맨끝으로 ]</a>
   </div><br><br><br><br><br><br>
   <%@include file="../../footer.jsp"%>
</body>
</html>