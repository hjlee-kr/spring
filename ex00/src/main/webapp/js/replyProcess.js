/**
 * replyProcess.js 
 * replyService 객체를 이용한 댓글 처리 코드
 */
 
 // 만든이후 잘되는지 확인
 //replyService.list();
 
 function showList(page) {
 	// 데이터를 받아 옵니다.
 	replyService.list(page,
 		// 데이터 가져오기가 성공되었을 때 실행되는 함수
 		// -> html tag를 만들어 화면에 표시
 		function (data) {
 			// data 의 구조 - {"list":list, "pageObject":pageObject}
 			let list = data.list; // data(map)의 key값으로 value를 가져온다.
 			
 			// ul 태그안에 들어갈 문자열을 저장할 객체
 			let str = "";
 			// 데이터가 없을 때 처리
 			if (list == null || list.length == 0) {
 				//$(".chat").html(""); //데이터가 존재하지 않습니다.
 				$(".chat").html("<li>댓글이 없습니다.</li>");
 				return;
 			}
 			// 데이터가 있는 경우의 처리
 			for(let i = 0 ; i < list.length ; i++) {
 				str += '<li class="left clearfix" data-rno="' + list[i].rno + '">';
				str += '<div>';
				str += '<div class="header">';
				str += '<strong class="primary-font">' + list[i].name;
				str += '(' + list[i].id + ')</strong>';
				str += '<small class="pull-right text-muted">';
				str += toDateTime(list[i].writeDate) + '</small>';
				str += '</div>';
				str += '<p><pre>' + list[i].content +'</pre></p>';
				str += '</div>';
				str += '</li>';
 			}
 			$(".chat").html(str);
 		}
 	);
 };
 
 // 댓글 리스트 함수 실행
 showList(1);
 
 // HTML 이 로딩된 후에 처리되도록 합니다.
 $(function() {
 	// -------이벤트 처리----------------
 	// 태그들이 모두 올라온 후에 처리할 수 있어야 합니다. $(function() {  이벤트처리  })
 	// {} 안에 이벤트처리부분이 구현되어야 정상동작 합니다.
 	
 	$("#newReplyBtn").click(function() {
 		// 이전 댓글 내용을 지운다.
 		$("#replyContent").val("");
 	
 	
 	});
 
 	// 댓글 등록 모달 창에서 "등록" 버튼 click이벤트 처리
 	$("#replyWriteBtn").click(function() {
 		//alert("댓글 등록 버튼 클릭"); - 이벤트로 들어오는지 확인용 코드
 		
 		// 댓글 등록에 필요한 데이터 수집(no, content)
 		// no는 전역변수로 선언을 했다.
 		// $("#replyContent").val() : id :replyContent
 		// <textarea>에 적은 데이터를 가져옵니다.
 		let reply = {no : no, content: $("#replyContent").val()};
 		// JSON.stringify()는 JSON데이터를 string으로 리턴해준다.
 		//alert(JSON.stringify(reply));
 		replyService.write(reply,
 			function(result) {
 				// 모달창을 닫는다.
 				$("#replyModal").modal("hide");
 				//alert(result);
 				// sitemesh에서 구현해 놓은 모달창에 결과를 보여주도록 만듭니다.
 				$("#msgModal .modal-body").text(result);
 				$("#msgModal").modal("show");
 				// 새로운 댓글이 들어와서 리스트를 다시 불러옵니다.
 				showList(1);
 			}
 		);
 		
 	});
 
 
 });
 
 
 
 
 
 
 
 
 
 
 
 
 