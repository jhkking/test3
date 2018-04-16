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
	<div id="contentForm">
		<%--      <input type="hidden" name="pageNum" value="${pageNum}">
        <input type="hidden" name="articleNumber" value="${article.articleNumber}">
          --%>
		<div class="input-group input-group-sm" role="group" aria-label="...">
			<table class="table table-striped table-bordered">
				<thead>
					<tr>
						<th width="30%">작성자</th>
						<td width="70%">${noticedetail.n_writer}</td>
					</tr>
					<tr>
						<th style="padding-top: 15px">제목</th>
						<td><input type="text" name="title"
							value="${noticedetail.n_title}" class="form-control"
							aria-describedby="basic-addon1" readonly></td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td colspan="2">
							<div class="form-control" rows="20" name="content">${noticedetail.n_content}</div>
						</td>
					</tr>
					<tr>
						<th style="padding-top: 15px">첨부파일</th>
						<td><c:if test="${empty noticedetail.n_original_filename }">
	첨부파일 없음</c:if> <c:if test="${!empty noticedetail.n_original_filename }">
								<c:url var="downfile" value="bdownfile.do">
									<c:param name="rfile" value="${noticedetail.n_rename_filename }" />
									<c:param name="ofile" value="${noticedetail.n_original_filename }" />
								</c:url>
								<a href="${downfile}">${noticedetail.n_original_filename }</a>
							</c:if></td>
					</tr>
				</tbody>
			</table>
		</div>
		<div class="btn-group btn-group-sm" role="group" aria-label="..." style="display:inline; align:center">
			<input type="button" class="btn btn-default" value="목록으로 돌아가기"
				onclick="document.location.href='nlist.do'" style="width: 33%;; float:left ; border-right: 1px solid #c00;">
				<c:if test="${loginUser.member_id eq 'admin' }">
			<input type="button" class="btn btn-default" value="수정하기"
				onclick="document.location.href='nupdate.do?no=${noticedetail.n_no}'" style="width: 33%; float:left; border-right: 1px solid #c00;border-left: 1px solid #c00;">
			
				<input type="button" class="btn btn-default" value="삭제하기"
				onclick="document.location.href='ndelete.do?no=${noticedetail.n_no}'" style="width: 33%; float:left;border-left: 1px solid #c00;">
		</c:if>
		</div>
	</div>


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
