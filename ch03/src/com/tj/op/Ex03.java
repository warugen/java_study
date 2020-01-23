package com.tj.op;

public class Ex03 {
	public static void main(String[] args) {
		int n1 = 33, n2 = 10;
		boolean result;
		result = (n1 == n2);
		
		System.out.printf("%d %s %d = %b\n", n1, "==", n2, result);
		
		result = (n1 != n2);
		System.out.printf("%d %s %d = %b\n", n1, "!=", n2, result);
		
		result = (n1 > n2);
		System.out.printf("%d %s %d = %b\n", n1, ">", n2, result);
		
		result = (n1 >= n2);
		System.out.printf("%d %s %d = %b\n", n1, ">=", n2, result);
		
		result = (n1 < n2);
		System.out.printf("%d %s %d = %b\n", n1, "<", n2, result);
		
		result = (n1 <= n2);
		System.out.printf("%d %s %d = %b\n", n1, "<=", n2, result);
	}

}
