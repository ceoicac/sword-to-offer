package title53;

public class Test53 {
	public static void main(String[] args) {
		char [] str = {'a','a','a'};
		char [] pattern = {'a','b','*','a','c','*','a'};
		System.out.println(new Solution53().match(str, pattern));
	}
}
