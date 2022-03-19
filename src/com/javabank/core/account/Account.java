package com.javabank.core.account;

import java.io.IOException;
import java.util.Date;

import com.google.gson.annotations.Expose;
import com.javabank.data.json.JsonBankingRepository;

public class Account {

	protected String brand = "0001";
	protected String name = "";
	protected String displayName = "";
	protected double ballance = 0.00;
	protected AccountStatement statement = null;
	
	@Expose(serialize = false, deserialize = false)
	protected JsonBankingRepository repository = null;
	
	public Account(String name, String displayName, double ballance) {
		setName(name);
		setDisplayName(displayName);
		setBallance(ballance);
		this.statement = new AccountStatement();
		if (ballance != 0.00) {
			addStatementEntry("Initial Ballance", ballance);
		}
		try {
			initialize();
		} catch (Throwable t) {
			// NOTHING
			this.repository = null;
		}
	}
	
	public void initialize() throws IOException {
		this.repository = new JsonBankingRepository(String.format("account-%s-%s", this.brand, this.name));
		this.repository.initialize();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public double getBallance() {
		return ballance;
	}
	public void setBallance(double ballance) {
		this.ballance = ballance;
	}
	public AccountStatement getStatement() {
		return this.statement;
	}
	
	public void addStatementEntry(Date date, String description, double value) {
		getStatement().addEntry(date, description, value);
		try {
			if (this.repository != null) {
				this.repository.save();
			}
		} catch (Throwable t) {
			// NOTHING
		}
	}
	
	public void addStatementEntry(String description, double value) {
		getStatement().addEntry(description, value);
		try {
			if (this.repository != null) {
				this.repository.save();
			}
		} catch (Throwable t) {
			// NOTHING
		}
	}
	
}
