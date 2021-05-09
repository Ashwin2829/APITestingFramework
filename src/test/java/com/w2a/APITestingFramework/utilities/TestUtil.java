package com.w2a.APITestingFramework.utilities;

import static org.testng.Assert.assertTrue;

import org.json.JSONObject;

import com.w2a.APITestingFramework.listeners.ExtentListeners;

public class TestUtil {
	
	public static boolean jsonHasKey(String json,String key) {
		
		JSONObject jsonobject = new JSONObject(json);
		ExtentListeners.testReport.get().info("Validating the presence of key "+key);
		return jsonobject.has(key);
	}
	
	public static String getJsonKeyValue(String json,String key) {
		
		JSONObject jsonobject = new JSONObject(json);
		ExtentListeners.testReport.get().info("Validating the value of key"+key);
		return jsonobject.get(key).toString();
		
	}

}
