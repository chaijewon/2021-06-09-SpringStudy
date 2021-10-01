package com.sist.dao;
/*
 *    스프링 : 최대한 간결한 프로그램 제작 (수정) : 클래스 관리자 (클래스 객체)
 *    객체를 저장할때 => 객체가 가지고 있는 멤버변수의 초기화 
 *    EmpDAO dao=(EmpDAO)app.getBean("dao"); // 수동 
 *    
 *    @Autowired  ==> Target
 *    EmpDAO dao
 *    
 *    @Autowired => 사용하는 위치  (스프링에 자동으로 주소값 주입을 요청)
 *    public class MainClass
 *    {
 *         @Autowired  ===> 멤버변수  FIELD (일반 변수는 사용이 불가능)
 *         private EmpDAO dao;            ================== 
 *                                        클래스 객체만 주입이 가능 
 *                                        
 *         @Autowired
 *         String name; (X)
 *         ==> 스프링에 저장되는 내용 (클래스 객체주소와 key) 
 *         
 *         @Autowired  ===> 생성자 
 *         public MainClass(EmpDAO dao) CONSTRUCTOR
 *         {
 *         }
 *         
 *         @Autowired  ===> 일반 메소드  METHOD
 *         public void init(EmpDAO dao)
 *         {
 *         }
 *         
 *         @Autowired ===> setter
 *         public void setEmpDAO(EmpDAO dao)
 *         {
 *         }
 *         
 *    }
 *    
 *    @Autowired   : 자동주입 
 *    => 특정객체를 지정 (key를 주고 객체주소를 얻어 온다)
 *       ===========
 *       @Qualifier("key") => 단독으로 사용할 수 없고 
 *                            반드시 @Autowired 있는 경우에만 사용이 가능 
 *    @Autowired
 *    @Qualifier("key")
 *    클래스명 객체명
 *    
 *    ==> @Resource(name="key") : @Autowired+@Qualifier("key")
 */

import java.util.*;
public class EmpVO {
    private int empno,sal;
    private String ename,job;
    private Date hiredate;
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
    
}








