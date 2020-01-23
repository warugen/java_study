package com.tj.ex12_book;

import java.util.Scanner;

import com.tj.ex11_book.Book;

public class BookMain2 {
	public static void main(String[] args) {
		BookLib[] books = { new BookLib("890-01","java","신용권"),
							new BookLib("890-02","dbms","박용권"),
							new BookLib("890-03","html","김용권"),
							new BookLib("890-04","css","이용권"),
							new BookLib("890-05","jsp","최용권")
		};
		
		Scanner sc = new Scanner(System.in);
		String bTitle;
		int idx;	// 배열 저장 인덱스
		String borrower, checkOutDate;
		int fn;		// 기능번호
		
		do {
			System.out.print("1.책대출, 2.책반납, 3.책목록, 0:종료 :");
			fn = sc.nextInt();
			switch (fn) {
			case 1:		// 대출처리
				// 1.책이름 입력받는다. 2.책검색 3.책상태확인 4.대출자입력 5.대출일입력 6.대출처리
				System.out.print("대출하고자 하는 책 이름은?");
				bTitle = sc.next();	// white-space 앞까지의 스트링 받음.
				for(idx = 0; idx < books.length; idx++) {
					if (bTitle.equals(books[idx].getBookTitle())) {
						break;
					}
				}
				
				if(idx == books.length) {
					System.out.println("해당하는 책을 찿을수 없습니다.");
					break;
				} else {
					if(books[idx].getState() == Book.STATE_BORROWED) {
						System.out.println("현재 대출중인 도서입니다.");
					} else {
						System.out.print("이름을 입력하세요. : ");
						borrower = sc.next();
						System.out.print("대출일은? : ");
						checkOutDate = sc.next();
						books[idx].checkOut(borrower, checkOutDate);
						
					}
				}
				
				break;
			case 2:		// 반납처리
				// 1.책이름 받기 2.책검색 3. 반납처리 
				System.out.print("반납할 책 이름을 입력하세요 : ");
				bTitle = sc.next();
				for(idx=0;idx < books.length ; idx++) {
//					if(bTitle.equals(books[idx].getBookTitle())) {
					if(books[idx].getBookTitle().equals(bTitle)) {
						break;
					}
				}
				
				if (idx == books.length) {
					System.out.println("해당하는 책을 찿을수 없습니다.");
					break;
				} else {
						books[idx].checkIn();
				}
				
				break;
			case 3:
//				for(BookLib b : books) {
//					b.printState();
//				}
				printList(books);
				break;
			case 0:
				break;
			default:
				System.out.println("번호를 잘못 입력했습니다. 다시 입력해주세요.");
				break;
			}
		} while (fn != 0);
		
		printList(books);
		
		
		System.out.println("안녕히 계세요.");
		sc.close();

	}
	
	public static void printList(BookLib[] books) {
		for(BookLib b : books) {
			b.printState();
		}
	}
}
