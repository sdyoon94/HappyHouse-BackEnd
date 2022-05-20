package com.ssafy.happyhouse.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.model.AnnouncementDto;

@Mapper
public interface AnnouncementMapper {
	void registerAnnouncement(AnnouncementDto announcementDto) throws Exception;
	List<AnnouncementDto> getAnnouncementList() throws Exception;
	List<AnnouncementDto> getAnnouncementSearchList(String subject) throws Exception;
	AnnouncementDto getAnnouncementInfo(int announcementNo) throws Exception;
	void updateAnnouncement(AnnouncementDto announcementDto) throws Exception;
	void deleteAnnouncement(int announcementNo) throws Exception;
}
