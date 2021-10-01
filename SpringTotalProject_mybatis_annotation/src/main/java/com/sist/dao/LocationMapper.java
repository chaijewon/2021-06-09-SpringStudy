package com.sist.dao;
/*
 *  private int no;
    private String title,msg,address;
 */
import java.util.*;

import org.apache.ibatis.annotations.Select;
public interface LocationMapper {
  @Select("SELECT no,title,msg,address FROM seoul_location")
  public List<LocationVO> locationListData();
  @Select("SELECT no,title,msg,address FROM seoul_location "
		 +"WHERE no=#{no}")
  public LocationVO locationDetailData(int no);
}
