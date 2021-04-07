package PartI.fruit;

public class Apple extends Fruit{
	
	private String taste;
	private String texture;
	
	public Apple() {
		
	}
	
	public Apple(String taste, String texture, String color, boolean rotten){
		super(color, rotten);
        this.taste=taste;
        this.texture=texture;
    }
	
	public String getTaste() {
		return this.taste;
	}
	
	public void setTaste(String taste){
		this.taste=taste;
	}
	
	public String getTexture() {
		return this.texture;
	}
	
	public void setTexture(String texture){
		this.texture=texture;
	}
	
	public String toString() {
		return super.toString() + " It also has a " + this.taste + " taste and a "
				+ this.texture + " texture.";
	}
	
	 public boolean equals(Apple apple) {
	        return this.getClass().equals(apple.getClass()) && this.getColor().equals(apple.getColor())
	                && this.isRotten() == apple.isRotten() && this.getTexture().equals(apple.getTexture())
	                && this.getTaste().equals(apple.getTaste());
	    }

	public static void main(String[] args) {
		Apple testapple1 = new Apple("sweet", "crisp", "red", false);
		//Apple testapple1 = new Apple("sweet", "crisp");
		//Apple testapple1 = new Apple();
		
		System.out.println(testapple1.toString());

	}
	
}
