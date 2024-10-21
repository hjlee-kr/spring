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
					<c:forEach items="${listBig }" var="vo"></c:forEach>
						<li class="nav-item">
							<a class="nav-link
								${(vo.cate_code1 == param.cate_code1)?'active':''}"
							data-toggle="tab" href="#home">${vo.cate_name }</a>
						</li>
				</ul>

				<!-- Tab panes -->
				<div class="tab-content">
					<div id="home" class="container tab-pane active">
						<br>
						<h3>HOME</h3>
						<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit,
							sed do eiusmod tempor incididunt ut labore et dolore magna
							aliqua.</p>
					</div>
					<div id="menu1" class="container tab-pane fade">
						<br>
						<h3>Menu 1</h3>
						<p>Ut enim ad minim veniam, quis nostrud exercitation ullamco
							laboris nisi ut aliquip ex ea commodo consequat.</p>
					</div>
					<div id="menu2" class="container tab-pane fade">
						<br>
						<h3>Menu 2</h3>
						<p>Sed ut perspiciatis unde omnis iste natus error sit
							voluptatem accusantium doloremque laudantium, totam rem aperiam.</p>
					</div>
				</div>

			</div>
			<div class="card-footer">Footer</div>
		</div>
	</div>
</body>
</html>