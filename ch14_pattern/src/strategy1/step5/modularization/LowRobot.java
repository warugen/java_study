package strategy1.step5.modularization;

import strategy1.step4.inter.*;

public class LowRobot extends Robot {
	
	public LowRobot() {
		setFly(new FlyNo());
		setMissile(new MissileNo());
		setKnife(new KnifeNo());
	}
	
}
