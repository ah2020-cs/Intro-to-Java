package vectors;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class MyVector {
	
	 private int len;
     private double[] vector;
	
	public MyVector(int n) {
		this.len = n;
        vector = new double[n];
	}
	
	public void save(String filename) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(new File(filename));

        for (int i=0; i<len; i++) {
        	pw.print(vector[i] + " ");
        }
	}
	
	public static MyVector read(String filename) throws FileNotFoundException {
         Scanner sc = new Scanner(new File(filename));
         
         try {
                 String input = sc.nextLine();
                 String[] input2 = input.split(" ");
                 MyVector vect1 = new MyVector(input2.length);
                 
                 for (int i = 0; i < vect1.vector.length; i++) {
                         vect1.vector[i] = Double.parseDouble(input2[i]);
                 }
                 return vect1;
                 
         } catch (InvalidFileFormat e) {
                 System.err.println(e.getMessage());
         }
         
         return null;
	}
	
	public MyVector sum(MyVector v) throws IncompatibleDimentions {
		
        if (vector.length != v.vector.length)
                throw new IncompatibleDimentions();

        MyVector vect1 = new MyVector(len);
        
        for (int i = 0; i < len; i++) {
                vect1.vector[i] = vector[i] + v.vector[i];
        }
        
        return vect1;
	}
	
	public MyVector mutiply(MyVector v) throws IncompatibleDimentions {
		
		//I wasn't too sure about this one since we had to return a vector 
		//but I believe that dot products are calculated like this.
		
        if (vector.length != v.vector.length)
                throw new IncompatibleDimentions();

        MyVector vect1 = new MyVector(1);
        for (int i = 0; i < len; i++)
                vect1.vector[0] += vector[i] * v.vector[i];

        return vect1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MyVector test = new MyVector(10);
		MyVector test2 = new MyVector(15);
		try {
			test.mutiply(test2);
		} catch (IncompatibleDimentions e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			test.sum(test2);
		} catch (IncompatibleDimentions e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		


	}

}
