package com.sist.method;

public class Sawon {
   private String name;
   private String dept;
   private String job;
   // 생성자 매개변수 , setter
   // 생성자  => 변경 할 수 없다 (객체 생성시에만 호출)
   // 초기값을 설정 => Database(URL,username,password) => 고정일 경우 (생성자)
   // setter => 수시로 변경이 가능 
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public Sawon()
	{
		System.out.println("======= 객체 메모리 할당 ======");
	}
    public void init()
    {
    	System.out.println("======= 사원 정보 ======");
    }
    public void destory()
    {
    	System.out.println("======= 객체 메모리 해제 =======");
    }
}
