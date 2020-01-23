package com.tj.ex;

public class Ex03 {
	public static void main(String[] args) {
		int[] score = {10,20,30,40,50};
		int[] s = new int[score.length];
		
//		for (int i = 0; i < score.length; i++) {
//			s[i] = score[i];
//		}
		System.arraycopy(score, 0, s, 0, score.length);
		
		for (int i = 0; i < score.length; i++) {
			System.out.println("score[" + i+"] = " + score[i] + "\ts[" + i + "] = " + s[i]);
		}
		System.out.println("******************************");
		score[0] = 9999;
		for (int i = 0; i < score.length; i++) {
			System.out.println("score[" + i+"] = " + score[i] + "\ts[" + i + "] = " + s[i]);
		}
	}
}
