<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="member.model.vo.Member"%>
<%
	Member member = (Member) session.getAttribute("member");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="css/1-col-portfolio.css" rel="stylesheet">

<style>
@import url(//fonts.googleapis.com/earlyaccess/nanumpenscript.css);

* {
	font-family: 'Nanum Pen Script', cursive;
}

table {
	border-collapse: separate;
	border-spacing: 0px 4px
}

.modal-dialog {
	width: 450px;
	height: 350px;
}

@import url(//fonts.googleapis.com/earlyaccess/nanumpenscript.css);

.npss {
	font-family: 'Nanum Pen Script', cursive;
	font-size: 25px;
}

.nps {
	font-family: 'Nanum Pen Script', cursive;
	font-size: 20px;
}

a.linkcolor {
	text-decoration: none;
	color: #888;
}



a.linkcolor:hover {
	color:#369;
	text-decoration: none;
}
</style>

</head>
<body>
	<nav
		class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark fixed-top">
		<div class="container">
			<a class="navbar-brand npss" href="intro.jsp">WhybiS</a>
			<button class="navbar-toggler navbar-toggler-right" type="button"
				data-toggle="collapse" data-target="#navbarResponsive"
				aria-controls="navbarResponsive" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse nps" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item"><a class="nav-link"
						href="/semi/intro.jsp">HOME</a></li>
					<li class="nav-item">
						<%
							if (member != null) {
						%> <a class="nav-link"
						href="/semi/vrimg?place=홍대&title=홍대정문&userid=<%=member.getSmemberId()%>&bnum=1">PLACE</a>
						<%
							} else {
						%> <a class="nav-link"
						href="javascript:alert('회원만 사용 가능 합니다 !\n로그인을 해주세요!');">PLACE</a>
						<%
							}
						%>
					</li>
					<%
						if (member != null) {
					%>
					<li class="nav-item"><a class="nav-link"
						href="/semi/bestplace?page=1">BEST</a></li>
					<%
						} else {
					%>
					<li class="nav-item"><a class="nav-link"
						href="/semi/bestplace?page=1">BEST</a></li>

					<%
						}
					%>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="" id="navbarDropdownBlog"
						data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">BOARD</a>
						<div class="dropdown-menu dropdown-menu-right"
							aria-labelledby="navbarDropdownBlog">
							<a class="dropdown-item" href="/semi/rblist?page=1">리뷰 게시판</a>
							<%
								if ((member != null && member.getSmemberWorkerYN().equals("y"))
										|| (member != null && member.getSmemberAdminYN().equals("y"))) {
							%>
							<a class="dropdown-item" href="/semi/wblist?page=1">사업자게시판</a>
							<%
								} else {
							%>
							<a class="dropdown-item"
								href="javascript:alert('사업자와 관리자만 게시판 열람 가능합니다 !');">사업자게시판</a>
							<%
								}
							%>
						</div></li>
					<li class="nav-item"><a class="nav-link"
						href="/semi/nlist?page=1"> NOTICE </a></li>
					<li class="nav-item"><a class="nav-link"
						href="/semi/qlist?page=1"> Q&A </a></li>
					<li class="nav-item dropdown">
						<%
							if (member == null) { //로그인하지 않았다면
						%> <a class="nav-link dropdown-toggle" href=""
						id="navbarDropdownBlog" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false"> MY PAGE </a>
						<div class="dropdown-menu dropdown-menu-right"
							aria-labelledby="navbarDropdownBlog">
							<a class="dropdown-item" href="javascript:alert('로그인이 필요합니다!');">내
								정보 보기 및 수정</a> <a class="dropdown-item"
								href="javascript:alert('로그인이 필요합니다!');">나의 관심 장소 보기</a> <a
								class="dropdown-item" href="javascript:alert('로그인이 필요합니다!');">내가
								쓴 글 보기</a>
						</div> <%
 	} else {
 %> <a class="nav-link dropdown-toggle" href="" id="navbarDropdownBlog"
						data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							MY PAGE </a>
						<div class="dropdown-menu dropdown-menu-right"
							aria-labelledby="navbarDropdownBlog">
							<a class="dropdown-item"
								href="/semi/myinfo?userid=<%=member.getSmemberId()%>">내 정보
								보기 및 수정</a> <a class="dropdown-item"
								href="/semi/mlikeplacelist?userid=<%=member.getSmemberId()%>">나의
								관심 장소 보기</a> <a class="dropdown-item"
								href="/semi/rmblist?myId=<%=member.getSmemberId()%>">내가 쓴 글
								보기</a>

						</div> <%
 	}
 %>
					
					<li></li>
					<li></li>
				</ul>
				<%
					if (member == null) { //로그인하지 않았다면
				%>
				<ul class="navbar-nav ml-auto">
					<li class="nav-item"><a class="nav-link" data-toggle="modal"
						data-target="#myModal"> LOGIN </a></li>
					<li class="nav-item"><a class="nav-link"
						href="views/member/JoinworkerCheck.jsp"> JOIN </a></li>
				</ul>
				<%
					} else {
				%>
				<ul class="navbar-nav ml-auto">
					<li class="nav-item"><a class="nav-link" data-toggle="modal"
						data-target="#myModal"> <font color="white"><b><%=member.getSmemberName()%></b>
								님</font></a></li> &nbsp;&nbsp;&nbsp;
					<li class="nav-item"><a class="nav-link" href="/semi/logout">로그아웃</a></li>
				</ul>
				<%
					if (member.getSmemberId().equals("admin01")) {
				%>
				&nbsp;&nbsp;<a href="/semi/mlist?page=1" class="linkcolor">회원 정보
					전체보기</a>
				<%
					}
				%>


				<%
					}
				%>
			</div>
		</div>
	</nav>
	<br>
	<div align="center">
		<div align="center">
			<%
				if (member != null && member.getSmemberId().equals("admin01")) {
			%>
			<a href="/semi/views/vrBoard/workerWriter.jsp"><input
				type="submit" class="btn btn-primary" value="사업자 글 올리기"></a> <a
				href="/semi/vrworkerlist?page=1"><input type="submit"
				class="btn btn-primary" value="올린 글 목록 보기"></a> <br> <br>
			<%
				}
			%>
		</div>
		<div align="center" id="divv">
			<form action="/semi/searchall">
				<select name="searchoption">
					<option value="all">검색 옵션</option>
					<option value="명소">장소</option>
					<option value="편의시설">편의 시설</option>
					<option value="숙소">숙소</option>
				</select> &nbsp;&nbsp;&nbsp; <input type="hidden" name="page" value="1">
				<input type="text" name="searchkey"> &nbsp;&nbsp; <input
					type="submit" class="btn btn-primary" value="검색">
			</form>
		</div>

	</div>
	<Br>
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title" id="myModalLabel">로그인</h4>
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">×</span><span class="sr-only">Close</span>
					</button>

				</div>
				<!--모달 바디-->
				<form action="login" method="post">
					<div class="modal-body">

						<table width="250" cellpadding="0" cellspacing="0" align="center">
							<tr>
								<td>아이디</td>
								<td><input type="text" name="userid"></td>
							</tr>

							<tr>
								<td>암 호</td>
								<td><input type="password" name="userpwd"></td>
							</tr>
							<tr align="center">
								<td colspan="2"><a href="#">아이디/암호 찾기</a></td>
							</tr>
							<tr align="center">
								<td colspan="2"><a href="#">회원가입</a></td>
							</tr>
						</table>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>

						<button type="submit" class="btn btn-primary">로그인</button>
					</div>
				</form>
			</div>
		</div>
	</div>

	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script
		src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
	<!--    <script src="http://googledrive.com/host/0B-QKv6rUoIcGREtrRTljTlQ3OTg"></script>
   ie10-viewport-bug-workaround.js
   <script src="http://googledrive.com/host/0B-QKv6rUoIcGeHd6VV9JczlHUjg"></script> -->
	<!-- holder.js -->

</body>
</html>