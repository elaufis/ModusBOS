package com.modusbps.bos.utils;

import java.util.HashMap;
import java.util.Map;

public class CallNotifierUtil {
	private String message;
	
	public CallNotifierUtil(String message){
		this.message = message;
	}
	
	public String getMSISDNFromMessage(){
		Map<String, String> parsedMsg = parseIncomingCallMessage();
		
		String msgData = parsedMsg.get("data");
		return msgData.substring(0, 10);
	}
	
	public Map<String, String> parseIncomingCallMessage(){
		Map<String, String> parameterMap = new HashMap<String, String>();
		String[] lineArray = this.message.split("\n");
		
		for(int i = 0; i < lineArray.length; i++){
			String key = lineArray[i].substring(0, lineArray[i].indexOf("="));
			String val = lineArray[i].substring(lineArray[i].indexOf("=") + 1);
			parameterMap.put(key, val);
		}
		
		return parameterMap;
	}

}
