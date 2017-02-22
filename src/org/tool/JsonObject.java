package org.tool;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonObject {
	public static Object getResult(int code,String message,Object data){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", code);
		map.put("msg", message);
		map.put("data", data);
		return map;
	}
}
