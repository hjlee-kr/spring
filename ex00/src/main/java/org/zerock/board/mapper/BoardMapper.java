package org.zerock.board.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.zerock.board.vo.BoardVO;

@Repository
public interface BoardMapper {

	public List<BoardVO> list();
	// 1. 드리이버확인
	// 2. DB연결
	// 3. SQL작성
	// 4. 실행객체에 데이터세팅
	// 5. 쿼리실행
	// 6. 데이터 담기
	// 7. DB닫기
	// 위의 7단계를 mybatis가 대신 처리해 준다.
}
