<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- main.jsp -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main</title>
</head>
<body>
<div class="container">
	<h2>메인입니다.</h2>
	<div style="border:1px solid black">
	${weatherVO.forecastDate } ${weatherVO.forecastTime }<br>
	${weatherVO.forecastRegion }<br>
	${weatherVO.forecastWeather }<br>
	기온 : ${weatherVO.forecastTemperature } &deg;C<br>
	습도 : ${weatherVO.forecastHumidity } &percnt;
	</div>  
</div>
</body>
</html>