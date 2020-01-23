package com.tj.loop;

public class Ex08while {
	public static void main(String[] args) {
		int sum = 0;
		
		for(int i = 1; i < 10; i++ ) {
			sum+=i;
			System.out.printf("i가 %d까지 누적합은 %d이다\n", i, sum);
		}
		
		System.out.println("************************************************");
		
		
		int j = 1;
		int tot = 0;
		while(j < 10) {
			System.out.printf("j가 %d까지 누적합은 %d이다\n", j, tot +=j);
			j++;
		}
	}
}
