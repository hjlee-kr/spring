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
 
 
 
 