package com.ssafy.happyhouse.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.model.CommentDto;

@Mapper
public interface CommentMapper {
	void registerComment(CommentDto commentDto) throws Exception;
	List<CommentDto> getCommentList(int qnaIndex) throws Exception;
}
