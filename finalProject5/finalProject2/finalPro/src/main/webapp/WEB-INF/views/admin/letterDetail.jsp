<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<!DOCTYPE html>
<html>
<head>
<style>
#contentt {
   background-size: 100% 100%;
   margin-left: 550px;
   width: 80%;
}

table th {
   color: black;
   border: 1px solid white;
   width: 100px;
   height: 40px;
   background-color: #5A7996;
   color: white;
}

table td {
   color: #585858;
   border: 1px solid #5A7996;
   width: 100px;
   height: 40px;
   background-color: white;
}

option {
   background-color: #424242;
}
</style>
<meta charset=UTF-8">
<title>마음의 편지</title>
</head>
<script type="text/javascript">
   $(document).ready(function() {
      $('#already').click(function() {
         alert("이미 블랙리스트 입니다.");
      });
   });
   $(document).ready(function() {
      $('#black').click(function() {
         alert("블랙리스트에 추가되었습니다!");
         $('#targetF').submit();
      });
   });
</script>
<body>

   <c:import url="../../../header.jsp"></c:import>
   <br>
   <br>
   <br>
   <br>
   <br>
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
               <li><a href="blacklist.do?currentPage=1"
                  class="animsition-link">Black List</a></li>
               <br>
               <li><a href="letterlist.do?currentPage=1"
                  " class="animsition-link">Heart Letter</a></li>
            </ul>
         </c:if>
      </div>
   </div>
   <br>
   <div id="contentt">

      <table
         style="border: 1px solid #f2f2f2; text-align: center; width: 1000px; height: 400px;">
         <tr>
            <th>제목</th>
            <td colspan="5">${letter.b_title }</td>
         </tr>
         <tr>
            <th>작성자</th>
            <td style="color: blue; font-size: 12pt;">${letter.white_id }</td>
            <th>신고대상자</th>
            <td style="color: red; font-size: 12pt;">${letter.black_id }</td>
            <th>신고 날짜</th>
            <td>${letter.b_date }</td>
         </tr>
         <tr>
            <th style="resize: none; vertical-align: middle;">내용</th>
            <td colspan="6"><textarea
                  style="resize: none; width: 100%; height: 320px; border: white;"
                  readonly>${letter.b_content }</textarea></td>
         
            <c:set var="cnt" value="0" />
            <c:forEach var="list" items="${blackList}">
               <c:if test="${letter.black_id eq list.member_id}">
                  <c:set var="cnt" value="${cnt +1}" />
               </c:if>
            </c:forEach>
            <form action="adminblack.do" method="get" id="targetF">
               <c:if test="${cnt ne 0 }">
                  <td style="background-color:#f2f2f2;border:0px"><input id="already"
                     style="width:auto;height: 50px;" type="button"
                     onclick="already();" value="이미 블랙리스트 입니다."></td>
               </c:if>
               <c:if test="${cnt eq 0 }">
                  <td style="background-color:#f2f2f2;border:0px"><button style="width:auto; height: 50;"
                        onclick="black();" id="black">+블랙리스트</button></td>
                  <input type="hidden" name="member_id" value="${letter.black_id }">
               </c:if>
            </form>
         </tr>
      </table>
   </div>

   <br>
   <br>
   <br>
   <br>
   <c:import url="../../../footer.jsp"></c:import>
</body>
</html>