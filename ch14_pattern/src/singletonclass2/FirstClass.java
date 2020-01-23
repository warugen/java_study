package singletonclass2;

public class FirstClass {
	public FirstClass() {
		SingletonClass singletonObject = SingletonClass.getInstance();
		System.out.println("승글톤객체의 i값 : " + singletonObject.getI());
		
		singletonObject.setI(200);
		System.out.println("승글톤객체 수정후 i값 : " + singletonObject.getI());
	}
}
