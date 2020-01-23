package com.tj.studentmng;
// (멤버변수)학번,이름 나이 학과 
// (메소드) modify(fn, 바꿀데이터), infoString()
public class Student {
	private int no;
	private String name;
	private int age;
	private String major;
	
	public Student () {}
	// Student s = new Student(2019, "홍길동" , 20, "기계공학");	
	public Student (int no, String name, int age, String major) {
		this.no = no;
		this.name = name;
		this.age = age;
		this.major = major;
	}
	
	public void modify(int fn, String data) {	//s.modify(3,24);
		switch (fn) {
		case 1:
			// 학번수정
			no = Integer.parseInt(data);
			break;
		case 2:
			// 이름수정
			name = data;
			break;
		case 3:
			// 나이수정
			age = Integer.parseInt(data);
			break;
		case 4:
			// 학과수정
			major = data;
			break;
		}
	}
	
	public String infoString() {
		String result = "[학  번] "+no+" [이  름] "+name + " [나  이] " + age + "[학  과]" + major;
		
		return result;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	
}
