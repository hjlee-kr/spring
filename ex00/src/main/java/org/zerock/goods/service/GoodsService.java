package org.zerock.goods.service;

import java.util.List;

import org.zerock.goods.vo.GoodsVO;
import org.zerock.util.page.PageObject;

public interface GoodsService {

	// 상품 리스트
	public List<GoodsVO> list(PageObject pageObject);
	// 상품 보기
	public GoodsVO view(Long goods_no);
	// 상품 등록
	public Integer write(GoodsVO vo);
	// 상품 수정
	public Integer update(GoodsVO vo);
	// 상품 삭제
	public Integer delete(GoodsVO vo);
	
	// 상품이미지 추가
	// 상품이미지 변경
	// 상품이미지 삭제
	
	// 상품사이즈 추가
	// 상품사이즈 변경
	// 상품사이즈 삭제
	
	// 상품색상 추가
	// 상품색상 변경
	// 상품색상 삭제
	
	// 상품 현재 가격 + 기간 변경
	// 상품 예정 가격 추가
}




