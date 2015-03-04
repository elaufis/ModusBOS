package com.modusbps.bos.utils;

import java.util.HashMap;
import java.util.Map;

public class CallNotifierUtil {
	
	public Map<String, String> parseIncomingCallMessage(String message){
		Map<String, String> parameterMap = new HashMap<String, String>();
		String[] lineArray = message.split("\n");
		
		for(int i = 0; i < lineArray.length; i++){
			String key = lineArray[i].substring(0, lineArray[i].indexOf("="));
			String val = lineArray[i].substring(lineArray[i].indexOf("=") + 1);
			parameterMap.put(key, val);
		}
		
		return parameterMap;
	}

}
