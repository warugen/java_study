package com.tj.ex5_lib;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BookMain {
	public static void main(String[] args) {
		BookLib[] books = { new BookLib("890-01","this is java","신용권"),
							new BookLib("890-02","dbms","박용권"),
							new BookLib("890-03","html is good","김용권"),
							new BookLib("890-04","css","이용권"),
							new BookLib("890-05","jsp","최용권")
		};
		
		try {
			books[0].checkOut("kim");
			books[0].setCheckOutDate(new Date(new GregorianCalendar(2019, 10, 13).getTimeInMillis()));
		} catch (Exception e1) {
			System.out.println(e1.getMessage());
		}
		
		Scanner sc = new Scanner(System.in);
		String bTitle;
		int idx;	// 배열 저장 인덱스
		String borrower;
		int fn;		// 기능번호
		
		do {
			System.out.print("0.전체 대출상태 열람 1.책대출, 2.책반납, 그외(문자포함):종료 :");
			
			try {
				fn = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("종료합니다.");
				sc.close();
				break;
			}
			
			switch (fn) {
			case 0:		// 전체 대출상태 열람
				for(BookLib b : books) {
					System.out.println(b);
				}
				break;
			case 1:		// 대출처리
				// 1.책이름 입력받는다. 2.책검색 3.책상태확인 4.대출자입력 5.대출일입력 6.대출처리
				System.out.print("대출하고자 하는 책 이름은?");
//				bTitle = sc.next();	// white-space 앞까지의 스트링 받음.
				sc.nextLine();
				bTitle = sc.nextLine();	// 띄어쓰기 공백까지 검색
				for(idx = 0; idx < books.length; idx++) {
					if (bTitle.equals(books[idx].getBookTitle())) {
						break;
					}
				}
				
				if(idx == books.length) {
					System.out.println("해당하는 책을 찿을수 없습니다.");
					break;
				} else {
					if(books[idx].getState() == BookLib.STATE_BORROWED) {
						System.out.println("현재 대출중인 도서입니다.");
					} else {
						System.out.print("이름을 입력하세요. : ");
						borrower = sc.next();
						try {
							books[idx].checkOut(borrower);
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}
					}
				}
				
				break;
			case 2:		// 반납처리
				// 1.책이름 받기 2.책검색 3. 반납처리 
				System.out.print("반납할 책 이름을 입력하세요 : ");
//				bTitle = sc.next();
				sc.nextLine();
				bTitle = sc.nextLine();
				for(idx=0;idx < books.length ; idx++) {
					if(books[idx].getBookTitle().equals(bTitle)) {
						break;
					}
				}
				
				if (idx == books.length) {
					System.out.println("해당하는 책을 찿을수 없습니다.");
					break;
				} else {
						try {
							books[idx].checkIn();
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}
				}
				break;

			default:
				System.out.println("프로그램을 종료합니다.");
				sc.close();
				break;
			}
		} while (fn ==0 || fn == 1 || fn == 2);
	}
}
