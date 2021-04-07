package PartI.fruit;

public class Inheritance {
	

	

	public static void main(String[] args) {
		// Here's some scratch space to experiment/debug your Fruit objects
		
		Fruit testfruit1 = new Fruit("red", false);
		Fruit testfruit2 = new Fruit("green", true);
		
		System.out.println(testfruit2.equals(testfruit1));
		
		System.out.println(testfruit1.getColor());
		System.out.println(testfruit1.getId());
		System.out.println(testfruit1.toString());
		
		

	}

}
