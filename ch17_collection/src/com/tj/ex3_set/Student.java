package com.tj.ex3_set;

public class Student {
	private String name;
	private int grade;
	
	public Student(String name, int grade) {
		this.name = name;
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "name=" + name + ", grade=" + grade;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj != null) {
			String objStr = obj.toString();
			String thisStr = toString();	// 홍길동:1
			return thisStr.equals(objStr);
		} else {
			return false;
		}
	}
	
	@Override
	public int hashCode() {	// hashcode값이 서로 같다고 속임수
		return toString().hashCode();
	}
}
