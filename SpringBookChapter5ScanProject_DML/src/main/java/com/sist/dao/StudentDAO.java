package com.sist.dao;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;
// 메모리 할당 요청 
@Repository
public class StudentDAO extends SqlSessionDaoSupport{

	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		// TODO Auto-generated method stub
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	// 기능 제작 
	// 데이터 추가 
	public void studentInsert(StudentVO vo)
	{
		getSqlSession().insert("studentInsert",vo);//commit
	}
	// 전체 목록
	public List<StudentVO> studentListData()
	{
		return getSqlSession().selectList("studentListData");
	}
	// 상세 보기 
	public StudentVO studentDetailData(int hakbun)
	{
		return getSqlSession().selectOne("studentDetailData", hakbun);
	}
	// 검색 
	public List<StudentVO> studentFindData(String name)
	{
		return getSqlSession().selectList("studentFindData",name);
	}
	// 수정
	public void studentUpdate(StudentVO vo)
	{
		getSqlSession().update("studentUpdate",vo);
	}
	// 삭제
	public void studentDelete(int hakbun)
	{
		getSqlSession().delete("studentDelete",hakbun);
	}
	
   
}
