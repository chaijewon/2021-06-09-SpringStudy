package com.sist.dao;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
/*
 *   <bean id="gdao" class="com.sist.dao.GenieDAO"
      p:sqlSessionFactory-ref="ssf"
    />
 */
import java.util.*;
/*
 *   component-scan 
 *   =============== 패키지를 지정하면 (모든 클래스를 메모리 할당)
 *   메모리 할당을 하는 클래스를 지정하는 어노테이션을 사용
 *    ===================== 클래스별로 구분(종류)
 *    = @Component : 일반 클래스 (MainClass , Jsoup )
 *    = @Repository : DAO(데이터베이스 연결)
 *    = @Controller : Model(파일명 전송)
 *    = @RestController : Model(JSON,일반전송)
 *    = @Service : BI
 *    
 *    
 */
@Repository("fdao")
public class FoodCategoryDAO extends SqlSessionDaoSupport{
    // p:sqlSessionFactory-ref="ssf"
	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		// TODO Auto-generated method stub
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	//
	public List<FoodCategoryVO> categoryListData()
	{
		return getSqlSession().selectList("categoryListData");
	}
   
}
