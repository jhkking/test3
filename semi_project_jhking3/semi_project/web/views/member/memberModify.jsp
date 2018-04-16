<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="member.model.vo.Member"%>
<%
	Member memberM = (Member) request.getAttribute("info");
%>
<!DOCTYPE html>

<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>PLACE</title>

<!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="css/1-col-portfolio.css" rel="stylesheet">
<link href="cssintro/modern-business.css" rel="stylesheet">
<style>
table {
	border-collapse: separate;
	border-spacing: 0px 4px
}

.modal-dialog {
	width: 450px;
	height: 350px;
}

#divv {
	width: 100%;
	height: 52px;
	background: #f3f6f7;
	border: 1px solid gray;
	margin-top: 30;
	padding-top: 9px;
}

#td_name {
	color: white;
}
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
}

.list-group-item:focus, .list-group-item#btn11.focus {
	background-color: #0069d9;
	color: #fff;
}
</style>

</head>


<body>
<%@ include file="../../header.jsp" %>
<form name = "modify" action="/semi/mupdate" method="post" onSubmit="return checkIt()">


	


	<!-- Page Content -->
	<div class="container">

		<!-- Page Heading/Breadcrumbs -->
		<h1 class="mt-4 mb-3">
			MY PAGE <small>내 정보 수정</small>
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
					<a href="memberDetail.jsp" class="list-group-item">내 정보 보기 및 수정</a> <a href="#"
						class="list-group-item">나의 관심 장소 보기</a> <a href="#"
						class="list-group-item">내가 쓴 글 보기</a>
				</div>
			</div>
			<!-- Content Column -->
			<div class="col-lg-9 mb-4">
				<h2>내 정보 보기 및 수정</h2>
				<div align="center">
					<table width="90%" class="type09">
						<tr align="center">
							<th colspan="2">나의 정보 수정</th>
						</tr>
						<tr>
							<th>1. 아이디</th>
							<td><input type="text" name="smemberid" value=<%=memberM.getSmemberId()%> readonly></td>
						</tr>
						<tr>
							<th>2-1. 새 비밀번호</th>
							<td><input type="password" name="smemberpwdA"></td>
						</tr>
						<tr>
							<th>2-2. 새 비밀번호 확인</th>
							<td><input type="password" name="smemberpwdB"></td>
						</tr>
						<tr>
							<th>3. 성 명</th>
							<td><input type="text" name="smembername" value=<%=memberM.getSmemberName()%> readonly></td>
						</tr>
						<tr>
							<th>4. 주민등록번호</th>
							<td><input type="text" maxlength="6" size="6"
								name="smemberidnumber" value=<%=memberM.getSmemberIdNumber()%> readonly> &nbsp;-&nbsp; <input type="password"
								maxlength="7" size="7" name="smemberidnumber1" value = "0000000" readonly></td>
						</tr>
						<tr>
							<th>5. 성 별</th>
							<td>
					<% 	if (memberM.getSmemberGender().equals("M")) { %>
					<input type="radio" name="gender" value="M" checked disabled>남 <input
					type="radio" name="gender" value="F" disabled>여 
					<%} else {%> 
					<input type="radio" name="gender" value="M" disabled>남 
					<input type="radio"	name="gender" value="F" checked disabled>여 
					<%} %></td>
						</tr>
						<tr>
							<th>6. 주  소</th>
							<td><input type="text" name="address" value=<%=memberM.getSmemberAddress()%>></td>
						</tr>
						<tr>
							<th>7. 연락처</th>
							<td>
							<%
							String str = "";
							for(int i = 0; i < 3; i++) { 	
							  str += memberM.getSmemberPhone().charAt(i);
							}%>
							<select name = "phone1">
							<%
							if(str.equals("010")) {
							%>
									<option value="010" selected="selected">010</option>
									<option value="011">011</option>
									<option value="016">016</option>
									<option value="017">017</option>
									<option value="019">019</option>
							<% }%>
							<%
							if(str.equals("011")) {
							%>
									<option value="010">010</option>
									<option value="011" selected="selected">011</option>
									<option value="016">016</option>
									<option value="017">017</option>
									<option value="019">019</option>
							<% }%>
							<%
							if(str.equals("016")) {
							%>
									<option value="010">010</option>
									<option value="011">011</option>
									<option value="016" selected="selected">016</option>
									<option value="017">017</option>
									<option value="019">019</option>
							<% }%>
							<%
							if(str.equals("017")) {
							%>
									<option value="010">010</option>
									<option value="011">011</option>
									<option value="016">016</option>
									<option value="017" selected="selected">017</option>
									<option value="019">019</option>
							
							<% }%>
							
							<%
							if(str.equals("019")) {
							%>
									<option value="010">010</option>
									<option value="011">011</option>
									<option value="016">016</option>
									<option value="017">017</option>
									<option value="019" selected="selected">019</option>
							<% }%>
							</select>
							<%
							String str2 = "";
							for(int i = 4; i < 8; i++) { 	
							  str2 += memberM.getSmemberPhone().charAt(i);
							}%>
							-<input name = "phone2" type="text" maxlength="4" size="4" value=<%=str2%>> 
							<%
							String str3 = "";
							for(int i = 9; i < memberM.getSmemberPhone().length(); i++) { 	
							  str3 += memberM.getSmemberPhone().charAt(i);
							}%>
							-<input name = "phone3"	type="text" maxlength="4" size="4" value=<%=str3 %>></td>
								
						</tr>

						<tr>
							<th>8. 이메일</th>
							<td><input type="email" name="email" value=<%=memberM.getSmemberEmail() %>></td>
						</tr>
					</table>
					<br>
					<table>
					<tr align = "center"><td>
					<b>본인 확인을 위해 현재 비밀번호를 입력해주세요.</b>
					</td></tr>
					<tr align = "center"><td>
					<input type = "hidden" name = "memberpwdA" id = "memberpwdA" value =<%=memberM.getSmemberPwd()%>>
					<input type = "password" name = "memberpwd" id = "memberpwd" value = "">
					</td></tr>
					<tr align = "center"><td>
					</td></tr>
					</table>
					<br> <br> 
					<input type = "submit" class="btn btn-primary" value="수정">
				</div>
			</div>
		</div>
		<!-- /.row -->

	</div>

</form>
	<%@ include file="../../footer.jsp"%>
</body>
<script>

   function checkIt(){
	   if(!document.modify.smemberpwdA.value){
     	  alert("변경할 비밀번호를 입력하지 않으셨습니다.");
           return false;
       }
       if(document.modify.smemberpwdA.value != document.modify.smemberpwdB.value ){
           alert("새 비밀번호가 일치하지 않습니다.");
           return false;
         }
          if(document.modify.memberpwd.value != document.modify.memberpwdA.value ){
            alert("현재 비밀번호가 일치하지 않습니다.");
            return false;
          }
        }

</script>
</html>
