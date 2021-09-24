package com.sist.di2;

public class Sawon {
    private String dept;
    private String job;
    private String loc;
    private Human human=new Human();
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	public Human getHuman() {
		return human;
	}
	// Human human="h"  ==> ref은 실제 클래스의 주소를 대입
	public void setHuman(Human human) {
		this.human = human;
	}
   
	public void print()
	{
		System.out.println("이름:"+human.getName());
		System.out.println("성별:"+human.getSex());
		System.out.println("부서명:"+dept);
		System.out.println("직위:"+job);
		System.out.println("근무지:"+loc);
		
	}
}
