<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>

<style>
.login input[type=email] {
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

.login input[type=text] {
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

.login input[type=button] {
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
	margin-top: -1000px;
}
/* .login input[type=button]:hover{
opacity: 0.8;
} */
</style>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>

<script type="text/javascript">

function loginAgain(){
	self.opener = self;
	window.close();
   }

$(function(){
	allHideMsg();
})


function allHideMsg(){
	$(".alert").css("visibility", "hidden");
}

        var httpRequest = null;
        
        // httpRequest 객체 생성
        function getXMLHttpRequest(){
            var httpRequest = null;
        
            if(window.ActiveXObject){
                try{
                    httpRequest = new ActiveXObject("Msxml2.XMLHTTP");    
                } catch(e) {
                    try{
                        httpRequest = new ActiveXObject("Microsoft.XMLHTTP");
                    } catch (e2) { httpRequest = null; }
                }
            }
            else if(window.XMLHttpRequest){
                httpRequest = new window.XMLHttpRequest();
            }
            return httpRequest;    
        }
        
        // 아이디 중복체크
        function idCheck(){
 
            var id = document.getElementById("userId").value;
 
            if (!id) {
                /* alert("아이디를 입력하지 않았습니다."); */
                allHideMsg();
                $("#retry_msg").css("visibility","visible")
                return false;
            } 
            else if((id < "0" || id > "9") && (id < "A" || id > "Z") && (id < "a" || id > "z")){ 
                alert("한글 및 특수문자는 아이디로 사용하실 수 없습니다.");
                return false;
            }
            else
            {
           		$.ajax({
            		type: 'POST',
            		dataType:"json",
            		url: 'memberIdCheckAction.do',
            		data:{id:id},
            		success:function(rs) {
                        allHideMsg();
            			if(rs.code == 'success'){
            				$("#ok_msg").css("visibility","visible");
            			}else if(rs.code == 'fail'){
            				$("#pwdHint").css("visibility","visible");
            				$("#hintMsg").css("visibility","visible");
            				$("#idChk").css("visibility","hidden");
            				$("#findBtn").css("visibility","visible");
            				$("#pwdAnswer").css("visibility","visible");
            				$("#userId").css("read-only","read-only");
            				$("#pwdHint").val(decodeURIComponent(rs.pwd.replaceAll("+"," ")));
            				
            			}
            		},
            		error:function(rs){
            			alert("에러 발생! 관리자에게 문의하세요.");
            		}
            	});
            }
        }
        
        //비밀번호 메일
        $(document).on("click",'#findBtn',function(){
        	 var pwdAnswer = $('#pwdAnswer').val();
        	 var id = $("#userId").val();
        	$.ajax({
                url:'mailSending.do',
                type:'POST',
                data: { pwdAnswer : pwdAnswer, id : id },
                /* contentType: "application/x-www-form-urlencoded", */
                /* dataType : "json", */
        		
                success:function(result){
                	/* var idLists = data.member_id;
                	var idLength = idLists.length;
                	var idfind = idLists.substring(1, idLength-1);
               	 		 $("#idList").append("<p>"+"찾으시는 회원님의 아이디는<b> "+idfind+"</b> 입니다.</p>") */
    					if(result == "ok")
    						alert("회원님의 이메일로 임시비밀번호를 발송했습니다!");
    					else
    						alert("정보를 다시 입력해주시길 바랍니다.")
                },
                error: function (XMLHttpRequest, textStatus, errorThrown){
                	alert('정보를 다시 입력해주시길 바랍니다.');
                }
            });
        });
        
        String.prototype.replaceAll = function(org, dest) {
            return this.split(org).join(dest);
        }

</script>

</head>
<body>
	<h2 align="center">비밀번호 찾기</h2>
	<div align="center">
		<form>
			<div class="login">
				<input type="text" name="member_id" id="userId"
					placeholder="아이디를 입력해 주세요." /><br>
				<br> <input type="button" value="아이디 확인" onclick="idCheck()"
					id="idChk" />
				<div id="retry_msg" class="alert">
					<font color=red><b>아이디를 입력해주세요.</b></font>
				</div>
				<div id="ok_msg" class="alert">
					<font color=red><b>입력하신 아이디를 찾을수가 없습니다.</b></font>
				</div>
				<h2 align="center" style="margin-top: -60px" id="hintMsg"
					class="alert">비밀번호 힌트</h2>
				<!-- <select name="pwd_hint" class="alert" id="pwdHint">
						<option value="0">선택하세요</option>
						<option value="학창시절 내 별명은?">학창시절 내 별명은?</option>
						<option value="나의 보물 1호는?">나의 보물 1호는?</option>
						<option value="나의 고향은?">나의 고향은?</option>
						<option value="가장 기억에 남는 친구 이름은?">가장 기억에 남는 친구 이름은?</option>
						<option value="가장 좋아하는 음식은?">가장 좋아하는 음식은?</option>
		</select><br> -->
				<input type="text" name="pwd_hint" class="alert" id="pwdHint"
					readonly /><br>
				<br> <input type="text" name="pwd_answer" id="pwdAnswer"
					class="alert" placeholder="답변을 입력해 주세요." /><br>
				<br> <input type="button" value="비밀번호 찾기 " id="findBtn"
					class="alert" /><br><br>
				<p align="center" style="margin-top: -10px">
					로그인 페이지로 가시려면 <a onclick="loginAgain()"
						style="color: blue; cursor: pointer">로그인페이지</a>를 클릭하세요.
				</p>
			</div>

		</form>
	</div>

</body>
</html>