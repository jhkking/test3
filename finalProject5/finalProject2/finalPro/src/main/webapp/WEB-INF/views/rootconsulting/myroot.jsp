<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>myreviewListView</title>
  <!-- Bootstrap -->
  <link href="bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet">
  <style>
    #container {
      width: 70%;
      margin: 0 auto;     /* 가로로 중앙에 배치 */
      padding-top: 15%;   /* 테두리와 내용 사이의 패딩 여백 */
      padding-botton : 5%;
    }
     
    #list {
      text-align: center;
    }
   
    #write {
      text-align: right;
    }


    /* Bootstrap 수정 */
/*     .table > thead {
      background-color: #b3c6ff;
    }
    .table > thead > tr > th {
      text-align: center;
    }
    .table-hover > tbody > tr:hover {
      background-color: #e6ecff;
    }
    .table > tbody > tr > td {
      text-align: center;
    }
    .table > tbody > tr > #title {
      text-align: left;
    }
     
    div > #paging {
      text-align: center;
    }
     
    .hit {
      animation-name: blink;
      animation-duration: 1.5s;
      animation-timing-function: ease;
      animation-iteration-count: infinite;
  
    }

    @keyframes blink {
      from {color: white;}
      30% {color: yellow;}
      to {color: red; font-weight: bold;}
      
    }  */
    table.type08 {
    
    border-collapse: collapse;
    text-align: center;
    line-height: 1.5;
    border-left: 1px solid #ccc;
    margin: 20px 10px;
}

table.type08 thead th {
    padding: 10px;
    font-weight: bold;
    border-top: 1px solid #ccc;
    border-right: 1px solid #ccc;
    border-bottom: 2px solid #c00;
    background: #dcdcd1;
}
table.type08 tbody th {
    width: 150px;
    padding: 10px;
    font-weight: bold;
    vertical-align: top;
    border-right: 1px solid #ccc;
    border-bottom: 1px solid #ccc;
    background: #ececec;
}
table.type08 td {
    width: 350px;
    padding: 10px;
    vertical-align: top;
    border-right: 1px solid #ccc;
    border-bottom: 1px solid #ccc;
}
    
  </style>
  <script type="text/javascript">
  $(function() {
      $("dd:not(:first)").css("display", "none");
      $("dt:first").addClass("selected");
      $("dl dt").click(function() {
         if ($("+dd", this).css("display") == "none") {
            $("dd").slideUp("slow");
            $("+dd", this).slideDown("slow");
            $("dt").removeClass("selected");
            $(this).addClass("selected");
         }
      }).mouseover(function() {
         $(this).addClass("over");
      }).mouseout(function() {
         $(this).removeClass("over");
      });
   });

  </script>
</head>
<body>
<c:import url="../../../header.jsp"/>
  <div id="container">
<%--    <div align="right">
      <!-- Login 검증 -->
      <!-- jstl의 if문은 else가 없어서 따로 검증해야함. -->
      <c:if test="${loginUser.member_id eq null}">
        <%@include file="member/login.jsp" %>
      </c:if>
    </div>  --%>
   
    <div id="list">
    <%--   <b>게시판 (전체 글: ${totalCount})</b> --%>
    
    </div> 
    <div>
   
    <font size="4" style="color:#c00">▼Review 등록 전 글 목록</font>
      <table class="table table-striped table-bordered table-hover type08"   >
        <thead>
          <tr>
            
            <th width="15%">국가</th>
            <th width="40%">제목</th>
            <th width="10%">작성자</th>
            <th width="10%">작성날짜</th>
             <th width="5%">수정</th>
            <th width="10%">Review</th>
           <th width="10%">Feedback</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach var="mr" items="${mrlist}" varStatus="status">
            <tr>
              
              <td>${mr.mr_nation1}_${mr.mr_nation2}</td>
              <%-- <td>${mr.mr_day}일차</td> --%>
              <td id="title">
<%--                  <a href="/bbs/content.bbs?articleNumber=${spot.s_no}&pageNum=${pageNum}">${spot.s_title}</a> --%>     
           <a href="mrdetail.do?id=${mr.mr_writer}&title=${mr.mr_title}">${mr.mr_title}</a>
              </td>
              <td>${mr.mr_writer}</td>
              <td>${mr.mr_date}</td>
              <td><button id="modifybtn" style="width:70px; height:25px; font-size:10px;text-align:center;border-radius:20px;margin:0;padding:0; "
              onclick="document.location.href = 'rmodifyform.do?id=${loginUser.member_id}&title=${mr.mr_title}'">수정</button></td>
              <td><button id="insertbtn" style="width:70px; height:25px; font-size:10px;text-align:center;border-radius:20px ;margin:0;padding:0;"
              onclick="document.location.href = 'rinsert.do?id=${loginUser.member_id}&title=${mr.mr_title}'">review</button></td>
              <td><button id="feedinsert" style="width:70px; height:25px; font-size:10px;text-align:center;border-radius:20px ;margin:0;padding:0;"
              onclick="document.location.href = 'feedinsert.do?id=${loginUser.member_id}&title=${mr.mr_title}'">feedback</button></td>
            <tr>
          </c:forEach>
        </tbody>
      </table>
      
       
      <font size="4" style="color:#c00">▼Review 등록 한 글 목록</font>
       
       <table class="table table-striped table-bordered table-hover type08"   >
        <thead>
          <tr>
            
            <th width="20%">국가</th>
            <!-- <th width="10%">총일수</th> -->
            <th width="50%">제목</th>
            <th width="10%">작성자</th>
            <th width="10%">작성날짜</th>
            <th width="10%">리뷰삭제</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach var="re" items="${reviewlist}" varStatus="status">
            <tr>
              
              <td>${re.r_nation1}_${re.r_nation2}</td>
              <%-- <td>${mr.mr_day}일차</td> --%>
              <td id="title">
<%--                  <a href="/bbs/content.bbs?articleNumber=${spot.s_no}&pageNum=${pageNum}">${spot.s_title}</a> --%>     
           <a href="rdetail2.do?r_writer=${re.r_writer}&r_title=${re.r_title}">${re.r_title}</a>
              </td>
              <td>${re.r_writer}</td>
              <td>${re.r_date}</td>
              <td><button id="insertbtn" style="width:70px; height:25px; font-size:10px;text-align:center;border-radius:20px;margin:0;padding:0;"
              onclick="document.location.href = 'rdelete.do?id=${loginUser.member_id}&title=${re.r_title}'">X</button></td>
            <tr>
          </c:forEach>
        </tbody>
      </table>
     
     <font size="4" style="color:#c00">▼Feedback 등록 목록</font>
       
       <table class="table table-striped table-bordered table-hover type08"   >
        <thead>
          <tr>
            
            <th width="20%">국가</th>
            <!-- <th width="10%">총일수</th> -->
            <th width="50%">제목</th>
            <th width="10%">작성자</th>
            <th width="10%">작성날짜</th>
            <th width="10%">삭제</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach var="fe" items="${feedbacklist}" varStatus="status">
            <tr>
              
              <td>${fe.f_nation1}_${fe.f_nation2}</td>
              <%-- <td>${mr.mr_day}일차</td> --%>
              <td id="title">
<%--                  <a href="/bbs/content.bbs?articleNumber=${spot.s_no}&pageNum=${pageNum}">${spot.s_title}</a> --%>     
           <a href="fdetail.do?no=${fe.f_no}">${fe.f_title}</a>
              </td>
              <td>${fe.f_writer}</td>
              <td>${fe.f_date}</td>
              <td><button id="insertbtn" style="width:70px; height:25px; font-size:10px;text-align:center;border-radius:20px;margin:0;padding:0;"
              onclick="document.location.href = 'fdelete.do?id=${loginUser.member_id}&title=${fe.f_title}'">X</button></td>
            <tr>
          </c:forEach>
        </tbody>
      </table>
     <%--  <!-- Paging 처리 -->
      <div id="paging">
        ${pageCode}
      </div> --%>
    </div>
  </div>
  <c:import url="../../../footer.jsp"/>

</body>

</html>
