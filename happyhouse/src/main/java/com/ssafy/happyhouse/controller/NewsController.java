package com.ssafy.happyhouse.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.happyhouse.model.NewsDto;
import com.ssafy.happyhouse.model.QnADto;
import com.ssafy.happyhouse.model.service.NewsService;

@RestController
@RequestMapping("/news")
@CrossOrigin("*")
public class NewsController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Autowired
	private NewsService newsService;

	@GetMapping("/list")
	public ResponseEntity<?> getNewsList() throws Exception {
		List<NewsDto> list=newsService.getNewsList();
		if (list != null && !list.isEmpty()) {
			return new ResponseEntity<List<NewsDto>>(list, HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
	}
}
