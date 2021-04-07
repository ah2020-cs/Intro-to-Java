import java.io.*;
import java.util.ArrayList;

import shapes.*;

/* your tasks:
 * create a class called ShapeException
 * createShape should throw a ShapeException
 * in main(), you should catch the ShapeException
 * 
 */
public class ReadShapeFile {

	public static GeometricObject createShape(String shapeName) throws ShapeException {
		
		/* if shapeName is "Circle" return Circle();
		 * if shapeName is "Square" return Square();
		 * if shapeName is "Rectangle" return Rectangle();
		 * if it is not any one of these, it should throw
		 * a ShapeException
		 */
		if (shapeName.equals("Circle")) {
			return new Circle();
		} else if (shapeName.equals("Square")) {
			return new Square();
		} else if (shapeName.equals("Rectangle")) {
			return new Rectangle();
		} else {
			throw new ShapeException("Invalid Shape");
		}
		
	}
	
	public static void main(String[] args) {
		ArrayList<GeometricObject> shapeList = new ArrayList<GeometricObject>();
		File f = new File("shapes.txt");
		
		ArrayList<String> strList = new ArrayList<String>();
		
		String inString = null;
		
		try (BufferedReader br = new BufferedReader(new FileReader(f))) {
		   String line;
		   while ((line = br.readLine()) != null) {
		      // System.out.println(line);
		       strList.add(line);
		   }  		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		/* create a loop to read the file line-by-line */
		for (String item : strList) {
			try {
				GeometricObject shape = createShape(item);
				shapeList.add(shape);
			} catch (ShapeException e) {
				e.printStackTrace();
				System.err.println("Cannot create shape: " + item);
			} 
		}
	
    	
    	
    	//System.out.println(strList);
		System.out.println(shapeList);
	}
}
