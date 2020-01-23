package com.tj.ex3_homework;

public class Customer {
	private String name;		// 이름
	private String phone;		// 전화번호
	private int point;			// 포인트
	
	public Customer() {}
	
	public Customer(String name, String phone, int point) {
		super();
		this.name = name;
		this.phone = phone;
		this.point = point;
	}
	
	@Override
	public String toString() {
		return name + " (" + phone + ")님 [포인트] " + point + "점\r\n";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
}
