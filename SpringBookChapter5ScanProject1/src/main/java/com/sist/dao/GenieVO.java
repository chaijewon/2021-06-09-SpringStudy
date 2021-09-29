package com.sist.dao;
/*
 *   1. VO작업 (변수설정)
 *   2. mapper (SQL)
 *   3. DAO작업 
 *   4. MainClass (Model)
 *   5. 스프링에 등록 
 */
/*
 *   NO        NOT NULL NUMBER         
POSTER             VARCHAR2(1000) 
TITLE              VARCHAR2(200)  
SINGER             VARCHAR2(100)  
ALBUM              VARCHAR2(200)  
STATE              CHAR(10)       
IDCREMENT          NUMBER         
KEY                VARCHAR2(100)
    SELECT no,title FROM genie_cjw;
    => no , title
       setNo()  setTitle()
 */
public class GenieVO {
    private int genie_no;
    private String genie_title,genie_singer,genie_album;
	public int getGenie_no() {
		return genie_no;
	}
	public void setGenie_no(int genie_no) {
		this.genie_no = genie_no;
	}
	public String getGenie_title() {
		return genie_title;
	}
	public void setGenie_title(String genie_title) {
		this.genie_title = genie_title;
	}
	public String getGenie_singer() {
		return genie_singer;
	}
	public void setGenie_singer(String genie_singer) {
		this.genie_singer = genie_singer;
	}
	public String getGenie_album() {
		return genie_album;
	}
	public void setGenie_album(String genie_album) {
		this.genie_album = genie_album;
	}
   
}
