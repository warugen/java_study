package com.tj.ex13_academy;

public class Staff extends Person {
	
	private String department;
	
	public Staff(String id, String name, String department) {
		super(id, name);
		this.department = department;
	}
	
	@Override
	public String infoString() {
		return super.infoString() + " (부서): "+department;
	}

}
