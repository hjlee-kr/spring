package org.zerock.category.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.category.service.CategoryService;
import org.zerock.category.vo.CategoryVO;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	@Qualifier("categoryServiceImpl")
	private CategoryService service;
	
	// 1. 카테고리 리스트
	@GetMapping("/list.do")
	public String list(@RequestParam(defaultValue = "0") Integer cate_code1, Model model) {
	
		log.info("cate_code1 = " + cate_code1);
		// 대분류 가져오기
		List<CategoryVO> listBig = service.list(0);
		
		
		
		// 중분류 가져오기
		// cate_code1 이 없으면 cate_code1 중 제일 작은것 가져와서 처리
		if (cate_code1 == 0 && (listBig != null && listBig.size() != 0)) {
			// listBig을 DB에서 가져올때 cate_code1을 Asc했기 때문에
			// 첫번째가 cate_code1 가장 작은 값이다. 
			cate_code1 = listBig.get(0).getCate_code1();
		}
		
		List<CategoryVO> listMid = service.list(cate_code1);
		
		// 처리된 값을  model에 담아서 넘긴다.
		model.addAttribute("listBig", listBig);
		model.addAttribute("listMid", listMid);
		
		model.addAttribute("cate_code1", cate_code1);
		
		log.info("cate_code1 = " + cate_code1 );
		
		// "/WEB-INF/views/ + category/list + .jsp"
		return "category/list";
	}
}











