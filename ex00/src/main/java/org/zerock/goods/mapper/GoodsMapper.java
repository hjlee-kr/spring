package org.zerock.goods.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.zerock.category.vo.CategoryVO;
import org.zerock.goods.vo.GoodsColorVO;
import org.zerock.goods.vo.GoodsImageVO;
import org.zerock.goods.vo.GoodsPriceVO;
import org.zerock.goods.vo.GoodsSizeVO;
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
	
	// 상품 등록
	// 1. goods 테이블에 상품등록 (필수)
	public Integer write(GoodsVO vo);
	// 2. 등록한 goods테이블의 goods_no를 가져온다.
	public Long getGoodsNo();
	// goods_price 테이블에 가격정보등록 (필수)
	public Integer writePrice(GoodsPriceVO vo);
	// goods_image 테이블에 등록 (선택: imageFileName에 자료가 있으면)
	public Integer writeImage(GoodsImageVO vo);
	// goods_size 테이블에 등록 (선택: size_names에 자료가 있으면)
	public Integer writeSize(GoodsSizeVO vo);
	// goods_color 테이블에 등록 (선택: color_names에 자료가 있으면)
	public Integer writeColor(GoodsColorVO vo);
	
}
