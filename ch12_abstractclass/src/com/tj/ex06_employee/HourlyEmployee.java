package com.tj.ex06_employee;

public class HourlyEmployee extends Employee {
	private int hoursWorked;
	private int moneyPerHour;
	
	public HourlyEmployee(String name, int hoursWorked, int moneyPerHour) {
		super(name);
		this.hoursWorked = hoursWorked;
		this.moneyPerHour = moneyPerHour;
	}
	
	@Override
	public int computePay() {
		// 일한시간 * 시급 = 월급
		setMonthFee(hoursWorked * moneyPerHour);
		return getMonthFee();
	}

}
