package com.javabank.core.account;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;

public class AccountStatement {

	protected List<AccountStatementEntry> entries = null;
	
	public AccountStatement() {
		this.entries = new ArrayList<AccountStatementEntry>();
	}
	
	public void sort() {
		sort(null);
	}
	
	public void sort(Comparator<AccountStatementEntry> comparator) {
		entries.sort(comparator);
	}
	
	public void addEntry(AccountStatementEntry entry) {
		int position = 0;
		for (int i = 0;i < entries.size(); i++) {
			AccountStatementEntry ientry = entries.get(i);
			if (ientry.getDate().compareTo(entry.getDate()) > 0) {
				break;
			}
			position++;
		}
		entries.add(position, entry);
	}
	
	public void addEntry(Date date, String description, double value) {
		AccountStatementEntry entry = new AccountStatementEntry(date, description, value);
		addEntry(entry);
	}
	
	public void addEntry(String description, double value) {
		AccountStatementEntry entry = new AccountStatementEntry(description, value);
		addEntry(entry);
	}
	
}
