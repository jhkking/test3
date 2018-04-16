<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>

<style>
.login input[type=email]{
width: 200px;
height: 20px;
background: transparent;
border: 1px solid blue;
border-radius: 2px;
color: black;
font-family: 'Exo', sans-serif;
font-size: 16px;
font-weight: 400;
padding: 4px;
}

.login input[type=text]{
width: 200px;
height: 20px;
background: transparent;
border: 1px solid blue;
border-radius: 2px;
color: black;
font-family: 'Exo', sans-serif;
font-size: 16px;
font-weight: 400;
padding: 4px;
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
.login input[type=button]:hover{
opacity: 0.8;
}
</style>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>

<script type="text/javascript">

function loginAgain(){
	self.opener = self;
	window.close();
   }

$(document).on('click','#findId',function(){
	
	var name = $("#member_name").val();
    var email = $("#email").val();
    if(name == ""){
        alert("회원님의 이름을 입력해주세요.");
        $("#member_name").focus(); // 입력포커스 이동
        return false; // 함수 종료
    }
    if(email == ""){
        alert("이메일을 입력해주세요.");
        $("#email").focus();
        return false;
    }
    
	var memberName = $('#member_name').val();
 	var email = $('#email').val();

 	var postData = {memberName : memberName , email : email};

    $.ajax({
		url: "findingId.do",
		type: "post",
		data: postData,
		dataType: "json",
		success: function(data){
			var values ="";
			
				values +=data.userid;
				$("#idList").html("");
			 $("#idList").append("<p>"+"찾으시는 회원님의 아이디는<b> "+values+"</b> 입니다.</p>");
		},
		error: function(request, status, errorData){
			/* alert("error code : " + request.status + "\n"
					+ "message : " + request.responseText + "\n"
					+ "error : " + errorData); */
			$("#idList").html("");
			 $("#idList").append("<p style='color:red'>회원님의 정보를 잘못 입력하셨습니다.</p>");
			}
	});
});

		
	
	</script>
	
</head>
<body>
<h2 align="center">아이디 찾기</h2>
<div align="center">
<form name="searchId">
	<div class="login">
		<input type="text"  name="member_name" id ="member_name" placeholder="이름을 입력해 주세요." /><br><br>
		<input type="email"  name="email" id ="email" placeholder="이메일을 입력해 주세요."  /><br>
		<input type="button" value="아이디 찾기 " id="findId" />
		<span id="idList"></span>
		
	</div>

</form>
</div> 
<p align="center">로그인 페이지로 가시려면 <a onclick="loginAgain()" style="color:blue; cursor:pointer">로그인페이지</a>를 클릭하세요.</p>
</body>
</html>