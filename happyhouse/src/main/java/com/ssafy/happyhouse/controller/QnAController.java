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
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.model.CommentDto;
import com.ssafy.happyhouse.model.QnADto;
import com.ssafy.happyhouse.model.service.CommentService;
import com.ssafy.happyhouse.model.service.QnAService;

@RestController
@RequestMapping("/qna")
@CrossOrigin("*")
public class QnAController {

	@Autowired
	private QnAService qnaService;
	private CommentService commentService;

	@PostMapping("/")
	public ResponseEntity<?> registerQnA(QnADto qnaDto) throws Exception {
		qnaService.registerQnA(qnaDto);
		return new ResponseEntity<List<QnADto>>(qnaService.getQnAList(), HttpStatus.OK);
	}

	@GetMapping("/")
	public ResponseEntity<?> getQnAList() throws Exception {
		List<QnADto> list = qnaService.getQnAList();
		if (list != null && !list.isEmpty()) {
			return new ResponseEntity<List<QnADto>>(list, HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
	}

	@GetMapping("/{qnaIndex}")
	public ResponseEntity<?> getQnADetail(@PathVariable int qnaIndex) throws Exception {
		QnADto qnaDto = qnaService.getQnADetail(qnaIndex);
		if (qnaDto != null) {
			return new ResponseEntity<QnADto>(qnaDto, HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
	}

	@GetMapping("/comment/{qnaIndex}")
	public ResponseEntity<?> getCommentList(@PathVariable int qnaIndex) throws Exception {
		List<CommentDto> list = commentService.getCommentList(qnaIndex);
		if (list != null && !list.isEmpty()) {
			return new ResponseEntity<List<CommentDto>>(list, HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
	}

	@PutMapping("/")
	public ResponseEntity<?> updateQnA(@RequestBody QnADto qnaDto) throws Exception {
		qnaService.updateQnA(qnaDto);
		return new ResponseEntity<List<QnADto>>(qnaService.getQnAList(), HttpStatus.OK);
	}
	
	@DeleteMapping("/{qnaIndex}")
	public ResponseEntity<?> deleteQnA(@PathVariable int qnaIndex) throws Exception{
		qnaService.deleteQnA(qnaIndex);
		return new ResponseEntity<List<QnADto>>(qnaService.getQnAList(), HttpStatus.OK);
	}
}
