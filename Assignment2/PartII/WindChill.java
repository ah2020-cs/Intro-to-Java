import java.util.Scanner;

public class WindChill {

	public static double windChill(double t, double v) {
		
		double w = 35.74+(0.6215*t)+(((0.4275*t)-35.75)*Math.pow(v, 0.16));
		return w;
	}
	
	public static void main(String[] args) {
		
		
		System.out.print("Enter your temp: ");
		Scanner in = new Scanner(System.in);
		double temp = in.nextDouble();
		
		System.out.print("Enter your windspeed: ");
		Scanner in2 = new Scanner(System.in);
		double windSpeed = in2.nextDouble();
		
		double windChillTemp = windChill(temp,windSpeed);
		
		// if the wind chill is valid:
		
		if (temp>=-50 && temp<=50 &&	
				windSpeed>=3 && windSpeed<=110) {
		System.out.println("For a temperature of " + temp + 
							" with wind speed of " + windSpeed + 
							", the wind chill is " + windChillTemp);
		}
		else {
		// if the wind chill is not valid:
		System.out.println("Cannot calculate a valid wind chill for this temperate and/or wind speed");
		}
		in.close();
		in2.close();
	}
}
