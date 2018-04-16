<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="member.model.vo.Member,java.util.*"%>
<%
	
%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>아이디 비밀번호 찾기</title>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script>

 function checkId(){
	 var name = document.getElementById("smemberName").value;
	 var idnumber = document.getElementById("smemberIdNumber").value;
	 var email = document.getElementById("smemberEmail").value;
	 $.ajax({
		 url:"/semi/mfid",
		 data:{name:name,idnumber:idnumber,email:email},
		 type:"post",
		 dataType:"json",
		 success : function(data) {
			 var jsonStr = JSON.stringify(data);
			 var Json = JSON.parse(jsonStr);
			 if(data!=0){
					$('#checkMessage').html(Json.smemberid);
					$('#checkType').attr('class', 'modal-content panel-warning');
				}
				$('#checkModal').modal("show");
			}
	 	
	 })
 }

 function checkPwd(){
	 var id = document.getElementById("smemberId").value;
	 var hint = document.getElementById("pwdHint").value;
	 var ans = document.getElementById("pwdAnswer").value;
	 $.ajax({
		 url:"/semi/mfpwd",
		 data:{id:id, hint:hint, ans:ans},
		 type:"post",
		 dataType:"json",
		 success : function(data) {
			 var jsonStr = JSON.stringify(data);
			 var Json = JSON.parse(jsonStr);
			 if(data!=0){
					$('#checkMessage').html(Json.smemberPwd);
					$('#checkType').attr('class', 'modal-content panel-warning');
				}
				$('#checkModal').modal("show");
			}
	 	
	 })
 }
 
 
</script>

<style>
table.type09 {
	border-collapse: collapse;
	text-align: left;
	line-height: 1.5;
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
 
button#btn11 {
	border: 1px solid skyblue;
	color: white;
	text-align: center;
	background: #007bff;
	border-radius: 12px;
}


.container4 {
	margin: 5%;
}

div#checkMessage {
	color: white;
	background: navy;
	border-radius: 5px;
}

div.modal-footer {
	background: white;
	border-radius: 5px;
	pointer-events: auto;
}
div.find1{
float : left;
width : 48%;
margin : 0 auto;
}
div.find2{
float : right;
width : 48%;
margin : 0 auto;
}
</style>

<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/1-col-portfolio.css" rel="stylesheet">
<link href="cssintro/modern-business.css" rel="stylesheet">
</head>
<body>
	<%@ include file="../../header.jsp"%>
	<br>
	<div class="container">

		<h1>
			아이디/비밀번호 <small>찾기</small>
			<hr color="gray">
		</h1>
		<br>
		<br>
	<div class="row">

		<div class = "find1">
			<!-- <form name="findid" action="/semi/mfid" method="post"> -->
				<table class="type09">
					<tbody>
						<tr align="center">
							<th colspan="2">아이디 찾기</th>
						</tr>
						<tr>
							<th>1. 이 름</th>
							<td><input type="text" name="smemberName" id="smemberName">&nbsp;
							</td>
						</tr>

						<tr>
							<th>2. 주민번호 앞자리</th>
							<td><input type="text" name="smemberIdNumber" id="smemberIdNumber" maxlength="6" size="6">
							</td>
						</tr>
						<tr>
							<th>3. 이메일</th>
							<td><input type="email" name="smemberEmail" id="smemberEmail"></td>
						</tr>
					</tbody>
				</table>
				<br>
			<button class="btn btn-primary"
						 onclick="checkId();">아이디찾기</button>


		<!-- 	</form> -->




		</div>
		<br>
		<div class = "find2">
				<table class="type09">
					<tbody>
						<tr align="center">
							<th colspan="2">비밀번호찾기</th>
						</tr>
						<tr>
							<th>1. 아이디</th>
							<td><input type="text" name="smemberId" id="smemberId">
							</td>
						</tr>
						<tr>
							<th>2. 비밀번호 힌트</th>
							<td><select name="pwdHint" id="pwdHint">
									<option value="비밀번호 찾기용 힌트선택">비밀번호 찾기용 힌트선택</option>
									<option value="좋아하는 숫자는?">좋아하는 숫자는?</option>
									<option value="제일 좋아하는 것은?">제일 좋아하는 것은?</option>
									<option value="내가 살던 동네는?">내가 살던 동네는?</option>
							</select></td>
						</tr>
						<tr>
							<th>3. 비밀번호 힌트 답</th>
							<td><input type="text" name="pwdAnswer" id="pwdAnswer"></td>
						</tr>
					</tbody>
				</table>

			<br>
			<button class="btn btn-primary"
						 onclick="checkPwd();">비밀번호 찾기</button>
		

		</div>
</div>
	</div>

<%-- 모달띠우기 --%>

<div class="modal fade" id="checkModal" tabindex="-1" role="dialog"
		aria-hidden="true">
		<div class="vertical-aligment-helper">
			<div class="modal-dialog vertical-align-center">
				<div id="checkType" class="modal-content panel-info">
					<div class="modal-header panel-heading">
						<h4 class="modal-title">확인 메세지</h4>
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">&times;</span> <span class="sr-only">close</span>
						</button>

					</div>
				</div>
				<div class="modal-body" id="checkMessage"></div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" data-dismiss="modal">확인</button>
				</div>
			</div>
		</div>
	</div>
	<br>
	<br>
	<%@ include file="../../footer.jsp"%>
</body>
</html>