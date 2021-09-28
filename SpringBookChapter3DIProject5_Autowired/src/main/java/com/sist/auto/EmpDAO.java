package com.sist.auto;

public class EmpDAO implements DAO{

	@Override
	public void getConnection() {
		// TODO Auto-generated method stub
		System.out.println("EmpDAO에서 오라클 연결");
	}

	@Override
	public void disConnection() {
		// TODO Auto-generated method stub
		System.out.println("EmpDAO에서 오라클 연결 해제");
	}

}
