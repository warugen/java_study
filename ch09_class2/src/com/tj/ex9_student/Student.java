package com.tj.ex9_student;
// Student.java(static이용한 번호 매김, infoString() 메소드추가)와
// StudentMain.java(객체배열을 이용한 확장 for문 이용
public class Student {
	public static int cnt = 1;
	private int no;
	private String name;
	private int kor;
	private int eng;
	private int math;
	
	private int total;
	private int avg;
	
	public Student() {}
	
	public Student(String name, int kor, int eng, int math) {
		this.no = cnt++;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		total = kor + eng + math;
		avg = total / 3;
	}
	
	public String infoString() {
		String result = ("\t"+no+"\t"+ name+"\t"+ kor+ "\t"+eng+ "\t"+math+"\t"+total+"\t"+avg);
		return result;
	}

	public int getKor() {
		return kor;
	}

	public int getEng() {
		return eng;
	}

	public int getMath() {
		return math;
	}

	public int getTotal() {
		return total;
	}

	public int getAvg() {
		return avg;
	}
	
}
