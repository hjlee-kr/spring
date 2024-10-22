package org.zerock.goods.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.zerock.category.vo.CategoryVO;
import org.zerock.goods.vo.GoodsVO;
import org.zerock.util.page.PageObject;

@Repository
public interface GoodsMapper {

	// 상품 리스트
	public List<GoodsVO> list(PageObject pageObject);
	// 상품 리스트 개수
	public Long getTotalRow(PageObject pageObject);
	
	// 대분류/중분류 리스트 가져오기
	public List<CategoryVO> getCategory(@Param("cate_code1") Integer cate_code1);
	
}
