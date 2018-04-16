<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ page import="member.model.vo.Member, java.util.*"%>
<% 
   ArrayList<Member> Idlist = (ArrayList<Member>)request.getAttribute("Idlist"); 
%>
<!DOCTYPE html>

<html lang="en">
<style>
   div.box1 {
      border : 2px solid gray;
      margin-top: 70px;
      border-radius : 2em;
      vertical-align:middle
   }
   div.box2 {
      border : 2px solid gray;
      margin-top: 70px;
      border-radius : 2em;
      vertical-align:middle
   }
duv.container{
   align : center;
}
footer{
   position:absolute;

    bottom:0;

    width:100%;

    height:70px;   

    background:#ccc;
    }
    div.row{
    border : 3px solid black;
    border-radius : 5em;
    height : 400px;
    backgroud : #f3f6f7;
     align : center;
    }
    *{
       margin : 0 auto;
    }
</style>
<head>
<%-- <script type="text/javascript">
var input = document.getElementById("btn11").value; 
<%for(Member r : memberL) {%>
   <%if(r.getSmemberId() == (btn11).value){ %>
      alert('로그인이 필요합니다!');
      <%}%>
   <%}%>
</script> --%>
<meta charset="utf-8">
<meta name="viewport"
   content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>JOIN_workercheck</title>

<!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="css/1-col-portfolio.css" rel="stylesheet">
<link href="cssintro/modern-business.css" rel="stylesheet">
</head>

<body>
      <!-- Navigation -->
   <%@ include file="../../header.jsp"%>
   <br><br><br>

      <div class="container">
      <div align = "center">
      <h2>  환영합니다! WhybiS입니다!</h2>
    <h3>∇  원하는 회원가입을 선택하세요! ∇</h3>
    <br><br>
      </div>
   
         <div class="row">
      
      <br>
            <div style="width: 250px; height: 250px;" class="box1" align = "center">&nbsp;
               <form action="/semi/workercheck">
               <input type = "hidden" name = "worker" value = "n">
                  <input type="image" type="submit"
                     src="/semi/images/memberjoin.png" width="150px" height="150px">
                  <br>
                  <h4>일반 회원 가입</h4>
               </form>
            </div>
            
            <div style="width: 250px; height: 250px;" class="box2" align = "center">&nbsp;
               <form action="/semi/workercheck">
               <input type = "hidden" name = "worker" value = "y">
                  <input type="image" type="submit"
                     src="/semi/images/workerjoin.png" width="150px" height="150px">
                  <br>
                  <h4>사업자 회원 가입</h4>
               </form>
            </div>

         </div>
         
      </div>

   <br><br><br>
<script src="jquery/jquery.min.js"></script>
   <script src="jqueryintro/bootstrap.bundle.min.js"></script>
   <script src="jquery/bootstrap.bundle.min.js"></script>
   <%@ include file="../../footer.jsp"%>
</body>

</html>