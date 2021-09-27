package com.sist.main5;
// Sawon/Member => 스프링에 관리 요청 (생성/소멸)
public class Sawon {
   private String name;
   private String dept;
   private String loc;
   private String job;
   private int pay;
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
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getPay() {
		return pay;
	}
	public void setPay(int pay) {
		this.pay = pay;
	}
	
   
}
