<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- list.jsp -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>카테고리</title>

<script type="text/javascript">
$(function(){
	// 이벤트 처리
	// 대분류 탭 클릭
	$(".bigCateData").click(function(){
		//alert("대분류 클릭");
		// 대분류 번호 수집
		let cate_code1 = $(this).data("cate_code1");
		// 현재 대분류가 아닐때만 이동
		if (!$(this).hasClass("active")) {
			// 중분류가져오기 -> 이동
			location="list.do?cate_code1=" + cate_code1;
		}
	});
	
	// 대분류 등록(+) 탭 클릭
	$("#writeBigBtn").click(function(){
		//alert("대분류 등록");
		$("#categoryModal").find(".modal-title").text("대분류 등록");
		
		$("#modalCateCode1").val(0);
		$("#modalCateCode2").val(0);
		
		$("#modalForm").attr("action", "write.do");
		
		$("#categoryModal").modal("show");
		
		return false; // a tag의 페이지 이동 처리를 무시합니다.
	});
	
	// 중분류 등록(+) 버튼 클릭
	$("#writeMidBtn").click(function(){
		alert("중분류 등록");
	});
});
</script>
</head>
<body>
	<div class="container">
		<div class="card">
			<div class="card-header"><h2>카테고리 관리</h2></div>
			<div class="card-body">
				<!-- Nav tabs -->
				<ul class="nav nav-tabs">
					<c:forEach items="${listBig }" var="vo">
						<li class="nav-item">
							<a class="nav-link bigCateData
								${(vo.cate_code1 == cate_code1)?'active':''}"
							data-toggle="tab" href="#mid_category"
							data-cate_code1="${vo.cate_code1}"
							>${vo.cate_name }</a>
						</li>
					</c:forEach>
					<li class="nav-item"><a
						class="nav-link" data-toggle="tab"
						href="#mid_category" data-cate_code1="${vo.cate_code1}"
						id="writeBigBtn"><i class="fa fa-plus"></i></a>
					</li>
				</ul>

				<!-- Tab panes -->
				<div class="tab-content">
					<div id="mid_category" class="container tab-pane active">
						<br>
						<h3>카테고리 중분류
						<button class="btn btn-primary btn-sm"
							id="writeMidBtn"
							data-cate_code1="${vo.cate_code1 }"
							><i class="fa fa-plus"></i></button>
						</h3>
						<ul class="list-group">
							<c:forEach items="${ listMid}" var="vo">
								<li class="list-group-item">
									${vo.cate_name }
								</li>
							</c:forEach>
						</ul>
					</div>
					
				</div>

			</div>
			<div class="card-footer">Footer</div>
		</div>
	</div>

	<!-- The Modal -->
	<div class="modal fade" id="categoryModal">
		<div class="modal-dialog modal-dialog-centered">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">Modal Heading</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>

				<form action="" method="post" id="modalForm">
					<input type="hidden" name="cate_code1" id="modalCateCode1" value="0">
					<input type="hidden" name="cate_code2" id="modalCateCode2" value="0">
					<!-- Modal body -->
					<div class="modal-body">
						<input name="cate_name" class="form-control"
							id="modalCateName">
					</div>
	
					<!-- Modal footer -->
					<div class="modal-footer">
						<button class="btn btn-primary" id="submitBtn">전송</button>
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Close</button>
					</div>
				</form>
			</div>
		</div>
	</div>


</body>
</html>





