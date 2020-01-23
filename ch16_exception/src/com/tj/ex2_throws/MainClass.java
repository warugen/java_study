package com.tj.ex2_throws;

public class MainClass {
	// JVM으로 던지면 JVM은 에러메세지 그냥 뿌린다.
	public static void main(String[] args) /* throws ArrayIndexOutOfBoundsException */{	
		try {
			new ThrowsEx();
		} catch (Exception e) {
			System.out.println("던진 예외 여기서 보험");
		}
	}
}
