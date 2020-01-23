package singletonclass2;

public class AClass {
	private int intVar;
	private static AClass INSTANCE = new AClass();
	public static AClass getInstance () {
//		if(INSTANCE == null) {
//			INSTANCE = new AClass();
//		}
		
		return INSTANCE;
	}
}
