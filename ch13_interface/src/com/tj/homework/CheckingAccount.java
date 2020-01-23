package com.tj.homework;

public class CheckingAccount extends Account {
	private String cardNo;
	
	public CheckingAccount() {}

	public CheckingAccount(String accountNo, String ownerName, int balance, String cardNo) {
		super(accountNo, ownerName, balance);
		this.cardNo = cardNo;
	}
	
	public CheckingAccount(String accountNo, String ownerName, String cardNo) {
		super(accountNo, ownerName);
		this.cardNo = cardNo;
	}


	public int pay(String cardNo, int amount) {
		if(getCardNo().equals(cardNo)) {
			if (getBalance() < amount) {
				System.out.println(getOwnerName()+"님 잔액이 모자랍니다. 사용 불가입니다.");
				return 0;
			} else {
				setBalance(getBalance()-amount);
				System.out.println(getOwnerName()+"님, "+amount+"원 결재했습니다.(잔여 금액 :" + getBalance()+"원)");
				return amount;
			}
			
		} else {
			System.out.println("카드번호가 일치하지 않습니다.");
			return 0;
		}
	}
	
	

	@Override
	public void printAccount() {
		super.printAccount();
		System.out.println("카드번호 : "+getCardNo());
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	
	
}
