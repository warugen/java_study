package com.tj.ex08_toys;

public class AirplaneToy implements IMissile, ILight {
	
	public AirplaneToy() {
		System.out.println("비행기 입니다.");
		canMissile();
		canLight();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}
	
	@Override
	public void canLight() {
		System.out.println("불빛반사 할 수 있다.");

	}

	@Override
	public void canMissile() {
		System.out.println("미사일을 발사할 수 있다.");
	}

}
