package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
public interface EmpDAO {
  @Select("SELECT empno,ename,job,hiredate,sal FROM emp")
  public List<EmpVO> empListData();// 자동 구현 완료 
  @Select("SELECT empno,ename,job,hiredate,sal FROM emp WHERE empno=?")
  public EmpVO empDetailData(int empno);
  
}
