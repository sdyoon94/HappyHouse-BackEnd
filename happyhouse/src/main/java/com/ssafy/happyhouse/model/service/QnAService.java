package com.ssafy.happyhouse.model.service;

import java.util.List;

import com.ssafy.happyhouse.model.QnADto;

public interface QnAService {
	void registerQnA(QnADto qnaDto) throws Exception;
	List<QnADto> getQnAList() throws Exception;
	QnADto getQnADetail(int qnaIndex) throws Exception;
	List<QnADto> getQnASearch(String keyword) throws Exception;
	void updateQnA(QnADto qnaDto) throws Exception;
	void deleteQnA(int qnaIndex) throws Exception;
}
