package org.zerock.goods.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.zerock.goods.vo.GoodsVO;
import org.zerock.util.page.PageObject;

@Repository
public interface GoodsMapper {

	// 상품 리스트
	public List<GoodsVO> list(PageObject pageObject);
	// 상품 리스트 개수
	public Long getTotalRow(PageObject pageObject);
	
	
}
