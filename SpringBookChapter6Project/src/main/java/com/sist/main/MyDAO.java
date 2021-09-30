package com.sist.main;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class MyDAO implements InitializingBean,DisposableBean{
    private String name,address;
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
		System.out.println("setName() Call...");
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
		System.out.println("setAddress() Call...");
	}
	
	public MyDAO() {
		// TODO Auto-generated constructor stub
		System.out.println("스프링에 의해 객체 생성!!");
	}
	public void display()
	{
		System.out.println("프로그래머가 호출하는 메소드!!");
	}
	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("객체가 소멸한다!!");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("DI(set메소드) 호출후 값을 주입!!");
	}

}
