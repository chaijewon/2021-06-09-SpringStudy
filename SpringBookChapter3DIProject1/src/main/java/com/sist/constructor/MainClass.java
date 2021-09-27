package com.sist.constructor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// classpath => ~/src/main/java
        ApplicationContext app=
        	new ClassPathXmlApplicationContext("app2.xml");
        Sawon s=(Sawon)app.getBean("sa");
        s.print();
	}

}
