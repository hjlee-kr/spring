package org.zerock.goods.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
		
		List<CategoryVO> listBig = new ArrayList<CategoryVO>();
		
		listBig = service.listCategory(0);
		
		model.addAttribute("listBig", listBig);
		
		return "goods/write";
	}
	
	// 중분류 가져오기 
	@GetMapping(value = "/getCategory.do",
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<List<CategoryVO>> getCategory(Integer cate_code1) {
		
		List<CategoryVO> listMid = new ArrayList<CategoryVO>();
		
		listMid = service.listCategory(cate_code1);
		
		return new ResponseEntity<List<CategoryVO>>(listMid, HttpStatus.OK);
	}
	
}







