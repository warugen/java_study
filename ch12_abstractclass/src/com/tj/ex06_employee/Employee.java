package com.tj.ex06_employee;

public abstract class Employee {
	
	private String name;
	private int monthFee;
	private int incentiveFee;
	
	public Employee(String name) {
		this.name = name;
	}
	
	public abstract int computePay();
	
	public final int computeIncentive() {
		// 월급이 200만원 넘으면 10% 상여금
		if (monthFee > 2000000) {
			incentiveFee = (int)(monthFee * 1.1);
		}
		return incentiveFee;
	}

	public String getName() {
		return name;
	}

	public int getMonthFee() {
		return monthFee;
	}

	public void setMonthFee(int monthFee) {
		this.monthFee = monthFee;
	}

	public int getIncentiveFee() {
		return incentiveFee;
	}

	public void setIncentiveFee(int incentiveFee) {
		this.incentiveFee = incentiveFee;
	}

	

}
