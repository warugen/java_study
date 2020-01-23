package com.tj.homework;

public class Account {
	private String accountNo;
	private String ownerName;
	private int balance;
	
	public Account() {}
	public Account(String accountNo, String ownerName) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = 0;
		System.out.println(ownerName+"님 계좌 계설되었습니다. 잔금은 "+balance+"원 입니다.");
	}

	public Account(String accountNo, String ownerName, int balance) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
		System.out.println(ownerName+"님 계좌 계설되었습니다. 잔금은 "+balance+"원 입니다.");
	}

	public void deposit(int amount) {
		this.balance += amount;
		System.out.println("감사합니다. " + ownerName+"님 " + amount +"원 예금 후 잔액 : "+ balance);
	}
	
	public int withdraw(int amount) {
		if (balance >= amount) {
			balance -= amount;
			System.out.println(ownerName+"님 " + amount +"원 인출 후 잔액 : "+ balance);
			return amount;
		} else {
			System.out.println("잔액이 부족하여 실패하였습니다.");
			return 0;
		}
	}
	
	public void printAccount() {
		System.out.println("------------------------------------");
		System.out.println("계좌번호 : "+accountNo);
		System.out.println("성    명 : "+ ownerName);
		System.out.println("잔    금 : "+balance);
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	
}
