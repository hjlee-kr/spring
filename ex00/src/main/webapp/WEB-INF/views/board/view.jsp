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


<script type="text/javascript" src=""></script>


<script type="text/javascript">
$(function(){
	// 글수정버튼(id="updateBtn")을 클릭했을때 
	$("#updateBtn").click(function() {
		location = "updateForm.do?no=${vo.no}";
	});
	
	// 글삭제버튼(id="deleteBtn")을 클릭했을때
	// 모달창의 pw내용을 지운다.
	$("#deleteBtn").click(function() {
		$("#pw").val("");
	});
});
</script>
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
			<button class="btn btn-danger" id="deleteBtn"
				data-toggle="modal" data-target="#deleteModal">삭제</button>
			<button class="btn btn-warning">취소</button>
		</div>
	</div>
	<!-- 글보기 card가 끝 -->
	
	<div>
		<jsp:include page="boardreply.jsp"></jsp:include>
	</div>
	
	
	
	
	<!-- The Modal -->
  <div class="modal fade" id="deleteModal">
    <div class="modal-dialog modal-dialog-centered">
      <div class="modal-content">
      
        <!-- Modal Header -->
        <div class="modal-header">
          <h4 class="modal-title">비밀번호 입력 모달 창</h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        <!-- deleto.do 로 이동시 no, pw 가 필요합니다. -->
        <!-- no : hidden으로, pw: 사용자입력으로 세팅 -->
        <form action="delete.do" method="post">
        	<input type="hidden" name="no" value="${vo.no }">
	        <!-- Modal body -->
	        <div class="modal-body">
	          <div class="form-group">
	          	<input class="form-control" type="password"
	          		name="pw" id="pw">
	          </div>
	        </div>
	        
	        <!-- Modal footer -->
	        <div class="modal-footer">
	          <button class="btn btn-danger">삭제</button>
	          <button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
	        </div>
        </form>
      </div>
    </div>
  </div>
	
	
	
	
</div>
</body>
</html>