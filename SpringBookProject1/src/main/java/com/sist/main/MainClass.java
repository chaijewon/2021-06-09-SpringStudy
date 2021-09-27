package com.sist.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 *    사용자가 실행 프로그램 : (스프링에서는 조립기)
 *    => Application : main()
 *    => Web : DispatcherServlet,Model
 *            ===================
 *              main()=>service()
 *              
 *    1. 스프링 
 *       1) 셋팅 (라이브러리 첨부:pom.xml) => 버전 호환
 *          5버전 => JDK 1.8이상 
 *       2) 실행 과정 
 *          => XML,Java => 컨테이너 (클래스를 관리하는 영역)
 *             컨테이너의 종류 
 *             ===========
 *               BeanFactory : core/di
 *                             ==== ==
 *                             core:클래스 객체 생성 
 *                             di : 객체의 필요한 데이터 첨부 
 *                    |
 *              ApplicationContext : core/di/aop
 *                             aop: 공통 모듈 (CallBack함수)
 *                             => OOP의 단점 보안 
 *                                ===
 *                                 => 자동호출을 할 수 없다 
 *                                 => 반복적인 기능 (메소드,클래스)
 *                     |
 *               ============================================
 *               |                         |                |
 *           GenericApplicationConext   AnnotationConfigApplicationContext
 *               (닫기)   => 4버전                    => 5버전
 *           WebApplicationContext(MVC)
 *           
 *       3) XML사용법 ,Java사용 , Annotation
 *       4) DI / AOP
 *       5) DataBase 
 *       6) MVC (웹)
 *       ================================ XML/Annotation
 *       
 *       chapter 1 : 설치 (자바,편집기,메이븐)
 *                   메이븐 (라이브러리 관리(POM.XML) , 배포관리,프로젝트 관리)
 *                   ===== 이클립스에서 주로 사용 
 *                   그레들 (인텔리제이) => 코틀린 (편집기:안드로이드)
 *                   ==> 라이브러리 (mvnrepository.com)
 *       ==========================================================
 *       chapter 2 : 스프링 시작
 *                  ==========
 *                  1) pom.xml
 *                  2) 객체 컨테이너 (스프링:클래스관리자) => 웹전용이 아니다 
 *                      스프링사용 => 복잡한 클래스(게임,웹)
 *                      => 기본 (스프링에서 메모리 할당 : 싱글턴)
 *                      => 한개의 메모리 생성해서 => 재사용이 가능하게 만든다 
 *       chapter 3 : DI (주입)
 *                   => 멤버변수값 초기화 setterDI
 *                   => 생성자메개변수로 초기화 생성자 DI
 *                   => 메소드 DI 
 *                      = 객체생성과 동시에 호출 : init-method
 *                      = 객체 소멸시 호출 : destory-method
 *                   => 객체를 생성하면 => 프로그램에서 사용 (getBean():DL)
 *       chapter 4 : 자동주입 (@Autowired)
 *       chapter 5 : 컴포넌트 스캔 (패키지별로 클래스 메모리 할당)
 *                   <component-scan base-package="패키지명">
 *       chapter 6 : 생명 주기 (객체 생성 => 객체 사용 => 객체 소멸)  
 *       chapter 7 : AOP (공통모듈)
 *       chapter 8 : DB연동 (jdbc(외부에서 사용이 없다) => ORM(Mybatis))
 *                   Mybatis (XML,Annotation) => INDEX,PL/SQL
 *      ======================= 1~8장까지 내용이 그대로 적용 =================
 *       chapter 9 : MVC(구조) => 웹
 *                   M(Model) => @Controller , @RequestMapping
 *                               => 메소드 (리턴형:String,request,response)
 *                   V (JSP : EL/JSTL)
 *                   C (서블릿 : DisaptcherServlet)
 *                   => 기타 (매개변수 , Model사용법)
 *       9~14 
 *       chapter 16 : JSON (VueJS,ReactJS)
 *                    =====
 *                     웹 , 앱 (코틀린에서 사용이 가능)
 *       chapter 17 : 프로파일 / 프로필 
 *       ============================================================
 *                   
 *        18page : 스프링 소개 
 *                 클래스관리하기 위해서 : 컨테이너를 가지고 있다 
 *                 ==================================
 *                   사용자가 만드는 모든 클래스가 독립적으로 만들어진다 
 *                                        ===== (POJO)
 *                   => 수정시에 다른 클래스의 영향을 미치지 않는다 
 *                      (결합성을 낮게 만드는 프로그램)
 *                   => 유지보수가 편하다 (분산처리 => 협업)
 *                 => DI / AOP / MVC / ORM(스프링의 기초)
 *         => JDK 설치 / 이클립스 설치 / Maven (POM.XML)
 *        
 *         30page  (maven : 라이브러리 설치 => pom.xml (mvnrepository.com))
 *         === 36page (properties태그부터 변경)
 *         Spring구조 
 *           spring-core
 *           spring-beans
 *           spring-aop
 *           aop
 *                                 
 */
// 컨테이너 등록 (1.XML,2.자바)
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // 스프링에서 제공하는 컨테이너를 이용해서 사용자 정의/라이브러리 클래스 저장이 가능)
		ApplicationContext app=
			new ClassPathXmlApplicationContext("app.xml");
		// 컨테이너를 통해서 등록된 클래스를 이용한다 
		// 스프링 => 클래스가 제작되기 전에 만들어져 있다 
		// scope="prototype" => 메모리 공간 따라 생성 
		Sawon sa1=(Sawon)app.getBean("sa");
		// getBean => 리턴형 (Object)   Object>Sawon
		// int a=3.4; (X) 
		// int a=(int)3.4
		sa1.setName("홍길동");
		sa1.setSex("남자");
		sa1.print();
		
		Sawon sa2=(Sawon)app.getBean("sa");//반드시 형변환 한다 
		//        ======= 클래스 형변환
		sa2.setName("심청이");
		sa2.setSex("여자");
		sa2.print();
		
		System.out.println("=================");
		sa1.print();
		// 싱글턴 => sa1 == sa2 (메모리 공간이 한개)
		
	}

}
