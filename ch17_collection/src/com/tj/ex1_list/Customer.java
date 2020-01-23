package com.tj.ex1_list;

public class Customer {
	private String name;
	private String phone;
	private String addr;
	
	public Customer() {}

	public Customer(String name, String phone, String addr) {
		this.name = name;
		this.phone = phone;
		this.addr = addr;
	}
	
	@Override
	public String toString() {
		return "이름=" + name + ", 전화번호=" + phone + ", 주소=" + addr;
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

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	
}
