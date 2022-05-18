package com.ssafy.happyhouse.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.QnADto;
import com.ssafy.happyhouse.model.mapper.QnAMapper;

@Service
public class QnAServiceImpl implements QnAService{
	@Autowired
	QnAMapper qnaMapper;
	
	@Override
	public void registerQnA(QnADto qnaDto) throws Exception {
		qnaMapper.registerQnA(qnaDto);
	}

	@Override
	public List<QnADto> getQnAList() throws Exception {
		return qnaMapper.getQnAList();
	}

	@Override
	public List<QnADto> getQnASearch(String keyword) throws Exception {
		return qnaMapper.getQnASearch(keyword);
	}

	@Override
	public void updateQnA(QnADto qnaDto) throws Exception {
		qnaMapper.updateQnA(qnaDto);
		
	}

	@Override
	public void deleteQnA(int qnaIndex) throws Exception {
		qnaMapper.deleteQnA(qnaIndex);
	}

	@Override
	public QnADto getQnADetail(int qnaIndex) throws Exception {
		return qnaMapper.getQnADetail(qnaIndex);
	}
}
