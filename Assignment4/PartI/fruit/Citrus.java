package PartI.fruit;

public class Citrus extends Fruit {
	
	private String taste;
	
	public Citrus(){	
		
	}
	
	public Citrus(String taste, String color, boolean rotten) {
		super(color,rotten);
		this.taste=taste;
	}
	
	public String getTaste() {
		return this.taste;
	}
	
	public void setTaste(String taste) {
		this.taste=taste;
	}
	
	public String toString() {
		return super.toString() + " It also has a " + this.taste + " taste.";
	}
	
	public boolean equals(Citrus citrus) {
        return this.getClass().equals(citrus.getClass()) && this.getColor().equals(citrus.getColor())
               && this.isRotten() == citrus.isRotten() && this.getTaste().equals(citrus.getTaste());
    }
	
	public static void main(String[] args) {
		Citrus testcitrus1 = new Citrus("sour", "pink", true);
		System.out.println(testcitrus1.toString());

	}
}
