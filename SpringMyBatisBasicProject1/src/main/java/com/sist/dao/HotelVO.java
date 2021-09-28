package com.sist.dao;

public class HotelVO {
    private int no;
    private String name,address;
    private double score;
    // SELECT * =>사용이 불가능  ==> poster,image => setPoster(),setImage() 
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
  
}
