
public class DisplayInRows {

	static final int ROW_LENGTH = 10;
	
	public static void main(String[] args) {
		
		int[] intArray = new int[100];
		
		for (int i=0;i< intArray.length;i++) {
			intArray[i] = (int)(Math.random()*100);
		}
		
		for (int i=0; i<intArray.length; i++) {
			
			if (i==0) {
				System.out.print(intArray[i]+ " ");
				i++;
			}else if (i%10!=0) {
				System.out.print(intArray[i]+ " ");
			}else if (i%10==0) {
				System.out.print(intArray[i]);
				System.out.println();
			}

		}
	}
}
