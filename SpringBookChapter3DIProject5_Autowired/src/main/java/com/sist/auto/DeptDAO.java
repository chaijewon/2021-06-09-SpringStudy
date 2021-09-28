package com.sist.auto;

public class DeptDAO implements DAO{

	@Override
	public void getConnection() {
		// TODO Auto-generated method stub
		System.out.println("DeptDAO에서 오라클 연결");
	}

	@Override
	public void disConnection() {
		// TODO Auto-generated method stub
		System.out.println("DeptDAO에서 오라클 연결 해제");
	}

}

