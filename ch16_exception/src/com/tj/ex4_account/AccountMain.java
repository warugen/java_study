package com.tj.ex4_account;

public class AccountMain {
	public static void main(String[] args) {
		Account obj1 = new Account("11-11", "홍길동");
		Account obj2 = new Account("22-22", "고길동", 10000);
		
		obj1.deposit(10000);
		obj2.deposit(10000);
		
		try {
			obj1.withdraw(5000);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			obj2.withdraw(30000);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
