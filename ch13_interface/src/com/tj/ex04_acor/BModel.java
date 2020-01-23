package com.tj.ex04_acor;
//	DMB송신가능, LTE, TV리모컨 탑재
public class BModel implements IAcor {
	private String model = "B모델";
	@Override
	public void dmbReceive() {
		System.out.println(model+"은 DMB 송수신 가능");
		
	}

	@Override
	public void lte() {
		System.out.println(model+"은 LTE 모델");

	}

	@Override
	public void tvremoteControl() {
		System.out.println(model+"은 TV리모컨 탑재");

	}

}
