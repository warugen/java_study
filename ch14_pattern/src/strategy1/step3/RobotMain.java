package strategy1.step3;

public class RobotMain {
	public static void main(String[] args) {
		
		Robot[] robots = {new SuperRobot(), new StandardRobot(), new LowRobot()};
		
		for (Robot r : robots) {
			System.out.println("--------------------------------------");
			r.shape();
			r.actionWalk();
			r.actionRun();
			
			//actionFlay()
			if (r instanceof SuperRobot) {
				 ((SuperRobot) r).actionFly();
				 ((SuperRobot) r).actionMissile();
				 ((SuperRobot) r).actionKnife();
			} else if (r instanceof StandardRobot) {
				((StandardRobot) r).actionFly();
				((StandardRobot) r).actionMissile();
				((StandardRobot) r).actionKnife();
			} else if (r instanceof LowRobot) {
				((LowRobot) r).actionFly();
				((LowRobot) r).actionMissile();
				((LowRobot) r).actionKnife();
			}
			
//			//actionMissile()
//			if (r instanceof SuperRobot) {
//				 ((SuperRobot) r).actionMissile();
//			} else if (r instanceof StandardRobot) {
//				((StandardRobot) r).actionMissile();
//			} else if (r instanceof LowRobot) {
//				((LowRobot) r).actionMissile();
//			}
//			
//			//actionKnife()
//			if (r instanceof SuperRobot) {
//				 ((SuperRobot) r).actionKnife();
//			} else if (r instanceof StandardRobot) {
//				((StandardRobot) r).actionKnife();
//			} else if (r instanceof LowRobot) {
//				((LowRobot) r).actionKnife();
//			}
			
		}
	}
}
