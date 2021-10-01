package com.sist.dao;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
// 스프링에서 매모리 할당 
@Repository
public class HotelDAO {
	@Autowired
	private HotelMapper mapper;
	
	public List<HotelVO> hotelListData()
	{
		return mapper.hotelListData();
	}
	
	public HotelVO hotelDetailData(int no)
	{
		return mapper.hotelDetailData(no);
	}
	
}
