package com.sist.dao;
import java.util.*;
import java.sql.*;
public class EmpDAO {
   private Connection conn;
   private PreparedStatement ps;
   private final String URL="jdbc:oracle:thin:@211.238.142.181:1521:XE";
   public EmpDAO()
   {
	   try
	   {
		   Class.forName("oracle.jdbc.driver.OracleDriver");
		   System.out.println("메모리 할당 완료");
	   }catch(Exception ex)
	   {
		   System.out.println(ex.getMessage());
	   }
   }
   public void getConnection()
   {
	   try
	   {
		   conn=DriverManager.getConnection(URL,"hr","happy");
	   }catch(Exception ex){ex.printStackTrace();}
   }
   public void disConnection()
   {
	   try
	   {
		   if(ps!=null) ps.close();
		   if(conn!=null) conn.close();
	   }catch(Exception ex){}
   }
   // 소스가 변경된 것이 아니라 => 클래스를 모아서 관리하는 역할을 수행 (클래스 등록=>XML)
   // 1. 등록 클래스를 찾는다 (DL)
   // 2. 멤버변수의 값을 등록 (DI) = 주입
   /*
    *   스프링에서 관리하는 자바클래스 
    *   ======================
    *   1. ~VO , MainClass (등록대상이아니다) => JSP
    *   2. ~DAO , ~Manager , ~Service ..(등록) : 기능을 가지고 있을때 등록
    *        => 여러개의 클래스에서 사용이 될때 
    */
   public List<EmpVO> empListData()
   {
	   List<EmpVO> list=new ArrayList<EmpVO>();
	   try
	   {
		   getConnection();
		   String sql="SELECT empno,ename,job FROM emp";
		   ps=conn.prepareStatement(sql);
		   ResultSet rs=ps.executeQuery();
		   while(rs.next())
		   {
			   EmpVO vo=new EmpVO();
			   vo.setEmpno(rs.getInt(1));
			   vo.setEname(rs.getString(2));
			   vo.setJob(rs.getString(3));
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
