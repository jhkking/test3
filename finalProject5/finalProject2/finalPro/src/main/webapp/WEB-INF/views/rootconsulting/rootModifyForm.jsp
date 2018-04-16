<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList "  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<title>rootModify</title>
<script src="http://code.jquery.com/jquery-1.5.js"></script>
<link href="/finalPro/bootstrap-3.0.0/css/bootstrap.min.css" rel="stylesheet"
	id="bootstrap-css">
<script src="/finalPro/bootstrap-3.0.0/js/bootstrap.min.js"></script>
<!-- <script src="//code.jquery.com/jquery-1.11.1.min.js"></script> -->
<script src="js/jquery-1.11.1.min.js"></script>
<script src="/finalPro/js/classie.js"></script>
<style type="text/css">
.rcontainer {
	margin-top: 120px;
}
.formDiv{
	/* text-align: center; */
	margin-left:17%;
}

.stepwizard-step p {
	margin-top: 10px;
}

.stepwizard-row {
	display: table-row;
}

.stepwizard {
	display: table;
	width: 100%;
	position: relative;
}

.stepwizard-step button[disabled] {
	opacity: 1 !important;
	filter: alpha(opacity = 100) !important;
}

.stepwizard-row:before {
	top: 58px;
	bottom: 0;
	position: absolute;
	content: " ";
	width: 100%;
	height: 3px;
	background-color: #ccc;
	z-order: 0;
}

.stepwizard-step {
	display: table-cell;
	text-align: center;
	position: relative;
}

.btn-circle {
	width: 50px;
	height: 50px;
	text-align: center;
	padding: 6px 0;
	font-size: 18px;
	line-height: 1.8;
	border-radius: 30px;
	border: 4px solid #ccc;
	font-weight: bold;
}

.btn-circle-small {

	width: 12px;
	height: 12px !important;
	text-align: center;
	padding: 6px 0;
	font-size: 18px;
	line-height: 1.8;
	border-radius: 20px;
	background-color: #ccc;
}

.btn-circle-small-right {
	
	width: 12px;
	height: 12px !important;
	text-align: center;
	padding: 6px 0;
	font-size: 18px;
	line-height: 1.8;
	border-radius: 20px;
	background-color: #ccc;
	float: right !important
}

.adv_blue {
	background-color: #0069aa;
}

.adv_orange {
	background-color: #f8981d;
	color: #fff;
}

.adv_grey {
	background-color: #fff;
	color: #ccc;
}


/* 추가 */
figure.snip1141 {

  position: relative;
  float: left; 
  overflow: hidden;
  margin: 10px 1%; 
  min-width: 350px;
  max-width: 350px;
  max-height: 200px; 
  min-height: 200px;
  /* width: 100%; */
  background: #000000;
  color: #ffffff;
  text-align: left;
  box-shadow: 0 0 5px rgba(0, 0, 0, 0.15);
}

figure.snip1141 * {
  -webkit-box-sizing: border-box;
  box-sizing: border-box; 
  -webkit-transition: all 0.4s ease-in-out;
  transition: all 0.4s ease-in-out;
}

figure.snip1141 img {
  /* max-width: 100%; */
  /* position: relative; */
  opacity: 0.9;
}

figure.snip1141 .circle {
  position: relative;
  height: 55px;
  width: 55px;
  top: 0%;
  left: 0%;
  background-color: rgba(0, 0, 0, 0.4);
  border-radius: 50%;
  text-align: center;
}

figure.snip1141 .circle:before,
figure.snip1141 .circle:after {
  border: 2px solid white;
  border-right-color: transparent;
  position: absolute;
  content: '';
  height: 100%;
  width: 100%;
  top: 0;
  left: 0;
  border-radius: 50%;
  -webkit-box-sizing: border-box;
  box-sizing: border-box;
  -webkit-transition: all 0.35s ease-in-out;
  transition: all 0.35s ease-in-out;
  -webkit-transition-delay: 0.3s;
  transition-delay: 0.3s;
}

figure.snip1141 .circle:before {
  -webkit-transform: rotate(45deg);
  transform: rotate(45deg);
}

figure.snip1141 .circle:after {
  -webkit-transform: rotate(-45deg);
  transform: rotate(-45deg);
}

figure.snip1141 figcaption {
  position: absolute;
  top: 20px;
  left: 20px;
  display: block;
  width: 100%;
  overflow: hidden;
}

figure.snip1141 h6 {
color : white;
  position: absolute;
  margin: 0;
  text-transform: uppercase;
  font-weight: 300;
  letter-spacing: -1px;
  line-height: 55px;
  top: 0%;
  left: 0%;
  width: 100%;
  padding: 0 20px;
  opacity: 0;
  -webkit-transform: translateX(-10%);
  transform: translateX(-10%);
}

figure.snip1141 .icon {
  overflow: hidden;
  width: 100%;
  position: absolute;
}

figure.snip1141 i {
  color: white;
  font-size: 48px;
  line-height: 55px;
  -webkit-transition-delay: 0.3s;
  transition-delay: 0.3s;
}

figure.snip1141 a {
  left: 0;
  right: 0;
  top: 0;
  bottom: 0;
  position: absolute;
  z-index: 1;
}

figure.snip1141:hover .circle,
figure.snip1141.hover .circle {
  background-color: rgba(0, 0, 0, 0);
}

figure.snip1141:hover .circle:before,
figure.snip1141.hover .circle:before,
figure.snip1141:hover .circle:after,
figure.snip1141.hover .circle:after {
  -webkit-transform: rotate(0deg);
  transform: rotate(0deg);
  -webkit-transition-delay: 0s;
  transition-delay: 0s;
}

figure.snip1141:hover h6,
figure.snip1141.hover h6 {
  opacity: 1;
  -webkit-transition-delay: 0.3s;
  transition-delay: 0.3s;
  -webkit-transform: translateX(0);
  transform: translateX(0);
}

figure.snip1141:hover img,
figure.snip1141.hover img {
  opacity: 0.35;
  -webkit-transform: scale(1.1);
  transform: scale(1.1);
}

figure.snip1141:hover i,
figure.snip1141.hover i {
  opacity: 0;
  -webkit-transition-delay: 0s;
  transition-delay: 0s;
}

</style>
</head>
<body>
<c:import url="../../../header.jsp"></c:import>
	<div class="rcontainer">

		<div class="stepwizard col-md-offset-1">

			<div class="stepwizard-row setup-panel">
				<div class="btn-circle-small"></div>
				<c:forEach var="i"  begin="1" end="${lastday}" step="1">
					<c:if test="${i eq 1}">
						<div class="stepwizard-step">
							<a href="#step-${i}" id="one" type="button"
									class="btn  btn-circle adv_blue" >${i}</a>
							<h6>Day ${i}</h6>
						</div>
					</c:if>
					<c:if test="${i ne 1}">
						<div class="stepwizard-step">
							<a href="#step-${i}" type="button"
								class="btn btn-primary btn-circle adv_blue">${i}</a>
							<h6>Day ${i}</h6>
						</div>
					</c:if>
				</c:forEach>
				<div class="btn-circle-small-right f-right"></div>
			</div>
		</div>
		<div class="formDiv">
		<!-- Consent begin -->
			<c:forEach var="mrd" items="${mrdetaillist }" varStatus="status">
			<input type="hidden" name="hidday" value="${status.count}">
				<div class="row setup-content" id="step-${status.count}">
					<div class="col-md-10 col-md-offset-1">
						<div class="col-md-12">
							<h3>Day ${status.count}</h3> 
							<form id="rootform${status.count}" enctype="multipart/form-data" method="POST" action="rootmodifylast.do">
							<div class="panel panel-default">
								<!-- Default panel contents -->
								<div class="panel-body" >
								
									<table border="0">
										<tr>
											<th>지역</th>
											<td>&nbsp;&nbsp;<input type="text"  class="na1" name="mr_nation1"  value="${mrd.mr_nation1 }"> </td>
											<th>　　　　세부지역</th>
											<td>&nbsp;&nbsp;<span id="s2"><input type="text"  class="na2" name="mr_nation2"
												value="${mrd.mr_nation2}" ></span></td>
										</tr>
										<tr>
									<td colspan="2"><p class="p1" >검색결과</p></td>
										</tr>
									</table>
								</div>
							</div>
				
							<font size="3" style="color: #F89406">관광지</font>
							<hr style="margin-bottom: 15px; border-color: #F89406">
							<span class="span11" ></span><br><br><br>
					
							<br><font size="3" style="color: #F89406">음식</font>
							<hr style="margin-bottom: 15px; border-color: #F89406">
							<span class="span22" ></span><br><br><br>
					
				
							<br><font size="3" style="color: #F89406">숙박</font>
							<hr style="margin-bottom: 15px; border-color: #F89406">
							<span class="span33" ></span><br><br><br><br><br><br><br><br><br>
				
							
							<div class="panel panel-default">
							
										<b style="float: left; margin-top: 20px; margin-bottom: 10px; margin-left: 30px;">제목
											: <input type="text" size="50" name="mr_title" style="border: 0;height:40px" id="ftitleid1"  value="${mrd.mr_title}" readonly>
										</b>
									
										<br>
										<br>
							<hr style="clear:both;">
							<div style="text-align:center; margin-top : 20px;">
							<textarea rows="5" cols="100" placeholder="내용 입력..." style="border:0;" name="mr_content">${mrd.mr_content}</textarea>
							 <%-- <input type="hidden" name = "lastday" value="${diffDays+1}"> --%>
							<input type="hidden"  name="mr_writer" value="${loginUser.member_id}">
							<input type="hidden" name="mr_day"  value="${status.count}">
							<br><input type="file" class="btn btn-default" name="uploadFile" style="width:100%" value="${mrd.mr_original_filename}">
							</div>
							</div>
						
							<hr>
							<!-- Split button -->
							<div class="btn-group">
								<c:if test="${status.count eq lastday}">
									<!-- <button class="btn btn-primary nextBtn btn-lg pull-left"
										type="button">Back</button> -->
									<a onclick="submit1('${status.count}')" class="btn btn-success btn-lg pull-right" >Root Save</a>
									<!-- <input type="submit" class="btn btn-success btn-lg pull-right" value="Root Save"> -->
								</c:if>
								<c:if test="${status.count ne lastday}">
									<!-- <button class="btn btn-primary nextBtn btn-lg pull-left"
										type="button">Back</button> -->
									<button class="btn btn-primary nextBtn btn-lg pull-left" type="button" onclick="saveList('${status.count}');">Next</button>

								</c:if>
							</div>
					</form>
						</div>

					</div>
					<!-- Split button end -->
				</div>
			</c:forEach>
			<!-- Step 1 end -->

			<!-- 			<div class="row setup-content" id="step-2">
				<div class="row col-md-offset-1">
					<h3>Primary Taxpayer Information</h3>
				</div>
				start
				<div class="col-md-3 col-md-offset-1">
					<div class="col-md-12">
						<div class="form-group">
							<label class="control-label">First Name</label> <input
								maxlength="200" type="text" required="required"
								class="form-control" placeholder="Enter Company Name" />
						</div>
						<div class="form-group">
							<label class="control-label">Company Address</label> <input
								maxlength="200" type="text" required="required"
								class="form-control" placeholder="Enter Company Address" />
						</div>
						<button class="btn btn-primary nextBtn btn-lg pull-left"
							type="button">Next</button>
					</div>
				</div>

			</div>


			<div class="row setup-content" id="step-3">
				<div class="col-xs-6 col-md-offset-3">
					<div class="col-md-12">
						<h3>Step 3</h3>
						<button class="btn btn-success btn-lg pull-right" type="submit">Submit</button>
					</div>
				</div>
			</div> -->
		<!-- </form> -->
		</div>

	</div>
	<script>
		function submit1(day){
			var str="#rootform"+day;
			$(str).submit();
		}	
	</script>
	<script>
		$(document)
				.ready(
						function() {
							var navListItems = $('div.setup-panel div a'), allWells = $('.setup-content'), allNextBtn = $('.nextBtn');

							allWells.hide();

							navListItems
									.click(function(e) {
										e.preventDefault();
										var $target = $($(this).attr('href')), $item = $(this);

										if (!$item.hasClass('disabled')) {
											navListItems.removeClass(
													'btn-primary').addClass(
													'btn-default');
											$item.addClass('btn-primary');
											allWells.hide();
											$target.show();
											$target.find('input:eq(0)').focus();
										}
									});

							allNextBtn
									.click(function() {
										var curStep = $(this).closest(
												".setup-content"), curStepBtn = curStep
												.attr("id"), nextStepWizard = $(
												'div.setup-panel div a[href="#'
														+ curStepBtn + '"]')
												.parent().next().children("a"), curInputs = curStep
												.find("input[type='text'],input[type='url']"), isValid = true;

										$(".form-group").removeClass(
												"has-error");
										for (var i = 0; i < curInputs.length; i++) {
											if (!curInputs[i].validity.valid) {
												isValid = false;
												$(curInputs[i]).closest(
														".form-group")
														.addClass("has-error");
											}
										}

										if (isValid)
											nextStepWizard.removeAttr(
													'disabled')
													.trigger('click');
									});

							$('div.setup-panel div a.btn-primary').trigger(
									'click');
						});

	</script>
	<c:import url="../../../footer.jsp" />
<script type="text/javascript">
$(".na1").keyup(
		function() {
			value = $(this).val();
$(".p1").text(value+"  검색 결과");

$.ajax({
						type : "post",
						url : "spotReco.do",
						data : {
							s_nation1 : value
						},
						dataType : "json",
						success : function(data) {

							console.log("spotReco 리스트가져오기!"
									+ value);
							var spotHtml = "";

							var jsonStr = JSON.stringify(data);
							//변환된 문자열을 json 객체로 바꿈
							var json = JSON.parse(jsonStr);
							if (json.list != null) {
								for ( var q in json.list) {
									var sTitle = decodeURIComponent(json.list[q].spreco_nation);
									var sImg = decodeURIComponent(json.list[q].spreco_origin_filename);
									console.log("list : "
											+ sTitle + ", "
											+ sImg);
									if (q % 2 == 1) {
										spotHtml += "<figure class='snip1141'><img src='/finalPro/images/"+sImg+"' width='350px' height='200px' /><figcaption><div class='circle'><i class='ion-ios-plus-empty'></i></div><h6>"+sTitle+"</h6></figcaption></figure><br>";
									} else {
										spotHtml += "<figure class='snip1141'><img src='/finalPro/images/"+sImg+"' width='350px' height='200px' /><figcaption><div class='circle'><i class='ion-ios-plus-empty'> </i></div><h6>"+sTitle+"</h6></figcaption></figure>";
									}
								}
								
								console.log("html : "
										+ spotHtml);
								$(".span11").html(
										spotHtml.replaceAll(
												"+", " "));
							}

						},
						error : function(data) {
							$(".span11")
									.html(
											"<font size='2'>검색 결과 없음 !</font>");
						}
					});

			$
					.ajax({
						type : "post",
						url : "foodReco.do",
						data : {
							food_nation1 : value
						},
						dataType : "json",
						success : function(data) {

							console.log("foodReco 리스트가져오기!"
									+ value);
							var foodHtml = "";

							var jsonStr = JSON.stringify(data);
							//변환된 문자열을 json 객체로 바꿈
							var json = JSON.parse(jsonStr);
							if (json.list != null) {
								for ( var q in json.list) {
									var sTitle = decodeURIComponent(json.list[q].foodreco_nation);
									var sImg = decodeURIComponent(json.list[q].foodreco_origin_filename);
									console.log("list : "
											+ sTitle + ", "
											+ sImg);
									if (q % 2 == 1) {
										foodHtml +="<figure class='snip1141'><img src='/finalPro/images/"+sImg+"' width='350px' height='200px' /><figcaption><div class='circle'><i class='ion-ios-plus-empty'> </i></div><h6>"+sTitle+"</h6></figcaption></figure><br>";
									} else {
										foodHtml += "<figure class='snip1141'><img src='/finalPro/images/"+sImg+"' width='350px' height='200px' /><figcaption><div class='circle'><i class='ion-ios-plus-empty'> </i></div><h6>"+sTitle+"</h6></figcaption></figure>";
									}
								}
								console.log("html : "
										+ foodHtml);
								$(".span22").html(
										foodHtml.replaceAll(
												"+", " "));
							}

						},
						error : function(data) {
							$(".span22")
									.html(
											"<font size='2'>검색 결과 없음 !</font>");
						}
					});

			$
					.ajax({
						type : "post",
						url : "hotelReco.do",
						data : {
							h_nation1 : value
						},
						dataType : "json",
						success : function(data) {

							console.log("hotelReco 리스트가져오기!"
									+ value);
							var hotelHtml = "";

							var jsonStr = JSON.stringify(data);
							//변환된 문자열을 json 객체로 바꿈
							var json = JSON.parse(jsonStr);
							if (json.list != null) {
								for ( var q in json.list) {
									var sTitle = decodeURIComponent(json.list[q].hotelreco_nation);
									var sImg = decodeURIComponent(json.list[q].hotelreco_origin_filename);
									console.log("list : "
											+ sTitle + ", "
											+ sImg);
									if (q % 2 == 1) {
										hotelHtml +="<figure class='snip1141'><img src='/finalPro/images/"+sImg+"' width='350px' height='200px' /><figcaption><div class='circle'><i class='ion-ios-plus-empty'> </i></div><h6>"+sTitle+"</h6></figcaption></figure><br>";
									} else {
										hotelHtml += "<figure class='snip1141'><img src='/finalPro/images/"+sImg+"' width='350px' height='200px' /><figcaption><div class='circle'><i class='ion-ios-plus-empty'> </i></div><h6>"+sTitle+"</h6></figcaption></figure>";
									}
								}
								console.log("html : "
										+ hotelHtml);
								$(".span33").html(
										hotelHtml.replaceAll(
												"+", " "));
							}

						},
						error : function(data) {
							$(".span33")
									.html(
											"<font size='2'>검색 결과 없음 !</font>");
						}
					});

			String.prototype.replaceAll = function(org, dest) {
				return this.split(org).join(dest);
			}
		}).keyup();
</script>
<script src="https://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<script type="text/javascript">
    $(document).ready(function(){
      $('#one').trigger('click');
    });
</script>
<script type="text/javascript">
  
	function saveList(day){
	/* 	var day = document.getElementsByName('hidday').value; */
		var str = "rootform"+ day;
		console.log(str);
		  var rootform = new FormData(document.getElementById(str));
			/* var ftitle = document.getElementById('ftitleid1').value; */
    $.ajax({
		  url : "rootmodify.do",
		  type : "post",
		  data : rootform,
		  /* data : {mr_title : m_title , mr_content : m_content, mr_nation1 : m_nation1 , mr_nation2 : m_nation2 , mr_writer : m_writer , mr_day : m_day}, */
		  processData: false, 
		  contentType: false,                                                                                                        
		  success  : function(data){
			 /*  toastr.success('Root 저장 완료 !'); */
			  console.log("ok");
		  }
	  });
/*     $(".d11").html('<b style="float: left; margin-top: 20px; margin-bottom: 10px; margin-left: 30px;">제목: <input type="text" name="mr_title" size="50" value="'+ftitle+'" readonly></b>');
 */	};
	
/* 		function saveListLast(){

			  var rootform = new FormData(document.getElementById('rootform'));

	    $.ajax({
			  url : "rootinsertLast.do",
			  type : "post",
			  data : rootform,
			  processData: false, 
			  contentType: false,
			  success  : function(data){
			
				 console.log("ok");
			  }
		  })
		 };  */
		 
</script>
</body>
</html>