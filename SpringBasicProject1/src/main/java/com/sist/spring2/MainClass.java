package com.sist.spring2;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 인터페이스 => 서로 다른 클래스 묶어서 관리 
        Hello hello=new HelloImpl1();
        hello.sayHello("홍길동");
        
        hello=new HelloImpl2();
        hello.sayHello("심청이");
        
	}

}
