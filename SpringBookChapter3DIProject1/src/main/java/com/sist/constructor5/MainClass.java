package com.sist.constructor5;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
// setXxx(값을 설정) => setter DI
// Sawon(값을 설정) => constructor DI
// 지역변수에는 값을 설정 할 수 없다 , 멤버변수 값을 설정 할때 사용 
/*
 *   54page 
 *   ======
 *   의존 (스프링을 통해서 => 변수값,객체주소값을 주입)  => 변화 초기화 
 *   55page => 컨테이너가 하는 역할 
 *             ==============
 *              객체 생성 => 필요한 데이터 설정  : 필요시마다 프로그램에서 사용이 가능 
 *              => 주입 (메뉴얼) => 프로그램을 구동하기 위해서 메뉴얼을 만들어서 스프링에 넘겨준다
 *                 ==========
 *                 1. 어노테이션 
 *                 2. XML
 *                 3. 등록된 클래스의 관계도를 만든다 (스프링에서 셋팅) => IoC
 *                    Ioc ==> DI로 통합 (주입,관계도)
 */
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        AnnotationConfigApplicationContext app=
        		new AnnotationConfigApplicationContext(SawonConfig.class);
        Sawon s=(Sawon)app.getBean("sa");
        s.print();
	}

}
