package com.tj.op;

public class Ex04 {
	public static void main(String[] args) {
		int i=1, j = 10, h = 10;
		System.out.println("&&(AND) (i>j) && (++j>h) = " + ((i>j) && (++j>h)));
		System.out.println("j =" + j);
		
		System.out.println("||(OR) (i>j) && (++j>h) = " + ((i>j) || (++j>h)));
		System.out.println("j =" + j);
	}

}
