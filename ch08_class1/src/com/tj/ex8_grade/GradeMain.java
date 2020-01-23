package com.tj.ex8_grade;

public class GradeMain {
	public static void main(String[] args) {
		GradeInfo p1 = new GradeInfo();
		GradeInfo p2 = new GradeInfo("김하늘", 80, 80, 80);
		GradeInfo p3 = new GradeInfo("황정민", 70, 70, 70);
		GradeInfo p4 = new GradeInfo("강동원");
		
		
		p1.setName("정우성");
		p1.setKor(90);
		p1.setEng(90);
		p1.setMath(90);
		
		p4.setKor(70);
		p4.setEng(70);
		p4.setMath(70);
		
		table();
		p1.print();
		p2.print();
		p3.print();
		p4.print();
	}
	
	
	public static void table() {
		System.out.println("=================================================");
		System.out.println("성\t적\t표");
		System.out.println("-------------------------------------------------");
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
		System.out.println("-------------------------------------------------");
	}
}
