package com.tj.student;
// 학생이름 검색시 필요한 DTO
public class StudentSelectDTO {
	private	String 	sNo;
	private String 	sName;
	private String 	mName;
	private int		score;
	
	public StudentSelectDTO() {}
	public StudentSelectDTO(String sNo, String sName, String mName, int score) {
		this.sNo = sNo;
		this.sName = sName;
		this.mName = mName;
		this.score = score;
	}

	@Override
	public String toString() {
		return sNo +"\t" + sName+"\t"+mName+"\t"+score;
	}

	public void setsNo(String sNo) {
		this.sNo = sNo;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public void setScore(int score) {
		this.score = score;
	}

}
