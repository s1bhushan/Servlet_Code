package com.model;



public class Society {
	private String wing;
	private int flatno;
	private String Name;
	private double amount;
	
	public Society(String wing, int flatno, String name, double amount) {
		super();
		this.wing = wing;
		this.flatno = flatno;
		this.Name = name;
		this.amount = amount;
	}
	public String getWing() {
		return wing;
	}
	public void setWing(String wing) {
		this.wing = wing;
	}
	public int getFlatno() {
		return flatno;
	}
	public void setFlatno(int flatno) {
		this.flatno = flatno;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		this.Name = name;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Building [wing=" + wing + ", flatno=" + flatno + ", Name=" + Name + ", amount=" + amount + "]";
	}
	
	

}

