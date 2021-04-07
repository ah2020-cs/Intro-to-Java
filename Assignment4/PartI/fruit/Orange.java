package PartI.fruit;

public class Orange extends Citrus{

	private String type;
	
	public Orange() {
		
	}
	
	public Orange(String type, String taste, boolean rotten) {
		super(taste, "Orange", rotten);
		this.type = type;
	}
	
	public String getType() {
		return this.type;
	}
	
	public void setType(String type) {
		this.type=type;
	}
	
	public String toString() {
		return super.toString() + " It is of type " + this.type;
	}
	
	public boolean equals(Orange orange) {
        return this.getClass().equals(orange.getClass()) && this.getColor().equals(orange.getColor())
                && this.isRotten() == orange.isRotten() && this.getTaste().equals(orange.getTaste())
                && this.getType().equals(orange.getType());
    }
	
	
	
	public static void main(String[] args) {
		Orange testorange1 = new Orange("clementine", "sweet", false);
		Orange testorange2 = new Orange("mandarine", "sour", false);
		System.out.println(testorange1.toString());
		System.out.println(testorange1.equals(testorange2));
	}

}
