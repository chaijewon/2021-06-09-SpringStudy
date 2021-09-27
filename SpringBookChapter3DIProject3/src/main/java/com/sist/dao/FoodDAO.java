package com.sist.dao;
import java.util.*;
import java.sql.*;
public class FoodDAO {
  private Connection conn;
  private PreparedStatement ps;
  /*
   *   c:driverName="oracle.jdbc.driver.OracleDriver"
       p:url="jdbc:oracle:thin:@211.238.142.181:1521:XE"
       p:username="hr"
       p:password="happy"
   */
  private String url,username,password; // setter DI
  
    public void setUrl(String url) {
	    this.url = url;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

// ConstructorDI
  public FoodDAO(String driverName)
  {
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
  
  // 목록 
  public List<FoodVO> foodListData()
  {
	  List<FoodVO> list=new ArrayList<FoodVO>();
	  try
	  {
		  getConnection();
		  String sql="SELECT name,address,tel FROM project_food_house "
				    +"ORDER BY no ASC";
		  ps=conn.prepareStatement(sql);
		  ResultSet rs=ps.executeQuery();
		  while(rs.next())
		  {
			  FoodVO vo=new FoodVO();
			  vo.setName(rs.getString(1));
			  vo.setAddress(rs.getString(2));
			  vo.setTel(rs.getString(3));
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







