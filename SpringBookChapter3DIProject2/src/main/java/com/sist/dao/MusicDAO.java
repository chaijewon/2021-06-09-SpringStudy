package com.sist.dao;
import java.sql.*;
import java.util.*;
public class MusicDAO {
    private Connection conn;
    private PreparedStatement ps;
    private String url,username,password; // DI
    // setter DI
    public void setUrl(String url) {
	this.url = url;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	// 생성자 DI
    public MusicDAO(String driverName)
   {
	   try
	   {
		   Class.forName(driverName);
	   }catch(Exception ex){}
   }
    // 연결
    public void getConnection()
    {
    	try
    	{
    		conn=DriverManager.getConnection(url,username,password);
    	}catch(Exception ex){}
    }
    // 해제
    public void disConnection()
    {
    	try
    	{
    		if(ps!=null) ps.close();
    		if(conn!=null) conn.close();
    	}catch(Exception ex){}
    }
    // 목록 읽기
    public List<MusicVO> musicListData()
    {
    	List<MusicVO> list=new ArrayList<MusicVO>();
    	try
    	{
    		getConnection();
    		String sql="SELECT no,title,singer,album "
    				  +"FROM genie_cjw ORDER BY no ASC";
    		ps=conn.prepareStatement(sql);
    		ResultSet rs=ps.executeQuery();
    		while(rs.next())
    		{
    			MusicVO vo=new MusicVO();
    			vo.setNo(rs.getInt(1));
    			vo.setTitle(rs.getString(2));
    			vo.setSinger(rs.getString(3));
    			vo.setAlbum(rs.getString(4));
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
