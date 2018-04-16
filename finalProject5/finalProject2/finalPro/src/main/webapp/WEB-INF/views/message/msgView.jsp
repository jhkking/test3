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
   height:50px;
   width:50px;
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
			control = '<li>'
					+ '<div class="msj macro" style="width:80%">'
					+ '<div class="avatar"><img class="img-circle" style="width:69px;height:69px" src="'
					+ '/finalPro/img/mimg/${loginUser.img_rename_filename}" /></div>'
					+ '<div class="text text-l">' + '<p>' + text + '</p>'
					+ '<p><small>' + date + '</small></p>' + '</div>'
					+ '</div>' + '</li>';
		} else {
			control = '<li>'
					+ '<div class="msj-rta macro" style="width:80%">'
					+ '<div class="text text-r">'
					+ '<p>'
					+ text
					+ '</p>'
					+ '<p><small>'
					+ date
					+ '</small></p>'
					+ '</div>'
					+ '<div class="avatar" style="padding:0px 0px 0px 10px !important"><img class="img-circle" style="width:69px;height:69px" src="'
					+ '/finalPro/img/mimg/${anotherUser.img_rename_filename}" /></div>' + '</li>';
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
	$(document).ready(function() {
		$('.mytext').keydown(function(key) {
			if (key.keyCode == 13) {
				var cont = $(".mytext").val();

				var id1 = document.getElementById("loginU").value;
				var recv1 = document.getElementById("recvid").value;
				var writer1 = document.getElementById("writerid").value;
				insertChat("me", cont, 0);
				jQuery.ajax({
					type : "post",
					data : {
						content : cont,
						id : id1,
						recv : recv1,
						writ : writer1
					},
					url : "msginsert.do",
					success : function() {
						console.log("성공");
					}
				});
				webSocket.send(cont);
				$('.mytext').val("");
			}
		});
	});

	//-- Clear Chat
	resetChat();

	//-- Print Messages

	//-- NOTE: No use time on insertChat.
</script>

<script type="text/javascript">
	/* var textarea = document.getElementById("messageWindow"); */
	var webSocket = new WebSocket(
			'ws://192.168.30.83:8888/finalPro/broadcasting');
	/* var inputMessage = document.getElementById('inputMessage'); */
	webSocket.onerror = function(event) {
		onError(event)
	};
	webSocket.onopen = function(event) {
		onOpen(event)
	};
	webSocket.onmessage = function(event) {
		onMessage(event)
	};
	function onMessage(event) {
		insertChat("상대", event.data, 0);
	}
	function onOpen(event) {
		/* textarea.value += "연결 성공\n"; */
	}
	function onError(event) {
		alert(event.data);
	}
	function send() {
		var cont = $(".mytext").val();
		var id1 = document.getElementById("loginU").value;
		var recv1 = document.getElementById("recvid").value;
		var writer1 = document.getElementById("writerid").value;
		insertChat("me", cont, 0);
		jQuery.ajax({
			type : "post",
			data : {
				content : cont,
				id : id1,
				recv : recv1,
				writer : writer1
			},
			url : "msginsert.do",
			success : function() {
				console.log("성공");
			}
		});
		webSocket.send(cont);
		$('.mytext').val("");
	}
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



		 <c:forEach var="row" items="${msglist2 }" varStatus="status">
         <c:if test="${row.m_writer eq loginUser.member_id }">
				<c:if test="${row.m_d_writer eq 'N' }">
					<div
						style="height: 71px; border-bottom: 1px solid #ECF2F4; background-color: white">
						<a href="mDetail.do?m_writer=${row.m_writer }&m_recv=${row.m_recv }&m_content=${row.m_content}&m_no=${row.m_no}&loginId=${loginUser.member_id}"> 
							<!-- image -->
							<div class="col-lg-3" style="padding: 0px;">
								<c:forEach var="ali" items="${anotherList }">
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
									<a href="" data-target="#dataModal${status.count }" data-toggle="modal"> <img
										src="/finalPro/img/outimg.png" />
									</a>
								</div>
								<div style="margin-top: 2px">
									<%-- <c:if test="${'N' eq row.m_read }">
										<img src="/finalPro/img/newimg.png" />
									</c:if> --%>
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
						<a href="mDetail.do?m_writer=${row.m_writer }&m_recv=${row.m_recv }&m_content=${row.m_content}&m_no=${row.m_no}&loginId=${loginUser.member_id}">
							<!-- image -->
							<div class="col-lg-3" style="padding: 0px;">
								<c:forEach var="ali" items="${anotherList }">
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
									<a href="" data-target="#dataModal${status.count }" data-toggle="modal"> <img
										src="/finalPro/img/outimg.png" />
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

         <div class="modal fade" id="dataModal${status.count }" tabindex="-1" role="dialog"
            aria-labelledby="dataModalLabel" aria-hidden="true">

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
                        class="btn btn-primary" style="width:100%;">나가기</a>
                  
                     <button type="button" class="btn btn-default"
                        data-dismiss="modal">Close</button>
                  </div>

               </div>

            </div>

         </div>

      </c:forEach>


		<%-- </c:forEach> --%>
	</div>
	<div class="col-sm-3 col-sm-offset-4 frame"
		style="background-color: #C8D7DE">

		<ul id="ul1">
			<c:forEach var="list" items="${selList }" varStatus="status">
				<c:if test="${list.m_writer eq loginUser.member_id }">
					<li>
						<div class="msj macro" style="width: 80%">
							<div class="avatar">
								<img class="img-circle" style="width: 69px; height:69px"
									src="/finalPro/img/mimg/${loginUser.img_rename_filename }" />
							</div>
							<div class="text text-l">
								<p>${list.m_content }</p>
								<p>
									<small> ${list.m_date } </small>
								</p>
							</div>
						</div>
					</li>
				</c:if>
				<c:if test="${list.m_recv eq loginUser.member_id }">
					<li>
						<div class="msj-rta macro" style="width: 80%">
							<div class="text text-r">
								<p>${list.m_content }</p>
								<p>
									<small> ${list.m_date } </small>
								</p>
							</div>
							<div class="avatar" style="padding: 0px 0px 0px 10px !important">
								<img class="img-circle" style="width: 69px; height:69px"
									src="/finalPro/img/mimg/${anotherUser.img_rename_filename }" />
							</div>
						</div>
					</li>
				</c:if>

				<c:if test="${status.count eq 1 }">
					<input type="hidden" id="writerid" value="${list.m_writer}">
					<input type="hidden" id="recvid" value="${list.m_recv}">
				</c:if>

				
			</c:forEach>
		</ul>
		<div>
			<div class="msj-rta macro"
				style="width: 80%; margin: 1px; height: 82%; margin-top: 10px;">
				<div class="text text-r" style="background: whitesmoke !important">
					<input class="mytext" placeholder="Type a message"
						id="inputMessage" />
				</div>

			</div>
			<div style="padding: 3px; margin-right: 15px;">
				<input type="submit" value="send" onclick="send()"
					style="border-radius: 3px" /> <input type="hidden" id="loginU"
					value="${loginUser.member_id }">
			</div>
		</div>
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