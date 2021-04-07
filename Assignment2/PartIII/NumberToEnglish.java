import java.util.HashMap;
import java.util.Scanner;

public class NumberToEnglish {

	public static String numberToEnglish(int num) {
		
		int negative = 0;
		String ans = "";
		if (num<0) {
			negative = 1;
			num *= -1;
		}
		
		String[] under20 = {"", "One ", "Two ", "Three ", "Four ", "Five ", "Six ",
		                    "Seven ", "Eight ", "Nine ", "Ten ", "Eleven ", "Twelve ", "Thirteen ",
		                    "Fourteen ", "Fifteen ", "Sixteen ", "Seventeen ", "Eighteen ", "Nineteen "};

        String[] tens = {"","Ten ", "Twenty ", "Thirty ", "Forty ", "Fifty ", "Sixty ", "Seventy ", "Eighty ", "Ninety "};
        
        String[] large = {"Hundred ", "Thousand ", "Million "};
        
        if (num==0) { 
        	ans = "Zero";
        } else if (num<20) {
        	ans += under20[num];
        } else if (num<100) {
        	ans += tens[num/10];
        	ans += under20[num%10];
        }
        else if (num<1000) {
        	ans += under20[num/100] + large[0];
        	ans += tens[(num%100)/10];
        	ans += under20[num%10];
        }
        else if (num<10000) {
        	ans += under20[num/1000] + large[1];
        	num -= (num/1000)*1000;
        	ans += under20[num/100] + large[0];
        	ans += tens[(num%100)/10];
        	ans += under20[num%10];
        }
        else if (num<100000) {
        	ans += tens[num/10000];
        	num -= (num/10000)*10000;
        	ans += under20[num/1000] + large[1];
        	num -= (num/1000)*1000;
        	if (num>99 && num!=0) {
        		ans += under20[num/100] + large[0];
            	ans += tens[(num%100)/10];
            	ans += under20[num%10];
        	} else {
	        	ans += tens[(num%100)/10];
	        	ans += under20[num%10];
        	}
        }
        else if (num<1000000) {
        	ans += under20[num/100000] + large[0];
        	num -= (num/100000)*100000;
        	
        	ans += tens[num/10000];
        	num -= (num/10000)*10000;
        	ans += under20[num/1000] + large[1];
        	num -= (num/1000)*1000;
        	
        	if (num>99 && num!=0) {
        		ans += under20[num/100] + large[0];
            	ans += tens[(num%100)/10];
            	ans += under20[num%10];
        	} else {
	        	ans += tens[(num%100)/10];
	        	ans += under20[num%10];
        	}
        }
        else if (num<10000000) {
        	
        	ans += under20[num/1000000] + large[2];
        	num -= (num/1000000)*1000000;
        	
        	if (num<1000000 && num!=0) {
	        	ans += under20[num/100000] + large[0];
	        	num-= (num/100000)*100000;
	        	
	        	ans += tens[num/10000];
	        	num -= (num/10000)*10000;
	        	ans += under20[num/1000] + large[1];
	        	num -= (num/1000)*1000;
	        	
	        	if (num>99 && num!=0) {
	        		ans += under20[num/100] + large[0];
	            	ans += tens[(num%100)/10];
	            	ans += under20[num%10];
	        	} else {
		        	ans += tens[(num%100)/10];
		        	ans += under20[num%10];
	        	}
        	}       	
        }
        else if (num<100000000) {
        	
        	ans += tens[num/10000000];
        	num -= (num/10000000)*10000000;
        	
        	ans += under20[num/1000000] + large[2];
        	num -= (num/1000000)*1000000;
        	
        	if (num<1000000 && num!=0) {
	        	ans += under20[num/100000] + large[0];
	        	num -= (num/100000)*100000;
	        	
	        	ans += tens[num/10000];
	        	num -= (num/10000)*10000;
	        	ans += under20[num/1000] + large[1];
	        	num -= (num/1000)*1000;
	        	
	        	if (num>99 && num!=0) {
	        		ans += under20[num/100] + large[0];
	            	ans += tens[(num%100)/10];
	            	ans += under20[num%10];
	        	} else {
		        	ans += tens[(num%100)/10];
		        	ans += under20[num%10];
	        	}
        	}       	
        }
        else if (num<1000000000) {
        	
        	ans += under20[num/100000000] + large[0];
        	num -= (num/100000000)*100000000;
        	
        	ans += tens[num/10000000];
        	num -= (num/10000000)*10000000;
        	
        	ans += under20[num/1000000] + large[2];
        	num -= (num/1000000)*1000000;
        	
        	if (num<1000000 && num!=0) {
	        	ans += under20[num/100000] + large[0];
	        	num -= (num/100000)*100000;
	        	
	        	ans += tens[num/10000];
	        	num -= (num/10000)*10000;
	        	ans += under20[num/1000] + large[1];
	        	num -= (num/1000)*1000;
	        	
	        	if (num>99 && num!=0) {
	        		ans += under20[num/100] + large[0];
	            	ans += tens[(num%100)/10];
	            	ans += under20[num%10];
	        	} else {
		        	ans += tens[(num%100)/10];
		        	ans += under20[num%10];
	        	}
        	}
        	
        }
        else {
        	return "Invalid Number Input!";
        }
        
        if (negative==1) {
        	ans = "Negative " + ans;
        }
		return ans;
	}
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		System.out.print("Enter a number: " );
		int number = in.nextInt();
		
		System.out.println("The number " + number + " in English is " + numberToEnglish(number));
	
	}
}
