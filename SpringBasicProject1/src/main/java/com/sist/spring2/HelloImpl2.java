package com.sist.spring2;
// A프로그래머가 구현
public class HelloImpl2 implements Hello{

	@Override
	public void sayHello(String name) {
		// TODO Auto-generated method stub
		System.out.println(name+"님 환영합니다!!");
	}

}
