package strategy1.step4.modularization;

public class MainClass {
	public static void main(String[] args) {
		Robot[] robots = {new SuperRobot(), new StandardRobot(), new LowRobot()};
		
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
