<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="vrBoard.model.vo.vrBoard"%>
<%@ page import="likePlace.model.vo.*, java.util.*, vrBoard.model.vo.*"%>
<%-- <%
	vrBoard board = (vrBoard) request.getAttribute("info");
%> --%>
<%
	likePlace like = (likePlace) request.getAttribute("info");
%>
<% 
	ArrayList<vrBoard> list = (ArrayList<vrBoard>)request.getAttribute("placelist");
	ArrayList<Maplocation> maplist = (ArrayList<Maplocation>)request.getAttribute("maplist");
	 int listCountpl = ((Integer)request.getAttribute("listCountpl")).intValue();
	   int currentPagepl = ((Integer)request.getAttribute("currentPagepl")).intValue();
	   int startPagepl = ((Integer)request.getAttribute("startPagepl")).intValue();
	   int endPagepl = ((Integer)request.getAttribute("endPagepl")).intValue();
	   int maxPagepl = ((Integer)request.getAttribute("maxPagepl")).intValue();
	  /*  String placeName = (String)request.getAttribute("place");
	   String title = (String)request.getAttribute("title");
	  int bno = ((Integer)request.getAttribute("bnum")).intValue(); */
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
	function noMember(){
		alert("회원만 이용가능합니다!\n로그인을 해주세요!");
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
			BEST <small>인기</small>
		</h1>
	
		<div align="center" width="80%" >
		<div style="float: left; width: 33%;">
		<form action = "/semi/bestplace">
			<button type = "submit" id="btn11" autofocus>장소</button>
			<input type = "hidden" name = "page" value =1>

		</form>
		</div>
		<div style="float: left; width: 33%;">
		<form action = "/semi/bestres">
			<button type = "submit" id="btn11">편의시설</button>
			<input type = "hidden" name = "page" value =1>

		</form>
		</div>
		<div style="float: left; width: 33%;">
		<form action = "/semi/besthotel">
			<button type = "submit" id="btn11" >숙소</button>
			<input type = "hidden" name = "page" value =1>

		</form>
		</div>

		</div>
		<br>
		<br>
		<br>
		<br>
		<div align = "center">

		<h3>명소</h3>

		</div>
		<br>
		<br>
			<!-- Project One -->


			<% for(vrBoard r : list){
				for(Maplocation map : maplist)  {
				if(r.getVrboardnum() == map.getMapnum()) {%>
			
		<div class="row">

			<div class="col-md-7">
				<a href="#"> <img class="img-fluid rounded mb-3 mb-md-0" id = "aaa"
					src="/semi/images/<%=map.getImagename() %>" alt=""></a>
				<div>
					<br>
				</div>
			</div>
			<div class="col-md-5">
				<h3><%=r.getVrboardtitle()%></h3>

				<p><%=r.getVrboardcontent()%></p>
				   <% if (member != null) { %>
               				<a class="btn btn-primary" href="/semi/vrimg?place=<%=r.getVrboardtitle().substring(0,2)%>&title=<%=r.getVrboardtitle()%>&userid=<%=member.getSmemberId()%>&bno=<%=r.getVrboardnum()%>">상세보기</a>

                  <%
                  } else {
               %>
              <a class="btn btn-primary" onclick="noMember();">상세보기</a>
               
                  <%} %>
			</div>


		</div>
		<%
				}}}
		%>
	<div align="center">
		<ul class="pagination justify-content-center">
			<%
				if (currentPagepl <= 1) {
			%>
			<li class="page-item"><a class="page-link" href="/semi/bestplace?page=1"
				aria-label="Previous"> <span aria-hidden="true">&laquo;</span> <span
					class="sr-only">Previous</span>
			</a></li>
			<%
				} else {
			%>
			<li class="page-item"><a class="page-link" href="/semi/bestplace?page=<%=currentPagepl - 1%>"
				aria-label="Previous"> <span aria-hidden="true">&laquo;</span> <span
					class="sr-only">Previous</span>
			</a></li>
			<%
				}
			%>
			
			<%
				for (int p = startPagepl; p <= endPagepl; p++) {
					if (p == currentPagepl) {
			%><li class="page-item"><a class="page-link" ><%=p%></a></li>
			<%
				} else {
			%>
			<li class="page-item"><a class="page-link" href="/semi/bestplace?page=<%=p%>"><%=p%></a></li>
			<%
				}
				}
			%>
			<%
				if (currentPagepl >= maxPagepl) {
			%>
			<li
				class="page-item"><a class="page-link" href="/semi/bestplace?page=<%=currentPagepl + 1%>"
					aria-label="Next"> <span aria-hidden="true">&raquo;</span> <span
						class="sr-only">Next</span>
				</a></li>
			<%
				} else {
			%>
			<li
				class="page-item"><a class="page-link" href="/semi/bestplace?page=<%=endPagepl%>"
					aria-label="Next"> <span aria-hidden="true">&raquo;</span> <span
						class="sr-only">Next</span>
				</a></li>
			<%
				}
			%>
		</ul>
	</div> 

	<!-- 여기부터 -->


</div>
	

	<!-- Bootstrap core JavaScript -->
	<script src="jquery/jquery.min.js"></script>
	<script src="jqueryintro/bootstrap.bundle.min.js"></script>
	<script src="jquery/bootstrap.bundle.min.js"></script>
	
	<%@ include file="../../footer.jsp"%>
</body>

</html>