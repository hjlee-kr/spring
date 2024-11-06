package org.zerock.news.controller;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Projections;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/news")
public class NewsController {

	@GetMapping("/list.do")
	public String list(Model model) {
		List<Document> resultList = new ArrayList<>();
		
		// MongoDB 연결
		try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
			// MongoDB DB Table 연결
			MongoDatabase database = mongoClient.getDatabase("test");
			// MongoDB collection 연결
			MongoCollection<Document> collection = database.getCollection("new");
			
			// 데이터 가져오는 필드설정
			Bson projection = Projections.fields(
					Projections.include("title", "press", "link", "date"),
					Projections.exclude("_id"));
			// 오늘날짜만의 데이터만 가져오도록 설정
			LocalDateTime nowDate = LocalDateTime.now();
			DateTimeFormatter formatter
				= DateTimeFormatter.ofPattern("yyyyMMdd");
			String formattedDate = formatter.format((TemporalAccessor) nowDate);
			log.info("date : " + formattedDate);
			Document query = new Document("date", formattedDate);
			
			// DB 자료를 resultList에 저장
			collection.find(query).projection(projection).into(resultList);

		//	for (Document doc : collection.find().projection(projection)) {
		//		log.info(doc.toJson());
		//	}
			model.addAttribute("resultList", resultList);
		}
		
		return "news/list";
	}
}
