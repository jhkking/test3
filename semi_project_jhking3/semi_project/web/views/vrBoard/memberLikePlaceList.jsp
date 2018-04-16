<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="vrBoard.model.vo.*, java.util.*"%>
<%
	ArrayList<vrBoard> likeBoard = (ArrayList<vrBoard>) request.getAttribute("likeBoard");
	/* String placeName = (String) request.getAttribute("place"); */
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 관심 장소 보기</title>
<!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="css/1-col-portfolio.css" rel="stylesheet">


<style>
@import url(//fonts.googleapis.com/earlyaccess/nanumpenscript.css);

h1 {
	font-family: 'Nanum Pen Script', cursive;
}

.npps {
	font-family: 'Nanum Pen Script', cursive;
	font-size: 30px;
}

h3 {
	font-family: 'Nanum Pen Script', cursive;
	font-size: 45px;
}



table.type08 {
	border-collapse: collapse;
	text-align: left;
	line-height: 1.5;
	border-left: 1px solid #ccc;
	margin: 20px 10px;
	font-family: 'Nanum Pen Script';
	font-size:20px;
	width : 100%;
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
	border-spacing: 0px 4px;
	whidth : 100%;
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
a.title{
	text-decoration:none;
	color:#369;
	
}
</style>
</head>
<body>
	<%@ include file="../../header.jsp"%>
	<div class="container">

		<!-- Page Heading/Breadcrumbs -->
		<h1 class="mt-4 mb-3">
			MY PAGE <small>나의 관심 장소 보기</small>
		</h1>

		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="index.html">MY PAGE</a></li>
			<li class="breadcrumb-item active">나의 관심 장소 보기</li>
		</ol>
		<!-- Content Row -->
		<div class="row">
			<!-- Sidebar Column -->
			<div class="col-lg-3 mb-4">
				<div class="list-group">
					<a href="/semi/myinfo?userid=<%=member.getSmemberId()%>" class="list-group-item">내 정보 보기 및 수정</a>
					<a href="/semi/mlikeplacelist?userid=<%=member.getSmemberId()%>" class="list-group-item">나의 관심 장소 보기</a> 
					<a href="/semi/rmblist?myId=<%=member.getSmemberId()%>"
						class="list-group-item">내가 쓴 글 보기</a>
				</div>
			</div>
			<!-- Content Column -->
			<div class="col-lg-9 mb-4">
				<h2>나의 관심 장소 보기</h2>
				<div align="center">
					<table class="type08">
						<thead>
							<tr align = "center" width = "100%">
								<th scope="cols">장소 구분</th>
								<th scope="cols">제목</th>
								<th scope="cols">조회수</th>
								<th scope="cols">관심등록</th>
							</tr>
						</thead>

						<tbody>
							<%
								if (likeBoard != null) {
									for (vrBoard lb : likeBoard) {
							%>
							<tr>
								<th scope="row"><%=lb.getVrcode()%></th>
								<td><a class="title"
									href="/semi/vrimg?place=<%=lb.getVrboardtitle().substring(0, 2)%>&title=<%=lb.getVrboardtitle()%>&userid=<%=member.getSmemberId()%>"><%=lb.getVrboardtitle()%></a></td>
								<td><%=lb.getVrboardreadcount()%></td>
								<td><%=lb.getVrlikecount()%></td>
							</tr>
							<%
								}
								}
							%>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="../../footer.jsp"%>
</body>
</html>