package PartI.fruit;

public class Lemon extends Citrus{

	private int sourness;
	
	public Lemon() {
		
	}
	
	public Lemon(int sourness, String taste, boolean rotten) {
		super(taste, "Yellow", rotten);
		this.sourness=sourness;
	}
	
	public int getSourness() {
		return this.sourness;
	}
	
	public void setSourness(int sourness) {
		this.sourness=sourness;
	}
	
	public String toString() {
		return super.toString() + " It has a sourness of " + this.sourness;
	}
	
	public boolean equals(Lemon lemon) {
        return this.getClass().equals(lemon.getClass()) && this.getColor().equals(lemon.getColor())
                && this.isRotten() == lemon.isRotten() && this.getTaste().equals(lemon.getTaste())
                && this.getSourness() == lemon.getSourness();
    }
	
	
	public static void main(String[] args) {
		Lemon testlemon1 = new Lemon(15, "very sour", false);
		
		System.out.println(testlemon1.toString());
		

	}
	
}
