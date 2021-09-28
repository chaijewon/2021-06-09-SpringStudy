package com.sist.test;
/*
 *     ====> 클래스 관리 (생성 / 소멸)
 *     1. 클래스 메모리 할당 
 *     2. setter DI 
 *     3. method DI
 *     ==============================
 *     4. 사용자 필요한 위치에서 메소드 호출 
 *     ============================== 프로그래머가 담당 
 *     5. 스프링에서 객체 소멸 
 */
class A
{
	private String name;
	public A()
	{
		System.out.println("A클래스 메모리 할당");
	}
	public void setName(String name)
	{
		this.name=name;
	}
	public String getName()
	{
		return name;
	}
}
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         try
         {
        	 Class clsName=Class.forName("com.sist.test.A");
        	 Object obj=clsName.getDeclaredConstructor().newInstance();
        	 // 생성자 함수가 가장 먼저 호출 
         }catch(Exception ex){}
	}

}
