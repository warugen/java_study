package com.tj.ex12_book;

public class CDInfo {
	private String cdNo;			// CD번호
	private String cdTitle;			// CD제목
	private String bookNo;			// 책번호
	
	
	public CDInfo() {}


	public CDInfo(String cdNo, String cdTitle, String bookNo) {
		this.cdNo = cdNo;
		this.cdTitle = cdTitle;
		this.bookNo = bookNo;
	}


	public String getCdNo() {
		return cdNo;
	}


	public void setCdNo(String cdNo) {
		this.cdNo = cdNo;
	}


	public String getCdTitle() {
		return cdTitle;
	}


	public void setCdTitle(String cdTitle) {
		this.cdTitle = cdTitle;
	}


	public String getBookNo() {
		return bookNo;
	}


	public void setBookNo(String bookNo) {
		this.bookNo = bookNo;
	}
	
		
}
