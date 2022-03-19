package com.javabank.data.json;

import com.google.gson.Gson;
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

public class JsonBankingRepository {

	protected String name = "data";
	protected String filepath = "data/data.json";
	protected Object data = null;
	
	public Map<String, Object> getMap() {
		return (Map<String, Object>) this.data;
	}
	
	public JsonBankingRepository(String name) {
		this.data = new HashMap<String, Object>();
		setName(name);
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
		this.filepath = String.format("data/%s.json", this.name);
	}
	
	public String getFilepath() {
		return this.filepath;
	}
	
	public Gson getGson() {
		return GsonSingleton.getInstance().getGson();
	}
	
	public String toString() {
		return getGson().toJson(this.data);
	}
	
	public void fromString(String s) {
		this.data = getGson().fromJson(s, Object.class);
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
