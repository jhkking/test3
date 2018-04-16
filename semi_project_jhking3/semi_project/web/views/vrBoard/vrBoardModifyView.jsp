<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="vrBoard.model.vo.*"%>
<%
	vrBoard Board = (vrBoard) request.getAttribute("Board");
	VrBoardDetail detail = (VrBoardDetail) request.getAttribute("detail");
	/* int boardnum=((Integer)request.getAttribute("boardnum")).intValue(); */
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
table#ttt{
	width : 700px;
}
*{
	margin : 0 auto;
}
button#btn11{
	width : 80px;
	height : 40px;
}
 img{
  width : 600px;
  height : 500px;
} 
input[type=file]{
	padding:10px;
	background:light gray;
}

div.workerRight{
	/* float : left; */
	/* width : 30%; */
	/* background : yellow; */
	border : 1px solid lightgray;
}
div.workerLeft{
	/* float : left; */
	width : 60%;
	/* background : blue; */
	border : 1px solid lightgray;
	align : center;
	cellspacing : 10px; 
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


.modal-dialog {
	width: 450px;
	height: 350px;
}

#divv {
	/* width: 100%; */
	height: 52px;
	background: #f3f6f7;
	border: 1px solid gray;
	margin-top: 30;
	padding-top: 9px;
}
div.row {
margin : 0 auto;
}
#td_name {
	color: white;
}
</style>
<script type="text/javascript">
function readURL(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();
        var fname=document.frm1.myfile.value;
        
        reader.onload = function (e) {
            $('#blah').attr('src', e.target.result);
        };
        $('#imgsrc').attr('value', fname);
        reader.readAsDataURL(input.files[0]);
    }
}
</script>
</head>


<body>
<%@ include file="../../header.jsp"%>


	<!-- Navigation -->
	


	<!-- Page Content -->
	<div class="container">
		<!-- Page Heading/Breadcrumbs -->
		<h1 class="mt-4 mb-3">
			Admin <small>Board 글 수정</small>
		</h1>
		<br>
		<!-- Content Row -->
		<div class="row">
			<!-- Sidebar Column -->
			<div class="workerLeft">
				<table align="center" id = "ttt">
					<tr align="center">
						<td>
							<h3>[사진]</h3>
						</td>
					</tr>
					<tr align="center">
						<td>
							<!-- 여기에 사진 올리기 -->
							<form method="post" name="frm1">

								<input type='file' id  = 'myfile' class = 'myfile' onchange="readURL(this);">

								<!-- <br><font size = 2>미리 보기 할 수 있습니다.</font> -->
								<br>
								<br> <img id="blah"
									src="/semi/images/<%=Board.getVrboardoriginalfilename() %>" alt="your image"
									width="100%" height="100%" />

							</form> <br>
						<br>
						</td>

					</tr>
				</table>
			</div>

			<form action="/semi/vrmodify2">
				<input type="hidden" id="imgsrc" name="imgsrc" value="">
				<!-- Content Column -->
				<div class="workerRight">
					<table>
						<tr align="center">
							<td>
								<h3>[정보]</h3>
							</td>
						</tr>
						<tr align="center">
							<td>
							<input type = "hidden" name = "boardnum" value = <%=Board.getVrboardnum() %>>
							<%if(Board.getVrcode().equals("명소")) {%>
								<br> <br> 카테고리 : <select
								name="searchoption">
								
									<option value="명소" selected>장소</option>
									<option value="편의시설">편의시설</option>
									<option value="숙소">숙소</option>
							</select> 
							<%} else if(Board.getVrcode().equals("편의시설")) {%>
							<br> <br> 카테고리 : <select
								name="searchoption">
								
									<option value="명소">장소</option>
									<option value="편의시설" selected>편의시설</option>
									<option value="숙소">숙소</option>
							</select> 
							<%} else {%>
							<br> <br> 카테고리 : <select
								name="searchoption">
								
									<option value="명소">장소</option>
									<option value="편의시설">편의시설</option>
									<option value="숙소" selected>숙소</option>
							</select> 
							<%} %>
							<br>
							<br>
							<br> 제목 : <input type="text" name="title" value=<%=Board.getVrboardtitle() %>> <br>
							<br>
							<br> 작성자 : <input type="text" name="writer" value="admin01" readonly>
								<br>
							<br>
							<br> 주소 : <input type="text" name="address" value=<%=detail.getVrdetailaddress() %>> <br>
							<br>
							<br> 영업 시간 : <input type="text" name="opentime"
								value=<%=detail.getVropentime() %>> <br>
							<br>
							<br> 전화 번호 : <input type="text" name="phone" value=<%=detail.getVrphone() %>> <br>
							<br>
							<br> 홈페이지 주소 : <input type="text" name="homepage" value=<%=detail.getVrhomepage() %>> <br>
							</td>
						</tr>
					</table>
				</div>
		
		<div align="center">
			<br>
			<br>
			<br>
			<button type="submit" id="btn11">수정완료</button>

		</div>
		</form>
		<!-- /.row -->

	</div>
</div>
<br><br><br><br>
	<!-- Bootstrap core JavaScript -->
	<%@ include file="../../footer.jsp"%>
</body>
</html>
