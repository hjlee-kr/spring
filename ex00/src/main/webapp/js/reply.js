/**
 * reply.js
 * 일반 게시판 댓글 처리 객체
 */
 
console.log("Board Reply Module ..........................");

// 일반 게시판 댓글을 처리하는 객체 선언
// jquery 의 ajax 를 사용 - ajax(), getJSON(), get(), post()
let replyService = {

	// 1. 일반 게시판 댓글 리스트 처리
	"list": function(page) {
		console.log("댓글 리스트.......");
		// page가 없으면 page = 1로 만든다.
		if (!page) page = 1;
		console.log("page : " + page + ", no : " + no);
	},
	// 2. 일반 게시판 댓글 등록 처리
	// write(댓글객체, 성공함수, 실패함수)
	"write": function(reply, callback, error) {
	},
	// 3. 일반 게시판 댓글 수정 처리
	// update(댓글객체, 성공함수, 실패함수)
	"update": function(reply, callback, error) {
	},
	// 4. 일반 게시판 댓글 삭제 처리
	// delete(댓글객체, 성공함수, 실패함수)
	"delete": function(reply, callback, error) {
	}

};






