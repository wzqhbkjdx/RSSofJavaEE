package rss;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

public class RSSReader {
	
	public static List<RSSItem> getRSS(String string) {
		
		List<RSSItem> mRSSItems = new ArrayList<>();
		
		try {
			URL url = new URL(string);

			HttpURLConnection conn;
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();

			InputStream in = conn.getInputStream();
			
			
			SAXParserFactory factory = SAXParserFactory.newInstance();  
			
			SAXParser parser = factory.newSAXParser();  
			
			XMLReader xmlReader = parser.getXMLReader();
			
			RSSHandler mRSSHandler = new RSSHandler(mRSSItems);
			xmlReader.setContentHandler(mRSSHandler); 
			
			xmlReader.parse(new InputSource(in)); 
			
//			for(RSSItem item : mRSSItems) {
//				System.out.println(item.getTitle());
//				System.out.println(item.getLink());
//				System.out.println(item.getPubdate());
//				System.out.println(item.getDescription());
//			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mRSSItems;
		
	}
	

}
