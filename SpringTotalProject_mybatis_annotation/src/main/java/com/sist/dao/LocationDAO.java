package com.sist.dao;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class LocationDAO {
   @Autowired
   private LocationMapper mapper;
   public List<LocationVO> locationListData()
   {
	   return mapper.locationListData();
   }
   public LocationVO locationDetailData(int no)
   {
	   return mapper.locationDetailData(no);
   }
}
