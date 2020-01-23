package com.tj.ex08_toys;

public class PhooToy implements IMoveArmLeg {
	public PhooToy() {
		System.out.println("곰돌이 푸 입니다.");
		canMoveArmLeg();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}
	@Override
	public void canMoveArmLeg() {
		System.out.println("팔다리를 움직일 수 있다.");
	}

}
