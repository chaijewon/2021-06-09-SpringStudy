package com.sist.constructor5;

public class Sawon {
  private String name;
  private String dept;
  private String job;
  
  // 매개변수가 있는 생성자 만들 경우 
  public Sawon(String name, String dept, String job) {
	
	this.name = name;
	this.dept = dept;
	this.job = job;
  }
  
  public void print()
  {
	  System.out.println("이름:"+name);
	  System.out.println("부서:"+dept);
	  System.out.println("직위:"+job);
  }
  
}
