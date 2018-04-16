<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@page  import="vrBoard.model.vo.*,java.util.*,likePlace.model.vo.likePlace" %>
<%vrBoard board = (vrBoard)request.getAttribute("board");
ArrayList<vrBoard> listAll = (ArrayList<vrBoard>) request.getAttribute("listAll");
String placeName = (String)request.getAttribute("place");
ArrayList<likePlace> like = (ArrayList<likePlace>)request.getAttribute("like");
Maplocation maplocation = (Maplocation) request.getAttribute("maplo");
VrBoardDetail vbd =(VrBoardDetail) request.getAttribute("vbd");
ArrayList<vrBoard> resBoard = (ArrayList<vrBoard>)request.getAttribute("resBoard");
ArrayList<DetailComment> list2 = (ArrayList<DetailComment>)request.getAttribute("list2"); 
ArrayList<VrBoardDetail> resBoardDetail = (ArrayList<VrBoardDetail>)request.getAttribute("resBoardDetail");

int resCount=0;
int bnum=0;
int count=0;
boolean flag=false;
boolean f = false;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Place</title>
<script type="text/javascript"
   src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"></script>
<!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="css/1-col-portfolio.css" rel="stylesheet">

<style>

@import url(//fonts.googleapis.com/earlyaccess/nanumpenscript.css);
div.mainmain1{
   float:left; width:15%;
}
div.mainmain2{
   float:left; width:55%;
   align : center;
} 

.modal-size {
   width:750px;
   height: 450px;
}
.n5{font-family: 'Nanum Pen Script', cursive; font-size:25px;}

div.coll{
   width : 100%;
   align : center;
}
 .n4{ font-family: 'Nanum Pen Script', cursive; font-size:25px; }
div.floating{
position:fixed;
right:50%;
top:120px;
margin-right:-850px;
float:left; 
/* margine : 0 auto; */
width:15%;
/* background : lightgray; */
border : 1px solid lightgray;
border-radius: 2em;
background : white;

}
div.infloating{
   background : lightgray;
border-top-left-radius: 2em;
border-top-right-radius: 2em;
}
div.ininfloat{
 background : white;
border-bottom-left-radius: 2em;
border-bottom-right-radius: 2em;
 border : 1px solid lightgray;
}
div.mainmain3{
   float:left; 
   width:30%;
   
   margine : 0 auto;
}
      h1 { font-family: 'Nanum Pen Script', cursive; }
      .npps { font-family: 'Nanum Pen Script', cursive; font-size:30px; }
      h3 { font-family: 'Nanum Pen Script', cursive; font-size:45px;  }
        .npps2 { font-family: 'Nanum Pen Script', cursive; font-size:30px; }
         .n3 { font-family: 'Nanum Pen Script', cursive; font-size:30px; }
 div.insta-back{
background:white;
width : 800px;
height : 500px;
position : fixed;
margin-left : -200px;
margin-top: +150px;
}
div.insta{
/* display:inline; */
background:white;
width : 800px;
height : 500px;
}
div.insta.ga{
float:left;
width:60%;


}
div.insta.se{
float:left;
width:40%;


}
div.insta.se.up{
height:50%;
}
div.down{
width:50%;
}
.res{
   margin:0 auto;
}
 table.type031 {
   border-collapse: collapse;
   text-align: left;
   line-height: 1.5;
   /* border-top: 1px solid #ccc; */
   border-left: 3px solid gray;
   margin-left:10px;
   font-family: 'Nanum Pen Script';
   
   width: 100%;
}

table.type031 th {
   width: 147px;
   padding: 10px;
   
   vertical-align: top;
   font-family: 'Nanum Pen Script';
   font-size:25px;
  /*  border-right: 8px solid #343A40;
    border-bottom: 1px solid #ccc;  */
}

table.type031 td {
   width: 349px;
   padding: 10px;
   vertical-align: top;
   /* border-right: 1px solid #ccc;
   border-bottom: 1px solid #ccc; */
}


dl {
   width: 200px;
   left : 20px; 
}

dt {
   line-height: 35px;
   font-size: 18pt;
   text-indent: 3em;
   font-weight: bold;
   color: black;
   height: 40px;
   border-bottom: 1px solid gray;
   border-top: 1px solid gray;
}

dt.over {
   background-color:#eee;
   cursor: pointer;
   color:black;
}

dt.selected {
    background-color:#343A40;
   cursor: default;
   color:white;
}

dd {
   height: 300px;
   
}

#map {
   height: 300px;
   width:70%;
}
a {
   text-decoration: none;
   color:black;
}

a.homepage{
   text-decoration: none;
   color:#888;
   font-size:25px;
}
/* .resimg:hover{
   -webkit-transform: scale(1.2);
   transition: all 0.3s ease-in-out; 
   opacity:0.5;
   filter:alpha(opacity=80);
}  */
figure.snip1141 {

   position: relative;
  float: left; 
  overflow: hidden;
  margin: 10px 1%; 
  min-width: 250px;
  max-width: 250px;
  max-height: 250px; 
  min-height: 250px;
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

figure.snip1141 h3 {
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

figure.snip1141:hover h3,
figure.snip1141.hover h3 {
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



<script type="text/javascript">

$(function() {
    $(window).scroll(function() {
        if ($(this).scrollTop() > 300) {
            $('#MOVE_TOP_BTN').fadeIn();
        } else {
            $('#MOVE_TOP_BTN').fadeOut();
        }
    });
    
    $("#MOVE_TOP_BTN").click(function() {
        $('html, body').animate({
            scrollTop : 0
        }, 400);
        return false;
    });
});


   $(function() {
      $("dd:not(:first)").css("display", "none");
      $("dt:first").addClass("selected");
      $("dl dt").click(function() {
         if ($("+dd", this).css("display") == "none") {
            $("dd").slideUp("slow");
            $("+dd", this).slideDown("slow");
            $("dt").removeClass("selected");
            $(this).addClass("selected");
         }
      }).mouseover(function() {
         $(this).addClass("over");
      }).mouseout(function() {
         $(this).removeClass("over");
      });
   });

   function imgclick() {
      var img = document.getElementById('image');

      if (img.src.match("like_no")) {
         img.src = "/semi/images/like_yes.png";
      } else {
         img.src = "/semi/images/like_no.png";
      }
   }

   
   $(".hover").mouseleave(
          function() {
            $(this).removeClass("hover");
          }
        );

   
   function insert(){
         
         alert('입력되었습니다');
      }
      
      function deleter(){
         alert('삭제되었습니다');
         
      }
</script>

</head>
<body>
   <%@ include file="../../header.jsp"%>
   <%if(maplocation!=null) {%>
       <input type="hidden" id = "mapname"value="<%=maplocation.getMapname()%>"> 
       <%} %>
   <div class="row">
   <div class="mainmain1">
   <dl class="npps" width=10%; height=10%;>
      
      <dt>홍대</dt>
      <dd>
      <table class="type031">
      <%for(vrBoard vr : listAll){ 
      if(vr.getVrboardtitle().contains("홍대")){ %>
      <tr>
      <%if(member!=null){ %>
         <th scope="row"><a href="/semi/vrimg?bnum=<%=vr.getVrboardnum() %>&title=<%=vr.getVrboardtitle()%>&place=홍대&userid=<%=member.getSmemberId()%>"><%=vr.getVrboardtitle()%></a></th>
      <%}else{%>         
         <th scope="row"><a href="/semi/vrimg?bnum=<%=vr.getVrboardnum() %>&title=<%=vr.getVrboardtitle()%>&place=홍대"><%=vr.getVrboardtitle()%></a></th>
      <% }%>
      </tr>
      <%}} %>
      </table></dd>
      
      <dt>건대</dt>
      <dd>
      <table class="type031">
      <%for(vrBoard vr : listAll){ 
      if(vr.getVrboardtitle().contains("건대")){ %>
      <tr>
      <%if(member!=null){ %>
         <th scope="row"><a href="/semi/vrimg?bnum=<%=vr.getVrboardnum() %>&title=<%=vr.getVrboardtitle()%>&place=건대&userid=<%=member.getSmemberId()%>"><%=vr.getVrboardtitle()%></a></th>
      <%}else{%>         
         <th scope="row"><a href="/semi/vrimg?bnum=<%=vr.getVrboardnum() %>&title=<%=vr.getVrboardtitle()%>&place=건대"><%=vr.getVrboardtitle()%></a></th>
      <% }%>
 
      </tr>
      <%}} %>
      </table>
      </dd>
      
      <dt>동대문</dt>
      <dd>
      <table class="type031">
      <%for(vrBoard vr : listAll){ 
      if(vr.getVrboardtitle().contains("동대문")){ %>
      <tr>
      <%if(member!=null){ %>
         <th scope="row"><a href="/semi/vrimg?bnum=<%=vr.getVrboardnum() %>&title=<%=vr.getVrboardtitle()%>&place=동대문&userid=<%=member.getSmemberId()%>"><%=vr.getVrboardtitle()%></a></th>
      <%}else{%>         
         <th scope="row"><a href="/semi/vrimg?bnum=<%=vr.getVrboardnum() %>&title=<%=vr.getVrboardtitle()%>&place=동대문"><%=vr.getVrboardtitle()%></a></th>
      <% }%>
      </tr>
      <%}} %>
      </table>
      </dd>
      <dt>혜화</dt>
      <dd>
      <table class="type031">
      <%for(vrBoard vr : listAll){ 
      if(vr.getVrboardtitle().contains("혜화")){ %>
      <tr>
      <%if(member!=null){ %>
         <th scope="row"><a href="/semi/vrimg?bnum=<%=vr.getVrboardnum() %>&title=<%=vr.getVrboardtitle()%>&place=혜화&userid=<%=member.getSmemberId()%>"><%=vr.getVrboardtitle()%></a></th>
      <%}else{%>         
         <th scope="row"><a href="/semi/vrimg?bnum=<%=vr.getVrboardnum() %>&title=<%=vr.getVrboardtitle()%>&place=혜화"><%=vr.getVrboardtitle()%></a></th>
      <% }%>
      </tr>
      <%}} %>
      </table>
      </dd>
      <dt>신사</dt>
      <dd>
      <table class="type031">
      <%for(vrBoard vr : listAll){ 
      if(vr.getVrboardtitle().contains("신사")){ %>
      <tr>
      <%if(member!=null){ %>
         <th scope="row"><a href="/semi/vrimg?bnum=<%=vr.getVrboardnum() %>&title=<%=vr.getVrboardtitle()%>&place=신사&userid=<%=member.getSmemberId()%>"><%=vr.getVrboardtitle()%></a></th>
      <%}else{%>         
         <th scope="row"><a href="/semi/vrimg?bnum=<%=vr.getVrboardnum() %>&title=<%=vr.getVrboardtitle()%>&place=신사"><%=vr.getVrboardtitle()%></a></th>
      <% }%>
      </tr>
      <%}} %>
      </table>
      </dd>

      <dt>잠실</dt>
      <dd>
      <table class="type031">
      <%for(vrBoard vr : listAll){ 
      if(vr.getVrboardtitle().contains("잠실")){ %>
      <tr>
      <%if(member!=null){ %>
         <th scope="row"><a href="/semi/vrimg?bnum=<%=vr.getVrboardnum() %>&title=<%=vr.getVrboardtitle()%>&place=잠실&userid=<%=member.getSmemberId()%>"><%=vr.getVrboardtitle()%></a></th>
      <%}else{%>         
         <th scope="row"><a href="/semi/vrimg?bnum=<%=vr.getVrboardnum() %>&title=<%=vr.getVrboardtitle()%>&place=잠실"><%=vr.getVrboardtitle()%></a></th>
      <% }%>
      </tr>
      <%}} %>
      </table>
      </dd>
       <dt>남산</dt>
      <dd>
      <table class="type031">
      <%for(vrBoard vr : listAll){ 
      if(vr.getVrboardtitle().contains("남산")){ %>
      <tr>
      <%if(member!=null){ %>
         <th scope="row"><a href="/semi/vrimg?bnum=<%=vr.getVrboardnum() %>&title=<%=vr.getVrboardtitle()%>&place=남산&userid=<%=member.getSmemberId()%>"><%=vr.getVrboardtitle()%></a></th>
      <%}else{%>         
         <th scope="row"><a href="/semi/vrimg?bnum=<%=vr.getVrboardnum() %>&title=<%=vr.getVrboardtitle()%>&place=남산"><%=vr.getVrboardtitle()%></a></th>
      <% }%>
      </tr>
      <%}} %>
      </table>
      </dd>
      <dt>명동</dt>
      <dd>
      <table class="type031">
      <%for(vrBoard vr : listAll){ 
      if(vr.getVrboardtitle().contains("명동")){ %>
      <tr>
      <%if(member!=null){ %>
         <th scope="row"><a href="/semi/vrimg?bnum=<%=vr.getVrboardnum() %>&title=<%=vr.getVrboardtitle()%>&place=명동&userid=<%=member.getSmemberId()%>"><%=vr.getVrboardtitle()%></a></th>
      <%}else{%>         
         <th scope="row"><a href="/semi/vrimg?bnum=<%=vr.getVrboardnum() %>&title=<%=vr.getVrboardtitle()%>&place=명동"><%=vr.getVrboardtitle()%></a></th>
      <% }%>
      </tr>
      <%}} %>
      </table>
      </dd>
   </dl>
   </div>
   <br><br>
   <!-- Page Content -->
<%if(board != null){ %>   
<div class = "mainmain2">


      <!-- Page Heading -->
      <br><br>
      <h1 class="my-4">
      <small></small>
      </h1>

      <!-- Project One -->

      
      <div align = "center">
         <div class="coll">
            <%if(maplocation != null){ %>
          <img width=70%; height=200px; src="images/<%=maplocation.getImagename()%>">
          <br>
          <a class="npps2" style="text-align:right;" ><%=board.getVrboardtitle()%></a>
          <%} %>
 <hr>
          <br><br><br><br>
            <form>
            <h1>VR PANORAMA</h1>
            
            <input type="hidden" id="vrimages0" value="images/<%=board.getVrboardoriginalfilename()%>">
            </form>
            <%-- <img id="vrimages" src="images/<%=vrboard.getVrboardoriginalfilename()%>" width="400" height="200"/> --%>
            <div id="map"></div>
         </div>
         <div class="coll">
         
         <%if(member != null && like != null){
            i:for(likePlace lk:like){
               
               if(flag==false){
               if(count<like.size()){
               if(board.getVrboardnum()==lk.getLikePlaceNum() && lk.getLikeUser().equals(member.getSmemberId())){ %>
               <h3><%=board.getVrboardtitle()%>&nbsp;<a href="/semi/vrBoardUnlike?bnum=<%=lk.getLikePlaceNum()%>&userid=<%=member.getSmemberId()%>&placeNum=<%=board.getVrboardnum()%>&title=<%=board.getVrboardtitle()%>&place=<%=placeName %>"><img src =" images/like_yes.png"></a></h3>
               <%  count++; flag=true; continue i;
               }}}}
         if(flag== false){%>
         <h3><%=board.getVrboardtitle()%>&nbsp;<a href="/semi/vrBoardlike?bnum=<%=board.getVrboardnum()%>&userid=<%=member.getSmemberId()%>&placeNum=<%=board.getVrboardnum()%>&title=<%=board.getVrboardtitle()%>&place=<%=placeName %>"><img src =" images/like_no.png"></a></h3>
               
            <%}}else{%>
         <h3><%=board.getVrboardtitle()%>&nbsp;<a href="javascript:alert('로그인이 필요합니다!');"><img src =" images/like_no.png"></a></h3>
      <%}%>
          <!-- <a class="btn btn-primary" href="#">자세히보기</a> -->
      

 <%if(vbd != null){ %>
   <a class="n4">주소&nbsp;:&nbsp;<%=vbd.getVrdetailaddress() %><br>
   이용시간&nbsp;:&nbsp;<%=vbd.getVropentime() %><br>
   PHONE&nbsp;:&nbsp;<%=vbd.getVrphone() %><br>
   Home-Page&nbsp;:&nbsp;<%if(vbd.getVrhomepage() != null){ %>
   <a class="homepage" href="<%=vbd.getVrhomepage() %>"><%=vbd.getVrhomepage() %></a>
   <%}else{%>
   없음</a>
   <%}%>
   
   <%} %>
          
          <!-- <a class="btn btn-primary" href="#">자세히보기</a> -->
      </div>

         
 <hr>
  <!--  편의시설 구역 -->
  <h1>편의시설</h1>
  <div id="res">
  <% for(int i =0; i<resBoard.size(); i++){
    if(resCount!=0 && resCount % 3 == 0){       
   %>
   <%for(int j=0; j<resBoardDetail.size(); j++){ 
              if(i==j){ %>
<figure class="snip1141">
     <br><br><a  data-toggle="modal"data-target="#myModal2"><img src = "images/<%=resBoard.get(i).getVrboardoriginalfilename()%>" 
     onclick="showimg('<%=resBoard.get(i).getVrboardoriginalfilename()%>','<%=resBoard.get(i).getVrboardtitle()%>',
      '<%=resBoard.get(i).getVrboardcontent()%>','<%=resBoardDetail.get(j).getVrdetailaddress()%>','<%=resBoardDetail.get(j).getVropentime()%>',
     '<%=resBoardDetail.get(j).getVrphone()%>','<%=resBoardDetail.get(j).getVrhomepage()%>);"width="250px" height="250px" ></a>&nbsp;&nbsp;&nbsp;&nbsp;
<figcaption>
    <div class="circle"><i class="ion-ios-plus-empty"> </i></div>
    <h3 ><%=resBoard.get(i).getVrboardtitle()%></h3>
  </figcaption>
  </figure> 
 <%}}%>
 <%--   <div class="modal fade" id="myModal2" tabindex="-1" role="dialog" area-labelleby="myBodalLabel" aria-hidden="true" style="clear:both">
               <div class="modal-dialog">
               <div class ="insta-back" >내용
            <div class="modal-header">x
            <h3 id ="restitle"></h3> 
               <button type="button" class="close" data-dismiss="modal">
               <span aria-hidden="true">×</span>
               <span class="sr-only">Close</span></button>
               </div>x
               
               <div class="insta">
               
               <div class="insta ga">
               
      
               <img id ="resimg1" src="" width=100%; height=100%;></img>
            
                   </div>
                  <!-- 사진 -->
                     <div class="insta se">
                  <div>
                  <p id="rescont"></p>
                  <p id="restitle2"></p>
                  <p id="resadd"></p>
                  <p id="resopentime"></p>
                  <p id="resphone"></p>
                  <a id="reslink" class="homepage" href=""><p id="reshomepage"></p></a>
                  <hr></div>
                  
                   <div>
                 
                 <form action="/semi/drinsert?bnum=<%=board.getVrboardnum()%>&userid=<%=member.getSmemberId() %>&place=<%=placeName%>&title=<%=board.getVrboardtitle()%>" method="post">
                  <input type="text" name="dcontent" placeholder="댓글입력..." style=" border-top:none; border-left:none; border-right:none;">
                  <input type="submit" value="입력" onclick="insert();">
                  
                  </form>
                 </div>
               
               </div>
                  </div>상세정보
            
                  </div> 
               </div>내용
    
               </div>
                --%>
              
  
   <% f=true;}else{ 
   %>
   <%for(int j=0; j<resBoardDetail.size(); j++){ 
              if(i==j){ %>
  <figure class="snip1141">
     <a  data-toggle="modal" data-target="#myModal2" ><img src = "images/<%=resBoard.get(i).getVrboardoriginalfilename()%>"
      onclick="showimg('<%=resBoard.get(i).getVrboardoriginalfilename()%>','<%=resBoard.get(i).getVrboardtitle()%>',
      '<%=resBoard.get(i).getVrboardcontent()%>','<%=resBoardDetail.get(j).getVrdetailaddress()%>','<%=resBoardDetail.get(j).getVropentime()%>',
     '<%=resBoardDetail.get(j).getVrphone()%>','<%=resBoardDetail.get(j).getVrhomepage()%>');"width="250px" height="250px" ></a>&nbsp;&nbsp;&nbsp;&nbsp;
<figcaption>

    <div class="circle"><i class="ion-ios-plus-empty"> </i></div>
    <h3 ><%=resBoard.get(i).getVrboardtitle()%></h3>
  </figcaption>
  </figure>
  <%}} %>
   
               
     <% f=true;}resCount++;%>
      <div class="modal fade" id="myModal2" tabindex="-1" role="dialog" 
    area-labelleby="myBodalLabel" aria-hidden="true" style="clear:both">
               <div class="modal-dialog">
               <div class="modal-content">
            
               <div class ="insta-back" ><!-- 내용 -->
            <div class="modal-header"><!-- x -->
            <h3 id ="restitle"></h3> 
               <button type="button" class="close" data-dismiss="modal">
               <span aria-hidden="true">×</span>
               <span class="sr-only">Close</span></button>
               </div><!-- x -->
      
               <div class="insta">
               <div class="insta ga">
               
               <img id ="resimg1" src="" width=100%; height=100%;></img>
            
                   </div>
                        <!-- 사진 -->
                  <div class="insta se" style="overflow:scroll">
                  <div>
                  <p id="rescont" class="n5"></p>
                  <b><p id="restitle2" class="n5"></p></b>
                  <p id="resadd" class="n5"></p>
                  <p id="resopentime" class="n5"></p>
                  <p id="resphone" class="n5"></p>
                  <a id="reslink" class="n5 homepage" href=""><p id="reshomepage" class="n5 homepage"></p></a>
               
                  <hr></div>
                  <div>
                  <!-- 댓글내용 -->
                  <p class="n5"><%=board.getVrboardtitle()%> ↓ community  ↓</p>
                  <%if(list2!=null){%>
                     <table style="boarder:none">
                  <%for(DetailComment d : list2){ %>
                     <tr><td><%=d.getDwriter()%> : </td><td><%=d.getDcontent()%></td>
                     <%if(member != null){ 
                     if(d.getDwriter().equals(member.getSmemberId()) || member.getSmemberId().equals("admin01")){%>
                     <td><a  href="/semi/drdelete?cno=<%=d.getCno()%>&bnum=<%=board.getVrboardnum()%>&userid=<%=member.getSmemberId() %>&place=<%=placeName%>&title=<%=board.getVrboardtitle()%>" onclick="deleter();">x</a></td><%} }%></tr>
                  <%}} %>
                  </table>
                  </div>
                   <div>
                 
                <form action="/semi/drinsert?bnum=<%=board.getVrboardnum()%>&userid=<%=member.getSmemberId() %>&place=<%=placeName%>&title=<%=board.getVrboardtitle()%>" method="post">
                  <input type="text" name="dcontent" placeholder="댓글입력..." style=" border-top:none; border-left:none; border-right:none;">
                  <input type="submit" value="입력" onclick="insert();">
                  
                  </form>
                 </div>
 
               
                  </div><!-- 상세정보 -->
            
                  </div> 
               </div><!-- 내용 -->
       
               </div>
               
               </div>
               
               </div>
  <%} %>
     
          
            
            
             </div>
           
 <script type="text/javascript">
function showimg(val,val2,val3,add,time,phone,home){
   console.log(val);
   document.getElementById("resimg1").src="images/"+val;
   document.getElementById("restitle").innerHTML=val2;
   document.getElementById("rescont").innerHTML=val3;
   
   
   
   document.getElementById("restitle2").innerHTML=val2;
   document.getElementById("resadd").innerHTML=add;
   document.getElementById("resopentime").innerHTML=time;
   document.getElementById("resphone").innerHTML=phone;
   
   document.getElementById("reslink").href=home;
   if(home != 'null'){
   document.getElementById("reshomepage").innerHTML=home;
   }

   
   
}
</script>   

      
            
            
  <hr style="clear:both">
         <h1>LOCATION</h1>
            
<div id="map1" style="width:70%;height:350px;"></div>
</div>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=767bb21ee012c29905e704cc8310cffa"></script>
<script>
var mapContainer = document.getElementById('map1'), // 지도를 표시할 div 
    mapOption = { 
        center: new daum.maps.LatLng(<%=maplocation.getMapwi()%>,<%=maplocation.getMapkung()%> ), // 지도의 중심좌표
        level: 4 // 지도의 확대 레벨
    };

// 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
var map = new daum.maps.Map(mapContainer, mapOption); 
//마커가 표시될 위치입니다 
var position  = new daum.maps.LatLng(<%=maplocation.getMapwi()%>,<%=maplocation.getMapkung()%>); 

// 마커를 생성합니다
var marker = new daum.maps.Marker({
  position: position,
  clickable: true // 마커를 클릭했을 때 지도의 클릭 이벤트가 발생하지 않도록 설정합니다
});
marker.setMap(map);
var mapname=document.getElementById('mapname').value;
var iwContent = '<div style="padding:5px;"><p class="npps" style="font-size:27px;">'+mapname+'<P></div>', // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
iwRemoveable = true; // removeable 속성을 ture 로 설정하면 인포윈도우를 닫을 수 있는 x버튼이 표시됩니다

//인포윈도우를 생성합니다
// 인포윈도우를 생성합니다
var infowindow = new daum.maps.InfoWindow({
    content : iwContent,
    removable : iwRemoveable
});

// 마커에 클릭이벤트를 등록합니다
daum.maps.event.addListener(marker, 'click', function() {
      // 마커 위에 인포윈도우를 표시합니다
      infowindow.open(map, marker);  
});




</script>
<div align = "center">
   <%} %>
   <h3>오시는길</h3>
   <%if(maplocation != null){ %>
   <a class="n3"><%=maplocation.getGbus()%></a><br>
   <a class="n3"><%=maplocation.getMbus()%></a><br>
   <a class="n3">지하철:<%=maplocation.getMetro()%></a><br>
   <%} %>
   <!--오른쪽 전체  -->
  </div> 
   </div>
  <div class="floating" align = "center">
  <div class = "infloating" width = "100%" height = "45px">
     <font size = "5px"><b>[ WhybiS광고글 ]</b><br></font>
     <font size = "4px">누르면 해당 홈페이지로 이동합니다!</font>
     <br>
  </div>
  <br>
   <a href = "http://www.yanolja.com" target="_blank">
   <!-- 광고 -->
      <img src = "images/yanolja.gif" width = "90%" >
   </a>
   <br><br>
      <a href = "http://corp.dailyhotel.co.kr" target="_blank">
   <!-- 광고 -->
      <img src = "images/daily.gif" width = "90%" >
   </a>
   
     <br><br>
         <a href = "http://www.goodchoice.kr" target="_blank">
   <!-- 광고 -->
      <img src = "images/zzz.gif" width = "90%" >
      <br>
   </a>
   <br>
   <%if(member!=null) { %>
      <a href = "/semi/mlikeplacelist?userid=<%=member.getSmemberId()%>">
   <!-- 광고 -->
      <img src = "/semi/images/likeit.jpg" width = "80px" height = "60px" >
   </a>
   <%} else { %>
   <a href = "javascript:alert('로그인이 필요합니다!');">
   <!-- 광고 -->
      <img src = "/semi/images/likeit.jpg" width = "80px" height = "60px" >
   </a>
   <%} %>
   <br>
   <font size = "4px">관심 목록 보기</font>
   <br>
   <div class = "ininfloat">

   
   <font size = "5px"><a id = "MOVE_TOP_BTN" style="cursor:pointer">▲ TOP</a></font>
   <br>
   </div>

   </div>
<!--    <div class="mainmain3" align = "center">
   <a href = "http://www.yanolja.com" target="_blank">
      <img src = "images/gwanggo.png" width = "50%" height = "550px;">
   </a>
   </div>
 -->
   </div><!-- 화면 전체  -->

         
      
      
      <!-- /.row -->

      <hr>

<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCslBH2Gcxh8pTTDRpLOlrEJ6RpOMjXwZ4&callback=initPano"
      async defer>
   </script>
   <script>
   var filePath = document.getElementById("vrimages0").value;
   
   console.log(filePath);
   
   function initPano() {
         // Set up Street View and initially set it visible. Register the
         // custom panorama provider function. Set the StreetView to display
         // the custom panorama 'reception' which we check for below.
         var panorama = new google.maps.StreetViewPanorama(document.getElementById('map'), {
            pano : 'reception',
            visible : true,
            panoProvider : getCustomPanorama
         });
      }
   

   
      
      // Return a pano image given the panoID.
      function getCustomPanoramaTileUrl(pano, zoom, tileX, tileY) {
         // Note: robust custom panorama methods would require tiled pano data.
         // Here we're just using a single tile, set to the tile size and equal
         // to the pano "world" size.
         return filePath;
      
      }

      // Construct the appropriate StreetViewPanoramaData given
      // the passed pano IDs.
      function getCustomPanorama(pano, zoom, tileX, tileY) {
         if (pano === 'reception') {
            return {
               location : {
                  pano : 'reception',
                  description : ''
               },
               links : [],
               // The text for the copyright control.
               copyright : 'sexy',
               // The definition of the tiles for this panorama.
               tiles : {
                  tileSize : new google.maps.Size(673, 411),
                  worldSize : new google.maps.Size(673, 411),
                  // The heading in degrees at the origin of the panorama
                  // tile set.
                  centerHeading : 105,
                  getTileUrl : getCustomPanoramaTileUrl
               }
            };
         }
      }

      vrView.addHotspot('123', {
         pitch : 30, // In degrees. Up is positive.
         yaw : 20, // In degrees. To the right is positive.
         radius : 10, // Radius of the circular target in meters.
         distance : 2
      // Distance of target from camera in meters.
      });

      vrView.on('click', function(event) {
         if (event.id == myHotspotId) {
            // Handle hotspot click.
         }
      });
   </script>
</body>
<%@ include file="../../footer.jsp"%>
</body>
</html>