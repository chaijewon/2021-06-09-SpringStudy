package com.sist.main;
/*
 *    1. 셋팅 
 *       1) properties => 자바 버전 변경(1.8) , 11
 *          자바 컴파일러  (11) ,
 *          project faects => (11)
 *       2) pom.xml (<properties>)
 *       3) WEB-INF (spring,views를 제거)
 *       4) web.xml => (web-app)를 제외하고 전체 삭제
 *       5) src/main/java => 패키지에서 HomeController삭제
 *    2. 스프링에서 배우는 내용 
 *       ================
 *       1) Container : 클래스 관리 (사용자가 만든 클래스 : 컴포넌트)
 *          ========= 클래스를 관리 (메모리 누수 방지, 결합성을 낮게 만드는 프로그램)
 *          결합성 => 소스를 수정했을때 다른 영향이 없는 프로그램을 제작
 *                       BeanFactory 
 *                          |
 *                      ApplicationContext(클래스를 머아서 관리하는 역할)
 *                          |
 *                    WebApplicationContext
 *       2) DI (의존성 주입) 
 *          = XML을 이용하는 방식
 *          = Annotation을 이용하는 방식 
 *       3) AOP (공통으로 적용되는 소스를 자동으로 호출이 가능)
 *          => getConnection() , disConnection() => 자동호출
 *          => 인터셉터 
 *       4) MVC 웹 
 *          => Model (일반 모델)
 *          => RestController (JSON)
 *       5) 웹관련 기술 (Front-End : VueJS,ReactJS)
 *          WebSocket (실시간 상담) => 크래스도메인(포트가 다를 경우에)
 *          Web Security(보안)
 *       6) 데이터 베이스 : MyBatis 
 *       7) 스케쥴러(원하는 시간마다 지정된 메소드 호출이 가능,데이터베이스 백업)
 *       8) 트랜잭션 , PL/SQL,Index  
 *       =================================== Spring Framework 
 *       
 */
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
