package com.ssafy.happyhouse.model.service;

import java.util.List;

import com.ssafy.happyhouse.model.AnnouncementDto;

public interface NewsService {
	List<String[]> NewsList() throws Exception;
}
