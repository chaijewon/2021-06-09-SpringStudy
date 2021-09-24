package com.sist.recipe;
/*
 *  <div class="list_lump">
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
 */
public class ChefVO {
    private String name;
    private String poster;
    private String mem_count1;
    private String mem_count3;
    private String mem_count7;
    private String mem_count2;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public String getMem_count1() {
		return mem_count1;
	}
	public void setMem_count1(String mem_count1) {
		this.mem_count1 = mem_count1;
	}
	public String getMem_count3() {
		return mem_count3;
	}
	public void setMem_count3(String mem_count3) {
		this.mem_count3 = mem_count3;
	}
	public String getMem_count7() {
		return mem_count7;
	}
	public void setMem_count7(String mem_count7) {
		this.mem_count7 = mem_count7;
	}
	public String getMem_count2() {
		return mem_count2;
	}
	public void setMem_count2(String mem_count2) {
		this.mem_count2 = mem_count2;
	}
    
}
