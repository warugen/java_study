
public class Exargs {
	public static void main(String[] args) {
		System.out.println("args배열의 길이 : "+args.length);
		for(String tmp : args) {
			System.out.println("Hello, "+tmp);
		}
	}
}
