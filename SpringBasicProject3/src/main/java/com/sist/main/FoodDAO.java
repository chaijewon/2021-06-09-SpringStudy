package com.sist.main;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import java.util.*;
public class FoodDAO extends SqlSessionDaoSupport{
   public List<FoodVO> foodListData()
   {
	   return getSqlSession().selectList("foodListData");
   }
   public FoodVO foodDetailData(int no)
   {
	   return getSqlSession().selectOne("foodDetailData", no);
	   //                                             #{no}
   }
}
