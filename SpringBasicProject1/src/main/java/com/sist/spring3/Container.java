package com.sist.spring3;
// 클래스를 모아서 관리 ==> 팩토리 패턴 (클래스를 생성관리하는 공장)
// => 프로그래머가 만든 클래스를 관리 => 싱글턴
import java.util.*;
public class Container {
   private Map map=new HashMap();
   public Container()
   {
	   map.put("a", new A());
	   map.put("b", new B());
	   map.put("c", new C());
   }
   // 찾기 ==> 스프링 (DL,DI) => 기본적으로 클래스 찾기기능 
   public I getBean(String key)
   {
	   return (I)map.get(key);
   }
}
