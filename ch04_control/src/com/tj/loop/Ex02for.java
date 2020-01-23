package com.tj.loop;

public class Ex02for {
	public static void main(String[] args) {
		int total = 0;
		for (int i = 1; i <= 20; i++) {
			System.out.print(i);
			
			if (i != 20) {
				System.out.print(" + ");

			}
			total = total + i;
		}
		
		System.out.println(" = " + total);
	}
}
