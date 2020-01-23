package com.tj.ex7_homework;

public class Customer {
	String name;		// 이름
	String phone;		// 전화번호
	String birth;		// 생일
	String address;		// 주소
	
	public Customer() {}
	public Customer(String name, String phone, String birth, String address) {
		this.name = name;
		this.phone = phone;
		this.birth = birth;
		this.address = address;
	}

	@Override
	public String toString() {
		return name + " " + phone + " " + birth + "생 " + address +"\r\n";
	}
	
	
}
