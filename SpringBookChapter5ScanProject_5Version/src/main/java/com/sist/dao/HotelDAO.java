package com.sist.dao;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;
// 메모리 할당 
/*
 *   Component-Scan 
 *   ==============
 *   메모리 할당 대상 (클래스 유형) ==> 137page
 *     = @Component ==> MainClass , ~Manager => 일반 클래스
 *     = @Repository ==> 데이터베이스 (~DAO)
 *     = @Service   ==> DAO+DAO (BoardDAO/ReplyDAO) => BI
 *     = @Controller ==> Model (@Controller) => return ".jsp/.do"
 *                       => 화면변경
 *     = @RestController ==> Model (화면변경(X),JSP로 데이터전송(JSON)
 *        ============== 웹/앱 , React,Ajax,Vue,코틀린
 *     = @ControllerAdvice ==> AOP관련 
 *     = @Configuration ==> 클래스 설정파일
 */
import java.util.*;
@Repository
public class HotelDAO extends SqlSessionDaoSupport{

	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		// TODO Auto-generated method stub
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	// 전체 목록
	public List<HotelVO> hotelListData()
	{
		return getSqlSession().selectList("hotelListData");
	}
	// 상세보기 <select id="hotelDetailData" resultType="HotelVO" parameterType="int">
	// resultType="HotelVO":return , parameterType="int":매개변수
	public HotelVO hotelDetailData(int no)
	{
		return getSqlSession().selectOne("hotelDetailData",no);
	}
   
}
