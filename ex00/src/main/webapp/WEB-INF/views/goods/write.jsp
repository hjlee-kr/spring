<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 등록</title>
<script type="text/javascript">
$(function(){
	// 이벤트 처리
	let now = new Date();
	let startYear = now.getFullYear();
	let yearRange = (startYear - 10) + ":" + (startYear + 10);
	
	// 날짜 입력 설정
	$(".datepicker").datepicker({
		// 입력란의 데이터 포맷
		dateFormat : "yy-mm-dd",
		// 월 선택 추가
		changeMonth: true,
		// 년 선택 추가
		changeYear: true,
		// 월 선택 입력(기본:영어->한글)
		monthNamesShort: ["1월","2월","3월","4월","5월","6월","7월","8월","9월","10월","11월","12월"],
		// 달력의 요일 표시 (기본:영어->한글)
		dayNamesMin: ["일","월","화","수","목","금","토"],
		// 선택할 수 있는 년도의 범위
		yearRange : yearRange
	});
	
});
</script>
</head>
<body>
<div class="container">
	<div class="card">
  		<div class="card-header"><h3>상품 등록</h3></div>
  		<form action="write.do" method="post" enctype="multipart/form-data">
			<div class="card-body">
			<!-- 대분류, 중분류는 java 구현후 작성할 예정 -->
				<div class="form-group">
					<label for="goods_name">상품명</label>
					<input class="form-control" id="goods_name"
						name="goods_name" required>
				</div>
				<div class="form-group">
					<label for="image_name">상품사진</label>
					<input type="file" class="form-control"
						id="image_name" name="image_name" required>
				</div>
				<div class="form-group">
					<label for="content">상품설명</label>
					<textarea rows="10" class="form-control"
						id="content" name="content"></textarea>
				</div>
				<div class="form-group">
					<label for="company">제조사</label>
					<input class="form-control" id="company"
						name="company" required>
				</div>
				<div class="form-group">
					<label for="product_date">생산일</label>
					<input class="form-control datepicker"
						id="product_date" name="product_date">
				</div>
				<div class="form-group">
					<label for="price">정가</label>
					<input class="form-control" id="price"
						name="price" required>
				</div>
				<div class="form-group">
					<label for="discount">할인금액</label>
					<input class="form-control" id="discount"
						name="discount">
				</div>
				<div class="form-group">
					<label for="discount_rate">할인율</label>
					<input class="form-control" id="discount_rate"
						name="discount_rate">
				</div>
				<div class="form-group">
					<label for="saved_rate">적립율</label>
					<input class="form-control" id="saved_rate"
						name="saved_rate">
				</div>
				<div class="form-group">
					<label for="delivery_charge">배송료</label>
					<input class="form-control" id="delivery_charge"
						name="delivery_charge">
				</div>
				<div class="form-group">
					<label for="sale_start_date">판매시작일</label>
					<input class="form-control datepicker"
						id="sale_start_date" name="sale_start_date">
				</div>
				<div class="form-group">
					<label for="sale_end_date">판매종료일</label>
					<input class="form-control datepicker"
						id="sale_end_date" name="sale_end_date">
				</div>
			</div>
			<div class="card-footer">
				<button class="btn btn-primary">등록</button>
			</div>
		</form>
	</div>
</div>
</body>
</html>










