package com.ssafy.happyhouse.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.AnnouncementDto;
import com.ssafy.happyhouse.model.mapper.AnnouncementMapper;

@Service
public class AnnouncementServiceImpl implements AnnouncementService{

	@Autowired
	AnnouncementMapper announcementMapper;
	
	@Override
	public List<AnnouncementDto> getAnnouncementList() throws Exception {
		return announcementMapper.getAnnouncementList();
	}

	@Override
	public List<AnnouncementDto> getAnnouncementSearchList(String subject) throws Exception {
		return announcementMapper.getAnnouncementSearchList(subject);
	}

	@Override
	public AnnouncementDto getAnnouncementInfo(int announcementNo) throws Exception {
		return announcementMapper.getAnnouncementInfo(announcementNo);
	}

	@Override
	public void registerAnnouncement(AnnouncementDto announcementDto) throws Exception {
		announcementMapper.registerAnnouncement(announcementDto);
	}

	@Override
	public void updateAnnouncement(AnnouncementDto announcementDto) throws Exception {
		announcementMapper.updateAnnouncement(announcementDto);
	}

	@Override
	public void deleteAnnouncement(int announcementNo) throws Exception {
		announcementMapper.deleteAnnouncement(announcementNo);
	}

}
