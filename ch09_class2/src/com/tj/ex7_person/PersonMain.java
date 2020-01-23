package com.tj.ex7_person;

public class PersonMain {
	public static void main(String[] args) {
		Person.staticTestMethod();
		
		Person p1 = new Person("홍길동");
		Person p2 = new Person("이길동");
		
		p1.saveMoney(1000);
		p1.saveCompany_moeny(1000);
		p1.currentMoney();
		
		p2.saveMoney(1000);
		p2.saveCompany_moeny(1000);
		p2.currentMoney();
	}
}
