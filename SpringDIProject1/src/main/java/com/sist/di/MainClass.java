package com.sist.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
// p:name , p:driver-ref=""

// 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
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ApplicationContext app=
        		new ClassPathXmlApplicationContext("app.xml");
        StudentSystem ss=(StudentSystem)app.getBean("ss");
        ss.print();
	}

}
