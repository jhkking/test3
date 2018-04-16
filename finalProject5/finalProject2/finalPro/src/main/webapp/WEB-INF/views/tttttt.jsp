<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Simple Map</title>
<!-- <meta name="viewport" content="initial-scale=1.0"> -->
<meta charset="utf-8">
<!-- <style>
/* Always set the map height explicitly to define the size of the div
       * element that contains the map. */
#map_canvas {
	height: 1000px;
}
/* Optional: Makes the sample page fill the window. */
html, body {
	height:  100%;
	margin: 0;
	padding: 0;
}  
</style> -->
<script
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDDN_ZeJEqk0GSwGVnifo3i_evVo_V5UHk&callback=initMap"
		async defer></script>
<script type="text/javascript">
		var map;
		function initialize() {
			var myLatlng = new google.maps.LatLng(37.20959739504577,
					126.97947084903717);
			var myOptions = {
				zoom : 4,
				center : myLatlng,
				mapTypeId : google.maps.MapTypeId.ROADMAP
			}

			map = new google.maps.Map(document.getElementById("map_canvas"),
					myOptions);

			//클릭했을 때 이벤트
			google.maps.event.addListener(map, 'click', function(event) {
				placeMarker(event.latLng);
				infowindow.setContent("latLng: " + event.latLng); // 인포윈도우 안에 클릭한 곳위 좌표값을 넣는다.
				infowindow.setPosition(event.latLng); // 인포윈도우의 위치를 클릭한 곳으로 변경한다.

			});
			//클릭 했을때 이벤트 끝

			//인포윈도우의 생성
			var infowindow = new google.maps.InfoWindow({
				content : 'Clicked latLng',
				size : new google.maps.Size(50, 50),
				position : myLatlng
			});
			infowindow.open(map);

		} // function initialize() 함수 끝

		// 마커 생성 합수
		function placeMarker(location) {
			var clickedLocation = new google.maps.LatLng(location);
			var marker = new google.maps.Marker({
				position : location,
				map : map
			});
			map.setCenter(location);
		}
		marker.setMap(map);
	</script>
</head>
<body onload="initialize()">
	
	<div id="map_canvas" style="width:100px; height:100px"></div>

</body>


</html>