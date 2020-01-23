package strategy1.step3;

public class Robot {
	public void actionWalk() {
		System.out.println("걸을 수 있습니다.");
	}
	
	public void actionRun() {
		System.out.println("뛸 수 있습니다.");
	}
	
	public void shape() {
		System.out.println(getClass().getName()+"입니다. 외형은 팔 다리 몸통 머리가 있습니다.");
	}
}
