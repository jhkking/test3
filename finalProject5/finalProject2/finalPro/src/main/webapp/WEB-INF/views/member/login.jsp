<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인페이지</title>
<style type="text/css">
/* NOTE: The styles were added inline because Prefixfree needs access to your styles and they must be inlined if they are on local disk! */
@import url(https://fonts.googleapis.com/css?family=Exo:100,200,400);
@import url(https://fonts.googleapis.com/css?family=Source+Sans+Pro:700,400,300);

body{
margin: 0;
padding: 0;
background: #fff;

color: #fff;
font-family: Arial;
font-size: 12px;
}

.body{
position: absolute;
top: -20px;
left: -20px;
right: -40px;
bottom: -40px;
width: auto;
height: auto;
background-image: url(http://ginva.com/wp-content/uploads/2012/07/city-skyline-wallpapers-008.jpg);
background-size: cover;
-webkit-filter: blur(5px);
z-index: 0;
}

.grad{
position: absolute;
top: -20px;
left: -20px;
right: -40px;
bottom: -40px;
width: auto;
height: auto;
background: -webkit-gradient(linear, left top, left bottom, color-stop(0%,rgba(0,0,0,0)), color-stop(100%,rgba(0,0,0,0.65))); /* Chrome,Safari4+ */
z-index: 1;
opacity: 0.7;
}

.header{
position: absolute;
top: calc(50% - 35px);
left: calc(50% - 255px);
z-index: 2;
}

.header div{
float: left;
color: #fff;
font-family: 'Exo', sans-serif;
font-size: 35px;
font-weight: 200;
}

.header div span{
color: #5379fa !important;
}

.login{
position: absolute;
top: calc(50% - 75px);
left: calc(55% - 50px);
height: 150px;
width: 350px;
padding: 10px;
z-index: 2;
}

.login input[type=text]{
width: 250px;
height: 30px;
background: transparent;
border: 1px solid rgba(255,255,255,0.6);
border-radius: 2px;
color: #fff;
font-family: 'Exo', sans-serif;
font-size: 16px;
font-weight: 400;
padding: 4px;
}

.login input[type=password]{
width: 250px;
height: 30px;
background: transparent;
border: 1px solid rgba(255,255,255,0.6);
border-radius: 2px;
color: #fff;
font-family: 'Exo', sans-serif;
font-size: 16px;
font-weight: 400;
padding: 4px;
margin-top: 10px;
}

.login input[type=submit]{
width: 260px;
height: 35px;
background: #fff;
border: 1px solid #fff;
cursor: pointer;
border-radius: 2px;
color: #a18d6c;
font-family: 'Exo', sans-serif;
font-size: 16px;
font-weight: 400;
padding: 6px;
margin-top: 10px;
}
.login input[type=button]{
width: 260px;
height: 35px;
background: #fff;
border: 1px solid #fff;
cursor: pointer;
border-radius: 2px;
color: #a18d6c;
font-family: 'Exo', sans-serif;
font-size: 16px;
font-weight: 400;
padding: 6px;
margin-top: 10px;
}

.login input[type=submit]:hover{
opacity: 0.8;
}
.login input[type=button]:hover{
opacity: 0.8;
}

.login input[type=submit]:active{
opacity: 0.6;
}
.login input[type=button]:active{
opacity: 0.6;
}

.login input[type=text]:focus{
outline: none;
border: 1px solid rgba(255,255,255,0.9);
}

.login input[type=password]:focus{
outline: none;
border: 1px solid rgba(255,255,255,0.9);
}

.login input[type=submit]:focus{
outline: none;
}
.login input[type=button]:focus{
outline: none;
}

::-webkit-input-placeholder{
color: rgba(255,255,255,0.6);
}

::-moz-input-placeholder{
color: rgba(255,255,255,0.6);
}
</style>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script>
    $(document).ready(function(){
        $("#btnLogin").click(function(){
            // 태크.val() : 태그에 입력된 값
            // 태크.val("값") : 태그의 값을 변경 
            var userId = $("#member_id").val();
            var userPw = $("#member_pwd").val();
            if(userId == ""){
                alert("아이디를 입력하세요.");
                $("#member_id").focus(); // 입력포커스 이동
                return false; // 함수 종료
            }
            if(userPw == ""){
                alert("비밀번호를 입력하세요.");
                $("#member_pwd").focus();
                return false;
            }
            /* if(msg == "black"){
               alert("응 니블랙");
            } */
            // 폼 내부의 데이터를 전송할 주소
            document.form1.action="loginCheck.do"
            // 제출
            document.form1.submit();
        });
    });

    function searchId(){
       window.name = "parentForm";
        window.open("searchId.do",
                "chkForm", "width=500, height=300, resizable = no, scrollbars = no, left=500, top=200");
   }
    
    function searchPwd(){
          window.name = "parentForm";
           window.open("searchPwd.do",
                   "chkForm", "width=500, height=300, resizable = no, scrollbars = no, left=500, top=200");
      }
    
</script>
</head>
<body>
<h2>로그인</h2>
    
    
    <div class="body"></div>
      <div class="grad"></div>
      <div class="header">
         <a href="about.jsp" class="title"><div><b>Travel</b><span><b>Stargram</b></span></div></a>
         
         
         <!-- <tt style="color:red">T</tt><tt style="color:#E26812">r</tt><tt style="color:#FDE102">a</tt>
               <tt style="color:#03A200">v</tt><tt style="color:#030AF5">l</tt><tt style="color:#094B6E">e</tt>
               <tt style="color:#82108D">S</tt><tt style="color:red">t</tt><tt style="color:#E26812">a</tt>
               <tt style="color:#FDE102">r</tt><tt style="color:#03A200">g</tt><tt style="color:#030AF5">r</tt>
               <tt style="color:#094B6E">a</tt><tt style="color:#82108D">m</tt> -->
         
      </div>
      <br>
    <form name="form1" action="login.do" method="post">
    <fieldset id="login_fs">
      <div class="login">
      <input type="hidden" name="url" value="<?php echo $login_url ?>">
            <input type="text" placeholder="아이디" name="member_id" id="member_id" size="20" maxLength="20"><br>
            <input type="hidden" value="$('#member_id').val()">
            <input type="password" placeholder="비밀번호" name="member_pwd" id="member_pwd" size="20" maxLength="20"><br><br>
            <c:if test="${msg == 'failure'}">
                    <div style="color: red">
                        아이디 또는 비밀번호가 일치하지 않습니다.
                    </div>
                </c:if>
                <c:if test="${msg == 'black'}">
                    <div style="color: red;font-size:15px;font-weight:bold">
                        제한된 계정입니다. 관리자에게 문의하세요.
                    </div>
                </c:if>
                <br>
                <a style="font-size:15px" onClick="javascript:searchId()" href="#">아이디 찾기</a> &ensp; / &ensp; 
                <a style="font-size:15px" onClick="javascript:searchPwd()" href="#">비밀번호 찾기</a>
            <input type="submit" value="로그인" class="btn_submit" id="btnLogin">
              <input type="button" value="회원가입" class="btn_register" onClick="location.href='enrollForm.do'">
              
      </div>
      </fieldset>

      </form>
  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

</body>
</body>
</html>