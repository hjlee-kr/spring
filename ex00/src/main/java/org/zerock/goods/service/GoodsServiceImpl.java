package org.zerock.goods.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.zerock.goods.mapper.GoodsMapper;
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
		return null;
	}

	@Override
	public GoodsVO view(Long goods_no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer write(GoodsVO vo) {
		// TODO Auto-generated method stub
		return null;
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

}
