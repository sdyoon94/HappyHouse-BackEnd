package com.ssafy.happyhouse.model.service;

import java.util.List;

import com.ssafy.happyhouse.model.CommentDto;

public interface CommentService {
	void registerComment(CommentDto commentDto) throws Exception;
	List<CommentDto> getCommentList(int qnaIndex) throws Exception;
}
