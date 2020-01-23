package com.tj.ex13_academy;

public class Gansa extends Person{
	
	private String subject;
	
	public Gansa(String id, String name, String subject) {
		super(id, name);
		this.subject = subject;
	}
	
	@Override
	public String infoString() {
		return super.infoString() + " (과목): "+subject;
	}
}
