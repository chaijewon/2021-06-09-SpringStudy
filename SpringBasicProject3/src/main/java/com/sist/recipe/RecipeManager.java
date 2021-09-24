package com.sist.recipe;

import java.util.StringTokenizer;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/*
 * <div class="list_lump">
            <div class="list_ranking2">
                <p class="list_ranking2_num txt4">1391</p>
                <p class="list_ranking2_num2"><span style="color:#fff;" class="glyphicon "></span></p>
            </div>
            <div class="list_mem3">
                <a href="/profile/index.html?uid=seohyun1208" class="mem_pic"><img src="http://recipe1.ezmember.co.kr/img/df/pf_100_100.png"></a>
            </div>
            <div class="list_cont4"><b>
                <a href="/profile/index.html?uid=seohyun1208" id="folFriend_seohyun1208" class="info_name_f">
                    �ϵ����                </a>
                    <button type="button" class="btn btn-default btn-sm" id="btnActFriend_seohyun1208" fact="insert" onclick="doActFriend('seohyun1208')">
                        <span class="glyphicon glyphicon-plus"></span>�ҽĹޱ�                    </button>
                </b>
                <span class="mem_cont1">0</span><span class="mem_cont3">0</span><span class="mem_cont7">0</span><span class="mem_cont2">2</span>
            </div>
        </div>
        
        <div class="media">
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
public class RecipeManager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RecipeManager r=new RecipeManager();
		//r.chefData();
		r.todayFoodData();

	}
	public void chefData()
	{
		try
		{
			/*
			 *  private String name;
			    private String poster;
			    private String mem_count1;
			    private String mem_count3;
			    private String mem_count7;
			    private String mem_count2;
			    
			    
			 */
			for(int i=1;i<10;i++)
			{
			   Document doc=Jsoup.connect("http://www.10000recipe.com/chef/chef_list.html?order=chef_no_follower&term=all&page="+i).get();
			   Elements name=doc.select("div.list_cont4 a.info_name_f");
			   Elements poster=doc.select("div.list_mem3 a.mem_pic img");
			   Elements mem_count1=doc.select("div.list_cont4 span.mem_cont1");
			   Elements mem_count3=doc.select("div.list_cont4 span.mem_cont3");
			   Elements mem_count7=doc.select("div.list_cont4 span.mem_cont7");
			   Elements mem_count2=doc.select("div.list_cont4 span.mem_cont2");
			   
			   for(int j=0;j<name.size();j++)
			   {
				   String n=name.get(j).text();
				   String p=poster.get(j).attr("src");
				   String mc1=mem_count1.get(j).text();
				   String mc3=mem_count3.get(j).text();
				   String mc7=mem_count7.get(j).text();
				   String mc2=mem_count2.get(j).text();
				   
				   System.out.println(n+" "+p+" "+mc1+" "+mc3+" "+mc7+" "+mc2);
				   
				   ChefVO vo=new ChefVO();
				   vo.setName(n);
				   vo.setPoster(p);
				   vo.setMem_count1(mc1);
				   vo.setMem_count2(mc2);
				   vo.setMem_count3(mc3);
				   vo.setMem_count7(mc7);
			   }
			}
		}catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}
	
	public void todayFoodData()
	{
		/*
		 *   private String title;
			  private String poster;
			  private String chef;
			  private String regdate;
			  private String view;
			  private String comment;
			  
			  <div class="media">
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
		try
		{
			for(int i=1;i<10;i++)
			{
			   Document doc=Jsoup.connect("http://www.10000recipe.com/bbs/list.html?bid=1&page="+i).get();
			   Elements poster=doc.select("div.media-left img.media-object");
			   Elements title=doc.select("div.media-body h4.media-heading a");
			   Elements temp=doc.select("div.media-body p.info_writer");
			   
			   
			   for(int j=0;j<title.size();j++)
			   {
				   String t=title.get(j).text();
				   String p=poster.get(j).attr("src");
				   String te=temp.get(j).text();
				  
				   System.out.println(t);
				   System.out.println(p);
				   System.out.println(te);
				   StringTokenizer st=new StringTokenizer(te, "|");
				   String chef=st.nextToken();
				   String regdate=st.nextToken();
				   String view=st.nextToken();
				   String comment=st.nextToken();
				   System.out.println("=====================");
				   
				   TodayFoodVO vo=new TodayFoodVO();
				   vo.setTitle(t);
				   vo.setPoster(p);
				   vo.setChef(chef);
				   vo.setRegdate(regdate);
				   vo.setView(view);
				   vo.setComment(comment);
				   
			   }
			}
		}catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}

}







