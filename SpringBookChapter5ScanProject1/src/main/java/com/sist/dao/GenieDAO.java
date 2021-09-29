package com.sist.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import java.util.*;
public class GenieDAO extends SqlSessionDaoSupport{
   /*
    *   while(rs.next()) ==> selectList ==> multirow
    *   {
    *   }
    *   
    *   vo.setXxx() ==> selectOne => 1row
    */
   public List<GenieVO> genieListData()
   {
	   return getSqlSession().selectList("genieListData");
   }
   public List<GenieVO> genieListData2()
   {
	   return getSqlSession().selectList("genieListData2");
   }
}
