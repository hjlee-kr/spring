package org.zerock.goods.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.goods.service.GoodsService;

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
		return "goods/list";
	}
	
	
}







