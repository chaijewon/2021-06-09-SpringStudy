package com.sist.spring;
import java.util.*;
import java.sql.*;
public class MovieDAO {
  private Connection conn;
  private PreparedStatement ps;
  private final String URL="jdbc:oracle:thin:@211.238.142.181:1521:XE";
  public MovieDAO()
  {
	  try
	  {
		  Class.forName("oracle.jdbc.driver.OracleDriver");
	  }catch(Exception ex){}
  }
  public void getConnection()
  {
	  try
	  {
		  conn=DriverManager.getConnection(URL,"hr","happy");
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
  public void init()
  {
	  System.out.println("================= 영화 목록 =================");
  }
  public List<MovieVO> movieListData()
  {
	  List<MovieVO> list=new ArrayList<MovieVO>();
	  try
	  {
		  getConnection();
		  String sql="SELECT mno,title,director,actor,genre "
				    +"FROM project_movie "
				    +"WHERE cno=1";
		  ps=conn.prepareStatement(sql);
		  ResultSet rs=ps.executeQuery();
		  while(rs.next())
		  {
			  MovieVO vo=new MovieVO();
			  vo.setMno(rs.getInt(1));
			  vo.setTitle(rs.getString(2));
			  vo.setDirector(rs.getString(3));
			  vo.setActor(rs.getString(4));
			  vo.setGenre(rs.getString(5));
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
