package com.sist.dao;
import java.util.*;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
// 메모리 할당 
@Repository
public class EmpJoinDAO extends SqlSessionDaoSupport{

	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		// TODO Auto-generated method stub
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	// 데이터베이스 관련 
	public List<EmpVO> empdeptJoinData()
	{
		return getSqlSession().selectList("empdeptJoinData");
		// Mybatis => 제네릭스 사용 (자동형변환)
	}
	public EmpVO empdeptDetailData(int empno)
	{
		return getSqlSession().selectOne("empdeptDetailData",empno);
	}
  
}
