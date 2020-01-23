package strategy1.step4.modularization;

import strategy1.step4.inter.*;

public class SuperRobot extends Robot {

	private IFly fly;
	private Imissile missile;
	private IKnife knife;
	
	public SuperRobot() {
		setFly(new FlyYes());
		setMissile(new MissileYes());
		setKnife(new KnifeLasor());
//		fly = new FlyYes();
//		missile = new MissileYes();
//		knife = new KnifeLasor();
	}
	
	@Override
	public void actionFly() {
		fly.fly();
	}

	@Override
	public void actionMissile() {
		missile.missile();
	}

	@Override
	public void actionKnife() {
		knife.knife();
	}

	public void setFly(IFly fly) {
		this.fly = fly;
	}

	public void setMissile(Imissile missile) {
		this.missile = missile;
	}

	public void setKnife(IKnife knife) {
		this.knife = knife;
	}

}
