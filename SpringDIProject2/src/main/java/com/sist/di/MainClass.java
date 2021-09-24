package com.sist.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // XML을 이용해서 메뉴얼 => 스프링에 전송 
		// 스프링 => 클래스 메모리 할당(<bean>) , p:name => setXxx() 값을 채운다)
		ApplicationContext app=
				new ClassPathXmlApplicationContext("app2.xml");
		// 필요한 객체를 요청 
		Member m1=(Member)app.getBean("mem1");
		System.out.println("m1:name="+m1.getName());
		System.out.println("m1:sex="+m1.getSex());
		System.out.println("m1:age="+m1.getAge());
		Member m2=(Member)app.getBean("mem2");
		System.out.println("m2:name="+m2.getName());
		System.out.println("m2:sex="+m2.getSex());
		System.out.println("m2:age="+m2.getAge());
		Member m3=(Member)app.getBean("mem3");
		System.out.println("m3:name="+m3.getName());
		System.out.println("m3:sex="+m3.getSex());
		System.out.println("m3:age="+m3.getAge());
	}

}
