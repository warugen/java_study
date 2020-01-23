package com.tj.ex4_man;

public class ManMain {
	public static void main(String[] args) {
		Man kang = new Man(185, 75);
		Man kim = new Man();
		
		kim.setHeight(180);
		kim.setWeight(65);
			
		Man yi = new Man(180 , 65);
		
		if (kim.equals(yi)) {
			System.out.println("kim객체변수와 lee객체변수는 같다.");
		} else {
			System.out.println("kim객체변수와 lee객체변수는 다르다.");
		}
		
		yi = kim;
		
		if (kim.equals(yi)) {
			System.out.println("kim객체변수와 lee객체변수는 같다.");
		} else {
			System.out.println("kim객체변수와 lee객체변수는 다르다.");
		}
		
		double bmi = kang.calcBMI();
		if (bmi > 24) {
			System.out.println("비만입니다.");
		}else {
			System.out.println("건강합니다.");
		}
		
		bmi = kim.calcBMI();
		if (bmi > 24) {
			System.out.println("비만입니다.");
		}else {
			
			System.out.println(kim.getClass().getName() + "님 건강합니다.");
		}
	}
}
