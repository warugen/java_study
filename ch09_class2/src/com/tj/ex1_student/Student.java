package com.tj.ex1_student;

public class Student {
	private String name;
	private int kor;
	private int eng;
	private int math;
	
	private int total;
	private double avg;
	
	public Student() {}
	
	public Student(String name, int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		total = kor + eng + math;
		avg = total / 3.0;
	}
	
	public void print() {
		System.out.printf("\t %s \t %d \t %d \t %d \t %d \t %.1f\n",name, kor,eng,math,total,avg);
	}
	
	public String infoString() {
		String result = String.format("\t %s %d \t %d \t %d \t %d \t %.1f",
									     name, kor, eng, math ,total, avg);
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
	
	public double getAvg() {
		return avg;
	}
}
