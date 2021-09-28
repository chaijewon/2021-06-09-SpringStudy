package com.sist.two;

public class Sawon {
    private String name,dept,loc;

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDept() {
		return dept;
	}
	
	public void setDept(String dept) {
		this.dept = dept;
	}
	
	public String getLoc() {
		return loc;
	}
	
	public void setLoc(String loc) {
		this.loc = loc;
	}
	
	public void print()
	{
		System.out.println("이름:"+name);
		System.out.println("부서:"+dept);
		System.out.println("근무지:"+loc);
	}
	  
}
