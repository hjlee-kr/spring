<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- list.jsp -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>카테고리</title>
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
							<a class="nav-link
								${(vo.cate_code1 == cate_code1)?'active':''}"
							data-toggle="tab" href="#home">${vo.cate_name }</a>
						</li>
					</c:forEach>
				</ul>

				<!-- Tab panes -->
				<div class="tab-content">
					<div id="mid_category" class="container tab-pane active">
						<br>
						<h3>카테고리 중분류</h3>
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
</body>
</html>