<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>일반 게시판 글보기</title>
<jsp:include page="../jsp/webLib.jsp"></jsp:include>
<style type="text/css">
.dataRow>.card-header{
	background: #e0e0e0;
}

</style>
</head>
<body>
<div class="container">
	<div class="card">
		<div class="card-header"><h3>일반 게시판 글보기</h3></div>
		<div class="card-body">
			<div class="card dataRow" data-no="${vo.no }">
				<div class="card-header">
					<span class="float-right">조회수 : ${vo.hit }</span>
					${vo.no }. ${vo.title }
				</div>
				<div class="card-body">
					<pre>${vo.content }</pre>
				</div>
				<div class="card-footer">
					<span class="float-right">
						<fmt:formatDate value="${vo.writeDate }"
						pattern="yyyy-MM-dd"/>
					</span>
					${vo.writer }
				</div>
			</div>
		</div>
		<div class="card-footer">
			<button class="btn btn-primary" id="updateBtn">수정</button>
			<button class="btn btn-danger" id="deleteBtn">삭제</button>
			<button class="btn btn-warning">취소</button>
		</div>
	</div>
</div>
</body>
</html>