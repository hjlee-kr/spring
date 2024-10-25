<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 정보</title>
<style type="text/css">
#smallImageDiv img {
	width: 80px;
	height: 80px;

}
</style>

<script type="text/javascript">
$(function(){

	
});
</script>
</head>
<body>
<div class="container">
	<div class="card">
  		<div class="card-header">상품 정보</div>
		<div class="card-body">
			<div class="row">
				<div class="col-md-6">
					<div id="smallImageDiv">
						<img src="${vo.image_name }" class="img-thumbnail">
						
					</div>
					<div id="bigImageDiv" class="img-thumbnail">
						<img src="${vo.image_name }" style="width : 100%;">
					</div>
				</div>
				<div class="col-md-6">
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
				</div>
			</div>
	
		</div>
		<div class="card-footer">Footer</div>
	</div>
</div>
</body>
</html>