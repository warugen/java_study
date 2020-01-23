package com.tj.ex7_person;

public class PersonInfo {
	private String name;
	private int age;
	private char gender;
	
	public PersonInfo() {}
	
	public PersonInfo(String name, int age, char gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	
	public void print() {
		System.out.println("이름 = "+name+"\t나이 = "+age+"\t성별 = "+gender);
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setGender(char gender) {
		this.gender = gender;
	}
	
	
}
