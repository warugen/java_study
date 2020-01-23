package com.tj.ex5_lib;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class BookLib implements ILendabale {
	
	private String bookNo;			// 책번호
	private String bookTitle;		// 책제목
	private String writer;			// 저자
	private String borrower;		// 대출인
	private Date checkOutDate;	// 반납일
	private byte state;				// 대출중(1)or대출가능(0)
	
	public BookLib() {}

	public BookLib(String bookNo, String bookTitle, String writer) {
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.writer = writer;
		this.state = STATE_NORMAL;
	}

	@Override
	public void checkOut(String borrower) throws Exception{
		if(state == STATE_BORROWED) {
			throw new Exception(getBookTitle()+"도서는 다른 고객이 대출중입니다.");
		}
		
		// 대출 가능 상태이므로 대출처리 진행
		this.borrower = borrower;
		this.checkOutDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년MM월dd일");
		state = STATE_BORROWED;
		System.out.println(getBookTitle()+"책 대출 완료되었습니다.");
		System.out.println("대출인 : " + borrower);
		System.out.println("대출일 : " + sdf.format(checkOutDate));

	}

	@Override
	public void checkIn() throws Exception {
		if(state == STATE_NORMAL) {
			throw new Exception("이책은 대출가능 상태라 나오는데 이상하다 예외다");
		}
		
		Date today = new Date();
		long diff = today.getTime() - checkOutDate.getTime();
		long day = diff / (24*60*60*1000);
		if (day > 14) {	// 연체료처리 
			System.out.println("연체료발생(하루당100원) "+((day-14)*100)+"원 연체료");
			Scanner sc = new Scanner(System.in);
			System.out.print("연체료를 받으셨나요?(Y/N:반납중단)");
			String answer = sc.next();
			if (answer.equalsIgnoreCase("n")) {
				System.out.println("반납중단되었습니다.");
				return;
			}
		}
		borrower = null;
		checkOutDate = null;
		state = STATE_NORMAL;
		System.out.println(getBookTitle()+"도서가 반납 되었습니다.");

	}


	@Override
	public String toString() {
		String tmp;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년MM월dd일");
		if(state == STATE_NORMAL) {
			tmp = getBookNo()+"\t \""+getBookTitle()+"\"\t "+getWriter()+"저 대출가능";
		} else if (state == STATE_BORROWED) {
			tmp = getBookNo()+"\t \""+getBookTitle()+"\"\t "+getWriter()+"저 대출중("+sdf.format(checkOutDate)+")\t 대출자 : "+getBorrower();
		} else {
			tmp = getBookNo()+"\t \""+getBookTitle()+"\"\t 이상하다 예외상황";
		}
		return tmp;
	}

	public String getBorrower() {
		return borrower;
	}

	public String getCheckOutDate() {
		return "";
	}

	public byte getState() {
		return state;
	}

	public String getBookNo() {
		return bookNo;
	}
	
	public String getBookTitle() {
		return bookTitle;
	}
	
	public String getWriter() {
		return writer;
	}

	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
	
}
