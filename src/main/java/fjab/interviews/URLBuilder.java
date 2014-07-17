package fjab.interviews;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class URLBuilder {

	public static void main(String[] args) {
		
		Map<String,String> urlParts = new LinkedHashMap<>();
		urlParts.put("protocol", "http");
		urlParts.put("domain", "myDomain");
		urlParts.put("port", "80");
		urlParts.put("path", "myPath");
		urlParts.put("parameter1", "myParameter1");
		urlParts.put("parameter2", "myParameter2");
		urlParts.put("parameter3", "myParameter3");
		
		StringBuffer sb = new StringBuffer();
		for(Map.Entry<String, String> part : urlParts.entrySet()){
			
			if(part.getKey().contains("parameter")){
				sb.append(part.getKey()).append("=");
			}
			sb.append(part.getValue());
			
			if(part.getKey().equals("protocol")){
				sb.append("://");
			}
			else if(part.getKey().equals("domain")){
				sb.append(":");
			}
			else if(part.getKey().equals("port")){
				sb.append("/");
			}
			else if(part.getKey().equals("path")){
				sb.append("?");
			}
			else if(part.getKey().contains("parameter")){
				sb.append("&");
			}
		}
		System.out.println("url===>"+sb);

	}

}
