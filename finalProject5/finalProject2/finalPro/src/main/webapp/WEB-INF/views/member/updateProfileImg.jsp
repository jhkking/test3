<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>프로필 사진 수정</title>

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

        //사진 미리보기
        function fileInfo(f){
    		var file = f.files; // files 를 사용하면 파일의 정보를 알 수 있음

    		var reader = new FileReader(); // FileReader 객체 사용
    		reader.onload = function(rst){ // 이미지를 선택후 로딩이 완료되면 실행될 부분
    			/* $('#img_box').html('<img margin-left="150px" height="200px" width="150px" src="' + rst.target.result + '">'); */ // append 메소드를 사용해서 이미지 추가
    			$(".originImg").remove();
    			$("#originImg").remove();
    			$('#img_box').html('<img margin-left="150px" height="200px" width="150px" src="' + rst.target.result + '">'); // append 메소드를 사용해서 이미지 추가
    			// 이미지는 base64 문자열로 추가
    			// 이 방법을 응용하면 선택한 이미지를 미리보기 할 수 있음
    			
    			$("#defaultImg").css("visibility","visible");
    		}
    		reader.readAsDataURL(file[0]); // 파일을 읽는다, 배열이기 때문에 0 으로 접근
    	}
        
        function success(){
        	alert("회원님의 프로필 사진이 변경되었습니다.");
        }
        
   </script>

</head>
<body>

	<div id="wrap">
		<br> <b><font size="4" color="gray">프로필 사진 수정</font></b>
		<hr size="1" width="460">
		<br>
		<form enctype="multipart/form-data" method="post"
			action="imgupdate.do?member_id=${loginUser.member_id }">
			<div>
				<label for="memberImage">이미지 파일을 선택해 주세요.</label><br>
				<br>
				<div style="text-align: center;">
					<!-- multiple 속성 제거하여 한번에 하나의 파일만 업로드 하도록 -->
					<!-- <input id="file1" type="file" style="width:50px height=80px" accept="image/*" onchange="fileInfo(this)"  name="upFile"/><br> -->
					<input type="file" name="upFile" onchange="fileInfo(this)"
						id="myimg" /><br> 
						<span style="margin-right: 500"
						id="img_box"></span>
						<span style="margin-right: 500"
						id="img_box2" class="originImg">
						<img id="originImg" margin-left="150px" height="200px" width="150px" src="/finalPro/img/mimg/${member.img_rename_filename }"></span><br>
					<br>
					<!-- <button type="submit" name="updateDef" id="updateDef">기본 이미지로 변경</button> -->
					<input type="hidden" name="oldori"  value="${member.img_original_filename }">
					<input type="hidden" name="oldre"  value="${member.img_rename_filename }">
					<button type="submit" style="visibility: hidden" id="defaultImg"
						onclick="success()">변경하기</button>
				</div>
			</div>
		</form>
	</div>

</body>

</html>