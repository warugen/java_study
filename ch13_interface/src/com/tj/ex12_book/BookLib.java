package com.tj.ex12_book;

import com.tj.ex11_book.ILendabale;

public class BookLib extends BookInfo implements ILendabale {
	
	private String borrower;		// 대출일
	private String checkOutDate;	// 반납일
	private byte state;				// 대출중(1)or대출가능(0)
	
	public BookLib() {}

	public BookLib(String bookNo, String bookTitle, String writer) {
		super(bookNo, bookTitle, writer);
		this.state = STATE_NORMAL;
	}

	@Override
	public void checkOut(String borrower, String checkOutDate) {
		if(state == STATE_BORROWED) {
			System.out.println(getBookTitle()+"도서는 다른 고객이 대출중입니다.");
			return;
		}
		
		// 대출 가능 상태이므로 대출처리 진행
		this.borrower = borrower;
		this.checkOutDate = checkOutDate;
		state = STATE_BORROWED;
		System.out.println(getBookTitle()+"대출 완료되었습니다.");
		System.out.println("대출인 : " + borrower);
		System.out.println("대출일 : " + checkOutDate);

	}

	@Override
	public void checkIn() {
		if(state == STATE_NORMAL) {
			System.out.println("이책은 대출가능 상태라 나오는데 이상하다 예외다");
			return;
		}
		
		borrower = null;
		checkOutDate = null;
		state = STATE_NORMAL;
		System.out.println(getBookTitle()+"도서가 반납 되었습니다.");

	}

	@Override
	public void printState() {
		if(state == STATE_NORMAL) {
			System.out.println(getBookNo()+"\t \""+getBookTitle()+"\"\t "+getWriter()+"저 대출가능");
		} else if (state == STATE_BORROWED) {
			System.out.println(getBookNo()+"\t \""+getBookTitle()+"\"\t "+getWriter()+"저 대출중("+checkOutDate+")");
		} else {
			System.out.println(getBookNo()+"\t \""+getBookTitle()+"\"\t 이상하다 예외상황");
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
