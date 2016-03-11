package json;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fastjson.FastJsonTools;
import rss.RSSItem;
import rss.RSSReader;


@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String RSS = "http://blog.sina.com.cn/rss/1267454277.xml";//新浪
	private static final String RSS2 = "http://www.prnasia.com/story/industry/AIR-1.atom";//霍尼韦尔
	private static final String RSS3 = "http://sse.tongji.edu.cn/SSEMainRSS.aspx";//同济大学

    public TestServlet() {
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");  
        request.setCharacterEncoding("utf-8");  
        response.setCharacterEncoding("utf-8");  
        PrintWriter writer = response.getWriter();
		List<RSSItem> list = RSSReader.getRSS(RSS3);
		
		for(RSSItem item : list){
//			System.out.println(item.getTitle());
//			System.out.println(item.getLink());
//			System.out.println(item.getPubdate());
//			System.out.println(item.getDescription());
			System.out.println(item.toString());
			writer.println(item.getTitle());
			writer.println(item.getLink());
			writer.println(item.getPubdate());
			writer.println(item.getDescription());
			
			String result = FastJsonTools.createJsonString(item);
			System.out.println(result);
			
		}
		
//		String artical = GsonTools.createJsonString(FastJsonService.getArtical());  
//        writer.println(artical);  
//        System.out.println(artical);  

		writer.flush();
		writer.close();
		
		
		
        
//		out.print(feed);
		
//		
//		out.flush();  
//      out.close(); 
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
