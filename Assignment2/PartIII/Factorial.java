
public class Factorial {

	public static void main(String[] args) {
		int val = 5;
		int product = 1;
		
		for (int i=1; i<=val; i++) {
			product*=i;
		}
		
		System.out.println(product);
	}
}
