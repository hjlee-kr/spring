<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- boardreply.jsp -->
<div class="row" style="margin : 40px -10px 0 -10px">
	<div class="col-lg-12">
		<!-- card -->
		<div class="card">
			<!-- 댓글 제목 -->
			<div class="card-header" style="background:#e0e0e0">
				<i class="fa fa-comments fa-fw"></i> Reply
			</div>

			<!-- 댓글 리스트 데이터 출력 -->		
			<div class="card-body">
				<ul class="chat">
					<!-- 데이터 한개당 li 태그를 만든다. for or foreach -->
					<!-- 하드코딩 -->
					<li class="left clearfix" data-rno="1">
						<div>
							<div class="header">
								<strong class="primary-font">홍길동(test1)</strong>
								<small class="pull-right text-muted">2024-01-01</small>
							</div>
							<p><pre>Good job!!</pre></p>
						</div>
					</li>
				</ul>
			</div>
		</div>
	</div>
</div>


