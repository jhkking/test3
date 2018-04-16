<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>header</title>
<link rel="stylesheet" href="css/base.css" />
<link rel="stylesheet" href="css/skeleton.css" />
<link rel="stylesheet" href="css/layout.css" />
<link rel="stylesheet" href="css/font-awesome.css" />
<link rel="stylesheet" href="css/retina.css" />
<link rel="stylesheet" href="css/animsition.min.css" />
<link rel="stylesheet" href="css/animsition.min.css" />
<link rel="stylesheet" href="css/animsition.min.css" />

<link rel="shortcut icon" href="favicon.png">
<link rel="apple-touch-icon" href="apple-touch-icon.png">
<link rel="apple-touch-icon" sizes="72x72"
	href="apple-touch-icon-72x72.png">
<link rel="apple-touch-icon" sizes="114x114"
	href="apple-touch-icon-114x114.png">
<style type="text/css">
.title {
	font-size: 30px;
	color: black;
}

.title.hover {
	color: orange;
}

.headimg {
	width: 40px;
	height: 40px;
}

.headimg2 {
	width: 30px;
	height: 30px;
}

.arrow_box {
	display: none;
	position: absolute;
	padding: 16px;
	-webkit-border-radius: 8px;
	-moz-border-radius: 8px;
	border-radius: 8px;
	background: #333;
	color: #fff;
	width: 90px;
}

.arrow_box:after {
	position: absolute;
	bottom: 100%;
	left: 50%;
	width: 0;
	height: 0;
	margin-left: -40px;
	border: solid transparent;
	border-color: rgba(51, 51, 51, 0);
	border-bottom-color: #333;
	border-width: 10px;
	pointer-events: none;
	content: " ";
}

.hspan:hover+p.arrow_box {
	display: block;
}
</style>

<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="bootstrap-3.3.7/js/bootstrap.min.js"></script>
<!-- <script>
     $(document).ready(function() {  
      
         console.log("아작");
         var id1 = document.getElementById("loginU2").value;
         console.log(id1);
         jQuery.ajax({
            type : "post",
            data : {LoginId:id1},
            url : "headermsg.do",
            success: function(data){
               if(data=="ok"){
                  console.log("아작~");
                  var rs=$('#msgdiv').html();
                  rs+="<img src='/finalPro/img/newimg2.png' class='hnewimg'/>";
                  $('#msgdiv').html(rs);
               }
            },
            error: function(request, status, errorData){
               alert("error code : " + request.status + "\n"
                  + "message : " + request.responseText + "\n"
                  + "error : " + errorData);
            }
         });
         
      
         
    
    });
</script> -->
<script type="text/javascript">
	$
			.ajax({
				url : "nationlist.do",
				type : "post",
				dataType : "json",
				success : function(data) {

					var jsonStr = JSON.stringify(data);
					//변환된 문자열을 json 객체로 바꿈
					var json = JSON.parse(jsonStr);

					var nationHtml = "";

					for ( var i in json.list) {
						var sNation = decodeURIComponent(json.list[i].nation1);
						console.log(sNation);
						nationHtml += '<li class="dropdown"><a href="#" class="animsition-link">'
							+ sNation
							+ '　　　　　</a><ul class="dropdown-menu dropdown-menu-right"><li><a href="foodlist.do?nation1='
							+ sNation
							+ '" class="animsition-link" width=50px>음식점　　　　</a></li><li><a href="hotellist.do?nation1='
							+ sNation
							+ '" class="animsition-link">숙소　　　　</a></li><li><a href="slist.do?nation1='
							+ sNation
							+ '" class="animsition-link">관광지　　　　</a></li></ul></li>';
					/*  '<li class="dropdown"><a href="#" class="animsition-link">'+ sNation　+'　　</a><ul class="dropdown-menu dropdown-menu-right"><li><a href="work2.jsp" class="animsition-link" width=50px>음식점</a></li><li><a href="work2.jsp" class="animsition-link">숙소</a></li><li><a href="work2.jsp" class="animsition-link">관광지</a></li></ul></li>'*/
					}
					$("#nationName").html(nationHtml);
				}
			});
</script>
</head>
<body>

	<!-- MENU
    ================================================== -->

	<div id="menu-wrap" class="menu-back cbp-af-header">
		<div class="container">
			<div class="sixteen columns">

				<a href="about.jsp" class="title"> <tt style="color: red">T</tt>
					<tt style="color: #E26812">r</tt>
					<tt style="color: #FDE102">a</tt> <tt style="color: #03A200">v</tt>
					<tt style="color: #030AF5">e</tt>
					<tt style="color: #094B6E">l</tt> <tt style="color: #82108D">S</tt>
					<tt style="color: red">t</tt>
					<tt style="color: #E26812">a</tt> <tt style="color: #FDE102">r</tt>
					<tt style="color: #03A200">g</tt>
					<tt style="color: #030AF5">r</tt> <tt style="color: #094B6E">a</tt>
					<tt style="color: #82108D">m</tt>
				</a>
				<c:if test="${empty sessionScope.loginUser }">
					<a href="enrollForm.do" style="float: right;"><span
						class="hspan"><img class="headimg"
							src="/finalPro/img/clipboard.png" style="margin-right: 20px;"></span>
					<p class="arrow_box" style="margin-top: 10px;">회원가입</p></a>
					<a href="loginForm.do" style="float: right;"><span
						class="hspan"><img class="headimg"
							src="/finalPro/img/left.png" style="margin-right: 20px;"></span>
					<p class="arrow_box" style="margin-top: 10px;">로그인</p></a>
				</c:if>
				<c:if test="${!empty sessionScope.loginUser }">


					<h6 style="float: right;">
						<tt style="color: #6496F3">${loginUser.member_name }</tt>
						님 환영합니다.
					</h6>

					<br>
					<br>
					<a href="logout.do" style="float: right;"><span class="hspan"><img
							class="headimg2" src="/finalPro/img/logout.png"></span>
					<p class="arrow_box" style="margin-top: 10px;">로그아웃</p></a>
					<a href="mupdateForm.do?member_id=${loginUser.member_id }"
						style="float: right;"><span class="hspan"><img
							class="headimg2" src="/finalPro/img/info.png"></span>
					<p class="arrow_box" style="margin-top: 10px;">정보수정</p></a>



					<c:if test="${loginUser.member_id eq 'admin'}">
						<a href="admin.do?currentPage=1" style="float: right;"><span
							class="hspan"><img class="headimg"
								src="/finalPro/img/card.png"></span>
							<p class="arrow_box">회원 관리</p></a>

					</c:if>
					<div style="float: right;" id="msgdiv">
						<!-- <img src="/finalPro/img/newimg.png" class="hnewimg"/>-->
						<c:if test="${!empty loginUser }">
							<a href="msg.do?loginId=${loginUser.member_id }"><span
								class="hspan"><img class="headimg"
									src="/finalPro/img/open.png"></span>
								<p class="arrow_box">쪽지함</p></a>
							<input type="hidden" id="loginU2" value="${loginUser.member_id }">
						</c:if>
					</div>


					<a href="block.do" style="float: right;"><span class="hspan"><img
							class="headimg" src="/finalPro/img/police.png"
							style="margin-top: -10px;"></span>
						<p class="arrow_box" style="margin-top: 10px;">신고하기</p></a>
				</c:if>

				<br>

				<ul class="slimmenu">

					<li><a class="active-menu animsition-link" href="about.jsp">Home</a></li>

					<li><a href="#">Nation</a>
						<ul class="submenu-back">
							<p id="nationName"></p>
							<%--       <%-- <c:forEach var="na" items="${nationlist}" varStatus="status">
                        <li class="dropdown"><a href="#" class="animsition-link"><p id="nationName"></p>　</a>
                           <ul class="dropdown-menu dropdown-menu-right">
                              <li><a href="work2.jsp" class="animsition-link" width=50px>음식점</a></li>
                              <li><a href="work2.jsp" class="animsition-link">숙소</a></li>
                              <li><a href="work2.jsp" class="animsition-link">관광지</a></li>
                              </ul>
                              </li>
                                 </c:forEach> --%>
						</ul></li>

					<li><a href="">Review</a>
						<ul class="submenu-back">
							<li><a href="rlist.do" class="animsition-link"
								onclick="loginCheck();">Review</a></li>
							<li><a href="flist.do" class="animsition-link"
								onclick="loginCheck();">Feedback</a></li>
						</ul></li>
					<li><a href="" class="animsition-link">Rootconsulting</a>
						<ul class="submenu-back">
							<li><a href="datecheck.do" class="animsition-link"
								onclick="loginCheck();">new root </a></li>
							<li><a href="myrootlist.do?id=${loginUser.member_id}"
								class="animsition-link" onclick="loginCheck();">my root </a></li>
						</ul></li>

					<li><a href="nlist.do" class="animsition-link">Notice</a></li>
					<li><a href="qlist.do" class="animsition-link">Q&A</a></li>
				</ul>
			</div>
		</div>
	</div>
	<script>
		$(document)
				.ready(
						function() {
							if ($('#loginU2').val() != null) {
								console.log("아작");
								var id1 = document.getElementById("loginU2").value;
								console.log(id1);
								jQuery
										.ajax({
											type : "post",
											data : {
												loginId : id1
											},
											url : "headermsg.do",
											success : function(data) {
												if (data == "ok") {
													console.log("아작~");
													var rs = $('#msgdiv')
															.html();
													rs += '<img src="/finalPro/img/newimg2.png" class="hnewimg"/>';
													$('#msgdiv').html(rs);
												}
											},
											error : function(request, status,
													errorData) {
												alert("error code : "
														+ request.status + "\n"
														+ "message : "
														+ request.responseText
														+ "\n" + "error : "
														+ errorData);
											}
										});
							}

						});
	</script>

	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/modernizr.custom.js"></script>
	<script type="text/javascript" src="js/jquery.animsition.min.js"></script>
	<script type="text/javascript">
		(function($) {
			"use strict";
			$(document).ready(
					function() {

						$(".animsition").animsition(
								{

									inClass : 'zoom-in-sm',
									outClass : 'zoom-out-sm',
									inDuration : 800,
									outDuration : 800,
									linkElement : '.animsition-link',
									// e.g. linkElement   :   'a:not([target="_blank"]):not([href^=#])'
									loading : true,
									loadingParentElement : 'body', //animsition wrapper element
									loadingClass : 'animsition-loading',
									unSupportCss : [ 'animation-duration',
											'-webkit-animation-duration',
											'-o-animation-duration' ],
									//"unSupportCss" option allows you to disable the "animsition" in case the css property in the array is not supported by your browser. 
									//The default setting is to disable the "animsition" in a browser that does not support "animation-duration".

									overlay : false,

									overlayClass : 'animsition-overlay-slide',
									overlayParentElement : 'body'
								});
					});
		})(jQuery);
	</script>
	<script>
   function loginCheck() {
      if(${ loginUser.member_id == null}) {
        alert(" 로그인하셔야 합니다.");   
        document.location.href ="loginForm.do";
      }
    };  
  </script> 
	<script type="text/javascript" src="js/jquery.easing.js"></script>
	<script type="text/javascript" src="js/retina-1.1.0.min.js"></script>
	<script type="text/javascript" src="js/classie.js"></script>
	<script type="text/javascript" src="js/cbpAnimatedHeader.min.js"></script>
	<script type="text/javascript" src="js/menu.js"></script>
	<script type="text/javascript" src="js/scroll.js"></script>
	<script type="text/javascript" src="js/animated-headline.js"></script>
	<script type="text/javascript" src="js/jquery.fs.tipper.min.js"></script>
	<script type="text/javascript" src="js/custom-home1.js"></script>

</body>
</html>