package com.ssafy.happyhouse.model.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.HouseInfoDto;
import com.ssafy.happyhouse.model.HouseSubwayDto;
import com.ssafy.happyhouse.model.SidoGugunCodeDto;
import com.ssafy.happyhouse.model.StationDto;
import com.ssafy.happyhouse.model.mapper.HouseMapMapper;
import com.ssafy.happyhouse.util.DistanceUtil;

@Service
public class HouseMapServiceImpl implements HouseMapService {
	
	@Autowired
	private HouseMapMapper houseMapMapper;

	@Override
	public List<SidoGugunCodeDto> getSido() throws Exception {
		return houseMapMapper.getSido();
	}

	@Override
	public List<SidoGugunCodeDto> getGugunInSido(String sido) throws Exception {
		return houseMapMapper.getGugunInSido(sido);
	}

	@Override
	public List<HouseInfoDto> getDongInGugun(String gugun) throws Exception {
		return houseMapMapper.getDongInGugun(gugun);
	}

	@Override
	public List<HouseSubwayDto> getAptInDong(String dong) throws Exception {
		List<HouseInfoDto> houseList = houseMapMapper.getAptInDong(dong);
		List<StationDto> stationList = houseMapMapper.getStationList();
		List<HouseSubwayDto> hsList = new ArrayList<HouseSubwayDto>();
		for(HouseInfoDto i : houseList) {
			HouseSubwayDto tmp = new HouseSubwayDto();
			tmp.setHouseInfoDto(i);
			tmp.setSubwayDistance(Double.MAX_VALUE);
			for(StationDto j : stationList) {
				double distance = DistanceUtil.haversine(Double.parseDouble(tmp.getHouseInfoDto().getLat()), Double.parseDouble(tmp.getHouseInfoDto().getLng()), Double.parseDouble(j.getLat()), Double.parseDouble(j.getLng()));
				if(tmp.getSubwayDistance() > distance) {
					tmp.setSubwayLine(j.getLine());
					tmp.setSubwayName(j.getName());
					tmp.setSubwayDistance(distance);
				}
			}
			hsList.add(tmp);
		}
		return hsList;
	}

}
