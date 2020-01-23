package com.tj.ex08_toys;

public class MazingaToy implements IMoveArmLeg, IMissile {
	public MazingaToy() {
		System.out.println("마징가 입니다.");
		canMoveArmLeg();
		canMissile();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}
	@Override
	public void canMissile() {
		System.out.println("미사일을 발사할 수 있다.");
	}

	@Override
	public void canMoveArmLeg() {
		System.out.println("팔다리를 움직일 수 있다.");
	}

}
