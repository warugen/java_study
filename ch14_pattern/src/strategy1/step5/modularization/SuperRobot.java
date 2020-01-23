package strategy1.step5.modularization;

import strategy1.step4.inter.*;

public class SuperRobot extends Robot {

	
	public SuperRobot() {
		setFly(new FlyYes());
		setMissile(new MissileYes());
		setKnife(new KnifeLasor());
//		fly = new FlyYes();
//		missile = new MissileYes();
//		knife = new KnifeLasor();
	}
	
}
