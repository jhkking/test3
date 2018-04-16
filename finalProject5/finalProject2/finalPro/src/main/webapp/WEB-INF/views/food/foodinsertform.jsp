<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>noticeInsert</title>
<link href="bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet">
<style>
#contentForm {
	width: 60%;
	margin: 0 auto;
	padding-top: 12%;
	padding-bottom: 5%;
}

.table>thead>tr>th, .table>tbody>tr>th {
	background-color: #e6ecff;
	text-align: center;
	width: 1200px;
}
</style>
</head>
<body>
	<c:import url="../../../header.jsp" />
	<form action="foodinsert.do" method="post" enctype="multipart/form-data">
		<div id="contentForm">
			<input type="hidden" name="food_writer" value="${loginUser.member_id }">
			<div class="input-group input-group-sm" role="group" aria-label="...">
				<table class="table table-striped table-bordered">
					<thead>
						<tr>
							<th width="15%">작성자</th>
							<td width="80%" readonly " colspan="3">
								${loginUser.member_id }					
							</td>
						</tr>		
						<tr>
							<th style="padding-top: 15px">제목</th>
							<td  colspan="3"><input type="text" name="food_title" class="form-control"
								aria-describedby="basic-addon1"></td>
						</tr>
							<tr>
							<th style="padding-top: 15px" >나라</th>
							<td width="35%"><input type="text" name="food_nation1" class="form-control"
								aria-describedby="basic-addon1"></td>
							<th style="padding-top: 15px; width:15%">지역이름</th>
							<td  width="35%"><input type="text" name="food_nation2" class="form-control"
								aria-describedby="basic-addon1"></td>
						</tr>
								<tr>
							<th style="padding-top: 15px">주소</th>
							<td><input type="text" name="food_address" class="form-control"
								aria-describedby="basic-addon1"></td>
							<th style="padding-top: 15px" width="20%">전화번호</th>
							<td><input type="text" name="food_phone" class="form-control"
								aria-describedby="basic-addon1"></td>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td colspan="4"><textarea class="form-control" rows="15" name="food_content"></textarea></td>
						</tr>
						<tr>
							<th style="padding-top: 15px">첨부파일</th>
							<td colspan="3"><input type="file" class="btn btn-default" name="uploadFile"></td>
						</tr>
					
					</tbody>
				</table>
			</div>
			<div class="btn-group btn-group-sm" role="group" aria-label="...">
				<input type="submit" class="btn btn-default" value="등록하기">
			</div>
		</div>
	</form>

	<script src="https://code.jquery.com/jquery-3.2.0.min.js"></script>
	<!--   <script>
    jQuery(document).ready(function() {
      if(${id== null}) {
        alert("게시판을 이용하시려면 로그인하셔야 합니다.");
        location.href="/bbs/login.bbs"
      }
    });
  </script> -->
	<c:import url="../../../footer.jsp" />
</body>
</html>
