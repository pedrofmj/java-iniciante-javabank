package com.javabank.data.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

import com.javabank.core.account.Account;
import com.javabank.gson.GsonSingleton;

import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

import java.util.Map;
import java.util.HashMap;

public class JsonBankingRepository<T> {

	protected String name = "data";
	protected String filepath = "data/data.json";
	protected T data = null;
	protected Type type = null;
	
//	public Map<String, Object> getMap() {
//		return (Map<String, Object>) this.data;
//	}
	
	public static boolean exists(String name) {
		String filepath = String.format("data/%s.json", name);
		File file = new File(filepath);
		if (file.exists()) {
			return true;
		} else {
			return false;
		}
	}
	
	public JsonBankingRepository(String name, Type type) {
		this(name, null, type);
		setType(type);
		try {
			load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public JsonBankingRepository(String name, T data, Type type) {
		setType(type);
		this.data = data; //new HashMap<String, Object>();
		setName(name);
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
		this.filepath = String.format("data/%s.json", this.name);
	}
	
	public Type getType() {
		return this.type;
	}
	
	public void setType(Type type) {
		this.type = type;
	}
	
	public String getFilepath() {
		return this.filepath;
	}
	
	public T getData() {
		return this.data;
	}
	
	public void setData(T data) {
		this.data = data;
	}
	
	public Gson getGson() {
		return GsonSingleton.getInstance().getGson();
	}
	
	public String toString() {
		return getGson().toJson(this.data);
	}
	
	public void fromString(String s) {
		//Type type = new TypeToken<T>() {}.getType();
		this.data = (T) getGson().fromJson(s, this.type);
	}
	
	public void save() throws IOException {
		mkdirs();
		BufferedWriter writer = new BufferedWriter(new FileWriter(getFilepath()));
		writer.write(toString());
		writer.close();
	}
	
	public void mkdirs() {
		File file = new File("data");
		file.mkdirs();
	}
	
	public void load() throws IOException {
		mkdirs();
		File file = new File(getFilepath());
		if (!file.exists()) {
			save();
		} else {
			BufferedReader reader = new BufferedReader(new FileReader(getFilepath()));
			StringWriter sw = new StringWriter();
			String line = null;
			while ((line = reader.readLine()) != null) {
				sw.write(String.format("%s\n", line));
			}
			String s = sw.toString();
			fromString(s);
		}
	}
	
	public void initialize() throws IOException {
		load();
	}
	
}
