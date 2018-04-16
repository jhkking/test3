<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>


<script type="text/javascript">
	//프로필 사진 수정 페이지
	function updateImg() {
		window.name = "parentForm";
		window
				.open("updateImg.do?member_id=${loginUser.member_id}",
						"updateImg",
						"width=500, height=300, resizable = no, scrollbars = no, left=400");
	}
	//패스워드 수정
	function updatePassword() {
		window.name = "parentForm";
		window
				.open(
						"updatePasswordForm.do?member_id=${loginUser.member_id }'",
						"updatePass",
						"width=500, height=300, resizable = no, scrollbars = no, left=400");
	}

	function fileInfo(f) {
		var file = f.files; // files 를 사용하면 파일의 정보를 알 수 있음

		var reader = new FileReader(); // FileReader 객체 사용
		reader.onload = function(rst) { // 이미지를 선택후 로딩이 완료되면 실행될 부분
			$('#img_box')
					.html(
							'<img margin-left="150px" height="200px" width="150px" src="' + rst.target.result + '">'); // append 메소드를 사용해서 이미지 추가
			// 이미지는 base64 문자열로 추가
			// 이 방법을 응용하면 선택한 이미지를 미리보기 할 수 있음
		}
		reader.readAsDataURL(file[0]); // 파일을 읽는다, 배열이기 때문에 0 으로 접근
	}

	//비밀번호 확인
	function passwordCheckk() {
		var password = document.getElementById("password").value;
		var passwordCheck = document.getElementById("passwordCheck").value;

		if (passwordCheck == "") {
			document.getElementById("passwordCheckText").innerHTML = ""
		} else if (password != passwordCheck) {
			document.getElementById("passwordCheckText").innerHTML = "<b><font color=red>비밀번호가 일치하지 않습니다.</font></b>"
		} else {
			document.getElementById("passwordCheckText").innerHTML = "<b><font color=green>비밀번호가 일치합니다.<font></b>"
		}
	}

	//주소 수정
	function updateAddress() {
		$("#updateAddr").css("visibility", "visible");
		/* $('#originAddress').remove();
		$('#addressLabel').remove();
		$('#uAddrBtn').remove(); */
		$('#addressDiv').remove();
	}
</script>


<script type="text/javascript">
	//주소 api
	function sample6_execDaumPostcode() {
		new daum.Postcode(
				{
					oncomplete : function(data) {
						// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

						// 각 주소의 노출 규칙에 따라 주소를 조합한다.
						// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
						var fullAddr = ''; // 최종 주소 변수
						var extraAddr = ''; // 조합형 주소 변수

						// 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
						if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
							fullAddr = data.roadAddress;

						} else { // 사용자가 지번 주소를 선택했을 경우(J)
							fullAddr = data.jibunAddress;
						}

						// 사용자가 선택한 주소가 도로명 타입일때 조합한다.
						if (data.userSelectedType === 'R') {
							//법정동명이 있을 경우 추가한다.
							if (data.bname !== '') {
								extraAddr += data.bname;
							}
							// 건물명이 있을 경우 추가한다.
							if (data.buildingName !== '') {
								extraAddr += (extraAddr !== '' ? ', '
										+ data.buildingName : data.buildingName);
							}
							// 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
							fullAddr += (extraAddr !== '' ? ' (' + extraAddr
									+ ')' : '');
						}

						// 우편번호와 주소 정보를 해당 필드에 넣는다.
						document.getElementById('sample6_postcode').value = data.zonecode; //5자리 새우편번호 사용
						document.getElementById('sample6_address').value = fullAddr;

						// 커서를 상세주소 필드로 이동한다.
						document.getElementById('sample6_address2').focus();
					}
				}).open();
	}
	
	function mdeleteChk(){
		if(confirm("탈퇴하시겠습니까?")){
			location.href='mdelete.do?member_id=${loginUser.member_id }';
			alert("회원 탈퇴가 완료되었습니다.")
		}else{
			return;
		}
	}
	
	//수정취소 버튼
	function cancel(){
		location.href='about.jsp';
	}
	
	//회원정보 수정 성공 알림
	function success(){
		alert("회원님의 정보가 성공적으로 수정되었습니다.");
	}
	
	
</script>


<meta charset="utf-8">

<title>회원 정보 수정</title>

<style>
div.image {
	background-image:
		url("http://file1.bobaedream.co.kr/strange/2015/02/25/23/1424874579805.jpg");
}
</style>

<!-- 다음 주소 API 소스 -->
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>

<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!--          <link rel="stylesheet" href="css/font-awesome.min.css" media="screen" title="no title" charset="utf-8"> -->

<link rel="stylesheet" href="css/style.css" media="screen"
	title="no title" charset="utf-8">

</head>
<body>


	<article class="container">
		<div class="page-header">
			<h1>회원 정보 수정</h1>


		</div>
		<br>
		<button href="loginForm.do" class="btn btn-warning"
			style="cursor: pointer;" onclick="updatePassword()">비밀번호 수정</button>
		<br> <br>
		<button type="button" onclick="updateImg()" class="btn btn-warning"
			style="cursor: pointer; margin-left: -855px">프로필 사진 수정</button>

		<div class="col-md-6 col-md-offset-3" style="margin-top: -50px">
			<form action="mupdate.do" method="post" name="updateuserInfo"
				enctype="multipart/form-data">
				<div class="form-group">
					<label for="id">아이디</label><br>
					<div style="float: left;">
						<input name="member_id" type="text" readonly class="form-control"
							value="${member.member_id}">
					</div>


					<br>

				</div>
				<!-- <div class="form-group">
					<label for="InputPassword1">비밀번호</label> <input type="password"
						class="form-control" id="password" placeholder="비밀번호"
						style="width: 200px" name="member_pwd">
				</div>
				<div class="form-group">
					<label for="InputPassword2">비밀번호 확인</label> <input type="password"
						class="form-control" id="passwordCheck" placeholder="비밀번호 확인"
						style="width: 200px" name="member_pwd2" onkeyup="passwordCheckk()">
					<p class="help-block" id="passwordCheckText"></p>
				</div> -->
				<div class="form-group">
					<label for="membername">이름</label> <input type="text"
						class="form-control" style="width: 200px" readonly
						value="${member.member_name}">
				</div>

				<!-- <div>
					<label for="memberImage">프로필 사진 첨부</label><br>
					<div style="text-align: center;">
						multiple 속성 제거하여 한번에 하나의 파일만 업로드 하도록
						<input id="file1" type="file" style="width:50px height=80px" accept="image/*" onchange="fileInfo(this)"  name="upFile"/><br>
						<input type="file" name="upFile" onchange="fileInfo(this)" /><br>
						<span style="margin-right: 500" id="img_box"></span>
					</div>
				</div> -->

				<div class="form-group">
					<label for="pwdhint">비빌번호 힌트</label>
					<!-- <select name="pwd_hint" class="form-control">
						<option value="0">선택하세요</option>
						<option value="별명">학창시절 내 별명은?</option>
						<option value="보물">나의 보물 1호는?</option>
						<option value="고향">나의 고향은?</option>
						<option value="친구">가장 기억에 남는 친구 이름은?</option>
						<option value="음식">가장 좋아하는 음식은?</option>
				</select> -->
					<input type="text" class="form-control" name="pwd_hint" readonly
						value="${member.pwd_hint}">
				</div>
				<div class="form-group">
					<label for="pwdanswer">비밀번호 답변</label>
					<div class="input-group">
						<input type="text" class="form-control" name="pwd_answer" readonly
							value="${member.pwd_answer}">
					</div>
				</div>

				<div class="form-group">
					<label for="birth">생년월일</label>
					<div class="input-group">
						<input type="date" class="form-control" id="memberbirth"
							placeholder="yy/mm/dd" name="member_birth"
							value="${member.member_birth}" readonly>
					</div>
				</div>

				<div class="form-group">
					<label for="phone">핸드폰</label> <input type="tel" name="phone"
						id="phone" maxlength="13" value="${member.phone}">
				</div>

				<div class="form-group">
					<label for="username">이메일</label> <input type="email" name="email"
						class="form-control" value="${member.email}">
				</div>

				<div class="form-group" id="addressDiv" style="margin-bottom:-180px">

					<label for="address" id="addressLabel">주소</label>&ensp;
					<button type="button" onclick="updateAddress()" id="uAddrBtn">주소
						수정하기</button>
					<input type="text" id="originAddress" class="form-control"
						value="${member.address}" readonly>

				</div>
				<div class="form-group"
					style="visibility: hidden; margin-bottom: 100px" id="updateAddr">
					<label for="address">주소 입력</label> <input type="text"
						id="sample6_postcode" name="address" placeholder="우편번호"> <input
						type="button" onclick="sample6_execDaumPostcode()" name="address"
						value="우편번호 찾기"><br> <input type="text"
						id="sample6_address" name="address" placeholder="주소"
						style="width: 500px" class="form-control"> <input
						type="text" id="sample6_address2" name="address"
						placeholder="상세주소" class="form-control" style="width: 400px">
					<span id="guide" style="color: #999"></span>
				</div>



				<div class="form-group text-center" >
					<button type="submit" class="btn btn-info" onclick="success()">
						수정하기
					</button>
					<button type="button" class="btn btn-warning"
						onClick="mdeleteChk()">
						회원탈퇴
					</button>
					<button type="button" class="btn btn-warning"
						onClick="cancel()">
						수정 취소
					</button>

				</div>
			</form>
		</div>

	</article>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<!-- <script src="js/bootstrap.min.js"></script> -->
</body>
</html>
