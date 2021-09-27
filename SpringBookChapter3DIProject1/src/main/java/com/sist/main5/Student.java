package com.sist.main5;
/*
 *    DI : 의존성 주입 (스프링을 통해서 클래스가 가지고 있는 변수에 값을 주입하는 과정)
 *         멤버변수 값을 처리 
 *          
 *           = setter (setXxx()를 이용해서 값을 주입)
 *           = 생성자 매개변수 이용 
 *           = 메소드를 자동호출 (객체생성시(init-method) , 
 *              개체소멸시(destory-method))
 *              
 *           1) setter/생성자 ==> 데이터베이스 정보 전송 
 *                              JSP의 경로명 지정 
 *           2) 메소드 : 드라이버 등록 , 데이터베이스 연결 해제 (한번만 수행이 가능)
 *                     => 트위터 읽어오기 (실시간) => 실시간 분석 
 *                     => 자동 로그인 처리 
 */
public class Student {
    private int hakbun;
    private String name;
    private String subject;
	public int getHakbun() {
		return hakbun;
	}
	public void setHakbun(int hakbun) {
		this.hakbun = hakbun;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	// 출력 
	public void print()
	{
		System.out.println("학번:"+hakbun);
		System.out.println("이름:"+name);
		System.out.println("과:"+subject);
	}
	   
}
