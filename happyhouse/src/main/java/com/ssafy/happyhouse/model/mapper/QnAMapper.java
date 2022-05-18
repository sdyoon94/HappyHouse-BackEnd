package com.ssafy.happyhouse.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.model.QnADto;

@Mapper
public interface QnAMapper {
	void registerQnA(QnADto qnaDto) throws Exception;
	List<QnADto> getQnAList() throws Exception;
	QnADto getQnADetail(int qnaIndex) throws Exception;
	List<QnADto> getQnASearch(String keyword) throws Exception;
	void updateQnA(QnADto qnaDto) throws Exception;
	void deleteQnA(int qnaIndex) throws Exception;
}
