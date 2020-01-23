package singletonclass2;

public class MainClass {
	public static void main(String[] args) {
		FirstClass first = new FirstClass();
		SecondClass second = new SecondClass();
		SingletonClass single = SingletonClass.getInstance();
		System.out.println("main함수에서의 싱글톤 객체 i값 : "+single.getI());
	}
}
