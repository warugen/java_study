package singletonclass1;

public class SingletonClass {
	private int i;
	
	private static SingletonClass INSTANCE;
	// 객체 생성이 안되어있으면 객체를 생성하고
	// 생성된것이 있으면 객체의 주소를 리턴한다.
	public static SingletonClass getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new SingletonClass();
		}
		
		return INSTANCE;
	}
	
	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}
	
}
