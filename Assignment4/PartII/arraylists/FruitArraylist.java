package PartII.arraylists;
import java.util.ArrayList;


import PartI.fruit.*;

public class FruitArraylist {

	public static void main(String[] args) {
		
		
		Apple redApple1 = new Apple("sweet", "crisp", "red", false);
		Apple greenApple1 = new Apple("tart", "soft", "green", true);
		Apple greenApple2 = new Apple("tart", "soft", "green", true);
		
		Lemon yellowLemon1 = new Lemon((int) (Math.random() * 100), "sour", false);
		Lemon yellowLemon2 = new Lemon((int) (Math.random() * 100), "sour", false);
		Lemon yellowLemon3 = new Lemon((int) (Math.random() * 100), "sour", false);
		
		Orange mandarin1 = new Orange("mandarin", "sweet", true);
		Orange mandarin2 = new Orange("mandarin", "sweet", true);
		
		
		// this ArrayList MUST be parameterized
		//ArrayList fruitArrayList;
		
		ArrayList<Fruit> fruitArrayList = new ArrayList<Fruit>();
		fruitArrayList.add(redApple1);
		fruitArrayList.add(greenApple1);
		fruitArrayList.add(greenApple2);
		fruitArrayList.add(yellowLemon1);
		fruitArrayList.add(yellowLemon2);
		fruitArrayList.add(yellowLemon3);
		fruitArrayList.add(mandarin1);
		fruitArrayList.add(mandarin2);
		

		
		int sum = 0;
		int count = 0;
		double avg = 0.0;
		
		for(int i = 0; i < fruitArrayList.size(); i++) {
			if(fruitArrayList.get(i) instanceof Lemon) {
				Lemon lemon_obj = (Lemon) fruitArrayList.get(i); //cast as lemon object
				sum += lemon_obj.getSourness();
				count++;
			}
		}
		//print the avg
		avg = sum/count;
		System.out.println(avg);
		
		
		
		// this is the variable you should retain to compare
		// to the other objects in the arraylist
		Apple rottenGreenApple1 = greenApple1;
		
		//prints out the id of apples that are "==" or "equal"
		for (int i = 0; i < fruitArrayList.size(); i++) {
			Fruit thisfruit = fruitArrayList.get(i);
			if (thisfruit instanceof Apple && thisfruit.equals(rottenGreenApple1)) {
				System.out.println("The rottenGreenApple1 object is equal to object with id: " + thisfruit.getId());
		
				if (thisfruit == rottenGreenApple1) {
					System.out.println("The rottenGreenApple1 object is the same as object with id: " + thisfruit.getId());
				}
			}
		}
		
		//removing Apple objects
		for(int i = 0; i < fruitArrayList.size(); i++) {
			if ((fruitArrayList.get(i) instanceof Apple) && (fruitArrayList.get(i).equals(rottenGreenApple1))){
				fruitArrayList.remove(i);
			}	
		}
		
		System.out.println();
		System.out.println("The final list is:");
		//printing arraylist
		for(int i = 0; i < fruitArrayList.size(); i++) {
			System.out.println(fruitArrayList.get(i));
		}
		
		
		
		
	}
}
