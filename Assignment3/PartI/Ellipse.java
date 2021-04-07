
public class Ellipse {
	
	private static int nextId;
    private int id = ++nextId;
    
	private double semiMajorAxis = 2.0;
	private double semiMinorAxis = 1.0;
	
	
	public Ellipse() {
    }
	
	public Ellipse(double a, double b) {
		this.semiMajorAxis = a;
		this.semiMinorAxis = b;
	}
	
	public double getSemiMajorAxis(){
		return this.semiMajorAxis;
	}
	public double getSemiMinorAxis(){
		return this.semiMinorAxis;
	}
	
	public double getArea() {
		return this.semiMajorAxis*this.semiMinorAxis*Math.PI;
	}
	
	public int getId() {
		return this.id;
	}
	
	public static void main(String[] args) {
		
		Ellipse ellipse = new Ellipse();
		System.out.println("Area: " + ellipse.getArea());
		System.out.println("Minoraxis: " + ellipse.getSemiMinorAxis());
		System.out.println("Majoraxis: " + ellipse.getSemiMajorAxis());
		System.out.println("ID is: " + ellipse.getId());
		
		System.out.println();
		
		Ellipse ellipse2 = new Ellipse(4,2);
		System.out.println("Area: " + ellipse2.getArea());
		System.out.println("Minoraxis: " + ellipse2.getSemiMinorAxis());
		System.out.println("Majoraxis: " + ellipse2.getSemiMajorAxis());
		System.out.println("ID is: " + ellipse2.getId());
		
		
	}
}
