package com.tj.ex4;

public class Student {
	private String hakbun;
	private String name;
	private String major;
	private int score;
	public Student() {}
	public Student(String hakbun, String name, String major, int score) {
		super();
		this.hakbun = hakbun;
		this.name = name;
		this.major = major;
		this.score = score;
	}
	@Override
	public String toString() {
		return "[학번]" + hakbun + ", [이름] " + name + ", [전공과목] " + major + ", [점수]" + score + "\r\n";
	}
	
	public String getHakbun() {
		return hakbun;
	}
	public void setHakbun(String hakbun) {
		this.hakbun = hakbun;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public double getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	
}
