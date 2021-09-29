package com.sist.dao;
import java.util.*;

import org.mybatis.spring.support.SqlSessionDaoSupport;
public class MelonDAO extends SqlSessionDaoSupport{
   public List<MelonVO> melonListData()
   {
	   return getSqlSession().selectList("melonListData");
   }
}
