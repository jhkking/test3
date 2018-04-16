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
   margin-left: 700px;
   width: 80%;
   margin-top: 20px;
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
<script type="text/javascript">
   $(document).ready(function() {
      $('#suc').click(function() {
         var blackUser = $('#black_id').val();
         var title = $('#b_title').val();
         var content = $('#b_content').val();
         if (blackUser == "") {
            alert("신고 대상자를 입력해주세요!");
            $('#black_id').focus();
            return false;
         }
         if (title == "") {
            alert("신고 대상자를 입력해주세요!");
            $('#b_title').focus();
            return false;
         }
         if (content == "") {
            alert("신고 대상자를 입력해주세요!");
            $('#b_content').focus();
            return false;
         } else {
            alert("신고가 접수되었습니다!");
            $('#targetF').submit();
         }
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
   <div id="menu-wrap" class="menu-back cbp-af-header"
      style="position: fixed; top: 150px; width: 190px;">
      <div class="sixteen columns">
         <c:if test="${loginUser.member_id eq 'admin' }">
            <ul class="slimmenu">
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
   <br>
   <br>
   <h2 style="float: center; color: red;">신고하기</h2>
   <div id="contentt">

      <form action="blockWrite.do" method="get" id="targetF">
         <table id="t1">
            <tr>
               <th style="visibility: hidden;">신고 대상자 :&nbsp;&nbsp;</th>
               <td><input type="text" name="black_id" id="black_id"
                  style="width: 400px; height: 34px; border-radius: 4px; padding: 6px 12px;"
                  placeholder="신고 대상자"><br> <br></td>
            </tr>
            <tr>
               <th style="visibility: hidden;">제목 :</th>
               <td><input type="text" name="b_title" id="b_title"
                  style="width: 400px; height: 34px; border-radius: 4px; padding: 6px 12px;"
                  placeholder="제목"><br> <br></td>
            </tr>
            <tr>
               <th style="vertical-align: middle; visibility: hidden;">사유 :</th>
               <td><textarea id="b_content"
                     style="resize: none; width: 400px; height: 200px; padding: 6px 12px; border-radius: 4px;"
                     name="b_content" placeholder="내용을 입력해주세요."></textarea></td>
               <input type="hidden" name="white_id" value=${loginUser.member_id }>
            </tr>
         </table>
         <input type="button"
            style="width: 100px; height: 40px; float: left; margin-left: 130px;"
            id="suc" value="신고">

      </form>

      <button id="su2"
         style="width: 100px; height: 40px; float: center; margin-left: 130px;">

         <a href="/finalPro/about.jsp" style="color: white;">취소</a>
      </button>

   </div>

   <br>
   <br>
   <br>
   <br>
   <c:import url="../../../footer.jsp"></c:import>
</body>
</html>