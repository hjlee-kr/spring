package org.zerock.category.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.category.service.CategoryService;

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
		return "category/list";
	}
}











