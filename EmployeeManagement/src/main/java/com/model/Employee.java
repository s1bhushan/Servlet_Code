package com.model;

import java.io.Serializable;

public class Employee implements Serializable{
	
	private int id;
	private String name;
	private double salary;
	private int year;
	public Employee(int id, String name, double salary, int year) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.year = year;
	}
	public Employee() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", year=" + year + "]";
	}
	
	
	
	

}
