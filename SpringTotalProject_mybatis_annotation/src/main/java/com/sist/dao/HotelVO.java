package com.sist.dao;
/*
 *  NO      NOT NULL NUMBER         
	NAME    NOT NULL VARCHAR2(100)  
	SCORE            NUMBER(2,1)    
	ADDRESS NOT NULL VARCHAR2(300)  
	POSTER  NOT NULL VARCHAR2(4000) 
	IMAGES           VARCHAR2(4000) 
	
	1. Spring
	     =설정 파일 
	      XML => 90%
	      Java(annotation) => 10%
	2. MyBatis 
	     =mapper
	     XML => 55%
	     Java(annotation) => 45%
 */
public class HotelVO {
    private int no;
    private String name,address;
    private double score;
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
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
   
}
