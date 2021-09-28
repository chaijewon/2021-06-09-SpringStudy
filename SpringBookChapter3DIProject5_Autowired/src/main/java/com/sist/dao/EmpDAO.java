package com.sist.dao;
import java.util.*;
import java.sql.*;
// 스프링 => XML을 읽기 
/*
 *   1. 메모리 할당 (생성자 호출 => 생성자 DI)
 *   2. setXxx() => 메소드 호출 
 *      생성 
 *      => 사용 빈도가 별로 없다 
 *      => 필요한 메소드 호출 (1개만) : init-method
 *   ================================ 필요한 값을 채운 클래스 객체 저장
 *   프로그래머가 스프링에 요청 => 필요한 클래스 얻어서 사용 
 *                         =================== getBean() : DL
 *   =========================================================
 *   3. 객체 메모리 해제 : 소멸 
 *      => 사용 빈도가 별로 없다 
 *      => 필요한 메소드 호출 (1개만) : destory-method
 */
public class EmpDAO {
   private Connection conn;
   private PreparedStatement ps;
   private String url,username,password; //setter DI
   
    public void setUrl(String url) {
	this.url = url;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public EmpDAO(String driverName)
   {
	   // 생성자 DI
	   try
	   {
		   Class.forName(driverName);
	   }catch(Exception ex){}
   }
   public void getConnection()
   {
	   try
	   {
		   conn=DriverManager.getConnection(url,username,password);
	   }catch(Exception ex){}
   }
   public void disConnection()
   {
	   try
	   {
		   if(ps!=null) ps.close();
		   if(conn!=null) conn.close();
	   }catch(Exception ex){}
   }
   public List<EmpVO> empListData()
   {
	   List<EmpVO> list=new ArrayList<EmpVO>();
	   try
	   {
		   getConnection();
		   String sql="SELECT empno,ename,job,hiredate,dname,loc "
				     +"FROM emp,dept "
				     +"WHERE emp.deptno=dept.deptno";//EQUI_JOIN(INNER JOIN)
		   ps=conn.prepareStatement(sql);
		   ResultSet rs=ps.executeQuery();
		   while(rs.next())
		   {
			   EmpVO vo=new EmpVO();
			   vo.setEmpno(rs.getInt(1));
			   vo.setEname(rs.getString(2));
			   vo.setJob(rs.getString(3));
			   vo.setHiredate(rs.getDate(4));
			   vo.getDvo().setDname(rs.getString(5));
			   vo.getDvo().setLoc(rs.getString(6));
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
}







