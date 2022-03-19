/**
 * 
 */
package com.javabank.main;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.javabank.data.json.JsonBankingRepository;
import com.javabank.gson.GsonSingleton;

import java.util.Map;
import java.util.HashMap;

import java.io.IOException;

/**
 * @author pedro.ferreira
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			JsonBankingRepository repository = new JsonBankingRepository("test");
			repository.initialize();
			
			Map<String, Object> map = repository.getMap();
			
			map.put("data", "Hello, World!");
			//map.put("error", null);
			
			repository.save();
			
			String s = repository.toString();
			System.out.println(s);
		} catch (IOException e) {
			System.out.println("ERRO IOEXCEPTION");
		}
		
		
	}

}
