package com.tj.ex4_object;

public class Customer {
	private String phone;
	private String name;
	private int point;
	private int sum;
	private String birth;	// 01-01
	private boolean vip;	// false : 일반고객, true: 고오급고객
	// Customer c = new Customer("010-9999-9999","홍길동","01-01");
	public Customer(String phone, String name, String birth) {
		this.phone = phone;
		this.name = name;
		this.birth = birth;
		this.point = 1000;
		vip = false;
		sum = 0;
		System.out.println(name+"회원님 가입 감사드립니다. 포인트 1000점 드립니다.");
	}
	
	@Override
	public String toString() {
		// 홍길동(010-9999-9999) 현재 포인트 : 1000원 누적금액 0원
		return name+"("+phone+")"+" 현재 포인트 : "+point+"점 누적금액 : "+sum+"원";
	}
}
