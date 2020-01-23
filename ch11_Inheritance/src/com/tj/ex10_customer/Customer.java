package com.tj.ex10_customer;

import com.tj.cons.Constant;

public class Customer extends Person {
	private String add;
	private int sum;			// 누적금액
	private int point;			// 포인트(구매할때마다 5%씩 적립)
	private String date;		// 기념일
	private boolean vip;		// ture면 vip
	
	//Customer c = new Customer("홍","9999-9999","서울","0811")
	public Customer(String name, String tel, String add, String date) {	
		// 반드시 super단의 생성자 호출은 첫번째라인에 와야한다
		super(name, tel);
		System.out.println(name+"님 가입감사요. 가입기념 포인트 1000점을 드립니다.");
		this.add = add;
		this.date = date;
		sum = 0;
		point = 1000;
		vip = false;
	}
	
	public void buy(int price) {
		sum += price;
		int tmpPoint = (int) (price * Constant.RATE);
		point += tmpPoint;
		System.out.println(getName()+"님 적립 포인트 :" + tmpPoint + ", 총 포인트 :" +point);
		
		if (sum > Constant.VIPRATE || vip == false) {
			// 누적금액 100만원 초과시 vip등업
			vip = true;
		}
	}
	
	@Override
	public String infoString() {
		
		return super.infoString() + " [주소] " + add + " [포인트]" + point;
	}
	
}
