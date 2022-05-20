package com.ssafy.happyhouse.controller;

import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssafy.happyhouse.model.MemberDto;
import com.ssafy.happyhouse.model.service.MemberService;
import com.ssafy.happyhouse.util.CryptoUtil;

//회원 처리용 controller
@Controller
@RequestMapping("/user")
@CrossOrigin("*")
public class MemberController {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Autowired
	private MemberService memberService;

	@PostMapping("/check")
	@ResponseBody
	public boolean pwCheck(@RequestBody Map<String, String> map) throws Exception {
		map.replace("userPwd", CryptoUtil.sha512(map.get("userPwd")));
		MemberDto memberDto = memberService.pwCheck(map);
		if(memberDto==null) {
			return false;
		}else {
			return true;
		}
	}
	
	@PostMapping("/modify")
	@ResponseBody
	public int userModify(@RequestBody Map<String, String> map) throws Exception {
		map.replace("userPwd", CryptoUtil.sha512(map.get("userPwd")));
		return memberService.userModify(map);
	}
	
	@GetMapping("/idcheck")
	public @ResponseBody String idCheck(@RequestParam("ckid") String checkId) throws Exception {
		logger.debug("아이디 중복 검사 : {}", checkId);
		int cnt = memberService.idCheck(checkId);
		JSONObject json = new JSONObject();
		json.put("idcount", cnt);
		return json.toString();
	}

	@PostMapping("/register")
	public @ResponseBody ResponseEntity<?> register(@RequestBody MemberDto memberDto) throws Exception {
		if (memberService.idCheck(memberDto.getUserId()) == 0) {
			memberDto.setUserPwd(CryptoUtil.sha512(memberDto.getUserPwd()));
			memberService.registerMember(memberDto);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody Map<String, String> map) throws Exception {
		map.replace("userPwd", CryptoUtil.sha512(map.get("userPwd")));
		MemberDto memberDto = memberService.login(map);
		if (memberDto != null) {
			return new ResponseEntity<MemberDto>(memberDto, HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
	}

	@GetMapping("/list")
	public String list() {
		return "user/list";
	}

}
