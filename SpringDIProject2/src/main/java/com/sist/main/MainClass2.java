package com.sist.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // 1. 스프링에 XML을 등록 (XML:메뉴얼을 전송 => 스프링의 동작을 지정)
		ApplicationContext app=
				new ClassPathXmlApplicationContext("app1.xml");
		// 2. XML : 메타데이터 
		// 3. 자바를 소스를 직접 코딩 => 필요한 데이터를 처리 
		//    ==> 자바 소스가 없기 때문에 (.class) : 소스 코딩 할수가 없다
		//    ==> 필요한 내용은 XML을 이용해서 사용 
		// 프로그램에 필요한 클래스를 찾기 시작 
		Sawon sa1=(Sawon)app.getBean("sa1");
		Sawon sa2=(Sawon)app.getBean("sa1");
		Sawon sa3=(Sawon)app.getBean("sa1");
		System.out.println("sa1:"+sa1);
		System.out.println("sa2:"+sa2);
		System.out.println("sa3:"+sa3); // 주소가 같으면 1개만 사용 
		sa1.setName("홍길동");
		sa2.setDept("개발부");
		sa3.setJob("사원");
		
		System.out.println(sa1.getName());
		System.out.println(sa1.getDept());
		System.out.println(sa1.getJob());
		System.out.println(sa2.getName());
		System.out.println(sa2.getDept());
		System.out.println(sa2.getJob());
		System.out.println(sa3.getName());
		System.out.println(sa3.getDept());
		System.out.println(sa3.getJob());
		
		System.out.println("================");
		Sawon s1=(Sawon)app.getBean("sa");
		Sawon s2=(Sawon)app.getBean("sa");
		Sawon s3=(Sawon)app.getBean("sa");// 메모리가 따로 생성이 된다 
		System.out.println("s1:"+s1);
		System.out.println("s2:"+s2);
		System.out.println("s3:"+s3);
		
		s1.setName("박문수");
		s2.setDept("개발부");
		s3.setJob("부장");
		
		System.out.println(s1.getName());
		System.out.println(s1.getDept());
		System.out.println(s1.getJob());
		
		// 객체 등록 => 메모리 한개사용(singleton) ,
		// 요청시마다 메모리를 따로 생성(prototype)
	}

}
