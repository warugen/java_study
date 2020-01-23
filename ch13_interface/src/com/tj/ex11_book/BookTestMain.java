package com.tj.ex11_book;

public class BookTestMain {
	Book b = new Book("a01","java","홍길동");
	ILendabale il = new ILendabale() {
		
		@Override
		public void printState() {
			System.out.println("test");
		}
		
		@Override
		public void checkOut(String borrower, String checkOutDate) {
			System.out.println("test");
		}
		
		@Override
		public void checkIn() {
			System.out.println("test");
		}
	};
}
