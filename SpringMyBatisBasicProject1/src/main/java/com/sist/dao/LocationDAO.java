package com.sist.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class LocationDAO extends SqlSessionDaoSupport{
	   public List<LocationVO> locationListData()
	   {
		   return getSqlSession().selectList("locationListData");
		   // SQL문장 (id), VO설정(resultType), ?값을 설정 (paramterType)
	   }
	   public LocationVO locationDetailData(int no)
	   {
		   return getSqlSession().selectOne("locationDetailData",no);
	   }
	   public List<LocationVO> locationFindData(String title)
	   {
		   return getSqlSession().selectList("locationFindData",title);
	   }
	   public List<LocationVO> locationPageingData(int page)
	   {
		   int rowSize=10;
		   int start=(rowSize*page)-(rowSize-1);
		   int end=rowSize*page;
		   
		   Map map=new HashMap();
		   // #{start}
		   map.put("start", start);
		   map.put("end", end);
		   
		   return getSqlSession().selectList("locationPageingData",map);
	   }
	   public int locationTotalPage()
	   {
		   return getSqlSession().selectOne("locationTotalPage");
	   }
	}