
public class LargestPairProduct {

	public static void main(String[] args) {
		
		int[] intArray = {17, 1, 3, 12, 39, 4, 76, 4, 31, 87};
		int product = -1;
		int temp = 0;
		
		for (int i=0; i<intArray.length; i++) {
			temp = 0;
			for (int j=i+1; j<intArray.length; j++) {
				
				temp = intArray[i]*intArray[j];
				
				if (temp > product) {
					product = temp;
				} else {
					continue;
				}
				
			}
		}
		
		System.out.println("Maximum product of all pairs in the array: " +
							product);
	}
}
