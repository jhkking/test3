<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="vrBoard.model.vo.*"%>
<%@ page import="likePlace.model.vo.likePlace, java.util.*"%>
<%-- <%
   vrBoard board = (vrBoard) request.getAttribute("info");
%> --%>
<%
   likePlace like = (likePlace) request.getAttribute("info");
%>
<% 
   ArrayList<vrBoard> list = (ArrayList<vrBoard>)request.getAttribute("hotellist");
      int listCountho = ((Integer)request.getAttribute("listCountho")).intValue();
      int currentPageho = ((Integer)request.getAttribute("currentPageho")).intValue();
      int startPageho = ((Integer)request.getAttribute("startPageho")).intValue();
      int endPageho = ((Integer)request.getAttribute("endPageho")).intValue();
      int maxPageho = ((Integer)request.getAttribute("maxPageho")).intValue();
      ArrayList<VrBoardDetail> listD = (ArrayList<VrBoardDetail>)request.getAttribute("listD");
%>

<%-- <%
   Member member = (Member) session.getAttribute("member");
%> --%>
<html lang="en">

<head>
<style>
img#aaa{
   width : 700px;
   height : 300px;
}
button#btn11 {
   border: 1px solid skyblue;
   color: white;
   font-size: 20px;
   text-align: center;
   background: lightgray;
   border-radius: 12px;
   height: 60px;
   width: 150px;
}

button#btn11:hover {
   color: #fff;
   background-color: #0069d9;
   border-radius: 12px;
   border-color: #0062cc;
}

button#btn11:focus, button#btn11.focus {
   box-shadow: 0 0 0 0.2rem rgba(0, 123, 255, 0.5);
   border-radius: 12px;
   background-color: #0069d9;
   color: #fff;
}
</style>
<meta charset="utf-8">
<meta name="viewport"
   content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>BEST</title>
<script type="text/javascript">
   function imgclick() {
      var img = document.getElementById('image');

      if (img.src.match("like_no")) {
         img.src = "/semi/images/like_yes.png";
      } else {
         img.src = "/semi/images/like_no.png";
      }
   }
</script>

<script type="text/javascript">
function showimg(val,title,content,add,time,phone,home){
   console.log(val);
   document.getElementById("resimg1").src="/semi/images/"+val;
   document.getElementById("restitle").innerHTML=title;
   document.getElementById("restitle2").innerHTML=title;
   document.getElementById("rescont").innerHTML=content;
   document.getElementById("resadd").innerHTML=add;
   document.getElementById("resopentime").innerHTML=time;
   document.getElementById("resphone").innerHTML=phone;
   
   document.getElementById("reslink").href=home;
   if(home != 'null'){
   document.getElementById("reshomepage").innerHTML=home;
   }

   
   
}
</script>   

</head>

<body>

   <!-- Navigation -->
   <%@ include file="../../header.jsp"%>

   <!-- Page Content -->
   <div class="container">

      <!-- Page Heading -->
      <h1 class="my-4">
         BEST <small>인기</small>
      </h1>
   
      <div align="center" width="80%" >
      <div style="float: left; width: 33%;">
      <form action = "/semi/bestplace">
         <button type = "submit" id="btn11">장소</button>
         <input type = "hidden" name = "page" value =1>

      </form>
      </div>
      <div style="float: left; width: 33%;">
      <form action = "/semi/bestres">
         <button type = "submit" id="btn11">편의시설</button>
         <input type = "hidden" name = "page" value =1>

      </form>
      </div>
      <div style="float: left; width: 33%;">
      <form action = "/semi/besthotel">
         <button type = "submit" id="btn11" autofocus>숙소</button>
         <input type = "hidden" name = "page" value =1>

      </form>
      </div>

      </div>
      <br>
      <br>
      <br>
      <br>
      <div align = "center">

      <h3>숙소</h3>

      </div>
      <br>
      <br>
      

         <!-- Project One -->

   <% for(vrBoard r : list){ %>
        <%for(VrBoardDetail d : listD){ 
        if(r.getVrboardnum() == d.getVrdetailnum()){%>
      <div class="row">

         <div class="col-md-7">
            <a href="#"> <img class="img-fluid rounded mb-3 mb-md-0" id = "aaa"
               src="/semi/images/<%=r.getVrboardoriginalfilename() %>"  alt=""></a>
            <div>
               <br>
            </div>
         </div>
         <div class="col-md-5">
            <h3><%=r.getVrboardtitle()%></h3>

            <p><%=r.getVrboardcontent()%></p>
            <a class="btn btn-primary" data-toggle="modal" data-target="#myModal2" onclick="showimg('<%=r.getVrboardoriginalfilename()%>',
            	      '<%=r.getVrboardtitle()%>','<%=r.getVrboardcontent()%>','<%=d.getVrdetailaddress()%>','<%=d.getVropentime()%>',
            	      '<%=d.getVrphone()%>','<%=d.getVrhomepage()%>')">상세보기</a>
         </div>


      </div>
            
      <%
         }}}
         %>
     
         
         
         <div class="modal fade" id="myModal2" tabindex="-1" role="dialog" area-labelleby="myBodalLabel" aria-hidden="true" style="clear:both">
         <div class="modal-dialog">
         <div class="modal-content">
      
         <div class ="insta-back" ><!-- 내용 -->
      <div class="modal-header"><!-- x -->
      <h3 id ="restitle"></h3> 
         <button type="button" class="close" data-dismiss="modal">
         <h3 id ="restitle"></h3> 
         <span aria-hidden="true">×</span>
         <span class="sr-only">Close</span></button>
         </div><!-- x -->

         <div class="insta">
         <div class="insta ga">
         
         <img id ="resimg1" src="" width=100%; height=100%;/>

             </div>
                  <!-- 사진 -->
            <div class="insta se" style="overflow:scroll">
             <div>
                  <p id="rescont" class="n5"></p>
                  <b><p id="restitle2" class="n5"></p></b>
                  <p id="resadd" class="n5"></p>
                  <p id="resopentime" class="n5"></p>
                  <p id="resphone" class="n5"></p>
                  <p id="reshomepage" class="n5 homepage"></p>
               
                  <hr></div>
            <div>
            <!-- 댓글내용 -->
            <%-- <p class="n5"><%=r.getVrboardtitle()%> --%>
            
            </div>
             <div>
       
           </div>

         
            </div><!-- 상세정보 -->
      
            </div> 
            
         </div><!-- 내용 -->
 
         </div>
         
         </div>
         
         </div>
         
         
<div align="center">
      <ul class="pagination justify-content-center">
         <%
            if (currentPageho <= 1) {
         %>
         <li class="page-item"><a class="page-link" href="/semi/vrlist?page=1"
            aria-label="Previous"> <span aria-hidden="true">&laquo;</span> <span
               class="sr-only">Previous</span>
         </a></li>
         <%
            } else {
         %>
         <li class="page-item"><a class="page-link" href="/semi/vrlist?page=<%=currentPageho - 1%>"
            aria-label="Previous"> <span aria-hidden="true">&laquo;</span> <span
               class="sr-only">Previous</span>
         </a></li>
         <%
            }
         %>
         <%--페이지 숫자 연속 출력 --%>
         <%
            for (int p = startPageho; p <= endPageho; p++) {
               if (p == currentPageho) {
         %><li class="page-item"><a class="page-link" ><%=p%></a></li>
         <%
            } else {
         %>
         <li class="page-item"><a class="page-link" href="/semi/vrlist?page=<%=p%>"><%=p%></a></li>
         <%
            }
            }
         %>
         <%
            if (currentPageho >= maxPageho) {
         %>
         <li
            class="page-item"><a class="page-link" href="/semi/vrlist?page=<%=currentPageho + 1%>"
               aria-label="Next"> <span aria-hidden="true">&raquo;</span> <span
                  class="sr-only">Next</span>
            </a></li>
         <%
            } else {
         %>
         <li
            class="page-item"><a class="page-link" href="/semi/vrlist?page=<%=endPageho%>"
               aria-label="Next"> <span aria-hidden="true">&raquo;</span> <span
                  class="sr-only">Next</span>
            </a></li>
         <%
            }
         %>
      </ul>
   </div>
   </div>
   <!-- Bootstrap core JavaScript -->
   <script src="jquery/jquery.min.js"></script>
   <script src="jqueryintro/bootstrap.bundle.min.js"></script>
   <script src="jquery/bootstrap.bundle.min.js"></script>
   <%@ include file="../../footer.jsp"%>
</body>

</html>