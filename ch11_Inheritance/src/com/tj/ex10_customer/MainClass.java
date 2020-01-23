package com.tj.ex10_customer;

import com.tj.cons.Constant;

public class MainClass {
	public static void main(String[] args) {
		Customer customer = new Customer("홍길동", "9999-9999", "서울시 종로구", "12-04");
		customer.buy(10000);
		
		Staff staff = new Staff("김일꾼", "909-1234", "08-08", "전산실");
		
		Person[] person = {staff,customer};
		
		for(Person p : person) {
			System.out.println(p.infoString());
		}
		
		Person customer1 = new Customer("홍길순", "9876-4544", "서울시 성북구", "11-04");
		customer1.infoString();
		
		if(customer1 instanceof Customer) {
			((Customer)customer1).buy(100000);	// Customer로 강제형변환하면 가능
		}
	}
}
