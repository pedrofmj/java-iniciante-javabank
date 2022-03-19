package com.javabank.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder; 

public final class GsonSingleton {

	private static GsonSingleton instance = null;
	
	private Gson gson = null;
	
	public GsonSingleton() {
		this.gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();
	}
	
	public Gson getGson() {
		return this.gson;
	}
	
	public void setGson(Gson gson) {
		this.gson = gson;
	}
	
	public static GsonSingleton getInstance() {
		if (instance == null) {
			instance = new GsonSingleton();
		}
		return instance;
	}
	
}
