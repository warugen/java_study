package com.tj.ex4_account;

public class Account {
	private String AccNo;
	private String ownerName;
	private int balance;
	public Account() {}
	public Account(String accNo, String ownerName) {
		this.AccNo = accNo;
		this.ownerName = ownerName;
		this.balance = 0;
	}
	public Account(String accNo, String ownerName, int balance) {
		this.AccNo = accNo;
		this.ownerName = ownerName;
		this.balance = balance;
	}
	
	// 에금전 계좌정보출력 -> 예금 -> 예금후계좌정보출력
	public void deposit(int amount) {
		System.out.println("예금전 "+this);
		balance += amount;
		System.out.println("예금후 "+this);
	}
	
	public void withdraw(int amount) throws Exception {
		// 잔액과 출금금액비교(예외처리) -> 출금전 계좌정보출력 -> 출금후 계좌정보출력
		if(balance<amount) {
			throw new Exception(amount+"원 출금하기에는 잔액("+balance+")원이 부족합니다.");	
		}
		System.out.println("출금전 " + this);
		balance -= amount;
		System.out.println("출금후 "+this);
	}
	@Override
	public String toString() {
		return "계좌번호 : " + AccNo + "\t 예금주 : " + ownerName + "\t 잔액 : " + balance;
	}
	
	

}

