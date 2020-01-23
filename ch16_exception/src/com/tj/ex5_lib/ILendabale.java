package com.tj.ex5_lib;

public interface ILendabale {
	public byte STATE_BORROWED = 1;		// 대출중을 의미
	public byte STATE_NORMAL = 0;		// 대출가능 의미
	public void checkOut(String borrower) throws Exception;		// 대출 로직
	public void checkIn() throws Exception;				// 반납
	
}
