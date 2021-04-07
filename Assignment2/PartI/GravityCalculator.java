
public class GravityCalculator {

	public static double calculatePosition(double time, double initialVelocity, double initialPosition) {
		
		double a = -9.81;
		double finalPosition = (0.5*a*Math.pow(time,2))+(initialVelocity*time)+initialPosition;
		
		return finalPosition;
	}
	
	public static void main(String[] args) {
		System.out.println("The final position is: " + calculatePosition(10,0,0) + "m");
		
	}
}
