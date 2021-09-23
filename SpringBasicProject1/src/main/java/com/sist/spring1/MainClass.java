package com.sist.spring1;
// 유저 사용 => 실행 (클라이언트에서)
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Hello hello=new Hello();
        //hello.sayHello("홍길동");
        // 가급적이면 => new를 사용하지 않는다 
        // new를 사용하는 곳은  VO를 호출(클래스가 아니라  데이터형)
        // VO => 읽기/쓰기 => 데이터형 클래스 (스프링이 관리하는 클래스)
        // 기능을 가지고 있는 클래스를 관리 (Model,DAO, Manager,Service)
	}

}
