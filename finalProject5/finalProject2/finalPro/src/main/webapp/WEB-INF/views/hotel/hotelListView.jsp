
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!--[if IE 8]><html class="no-js lt-ie9" lang="en"> <![endif]-->
<!--[if gt IE 8]>
<!--><html class="no-js" lang="en"><!--<![endif]-->
<head>

	<!-- Basic Page Needs
  ================================================== -->
	<meta charset="utf-8">
	<title>PALLAS</title>
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
	
	
	
</head>
<body>	

	<div class="animsition">
	
	<!-- MENU
    ================================================== -->	
<c:import url="../../../header.jsp"></c:import>
		
	<!-- Primary Page Layout
	================================================== -->


	<section class="section white-background portfolio-padding-top-bottom-1">
	<br>
	<a style="margin-left:85%; font-size:15px; color:black;" href="hotelinsertview.do">글쓰기</a>
	
	
	
		
	
			<div id="projects-grid">
				<c:forEach var="ho" items="${hotelList}" varStatus="status">
				<a href="hotelpage.do?no=${ho.h_no}" class="animsition-link">
					<div class="portfolio-box-1 branding">
						<div class="mask-1" style="width:450px; height:340px;"></div>
						<img style="width:450px;height:340px;" src="images/${ho.h_original_filename} " alt="">
						<h6>${ho.h_title}</h6>
						<div class="line-mask"></div>
						<p>${ho.h_address}</p>
					</div>
				</a>
					</c:forEach>
			</div>
		
			
	</section>
	

		
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
<script type="text/javascript" src="js/imagesloaded.pkgd.min.js"></script> 
<script type="text/javascript" src="js/masonry.js"></script> 
<script type="text/javascript" src="js/isotope.js"></script> 
<script type="text/javascript" src="js/custom-work2.js"></script>  	  
<!-- End Document
================================================== -->
<c:import url="../../../footer.jsp"></c:import>
</body>
</html>