package com.javabank.core.account;

import java.util.Date;

public class Account {

	protected String name = "";
	protected String displayName = "";
	protected double ballance = 0.00;
	protected AccountStatement statement = null;
	
	public Account(String name, String displayName, double ballance) {
		setName(name);
		setDisplayName(displayName);
		setBallance(ballance);
		this.statement = new AccountStatement();
		if (ballance != 0.00) {
			addStatementEntry("Initial Ballance", ballance);
		}
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
	}
	
	public void addStatementEntry(String description, double value) {
		getStatement().addEntry(description, value);
	}
	
}
