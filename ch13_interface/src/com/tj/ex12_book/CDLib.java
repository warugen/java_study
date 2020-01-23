package com.tj.ex12_book;

import com.tj.ex11_book.ILendabale;

public class CDLib extends CDInfo implements ILendabale {
	
	private String borrower;		// 대출일
	private String checkOutDate;	// 반납일
	private byte state;				// 대출중(1)or대출가능(0)
	
	public CDLib() {}

	public CDLib(String CDNo, String CDTitle, String bookNo) {
		super(CDNo, CDTitle, bookNo);
		this.state = STATE_NORMAL;
	}

	@Override
	public void checkOut(String borrower, String checkOutDate) {
		if(state == STATE_BORROWED) {
			System.out.println(getCdTitle()+"CD는 다른 고객이 대출중입니다.");
			return;
		}
		
		// 대출 가능 상태이므로 대출처리 진행
		this.borrower = borrower;
		this.checkOutDate = checkOutDate;
		state = STATE_BORROWED;
		System.out.println(getCdTitle()+"CD대출 완료되었습니다.");
		System.out.println("대출인 : " + borrower);
		System.out.println("대출일 : " + checkOutDate);

	}

	@Override
	public void checkIn() {
		if(state == STATE_NORMAL) {
			System.out.println("이CD는 대출가능 상태라 나오는데 이상하다 예외다");
			return;
		}
		
		borrower = null;
		checkOutDate = null;
		state = STATE_NORMAL;
		System.out.println(getCdTitle()+"CD가 반납 되었습니다.");

	}

	@Override
	public void printState() {
		if(state == STATE_NORMAL) {
			System.out.println(getBookNo()+"\t \""+getCdNo()+"\"\t "+getCdTitle()+"저 대출가능");
		} else if (state == STATE_BORROWED) {
			System.out.println(getBookNo()+"\t \""+getCdNo()+"\"\t "+getCdTitle()+"저 대출중("+checkOutDate+")");
		} else {
			System.out.println(getBookNo()+"\t \""+getCdNo()+"\"\t 이상하다 예외상황");
		}

	}

	public String getBorrower() {
		return borrower;
	}

	public String getCheckOutDate() {
		return checkOutDate;
	}

	public byte getState() {
		return state;
	}

	
}
