<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="bootstrap-3.3.7/css/bootstrap.css" />
<style>
#contentt {
   /* background-image: url('img/bimg3.png'); */
   background-size: 100% 100%;
   margin-left: 200px;
   width: 80%;
}

th {
   color: black;
   text-align: center;
}

td {
   color: #585858;
}

option {
   background-color: #424242;
}


a {
   color: #000;
}
</style>
<meta charset=UTF-8">
<title>마음의 편지</title>
</head>
<body>

   <c:import url="../../../header.jsp"></c:import>
   <br>
   <br>
   <br>
   <br>
   <br>
   <br>
   <br>
  
   <div id="menu-wrap" class="menu-back cbp-af-header"
      style="position: fixed; top: 150px; width: 190px;">
      <div class="sixteen columns">   
      <c:if test="${loginUser.member_id eq 'admin' }">
         <ul class="slimmenu">
            <!-- <li><a href="#">Review</a>
                  <ul class="submenu-back">
                     <li><a href="contact.html" class="animsition-link">Review</a>
                     </li>
                     <li><a href="contact1.html" class="animsition-link">Feedback</a>
                     </li>
                  </ul></li> -->
            <li><a href="admin.do?currentPage=1" class="animsition-link"
               style="background: url(/finalPro/images/line.png) 0 14px no-repeat; background-size: 15px 10px; padding-left: 27px;">All
                  Users</a></li>
            <br>
            <li><a href="blacklist.do?currentPage=1" class="animsition-link">Black
                  List</a></li>
            <br>
            <li><a href="letterlist.do?currentPage=1"" class="animsition-link">Heart Letter</a></li>
         </ul>
         </c:if>
      </div>
   </div>
      <br>
      <h3>마음의 편지함</h3>
      <br>
   <div id="contentt">
      <p>총 ${listCount }개의 신고 접수</p>
      <table class="table table-hover" border="1" width="100%"
         style="text-align: center;">
            <tr>
               <th>글 번호</th>
               <th>접수자</th>
               <th>신고 대상자</th>
               <th>제목</th>
               <th>날짜</th>
            </tr>

            <c:forEach items="${letterList }" var="row">
               <tr>
                  <td>${row.b_no }</td>
                  <td>${row.white_id }</td>
                  <td>${row.black_id }</td>
                  <td>
                     <a href="letterDetail.do?currentPage=${currentPage }&b_no=${row.b_no}">${row.b_title }</a>
                  </td>
                  <td>${row.b_date }</td>
               </tr>
            </c:forEach>
      </table>
      <!-- 페이지 번호 처리 -->
      <div style="text-align: center;">

         <c:if test="${currentPage eq 1 }">
            [맨처음]
         </c:if>
         <c:if test="${currentPage > 1 }">
            <c:url var="first" value="letterlist.do">
               <c:param name="currentPage" value="1" />
            </c:url>
            <a href="${first }">[맨처음]</a>
            
            <c:url var="prev" value="letterlist.do">
               <c:param name="currentPage" value="${currentPage = 1}" />
            </c:url>
         </c:if>
         <c:if test="${param.currentPage eq 1 }">
            [이전]
         </c:if>
         <c:if test="${param.currentPage ne 1 }">
            <a href="${prev }"> [이전]</a>   
            <c:url var="prev" value="letterlist.do">
               <c:param name="currentPage"  value="${currentPage - 1}" />
            </c:url>
            
         </c:if>
         
         <c:forEach var="p" begin="${startPage }" end="${endPage }" step="1">
         <c:url var="page" value="letterlist.do">
            <c:param name="currentPage" value="${p }" />
         </c:url>
            <c:if test="${p ne param.currentPage }">
               <a href="${page }">${p }&nbsp; </a>
            </c:if>

            <c:if test="${p eq param.currentPage }">
               <font color="red" size="2"><b>${p }</b></font>&nbsp;
            </c:if>
         </c:forEach>

         <c:if test="${param.currentPage eq maxPage}">
            [다음]
         </c:if>
         <c:if test="${param.currentPage != maxPage }">
            <c:url var="next" value="letterlist.do">
               <c:param name="currentPage" value="${currentPage + 1 }" />
            </c:url>
            <a href="${next }"> [다음]</a>
         </c:if>

         <c:if test="${param.currentPage eq maxPage}">
            [맨끝]
         </c:if>
         <c:if test="${param.currentPage != maxPage }">
            <c:url var="last" value="letterlist.do">
               <c:param name="currentPage" value="${maxPage }" />
            </c:url>
            <a href="${last }">[맨끝]</a>
         </c:if>
      </div>
   </div>
   <br>
   <br>
   <br>
   <br>
   <c:import url="../../../footer.jsp"></c:import>

</body>
</html>