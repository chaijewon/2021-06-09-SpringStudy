package com.sist.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.sql.ResultSet;
import java.util.*;
/*
 *   public List<HotelVO> hotelFindData(String addr)
    {
    	List<HotelVO> list=new ArrayList<HotelVO>();
    	try
    	{
    		getConnection();
    		String sql="SELECT name,score FROM seoul_hotel "
    				  +"WHERE address LIKE '%'||?||'%'";
    		ps=conn.prepareStatement(sql);
    		ps.setString(1, addr);
    		ResultSet rs=ps.executeQuery();
    		while(rs.next())
    		{
    			HotelVO vo=new HotelVO();
    			vo.setName(rs.getString(1));
    			vo.setScore(rs.getDouble(2));
    			list.add(vo);
    		}
    		rs.close();
    	}catch(Exception ex)
    	{
    		ex.printStackTrace();
    	}
    	finally
    	{
    		disConnection();
    	}
    	return list;
    }
 */
public class HotelDAO extends SqlSessionDaoSupport{
   public List<HotelVO> hotelListData()
   {
	   return getSqlSession().selectList("hotelListData");
	   // SQL문장 (id), VO설정(resultType), ?값을 설정 (paramterType)
   }
   public HotelVO hotelDetailData(int no)
   {
	   return getSqlSession().selectOne("hotelDetailData",no);
   }
   public List<HotelVO> hotelFindData(String name)
   {
	   return getSqlSession().selectList("hotelFindData",name);
   }
   public List<HotelVO> hotelPageingData(int page)
   {
	   int rowSize=10;
	   int start=(rowSize*page)-(rowSize-1);
	   int end=rowSize*page;
	   
	   Map map=new HashMap();
	   // #{start}
	   map.put("start", start);
	   map.put("end", end);
	   
	   return getSqlSession().selectList("hotelPageingData",map);
   }
   public int hotelTotalPage()
   {
	   return getSqlSession().selectOne("hotelTotalPage");
   }
}
