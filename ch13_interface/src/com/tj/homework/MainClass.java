package com.tj.homework;

public class MainClass {
	public static void main(String[] args) {
		Account a1 = new Account("111-1111","홍길동");
		Account a2 = new Account("111-1112", "홍길순", 1000000);
		a1.deposit(500000);
		a1.withdraw(200000);
		a1.printAccount();
		
		System.out.println("============================================================");
		
		CheckingAccount ca1 = new CheckingAccount("111-1111", "김길동", 1000000, "1234-1234-1234-1234");
		ca1.deposit(200000);
		ca1.pay(ca1.getCardNo(), 500000);
		ca1.pay(ca1.getCardNo(), 10000000);
		ca1.printAccount();
		
		System.out.println("============================================================");

		CreditLineAccount cla1 = new CreditLineAccount("123-4567", "박길동", 2000000, "1234-5678-1234-6789", 5000000);
		cla1.withdraw(500000);
		cla1.pay(cla1.getCardNo(), 500000);
		cla1.pay(cla1.getCardNo(), 5000000);
		cla1.printAccount();
	}
}
