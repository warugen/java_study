package com.tj.loop;

public class Ex09while {
	public static void main(String[] args) {
		int i = 1;
		int sum = 0;
		while(i<=100) {
			if(i%3==0) {
				sum += i;
			}
			i++;
		}
		
		System.out.printf("1~100까지 숫자중 3의 배수의 합 : %d\n", sum);
		
		System.out.println("*******************************************");
		sum = 0;
		for (int j = 0; j <= 100; j++) {
			if(j%3==0) {
				sum += j;
			}
		}
		
		System.out.printf("1~100까지 숫자중 3의 배수의 합 : %d\n", sum);
	}
}
