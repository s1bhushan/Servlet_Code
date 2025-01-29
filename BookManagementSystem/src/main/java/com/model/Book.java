package com.model;

import java.io.Serializable;
import java.time.LocalDate;

public class Book implements Serializable,Comparable<Book>{
	
	private int id;
	private String name;
	private double price;
	private LocalDate date;
	public Book(int id, String name, double price, LocalDate date) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.date = date;
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", price=" + price + ", date=" + date + "]";
	}
	@Override
	public int compareTo(Book o) {
		
		return Comparators.NAME.compare(this, o);
	}
	
	

}
