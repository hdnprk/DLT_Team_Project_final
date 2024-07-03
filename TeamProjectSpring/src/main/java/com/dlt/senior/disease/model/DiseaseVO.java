package com.dlt.senior.disease.model;

public class DiseaseVO {
	private String districtId;
	private String districtName;
	private String regionId;
	private String regionName;
	//질병 데이터
	private int data_id;	
	private double dementiaData; //치매
	private double diabetesData; //당뇨
	private double hyperlipidemiaData; //고지혈증
	private double hypertensionData; //고혈압
	private int year;
	
	public int getData_id() {
		return data_id;
	}
	public void setData_id(int data_id) {
		this.data_id = data_id;
	}
	public double getDementiaData() {
		return dementiaData;
	}
	public void setDementiaData(double dementiaData) {
		this.dementiaData = dementiaData;
	}
	public double getDiabetesData() {
		return diabetesData;
	}
	public void setDiabetesData(double diabetesData) {
		this.diabetesData = diabetesData;
	}
	public double getHyperlipidemiaData() {
		return hyperlipidemiaData;
	}
	public void setHyperlipidemiaData(double hyperlipidemiaData) {
		this.hyperlipidemiaData = hyperlipidemiaData;
	}
	public double getHypertensionData() {
		return hypertensionData;
	}
	public void setHypertensionData(double hypertensionData) {
		this.hypertensionData = hypertensionData;
	}
	
	public String getDistrictId() {
		return districtId;
	}
	public void setDistrictId(String districtId) {
		this.districtId = districtId;
	}
	public String getDistrictName() {
		return districtName;
	}
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}
	public String getRegionId() {
		return regionId;
	}
	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}
	public String getRegionName() {
		return regionName;
	}
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
}
