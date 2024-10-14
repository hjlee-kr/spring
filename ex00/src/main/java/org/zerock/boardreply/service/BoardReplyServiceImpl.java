package org.zerock.boardreply.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.zerock.boardreply.vo.BoardReplyVO;
import org.zerock.util.page.PageObject;

// 자동생성 어노테이션
// @Controller, @RestController
// @Service
// @Repository
// @Component
// @~~Advice
@Service
@Qualifier("boardReplyServiceImpl")
public class BoardReplyServiceImpl implements BoardReplyService {

	
	@Override
	public List<BoardReplyVO> list(PageObject pageObject, Long no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer write(BoardReplyVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer update(BoardReplyVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer delete(BoardReplyVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

}
