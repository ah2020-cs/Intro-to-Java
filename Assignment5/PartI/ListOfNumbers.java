import java.io.*;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
 
public class ListOfNumbers {
	
    private List<Integer> list;
    private String inFile;
 
    public ListOfNumbers () {
        list = new ArrayList<Integer>();
    }
    
    public ListOfNumbers (String inFile) {
    	this();
    	this.inFile = inFile;	
    }
    
    public void readList() {
    	
    	File file = new File("numberfile.txt");

    	try (BufferedReader br = new BufferedReader(new FileReader(file))) {
    		   String line;
    		   while ((line = br.readLine()) != null) {
    		       System.out.println(line);
    		       this.list.add(Integer.valueOf(line));
    		       
    		   }
    	} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    	
    	/* For testing 
    	System.out.println();
    	for (int i = 0; i < list.size(); i++) {   
    	    System.out.print(list.get(i)+" ");
    	}*/
    	
    }
    
    public void writeList() {
        PrintWriter out = null;
        try {
            System.out.println("Entering try statement");
            out = new PrintWriter(new FileWriter("outFile.txt"));
            for (int i = 0; i < list.size(); i++)
                out.println("Value at: " + i + " = " + list.get(i));
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Caught IndexOutOfBoundsException: " +
                                 e.getMessage());
        } catch (IOException e) {
            System.err.println("Caught IOException: " + e.getMessage());
        } finally {
            if (out != null) {
                System.out.println("Closing PrintWriter");
                out.close();
            } else {
                System.out.println("PrintWriter not open");
            }
        }
    }
    
    public static void cat(String fileName) {
        RandomAccessFile input = null;
        String line = null;
        File file = new File(fileName);
        try {
            input = new RandomAccessFile(file, "r");
            while ((line = input.readLine()) != null) {
                System.out.println(line);
            }
            return;
        } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
            if (input != null) {
                try {
					input.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        }
    }
    
    public static void main(String[] args) {
    	ListOfNumbers listOfNumbers = new ListOfNumbers("numberfile.txt");
    	ListOfNumbers.cat("numberfile.txt");
    	listOfNumbers.readList();
    	listOfNumbers.writeList();
    	
    }

}
