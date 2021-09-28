package com.sist.two;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Class[] cls={SawonConfig.class,MemberConfig.class};
        AnnotationConfigApplicationContext app=
        	  new AnnotationConfigApplicationContext(MainConfig.class);
        Sawon s=(Sawon)app.getBean("sa");
        s.print();
        Member m=(Member)app.getBean("mem");
        m.print();
	}

}
