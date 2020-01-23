package com.tj.ex1_string;

import java.util.Scanner;

public class Ex03 {
	public static void main(String[] args) {
		// x를 누르면 종료. 나머지 기능은 무한반복
		Scanner sc = new Scanner(System.in);
		String fn;
		do {
			System.out.print("한하는 기능번호는? 1:대출, 2:반납, x:종료 ");
			fn = sc.next();
			if(fn.equals("1")) {
				// 대출
			} else if (fn.equals("2")) {
				//반납
			}
		} while (!fn.equalsIgnoreCase("x"));
		
		System.out.println("프로그램을 종료합니다.");
	}
}
