package strategy1.step5.modularization;

import strategy1.step4.inter.*;

public class StandardRobot extends Robot {
	
	public StandardRobot() {
		setFly(new FlyNo());
		setMissile(new MissileYes());
		setKnife(new KnifeWood());
	}
}
