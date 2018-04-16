<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>비밀번호 변경하기</title>

<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>

<style type="text/css">
#wrap {
	width: 490px;
	text-align: center;
	margin: 0 auto 0 auto;
}

#chk {
	text-align: center;
}

#cancelBtn {
	visibility: visible;
}

/* #useBtn{
             visibility:hidden;
        } */
.bottom_btn {
	padding-left: 33%;
}

.bottom_btn>input {
	float: left;
}

.bottom_btn>input:first-child {
	margin-right: 5%;
}
</style>

<script type="text/javascript">

//비밀번호 확인
function passwordCheckk(){
	  var password = document.getElementById("password").value;
	  var passwordCheck = document.getElementById("passwordCheck").value;
	  
	  if(passwordCheck == ""){
		  document.getElementById("passwordCheckText").innerHTML = ""
	  }else if(password != passwordCheck){
		  document.getElementById("passwordCheckText").innerHTML = "<b><font color=red>비밀번호가 일치하지 않습니다.</font></b>"
	  }else{
		  document.getElementById("passwordCheckText").innerHTML = "<b><font color=green>비밀번호가 일치합니다.<font></b>"
	  }
}

function success(){
	alert("회원님의 비밀번호가 변경되었습니다.")
}



      
   </script>

</head>
<body>

	<div id="wrap">
		<br> <b><font size="4" color="gray">비밀번호 변경하기</font></b>
		<hr size="1" width="460">
		<br>
		<div id="chk">
			<form id="checkForm" method="post"
				action="updatePassword.do?member_id=${loginUser.member_id }">
				<input type="password" name="member_pwd" id="password"
					maxlength="20" style="width: 250px" placeholder="변경할 비밀번호">
				<br> <input type="password" name="idinput" id="passwordCheck"
					maxlength="20" style="width: 250px" placeholder="비밀번호 확인"
					onkeyup="passwordCheckk()"> <br>
				<p class="help-block" id="passwordCheckText"></p>
				<br>
				<br>
				<div class="bottom_btn">
					<input id="cancelBtn" type="button" value="취소"
						onclick="window.close()"> <input id="useBtn" type="submit"
						value="변경하기" onclick="success()">
				</div>
			</form>
		</div>
	</div>

</body>

</html>