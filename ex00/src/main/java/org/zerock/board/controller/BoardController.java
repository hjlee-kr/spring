package org.zerock.board.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.zerock.board.service.BoardService;
import org.zerock.board.vo.BoardVO;
import org.zerock.util.page.PageObject;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/board")
@Log4j
public class BoardController {
	
	// 자동 DI
	@Setter(onMethod_ = @Autowired)
	private BoardService service;

	// 1. 일반 게시판 리스트
	@GetMapping("/list.do")
	// 1. HttpServletRequest 에 자료를 담아서 넘긴다.
//	public String list(HttpServletRequest request) {
	// 2. Model(Spring에서 제공) 을 이용하여 자료넘기기 
	public String list(Model model, HttpServletRequest request) {
	// 3. ModelAndView 를 활용
	//public ModelAndView list(Model model) {
		log.info("list() =======");
		
		// 페이지 처리를 위한 객체 생성
		PageObject pageObject = PageObject.getInstance(request);
		// 1.
		//request.setAttribute("list", service.list());
		// 2. 처리된 데이터를 model 저장해서 넘긴다.
		// model에 담으면 request에 자동으로 담긴다.
		model.addAttribute("list", service.list(pageObject));
		model.addAttribute("pageObject", pageObject);
		return "board/list";

		// 3. ModelAndView 를 활용하여 데이터를 담고 페이지이동한다.
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("list", service.list());
//		mav.setViewName("board/list");
//		
//		return mav;
	}
	
	// 2. 일반 게시판 글보기
	@GetMapping("/view.do")
	// uri에 있는 key값과 동일한 이름의 변수에 값이 담긴다. (no, inc)
	public String view(Model model, Long no, int inc) {
		log.info("view() ======");
		model.addAttribute("vo", service.view(no, inc));
		return "board/view";
	}
	
	// 3-1. 일반 게시판 글쓰기 폼
	// class에 있는 mapping주소 + 메서드 mapping주소로 접근하게 된다.
	@GetMapping("/writeForm.do")
	public String writeForm() {
		log.info("writeForm() =======");
		//service.write();
		return "board/write";
	}
	
	// 3-2. 일반 게시판 글쓰기 처리
	@PostMapping("/write.do")
	public String write(BoardVO vo) {
		log.info("write() =======");
		
		service.write(vo);
		
		return "redirect:list.do";
	}
}










