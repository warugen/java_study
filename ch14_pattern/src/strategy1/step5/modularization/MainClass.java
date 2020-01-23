package strategy1.step5.modularization;

import strategy1.step4.inter.FlyHi;

public class MainClass {
	public static void main(String[] args) {
		Robot[] robots = {new SuperRobot(), new StandardRobot(), new LowRobot()};
		
		System.out.println("요구사항 변경 전");
		
		for(Robot r : robots) {
			System.out.println("-------------------------");
			r.shape();
			r.actionWalk();
			r.actionRun();
			r.actionFly();
			r.actionMissile();
			r.actionKnife();
		}
		
		System.out.println("요구사항 변경 후");
		robots[0].setFly(new FlyHi());
		for(Robot r : robots) {
			System.out.println("-------------------------");
			r.shape();
			r.actionWalk();
			r.actionRun();
			r.actionFly();
			r.actionMissile();
			r.actionKnife();
		}
	}
}
