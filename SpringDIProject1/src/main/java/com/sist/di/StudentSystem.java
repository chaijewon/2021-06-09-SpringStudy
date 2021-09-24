package com.sist.di;
import java.util.*;
// 학생 정보 => XML에서 채워서 스프링으로 전송 => 사용하면 된다 
public class StudentSystem {
   private List<Student> list=new ArrayList<Student>();

	public List<Student> getList() {
		return list;
	}
	
	public void setList(List<Student> list) {
		this.list = list;
	}
   
	public void init()
	{
		System.out.println("====== 학생 정보 =======");
	}
	
	public void print()
	{
		for(Student s:list)
		{
			System.out.println(s.getHakbun()+" "
					+s.getName()+" "
					+s.getSex());
		}
	}
}
