package com.sist.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // XML에 등록된 클래스 => 스프링에 전송 
		ApplicationContext app=
			new ClassPathXmlApplicationContext("app.xml");
		Student s=(Student)app.getBean("std");
		s.print();
	}

}
