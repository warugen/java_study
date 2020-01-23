package com.tj.ex3_math;

import java.util.Random;

public class Ex03_random {
	public static void main(String[] args) {
		System.out.println((int)(Math.random()*45)+1);
		Random random = new Random();
		System.out.println("임의의 int 난수 : "+random.nextInt());
		System.out.println("임의의 double 난수 : "+random.nextDouble());	// Math.random()과 같다.
		System.out.println("True/False 난수 : "+random.nextBoolean());
		System.out.println("0부터 100까지 정수난수 : "+random.nextInt(101));
		System.out.println("1부터 45까지 정수난수 : "+(random.nextInt(45)+1));
		
		
	}
}
