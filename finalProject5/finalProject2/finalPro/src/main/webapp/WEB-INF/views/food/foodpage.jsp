<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<!--[if IE 8]><html class="no-js lt-ie9" lang="en"> <![endif]-->
<!--[if gt IE 8]>
<!-->
<html class="no-js" lang="en">
<!--<![endif]-->
<head>

<!-- Basic Page Needs
  ================================================== -->
<meta charset="utf-8">
<title>PALLAS</title>
<meta name="description" content="">
<meta name="author" content="">

<!-- Mobile Specific Metas
  ================================================== -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">



<!-- CSS
  ================================================== -->
<link rel="stylesheet" href="css/base.css" />
<link rel="stylesheet" href="css/skeleton.css" />
<link rel="stylesheet" href="css/layout.css" />
<link rel="stylesheet" href="css/font-awesome.css" />
<link rel="stylesheet" href="css/retina.css" />
<link rel="stylesheet" href="css/animsition.min.css" />



<!-- Favicons
	================================================== -->
<link rel="shortcut icon" href="favicon.png">
<link rel="apple-touch-icon" href="apple-touch-icon.png">
<link rel="apple-touch-icon" sizes="72x72"
	href="apple-touch-icon-72x72.png">
<link rel="apple-touch-icon" sizes="114x114"
	href="apple-touch-icon-114x114.png">

<style>
/* 이미지크기 버튼 */
#image {
	width: 70px;
	height: 70px;
	margin-left: 50px;
}

.left {
	width: 30%;
	height: 600px;
	float: left;
}

.right {
	width: 70%;
	height: 600px;
	float: left;
}

.max {
	width: 100%;
	height: 100%;
}

.center {
	width: 750px;
	height: 600px;
}
/* 버튼 추가  */
@import
	url(https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css)
	;

@import url(https://fonts.googleapis.com/css?family=Lato:300,400,700);

.jumbotron h1 {
	color: #353535;
}

span.icon {
	margin: 0 5px;
	color: #D64541;
}

h2 {
	color: #BDC3C7;
	text-transform: uppercase;
	letter-spacing: 1px;
}

.mrng-60-top {
	margin-top: 60px;
}
/* Global Button Styles */
a.bt.animated-button:link, a.animated-button:visited {
	position: relative;
	display: block;
	margin: 30px auto 0;
	padding: 14px 15px;
	color: #fff;
	font-size: 14px;
	font-weight: bold;
	text-align: center;
	text-decoration: none;
	text-transform: uppercase;
	overflow: hidden;
	letter-spacing: .08em;
	border-radius: 0;
	text-shadow: 0 0 1px rgba(0, 0, 0, 0.2), 0 1px 0 rgba(0, 0, 0, 0.2);
	-webkit-transition: all 1s ease;
	-moz-transition: all 1s ease;
	-o-transition: all 1s ease;
	transition: all 1s ease;
}

a.bt.animated-button:link:after, a.animated-button:visited:after {
	content: "";
	position: absolute;
	height: 0%;
	left: 50%;
	top: 50%;
	width: 150%;
	z-index: -1;
	-webkit-transition: all 0.75s ease 0s;
	-moz-transition: all 0.75s ease 0s;
	-o-transition: all 0.75s ease 0s;
	transition: all 0.75s ease 0s;
}

a.bt.animated-button:link:hover, a.bt.animated-button:visited:hover {
	color: #FFF;
	text-shadow: none;
}

a.bt.animated-button:link:hover:after, a.bt.animated-button:visited:hover:after
	{
	height: 450%;
}

a.bt.animated-button:link, a.bt.animated-button:visited {
	position: relative;
	display: block;
	margin: 30px auto 0;
	padding: 14px 15px;
	color: #fff;
	font-size: 14px;
	border-radius: 0;
	font-weight: bold;
	text-align: center;
	text-decoration: none;
	text-transform: uppercase;
	overflow: hidden;
	letter-spacing: .08em;
	text-shadow: 0 0 1px rgba(0, 0, 0, 0.2), 0 1px 0 rgba(0, 0, 0, 0.2);
	-webkit-transition: all 1s ease;
	-moz-transition: all 1s ease;
	-o-transition: all 1s ease;
	transition: all 1s ease;
}

/* Victoria Buttons */
a.bt.animated-button.victoria-two {
	border: 2px solid #D24D57;
}

a.bt.animated-button.victoria-two:after {
	background: #D24D57;
	-moz-transform: translateX(-50%) translateY(-50%) rotate(25deg);
	-ms-transform: translateX(-50%) translateY(-50%) rotate(25deg);
	-webkit-transform: translateX(-50%) translateY(-50%) rotate(25deg);
	transform: translateX(-50%) translateY(-50%) rotate(25deg);
}
</style>
<script type="text/javascript" src="/finalPro/js/jquery-3.3.1.min.js"></script>
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

	/* $(document).ready(function() {

		$('#replybtn').on('click', function(){
		 var str = $("#rform").serialize();
		/* var spcontent = document.getElementById("sp_content");
		 var spno = document.getElementById("no");
		var spwriter = document.getElementById("sp_writer"); 
		console.log(str);
		$.ajax({
		url : "spotreply.do",
		type : "post",
		data: str,
		dataType : "json",
		success : function(data) {
			var jsonStr = JSON.stringify(data);
			//변환된 문자열을 json 객체로 바꿈
			var json = JSON.parse(jsonStr);
			//console.log(jsonStr);

			var spotreplyHtml = "";

			for ( var i in json.list) {
				var spcontent = decodeURIComponent(json.list[i].spcontent);
				var spwriter = decodeURIComponent(json.list[i].spwriter);
				var spdate = json.list[i].spdate;

				spotreplyHtml += "<font size='2px;'>" + spcontent + "-"
						+ spwriter + "-" + spdate + "</font><br>";
			}
			
			$('#spotreplyview').append(spotreplyHtml);
		},
		error : function(request, status, errorData) {
			console.log("error code :" + request.status + "\n" + "message : "
					+ request.responseText + "\n" + "error : " + errorData);
		}
	});
	});
	}); */
	
	 function imgclick() {
			loginCheck();
	       var img = document.getElementById('image');  
	      if (img.src.match("heart")) {
	    	  console.log("${loginUser.member_id}");
	         $.ajax({
	        	type:"post",
	        	url: "likelist.do",
	        	data : {like_member : "${loginUser.member_id}" , like_place_code: "음식", like_place_no : "${foodOne.food_no}", action1 : "delete"  },
	        	dataType: "json",
	        	success:function(data){
	        		   img.src = "/finalPro/img/love.png";  
	        		
	        		 var jsonStr = JSON.stringify(data);
						//변환된 문자열을 json 객체로 바꿈
						var json = JSON.parse(jsonStr);

						var likelistSrc = "";

						for ( var i in json.list) {
							/*	 img.src = "/finalPro/img/love.png";
						 	var no =json.list[i].like_no;
							
							if(no = "${spotOne.s_no}"){
								 img.src = "/finalPro/img/heart.png";
							}else{
								 img.src = "/finalPro/img/love.png";
							} */
							/*  ("#divimg").html('<img src="img/love.png"  id="image" onclick="imgclick();">');  */
							console.log("좋아요 취소");
						}
	        		 
	        	}
	         });
	         
	         
	      } else {
	    	  console.log("${loginUser.member_id}");
	    	  $.ajax({
	        	type:"post",
	        	url: "likelist.do",
	        	data : {like_member : "${loginUser.member_id}" , like_place_code:"음식" , like_place_no :"${foodOne.food_no}", action1 : "insert" },
	        	dataType: "json",
	        	success:function(data){
	        		 
	        	     img.src = "/finalPro/img/heart.png";
	        	   
	        		 var jsonStr = JSON.stringify(data);
						//변환된 문자열을 json 객체로 바꿈
						var json = JSON.parse(jsonStr);

						var likelistSrc = "";

						for ( var i in json.list) {
							
							
							 /* 	var no =json.list[i].like_no;
							
							if(no = "${spotOne.s_no}"){
								 img.src = "/finalPro/img/heart.png";
							}else{
								 img.src = "/finalPro/img/love.png";
							}  */
							console.log("좋아요 ");
							/*  ("#divimg").html('<img src="img/heart.png"  id="image" onclick="imgclick();"'); */ 
						}
	        	}
	         });
	   
	      }
	   }
	
	 $.ajax({
	 	type:"post",
	 	url: "likelist.do",
	 	data : {like_member : "${loginUser.member_id}" , like_place_code: "음식", like_place_no : "${foodOne.food_no}", action1 : "none"  },
	 	dataType: "json",
	 	success:function(data){
	 		/*  img.src = "/finalPro/img/love.png"; */
	 		 console.log("리스트가져오기!");
	 		 var img = document.getElementById('image');  
		  
	 		 var jsonStr = JSON.stringify(data);
					//변환된 문자열을 json 객체로 바꿈
					var json = JSON.parse(jsonStr);

					for ( var i in json.list) {
						var no =json.list[i].like_no;
						 var imgHtml ="";
						if( "${foodOne.food_no}"== no){
							 img.src = "/finalPro/img/heart.png"; 
							/*  imgHtml = '<img src="img/heart.png"  id="image"  onclick="imgclick();">' */
							 break;
						}else{
							  img.src = "/finalPro/img/love.png"; 
							/*  imgHtml = '<img src="img/love.png"  id="image" onclick="imgclick();">' */
						}
						
					}
					/* ("#divimg").html(imgHtml);  */
	 	}/* ,
	 	error : function(result){
	 		console.log("리스트가 널!");
	 		 var img = document.getElementById('image'); 
	 		img.src = "/finalPro/img/love.png"; 
	 	} */
	  });
	
</script>
<style type="text/css">
.title {
	font-size: 30px;
	color: black;
}

.title.hover {
	color: orange;
}
</style>
</head>
<body>

	<div class="animsition">

		<!-- MENU
    ================================================== -->


		<div id="menu-wrap" class="menu-back cbp-af-header">
			<div class="container">
				<div class="sixteen columns">
					<div id="leftDiv" style="float: left; width: 50%;">
						<a href="about.jsp" class="title">TravleStargram</a>
					</div>
					<div id="rightDiv" style="text-align: right;">
						<c:if test="${empty sessionScope.loginUser }">

							<a href="loginForm.do" class="animsition-link"
								style="cursor: pointer;">로그인</a>&nbsp;
                  <a href="enrollForm.do" class="animsition-link"
								style="cursor: pointer;">회원가입</a>
						</c:if>
						<c:if test="${!empty sessionScope.loginUser }">

							<a href="#" class="animsition-link" style="cursor: pointer;">
								${loginUser.member_name } 님</a>&nbsp;
                  <a href="logout.do" class="animsition-link"
								style="cursor: pointer;">로그아웃</a>
						</c:if>
					</div>


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

						<li><a href="#">Review</a>
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
		<script type="text/javascript" src="js/jquery.js"></script>
		<script type="text/javascript" src="js/modernizr.custom.js"></script>
		<script type="text/javascript" src="js/jquery.animsition.min.js"></script>
		<script type="text/javascript">
			(function($) {
				"use strict";
				$(document)
						.ready(
								function() {

									$(".animsition")
											.animsition(
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
														unSupportCss : [
																'animation-duration',
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

		<%--  <c:import url="../../../header.jsp"></c:import> --%>
		<!-- Primary Page Layout
	================================================== -->


		<section class="section white-background projects-padding-top-bottom">
			<div class="container">
				<div class="sixteen columns">
					<div class="section-header-text">
						<h4>${foodOne.food_title }</h4>

						<div class="line-header"></div>
					</div>
				</div>
				<div class="sixteen columns">
					<div class="section-project-text">
						<p>Donec vel mi sem. Etiam in nulla arcu, ut vehicula velit.
							Vivamus dapibus rutrum mi ut aliquam. In hac habitasse platea
							dictumst. Integer sagittis neque a tortor tempor in porta sem
							vulputate. Donec varius felis fermentum nisl imperdiet at
							molestie purus porta.</p>

					</div>
				</div>
			</div>
		</section>

		<section class="section white-background">


			<div class="center" style="margin-left: 25%; word-break: break-all">
				<div class="image-auto-wraper right">
					<div style="position: absolute">
						<div style="position: relative; z-index: 1;">
							<img src="images/${foodOne.food_original_filename}" alt="" style="width:500px;height:350px">
						</div>
					</div>
					<div style="position: absolute;">
						<div style="position: relative; right: 5px; z-index: 33;">
							<img src="img/love.png" id="image" onclick="imgclick();">
						</div>
					</div>
					<div style="position:absolute;top:60%">
						<font size="3px">${foodOne.food_content }</font>
					</div>
				</div>

				<div class="left" style="overflow-y: auto;">
					<div id="foodreplyview">
						<c:forEach var="foo" items="${replyList}" varStatus="status">
							<font size="2px;"> ▶${foo.fo_content} [${foo.fo_writer}]
								-${foo.fo_date} <c:if
									test="${loginUser.member_id eq foo.fo_writer }">

									<a style="color: black;"
										href="deletefoodreply.do?fo_no=${foo.fo_no}&fo_ref_no=${foo.fo_ref_no}">&nbsp;&nbsp;X</a>


								</c:if>
							</font>
							<br>
						</c:forEach>
					</div>
					<c:if test="${!empty loginUser.member_id }">


						<!--  <a href="#" class="bt  animated-button victoria-two">Good !</a>  -->
						<!-- 						<img src="img/star.png"> -->

						<form name="rform" id="rform" action="insertfoodreply.do">
							&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" id="fo_content"
								placeholder="댓글입력..."
								style="border-top: none; border-left: none; border-right: none;"
								name="fo_content"> <input type="hidden" id="fo_ref_no"
								name="fo_ref_no" value="${foodOne.food_no}"> <input
								type="hidden" id="fo_writer" name="fo_writer"
								value="${loginUser.member_id}"> <input type="submit"
								id="replybtn" value="등록">
						</form>
						<c:if
							test="${loginUser.member_id eq foodOne.food_writer or loginUser.member_id eq 'admin' }">

							<input type="submit" id="replybtn" value="삭제"
								onclick="document.location.href='deletefood.do?no=${foodOne.food_no}&nation1=${foodOne.food_nation1}'">

						</c:if>
					</c:if>
				</div>

			</div>



		</section>



		<footer class="footer no-shadow">
			<div class="container">
				<div class="sixteen columns">
					<div class="footer-social">
						<a href="#">twitter</a> <a href="#">github</a> <a href="#">facebook</a>
						<a href="#">google +</a>
					</div>
				</div>
			</div>
			<div class="container">
				<div class="sixteen columns">
					<div class="footer-copy-text">
						<p>© We are Pallas. All rights reserved. 2015</p>
						<p>Made by IG Design in Kraljevo, Serbia</p>
					</div>
				</div>
			</div>
		</footer>

	</div>


	<!-- JAVASCRIPT
    ================================================== -->
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
		});
		
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
	<script type="text/javascript">
		(function($) {
			"use strict";

			//Navigation	

			$('ul.slimmenu').on('click', function() {
				var width = $(window).width();
				if ((width <= 1200)) {
					$(this).slideToggle();
				}
			});
			$('ul.slimmenu').slimmenu({
				resizeWidth : '1200',
				collapserTitle : '',
				easingEffect : 'easeInOutQuint',
				animSpeed : 'medium',
				indentChildren : true,
				childrenIndenter : '&raquo;'
			});
		})(jQuery);
	</script>
	<script type="text/javascript" src="js/scroll.js"></script>
	<!-- End Document
================================================== -->
</body>
</html>