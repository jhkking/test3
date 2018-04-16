<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>noticeDetail</title>
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
</style>
</head>
<body>
	<c:import url="../../../header.jsp"></c:import>
	<form id="frm" action="qupdateView.do" method="post" enctype="multipart/form-data">
	<div id="contentForm">
		<%--      <input type="hidden" name="pageNum" value="${pageNum}">
        <input type="hidden" name="articleNumber" value="${article.articleNumber}">
          --%>
		<div class="input-group input-group-sm" role="group" aria-label="...">
			<table class="table table-striped table-bordered">
				<thead>
					<tr>
						<th width="30%">작성자</th>
						<td width="70%" >${qnadetail.q_writer}
						        <input type="hidden" name="q_writer" value="${qnadetail.q_writer}">
						         <input type="hidden" name="q_no" value="${qnadetail.q_no}">
						         <input type="hidden" name="q_readcount" value="${qnadetail.q_readcount}">
						         <input type="hidden" name="q_date" value="${qnadetail.q_date}">
						</td>
					</tr>
					<tr>
						<th style="padding-top: 15px">제목</th>
						<td><input type="text" name="q_title"
							value="${qnadetail.q_title}" class="form-control"
							aria-describedby="basic-addon1" ></td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td colspan="2">
							<input type="text" class="form-control" rows="20" name="q_content" value="${qnadetail.q_content }">
						</td>
					</tr>

				</tbody>
			</table>
			<input type ="submit" value ="저장하기">
		</div>
	
		<div class="btn-group btn-group-sm" role="group" aria-label="...">
			<input type="button" class="btn btn-default" value="목록으로 돌아가기"
				onclick="document.location.href='qlist.do'">
				
	
		</div>
	
	</div>

</form>
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
