package gson;

import com.google.gson.Gson;

public class GsonTools {
	
	public static String createJsonString(Object object){
		Gson gson = new Gson();
		String jsonString = gson.toJson(object);
		return jsonString;
		
	}

}
