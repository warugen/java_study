package strategy1.step1;

public class RobotMain {
	public static void main(String[] args) {
		SuperRobot superR = new SuperRobot();
		StandardRobot stanR = new StandardRobot();
		LowRobot lowR = new LowRobot();
		System.out.println("--------------------------------------");
		superR.shape();
		superR.actionWalk();
		superR.actionRun();
		superR.actionFly();
		superR.actionMissile();
		superR.actionKnife();
		System.out.println("--------------------------------------");
		stanR.shape();
		stanR.actionWalk();
		stanR.actionRun();
		stanR.actionFly();
		stanR.actionMissile();
		stanR.actionKnife();
		System.out.println("--------------------------------------");
		lowR.shape();
		lowR.actionWalk();
		lowR.actionRun();
		lowR.actionFly();
		lowR.actionMissile();
		lowR.actionKnife();
	}
}
