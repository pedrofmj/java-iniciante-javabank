/**
 * 
 */
package com.javabank.main;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.javabank.gson.GsonSingleton;

import java.util.Map;
import java.util.HashMap;

/**
 * @author pedro.ferreira
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Gson gson = GsonSingleton.getInstance().getGson();
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("data", "Hello, World!");
		//map.put("error", null);
		
		String s = gson.toJson(map);
		
		System.out.println(s);
		
	}

}
