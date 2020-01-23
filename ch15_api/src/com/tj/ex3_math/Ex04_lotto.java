package com.tj.ex3_math;

import java.util.Random;

public class Ex04_lotto {
	public static void main(String[] args) {
		byte[] lotto = new byte[6];
		
		Random random = new Random();
		int j=0;
		for ( int i =0 ; i < lotto.length; i++) {
			byte tmp = (byte)(random.nextInt(45)+1);
			for ( j=0; j<i; j++) {
				if(lotto[j] == tmp) {
					i--;
//					break;
				}
			}
			
			if ( i==j) {
				lotto[i] = tmp;
			}
		}
		
		for(byte b : lotto) {
			System.out.println(b);
		}
	}
}
