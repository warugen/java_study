package singletonclass1;

public class SingletonMain {
	public static void main(String[] args) {
		SingletonClass obj1 = SingletonClass.getInstance();
		obj1.setI(99);
		System.out.println(obj1.getI());
		SingletonClass obj2 = SingletonClass.getInstance();
		System.out.println(obj2.getI());
	}
}
