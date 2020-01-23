package com.tj.ex10_customer;

public class Staff extends Person{

	private String hiredate;		// 2020-05-01
	private String department;		// 부서
	
	// Staff s = new Staff("이름","전화번호","입사일","부서")
	public Staff(String name, String tel, String hiredate, String department) {
		super(name, tel);
		this.hiredate = hiredate;
		this.department = department;
		
		
	}
	
	@Override
	public String infoString() {
		
		return super.infoString() + " [입사일] "+hiredate+" [부서] "+department;
	}
	

}
