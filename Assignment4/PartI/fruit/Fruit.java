package PartI.fruit;

public class Fruit {
	
	private String color;
	private boolean rotten;
	
	private static int nextid = 0;
	private int id = ++nextid;
	
	public Fruit(){
		
	}
	
	public Fruit(String color, boolean rotten) {
		this.color = color;
		this.rotten = rotten;
	}
	
	public String getColor() {
		return this.color;
	}
	
	public void setColor(String color) {
		this.color=color;
	}
	
	public boolean isRotten() {
		return this.rotten;
	}
	
	public void setRotten(boolean rotten) {
		this.rotten=rotten;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String toString() {
		return "This is a " + this.getClass().getSimpleName() + " which is " + 
				this.color + " with id: " + this.id + " and it is" + 
				(this.rotten ? " rotten." : " fresh.");
	}
	
	public boolean equals(Fruit fruit) {
        return this.getClass().equals(fruit.getClass()) && this.getColor().equals(fruit.getColor()) 
        		&& this.isRotten() == fruit.isRotten();
    }
	
	public static void main(String[] args) {
		
	}

}


