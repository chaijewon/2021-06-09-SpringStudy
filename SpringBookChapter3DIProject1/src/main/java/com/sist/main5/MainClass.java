package com.sist.main5;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        AnnotationConfigApplicationContext app=
        		new AnnotationConfigApplicationContext(StudentConfig.class);
	    Student s=(Student)app.getBean("std");
	    s.print();
	}

}
