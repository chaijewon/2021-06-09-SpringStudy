package com.sist.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // 1. 스프링 컨테이너 => XM을 읽어서 저장 
		// 2. ClassPath : src/main/java
		ApplicationContext app=
				new ClassPathXmlApplicationContext("app.xml");
		// XML을 읽어서 객체 생성 
		/*
		 *   map.put("sa1",Class.forName(""))
		 *   map.put("sa2",Class.forName(""))
		 *   map.put("sa3",Class.forName(""))
		 */
		// app에 있는 클래스 찾기(DL) => dbcp
		Sawon sa1=(Sawon)app.getBean("sa1");
		sa1.setName("홍길동");
		sa1.setDept("개발부");
		sa1.setJob("대리");
		sa1.setLoc("서울");
		sa1.setPay(3500); // XML에서 설정이 가능 => DI
		Sawon sa2=app.getBean("sa2",Sawon.class);// 자동 형변환 
		sa2.setName("심청이");
		sa2.setDept("자재부");
		sa2.setJob("부장");
		sa2.setLoc("부산");
		sa2.setPay(5500);
		Sawon sa3=(Sawon)app.getBean("sa3");
		sa3.setName("박문수");
		sa3.setDept("기획부");
		sa3.setJob("부장");
		sa3.setLoc("부산");
		sa3.setPay(5500);
		
		// 출력 
		Sawon[] sawons={sa1,sa2,sa3};
		for(Sawon s:sawons)
		{
			System.out.println(s.getName()+" "
					+s.getDept()+" "
					+s.getJob()+" "
					+s.getLoc()+" "
					+s.getPay());
		}
		
	}

}
