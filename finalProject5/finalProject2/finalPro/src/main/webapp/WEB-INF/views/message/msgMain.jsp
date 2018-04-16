<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<link rel="stylesheet" href="bootstrap-3.3.7/css/bootstrap.min.css"
	id="bootstrap-css" />
<script type="text/javascript" src="bootstrap-3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<title>msg</title>
<style>
.mytext {
	border: 0;
	padding: 10px;
	background: whitesmoke;
}

.text {
	width: 75%;
	display: flex;
	flex-direction: column;
}

.text>p:first-of-type {
	width: 100%;
	margin-top: 0;
	margin-bottom: auto;
	line-height: 13px;
	font-size: 12px;
}

.text>p:last-of-type {
	width: 100%;
	text-align: right;
	color: silver;
	margin-bottom: -7px;
	margin-top: auto;
}

.text-l {
	float: left;
	padding-right: 10px;
}

.text-r {
	float: right;
	padding-left: 10px;
}

.avatar {
	display: flex;
	justify-content: center;
	align-items: center;
	width: 25%;
	float: left;
	padding-right: 10px;
}

.macro {
	margin-top: 5px;
	width: 85%;
	border-radius: 5px;
	padding: 5px;
	display: flex;
}

.msj-rta {
	float: right;
	background: whitesmoke;
}

.msj {
	float: left;
	background: white;
}

.frame {
	background: #e0e0de;
	height: 450px;
	overflow: hidden;
	padding: 0;
}

.frame>div:last-of-type {
	position: absolute;
	bottom: 0;
	width: 100%;
	display: flex;
}

body>div>div>div:nth-child(2)>span {
	background: whitesmoke;
	padding: 10px;
	font-size: 21px;
	border-radius: 50%;
}

body>div>div>div.msj-rta.macro {
	margin: auto;
	margin-left: 1%;
}

#ul1 {
	width: 100%;
	list-style-type: none;
	padding: 18px;
	position: absolute;
	bottom: 47px;
	display: flex;
	flex-direction: column;
	top: 0;
	overflow-y: scroll;
}

.msj:before {
	width: 0;
	height: 0;
	content: "";
	top: -5px;
	left: -14px;
	position: relative;
	border-style: solid;
	border-width: 0 13px 13px 0;
	border-color: transparent #ffffff transparent transparent;
}

.msj-rta:after {
	width: 0;
	height: 0;
	content: "";
	top: -5px;
	left: 14px;
	position: relative;
	border-style: solid;
	border-width: 13px 13px 0 0;
	border-color: whitesmoke transparent transparent transparent;
}

input:focus {
	outline: none;
}

::-webkit-input-placeholder { /* Chrome/Opera/Safari */
	color: #d4d4d4;
}

::-moz-placeholder { /* Firefox 19+ */
	color: #d4d4d4;
}

:-ms-input-placeholder { /* IE 10+ */
	color: #d4d4d4;
}

:-moz-placeholder { /* Firefox 18- */
	color: #d4d4d4;
}

.col-sm-offset-4 {
	margin-left: 0%;
	width: 25%;
	height: 600px;
}

.col-sm-4 {
	margin-left: 25%;
	width: 25%;
	height: 600px;
	overflow-y: scroll;
}

img.mimg {
	border-radius: 28px 28px 28px 28px;
	height: 50px;
	width: 50px;
}
</style>
<script>
   var me = {};
   me.avatar = "https://lh6.googleusercontent.com/-lr2nyjhhjXw/AAAAAAAAAAI/AAAAAAAARmE/MdtfUmC0M4s/photo.jpg?sz=48";

   var you = {};
   you.avatar = "https://a11.t26.net/taringa/avatares/9/1/2/F/7/8/Demon_King1/48x48_5C5.jpg";

   function formatAMPM(date) {
      var hours = date.getHours();
      var minutes = date.getMinutes();
      var ampm = hours >= 12 ? 'PM' : 'AM';
      hours = hours % 12;
      hours = hours ? hours : 12; // the hour '0' should be '12'
      minutes = minutes < 10 ? '0' + minutes : minutes;
      var strTime = hours + ':' + minutes + ' ' + ampm;
      return strTime;
   }

   //-- No use time. It is a javaScript effect.
   function insertChat(who, text, time) {
      if (time === undefined) {
         time = 0;
      }
      var control = "";
      var date = formatAMPM(new Date());

      if (who == "me") {
         control = '<li style="width:250px">'
               + '<div class="msj macro">'
               + '<div class="avatar"><img class="img-circle" style="width:100%;" src="'
               + me.avatar + '" /></div>' + '<div class="text text-l">'
               + '<p>' + text + '</p>' + '<p><small>' + date
               + '</small></p>' + '</div>' + '</div>' + '</li>';
      } else {
         control = '<li style="width:250px;">'
               + '<div class="msj-rta macro">'
               + '<div class="text text-r">'
               + '<p>'
               + text
               + '</p>'
               + '<p><small>'
               + date
               + '</small></p>'
               + '</div>'
               + '<div class="avatar" style="padding:0px 0px 0px 10px !important"><img class="img-circle" style="width:100%;" src="'
               + you.avatar + '" /></div>' + '</li>';
      }
      setTimeout(
            function() {
               $("#ul1").append(control).scrollTop(
                     $("#ul1").prop('scrollHeight'));
            }, time);

   }

   function resetChat() {
      $("#ul1").empty();
   }

   /* $(".mytext").on("keydown", function(e) {
      if (e.which == 13) {
         var text = $(this).val();
         if (text !== "") {
            insertChat("me", text);
            $(this).val('');
         }
      }
   }); */

   /* $('body > div > div > div:nth-child(2) > span').click(function(){
    $(".mytext").trigger({type: 'keydown', which: 13, keyCode: 13});
    }); */

   function exe() {
      var cont = $(".mytext").val();
      insertChat("me", cont, 0);
      $('.mytext').val("");

   }
   $(document).ready(function() {
      $('.mytext').keydown(function(key) {
         if (key.keyCode == 13) {
            var cont = $(".mytext").val();
            insertChat("me", cont, 0);
            $('.mytext').val("");
         }
      });
   });

   출처: http: //findfun.tistory.com/282 [즐거움을 찾자 Find Fun!!]
   //-- Clear Chat
   resetChat();

   //-- Print Messages

   //-- NOTE: No use time on insertChat.
</script>
</head>
<body>

	<c:import url="../../../header.jsp" />
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	
	<div class="col-sm-4"
		style="border: 1px solid #C1C4C6; padding: 0px; background-color: white">


		<a href="msg.do?loginId=${loginUser.member_id }">
			<div style="height: 100px;background-color:#503A3A">
				<div class="col-lg-3" style="padding: 0px;">
					<img src="/finalPro/img/balloon.png"
						style="width: 80px; height: 80px; float: left; margin-top: 10px; margin-left: 10px;">
				</div>
				<div class="col-lg-9" style="padding: 0px; margin-top: 5%">
					<p style="font-size: 30pt;color:white">쪽지 쓰기</p>
				</div>
			</div>
		</a>

		<c:forEach var="row" items="${msglist }" varStatus="status">
			<c:if test="${row.m_writer eq loginUser.member_id }">
				<c:if test="${row.m_d_writer eq 'N' }">
					<div
						style="height: 71px; border-bottom: 1px solid #ECF2F4; background-color: white">
						<a
							href="mDetail.do?m_writer=${row.m_writer }&m_recv=${row.m_recv }&m_content=${row.m_content}&m_no=${row.m_no}&loginId=${loginUser.member_id}">
							<!-- image -->
							<div class="col-lg-3" style="padding: 0px;">
								<c:forEach var="ali" items="${anotherListM }">
									<c:if test="${ali.member_id eq row.m_recv }">
										<img src="img/mimg/${ali.img_rename_filename }" class="mimg"
											style="margin-top: 10px; margin-left: 10px;" />
									</c:if>
								</c:forEach>
								<!-- <img src="img/mimg/2011.jpg" class="mimg"
									style="margin-top: 10px; margin-left: 10px;" /> -->
							</div> <!-- image end --> <!-- div -->

							<div class="col-lg-8" style="padding: 0px;">
								<c:if test="${row.m_writer eq loginUser.member_id }">
									<div style="margin-top: 2px">${row.m_recv }</div>
								</c:if>
								<c:if test="${row.m_recv eq loginUser.member_id }">
									<div style="margin-top: 2px">${row.m_writer }</div>
								</c:if>
								<div style="margin-top: 10px">${row.m_content }</div>
							</div> <!-- div end --> <!-- div -->


							<div class="col-lg-1" style="padding: 0px;">
								<div style="margin-top: 2px">
									<a href="" data-target="#dataModal${status.count }"
										data-toggle="modal"> <img src="/finalPro/img/outimg.png" />
									</a>
								</div>

							</div> <!-- div end -->
						</a>

					</div>
				</c:if>
			</c:if>
			<c:if test="${row.m_writer ne loginUser.member_id }">
				<c:if test="${row.m_d_recv eq 'N' }">
					<div
						style="height: 71px; border-bottom: 1px solid #ECF2F4; background-color: white">
						<a
							href="mDetail.do?m_writer=${row.m_writer }&m_recv=${row.m_recv }&m_content=${row.m_content}&m_no=${row.m_no}&loginId=${loginUser.member_id}">
							<!-- image -->
							<div class="col-lg-3" style="padding: 0px;">
								<c:forEach var="ali" items="${anotherListM }">
									<c:if test="${ali.member_id eq row.m_writer }">
										<img src="img/mimg/${ali.img_rename_filename }" class="mimg"
											style="margin-top: 10px; margin-left: 10px;" />
									</c:if>
								</c:forEach>
								<!-- <img src="img/mimg/2011.jpg" class="mimg"
									style="margin-top: 10px; margin-left: 10px;" /> -->
							</div> <!-- image end --> <!-- div -->

							<div class="col-lg-8" style="padding: 0px;">
								<c:if test="${row.m_writer eq loginUser.member_id }">
									<div style="margin-top: 2px">${row.m_recv }</div>
								</c:if>
								<c:if test="${row.m_recv eq loginUser.member_id }">
									<div style="margin-top: 2px">${row.m_writer }</div>
								</c:if>
								<div style="margin-top: 10px">${row.m_content }</div>
							</div> <!-- div end --> <!-- div -->


							<div class="col-lg-1" style="padding: 0px;">
								<div style="margin-top: 2px">
									<a href="" data-target="#dataModal${status.count }"
										data-toggle="modal"> <img src="/finalPro/img/outimg.png" />
									</a>
								</div>
								<div style="margin-top: 2px">
									<c:if test="${'N' eq row.m_read }">
										<img src="/finalPro/img/newimg.png" />
									</c:if>
								</div>
							</div> <!-- div end -->

						</a>
					</div>
				</c:if>
			</c:if>

			<div class="modal fade" id="dataModal${status.count }" tabindex="-1"
				role="dialog" aria-labelledby="dataModalLabel" aria-hidden="true">

				<div class="modal-dialog modal-sm">

					<div class="modal-content">

						<div class="modal-header">

							<button type="button" class="close" data-dismiss="modal">
								<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
							</button>
							<h4 class="modal-title" id="dataModalLabel">나가기</h4>
						</div>
						<div class="modal-body" style="text-align: center;">채팅방을
							나가시겠습니까?</div>
						<div class="modal-footer">

							<a
								href="msgdelete.do?m_writer=${row.m_writer }&m_recv=${row.m_recv}&loginId=${loginUser.member_id}"
								class="btn btn-primary" style="width: 100%;">나가기</a>

							<button type="button" class="btn btn-default"
								data-dismiss="modal">Close</button>
						</div>

					</div>

				</div>

			</div>

		</c:forEach>

	</div>


	<div class="col-sm-3 col-sm-offset-4 frame"
		style="text-align: center;width:20%;border-radius:11% ;background-image: url(/finalPro/img/iphone.png);background-repeat:no-repeat;background-size:100% 100%">
		<br>
		<form action="msend.do" method="post" style="width:100%;heigth:100%">
			<c:if test="${!empty loginUser }">
				<input type="hidden" name="m_writer" value="${loginUser.member_id }"
					style="blackground: ivory;">
			</c:if>
			<div style="width:80%;height:40px;position:absolute;left:10%;top:15%"><input type="text"
				name="m_recv" style="width:100%;border:1px solid #CEE3F6;border-radius:5px;/* box-shadow:2px 2px 2px 2px #CEE3F6 */"  placeholder="받는 사람"></div><br><br><br>
			<div style="width:80%;height:385px;position:absolute;left:10%;top:20.8%"><textarea name="m_content" style="width:100%;height:100%;border:1px solid #CEE3F6;border-radius:5px;/* box-shadow:2px 2px 2px 2px #CEE3F6 */"  placeholder="내용"></textarea></div>
			<br>
			<div style="width:17.4%;height:8.2%;position:absolute;left:41%;bottom:4.7%"><input type="submit" value="전 송" style="padding:0px;color:white;background-color:black;width:100%;height:100%;border:2px solid black;border-radius:50%"></div>
			
		</form>
	</div>

	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>

	<br>
	<br>
	<br>
	<br>
	<c:import url="../../../footer.jsp" />


</body>
</html>