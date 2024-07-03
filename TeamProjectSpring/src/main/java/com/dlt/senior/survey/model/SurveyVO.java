package com.dlt.senior.survey.model;

public class SurveyVO {
	private int SEQ;
    private String gender;
    private String age;
    private String region;
    private String health1;
    private String health2;
    private String health3;
    private String economy1;
    private String economy2;
    private String economy3;
    private String social1;
    private String social2;
    private String social3;
    
	public int getSEQ() {
		return SEQ;
	}
	
	public void setSEQ(int SEQ) {
		this.SEQ = SEQ;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getAge() {
		return age;
	}
	
	public void setAge(String age) {
		this.age = age;
	}
	
	public String getRegion() {
		return region;
	}
	
	public void setRegion(String region) {
		this.region = region;
	}
	
	public String getHealth1() {
		return health1;
	}
	
	public void setHealth1(String health1) {
		this.health1 = health1;
	}
	
	public String getHealth2() {
		return health2;
	}
	
	public void setHealth2(String health2) {
		this.health2 = health2;
	}
	
	public String getHealth3() {
		return health3;
	}
	
	public void setHealth3(String health3) {
		this.health3 = health3;
	}
	
	public String getEconomy1() {
		return economy1;
	}
	
	public void setEconomy1(String economy1) {
		this.economy1 = economy1;
	}
	
	public String getEconomy2() {
		return economy2;
	}
	
	public void setEconomy2(String economy2) {
		this.economy2 = economy2;
	}
	
	public String getEconomy3() {
		return economy3;
	}
	
	public void setEconomy3(String economy3) {
		this.economy3 = economy3;
	}
	
	public String getSocial1() {
		return social1;
	}
	
	public void setSocial1(String social1) {
		this.social1 = social1;
	}
	
	public String getSocial2() {
		return social2;
	}
	
	public void setSocial2(String social2) {
		this.social2 = social2;
	}
	
	public String getSocial3() {
		return social3;
	}
	
	public void setSocial3(String social3) {
		this.social3 = social3;
	}
	
	@Override
	public String toString() {
		return "SurveyVO [SEQ=" + SEQ + ", gender=" + gender + ", age=" + age + ", region=" + region + ", health1="
				+ health1 + ", health2=" + health2 + ", health3=" + health3 + ", economy1=" + economy1 + ", economy2="
				+ economy2 + ", economy3=" + economy3 + ", social1=" + social1 + ", social2=" + social2 + ", social3="
				+ social3 + "]";
	}
	
    
    
    
}