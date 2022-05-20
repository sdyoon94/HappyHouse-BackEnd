package com.ssafy.happyhouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.model.AnnouncementDto;
import com.ssafy.happyhouse.model.service.AnnouncementService;

@RestController
@RequestMapping("/announcement")
@CrossOrigin("*")
public class AnnouncementController {
	@Autowired
	private AnnouncementService announcementService;
	
	@PostMapping
	public ResponseEntity<?> registerAnnouncement(@RequestBody AnnouncementDto announcementDto) throws Exception {
		announcementService.registerAnnouncement(announcementDto);
		return new ResponseEntity<List<AnnouncementDto>>(announcementService.getAnnouncementList(), HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<?> list() throws Exception {
		List<AnnouncementDto> list = announcementService.getAnnouncementList();
		if (list != null && !list.isEmpty()) {
			return new ResponseEntity<List<AnnouncementDto>>(list, HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping("/{announcementNo}")
	public ResponseEntity<?> info(@PathVariable int announcementNo) throws Exception {
		AnnouncementDto announcementDto = announcementService.getAnnouncementInfo(announcementNo);
		if(announcementDto != null) {
			return new ResponseEntity<AnnouncementDto>(announcementService.getAnnouncementInfo(announcementNo), HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping("/searchlist")
	public ResponseEntity<List<AnnouncementDto>> searchlist(@RequestParam("subject") String subject) throws Exception {
		return new ResponseEntity<List<AnnouncementDto>>(announcementService.getAnnouncementSearchList(subject), HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<?> updateAnnouncement(@RequestBody AnnouncementDto announcementDto) throws Exception {
		announcementService.updateAnnouncement(announcementDto);
		return new ResponseEntity<List<AnnouncementDto>>(announcementService.getAnnouncementList(), HttpStatus.OK);
	}

	@DeleteMapping("/{announcementNo}")
	public ResponseEntity<?> deleteAnnouncement(@PathVariable int announcementNo) throws Exception {
		announcementService.deleteAnnouncement(announcementNo);
		return new ResponseEntity<List<AnnouncementDto>>(announcementService.getAnnouncementList(), HttpStatus.OK);
	}
}
