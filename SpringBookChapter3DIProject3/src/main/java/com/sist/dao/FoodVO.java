package com.sist.dao;
// 캡슐화 코딩 (시큐어코딩) 
public class FoodVO {
    private String name;
    private String address;
    private String tel;
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
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	   
}
