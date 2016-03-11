package fastjson;

import java.util.ArrayList;
import java.util.List;

public class FastJsonService {
	
	public static Artical getArtical(){
		Artical artical = new Artical();
		artical.setTitle("中国足协聘请高洪波为中国男子足球队主教练");
		artical.setSummary("中国足协在征求选聘专家组意见和推荐建议后，经慎重研究，决定由高洪波作为2018世界杯预选赛小组赛中国男子足球队主教练");
		artical.setImageUrl("http://192.168.228.135:8080/test/20160204/20160203144316c84a4.jpg");
		artical.setUrl("http://192.168.228.135:8080/test/Detial.html");
		artical.setPostTime("2016-02-03 14:42:39");
		return artical;
	}
	
	public static List<Artical> getArticalList(){
		 List<Artical> list= new ArrayList();
		 for(int i = 0; i < 500; i++){
			 list.add(getArtical());
		 }
		 return list;
	}


}
