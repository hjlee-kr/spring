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
import org.springframework.web.bind.annotation.ModelAttribute;
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
import org.zerock.goods.vo.GoodsSearchVO;
import org.zerock.goods.vo.GoodsSizeVO;
import org.zerock.goods.vo.GoodsVO;
import org.zerock.util.file.FileUtil;
import org.zerock.util.page.PageObject;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/goods")
public class GoodsController {

	@Autowired
	@Qualifier("goodsServiceImpl")
	private GoodsService service;
	
	// 파일이 저장될 경로
	String path = "/upload/goods";
	
	
	@GetMapping("/list.do")
	// 검색을 위한 데이터를 별도로 받아서 처리
	// @ModelAttribute() - 전달받은 데이터를 Model에 담아서 JSP까지 전달합니다.
	// 1. 변수선언(생성) 2. DB에서 받은 데이터 변수에 저장
	// 3. 변수에 담긴것을 model로 넘겨서 JSP사용
	public String list(Model model,
			@ModelAttribute(name="goodsSearchVO") GoodsSearchVO goodsSearchVO,
			HttpServletRequest request) {
		
		PageObject pageObject = PageObject.getInstance(request);
		List<CategoryVO> listBig = new ArrayList<CategoryVO>();
		
		String perPageNum = request.getParameter("perPageNum");
		
		if (perPageNum == null) {
			pageObject.setPerPageNum(8);
		}
		else {
			pageObject.setPerPageNum(Integer.parseInt(perPageNum));
		}
		
		List<GoodsVO> list = new ArrayList<GoodsVO>();

		listBig = service.listCategory(0);
		list = service.list(pageObject, goodsSearchVO);

		if (goodsSearchVO.getCate_code1() != 0 && goodsSearchVO.getCate_code1() != null) {
			List<CategoryVO> listMid = new ArrayList<CategoryVO>();
			listMid = service.listCategory(goodsSearchVO.getCate_code1());
			model.addAttribute("listMid", listMid);
		}
		
		model.addAttribute("list", list);
		model.addAttribute("listBig", listBig);
		model.addAttribute("pageObject", pageObject);
		//model.addAttribute("goodsSearchVO", goodsSearchVO)
		
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
			HttpServletRequest request,
			RedirectAttributes rttr
			) throws Exception {
		
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
		
		vo.setImage_name(FileUtil.upload(path, imageMain, request));
		
		List<String> imageFileNames = new ArrayList<String>();
		for (MultipartFile file : imageFiles) {
			imageFileNames.add(FileUtil.upload(path, file, request));
		}
		Integer result = service.write(vo, imageFileNames, size_names, color_names);
		
		return "redirect:list.do";
	}
	

}







