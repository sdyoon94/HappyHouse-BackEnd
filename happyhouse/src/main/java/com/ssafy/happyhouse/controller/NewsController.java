package com.ssafy.happyhouse.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.happyhouse.model.service.NewsService;

@Controller
@RequestMapping("/news")
public class NewsController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Autowired
	private NewsService newsService;

	@GetMapping("/list")
	public ModelAndView NewsList() throws Exception {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("news/news");
		mav.addObject("newsList", newsService.NewsList());
		return mav;
	}
}
