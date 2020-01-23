package com.tj.loop;

import java.util.Scanner;

// 예제5 : 컴퓨터와 가위바위보 게임을 당신이 질 때까지 무한반복하는 게임을 작성하시오.
// (단, 가위대신 0, 바위대신 1, 보대신 2)
public class Homework5 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		do {
			// 컴퓨터 난수 생성
			int rand = (int) (Math.random() * 3);
			
			System.out.print("가위는 0 바위는 1 보는 2를 선택하세요 : ");

			int user = scan.nextInt();

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

				if (rand == 0) {
					System.out.println("컴퓨터가 가위를 선택하셨습니다.");
				} else if (rand == 1) {
					System.out.println("컴퓨터가 바위를 선택하셨습니다.");
				} else {
					System.out.println("컴퓨터가 보를 선택하셨습니다.");
				}

				if ((user + 2) % 3 == rand) {
					// 사람이 이김
					System.out.println("당신이 이겼습니다.");
				} else if ((user + 1) % 3 == rand) {
					// 컴퓨터가 이김
					System.out.println("당신이 졌습니다. 프로그램을 종료합니다.");
					break;
				} else {
					// 비김
					System.out.println("비겼습니다.");
				}
			}
		} while (true);

		scan.close();

	}
}
