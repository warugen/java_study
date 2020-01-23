package com.tj.ex11_book;

public class Book implements ILendabale {
	private String bookNo;			// 책번호
	private String bookTitle;		// 책제목
	private String writer;			// 저자
	private String borrower;		// 대출일
	private String checkOutDate;	// 반납일
	private byte state;				// 대출중(1)or대출가능(0)
	
	// Book b = new Book("450-01가","java","신용권");
	public Book() {}
	public Book(String bookNo, String bookTitle, String writer) {
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.writer = writer;
		this.state = STATE_NORMAL;
	}

	@Override
	// b.checkOut("홍길동",12-06")
	public void checkOut(String borrower, String checkOutDate) {
		if(state == STATE_BORROWED) {
			System.out.println(bookTitle+"도서는 다른 고객이 대출중입니다.");
			return;
		}
		
		// 대출 가능 상태이므로 대출처리 진행
		this.borrower = borrower;
		this.checkOutDate = checkOutDate;
		state = STATE_BORROWED;
		System.out.println(bookTitle+"대출 완료되었습니다.");
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
		System.out.println(bookTitle+"도서가 반납 되었습니다.");
		
	}

	@Override
	public void printState() {
		if(state == STATE_NORMAL) {
			System.out.println(bookNo+"\t \""+bookTitle+"\"\t "+writer+"저 대출가능");
		} else if (state == STATE_BORROWED) {
			System.out.println(bookNo+"\t \""+bookTitle+"\"\t "+writer+"저 대출중("+checkOutDate+")");
		} else {
			System.out.println(bookNo+"\t \""+bookTitle+"\"\t 이상하다 예외상황");
		}
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
