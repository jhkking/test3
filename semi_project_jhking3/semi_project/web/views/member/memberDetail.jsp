<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="member.model.vo.Member"%>
<%
	Member memberD = (Member) request.getAttribute("info");
%>
<!DOCTYPE html>

<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>PLACE</title>

<!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="css/1-col-portfolio.css" rel="stylesheet">
<link href="cssintro/modern-business.css" rel="stylesheet">
<style>
table.type09 {
	border-collapse: collapse;
	text-align: left;
	line-height: 1.5;
	font-size:20px;
}

table.type09 thead th {
	padding: 10px;
	font-weight: bold;
	vertical-align: top;
	color: #369;
	border-bottom: 3px solid #036;
}

table.type09 tbody th {
	width: 150px;
	padding: 10px;
	font-weight: bold;
	vertical-align: top;
	border-bottom: 1px solid #ccc;
	background: #f3f6f7;
}

table.type09 td {
	width: 350px;
	padding: 10px;
	vertical-align: top;
	border-bottom: 1px solid #ccc;
}

button#btn11 {
	border: 1px solid skyblue;
	color: white;
	text-align: center;
	background: #007bff;
}

.list-group-item:focus, .list-group-item#btn11.focus {
	background-color: #0069d9;
	color: #fff;
}
table {
	border-collapse: separate;
	border-spacing: 0px 4px
}

.modal-dialog {
	width: 450px;
	height: 350px;
}

#divv {
	width: 100%;
	height: 52px;
	background: #f3f6f7;
	border: 1px solid gray;
	margin-top: 30;
	padding-top: 9px;
}

#td_name {
	color: white;
}
</style>

</head>


<body>
<%@ include file="../../header.jsp"%>


	<!-- Navigation -->
	


	<!-- Page Content -->
	<div class="container">

		<!-- Page Heading/Breadcrumbs -->
		<h1 class="mt-4 mb-3">
			MY PAGE <small>나의 정보 확인</small>
		</h1>

		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="index.html">MY PAGE</a></li>
			<li class="breadcrumb-item active">내 정보 보기 및 수정</li>
		</ol>
		<!-- Content Row -->
		<div class="row">
			<!-- Sidebar Column -->
			<div class="col-lg-3 mb-4">
				<div class="list-group">
					<a href="/semi/myinfo?userid=<%=member.getSmemberId()%>" class="list-group-item">내 정보 보기 및 수정</a> 
					<a href="/semi/mlikeplacelist?userid=<%=member.getSmemberId()%>"class="list-group-item">나의 관심 장소 보기</a> 
					<a href="/semi/rmblist?myId=<%=member.getSmemberId()%>" class="list-group-item">내가 쓴 글 보기</a>
				</div>
			</div>
			<!-- Content Column -->
			<div class="col-lg-9 mb-4">
				<h2>내 정보 보기 및 수정</h2>
				<div align="center">
					<table width="90%" class="type09">
						<tr align="center">
							<th colspan="2">나의 정보 확인</th>
						</tr>
						<tr>
							<th>1. 아이디</th>
							<td><%=memberD.getSmemberId()%></td>
						</tr>
						<tr>
							<th>2. 성 명</th>
							<td><%=memberD.getSmemberName()%></td>
						</tr>
						<tr>
							<th>3. 생년월일</th>
							<td><%=memberD.getSmemberIdNumber()%></td>
						</tr>
						<tr>
							<th>4. 성 별</th>
							<td>
					<% 	if (memberD.getSmemberGender().equals("M")) { %>
					남자
					<%} else {%> 
					여자
					<%} %></td>
						</tr>
						<tr>
							<th>5. 주  소</th>
							<td><%=memberD.getSmemberAddress()%></td>
						</tr>
						<tr>
							<th>6. 연락처</th>
							<td>
							<%=memberD.getSmemberPhone()%>
							</td>
								
						</tr>

						<tr>
							<th>7. 이메일</th>
							<td><%=memberD.getSmemberEmail()%></td>
						</tr>
					</table>
					<br> <br> 
					<a href = "/semi/myinfo2?userid=<%=memberD.getSmemberId()%>"><button class="btn btn-primary">수정 페이지로 이동</button></a>
				</div>
			</div>
		</div>
		<!-- /.row -->

	</div>


	<!-- Bootstrap core JavaScript -->
	<%@ include file="../../footer.jsp"%>
</body>
</html>
