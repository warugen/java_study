package com.tj.ex1_student;

public class StudentMain {
	public static void main(String[] args) {
		
		Student s1 = new Student("정우성", 90, 90, 90);
		Student s2 = new Student("김하늘", 81, 90, 90);
		Student s3 = new Student("황정민", 91, 90, 90);
		Student s4 = new Student("강동원", 80, 90, 90);
		Student s5 = new Student("유아인", 70, 90, 90);
		
		Student[] student = {s1,s2,s3,s4,s5};
		
		String[] title = {"이름", "국어","영어","수학","총점","평균"};
		
		int[] tot = new int[5];
		double[] avg = new double[5];
				
		line();		// =====================
		System.out.println("\t\t\t성   적   표");
		line('-',50); // ---------------------
			
		
		for(String t: title) {
			System.out.print("\t"+t);
		}
		
		System.out.println();
		line('-',50);
		
		for(Student s : student){
			System.out.println(s.infoString());
			tot[0] += s.getKor();
			tot[1] += s.getEng();
			tot[2] += s.getMath();
			tot[3] += s.getTotal();
			tot[4] += s.getAvg();
		}
		
		for(int i=0; i<5; i++) {
			avg[i] = (double)tot[i] / student.length;
		}
		
		line('-',50);
		
		System.out.print("\t총점");
		
		for(int t : tot) {
//			System.out.print("\t"+t);
			System.out.printf("\t%4d",t);
		}
		
		System.out.print("\n\t평균");
		for (double a : avg) {
//			System.out.print("\t"+a);
			System.out.printf("\t%.1f",a);
		}
		System.out.println();
		line();
	}
	
	private static void line() {
		
		for(int i =0; i < 65; i++) {
			System.out.print("=");
		}
		System.out.println();
	}

	private static void line(char ch, int cnt) {
		System.out.print('\t');
		for(int i = 0; i < cnt; i++) {
			System.out.print(ch);
		}
		System.out.println();
	}
}
