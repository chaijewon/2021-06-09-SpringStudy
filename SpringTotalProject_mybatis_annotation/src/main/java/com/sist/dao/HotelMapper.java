package com.sist.dao;
import java.util.*; //hotel-mapper.xml 대신 사용하는 파일 

import org.apache.ibatis.annotations.Select;
public interface HotelMapper {
   /*
    *  <select id="hotelListData" resultType="HotelVO">
    *    SELECT no,name,addrss,score 
    *    FROM seoul_hotel
    *  </select>
    *   => @Select
    */
	@Select("SELECT no,name,address,score FROM seoul_hotel")
	public List<HotelVO> hotelListData(); //마이바티스에서 자동 구현 
	  /*
	    *  <select id="hotelDetailData" resultType="HotelVO" 
	    *     parameterType="int">
	    *    SELECT no,name,addrss,score 
	    *    FROM seoul_hotel
	    *    WHERE no=#{no}
	    *  </select>
	    *   => @Select
	    */
	@Select("SELECT no,name,address,score FROM seoul_hotel "
		   +"WHERE no=#{no}")
	//     resultType             parameterType
	public HotelVO hotelDetailData(int no);
}
