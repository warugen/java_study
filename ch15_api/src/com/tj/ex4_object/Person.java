package com.tj.ex4_object;

public class Person {
	private long juminNo;	//9001111022345

	public Person(long juminNo) {
		this.juminNo = juminNo;
	}
	
	@Override
	public String toString() {
		return "주민번호 : "+juminNo;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if (obj != null && obj instanceof Person) {
			return (this.juminNo == ((Person)obj).juminNo);
		} else {
			return false;
		}
	}

	public long getJuminNo() {
		return juminNo;
	}

	public void setJuminNo(long juminNo) {
		this.juminNo = juminNo;
	}
	
	
}
