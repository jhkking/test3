<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="vrBoard.model.vo.vrBoard"%>
<%@ page import="likePlace.model.vo.likePlace, java.util.*"%>
<%-- <%
	vrBoard board = (vrBoard) request.getAttribute("info");
%> --%>

<%-- <%
	Member member = (Member) session.getAttribute("member");
%> --%>
<html lang="en">

<head>
<style>
button#btn11 {
	border: 1px solid skyblue;
	color: white;
	font-size: 20px;
	text-align: center;
	background: lightgray;
	border-radius: 12px;
	height: 60px;
	width: 150px;
}

button#btn11:hover {
	color: #fff;
	background-color: #0069d9;
	border-radius: 12px;
	border-color: #0062cc;
}

button#btn11:focus, button#btn11.focus {
	box-shadow: 0 0 0 0.2rem rgba(0, 123, 255, 0.5);
	border-radius: 12px;
	background-color: #0069d9;
	color: #fff;
}
</style>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>BEST</title>
<script type="text/javascript">
	function imgclick() {
		var img = document.getElementById('image');

		if (img.src.match("like_no")) {
			img.src = "/semi/images/like_yes.png";
		} else {
			img.src = "/semi/images/like_no.png";
		}
	}
</script>


</head>

<body>

	<!-- Navigation -->
	<%@ include file="../../header.jsp"%>

	<!-- Page Content -->
	<div class="container">

		<!-- Page Heading -->
		<h1 class="my-4">
			검색 <small>search</small>
		</h1>
	
		<div align="center" width="80%" >
			
			<h3>▼ 검색 목록 ▼</h3>

		</div>
		<br>
		<br>

			<div align = "center">
				<div align = "center" width = "100%">
					<img src = "/semi/images/search_no.png" height = "100" width = "100">
					<br><br>
					<h3>['<%=request.getAttribute("skeyword") %>']</h3>
					<br><br>
					<h3>찾으시는 검색어와 일치하는 검색 결과가 없습니다.</h3>
					<br><br>
				</div>
			</div>

	</div>
	<!-- Bootstrap core JavaScript -->
	<script src="jquery/jquery.min.js"></script>
	<script src="jqueryintro/bootstrap.bundle.min.js"></script>
	<script src="jquery/bootstrap.bundle.min.js"></script>
	<%@ include file="../../footer.jsp"%>
</body>

</html>