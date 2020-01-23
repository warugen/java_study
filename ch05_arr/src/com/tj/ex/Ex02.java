package com.tj.ex;

public class Ex02 {
	public static void main(String[] args) {
		int[] score = {10,20,30,40,50};
		int[] s = score;
		
		for (int i = 0; i < score.length; i++) {
			System.out.printf("score[%d] = %d\t s[%d] = %d\n", i, score[i], i, s[i]);
		}
		
		System.out.println("*********************************");
		
		score[0] = 100;
		
		for (int i = 0; i < score.length; i++) {
			System.out.printf("score[%d] = %d\t s[%d] = %d\n", i, score[i], i, s[i]);
		}
	}
}
