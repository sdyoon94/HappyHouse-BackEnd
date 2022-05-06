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

import com.ssafy.happyhouse.model.MemberDto;
import com.ssafy.happyhouse.model.service.MemberService;
import com.ssafy.happyhouse.util.CryptoUtil;

@RestController
@RequestMapping("/admin")
@CrossOrigin("*")
public class AdminController {
	@Autowired
	private MemberService memberService;

	@GetMapping("/user")
	public ResponseEntity<?> userList() throws Exception {
		List<MemberDto> list = memberService.listMember();
		if (list != null && !list.isEmpty()) {
			return new ResponseEntity<List<MemberDto>>(list, HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
	}

	@PostMapping("/user")
	public ResponseEntity<?> userRegister(@RequestBody MemberDto memberDto) throws Exception {
		memberService.registerMember(memberDto);
		return new ResponseEntity<List<MemberDto>>(memberService.listMember(), HttpStatus.OK);
	}

	@GetMapping("/user/{userid}")
	public ResponseEntity<?> userInfo(@PathVariable String userid) throws Exception {
		MemberDto memberDto = memberService.getMember(userid);
		if(memberDto!=null) {
			return new ResponseEntity<MemberDto>(memberDto, HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
	}
	
	@PutMapping("/user")
	public ResponseEntity<?> userModify(@RequestBody MemberDto memberDto) throws Exception {
		String temppw=memberDto.getUserPwd();
		memberDto.setUserPwd(CryptoUtil.sha512(temppw));
		memberService.updateMember(memberDto);
		return new ResponseEntity<List<MemberDto>>(memberService.listMember(), HttpStatus.OK);
	}
	
	@DeleteMapping("/user/{userid}")
	public ResponseEntity<?> userdelete(@PathVariable String userid) throws Exception{
		memberService.deleteMember(userid);
		return new ResponseEntity<List<MemberDto>>(memberService.listMember(), HttpStatus.OK);
	}
}
