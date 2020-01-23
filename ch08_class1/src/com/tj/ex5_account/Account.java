package com.tj.ex5_account;
//은행계좌 클래스
public class Account {
	private String accountNo;	// 계좌번호
	private String ownerName;	// 예금주
	private int balance;		// 잔액
	
	public Account() {
		System.out.println("계좌개설 감사합니다.");
	}
	
	public Account(String accountNo, String ownerName, int balance) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
		System.out.println(this.ownerName+"님 계좌개설 감사합니다. 입금해주셔서 감사합니다.");
	}
	
	public Account(String accountNo, String ownerName) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		System.out.println(this.ownerName+"님 계좌개설 감사합니다.");
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
	
//	public void getBalance() {
//		System.out.println(ownerName+"님 잔액은 : "+ balance);
//	}
	
	public void deposit(int money) {
		this.balance += money;
		System.out.println("감사합니다. " + ownerName+"님 " + money +"원 예금 후 잔액 : "+ balance);
	}
	
	public int withdraw(int money) {
		
		if (balance >= money) {
			balance -= money;
			System.out.println(ownerName+"님 " + money +"원 인출 후 잔액 : "+ balance);
			return money;
		} else {
			System.out.println("잔액이 부족하여 실패하였습니다.");
			return 0;
		}
		
	}
}
