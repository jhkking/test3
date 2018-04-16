<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
       <%@ page import ="member.model.vo.Member, java.util.*" %>
    <%
    ArrayList<Member>list =(ArrayList<Member>)request.getAttribute("list");
    int listCount = ((Integer)request.getAttribute("listCount")).intValue();
   int currentPage = ((Integer)request.getAttribute("currentPage")).intValue();
   int startPage = ((Integer)request.getAttribute("startPage")).intValue();
   int endPage = ((Integer)request.getAttribute("endPage")).intValue();
   int maxPage = ((Integer)request.getAttribute("maxPage")).intValue();
    %>

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
/* footer{
   position:absolute;

    bottom:0;

    width:100%;

    height:70px;   

    background:#ccc;
    } */
table.type09 {
   border-collapse: collapse;
   text-align: left;
   line-height: 1.5;
   font-size:20px;
}

table.type09 thead tr {
   padding: 10px;
   font-weight: bold;
   vertical-align: top;
   color: #369;
   border-bottom: 3px solid #036;

}

table.type09 tbody tr {
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

 div.search {
   width: 80%;
   display: none;
} 
/* footer{
   position:absolute;

    bottom:0;

    width:100%;

    height:70px;   

    background:#ccc;
    } */
    div.roww{
       flex-wrap: wrap;
       width : 100%;
       align : center;
    }
    div.containerr{
       width : 100%;
       align : center;
    }
</style>

<script type="text/javascript">
   function showDiv() {
      var items = document.getElementsByName("item");
      var sidDiv = document.getElementById("sid");
      var sgenderDiv = document.getElementById("sgender");

      if (items[0].checked == true) {
         sidDiv.style.display = "block";
         sgenderDiv.style.display = "none";

      }
      if (items[1].checked == true) {
         sidDiv.style.display = "none";
         sgenderDiv.style.display = "block";

      }

   }
</script>
</head>

<body>
   <%@ include file="../../header.jsp"%>
   <!--  여기서부터-->
<div class = "center-block">
<div class = "roww">
<div align = "center">
   <h1>관리자 회원관리 페이지</h1>
   <font size = "5px"><a href="/semi/mlist?page=1"><전체목록보기></a></font>
   <br><br>
   <font size = "5px">검색할 항목 선택:

   <br>
   <input type="radio" name="item" value="sid" onchange="showDiv();">아이디
   <input type="radio" name="item" value="sgender" onchange="showDiv();">성별</font>
   <br>
   <br>
   
   <div class = "search" id="sid">
      <form action="/semi/msid?page=1" method="post">
         검색할 사용자 아이디 입력: <input type="search" name="idkeyword"> <input
            type="submit" value="검색">
      </form>
   </div>
   <div class = "search" id="sgender">
      <form action="/semi/msgender?page=1" method="post">
         검색할 성별 선택: <input type="radio" name="gdkeyword" value="남">남
         &nbsp; <input type="radio" name="gdkeyword" value="여">여 <input
            type="submit" value="검색">
      </form>
   </div>
   
   <table class="type09" align = "center">
      <thead>
         <tr>
            <td>아이디</td>
            <td>힌트</td>
            <td>힌트답</td>
            <td>이름</td>
            <td>주번</td>
            <td>주소</td>
            <td>성별</td>
            <td>폰</td>
            <td>이메일</td>
            <td>관리자(y)</td>
            <td>사업자(y)</td>
            <td>날짜</td>
            <th>삭제</th>
         </tr>
      </thead>
      <%
         for (Member m : list) {
      %>
      <tbody>
         <tr>
            <td><%=m.getSmemberId()%></td>
            <td><%=m.getSmemberPwdHint()%></td>
            <td><%=m.getSmemberPwdAns()%></td>
            <td><%=m.getSmemberName()%></td>
            <td><%=m.getSmemberIdNumber()%></td>
            <td><%=m.getSmemberAddress()%></td>
            <td><%=m.getSmemberGender()%></td>
            <td><%=m.getSmemberPhone()%></td>
            <td><%=m.getSmemberEmail()%></td>
            <td><%=m.getSmemberAdminYN()%></td>
            <td><%=m.getSmemberWorkerYN()%></td>
            <td><%=m.getSmemberDate()%></td>
            <td><a href="/semi/madelete?userid=<%=m.getSmemberId()%>">삭제</a></td>

         </tr>
         <%
            }
         %>
      </tbody>
   </table>
   </div>
<br><br>
   <!-- 페이지 숫자 출력 -->
   <div id = "pgae" align="center">
   <font size = "5px">
      <a href="/semi/mlist?page=1">[ 처음으로 ]</a>
      <%
         if (currentPage <= 1) {
      %>
      [ 이전 ]
      <%
         } else {
      %>
      <a href="/semi/mlist?page=<%=currentPage - 1%>">[ 이전 ]</a>
      <%
         }
      %>
      <%--페이지 숫자 연속 출력 --%>
      <%
         for (int p = startPage; p <= endPage; p++) {
            if (p == currentPage) {
      %><font color="red" size="4"><b><%=p%></b></font>&nbsp;
      <%
         } else {
      %>
      <a href="/semi/mlist?page=<%=p%>"><%=p%></a>&nbsp;
      <%
         }
         }
      %>
      <%
         if (currentPage >= maxPage) {
      %>
      [ 다음 ]
      <%
         } else {
      %>
      <a href="/semi/mlist?page=<%=currentPage + 1%>">[ 다음 ]</a>
      <%
         }
      %>
      <a href="/semi/mlist?page=<%=maxPage%>">[ 맨끝으로 ]</a>
      </font>
    </div> 
   <br>
   <br>
   <br>
   <br>
   <br>
   <br>
   </div>
</div>
   <%@include file="../../footer.jsp"%> 
</body>
</html>