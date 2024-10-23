package org.zerock.goods.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.category.vo.CategoryVO;
import org.zerock.goods.mapper.GoodsMapper;
import org.zerock.goods.vo.GoodsColorVO;
import org.zerock.goods.vo.GoodsImageVO;
import org.zerock.goods.vo.GoodsPriceVO;
import org.zerock.goods.vo.GoodsSizeVO;
import org.zerock.goods.vo.GoodsVO;
import org.zerock.util.page.PageObject;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@Qualifier("goodsServiceImpl")
public class GoodsServiceImpl implements GoodsService {

	@Setter(onMethod_ = @Autowired)
	private GoodsMapper mapper;
	
	@Override
	public List<GoodsVO> list(PageObject pageObject) {
		// TODO Auto-generated method stub
		pageObject.setTotalRow(mapper.getTotalRow(pageObject));
		
		return mapper.list(pageObject);
	}

	@Override
	public GoodsVO view(Long goods_no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional	// 쿼리중 하나라도 문제가 생기거나 처리되지 않으면 자동 Rollback합니다.
	public Integer write(GoodsVO vo,
			List<String> imageFileNames,
			List<String> size_names,
			List<String> color_names) {
		// TODO Auto-generated method stub
		// 1. goods 테이블에 상품등록 (필수)
		mapper.write(vo);
		// 2. 등록한 goods테이블의 goods_no를 가져온다.
		Long goods_no = mapper.getGoodsNo();
		//Long goods_no = 0L;
		// goods_price 테이블에 가격정보등록 (필수)
		//vo.setGoods_no(goods_no);
		GoodsPriceVO priceVO = new GoodsPriceVO();
		priceVO.setGoods_no(goods_no);
		priceVO.setPrice(vo.getPrice());
		priceVO.setDiscount(vo.getDiscount());
		priceVO.setDiscount_rate(vo.getDiscount_rate());
		priceVO.setSaved_rate(vo.getSaved_rate());
		priceVO.setDelivery_charge(vo.getDelivery_charge());
		priceVO.setSale_start_date(vo.getSale_start_date());
		priceVO.setSale_end_date(vo.getSale_end_date());
		mapper.writePrice(priceVO);
		// goods_image 테이블에 등록 (선택: imageFileNames에 자료가 있으면)
		for (String imageName : imageFileNames) {
			GoodsImageVO imageVO = new GoodsImageVO();
			imageVO.setGoods_no(goods_no);
			imageVO.setImage_name(imageName);
			mapper.writeImage(imageVO);
		}
		// goods_size 테이블에 등록 (선택: size_names에 자료가 있으면)
		for (String sizeName : size_names) {
			GoodsSizeVO sizeVO = new GoodsSizeVO();
			sizeVO.setGoods_no(goods_no);
			sizeVO.setSize_name(sizeName);
			mapper.writeSize(sizeVO);
		}
		// goods_color 테이블에 등록 (선택: color_names에 자료가 있으면)
		for (String colorName : color_names) {
			GoodsColorVO colorVO = new GoodsColorVO();
			colorVO.setGoods_no(goods_no);
			colorVO.setColor_name(colorName);
			mapper.writeColor(colorVO);
		}
		return 1;
	}

	@Override
	public Integer update(GoodsVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer delete(GoodsVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CategoryVO> listCategory(Integer cate_code1) {
		// TODO Auto-generated method stub
		return mapper.getCategory(cate_code1);
	}

}
