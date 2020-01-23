package com.tj.ex12_book;

public interface ILendabale {
	public byte STATE_BORROWED = 1;		// 대출중을 의미
	public byte STATE_NORMAL = 0;		// 대출가능 의미
	public void checkOut(String borrower, String checkOutDate);		// 대출 로직
	public void checkIn();				// 반납
	public void printState();			// 도서정보와 상태를 출력
	
}
