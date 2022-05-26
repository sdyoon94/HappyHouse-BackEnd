package com.ssafy.happyhouse.model;

public class HouseSubwayDto {

	private HouseInfoDto houseInfoDto;
	private String subwayLine;
	private String subwayName;
	private double subwayDistance;
	
	public HouseInfoDto getHouseInfoDto() {
		return houseInfoDto;
	}
	public void setHouseInfoDto(HouseInfoDto houseInfoDto) {
		this.houseInfoDto = houseInfoDto;
	}
	public String getSubwayLine() {
		return subwayLine;
	}
	public void setSubwayLine(String subwayLine) {
		this.subwayLine = subwayLine;
	}
	public String getSubwayName() {
		return subwayName;
	}
	public void setSubwayName(String subwayName) {
		this.subwayName = subwayName;
	}
	public double getSubwayDistance() {
		return subwayDistance;
	}
	public void setSubwayDistance(double subwayDistance) {
		this.subwayDistance = subwayDistance;
	}
	@Override
	public String toString() {
		return "HouseSubwayDto [houseInfoDto=" + houseInfoDto + ", subwayLine=" + subwayLine + ", subwayName="
				+ subwayName + ", subwayDistance=" + subwayDistance + "]";
	}
}
