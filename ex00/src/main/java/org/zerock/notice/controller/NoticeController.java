package org.zerock.notice.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.notice.service.NoticeService;
import org.zerock.util.page.PageObject;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/notice")
public class NoticeController {

	@Autowired
	@Qualifier("noticeServiceImpl")
	private NoticeService service;
	
	// 1. 공지사항 리스트
	@GetMapping("/list.do")
	public String list(Model model, HttpServletRequest request) {
		log.info("list.do ======");
		
		// 페이지 처리를 위한 객체생성
		PageObject pageObject = PageObject.getInstance(request);
		
		// 처리된 데이터를 Model에 저장해서 jsp로 넘긴다.
		model.addAttribute("list", service.list(pageObject));
		model.addAttribute("pageObject", pageObject);
		
		return "notice/list";
	}
	
	// 2. 공지사항 글보기
	@GetMapping("/view.do")
	public String view(Model model, Long no) {
		log.info("view.do ================");
		model.addAttribute("vo", service.view(no));
		return "notice/view";
	}
	
}











