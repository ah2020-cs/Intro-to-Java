
public class LoopSum {

	public static int sum100() {
		
		int sum = 0;
		
		for (int i=1; i<=100; i++){
			sum+=i;
		}
	
		return sum;
	}
	
	public static int sumN(int N) {
		
		int sum = 0;
		
		for (int i=1; i<=N; i++){
			sum+=i;
		}
	
		return sum;
	}
	
	public static void main(String[] args) {
		
		System.out.println(sum100());
		System.out.println(sumN(100));
		
	}
	
}
