<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link href="bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet"
	id="bootstrap-css">
<script src="bootstrap-3.3.7/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">


function imgmove(smallImg , fday, num){
   /* var smallImg = document.getElementsByName("imagesmall").src; */
   var bigImg = document.getElementById("imagebig");
   var day = document.getElementById("day");
   console.log(smallImg);
   bigImg.src = "images/"+smallImg;
   
   contentmove(fday,num);
}



/* function contentmove(fday,num){
   console.log(fday+",  "+num);
   $.ajax({
   type:"post",
   url: "fdetialone.do",
   data : {day : fday , ref :num},
   dataType: "json",
   success:function(data){
       console.log("가져오기!" + fday +","+num);
       var jsonStr = JSON.stringify(data);
        var json = JSON.parse(jsonStr);
        var title = json.title;
     
        $(".ftitle").html("<p>"+title+"</p>")
         },
         error : function(request,status,error) {
            alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
         }
      });

} */

jQuery(document).ready(function($) {
    
 /*    $('#myCarousel').carousel({
           interval: 5000 
    });  */

    //Handles the carousel thumbnails 
    $('[id^=carousel-selector-]').click(function () {
    var id_selector = $(this).attr("id");
    try {
        var id = /-(\d+)$/.exec(id_selector)[1];
        console.log(id_selector, id);
        jQuery('#myCarousel').carousel(parseInt(id));
    } catch (e) {
        console.log('Regex failed!', e);
    }
});
    // When the carousel slides, auto update the text
    $('#myCarousel').on('slid.bs.carousel', function (e) {
             var id = $('.item.active').data('slide-number');
            $('#carousel-text').html($('#slide-content-'+id).html());
    });
});
</script>
<style>
table.type09 {
	border-collapse: collapse;
	text-align: left;
	line-height: 1.5;
}

table.type09 thead th {
	padding: 10px;
	font-weight: bold;
	vertical-align: top;
	color: #369;
	border-bottom: 3px solid #036;
}

table.type09 tbody th {
	width: 200px;
	padding: 10px;
	font-weight: bold;
	vertical-align: top;
	border-bottom: 1px solid #ccc;
	background: #f3f6f7;
}

table.type09 tbody td {
	width: 400px;
	padding: 10px;
	vertical-align: top;
	border-bottom: 1px solid #ccc;
}

table.type09 td {
	width: 50px;
	padding: 10px;
	vertical-align: top;
	border-bottom: 1px solid #ccc;
}
</style>

<style type="text/css">
.box1 {
	float: left;
}

.box2 {
	display: inline-block;
}

.hide-bullets {
	list-style: none;
	margin-left: -40px;
	margin-top: 20px;
}

.thumbnail {
	padding: 0;
}

.carousel-inner>.item>img, .carousel-inner>.item>a>img {
	width: 100%;
}
</style>
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<title>Insert title here</title>
</head>
<body>

	<c:import url="../../../header.jsp" />

	<!------ Include the above in your HEAD tag ---------->


	<div class="container" style="margin-top: 200px">
		<div id="main_area">
			<!-- Slider -->
			<div class="row">
				<div class="col-sm-6" id="slider-thumbs">
					<!-- Bottom switcher of slider -->
					<ul class="hide-bullets">

						<c:forEach var="fb" items="${feedbackOneList}" varStatus="status">
							<li class="col-sm-3"><a class="thumbnail"
								onclick="imgmove( '${fb.f_original_filename}','${fb.f_day}','${fb.f_no}');">
									<img src="images/${fb.f_original_filename}" name="imagesmall">
							</a></li>
						</c:forEach>





					</ul>
				</div>
				<div class="col-sm-6">
					<div class="col-xs-12" id="slider">
						<!-- Top part of the slider -->
						<div class="row">

							<div class="col-sm-12" id="carousel-bounding-box">
								<div class="carousel slide" id="myCarousel">
									<!-- Carousel items -->
									<div class="carousel-inner">
										<div style="width: 550px; height: 440px;" class="active item"
											data-slide-number="0">
											<c:forEach var="fb1" items="${feedbackOneList}"
												varStatus="status">
												<c:if test="${status.index eq 0 }">
													<img src="images/${fb1.f_original_filename}" id="imagebig">
												</c:if>
											</c:forEach>

										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>

				<!--/Slider-->
				<div style="margin-left: 25%;">
					<table class="type09">
						<thead>
							<c:forEach var="fl" items="${feedbackOneList }"
								varStatus="status">
								<tr>
									<c:if test="${status.index eq 0 }">
										<th class="ftitle" scope="cols"><font color="black">제목:${fl.f_title }</font></th>
										<th id="writer" scope="cols"><font color="black">작성자:${fl.f_writer }</font>
										</td>
									</c:if>
								</tr>
						</thead>
						<tr>
							<th scope="row"><font color="black"> ${status.index  + 1}
									일차</font></th>
							<td id="content"><font color="black">내용:${fl.f_content }</font></td>
							<%-- <div id ="content">내용:${fl.f_content }</div> --%>
						</tr>
						</c:forEach>

					</table>
					<div>
						<br>
						<font color="black">댓글</font><br>

						<table class="type09">
							<thead>
								<tr>


									<th scope="cols">내용</th>

									<th scope="cols">작성자</th>
									<th scope="cols">날짜</th>

									<th scope="cols">삭제</th>

								</tr>
							</thead>


							<c:forEach var="fr" items="${freplyList}" varStatus="status">
								<tr>


									<td style="width: 60%">${fr.fr_content}</td>

									<td style="width: 10%">${fr.fr_writer}</td>
									<td style="width: 10%">${fr.fr_date}</td>
									<c:if test="${loginUser.member_id eq fr.fr_writer }">
										<td style="width: 10%"><a style="color: blue;"
											href="deletefeedbackreply.do?fr_no=${fr.fr_no}&fr_ref_no=${fr.fr_ref_no}">&nbsp;&nbsp;X</a>
										</td>
									</c:if>
									<c:if test="${loginUser.member_id ne fr.fr_writer }">
										<td></td>
									</c:if>


								</tr>
							</c:forEach>



						</table>
						<br>


						<c:if test="${!empty loginUser.member_id }">


							<form action="insertfeedbackreply.do" method="post">

								<div class="box1">
									<input type="text" id="fr_content" style="height: 50px;"
										size="100px;" placeholder="댓글입력..."
										style="border-top: none; border-left: none; border-right: none;"
										name="fr_content"> <input type="hidden" id="fr_ref_no"
										name="fr_ref_no" value="${feedNo}"> <input
										type="hidden" id="fr_writer" name="fr_writer"
										value="${loginUser.member_id}">
									<div class="box2">
										<input type="submit" class="feedreplybtn" value="등록">

									</div>
								</div>
							</form>

						</c:if>

					</div>
				</div>

			</div>


		</div>
	</div>
	<c:import url="../../../footer.jsp" />
</body>
</html>