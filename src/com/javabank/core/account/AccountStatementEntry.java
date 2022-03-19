package com.javabank.core.account;

import java.util.Date;

public class AccountStatementEntry implements Comparable<AccountStatementEntry> {
	
	protected Date date = null;
	protected String description;
	protected double value = 0.00;
	
	public AccountStatementEntry(Date date, String description, double value) {
		setDate(date);
		setDescription(description);
		setValue(value);
	}	  
	
	public AccountStatementEntry(String description, double value) {
		this(new Date(), description, value);
	}
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	@Override
	public int compareTo(AccountStatementEntry o) {
		return getDate().compareTo(o.getDate());
	}
	
}

