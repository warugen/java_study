package com.tj.homework;

public class CreditLineAccount extends CheckingAccount {
	private int creditLine;

	public CreditLineAccount() {}

	public CreditLineAccount(String accountNo, String ownerName, int balance, String cardNo, int creditLine) {
		super(accountNo, ownerName, balance, cardNo);
		this.creditLine = creditLine;
		
	}

	public CreditLineAccount(String accountNo, String ownerName, String cardNo, int creditLine) {
		super(accountNo, ownerName, cardNo);
		this.creditLine = creditLine;
	}
	
	public int pay(String cardNo, int amount) {
		if(getCardNo().equals(cardNo)) {
			if(creditLine < amount) {
				System.out.println(getOwnerName()+"님 카드한도 "+creditLine+"원 초과하여 사용 불가입니다.");
				return 0;
			} else {
				creditLine -= amount;
				System.out.println(getOwnerName()+"님, "+amount+"원 결재했습니다.(잔여 한도 :" +creditLine+"원)");
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
		System.out.println("카드 한도액 : "+creditLine);
	}

	public int getCreditLine() {
		return creditLine;
	}

	public void setCreditLine(int creditLine) {
		this.creditLine = creditLine;
	}
	
	
}
