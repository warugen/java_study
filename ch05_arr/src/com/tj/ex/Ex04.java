package com.tj.ex;

import java.util.Scanner;

public class Ex04 {
	public static void main(String[] args) {
		//영희, 철수, 길동, 영수, 말자
		String[] name = {"영희","철수","길동","영수","말자"};
		int[] height = new int[name.length];
		
		int totHeight = 0;	// 총 키의 합
		int min = 9999;		// 최소키
		int max = 0;		// 최대키
		int minIdx = -1, maxIdx = -1;
		
		Scanner scan = new Scanner(System.in);
		for (int i = 0; i < name.length; i++) {
			System.out.print(name[i]+"의 키를 입력하세요 :");
			height[i] = scan.nextInt();
			totHeight += height[i];			// 키 누적
		}
		
		for (int i = 0; i < name.length; i++) {
			if (height[i] < min) {			// 최소키 구하기
				min = height[i];
				minIdx = i;
			} 
			if (height[i] > max) {	// 최대키 구하기
				max = height[i];
				maxIdx = i;
			}
		}
		
		System.out.printf("최단신 키는 %s이고 %d 입니다.\n",name[minIdx], height[minIdx]);
		System.out.printf("최장신 키는 %s이고 %d 입니다.\n",name[maxIdx], height[maxIdx]);
		System.out.printf("평균키 : %.2f\n", (double)totHeight / name.length);
		
		scan.close();
	}
}
