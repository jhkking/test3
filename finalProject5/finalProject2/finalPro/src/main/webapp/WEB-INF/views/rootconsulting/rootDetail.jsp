<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>   
<html>

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Resume - Start Bootstrap Theme</title>
<style type="text/css">
#sideNav{
margin-top : 110px;
}
.cccontainer-fluid {
margin-top : 110px;
align : center;
}

#left{
width : 100%;
height : 85%;
content:"";
background-image: url('img/osaka.png') ;
background-repeat:no-repeat;
background-position:center;
background-origin:content-box;
background-size: 100%;
filter:alpha(opacity=30);
}

</style>

    <!-- Bootstrap core CSS -->
    <link href="travelpage/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
   <!-- 좌측 글씨와 사진 틀이 사라지고 div가 합쳐짐 -->

    <!-- Custom fonts for this template -->
    <link href="https://fonts.googleapis.com/css?family=Saira+Extra+Condensed:100,200,300,400,500,600,700,800,900" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i" rel="stylesheet">
    <link href="travelpage/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <link href="travelpage/css/resume.min.css" rel="stylesheet">

  </head>

<body id="page-top">

<c:import url="../../../header.jsp" />

<div width="100%" height = "100%">
    <nav class="navbar navbar-expand-lg navbar-dark bg-primary fixed-top" id="sideNav">
      <a class="navbar-brand js-scroll-trigger" href="#page-top">
      
        <span class="d-block d-lg-none">Start Bootstrap</span>
        <span class="d-none d-lg-block">
        <%-- <c:when test="${}"> <!-- 사진이 있다면 -->
          <img class="img-fluid img-profile rounded-circle mx-auto mb-2" src="img/profile.jpg" alt="">
          </c:when> --%>
          <%-- <c:otherwise><!-- 사진이 없다면 -->
          	<img class="img-fluid img-profile rounded-circle mx-auto mb-2" src="img/default.jpg" alt="">
          </c:otherwise> --%>
          <img class="img-fluid img-profile rounded-circle mx-auto mb-2" src="img/mimg/${writerImg}" alt="">
        </span>
      </a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav">
          <li class="nav-item">
            <a class="nav-link js-scroll-trigger" href="#">${mrdetail[0].mr_nation1 }</a>
          </li>
            <c:forEach var="mr"  items="${mrdetail}" varStatus="status">
          <li class="nav-item">
            <a class="nav-link js-scroll-trigger" href="#day${mr.mr_day}">Day${mr.mr_day}</a>
          </li>
          </c:forEach> 
        </ul>
      </div>
    </nav>

    <div class="cccontainer-fluid ppp" >


      <section class="resume-sectionnn p-3 p-lg-5 d-flex d-column" id="nation">
        <div id = "left" align = "center"  >
        <br><br><br>
        <div align = "center">
        <br><br>
          <font size ="15" color = "black"><b>${mrdetail[0].mr_nation1 }_</b></font>
           <font size ="7" color = "#bd5d38"><b>${mrdetail[0].mr_nation2}</b></font>
          
          </div>
          <br><br>
          <div class="subheading mb-5"><font size ="15" color = "black"><b>${mrdetail[0].mr_writer }</b></font><br><br>
            <a href="#"><font style="size : 3; font-family: 맑은고딕; color : gray;">[<b>${lastday-1}박 ${lastday}일</b>]</font></a>
          </div><br>
          <p class="mb-5"><font size ="8" color = "orange">${mrdetail[0].mr_title }</font></p>
          <ul class="list-inline list-social-icons mb-0">
            <li class="list-inline-item">
              <a href="#">
                <span class="fa-stack fa-lg">
                  <i class="fa fa-circle fa-stack-2x"></i>
                  <i class="fa fa-facebook fa-stack-1x fa-inverse"></i>
                </span>
              </a>
            </li>
            <li class="list-inline-item">
              <a href="#">
                <span class="fa-stack fa-lg">
                  <i class="fa fa-circle fa-stack-2x"></i>
                  <i class="fa fa-twitter fa-stack-1x fa-inverse"></i>
                </span>
              </a>
            </li>
            <li class="list-inline-item">
              <a href="#">
                <span class="fa-stack fa-lg">
                  <i class="fa fa-circle fa-stack-2x"></i>
                  <i class="fa fa-linkedin fa-stack-1x fa-inverse"></i>
                </span>
              </a>
            </li>
            <li class="list-inline-item">
              <a href="#">
                <span class="fa-stack fa-lg">
                  <i class="fa fa-circle fa-stack-2x"></i>
                  <i class="fa fa-github fa-stack-1x fa-inverse"></i>
                </span>
              </a>
            </li>
          </ul>
        </div>
      </section>


 <c:forEach var="mr" items="${mrdetail}" varStatus="status">
      <section class="resume-sectionnn p-3 p-lg-5 d-flex flex-column" id="day${mr.mr_day }">
        <div class="my-auto">
        <br><br><br>
          <h2 class="mb-5"><font color = "#bd5d38">${mr.mr_day } 일차</font></h2>

          <div class="resume-item d-flex flex-column flex-md-row mb-5">
            <div  style="width: 100%;" align = "center">
              <h3 class="mb-0" align = "center">[  ${mr.mr_title }  ]</h3>
                <div style="width: 100%;">
                <br>
				    <img src="/finalPro/images/${review.r_original_filename}" style="width:1100px; height:500px;  vertical-align: middle" />
				</div>
				<br>
              <font size = "5px" color = "black">▶<b>${mr.mr_content }</b></font>
            </div>
            
          </div>

        </div>

      </section>
      </c:forEach> 
    </div>
</div>
<c:import url="../../../footer.jsp"/>
  </body>
</html>