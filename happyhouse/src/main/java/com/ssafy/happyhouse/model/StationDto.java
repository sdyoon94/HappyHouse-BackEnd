package com.ssafy.happyhouse.model;

public class StationDto {
	private String line;
	private String name;
	private String lat;
	private String lng;

	public String getLine() {
		return line;
	}

	public void setLine(String line) {
		this.line = line;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	@Override
	public String toString() {
		return "StationDto [line=" + line + ", name=" + name + ", lat=" + lat + ", lng=" + lng + "]";
	}
}
