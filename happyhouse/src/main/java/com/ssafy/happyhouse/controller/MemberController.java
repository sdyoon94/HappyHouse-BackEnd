package com.ssafy.happyhouse.controller;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssafy.happyhouse.model.MemberDto;
import com.ssafy.happyhouse.model.service.MemberService;
import com.ssafy.happyhouse.util.CryptoUtil;

//회원 처리용 controller
@Controller
@RequestMapping("/user")
public class MemberController {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Autowired
	private MemberService memberService;

	@GetMapping("/register")
	public String register() {
		return "user/join";
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
	public String register(MemberDto memberDto, Model model) throws Exception {
		logger.debug("memberDto info : {}", memberDto);
		memberDto.setUserPwd(CryptoUtil.sha512(memberDto.getUserPwd()));
		memberService.registerMember(memberDto);
		return "redirect:/user/login";
	}

	@GetMapping("/login")
	public String login() {
		return "user/login";
	}

	@PostMapping("/login")
	public String login(@RequestParam Map<String, String> map, Model model, HttpSession session,
			HttpServletResponse response) throws Exception {
		logger.debug("map : {}", map.get("userId"));
		System.out.println(map.get("userPwd"));
		map.replace("userPwd", CryptoUtil.sha512(map.get("userPwd")));
		System.out.println(map.get("userPwd"));
		MemberDto memberDto = memberService.login(map);
		if (memberDto != null) {
			session.setAttribute("userinfo", memberDto);

			Cookie cookie = new Cookie("ssafy_id", map.get("userId"));
			cookie.setPath("/");
			if ("saveok".equals(map.get("idsave"))) {
				cookie.setMaxAge(60 * 60 * 24 * 365 * 40);
			} else {
				cookie.setMaxAge(0);
			}
			response.addCookie(cookie);
			return "redirect:/";
		} else {
			model.addAttribute("msg", "아이디 또는 비밀번호 확인 후 다시 로그인하세요!");
			return "user/login";
		}
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("/list")
	public String list() {
		return "user/list";
	}

}
