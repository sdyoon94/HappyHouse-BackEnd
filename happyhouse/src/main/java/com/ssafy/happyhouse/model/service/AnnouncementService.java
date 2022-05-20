package com.ssafy.happyhouse.model.service;

import java.util.List;

import com.ssafy.happyhouse.model.AnnouncementDto;

public interface AnnouncementService {
	void registerAnnouncement(AnnouncementDto announcementDto) throws Exception;
	List<AnnouncementDto> getAnnouncementList() throws Exception;
	List<AnnouncementDto> getAnnouncementSearchList(String subject) throws Exception;
	AnnouncementDto getAnnouncementInfo(int announcementNo) throws Exception;
	void updateAnnouncement(AnnouncementDto announcementDto) throws Exception;
	void deleteAnnouncement(int announcementNo) throws Exception;
}
