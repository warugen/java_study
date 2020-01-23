package com.tj.ex9_student;

public class StudentMain {
	public static void main(String[] args) {
		Student s1 = new Student("정우성", 90, 80, 95);
		Student s2 = new Student("김하늘", 100, 80, 95);
		Student s3 = new Student("황정민", 95, 80, 90);
		Student s4 = new Student("강동원", 95, 90, 99);
		Student s5 = new Student("유아인", 90, 90, 90);
		
		Student[] student = {s1,s2,s3,s4,s5};
		
		int[] tot = new int[5];
		int[] avg = new int[5];
		
		String[] title = {"번호","이름", "국어","영어","수학","총점","평균"};
		
		line('=');
		System.out.println("\t\t\t성\t적\t표");
		line('-');
		
		for(String t: title) {
			System.out.print("\t"+t);
		}
		System.out.println();
		
		for(Student s : student) {
			System.out.println(s.infoString());
			tot[0] += s.getKor();
			tot[1] += s.getEng();
			tot[2] += s.getMath();
			tot[3] += s.getTotal();
			tot[4] += s.getAvg();
		}
		
		for(int i=0; i<5; i++) {
			avg[i] = tot[i] / student.length;
		}
		
		line('-');
		
		System.out.print("\t\t총점");
		
		for(int t : tot) {
			System.out.print("\t"+t);
		}
		System.out.println();
		
		System.out.print("\t\t평균");
		
		for(int a : avg) {
			System.out.print("\t"+a);
		}
		
		System.out.println();
		line('=');
		
	}
	
	private static void line(char ch) {
		for(int i = 0; i< 69; i++) {
			System.out.print(ch);
		}
		System.out.println();
	}
}
