package com.ssafy.happyhouse.model;

public class StationDto {
	private String line;
	private String name;
	private double lat;
	private double lng;

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

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

	@Override
	public String toString() {
		return "StationDto [line=" + line + ", name=" + name + ", lat=" + lat + ", lng=" + lng + "]";
	}
}
