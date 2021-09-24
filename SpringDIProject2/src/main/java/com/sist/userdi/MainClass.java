package com.sist.userdi;

import com.sist.di.Member;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String path="C:\\springDev2\\springStudy\\SpringDIProject2\\src\\main\\java\\com\\sist\\userdi\\app.xml";
	    ApplicationContext app=
	    		new ClassPathXmlApplicationContext(path);
	    Student s=(Student)app.getBean("std");
	    System.out.println(s.getHakbun());
	    System.out.println(s.getName());
	    System.out.println(s.getSex());
	}

}
