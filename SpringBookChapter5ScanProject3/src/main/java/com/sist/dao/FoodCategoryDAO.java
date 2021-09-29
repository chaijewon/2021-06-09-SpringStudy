package com.sist.dao;
import java.util.*;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
// 메모리 할당 
@Repository("cdao")
public class FoodCategoryDAO extends SqlSessionDaoSupport{
	// SqlSessionFactory 주입
	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		// TODO Auto-generated method stub
		super.setSqlSessionFactory(sqlSessionFactory);
	}
  
    public List<FoodCategoryVO> categoryListData()
    {
    	return getSqlSession().selectList("categoryListData");
    }
}
