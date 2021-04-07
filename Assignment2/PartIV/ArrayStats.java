import java.util.Arrays;

public class ArrayStats {

	public static void main(String[] args) {
		int[] intArray = new int[50];
		
		int smallestValue;
		int largestValue;
		double meanAverage;
		
		/* initialize the source Array */
		for (int i = 0;i < intArray.length; i++) {
			intArray[i] = (int)(Math.random()*100);
		}
		
		smallestValue = intArray[0];
		for (int i=0; i<intArray.length; i++) {
			
			if (intArray[i]<smallestValue) {
				smallestValue = intArray[i];
			}
			
		}
		
		largestValue = intArray[0];
		for (int i=0; i<intArray.length; i++) {
			
			if (intArray[i]>largestValue) {
				largestValue = intArray[i];
			}
			
		}
		
		double sum = 0;
		for (int i=0; i<intArray.length; i++) {
			sum+=intArray[i];
		}
		meanAverage = sum/(intArray.length);
		
		//System.out.println(Arrays.toString(intArray));
		
		System.out.println("Smallest value in the array is " + 
							smallestValue);
		System.out.println("Largest value in the array is " + 
							largestValue);
		System.out.println("Mean average value of array elements is " + 
							meanAverage);
	}
}
