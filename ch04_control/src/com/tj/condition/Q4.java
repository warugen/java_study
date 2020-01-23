package com.tj.condition;

import java.util.Scanner;

public class Q4 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("가위는 0 바위는 1 보는 2를 선택하세요 : ");
		
		int num = scan.nextInt();
		
		if (num == 0) {
			System.out.println("가위를 선택하셨습니다.");
		} else if (num == 1) {
			System.out.println("바위를 선택하셨습니다.");
		} else if (num == 2) {
			System.out.println("보를 선택하셨습니다.");
		} else {
			System.out.println("잘못 입력하였습니다.");
		}
		
		scan.close();
	}
}
