<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
   <%@ page import="vrBoard.model.vo.vrBoard, java.util.*"%>
<%-- <% 
   ArrayList<vrBoard> list = (ArrayList<vrBoard>)request.getAttribute("list"); 
%>
<% 
   ArrayList<vrBoard> hotellist = (ArrayList<vrBoard>)request.getAttribute("hotellist");

%>
<% 
   ArrayList<vrBoard> placelist = (ArrayList<vrBoard>)request.getAttribute("placelist");

%>
<% 
   ArrayList<vrBoard> reslist = (ArrayList<vrBoard>)request.getAttribute("reslist");

%> --%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
   content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>WhybiS</title>
<style>
   div#divvv {

   background: #f3f6f7;
   border: 1px solid gray;
}
input#inputt{
 border : none;border-right:0px; border-top:0px; boder-left:0px; boder-bottom:0px;background: #f3f6f7;text-align:center;
}
img#divvvimg{
   /* float : right; */
   width : 60px;
   height : 60px;
}
inpupt#inputt{
   float : left;
   width : 50%;
}
</style>

<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
   $(function() {
      
      //메인 슬라이드
      $.ajax({
         url : "/semi/introbest",
         type : "get",
         dataType : "json",
         success : function(data) {

   var value = "<div class='carousel-item active'   style='background-image: url(/semi/images/"+decodeURIComponent(data.placetitle1pic1)+")'><div class='carousel-caption d-none d-md-block'><h3><p id = 'mainP1'></p></h3>   <p id = 'mainPA1'></p>   </div>   </div>   <div class='carousel-item'   style='background-image: url(/semi/images/" + decodeURIComponent(data.placetitle1pic2) + ")'>   <div class='carousel-caption d-none d-md-block'><h3><p id = 'mainP2'></p></h3>   <p id = 'mainPA2'></p></div>   </div><div class='carousel-item'   style='background-image: url(/semi/images/"+decodeURIComponent(data.placetitle1pic3)+")'>   <div class='carousel-caption d-none d-md-block'><h3><p id = 'mainP3'></p></h3>   <p id = 'mainPA3'></p></div>   </div>";

/*  var value = "<div class='carousel-item active'   style='background-image: url(http://post.phinf.naver.net/MjAxNzEyMjlfMTMx/MDAxNTE0NTM1MjYwMTQy.B_DrNLREgsEyUa2_mLkIT204tSXaO2z268dGojeITWgg.rcaMA_UB9zjVfpymMAk_iWtPq074FYPLpvj7ARQC_RYg.JPEG/2.jpg?type=w1200)'><div class='carousel-caption d-none d-md-block'><h3><p id = 'mainP'></p></h3>   <p id = 'mainPA'></p>   </div>   </div>   <div class='carousel-item'   style='background-image: url(http://cfile27.uf.tistory.com/image/9974F43359D4767703D5C9)'>   <div class='carousel-caption d-none d-md-block'><h3><p id = 'mainR'></p></h3>   <p id = 'mainRA'></p></div>   </div><div class='carousel-item'   style='background-image: url(http://cfile27.uf.tistory.com/image/99E2113359F5FF531C146A)'>   <div class='carousel-caption d-none d-md-block'><h3><p id = 'mainH'></p></h3>   <p id = 'mainHA'></p></div>   </div>";
 */ $('#mainSlide').html(value); 

               }
            });
      $.ajax({
         url : "/semi/introbest",
         type : "get",
         dataType : "json",
         success : function(data) {
            var value = decodeURIComponent(data.placetitle1);

            $('#mainP1').html(value);

         }
      });
      $.ajax({
         url : "/semi/introbest",
         type : "get",
         dataType : "json",
         success : function(data) {
            var value = decodeURIComponent(data.placetitle2);

            $('#mainP2').html(value);

         }
      });
      $.ajax({
         url : "/semi/introbest",
         type : "get",
         dataType : "json",
         success : function(data) {
            var value = decodeURIComponent(data.placetitle3);

            $('#mainP3').html(value);

         }
      });
      $.ajax({
         url : "/semi/introbest",
         type : "get",
         dataType : "json",
         success : function(data) {
            var value = decodeURIComponent(data.restitle1);

            $('#mainR').html(value);

         }
      });
      $.ajax({
         url : "/semi/introbest",
         type : "get",
         dataType : "json",
         success : function(data) {
            var value =decodeURIComponent(data.hoteltitle1);

            $('#mainH').html(value);

         }
      });
      
      
      $.ajax({
         url : "/semi/introbest",
         type : "get",
         dataType : "json",
         success : function(data) {
            var value = decodeURIComponent(data.mainPA1);

            $('#mainPA1').html(value);

         }
      });
      $.ajax({
         url : "/semi/introbest",
         type : "get",
         dataType : "json",
         success : function(data) {
            var value = decodeURIComponent(data.mainPA2);

            $('#mainPA2').html(value);

         }
      });
      $.ajax({
         url : "/semi/introbest",
         type : "get",
         dataType : "json",
         success : function(data) {
            var value = decodeURIComponent(data.mainPA3);

            $('#mainPA3').html(value);

         }
      });
      $.ajax({
         url : "/semi/introbest",
         type : "get",
         dataType : "json",
         success : function(data) {
            var value = decodeURIComponent(data.mainRA);

            $('#mainRA').html(value);

         }
      });
      $.ajax({
         url : "/semi/introbest",
         type : "get",
         dataType : "json",
         success : function(data) {
            var value =decodeURIComponent(data.mainHA);

            $('#mainHA').html(value);

         }
      });
      
      
      //best3
      $.ajax({
         url : "/semi/introbest",
         type : "get",
         dataType : "json",
         success : function(data) {
            var value = "<img src='/semi/images/"
                  + decodeURIComponent(data.placetitle1pic1)
                  + "' width='100%' height='220'>";
            $('#picP').html(value);

         }
      });
      $.ajax({
         url : "/semi/introbest",
         type : "get",
         dataType : "json",
         success : function(data) {
            var value = "<img src='/semi/images/"
                  + decodeURIComponent(data.restitle1pic)
                  + "' width='100%' height='220'>";
            $('#picR').html(value);

         }
      });
      $.ajax({
         url : "/semi/introbest",
         type : "get",
         dataType : "json",
         success : function(data) {
            var value = "<img src='/semi/images/"
                  + decodeURIComponent(data.hoteltitle1pic)
                  + "' width='100%' height='220'>";
            $('#picH').html(value);

         }
      });

      $
            .ajax({
               url : "/semi/introbest",
               type : "get",
               dataType : "json",
               success : function(data) {
                  var value = "<b>1위</b><br> <font size = '5px'>"
                        + decodeURIComponent(data.placetitle1)
                        + "</font> ";

                  $('#place1').html(value);

               }
            });
      $
            .ajax({
               url : "/semi/introbest",
               type : "get",
               dataType : "json",
               success : function(data) {
                  var value = "<b>2위&nbsp;&nbsp;&nbsp;</b><font size = '5px'>"
                        + decodeURIComponent(data.placetitle2)
                        + "</font> ";

                  $('#place2').html(value);

               }
            });
      $
            .ajax({
               url : "/semi/introbest",
               type : "get",
               dataType : "json",
               success : function(data) {
                  var value = "<b>3위&nbsp;&nbsp;&nbsp;</b><font size = '5px'>"
                        + decodeURIComponent(data.placetitle3)
                        + "</font> ";

                  $('#place3').html(value);

               }
            });

      $
            .ajax({
               url : "/semi/introbest",
               type : "get",
               dataType : "json",
               success : function(data) {
                  var value = "<b>1위</b><br> <font size = '5px'>"
                        + decodeURIComponent(data.restitle1) + "</font> ";

                  $('#res1').html(value);

               }
            });
      $
            .ajax({
               url : "/semi/introbest",
               type : "get",
               dataType : "json",
               success : function(data) {
                  var value = "<b>2위&nbsp;&nbsp;&nbsp;</b><font size = '5px'>"
                        + decodeURIComponent(data.restitle2)
                        + "</font> ";

                  $('#res2').html(value);

               }
            });
      $
            .ajax({
               url : "/semi/introbest",
               type : "get",
               dataType : "json",
               success : function(data) {
                  var value = "<b>3위&nbsp;&nbsp;&nbsp;</b><font size = '5px'>"
                        + decodeURIComponent(data.restitle3)
                        + "</font> ";

                  $('#res3').html(value);

               }
            });

      $
            .ajax({
               url : "/semi/introbest",
               type : "get",
               dataType : "json",
               success : function(data) {
                  var value = "<b>1위</b><br> <font size = '5px'>"
                        + decodeURIComponent(data.hoteltitle1)
                        + "</font> ";

                  $('#hotel1').html(value);

               }
            });
      $
            .ajax({
               url : "/semi/introbest",
               type : "get",
               dataType : "json",
               success : function(data) {
                  var value = "<b>2위&nbsp;&nbsp;&nbsp;</b><font size = '5px'>"
                        + decodeURIComponent(data.hoteltitle2)
                        + "</font> ";

                  $('#hotel2').html(value);

               }
            });
      $
            .ajax({
               url : "/semi/introbest",
               type : "get",
               dataType : "json",
               success : function(data) {
                  var value = "<b>3위&nbsp;&nbsp;&nbsp;</b><font size = '5px'>"
                        + decodeURIComponent(data.hoteltitle3)
                        + "</font>";

                  $('#hotel3').html(value);

               }
            });
   });
</script>

<!-- Bootstrap core CSS -->
<link href="cssintro/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="cssintro/modern-business.css" rel="stylesheet">
<script type="text/javascript">
   function realtimeClock() {
      document.rtcForm.rtcInput.value = getTimeStamp();
      setTimeout("realtimeClock()", 1000);
   }

   function getTimeStamp() { // 24시간제
      var d = new Date();

      var s = leadingZeros(d.getFullYear(), 4) + '년 '
            + leadingZeros(d.getMonth() + 1, 2) + '월 '
            + leadingZeros(d.getDate(), 2) + '일  ' +

            leadingZeros(d.getHours(), 2) + ' : '
            + leadingZeros(d.getMinutes(), 2) + ' : '
            + leadingZeros(d.getSeconds(), 2);

      return s;
   }

   function leadingZeros(n, digits) {
      var zero = '';
      n = n.toString();

      if (n.length < digits) {
         for (i = 0; i < digits - n.length; i++)
            zero += '0';
      }
      return zero + n;
   }
</script>
</head>

<body onload="realtimeClock()">

   <!-- Navigation -->
   <%@ include file="header.jsp"%>
<form name="rtcForm">
   <header>
      <div id="carouselExampleIndicators" class="carousel slide"
         data-ride="carousel">
         <ol class="carousel-indicators">
            <li data-target="#carouselExampleIndicators" data-slide-to="0"
               class="active"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
         </ol>
         <div class="carousel-inner" id = "mainSlide" role="listbox">
            
         </div>
      </div>
         <a class="carousel-control-prev" href="#carouselExampleIndicators"
            role="button" data-slide="prev"> <span
            class="carousel-control-prev-icon" aria-hidden="true"></span> <span
            class="sr-only">Previous</span>
         </a> <a class="carousel-control-next" href="#carouselExampleIndicators"
            role="button" data-slide="next"> <span
            class="carousel-control-next-icon" aria-hidden="true"></span> <span
            class="sr-only">Next</span>
         </a>
      
   </header>
   <br>
   <div align = "center">
   <div id="divvv" width="100%" align="center">
   <img src = "/semi/images/date.png" id = "divvvimg">
   <br>
      <h3><input id = "inputt" name="rtcInput" readonly align = "center"></h3>
      </div>
   </div>
   <!-- Page Content -->
   <div class="container" border="1">

      <h1 class="my-4" align="center" color="gray">BEST 3</h1>

      <!-- Marketing Icons Section -->
      <div class="row">
         <div class="col-lg-4 mb-4">
            <div class="card h-100">
               <h4 class="card-header">장소</h4>
               <div id = "picP" class="card-body" align="center">
               
               </div>
               <div class="card-footer" align="center">
                  <div id = "place1"> </div>
                  <hr color="lightgray">
                  <div id = "place2"id = "place2"></div>
                  <hr color="lightgray">
                  <div id = "place3"id = "place3"></div>
               </div>

            </div>
         </div>
         
         <div class="col-lg-4 mb-4">
            <div class="card h-100">
               <h4 class="card-header">편의 시설</h4>
               <div id = "picR" class="card-body" align="center">
               
               </div>
               <div class="card-footer" align="center">
                  <div id = "res1"> </div>
                  <hr color="lightgray">
                  <div id = "res2"></div>
                  <hr color="lightgray">
                  <div id = "res3"></div>
               </div>
            </div>
         </div>
         
         <div class="col-lg-4 mb-4">
            <div class="card h-100">
               <h4 class="card-header">숙소</h4>
               <div id = "picH" class="card-body" align="center">
               
               </div>
               <div class="card-footer" align="center">
                  <div id = "hotel1"> </div>
                  <hr color="lightgray">
                  <div id = "hotel2"></div>
                  <hr color="lightgray">
                  <div id = "hotel3"></div>
               </div>
            </div>
         </div>
         </div>
      
      <!-- /.row -->
<hr color = "lightgray">
<br>
      <!-- Portfolio Section -->
      <div class="row">

        <div class="col-md-8">
          <img class="img-fluid" src="/semi/images/introimg6.jpg" alt="" width = "750" height = "400">
        </div>

        <div class="col-md-4">
        <br>
          <font size = "6px">'WhybiS' Description</font>
          <font size = "5px">It is for tourists who want to visit Seoul, the capital of Korea.</font>
          <br><br><br> <br>
          <font size = "6px">Project Developer</font>
           <br>
          <font size = "5px">
          <ul>
            <li>WhybiS Leader. Cheon Da Ye </li>
            <li>WhybiS Member. Kim Ju Hyung</li>
            <li>WhybiS Member. Moon Si Hyun</li>
            <li>WhybiS Member. Yang Joon Seung</li>
            <li>WhybiS Member. Hwang Hyeon Jung</li>
          </ul>
          </font>
        </div>

      </div>
<br><br><br><br><br>

   </div>
   <!-- /.container -->

</form>
   <%@ include file="footer.jsp"%>
   <!-- Bootstrap core JavaScript -->
   <script src="jqueryintro/jquery.min.js"></script>
   <script src="jqueryintro/bootstrap.bundle.min.js"></script>

</body>

</html>