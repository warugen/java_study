package com.tj.ex04_acor;
// 	DMB송신불가, 3G, TV리모컨 미탑재
public class AModel implements IAcor {
	private String model = "A모델";
	
	@Override
	public void dmbReceive() {
		System.out.println(model+"은 DMB 송수신 불가");

	}

	@Override
	public void lte() {
		System.out.println(model+"은 3G 모델");

	}

	@Override
	public void tvremoteControl() {
		System.out.println(model+"은 TV리모컨 미탑재");

	}

}
