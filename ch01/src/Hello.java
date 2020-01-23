
public class Hello {
	public static void main(String args[]) {
		System.out.println("Hello, JAVA!!");
		int num =10;
		System.out.println((num%2 == 0)?"짝수":"홀수");
	}
	public static Hello INSTANCE = new Hello();
	public static Hello getInstance() {
		return INSTANCE;
	}
	
}
