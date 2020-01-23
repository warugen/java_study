package com.tj.ex06_employee;

public class SalaryEmployee extends Employee {
	
	private int annalSalary;
	
	public SalaryEmployee(String name, int annalSalary) {
		super(name);
		this.annalSalary = annalSalary;
	}

	@Override
	public int computePay() {
		// 연봉 나누기 14 = 월급
		setMonthFee(annalSalary / 14);
		return getMonthFee();
	}

}
