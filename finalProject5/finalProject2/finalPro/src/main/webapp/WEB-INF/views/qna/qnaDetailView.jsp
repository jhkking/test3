<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>qnaDetail</title>
<link href="bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet">
<style>
#contentForm {
   width: 40%;
   margin: 0 auto;
   padding-top: 15%;
   padding-bottom: 5%;
}

.table>thead>tr>th, .table>tbody>tr>th {
   background-color: #e6ecff;
   text-align: center;
   width: 700px;
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
    width: 200px;
    padding: 10px;
    font-weight: bold;
    vertical-align: top;
    border-bottom: 1px solid #ccc;
    background: #f3f6f7;
}
table.type09 tbody td {
    width: 400px;
    padding: 10px;
    vertical-align: top;
    border-bottom: 1px solid #ccc;
}
table.type09 td {
    width: 50px;
    padding: 10px;
    vertical-align: top;
    border-bottom: 1px solid #ccc;
}


</style>
<style type="text/css">


.box1{
float: left;
}
.box2{
display:inline-block;



}
.hide-bullets {
   list-style: none;
   margin-left: -40px;
   margin-top: 20px;
}

.thumbnail {
   padding: 0;
}

.carousel-inner>.item>img, .carousel-inner>.item>a>img {
   width: 100%;
}

</style>


</head>
<body>
   <c:import url="../../../header.jsp"></c:import>
   <div id="contentForm">
      <%--      <input type="hidden" name="pageNum" value="${pageNum}">
        <input type="hidden" name="articleNumber" value="${article.articleNumber}">
          --%>
      <div class="input-group input-group-sm" role="group" aria-label="...">
         <table class="table table-striped table-bordered">
            <thead>
               <tr>
                  <th width="30%">작성자</th>
                  <td width="70%">${qnadetail.q_writer}</td>
               </tr>
               <tr>
                  <th style="padding-top: 15px">제목</th>
                  <td><input type="text" name="title"
                     value="${qnadetail.q_title}" class="form-control"
                     aria-describedby="basic-addon1" readonly></td>
               </tr>
            </thead>
            <tbody>
               <tr>
                  <td colspan="2">
                     <div class="form-control" rows="20" name="content">${qnadetail.q_content}</div>
                  </td>
               </tr>
   
            </tbody>
         </table>
      </div>
      <div class="btn-group btn-group-sm" role="group" aria-label="..." style="display:inline; align:center">
         <input type="button" class="btn btn-default" value="목록으로 돌아가기"
            onclick="document.location.href='qlist.do'" style="width: 33%;; float:left ; border-right: 1px solid #c00;">
            
         <input type="button" class="btn btn-default" value="수정하기"
            onclick="document.location.href='qupdate.do?no=${qnadetail.q_no}'" style="width: 33%; float:left; border-right: 1px solid #c00;border-left: 1px solid #c00;">
         
            <input type="button" class="btn btn-default" value="삭제하기"
            onclick="document.location.href='qdelete.do?no=${qnadetail.q_no}'" style="width: 33%; float:left;border-left: 1px solid #c00;">
      </div>
   </div>
   
   
   
   <div><br><font color="black">댓글</font><br>

<table class ="type09">
<thead>
<tr>


<th scope="cols">내용</th>

<th scope="cols">작성자</th>
<th scope="cols">날짜</th>

<th scope="cols">삭제</th>

</tr>
</thead>


<c:forEach var="qr" items="${qreplyList}" varStatus="status">
<tr>


<td style="width:60%">
${qr.qr_content}
</td> 

<td style="width:10%">${qr.qr_writer}
</td>
<td style="width:10%">${qr.qr_date}
</td>
<c:if test ="${loginUser.member_id eq qr.qr_writer or loginUser.member_id eq 'admin' }">
<td style="width:10%">
<a style=color:blue; href ="deleteqnareply.do?qr_no=${qr.qr_no}&qr_ref_no=${qr.qr_ref_no}">&nbsp;&nbsp;X</a>
</td>
</c:if>
<c:if test ="${loginUser.member_id ne qr.qr_writer }">
<td></td>
</c:if>


</tr>
</c:forEach>



</table>
<br>


               <c:if test="${!empty loginUser.member_id }">
                  
   
                  <form  action="insertqnareply.do" method="post">
                     
                      <div class="box1"> 
                     <input type="text" id="qr_content" style="height:50px;" size="100px;" 
                         placeholder="댓글입력..."
                        style="border-top:none; border-left: none; border-right: none;" name="qr_content">
            
                     <input type="hidden" id="qr_ref_no" name="qr_ref_no"
                        value="${qnaNo}"> 
                        <input type="hidden"
                        id="qr_writer" name="qr_writer" value="${loginUser.member_id}">
                         <div class="box2">
                        <input type="submit" class="qnareplybtn"  value="등록" >
                        
                        </div>
                      </div> 
                     </form>
                  
               </c:if>

</div>
<br><br><br><br><br><br><br><br><br><br><br>


   <script src="https://code.jquery.com/jquery-3.2.0.min.js"></script>
   <!--  <script>
    jQuery(document).ready(function() {
      if(${id== null}) {
        alert("게시판을 이용하시려면 로그인하셔야 합니다.");
        location.href="/bbs/login.bbs"
      }
    });
  </script> -->
   <c:import url="../../../footer.jsp"></c:import>

</body>
</html>