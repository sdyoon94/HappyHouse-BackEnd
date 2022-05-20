package com.ssafy.happyhouse.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.MemberDto;
import com.ssafy.happyhouse.model.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberMapper memberMapper;
	
	@Override
	public int idCheck(String checkId) throws Exception {
		return memberMapper.idCheck(checkId); // 0 or 1
	}

	@Override
	public void registerMember(MemberDto memberDto) throws Exception {
//		validation check
		memberMapper.registerMember(memberDto);
	}

	@Override
	public MemberDto login(Map<String, String> map) throws Exception {
		return memberMapper.login(map);
	}
	
	@Override
	public List<MemberDto> listMember() throws Exception {
		return memberMapper.listMember();
	}

	@Override
	public MemberDto getMember(String userId) throws Exception {
		return memberMapper.getMember(userId);
	}

	@Override
	public void updateMember(MemberDto memberDto) throws Exception {
		memberMapper.updateMember(memberDto);
	}

	@Override
	public void deleteMember(String userId) throws Exception {
		memberMapper.deleteMember(userId);
	}

	@Override
	public MemberDto pwCheck(Map<String, String> map) {
		return memberMapper.pwCheck(map);
	}

	@Override
	public int userModify(Map<String, String> map) {
		return memberMapper.userModify(map);
	}

	@Override
	public int checkUser(Map<String, String> map) {
		return memberMapper.checkUser(map);
	}

	@Override
	public int setPw(Map<String, String> map) {
		return memberMapper.setPw(map);
	}

}
