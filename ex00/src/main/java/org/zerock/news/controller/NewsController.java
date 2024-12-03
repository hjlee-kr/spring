package org.zerock.news.controller;

import java.util.ArrayList;
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
		List<Document> resultList = new ArrayList<Document>();
		
		// MongoDBMS 연결
		try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
			// MongoDB 연결
			MongoDatabase database = mongoClient.getDatabase("mydb1");
			// MongoDB collection 연결
			MongoCollection<Document> collection = database.getCollection("news");
			
			// 데이터 가져오는 필드설정
			Bson projection = Projections.fields(
					Projections.include("title", "press", "link", "date", "section"),
					Projections.exclude("_id"));
			
			// DB자료를 resultList에 저장
			collection.find().projection(projection).into(resultList);
			log.info(resultList);
			
			model.addAttribute("resultList", resultList);
			
		}
		
		return "news/list";
	}
}
