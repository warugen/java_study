package com.tj.condition;

import java.util.Random;
import java.util.Scanner;

public class Q5 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("가위는 0 바위는 1 보는 2를 선택하세요 : ");

		int user = scan.nextInt();
		
		// 컴퓨터 난수 생성
//		int com = (int) (Math.random() * 3);
		Random ran = new Random();
		int com = ran.nextInt(3);
		System.out.println(com);
		
		if (user == 0) {
			System.out.println("당신은 가위를 선택하셨습니다.");
		} else if (user == 1) {
			System.out.println("당신은 바위를 선택하셨습니다.");
		} else if (user == 2) {
			System.out.println("당신은 보를 선택하셨습니다.");
		} else {
			System.out.println("잘못 입력하였습니다.");
			user = 3;
		}
		
		if (user != 3) {
			
			if (com == 0) {
				System.out.println("컴퓨터가 가위를 선택하셨습니다.");
			} else if (com == 1) {
				System.out.println("컴퓨터가 바위를 선택하셨습니다.");
			} else {
				System.out.println("컴퓨터가 보를 선택하셨습니다.");
			}
			
			if ((user + 2)%3 == com) {
				// 사람이 이김
				System.out.println("당신이 이겼습니다.");
			} else if ((user + 1)%3 == com) {
				// 컴퓨터가 이김
				System.out.println("당신이 졌습니다.");
			} else {
				// 비김
				System.out.println("비겼습니다.");
			}
			
//			if (user == com) {
//				System.out.println("비겼습니다.");
//			} else if (user == 0 && com ==2) {
//				System.out.println("당신이 이겼습니다.");
//			} else if (user > com) {
//				System.out.println("당신이 이겼습니다.");
//			} else {
//				System.out.println("당신이 졌습니다.");
//			}
		}

		scan.close();
	}
}
