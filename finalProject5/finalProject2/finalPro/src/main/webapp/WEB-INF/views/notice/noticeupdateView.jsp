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
	<form id="frm" action="nupdateView.do" method="post" enctype="multipart/form-data">
	<div id="contentForm">
		<%--      <input type="hidden" name="pageNum" value="${pageNum}">
        <input type="hidden" name="articleNumber" value="${article.articleNumber}">
          --%>
		<div class="input-group input-group-sm" role="group" aria-label="...">
			<table class="table table-striped table-bordered">
				<thead>
					<tr>
						<th width="30%">작성자</th>
						<td width="70%" >${noticedetail.n_writer}
						        <input type="hidden" name="n_writer" value="${noticedetail.n_writer}">
						         <input type="hidden" name="n_no" value="${noticedetail.n_no}">
						</td>
					</tr>
					<tr>
						<th style="padding-top: 15px">제목</th>
						<td><input type="text" name="n_title"
							value="${noticedetail.n_title}" class="form-control"
							aria-describedby="basic-addon1" ></td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td colspan="2">
							<input type="text" class="form-control" rows="20" name="n_content">
						</td>
					</tr>
<tr>
				<c:if test="${empty noticedetail.n_original_filename }">
					<td><input type="file" name="uploadFile"></td>
					<input type="hidden" name="ofile" value="null">
					<input type="hidden" name="rfile" value="null">
				</c:if>
				<c:if test="${not empty noticedetail.n_original_filename }">
					<td><input type="file" name="uploadFile"></td>
					<input type="hidden" name="ofile" value="${noticedetail.n_original_filename }">
					<input type="hidden" name="rfile" value="${noticedetail.n_rename_filename }">
				</c:if>
				</tr>
				</tbody>
			</table>
			<input type ="submit" value ="저장하기">
		</div>
	
		<div class="btn-group btn-group-sm" role="group" aria-label="...">
			<input type="button" class="btn btn-default" value="목록으로 돌아가기"
				onclick="document.location.href='nlist.do'">
				
	
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
