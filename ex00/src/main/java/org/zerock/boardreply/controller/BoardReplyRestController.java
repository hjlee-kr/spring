package org.zerock.boardreply.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.boardreply.service.BoardReplyService;
import org.zerock.boardreply.vo.BoardReplyVO;
import org.zerock.util.page.PageObject;

import lombok.extern.log4j.Log4j;

// 자동생성 어노테이션
// @Controller, @RestController
// @Service
// @Repository
// @Component
// @~~Advice
@RestController
// sitemesh에 적용안되는 uri 사용 - 이유는 화면에 구성하는 uri가 아니기 때문이다.
@RequestMapping("/boardreply")
@Log4j
public class BoardReplyRestController {

	// 자동DI
	@Autowired
	@Qualifier("boardReplyServiceImpl")
	private BoardReplyService service;
	
	// 1.리스트 - get
	@GetMapping(value = "/list.do",
			produces = {
				MediaType.APPLICATION_XML_VALUE,
				MediaType.APPLICATION_JSON_UTF8_VALUE
			})
	// 리턴 type은 String(uri)가 jsp에 넘어갈 자료를 생각해야 한다.
	// 댓글리스트, 페이지정보 - 두가지의 자료형이 틀리다. -> map
	public ResponseEntity<Map<String, Object>> 
		list(PageObject pageObject, Long no) {
		log.info("list - page : " + pageObject.getPage() + ", no : " + no);
		// DB에서 데이터(list)를 가져와서 넘겨줍니다.
		// pageObject 넘겨줍니다.
		List<BoardReplyVO> list = service.list(pageObject, no);
		
		// 데이터를 전달할 map 객체 생성
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("pageObject", pageObject);
		
		// list 와 pageObject의 데이터 확인
		// map으로 해서 데이터가 나오면 그냥사용하면 되고
		// 주소가 나오면 각각 출력하도록 작성 : map.list, map.pageObject;
		log.info("After map : " + map);
				
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
}








