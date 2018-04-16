<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>

	<!-- Basic Page Needs
  ================================================== -->
	<meta charset="utf-8">
	<title>Travel Stargram</title>
	<meta name="description" content="">
	<meta name="author" content="">

	<!-- Mobile Specific Metas
  ================================================== -->
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	
	
	
	<!-- CSS
  ================================================== -->
	<link rel="stylesheet" href="css/base.css"/>
	<link rel="stylesheet" href="css/skeleton.css"/>
	<link rel="stylesheet" href="css/layout.css"/>
	<link rel="stylesheet" href="css/font-awesome.css" />
	<link rel="stylesheet" href="css/retina.css"/>
	<link rel="stylesheet" href="css/animsition.min.css"/>
	

		
	<!-- Favicons
	================================================== -->
	<link rel="shortcut icon" href="favicon.png">
	<link rel="apple-touch-icon" href="apple-touch-icon.png">
	<link rel="apple-touch-icon" sizes="72x72" href="apple-touch-icon-72x72.png">
	<link rel="apple-touch-icon" sizes="114x114" href="apple-touch-icon-114x114.png">
	
<style>
#section2{
	display:none;
}
</style>
<script
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDDN_ZeJEqk0GSwGVnifo3i_evVo_V5UHk&callback=initMap"
		async defer></script>
<script type="text/javascript">
		var map;
		function initialize() {
			var myLatlng = new google.maps.LatLng(37,
					128);
			var myOptions = {
				zoom : 3,
				center : myLatlng,
				mapTypeId : google.maps.MapTypeId.ROADMAP
			}

			map = new google.maps.Map(document.getElementById("map_canvas"),
					myOptions);
			var japanLatlng = new google.maps.LatLng(37,139);
			var chinaLatlng = new google.maps.LatLng(35,104);
			var usaLatlng = new google.maps.LatLng(40,-101);
			var franchLatlng = new google.maps.LatLng(47,2);
			var vetnamLatlng = new google.maps.LatLng(15,108);
			var ukLatlng = new google.maps.LatLng(56,-3);
			placeMarker(myLatlng);
			placeMarker(japanLatlng);
			placeMarker(chinaLatlng);
			placeMarker(usaLatlng);
			placeMarker(franchLatlng);
			placeMarker(vetnamLatlng);
			placeMarker(ukLatlng);

		} // function initialize() 함수 끝

		// 마커 생성 합수
		function placeMarker(location) {
			var clickedLocation = new google.maps.LatLng(location);
			var marker = new google.maps.Marker({
				position : location,
				animation: google.maps.Animation.DROP,
				map : map
			});
			map.setCenter(location);
			
			/* function toggleBounce() {
				  if (marker.getAnimation() !== null) {
				    marker.setAnimation(null);
				  } else {
				    marker.setAnimation(google.maps.Animation.BOUNCE);
				  }
				}
			marker.addListener('click', toggleBounce); */
			google.maps.event.addListener(marker, 'click', function(event) {
				
				marker.setAnimation(google.maps.Animation.BOUNCE);
				var lat=marker.position.lat();
				var lng=marker.position.lng();
				marker.setAnimation(null);
				$('#worldh').val(lat+","+lng);
				console.log($('#worldh').val());
						jQuery.ajax({
							type : "post",
							data : {
								lat : lat,
								lng : lng
							}, 
							url : "aboutbest.do",
							dataType:"json",
							success : function(data) {
					               console.log("data : " + data);
					               //리턴된 하나의 객체를 문자열로 변환함
					               var jsonStr = JSON.stringify(data);
					               //변한된 문자열을 json 객체로 바꿈
					               var json = JSON.parse(jsonStr);
					               var cnt=1;
					               for(var i in json.list){
					            	  var str ="#aboutImg";
					            	  var strdiv ="#aboutDiv";
					            	  var strdivv ="#aboutDivv";
					            	  var lstr=str+cnt;
					            	  var lstrdiv=strdiv+cnt;
					            	  var lstrdivv=strdivv+cnt; 
					            	  
					            	  $(lstrdivv).html('<h6>'+decodeURIComponent(json.list[i].food_title,"UTF-8")+'</h6><p><span>'+decodeURIComponent(json.list[i].food_nation1,"UTF-8")+'/'+decodeURIComponent(json.list[i].food_nation2,"UTF-8")+'</span></p><ul class="skills-list">'+
													'<li><p><span>&#xf1db;</span>'+decodeURIComponent(json.list[i].food_writer,"UTF-8")+'</p></li><li><p><span>&#xf1db;</span>Interaction Design</p>'+
													'</li><li><p><span>&#xf1db;</span>Product Design</p></li><li><p><span>&#xf1db;</span>Website Design</p></li>'+
												'</ul><div class="social-team"><ul class="list-social-team"></ul></div>');
					            	  $(lstr).attr('src','/finalPro/images/'+json.list[i].food_original_filename);
					            	  $(lstr).attr('style',	'width:290px;height:290px');
					            	  var titile=decodeURIComponent(json.list[i].food_title).substring(1,3);
					            	  console.log(titile);
					            	  if(titile =="호텔"){
					            		  $(lstrdiv).attr('onclick','location.href="hotelpage.do?no='+json.list[i].food_no+'"');
					            	  }else if(titile =="음식"){
					            		  $(lstrdiv).attr('onclick','location.href="foodpage.do?no='+json.list[i].food_no+'"');
					            	  }else if(titile =="장소"){
					            		  $(lstrdiv).attr('onclick','location.href="spotpage.do?no='+json.list[i].food_no+'"');
					            	  }
					            	  
					            	  
					            	  cnt+=1;
					               }
					               $('#section2').attr('style','display:block');
					               document.getElementById("aboutfocus").scrollIntoView(); 
					               
							}
						});
			});
		}
		marker.setMap(map);
		
		
	</script>
	
	
</head>
<body onload="initialize()">	
<div class="animsition">
<c:import url="header.jsp"/>
	<!-- Primary Page Layout
	================================================== -->
	
	<section class="cd-section">
			<br><br><br><br><br><br><br><br>
			<h4>원하시는 지역을 클릭해주세요</h4><br>
			<div id="map_canvas" style="width:100%;height:1000px">		
			</div>
	</section> <!-- .cd-section --> 
	
	<br><br><br><br><br><br><br><br><br><br><br>
	<section class="section white-background padding-bottom hidden-sec" id="section2">
		<div class="container" id="aboutfocus">
				<input type="hidden" id="worldh">
				<div class="four columns">	
					<div class="team-wrap" id="aboutDiv1">	
						<img src="images/team1.jpg" alt="" id="aboutImg1">
						
						<div class="mask-team" id="aboutDivv1">
						</div>
					</div>	
				</div>
				<div class="four columns">	
					<div class="team-wrap" id="aboutDiv2">
						<img src="images/team2.jpg" alt="" id="aboutImg2">	
						<div class="mask-team" id="aboutDivv2">
						</div>
					</div>	
				</div>	
				<div class="four columns">	
					<div class="team-wrap" id="aboutDiv3">	
						<img src="images/team3.jpg" alt="" id="aboutImg3">
						<div class="mask-team" id="aboutDivv3">
						</div>
					</div>	
				</div>
				<div class="four columns">	
					<div class="team-wrap" id="aboutDiv4">
						<img src="images/team4.jpg" alt="" id="aboutImg4">	
						<div class="mask-team" id="aboutDivv4">
						</div>
					</div>	
				</div>
		</div>
	</section>

	
	
<c:import url="footer.jsp"/>
		
	</div>	

		
	<!-- JAVASCRIPT
    ================================================== -->
<script type="text/javascript" src="js/jquery.js"></script>	
<script type="text/javascript" src="js/modernizr.custom.js"></script> 
<script type="text/javascript" src="js/jquery.animsition.min.js"></script>
<script type="text/javascript">
(function($) { "use strict";
	$(document).ready(function() {
	  
	  $(".animsition").animsition({
	  
		inClass               :   'zoom-in-sm',
		outClass              :   'zoom-out-sm',
		inDuration            :    800,
		outDuration           :    800,
		linkElement           :   '.animsition-link', 
		// e.g. linkElement   :   'a:not([target="_blank"]):not([href^=#])'
		loading               :    true,
		loadingParentElement  :   'body', //animsition wrapper element
		loadingClass          :   'animsition-loading',
		unSupportCss          : [ 'animation-duration',
								  '-webkit-animation-duration',
								  '-o-animation-duration'
								],
		//"unSupportCss" option allows you to disable the "animsition" in case the css property in the array is not supported by your browser. 
		//The default setting is to disable the "animsition" in a browser that does not support "animation-duration".
		
		overlay               :   false,
		
		overlayClass          :   'animsition-overlay-slide',
		overlayParentElement  :   'body'
	  });
	});  
})(jQuery);
</script>
<script type="text/javascript" src="js/jquery.easing.js"></script>
<script type="text/javascript" src="js/retina-1.1.0.min.js"></script>
<script type="text/javascript" src="js/classie.js"></script>
<script type="text/javascript" src="js/cbpAnimatedHeader.min.js"></script>
<script type="text/javascript" src="js/menu.js"></script> 	
<script type="text/javascript" src="js/scroll.js"></script>
<script type="text/javascript" src="js/custom-about.js"></script>  	  
<!-- End Document
================================================== -->
</body>
</html>