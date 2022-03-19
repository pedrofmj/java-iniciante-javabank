/**
 * 
 */
package com.javabank.main;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.javabank.core.account.Account;
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
		
		Account account1 = new Account("john-doe", "John Doe", 100.00);
		Account account2 = new Account("jane-doe", "Jane Doe", 100.00);
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		account1.addStatementEntry("Withdraw", -10.00);
		
	}
	
	/**
	 * @param args
	 */
	public static void main_repo(String[] args) {
		
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
