package org.zerock.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.log4j.Log4j;

// @Controller, @RestController
// @Service, @Repository
// @Component, @~~Advice
@Controller
@Log4j
public class UploadController {

	@GetMapping("/uploadForm")
	public void uploadForm() {
		log.info("==== upload Form ====");
		// void type으로 선언하면
		// Mapping에 적힌 url로 -> jsp 만들어서 이동
		// /WEB-INF/views/ + uploadForm + .jsp
	}
	
	@PostMapping("/uploadFormAction")
	public void uploadFormPost(MultipartFile[] uploadFile, Model model) {
		
		log.info("**** 등록한 파일 정보 ****");
		for (MultipartFile multipartFile : uploadFile) {
			log.info("upload file name : " + multipartFile.getOriginalFilename());
			log.info("upload file size : " + multipartFile.getSize());
			log.info("*********************************");
		}
		
		String uploadFolder = "C:/upload";
		
		for (MultipartFile multipartFile : uploadFile) {
			File saveFile = new File(uploadFolder, multipartFile.getOriginalFilename());
			
			try {
				multipartFile.transferTo(saveFile);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		} // end of for()
	} // end of uploadFormPost()
	
	// Ajax 이용한 파일 업로드
	@GetMapping("/uploadAjax")
	public void uploadAjax() {
		log.info("uploadAjax ..........................");
		// 매서드 처리가 끝나고
		// "/WEB-INF/views/uploadAjax.jsp" 로 이동한다.
	}
	
	@PostMapping("/uploadAjaxAction")
	public void uploadAjaxAction(MultipartFile[] uploadFile) throws Exception {
		log.info("uploadAjaxAction ....................");
		
		String uploadFolder = "C:/upload";
		
		// foreach 형태로 사용 (향상된 for문)
		for (MultipartFile multipartFile : uploadFile) {
			log.info("============================================");
			log.info("upload file name : " + multipartFile.getOriginalFilename());
			log.info("upload file size : " + multipartFile.getSize());
			
			String uploadFileName = multipartFile.getOriginalFilename();
			
			File saveFile = new File(uploadFolder, uploadFileName);
			multipartFile.transferTo(saveFile);
		}
	}
	
	
} // end of class














