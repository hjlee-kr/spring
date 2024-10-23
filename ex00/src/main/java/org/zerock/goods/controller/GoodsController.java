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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.category.vo.CategoryVO;
import org.zerock.goods.service.GoodsService;
import org.zerock.goods.vo.GoodsColorVO;
import org.zerock.goods.vo.GoodsImageVO;
import org.zerock.goods.vo.GoodsSizeVO;
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
	public String writeForm(Model model) {
		
		List<CategoryVO> listBig = new ArrayList<CategoryVO>();
		List<CategoryVO> listMid = new ArrayList<CategoryVO>();
		
		listBig = service.listCategory(0);
		// 대분류 첫번째에 있는 중분류를 가져온다.
		listMid = service.listCategory(listBig.get(0).getCate_code1());
		
		model.addAttribute("listBig", listBig);
		model.addAttribute("listMid", listMid);
		
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
	
	// 상품 등록 처리
	@PostMapping("/write.do")
	public String write(
			GoodsVO vo,
			// 대표이미지
			MultipartFile imageMain,
			// 추가이미지
			@RequestParam("imageFiles") ArrayList<MultipartFile> imageFiles,
			// 옵션 - 사이즈, 색상
			@RequestParam("size_names") ArrayList<String> size_names,
			@RequestParam("color_names") ArrayList<String> color_names,
			RedirectAttributes rttr
			) {
		
		log.info("============write.do=================");
		log.info(vo);
		log.info("대표이미지 : " + imageMain.getOriginalFilename());
		log.info("<<추가이미지>>");
		for (MultipartFile file : imageFiles) {
			log.info(file.getOriginalFilename());
		}
		log.info("size : " + size_names);
		log.info("color : " + color_names);
		log.info("=====================================");
		
		// 추가이미지, size, color를 담을 리스트들을 만든다.
		
		vo.setImage_name(imageMain.getOriginalFilename());
		
		List<String> imageFileNames = new ArrayList<String>();
		for (MultipartFile file : imageFiles) {
			imageFileNames.add(file.getOriginalFilename());
		}
		service.write(vo, imageFileNames, size_names, color_names);
		
		return "redirect:list.do";
	}
}







