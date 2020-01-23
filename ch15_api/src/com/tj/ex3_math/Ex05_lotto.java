package com.tj.ex3_math;

import java.util.Random;

public class Ex05_lotto {
	public static void main(String[] args) {
		byte[] lotto = new byte[6];
		Random random = new Random();
		random.nextBytes(lotto);	// byte배열 모든방에 난수(-128~127)
		for(int i=0; i<lotto.length; i++) {
			int tmp = Math.abs(lotto[i]);
			lotto[i] = (byte)(tmp%45+1);
		}
		
		for(byte l : lotto) {
			System.out.println(l);
		}
	}
}
