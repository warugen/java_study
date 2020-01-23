package com.tj.ex1_trycatch;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int i =0;
		int j =0;
		do {
			try {
				System.out.print("첫번째 정수 i입력 : ");
				i = sc.nextInt();
				break;
			} catch (Exception e) {
//				e.printStackTrace();
				sc.nextLine();	// 버퍼를 지운다.
				System.out.println("숫자만 입력해주세요");
			}
		} while (true);
		
		
		System.out.println("i= "+i);
		
		System.out.print("두번째 정수 j입력 : ");
		try {
			j = sc.nextInt();							// InputMismatchException
			System.out.println("j= "+j);
			System.out.println("i * j = " + (i * j));
			System.out.println("i / j = " + (i / j));	// AriithmeticException
		} catch (InputMismatchException e) {
			System.out.println("j에 수를 입력하지 않으면 1로 처리합니다.");
			j = 1;
		} catch (Exception e) {	// 부모에러는 캐치 맨 마지막에 한다.
			System.out.println("0으로 나눌수 없습니다.");
		}
				
		System.out.println("i + j = " + (i + j));
		System.out.println("i - j = " + (i - j));
		System.out.println("DONE");
		sc.close();
		
	}
}
