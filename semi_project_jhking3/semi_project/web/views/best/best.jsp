<%@page import="oracle.net.aso.r"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="vrBoard.model.vo.vrBoard"%>
<%@ page import="likePlace.model.vo.likePlace, java.util.*, vrBoard.model.vo.*"%>
<%-- <%
	vrBoard board = (vrBoard) request.getAttribute("info");
%> --%>
<%
	likePlace like = (likePlace) request.getAttribute("info");
%>
<% 
ArrayList<Maplocation> maplist = (ArrayList<Maplocation>)request.getAttribute("maplist");
	ArrayList<vrBoard> list = (ArrayList<vrBoard>)request.getAttribute("list");
	 int listCount = ((Integer)request.getAttribute("listCount")).intValue();
	   int currentPage = ((Integer)request.getAttribute("currentPage")).intValue();
	   int startPage = ((Integer)request.getAttribute("startPage")).intValue();
	   int endPage = ((Integer)request.getAttribute("endPage")).intValue();
	   int maxPage = ((Integer)request.getAttribute("maxPage")).intValue();
	  
%>

<%-- <%
	Member member = (Member) session.getAttribute("member");
%> --%>
<html lang="en">

<head>
<style>
img#aaa{
	width : 700px;
	height : 300px;
}
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

div#cpage {
	margin: 0 auto;
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
	<div class="container">

		<h1 class="my-4">
			BEST <small>인기</small>
		</h1>

		<div align="center" width="80%">
			<div style="float: left; width: 33%;">
				<form action="/semi/bestplace">
					<button type="submit" id="btn11">장소</button>
					<input type="hidden" name="page" value=1>
				</form>
			</div>
			<div style="float: left; width: 33%;">
				<form action="/semi/bestres">
					<button type="submit" id="btn11">편의시설</button>
					<input type="hidden" name="page" value=1>
				</form>
			</div>
			<div style="float: left; width: 33%;">
				<form action="/semi/besthotel">
					<button type="submit" id="btn11">숙소</button>
					<input type="hidden" name="page" value=1>
				</form>
			</div>

		</div>
		<br> <br> <br> <br>
		<div align="center">

			<h3>BEST</h3>

		</div>
		<br> <br>

		<% for(vrBoard board:list){
			for(Maplocation map : maplist)  {
				if(board.getVrboardnum() == map.getMapnum()) {
        	 %>
		<div class="row">

			
			<div class="col-md-7">
				<a href="#"> <img class="img-fluid rounded mb-3 mb-md-0" id = "aaa"
					src="/semi/images/<%=map.getImagename() %>" alt=""></a>
				<div>
					<br>
				</div>
			</div>
			<div class="col-md-5">
				<h3><%=board.getVrboardtitle()%></h3>
				<p><%=board.getVrboardcontent()%></p>
				<a class="btn btn-primary" href="#">View Project</a>
			</div>
		</div>

		
<%} else {%>
<div class="row">

			
			<div class="col-md-7">
				<a href="#"> <img class="img-fluid rounded mb-3 mb-md-0" id = "aaa"
					src="/semi/images/<%=board.getVrboardoriginalfilename() %>" alt=""></a>
				<div>
					<br>
				</div>
			</div>
			<div class="col-md-5">
				<h3><%=board.getVrboardtitle()%></h3>
				<p><%=board.getVrboardcontent()%></p>
				<a class="btn btn-primary" href="#">View Project</a>
			</div>
		</div>
	<%}}}%>


<div align="center">
		<ul class="pagination justify-content-center">
			<%
				if (currentPage <= 1) {
			%>
			<li class="page-item"><a class="page-link" href="/semi/vrlist?page=1"
				aria-label="Previous"> <span aria-hidden="true">&laquo;</span> <span
					class="sr-only">Previous</span>
			</a></li>
			<%
				} else {
			%>
			<li class="page-item"><a class="page-link" href="/semi/vrlist?page=<%=currentPage - 1%>"
				aria-label="Previous"> <span aria-hidden="true">&laquo;</span> <span
					class="sr-only">Previous</span>
			</a></li>
			<%
				}
			%>
			<%--페이지 숫자 연속 출력 --%>
			<%
				for (int p = startPage; p <= endPage; p++) {
					if (p == currentPage) {
			%><li class="page-item"><a class="page-link" ><%=p%></a></li>
			<%
				} else {
			%>
			<li class="page-item"><a class="page-link" href="/semi/vrlist?page=<%=p%>"><%=p%></a></li>
			<%
				}
				}
			%>
			<%
				if (currentPage >= maxPage) {
			%>
			<li
				class="page-item"><a class="page-link" href="/semi/vrlist?page=<%=currentPage + 1%>"
					aria-label="Next"> <span aria-hidden="true">&raquo;</span> <span
						class="sr-only">Next</span>
				</a></li>
			<%
				} else {
			%>
			<li
				class="page-item"><a class="page-link" href="/semi/vrlist?page=<%=endPage%>"
					aria-label="Next"> <span aria-hidden="true">&raquo;</span> <span
						class="sr-only">Next</span>
				</a></li>
			<%
				}
			%>
		</ul>
	</div>
	</div>



	<!-- Bootstrap core JavaScript -->
	<script src="jquery/jquery.min.js"></script>
	<script src="jqueryintro/bootstrap.bundle.min.js"></script>
	<script src="jquery/bootstrap.bundle.min.js"></script>
	<%@ include file="../../footer.jsp"%>
</body>

</html>