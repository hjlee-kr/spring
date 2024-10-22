package org.zerock.goods.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.category.vo.CategoryVO;
import org.zerock.goods.service.GoodsService;
import org.zerock.goods.vo.GoodsVO;
import org.zerock.util.page.PageObject;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/goods")
public class GoodsController {

	@Autowired
	@Qualifier("goodsServiceImpl")
	private GoodsService service;
	
	@GetMapping("/list.do")
	public String list(Model model, HttpServletRequest request) {
		
		PageObject pageObject = PageObject.getInstance(request);
		
		String perPageNum = request.getParameter("perPageNum");
		
		if (perPageNum == null) {
			pageObject.setPerPageNum(8);
		}
		else {
			pageObject.setPerPageNum(Integer.parseInt(perPageNum));
		}
		
		List<GoodsVO> list = new ArrayList<GoodsVO>();
		
		list = service.list(pageObject);
		
		model.addAttribute("list", list);
		model.addAttribute("pageObject", pageObject);
		
		return "goods/list";
	}
	
	// 상품 등록 폼
	@GetMapping("/writeForm.do")
	public String write(Model model) {
		
		List<CategoryVO> list = new ArrayList<CategoryVO>();
		
		
		
		return "goods/write";
	}
	
}







