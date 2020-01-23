package com.tj.ex13_academy;

public class Student extends Person {
	private String ban;
	
	public Student(String id, String name, String ban) {
		super(id, name);
		this.ban = ban;
	}
	
	@Override
	public String infoString() {
		return super.infoString() + " (반): "+ban;
	}
	
}
