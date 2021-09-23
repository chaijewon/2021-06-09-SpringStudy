package com.sist.dao;
import java.util.*;
// 스프링에 등록하지 않는다 (일반 데이터형으로 취급) 
public class EmpVO {
    private int empno;
    private String ename;
    private String job;
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
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
  
}
