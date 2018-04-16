<%@ page language="java" contentType="text/html; charset=UTF-8" session="false" 
   pageEncoding="UTF-8" import = "reviewBoard.model.vo.ReviewBoard, qnaBoard.model.vo.QnaBoard, vrBoard.model.vo.vrBoard, workerBoard.model.vo.WbBoard, member.model.vo.Member, java.sql.*, java.util.*"%>
<%
   ArrayList<ReviewBoard> mylist = (ArrayList<ReviewBoard>)request.getAttribute("mylist"); 
   ArrayList<QnaBoard> qmylist = (ArrayList<QnaBoard>)request.getAttribute("qmylist"); 
   ArrayList<vrBoard> vmylist = (ArrayList<vrBoard>)request.getAttribute("vmylist");
   ArrayList<WbBoard> wmylist = (ArrayList<WbBoard>)request.getAttribute("wmylist");
      HttpSession session = request.getSession(false);
      String myId = (String)session.getAttribute("myId");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>BoardMyListView</title>
    <!-- Bootstrap core CSS -->
    <link href="/semi/views/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="/semi/views/css/1-col-portfolio.css" rel="stylesheet">
<style>
button.bt{
   width:150px;
   height:40px;
   border:1px dotted #369;
   border-radius:20px;
   background-color:#f3f6f7;
   color:#369;
}
table.type09 {
   border-collapse: collapse;
   text-align: left;
   line-height: 1.5;
   width:100%;
}

table.type09 thead th {
   padding: 10px;
   font-weight: bold;
   vertical-align: top;
   color: #369;
   border-bottom: 3px solid #036;
}

table.type09 tbody th {
   width: 150px;
   padding: 10px;
   font-weight: bold;
   vertical-align: top;
   border-bottom: 1px solid #ccc;
   background: #f3f6f7;
}

table.type09 td {
   width: 350px;
   padding: 10px;
   vertical-align: top;
   border-bottom: 1px solid #ccc;
}
#qnab{
   display:none;
}
#rvb{
   display:none;
}
#vrb{
   display:none;
}
#wkb{
   display:none;
}
</style>
<script type="text/javascript">
   function showDiv(){
      var items = document.getElementsByName("item");
      var qnabDiv = document.getElementById("qnab");
      var rvbDiv = document.getElementById("rvb");
      var vrbDiv = document.getElementById("vrb");
      var wkbDiv = document.getElementById("wkb");
         
      if(items[0].checked == true){
         qnabDiv.style.display = "block";
         rvbDiv.style.display = "none";
         vrbDiv.style.display = "none";
         wkbDiv.style.display = "none";
      }
      if(items[1].checked == true){
         qnabDiv.style.display = "none";
         rvbDiv.style.display = "block";
         vrbDiv.style.display = "none";
         wkbDiv.style.display = "none";
      }
      if(items[2].checked == true){
         qnabDiv.style.display = "none";
         rvbDiv.style.display = "none";
         vrbDiv.style.display = "block";
         wkbDiv.style.display = "none";
      }
      if(items[3].checked == true){
         qnabDiv.style.display = "none";
         rvbDiv.style.display = "none";
         vrbDiv.style.display = "none";
         wkbDiv.style.display = "block";
      }
   }
</script>
</head>
<body>

<%@ include file="../../header.jsp"%>


   <!-- Navigation -->
   


   <!-- Page Content -->
   <div class="container">

      <!-- Page Heading/Breadcrumbs -->
      <h1 class="mt-4 mb-3">
         MY PAGE <small>나의 정보 확인</small>
      </h1>

      <ol class="breadcrumb">
         <li class="breadcrumb-item"><a href="index.html">MY PAGE</a></li>
         <li class="breadcrumb-item active">내 정보 보기 및 수정</li>
      </ol>
      <!-- Content Row -->
      <div class="row">
         <!-- Sidebar Column -->
         <div class="col-lg-3 mb-4">
            <div class="list-group">
               <a href="/semi/myinfo?userid=<%=member.getSmemberId()%>" class="list-group-item">내 정보 보기 및 수정</a> 
               <a href="/semi/mlikeplacelist?userid=<%=member.getSmemberId()%>"class="list-group-item">나의 관심 장소 보기</a> 
               <a href="/semi/rmblist?myId=<%=member.getSmemberId()%>" class="list-group-item">내가 쓴 글 보기</a>
            </div>
         </div>
         <!-- Content Column -->
         <div class="col-lg-9 mb-4">

            <h3 align="center">내가 쓴 글 목록</h3><br> 
<div align="center">
<input type = "radio" name = "item" value = "qnab" onchange = "showDiv();"> QNA게시판 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type = "radio" name = "item" value = "rvb" onchange = "showDiv();" > 리뷰게시판 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type = "radio" name = "item" value = "vrb" onchange = "showDiv();" > VR게시판 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type = "radio" name = "item" value = "wkb" onchange = "showDiv();"> 사업자게시판
</div>
<br><br>

<div id = "qnab">
<h4>QnA Board</h4>

<hr color = "lightgray">
   <form action="/semi/qmblist" method = "post">            
 <br>
    <table class="type09">
      <thead>
         <tr>
            <th scope="cols">글 번호</th>
            <th scope="cols">글 제목</th>
            <th scope="cols">작성자</th>
            <th scope="cols">작성날짜</th>
            <th scope="cols">조회수</th>
            <th scope="cols">첨부파일 유무</th>            
         </tr>    
      </thead>
      <tbody>
      <%for(QnaBoard b : qmylist){ 
         if(member.getSmemberId().equals(b.getQnawriter())){
          %>
         <tr>
            <th scope="row"><%=b.getQnano()%></th>
            <th>
            <%if (member != null) {%> 
            <a href="/semi/qdetail?bnum=<%=b.getQnano()%>&page=1"><%=b.getTitle()%></a>
            <%} else {%> 
            <%=b.getTitle()%> 
            <% } %>
            </th>
            <th><%=b.getQnawriter() %></th>
            <th><%=b.getQnadate() %></th>
            <th><%=b.getQnareadcount() %></th>
            <th>
            <% if (b.getQnaoriginalfilename() != null) { %> 
                ☆
              <% } else { %>
                  χ
              <% } %>
           </th>       
            <% } %>
        <% } %> 
         </tr>   
         </tbody>
      </table>    
   </form> 
</div>

<div id = "vrb">
<h4>VR BOARD</h4>
<hr color = "lightgray">
   <form action="/semi/vmblist" method = "post">            
<br>
   <table class="type09">
      <thead>
         <tr>
            <th scope="cols">글 번호</th>
            <th scope="cols">분류</th>
            <th scope="cols">글 제목</th>
            <th scope="cols">작성자</th>
            <th scope="cols">작성날짜</th>
            <th scope="cols">조회수</th>
            <th scope="cols">좋아요 수</th>
            <th scope="cols">첨부파일 유무</th>
         </tr>    
      </thead>
      <tbody>
      <%for(vrBoard v : vmylist){ 
         if(member.getSmemberId().equals(v.getVrboardwriter())){
            if(member.getSmemberId().equals("admin01"))
          %>
         <tr>
            <th scope="row"><%=v.getVrboardnum()%></th>
            <th><%=v.getVrcode() %></th>
            <th>
            <%if (member != null) {%> 
            <a href="/semi/vrdetail?bnum=<%=v.getVrboardnum()%>&page=1"><%=v.getVrboardtitle()%></a>
            <%} else {%> 
            <%=v.getVrboardtitle()%> 
            <% } %>
            </th>
            <th><%=v.getVrboardwriter() %></th>
            <th><%=v.getVrboarddate() %></th>
            <th><%=v.getVrboardreadcount() %></th>
            <th><%=v.getVrlikecount() %></th>
            <th>
            <% if (v.getVrboardoriginalfilename() != null) { %> 
                ☆
              <% } else { %>
                  χ
              <% } %>
           </th>       
            <% } %>
        <% } %> 
         </tr>   
         </tbody>
      </table>   
   </form>
</div>



<div id = "rvb">
<h4>Review Board</h4>
<hr color = "lightgray">
   <form action="/semi/rmblist" method = "post">            
<br>
   <table class="type09">
      <thead>
         <tr>
            <th scope="cols">글 번호</th>
            <th scope="cols">글 제목</th>
            <th scope="cols">작성자</th>
            <th scope="cols">작성날짜</th>
            <th scope="cols">조회수</th>
            <th scope="cols">첨부파일 유무</th>
         </tr>    
      </thead>
      <tbody>
      <%for(ReviewBoard r : mylist){ 
         if(member.getSmemberId().equals(r.getReviewWriter())){
          %>
         <tr>
            <th scope="row"><%=r.getReviewNum()%></th>
            <th>
            <%if (member != null) {%> 
            <a href="/semi/rdetail?bnum=<%=r.getReviewNum()%>&page=1"><%=r.getReviewTitle()%></a>
            <%} else {%> 
            <%=r.getReviewTitle()%> 
            <% } %>
            </th>
            <th><%=r.getReviewWriter() %></th>
            <th><%=r.getReviewDate() %></th>
            <th><%=r.getReviewReadcount() %></th>
            <th>
            <% if (r.getReviewOriginalFilename() != null) { %> 
                ☆
              <% } else { %>
                  χ
              <% } %>
           </th>         
            <% } %>
        <% } %> 
         </tr>   
         </tbody>
      </table>   
   </form>
</div>

<div id = "wkb">
<h4>Worker Board</h4>
<hr color = "lightgray">
   <form action="/semi/wbmlist" method = "post">            
<br>
   <table class="type09">
      <thead>
         <tr>
            <th scope="cols">글 번호</th>
            <th scope="cols">글 제목</th>
            <th scope="cols">작성자</th>
            <th scope="cols">작성날짜</th>
            <th scope="cols">조회수</th>
            <th scope="cols">첨부파일 유무</th>
         </tr>    
      </thead>
      <tbody>
      <%for(WbBoard w : wmylist){ 
         if(member.getSmemberId().equals(w.getWbwriter())){
          %>
         <tr>
            <th scope="row"><%=w.getWbnumber()%></th>
            <th>
            <%if (member != null) {%> 
            <a href="/semi/wbdetail?bnum=<%=w.getWbnumber()%>&page=1"><%=w.getWbtitle()%></a>
            <%} else {%> 
            <%=w.getWbtitle()%> 
            <% } %>
            </th>
            <th><%=w.getWbwriter() %></th>
            <th><%=w.getWbdate() %></th>
            <th><%=w.getWb_readcount() %></th>
            <th>
            <% if (w.getWboriginalfilename() != null) { %> 
                ☆
              <% } else { %>
                  χ
              <% } %>
           </th>       
            <% } %>
        <% } %> 
         </tr>   
         </tbody>
      </table>   
   </form>
</div>
   <script src="jqueryintro/bootstrap.bundle.min.js"></script>
            
         </div>
      </div>
      <!-- /.row -->

   </div>
<br><br><br><br><br><br>

   <!-- Bootstrap core JavaScript -->
<%@ include file="../../footer.jsp" %>
</body>
</html>