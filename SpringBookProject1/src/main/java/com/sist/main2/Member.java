package com.sist.main2;
// 스프링 관리 (요청시마다 객체생성=>한개(singleton , 여러개(prototype))
public class Member {
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
    // 출력 
	public void print()
	{
		System.out.println("이름:"+name);
		System.out.println("성별:"+sex);
	}
}
