<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" href="bootstrap-3.3.7/css/bootstrap.css" />
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script>
   $(document).ready(function() {
      var modalLayer = $("#modalLayer");
      var modalLink = $(".modalLink");
      var modalCont = $(".modalContent");
      var marginLeft = modalCont.outerWidth() / 2;
      var marginTop = modalCont.outerHeight() / 2;

      function modalLinkq(userid) {

         $("#f1").attr("value", userid);
         modalLayer.fadeIn("slow");
         modalCont.css({
            "margin-top" : -marginTop,
            "margin-left" : -marginLeft
         });
         $(this).blur();
         $(".modalContent > a").focus();

         return false;
      }
      modalLinks = modalLinkq;

      $(".modalContent > .modalclose").click(function() {
         modalLayer.fadeOut("slow");
         modalLink.focus();
      });
   });
   function modalLinkk(userid) {
      modalLinks(userid);
   }
</script>
<script>
   String.prototype.replaceAll = function(org, dest) {
      return this.split(org).join(dest);
   }
</script>
<script>
   $(document)
         .ready(
               function() {
                  var modalLayer2 = $("#modalLayer2");
                  var modalLink2 = $(".modalLink2");
                  var modalCont2 = $(".modalContent2");
                  var marginLeft2 = modalCont2.outerWidth() / 2;
                  var marginTop2 = modalCont2.outerHeight() / 2;

                  function modalLinkq2(userid) {

                     /* $("#f2").attr("value", userid);
                     var b_id = $('#f2').val(); */

                     jQuery
                           .ajax({
                              type : "post",
                              data : {
                                 id : userid
                              },
                              url : "blackreason.do",
                              success : function(data) {
                                 console.log(data); //object 라고 출력됨
                                 //리턴된 하나의 객체를 문자열로 변환함
                                 var jsonStr = JSON.stringify(data);
                                 //변환된 문자열을 json 객체로 바꿈
                                 var json = JSON.parse(jsonStr);
                                 $('#t3').empty();
                                 var values = $('#t3').html();
                                 values += "<tr><td>신고자</td><td>피의자</td><td>제 목</td><td>내용(이유)</td></tr>";

                                 for ( var i in json.list) {

                                    values += "<tr><td>"
                                          + decodeURIComponent(json.list[i].white_id
                                                .replace("+",
                                                      " "))
                                          + "</td><td>"
                                          + decodeURIComponent(json.list[i].black_id
                                                .replace("+",
                                                      " "))
                                          + "</td><td>"
                                          + decodeURIComponent(json.list[i].b_title
                                                .replace("+",
                                                      " "))
                                          + "</td><td>"
                                          + decodeURIComponent(json.list[i].b_content
                                                .replaceAll(
                                                      "+",
                                                      " "))
                                          + "</td></tr>";

                                 }

                                 $('#t3').html(values);
                              },
                           });
                     modalLayer2.fadeIn("slow");
                     modalCont2.css({
                        "margin-top" : -marginTop2,
                        "margin-left" : -marginLeft2
                     });
                     $(this).blur();
                     $(".modalContent2 > a").focus();

                     return false;
                  }
                  modalLinks2 = modalLinkq2;

                  $(".modalContent2 > .modalclose2").click(function() {
                     modalLayer2.fadeOut("slow");
                     modalLink2.focus();
                  });
               });

   function modalLinkk2(userid) {
      modalLinks2(userid);
   }
</script>
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

.mask {
   width: 100%;
   height: 100%;
   position: fixed;
   left: 0;
   top: 0;
   z-index: 10;
   background: #000;
   opacity: .5;
   filter: alpha(opacity = 50);
}

#modalLayer {
   display: none;
   position: relative;
}

#modalLayer .modalContent {
   width: 440px;
   height: 200px;
   padding: 20px;
   border: 1px solid #ccc;
   position: fixed;
   left: 50%;
   top: 50%;
   z-index: 11;
   background: #fff;
}

#modalLayer .modalContent button {
   position: absolute;
   right: 0;
   top: 0;
   cursor: pointer;
}

#modalLayer2 {
   display: none;
   position: relative;
}

#modalLayer2 .modalContent2 {
   width: 440px;
   height: 200px;
   padding: 20px;
   border: 1px solid #ccc;
   position: fixed;
   left: 50%;
   top: 50%;
   z-index: 11;
   background: #fff;
}

#modalLayer2 .modalContent2 button {
   position: absolute;
   right: 0;
   top: 0;
   cursor: pointer;
}
</style>
<meta charset=UTF-8">
<title>회원 조회</title>
</head>
<body>
   <c:import url="../../../header.jsp"></c:import>
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
               <li><a href="blacklist.do?currentPage=1"
                  class="animsition-link">Black List</a></li>
               <li><a href="letterlist.do?currentPage=1"
                  " class="animsition-link">Heart Letter</a></li>
            </ul>
         </c:if>
      </div>
   </div>
   <br>
   <br>
   <br>
	<h3>블랙 리스트</h3>
   <br>
   <div id="contentt">

      <table class="table table-hover" border="1" width="100%"
         style="text-align: center;">
         <tr>
            <th>회원 아이디</th>
            <th>이름</th>
            <th>생년월일</th>
            <th>성별</th>
            <th>전화번호</th>
            <th>e-mail</th>
            <th>주소</th>
            <th>블랙 리스트 현황</th>
            <th>상태</th>
            <th>사유</th>
         </tr>
         <c:if test="${empty blacklist}">
            <tr>
               <td style="position:absolute;left:45%">블랙리스트가 없습니다!</td>
            </tr>
         </c:if>
         <c:if test="${!empty blacklist}">
            <c:forEach items="${blacklist }" var="row">
               <tr>
                  <td>${row.member_id }</td>
                  <td>${row.member_name }</td>
                  <td>${row.member_birth }</td>
                  <td>${row.gender }</td>
                  <td>${row.phone }</td>
                  <td>${row.email }</td>
                  <td>${row.address }</td>
                  <td>${row.blackuser }</td>
                  <td><a href="#modalLayer"
                     class="modalLink animsition-link btn"
                     style="line-height: 0px; padding: 14px 10px; margin-bottom: 20px; margin-top: 20px"
                     onclick="modalLinkk('${row.member_id}')">블랙 취소</a></td>
                  <td><a href="#modalLayer2"
                     class="modalLink animsition-link btn"
                     style="line-height: 0px; padding: 14px 10px; margin-bottom: 20px; margin-top: 20px"
                     onclick="modalLinkk2('${row.member_id}','${row.member_name }')">블랙
                        원인</a></td>
               </tr>
            </c:forEach>
         </c:if>
      </table>
      <br> <br> <br>
      <div style="text-align: center;">

         <c:if test="${currentPage eq 1 }">
            [맨처음]
         </c:if>
         <c:if test="${currentPage > 1 }">
            <c:url var="first" value="blacklist.do">
               <c:param name="currentPage" value="1" />
            </c:url>
            <a href="${first }">[맨처음]</a>

            <c:url var="prev" value="blacklist.do">
               <c:param name="currentPage" value="${currentPage = 1}" />
            </c:url>
         </c:if>
         <c:if test="${param.currentPage eq 1 }">
            [이전]
         </c:if>
         <c:if test="${param.currentPage ne 1 }">
            <a href="${prev }"> [이전]</a>
            <c:url var="prev" value="blacklist.do">
               <c:param name="currentPage" value="${currentPage - 1}" />
            </c:url>

         </c:if>

         <c:forEach var="p" begin="${startPage }" end="${endPage }" step="1">
            <c:url var="page" value="blacklist.do">
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
            <c:url var="next" value="blacklist.do">
               <c:param name="currentPage" value="${currentPage + 1 }" />
            </c:url>
            <a href="${next }"> [다음]</a>
         </c:if>

         <c:if test="${param.currentPage eq maxPage}">
            [맨끝]
         </c:if>
         <c:if test="${param.currentPage != maxPage }">
            <c:url var="last" value="blacklist.do">
               <c:param name="currentPage" value="${maxPage }" />
            </c:url>
            <a href="${last }">[맨끝]</a>
         </c:if>
      </div>
   </div>

   <c:import url="../../../footer.jsp"></c:import>


   <div id="modalLayer">
      <div class="modalContent">
         <!-- //<a href="#">모달창 테스트</a>// -->
         <p>일반 회원으로 되돌리겠습니까?</p>
         <form action="blackcancle.do" method="post">
            <input type="hidden" id="f1" name="member_id"> <input
               class="btn btn-primary" type="submit" value="확인" class='btn'>
         </form>
         <button type="button" style="position: relative;" class="modalclose">닫기</button>
      </div>
   </div>
   <div id="modalLayer2">
      <div class="modalContent2">
         <table class="table table-hover" border="1" width="100%"
            style="text-align: center;" id="t3">

         </table>
         <button type="button" style="position: relative;" class="modalclose2">닫기</button>
      </div>
   </div>


</body>
</html>