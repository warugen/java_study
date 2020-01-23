package com.tj.ex7_person;

public class Person {
	private String name;
	private int money;
	private static int company_money;
	public Person(String name) {
		this.name = name;
	}
	
	public void currentMoney() {
		System.out.print(name+"님 개인 자산 : "+money+"\t");
		System.out.println(name + "님 회사 공금 : "+company_money);
	}
	
	public void saveMoney(int money) {
		this.money = money;
	}
	
	public void saveCompany_moeny(int money) {
		company_money += money;
	}
	
	public static void staticTestMethod() {
		System.out.println("static Method Test");
	}
}
