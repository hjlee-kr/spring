package org.zerock.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
		
		// 폴더 만들기
		File uploadPath = new File(uploadFolder, getFolder());
		log.info("upload path : " + uploadPath);
		
		if (uploadPath.exists() == false) {
			uploadPath.mkdirs(); // c:/upload/yyyy/MM/dd" 폴더 생성
		}
		
		// foreach 형태로 사용 (향상된 for문)
		for (MultipartFile multipartFile : uploadFile) {
			log.info("============================================");
			log.info("upload file name : " + multipartFile.getOriginalFilename());
			log.info("upload file size : " + multipartFile.getSize());
			
			String uploadFileName = multipartFile.getOriginalFilename();
			
			//File saveFile = new File(uploadFolder, uploadFileName);
			File saveFile = new File(uploadPath, uploadFileName);
			multipartFile.transferTo(saveFile);
		}
	}
	
	// 저장폴더를 YYYY/MM/DD 가 되도록 만드는 메서드
	private String getFolder() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Date date = new Date(); // 현재 시간 저장
		
		String str = sdf.format(date);
		
		return str.replace("-", File.separator);
	}
	
} // end of class














