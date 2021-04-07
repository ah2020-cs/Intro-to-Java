package PartI;
import java.math.BigDecimal;
import java.util.*;

public class MaxFinder<T> {
	
	private List<T> values;

    public MaxFinder() {
        values = new ArrayList<>();
    }

    public void add(T t) {
        values.add(t);
    }

    public void add(ArrayList<T> al) {
        values.addAll(al);
    }
	
    public T max() {
        if (values.size() == 0) {
            return null;
        }
        T max = values.get(0);
        for (T number : values) {
   
        	BigDecimal x = new BigDecimal(max.toString());
        	BigDecimal y = new BigDecimal(number.toString());
        	
            if(y.compareTo(x)>0); {
                max = number;
            }
        }
        return max;
    }
   
    
    public static void main(String[] args) {
        MaxFinder<Number> test = new MaxFinder<Number>();
        
        test.add(5);
        test.add(7.5);
        
        ArrayList<Number> arList = new ArrayList<Number>();
        arList.add((double) 1);
        arList.add(10.1);
        arList.add(99.0);
        
        test.add(arList);
        
       
        Number max = test.max();
        System.out.println("max is: " + max);
   
}

	

}
