package com.dlt.senior.survey.model;

import org.springframework.stereotype.Component;

@Component
public class GraphVO {
	private String gender = "";
	private String age = "";
	private int health;
	private int eco;
	private int rel;
	private int finalscore;
	
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
	
	public int getHealth() {
		return health;
	}
	
	public void setHealth(int health) {
		this.health = health;
	}
	
	public int getEco() {
		return eco;
	}
	
	public void setEco(int eco) {
		this.eco = eco;
	}
	
	public int getRel() {
		return rel;
	}
	
	public void setRel(int rel) {
		this.rel = rel;
	}

	public int getFinalscore() {
		return finalscore;
	}

	public void setFinalscore(int finalscore) {
		this.finalscore = finalscore;
	}
	
}
