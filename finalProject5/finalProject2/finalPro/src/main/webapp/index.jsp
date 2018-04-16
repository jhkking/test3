
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

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
	
	<c:import url="header.jsp"/>
	<!-- Primary Page Layout
	================================================== -->

	<section class="cd-section">
		<div class="cd-block">
			<div class="home-top">
				<div class="cd-intro">
					<h1>Great strategy build <br>great <span>brands</span></h1>
				</div>
				
				<div class="small-text">- specialized in brand experience -</div>
				
				<div class="social-top">
					<ul class="list-social">
						<li class="icon-soc tipped" data-title="twitter"  data-tipper-options='{"direction":"top","follow":"true"}'>
							<a href="#">&#xf099;</a>
						</li>
						<li class="icon-soc tipped" data-title="facebook"  data-tipper-options='{"direction":"top","follow":"true"}'>
							<a href="#">&#xf09a;</a>
						</li>
						<li class="icon-soc tipped" data-title="github"  data-tipper-options='{"direction":"top","follow":"true"}'>
							<a href="#">&#xf09b;</a>
						</li>
						<li class="icon-soc tipped" data-title="google +"  data-tipper-options='{"direction":"top","follow":"true"}'>
							<a href="#">&#xf0d5;</a>
						</li>
					</ul>	
				</div>		
				
				<a href="#scroll-link" class="scroll scroll-down"></a>
				
			</div>
		</div>
	</section> <!-- .cd-section -->

	<section class="cd-section" id="scroll-link">
		<div class="cd-block">
			<div class="cd-half-block"></div>

			<div class="cd-half-block">
				<div class="block-text">
					<h2>About Us<span>.</span></h2>
					<p>We believe in coming up with original ideas and turning them into digital work that is both innovative and measurable. Taking on thought-provoking projects that challenge us creatively and make us go the extra mile is what we consider a way of life.</p>
					<a href="about.html" class="btn animsition-link">find out more</a>
				</div>
			</div>
		</div>
	</section> <!-- .cd-section -->

	<section class="cd-section">
		<div class="cd-block">
			<div class="cd-half-block"></div>

			<div class="cd-half-block">
				<div class="block-text">
					<h2>Portfolio<span>.</span></h2>
					<p>We are relentless in moving boundaries and carry out this spirited attitude into digital solutions. Digital solutions that engage, inspire and make you think. Make you curious.</p>
					<a href="work.html" class="btn animsition-link">discover</a>
				</div>
			</div>
		</div>
	</section> <!-- .cd-section -->

	<section class="cd-section">
		<div class="cd-block">
			<div class="cd-half-block"></div>

			<div class="cd-half-block">
				<div class="block-text">
					<h2>Jurnal<span>.</span></h2>
					<p>Real stories revealed for you, the reader. Cum magnis dis parturient montes, nascetur ridiculus mus. Suspendisse sed ligula. Sed volutpat odio non turpis gravida luctus. Praesent elit pede, iaculis facilisis, vehicula mattis, tempus non, arcu.</p>
					<a href="blog.html" class="btn animsition-link">read articles</a>
				</div>
			</div>
		</div>
	</section> <!-- .cd-section -->

	<section class="cd-section">
		<div class="cd-block">
			<div class="cd-half-block"></div>

			<div class="cd-half-block">
				<div class="block-text">
					<h2>Contact<span>.</span></h2>
					<p>For projects, ideas, collaborations or anything else don’t hesitate to get in touch with us. Or just say hello.</p>
					<a href="contact.html" class="btn animsition-link">get in touch</a>
				</div>
			</div>
		</div>
	</section> <!-- .cd-section -->
	<nav>
		<ul class="cd-vertical-nav">
			<li><a href="#0" class="cd-prev inactive"></a></li>
			<li><a href="#0" class="cd-next inactive1"></a></li>
		</ul>
	</nav> <!-- .cd-vertical-nav -->
	
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
<script type="text/javascript" src="js/animated-headline.js"></script>	
<script type="text/javascript" src="js/jquery.fs.tipper.min.js"></script>	
<script type="text/javascript" src="js/custom-home1.js"></script>  	  
<!-- End Document
================================================== -->



</body>
</html>