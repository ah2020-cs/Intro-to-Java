package PartIII;
import java.util.ArrayList;
import java.util.Collection;

public class ResultPrinter {

	MathOperation op;
	
	public ResultPrinter(MathOperation op) {
		this.op = op;
	}
	
	public void go(double a, double b) {
		// System.out.println("result is " + ???);
		System.out.println("result: " + this.op.operation(a, b));
	}

	public static void go(double a, double b, MathOperation op) {
		// System.out.println("result is " + ???);
		System.out.println("result: " + op.operation(a, b));
	}
	
	public static void go(Collection<Pair<Double,Double>> c, MathOperation op) {
		
		/* Some Loop  {
		 
		  	System.out.println("result is " + ???);
		  }
		*/
		
		for (Pair<Double, Double> pair : c) {
            System.out.println("result: " + op.operation(pair.key, pair.value));
		} 
	}
	
	public static void main(String[] args) {
		// ResultPrinter rp = new ResultPrinter( ???? );
		MathOperation add = (a1, b1) -> a1 + b1;
        ResultPrinter rp = new ResultPrinter(add);
		rp.go(3.0, 4.0);
		
		MathOperation subtract = (a1, b1) -> a1 - b1;
        ResultPrinter rp2 = new ResultPrinter(subtract);
		rp2.go(4.0, 3.0);
		
		// ResultPrinter.go(4.0, 2.0, ????);
		MathOperation multiply = (a1, b1) -> a1 * b1;
        ResultPrinter.go(4.0, 2.0, multiply);
		

        MathOperation divide = (a1, b1) -> a1 / b1;
        
		ArrayList<Pair<Double,Double>> al = new ArrayList<Pair<Double,Double>>();
		Pair<Double, Double> p = new Pair<Double, Double>(3.0, 4.0);
		al.add(p);
		p = new Pair<Double, Double>(5.0, 6.0);
		al.add(p);
		p = new Pair<Double, Double>(7.0, 8.0);
		al.add(p);
		
		System.out.println("\n" +al.toString());
		ResultPrinter.go(al, divide);
		
	}
}
