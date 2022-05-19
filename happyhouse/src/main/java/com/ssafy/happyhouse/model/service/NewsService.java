package com.ssafy.happyhouse.model.service;

import java.util.List;

import com.ssafy.happyhouse.model.AnnouncementDto;
import com.ssafy.happyhouse.model.NewsDto;

public interface NewsService {
	List<NewsDto> getNewsList() throws Exception;
}
