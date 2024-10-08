package org.zerock.board.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.board.service.BoardService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/board")
@Log4j
public class BoardController {
	
	// 자동 DI
	@Setter(onMethod_ = @Autowired)
	private BoardService service;

	@GetMapping("/list.do")
	public String list(HttpServletRequest request) {
		log.info("list()");
		request.setAttribute("list", service.list());
		return "board/list";
	}
}
