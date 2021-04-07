package edu.nyu.cs9053.midterm.hierarchy;

public class Lecturer extends Faculty {
	
	public Lecturer() {
		
	}
	
	public Lecturer(String name, int age, boolean tenured, boolean adjunct) {
		super(name,age, tenured, adjunct);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Professor lect1 = new Professor("Aakash", 20, true, false);
		Professor lect2 = new Professor("Aakash", 20, false, true);
		System.out.println(lect1.getName()+" is "+lect1.getAge());
		//System.out.println(lect1.isTenured());
		//System.out.println(lect1.isAdjunct());
		
		System.out.println(Faculty.equals(lect1, lect2));

	}

}
