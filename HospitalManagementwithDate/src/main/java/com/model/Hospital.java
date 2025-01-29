package com.model;

import java.io.Serializable;
import java.time.LocalDate;


public class Hospital implements Serializable,Comparable<Hospital>{
	
	private int medID;
	private String pname;
	private int age;
	
	private String dname;
	private LocalDate apdate;
	public Hospital(int medID, String pname, int age, String dname, LocalDate date) {
		super();
		this.medID = medID;
		this.pname = pname;
		this.age = age;
		this.dname = dname;
		this.apdate = date;
	}
	public Hospital(){
		
	}
	public int getMedID() {
		return medID;
	}
	public void setMedID(int medID) {
		this.medID = medID;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public LocalDate getApdate() {
		return apdate;
	}
	public void setApdate(LocalDate apdate) {
		this.apdate = apdate;
	}
	@Override
	public String toString() {
		return "Hospital [medID=" + medID + ", pname=" + pname + ", age=" + age + ", dname=" + dname + ", apdate="
				+ apdate + "]";
	}
	@Override
	public int compareTo(Hospital o) {
		
		return Comparators.PNAME.compare(this, o);
	}
	

}
