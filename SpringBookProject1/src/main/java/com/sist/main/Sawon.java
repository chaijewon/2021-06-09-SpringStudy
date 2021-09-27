package com.sist.main;

public class Sawon {
    private String name;
    private String sex;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
    public void print()
    {
    	System.out.println("이름:"+name);
    	System.out.println("성별:"+sex);
    }
}
