package com.ssafy.happyhouse.model.service;

import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.model.MemberDto;

public interface MemberService {

	MemberDto login(Map<String, String> map) throws Exception;
	
	int idCheck(String checkId) throws Exception;
	void registerMember(MemberDto memberDto) throws Exception;
	
	List<MemberDto> listMember() throws Exception;
	MemberDto getMember(String userId) throws Exception;
	void updateMember(MemberDto memberDto) throws Exception;
	void deleteMember(String userId) throws Exception;

	MemberDto pwCheck(Map<String, String> map);

	int userModify(Map<String, String> map);

	int checkUser(Map<String, String> map);

	int setPw(Map<String, String> map);
	
}
