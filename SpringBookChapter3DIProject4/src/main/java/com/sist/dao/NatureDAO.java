package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class NatureDAO {
	private Connection conn;
    private PreparedStatement ps;
    private SeoulDataSource ds;
    // 스프링에서 데이터값을 받는다 
	public void setDs(SeoulDataSource ds) {
		this.ds = ds;
	}
	// dirver 등록 : => 생성자 , setter가 다음에 실행된다 
	public NatureDAO(String driverName)
	{
		try
		{
			Class.forName(driverName);
		}catch(Exception ex){}
	}
	// 같은 기능을 가지고 있는 메소드를 모아서 처리 (공통모듈)
    public void getConnection()
    {
    	try
    	{
    		conn=DriverManager.getConnection(ds.getUrl(),
    				ds.getUsername(),ds.getPassword());
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
    public List<NatureVO> natureFindData(String addr)
    {
    	List<NatureVO> list=new ArrayList<NatureVO>();
    	try
    	{
    		getConnection();
    		String sql="SELECT title,address FROM seoul_location "
    				  +"WHERE address LIKE '%'||?||'%'";
    		ps=conn.prepareStatement(sql);
    		ps.setString(1, addr);
    		ResultSet rs=ps.executeQuery();
    		while(rs.next())
    		{
    			NatureVO vo=new NatureVO();
    			vo.setTitle(rs.getString(1));
    			vo.setAddress(rs.getString(2));
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
