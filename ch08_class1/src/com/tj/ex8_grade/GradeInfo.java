package com.tj.ex8_grade;

public class GradeInfo {
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int total;
	private double avg;
	
	public GradeInfo() {}
	
	public GradeInfo(String name) {
		this.name = name;
	}
	
	public GradeInfo(String name, int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	
	public void print() {
		total = kor + eng + math;
		avg = total / 3.0;
		System.out.printf(name+"\t"+kor+"\t"+eng+"\t"+math+"\t"+total+"\t%.2f\n",avg);
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public void setMath(int math) {
		this.math = math;
	}
	
	
}
