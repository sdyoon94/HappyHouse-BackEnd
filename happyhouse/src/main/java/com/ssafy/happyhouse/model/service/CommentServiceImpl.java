package com.ssafy.happyhouse.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.CommentDto;
import com.ssafy.happyhouse.model.mapper.CommentMapper;

@Service
public class CommentServiceImpl implements CommentService {
	@Autowired
	CommentMapper commentMapper;

	@Override
	public void registerComment(CommentDto commentDto) throws Exception {
		commentMapper.registerComment(commentDto);

	}

	@Override
	public List<CommentDto> getCommentList(int qnaIndex) throws Exception {
		System.out.println("index : "+qnaIndex);
		return commentMapper.getCommentList(qnaIndex);
	}
}
