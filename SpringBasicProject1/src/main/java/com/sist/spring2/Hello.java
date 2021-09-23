package com.sist.spring2;
// 구조 (설계) => 인터페이스는 고정 => 추가/수정,삭제(어렵다)
public interface Hello {
   default public void sayHello(String name){}
   // 1.8 => 구현된 메소드가 가능하게 만든다 (수정,삭제,추가)
}
