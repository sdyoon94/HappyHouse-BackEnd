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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.happyhouse.model.AnnouncementDto;
import com.ssafy.happyhouse.model.HouseInfoDto;
import com.ssafy.happyhouse.model.SidoGugunCodeDto;
import com.ssafy.happyhouse.model.service.AnnouncementService;
import com.ssafy.happyhouse.model.service.HouseMapService;

@Controller
@RequestMapping("/announcement")
@CrossOrigin("*")
public class AnnouncementController {
	
	private final Logger logger = LoggerFactory.getLogger(AnnouncementController.class);

	@Autowired
	private AnnouncementService announcementService;
	
	@GetMapping("/list")
	public ModelAndView list() throws Exception {
		logger.debug("list : {}", announcementService.getAnnouncementList());
		ModelAndView mav=new ModelAndView();
		mav.setViewName("announcement/announcement");
		mav.addObject("announcementList", announcementService.getAnnouncementList());
		return mav;
	
	}
	
	@GetMapping("/info/{announcementNo}")
	public ModelAndView info(@PathVariable("announcementNo") int announcementNo) throws Exception {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("announcement/announcementInfo");
		mav.addObject("announcement", announcementService.getAnnouncementInfo(announcementNo));
		return mav;
	}
	
	@GetMapping("/searchlist")
	public ResponseEntity<List<AnnouncementDto>> searchlist(@RequestParam("subject") String subject) throws Exception {
		return new ResponseEntity<List<AnnouncementDto>>(announcementService.getAnnouncementSearchList(subject), HttpStatus.OK);
	}
	

	
}
