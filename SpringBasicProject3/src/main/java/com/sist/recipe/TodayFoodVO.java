package com.sist.recipe;
/*
 * <div class="media">
            <div class="media-left">
                <a href="/bbs/1947">
                    <img class="media-object" src="http://recipe1.ezmember.co.kr/cache/bbs/2016/08/2973ca7f6c2ec772715a75b45f8f4bfe39_s.jpg" data-holder-rendered="true" style="width: 200px; height: 130px;">
                </a>
            </div>
            <div class="media-body media-middle">
                <h4 class="media-heading" id="media-heading"><a href="/bbs/1947">ȯ���� ���⿹��, �񰨱⿡ ���� ����</a></h4>
                <p class="info_writer">�����Ƿ�����<span>|</span>2016-08-29 ���� 11:39<span>|</span><span class="cate_view">4,928</span><span>|</span><span class="cate_comment">0</span></p>
            </div>
        </div>
 */
public class TodayFoodVO {
  private String title;
  private String poster;
  private String chef;
  private String regdate;
  private String view;
  private String comment;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public String getChef() {
		return chef;
	}
	public void setChef(String chef) {
		this.chef = chef;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getView() {
		return view;
	}
	public void setView(String view) {
		this.view = view;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
  
}
